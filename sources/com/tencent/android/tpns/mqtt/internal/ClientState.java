package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingResp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRel;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class ClientState {
    private static final String CLASS_NAME = "ClientState";
    private static final int MAX_MSG_ID = 65535;
    private static final int MIN_MSG_ID = 1;
    private static final String PERSISTENCE_CONFIRMED_PREFIX = "sc-";
    private static final String PERSISTENCE_RECEIVED_PREFIX = "r-";
    private static final String PERSISTENCE_SENT_BUFFERED_PREFIX = "sb-";
    private static final String PERSISTENCE_SENT_PREFIX = "s-";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientState");
    private int actualInFlight = 0;
    private CommsCallback callback = null;
    private boolean cleanSession;
    private ClientComms clientComms = null;
    private boolean connected = false;
    private int inFlightPubRels = 0;
    private Hashtable inUseMsgIds;
    private Hashtable inboundQoS2 = null;
    private long keepAlive;
    private long lastInboundActivity = 0;
    private long lastOutboundActivity = 0;
    private long lastPing = 0;
    private int maxInflight = 0;
    private int nextMsgId = 0;
    private Hashtable outboundQoS0 = null;
    private Hashtable outboundQoS1 = null;
    private Hashtable outboundQoS2 = null;
    private volatile Vector pendingFlows;
    private volatile Vector pendingMessages;
    private MqttClientPersistence persistence;
    private MqttWireMessage pingCommand;
    private int pingOutstanding = 0;
    private Object pingOutstandingLock = new Object();
    private MqttPingSender pingSender = null;
    private Object queueLock = new Object();
    private Object quiesceLock = new Object();
    private boolean quiescing = false;
    private CommsTokenStore tokenStore;

    protected ClientState(MqttClientPersistence mqttClientPersistence, CommsTokenStore commsTokenStore, CommsCallback commsCallback, ClientComms clientComms2, MqttPingSender mqttPingSender) throws MqttException {
        Logger logger = log;
        logger.setResourceName(clientComms2.getClient().getClientId());
        logger.finer("ClientState", "<Init>", "");
        this.inUseMsgIds = new Hashtable();
        this.pendingFlows = new Vector();
        this.outboundQoS2 = new Hashtable();
        this.outboundQoS1 = new Hashtable();
        this.outboundQoS0 = new Hashtable();
        this.inboundQoS2 = new Hashtable();
        this.pingCommand = new MqttPingReq();
        this.inFlightPubRels = 0;
        this.actualInFlight = 0;
        this.persistence = mqttClientPersistence;
        this.callback = commsCallback;
        this.tokenStore = commsTokenStore;
        this.clientComms = clientComms2;
        this.pingSender = mqttPingSender;
        restoreState();
    }

    protected void setMaxInflight(int i) {
        this.maxInflight = i;
        this.pendingMessages = new Vector(this.maxInflight);
    }

    protected void setKeepAliveSecs(long j) {
        this.keepAlive = j * 1000;
    }

    protected long getKeepAlive() {
        return this.keepAlive;
    }

    protected void setCleanSession(boolean z) {
        this.cleanSession = z;
    }

    protected boolean getCleanSession() {
        return this.cleanSession;
    }

    private String getSendPersistenceKey(MqttWireMessage mqttWireMessage) {
        return "s-" + mqttWireMessage.getMessageId();
    }

    private String getSendConfirmPersistenceKey(MqttWireMessage mqttWireMessage) {
        return "sc-" + mqttWireMessage.getMessageId();
    }

    private String getReceivedPersistenceKey(MqttWireMessage mqttWireMessage) {
        return "r-" + mqttWireMessage.getMessageId();
    }

    private String getReceivedPersistenceKey(int i) {
        return "r-" + i;
    }

    private String getSendBufferedPersistenceKey(MqttWireMessage mqttWireMessage) {
        return "sb-" + mqttWireMessage.getMessageId();
    }

    protected void clearState() throws MqttException {
        log.fine("ClientState", "clearState", ">");
        this.persistence.clear();
        this.inUseMsgIds.clear();
        this.pendingMessages.clear();
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.outboundQoS0.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
    }

    private MqttWireMessage restoreMessage(String str, MqttPersistable mqttPersistable) throws MqttException {
        MqttWireMessage mqttWireMessage;
        try {
            mqttWireMessage = MqttWireMessage.createWireMessage(mqttPersistable);
        } catch (Throwable th) {
            TBaseLogger.e("ClientState", "restoreMessage", th);
            if (th.getCause() instanceof EOFException) {
                if (str != null) {
                    this.persistence.remove(str);
                }
                mqttWireMessage = null;
            } else {
                throw th;
            }
        }
        log.fine("ClientState", "restoreMessage", "601", new Object[]{str, mqttWireMessage});
        return mqttWireMessage;
    }

    private void insertInOrder(Vector vector, MqttWireMessage mqttWireMessage) {
        int messageId = mqttWireMessage.getMessageId();
        for (int i = 0; i < vector.size(); i++) {
            if (((MqttWireMessage) vector.elementAt(i)).getMessageId() > messageId) {
                vector.insertElementAt(mqttWireMessage, i);
                return;
            }
        }
        vector.addElement(mqttWireMessage);
    }

    private Vector reOrder(Vector vector) {
        Vector vector2 = new Vector();
        if (vector.size() == 0) {
            return vector2;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < vector.size()) {
            int messageId = ((MqttWireMessage) vector.elementAt(i)).getMessageId();
            int i5 = messageId - i2;
            if (i5 > i3) {
                i4 = i;
                i3 = i5;
            }
            i++;
            i2 = messageId;
        }
        if ((65535 - i2) + ((MqttWireMessage) vector.elementAt(0)).getMessageId() > i3) {
            i4 = 0;
        }
        for (int i6 = i4; i6 < vector.size(); i6++) {
            vector2.addElement(vector.elementAt(i6));
        }
        for (int i7 = 0; i7 < i4; i7++) {
            vector2.addElement(vector.elementAt(i7));
        }
        return vector2;
    }

    protected void restoreState() throws MqttException {
        Enumeration keys = this.persistence.keys();
        int i = this.nextMsgId;
        Vector vector = new Vector();
        log.fine("ClientState", "restoreState", "600");
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            MqttWireMessage restoreMessage = restoreMessage(str, this.persistence.get(str));
            if (restoreMessage != null) {
                if (str.startsWith("r-")) {
                    log.fine("ClientState", "restoreState", "604", new Object[]{str, restoreMessage});
                    this.inboundQoS2.put(new Integer(restoreMessage.getMessageId()), restoreMessage);
                } else if (str.startsWith("s-")) {
                    MqttPublish mqttPublish = (MqttPublish) restoreMessage;
                    i = Math.max(mqttPublish.getMessageId(), i);
                    if (this.persistence.containsKey(getSendConfirmPersistenceKey(mqttPublish))) {
                        MqttPubRel mqttPubRel = (MqttPubRel) restoreMessage(str, this.persistence.get(getSendConfirmPersistenceKey(mqttPublish)));
                        if (mqttPubRel != null) {
                            log.fine("ClientState", "restoreState", "605", new Object[]{str, restoreMessage});
                            this.outboundQoS2.put(new Integer(mqttPubRel.getMessageId()), mqttPubRel);
                        } else {
                            log.fine("ClientState", "restoreState", "606", new Object[]{str, restoreMessage});
                        }
                    } else {
                        mqttPublish.setDuplicate(true);
                        if (mqttPublish.getMessage().getQos() == 2) {
                            log.fine("ClientState", "restoreState", "607", new Object[]{str, restoreMessage});
                            this.outboundQoS2.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                        } else {
                            log.fine("ClientState", "restoreState", "608", new Object[]{str, restoreMessage});
                            this.outboundQoS1.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                        }
                    }
                    this.tokenStore.restoreToken(mqttPublish).internalTok.setClient(this.clientComms.getClient());
                    this.inUseMsgIds.put(new Integer(mqttPublish.getMessageId()), new Integer(mqttPublish.getMessageId()));
                } else if (str.startsWith("sb-")) {
                    MqttPublish mqttPublish2 = (MqttPublish) restoreMessage;
                    i = Math.max(mqttPublish2.getMessageId(), i);
                    if (mqttPublish2.getMessage().getQos() == 2) {
                        log.fine("ClientState", "restoreState", "607", new Object[]{str, restoreMessage});
                        this.outboundQoS2.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                    } else if (mqttPublish2.getMessage().getQos() == 1) {
                        log.fine("ClientState", "restoreState", "608", new Object[]{str, restoreMessage});
                        this.outboundQoS1.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                    } else {
                        log.fine("ClientState", "restoreState", "511", new Object[]{str, restoreMessage});
                        this.outboundQoS0.put(new Integer(mqttPublish2.getMessageId()), mqttPublish2);
                        this.persistence.remove(str);
                    }
                    this.tokenStore.restoreToken(mqttPublish2).internalTok.setClient(this.clientComms.getClient());
                    this.inUseMsgIds.put(new Integer(mqttPublish2.getMessageId()), new Integer(mqttPublish2.getMessageId()));
                } else if (str.startsWith("sc-") && !this.persistence.containsKey(getSendPersistenceKey((MqttPubRel) restoreMessage))) {
                    vector.addElement(str);
                }
            }
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str2 = (String) elements.nextElement();
            log.fine("ClientState", "restoreState", "609", new Object[]{str2});
            this.persistence.remove(str2);
        }
        this.nextMsgId = i;
    }

    private void restoreInflightMessages() {
        this.pendingMessages = new Vector(this.maxInflight);
        this.pendingFlows = new Vector();
        Enumeration keys = this.outboundQoS2.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            MqttWireMessage mqttWireMessage = (MqttWireMessage) this.outboundQoS2.get(nextElement);
            if (mqttWireMessage instanceof MqttPublish) {
                log.fine("ClientState", "restoreInflightMessages", "610", new Object[]{nextElement});
                mqttWireMessage.setDuplicate(true);
                insertInOrder(this.pendingMessages, (MqttPublish) mqttWireMessage);
            } else if (mqttWireMessage instanceof MqttPubRel) {
                log.fine("ClientState", "restoreInflightMessages", "611", new Object[]{nextElement});
                insertInOrder(this.pendingFlows, (MqttPubRel) mqttWireMessage);
            }
        }
        Enumeration keys2 = this.outboundQoS1.keys();
        while (keys2.hasMoreElements()) {
            Object nextElement2 = keys2.nextElement();
            MqttPublish mqttPublish = (MqttPublish) this.outboundQoS1.get(nextElement2);
            mqttPublish.setDuplicate(true);
            log.fine("ClientState", "restoreInflightMessages", "612", new Object[]{nextElement2});
            insertInOrder(this.pendingMessages, mqttPublish);
        }
        Enumeration keys3 = this.outboundQoS0.keys();
        while (keys3.hasMoreElements()) {
            Object nextElement3 = keys3.nextElement();
            log.fine("ClientState", "restoreInflightMessages", "512", new Object[]{nextElement3});
            insertInOrder(this.pendingMessages, (MqttPublish) this.outboundQoS0.get(nextElement3));
        }
        this.pendingFlows = reOrder(this.pendingFlows);
        this.pendingMessages = reOrder(this.pendingMessages);
    }

    public void send(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (mqttWireMessage.isMessageIdRequired() && mqttWireMessage.getMessageId() == 0) {
            if ((mqttWireMessage instanceof MqttPublish) && ((MqttPublish) mqttWireMessage).getMessage().getQos() != 0) {
                mqttWireMessage.setMessageId(getNextMessageId());
            } else if ((mqttWireMessage instanceof MqttPubAck) || (mqttWireMessage instanceof MqttPubRec) || (mqttWireMessage instanceof MqttPubRel) || (mqttWireMessage instanceof MqttPubComp) || (mqttWireMessage instanceof MqttSubscribe) || (mqttWireMessage instanceof MqttSuback) || (mqttWireMessage instanceof MqttUnsubscribe) || (mqttWireMessage instanceof MqttUnsubAck)) {
                mqttWireMessage.setMessageId(getNextMessageId());
            }
        }
        if (mqttToken != null) {
            try {
                mqttToken.internalTok.setMessageID(mqttWireMessage.getMessageId());
            } catch (Throwable unused) {
                throw new MqttException(32201);
            }
        }
        if (mqttWireMessage instanceof MqttPublish) {
            synchronized (this.queueLock) {
                if (this.actualInFlight < this.maxInflight) {
                    MqttMessage message = ((MqttPublish) mqttWireMessage).getMessage();
                    log.fine("ClientState", "send", "628", new Object[]{new Integer(mqttWireMessage.getMessageId()), new Integer(message.getQos()), mqttWireMessage});
                    int qos = message.getQos();
                    if (qos == 1) {
                        this.outboundQoS1.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
                        this.persistence.put(getSendPersistenceKey(mqttWireMessage), (MqttPublish) mqttWireMessage);
                    } else if (qos == 2) {
                        this.outboundQoS2.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
                        this.persistence.put(getSendPersistenceKey(mqttWireMessage), (MqttPublish) mqttWireMessage);
                    }
                    this.tokenStore.saveToken(mqttToken, mqttWireMessage);
                    this.pendingMessages.addElement(mqttWireMessage);
                    this.queueLock.notifyAll();
                } else {
                    log.fine("ClientState", "send", "613", new Object[]{new Integer(this.actualInFlight)});
                    throw new MqttException(32202);
                }
            }
            return;
        }
        log.fine("ClientState", "send", "615", new Object[]{new Integer(mqttWireMessage.getMessageId()), mqttWireMessage});
        if (mqttWireMessage instanceof MqttConnect) {
            synchronized (this.queueLock) {
                this.tokenStore.saveToken(mqttToken, mqttWireMessage);
                this.pendingFlows.insertElementAt(mqttWireMessage, 0);
                this.queueLock.notifyAll();
            }
            return;
        }
        if (mqttWireMessage instanceof MqttPingReq) {
            this.pingCommand = mqttWireMessage;
        } else if (mqttWireMessage instanceof MqttPubRel) {
            this.outboundQoS2.put(new Integer(mqttWireMessage.getMessageId()), mqttWireMessage);
            this.persistence.put(getSendConfirmPersistenceKey(mqttWireMessage), (MqttPubRel) mqttWireMessage);
        } else if (mqttWireMessage instanceof MqttPubComp) {
            this.persistence.remove(getReceivedPersistenceKey(mqttWireMessage));
        }
        synchronized (this.queueLock) {
            if (!(mqttWireMessage instanceof MqttAck)) {
                this.tokenStore.saveToken(mqttToken, mqttWireMessage);
            }
            this.pendingFlows.addElement(mqttWireMessage);
            this.queueLock.notifyAll();
        }
    }

    public void persistBufferedMessage(MqttWireMessage mqttWireMessage) {
        getSendBufferedPersistenceKey(mqttWireMessage);
        try {
            mqttWireMessage.setMessageId(getNextMessageId());
            String sendBufferedPersistenceKey = getSendBufferedPersistenceKey(mqttWireMessage);
            try {
                this.persistence.put(sendBufferedPersistenceKey, (MqttPublish) mqttWireMessage);
            } catch (Throwable unused) {
                log.fine("ClientState", "persistBufferedMessage", "515");
                this.persistence.open(this.clientComms.getClient().getClientId(), this.clientComms.getClient().getServerURI());
                this.persistence.put(sendBufferedPersistenceKey, (MqttPublish) mqttWireMessage);
            }
            log.fine("ClientState", "persistBufferedMessage", "513", new Object[]{sendBufferedPersistenceKey});
        } catch (Throwable th) {
            TBaseLogger.e("ClientState", "persistBufferedMessage", th);
        }
    }

    public void unPersistBufferedMessage(MqttWireMessage mqttWireMessage) {
        try {
            log.fine("ClientState", "unPersistBufferedMessage", "517", new Object[]{mqttWireMessage.getKey()});
            this.persistence.remove(getSendBufferedPersistenceKey(mqttWireMessage));
        } catch (Throwable th) {
            TBaseLogger.e("ClientState", "unPersistBufferedMessage", th);
        }
    }

    protected void undo(MqttPublish mqttPublish) throws MqttPersistenceException {
        synchronized (this.queueLock) {
            log.fine("ClientState", "undo", "618", new Object[]{new Integer(mqttPublish.getMessageId()), new Integer(mqttPublish.getMessage().getQos())});
            if (mqttPublish.getMessage().getQos() == 1) {
                this.outboundQoS1.remove(new Integer(mqttPublish.getMessageId()));
            } else {
                this.outboundQoS2.remove(new Integer(mqttPublish.getMessageId()));
            }
            this.pendingMessages.removeElement(mqttPublish);
            this.persistence.remove(getSendPersistenceKey(mqttPublish));
            this.tokenStore.removeToken(mqttPublish);
            if (mqttPublish.getMessage().getQos() > 0) {
                releaseMessageId(mqttPublish.getMessageId());
                mqttPublish.setMessageId(0);
            }
            checkQuiesceLock();
        }
    }

    public MqttToken checkForActivity(IMqttActionListener iMqttActionListener) throws MqttException {
        Object obj;
        Throwable th;
        long j;
        MqttToken mqttToken;
        Logger logger = log;
        logger.fine("ClientState", "checkForActivity", "616", new Object[0]);
        synchronized (this.quiesceLock) {
            if (this.quiescing) {
                return null;
            }
        }
        getKeepAlive();
        if (!this.connected || this.keepAlive <= 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object obj2 = this.pingOutstandingLock;
        synchronized (obj2) {
            try {
                int i = this.pingOutstanding;
                if (i > 0) {
                    if (currentTimeMillis - this.lastInboundActivity >= this.keepAlive + ((long) 100)) {
                        logger.severe("ClientState", "checkForActivity", "619", new Object[]{new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity), new Long(currentTimeMillis), new Long(this.lastPing)});
                        throw ExceptionHelper.createMqttException(32000);
                    }
                }
                if (i == 0) {
                    obj = obj2;
                    try {
                        if (currentTimeMillis - this.lastOutboundActivity >= this.keepAlive * 2) {
                            logger.severe("ClientState", "checkForActivity", "642", new Object[]{new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity), new Long(currentTimeMillis), new Long(this.lastPing)});
                            throw ExceptionHelper.createMqttException(32002);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    obj = obj2;
                }
                if ((i != 0 || currentTimeMillis - this.lastInboundActivity < this.keepAlive - ((long) 100)) && currentTimeMillis - this.lastOutboundActivity < this.keepAlive - ((long) 100)) {
                    logger.fine("ClientState", "checkForActivity", "634", null);
                    j = Math.max(1L, getKeepAlive() - (currentTimeMillis - this.lastOutboundActivity));
                    mqttToken = null;
                } else {
                    logger.fine("ClientState", "checkForActivity", "620", new Object[]{new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity)});
                    mqttToken = new MqttToken(this.clientComms.getClient().getClientId());
                    if (iMqttActionListener != null) {
                        mqttToken.setActionCallback(iMqttActionListener);
                    }
                    this.tokenStore.saveToken(mqttToken, this.pingCommand);
                    this.pendingFlows.insertElementAt(this.pingCommand, 0);
                    j = getKeepAlive();
                    notifyQueueLock();
                }
                logger.fine("ClientState", "checkForActivity", "624", new Object[]{new Long(j)});
                MqttPingSender mqttPingSender = this.pingSender;
                if (mqttPingSender != null) {
                    mqttPingSender.schedule(j);
                }
                return mqttToken;
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    protected MqttWireMessage get() throws MqttException {
        synchronized (this.queueLock) {
            MqttWireMessage mqttWireMessage = null;
            while (mqttWireMessage == null) {
                if ((this.pendingMessages.isEmpty() && this.pendingFlows.isEmpty()) || (this.pendingFlows.isEmpty() && this.actualInFlight >= this.maxInflight)) {
                    try {
                        Logger logger = log;
                        logger.fine("ClientState", "get", "644");
                        this.queueLock.wait();
                        logger.fine("ClientState", "get", "647");
                    } catch (InterruptedException unused) {
                    }
                }
                if (!this.connected && (this.pendingFlows.isEmpty() || !(((MqttWireMessage) this.pendingFlows.elementAt(0)) instanceof MqttConnect))) {
                    log.fine("ClientState", "get", "621");
                    return null;
                } else if (!this.pendingFlows.isEmpty()) {
                    mqttWireMessage = (MqttWireMessage) this.pendingFlows.remove(0);
                    if (mqttWireMessage instanceof MqttPubRel) {
                        this.inFlightPubRels++;
                        log.fine("ClientState", "get", "617", new Object[]{new Integer(this.inFlightPubRels)});
                    }
                    checkQuiesceLock();
                } else if (!this.pendingMessages.isEmpty()) {
                    if (this.actualInFlight < this.maxInflight) {
                        mqttWireMessage = (MqttWireMessage) this.pendingMessages.elementAt(0);
                        this.pendingMessages.removeElementAt(0);
                        this.actualInFlight++;
                        log.fine("ClientState", "get", "623", new Object[]{new Integer(this.actualInFlight)});
                    } else {
                        log.fine("ClientState", "get", "622");
                    }
                }
            }
            return mqttWireMessage;
        }
    }

    public void setKeepAliveInterval(long j) {
        this.keepAlive = j;
    }

    public void notifySentBytes(int i) {
        if (i > 0) {
            this.lastOutboundActivity = System.currentTimeMillis();
        }
        log.fine("ClientState", "notifySentBytes", "643", new Object[]{new Integer(i)});
    }

    protected void notifySent(MqttWireMessage mqttWireMessage) {
        TBaseLogger.d("ClientState", "action - notifySent");
        this.lastOutboundActivity = System.currentTimeMillis();
        log.fine("ClientState", "notifySent", "625", new Object[]{mqttWireMessage.getKey()});
        MqttToken token = this.tokenStore.getToken(mqttWireMessage);
        token.internalTok.notifySent();
        if (mqttWireMessage instanceof MqttPingReq) {
            synchronized (this.pingOutstandingLock) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.pingOutstandingLock) {
                    this.lastPing = currentTimeMillis;
                    this.pingOutstanding++;
                }
            }
        } else if ((mqttWireMessage instanceof MqttPublish) && ((MqttPublish) mqttWireMessage).getMessage().getQos() == 0) {
            token.internalTok.markComplete(null, null);
            this.callback.asyncOperationComplete(token);
            decrementInFlight();
            releaseMessageId(mqttWireMessage.getMessageId());
            this.tokenStore.removeToken(mqttWireMessage);
            checkQuiesceLock();
        }
    }

    private void decrementInFlight() {
        synchronized (this.queueLock) {
            this.actualInFlight--;
            log.fine("ClientState", "decrementInFlight", "646", new Object[]{new Integer(this.actualInFlight)});
            if (!checkQuiesceLock()) {
                this.queueLock.notifyAll();
            }
        }
    }

    protected boolean checkQuiesceLock() {
        int count = this.tokenStore.count();
        if (!this.quiescing || count != 0 || this.pendingFlows.size() != 0 || !this.callback.isQuiesced()) {
            return false;
        }
        synchronized (this.quiesceLock) {
            this.quiesceLock.notifyAll();
        }
        return true;
    }

    public void notifyReceivedBytes(int i) {
        if (i > 0) {
            this.lastInboundActivity = System.currentTimeMillis();
        }
        log.fine("ClientState", "notifyReceivedBytes", "630", new Object[]{new Integer(i)});
    }

    protected void notifyReceivedAck(MqttAck mqttAck) throws MqttException {
        this.lastInboundActivity = System.currentTimeMillis();
        Logger logger = log;
        logger.fine("ClientState", "notifyReceivedAck", "627", new Object[]{new Integer(mqttAck.getMessageId()), mqttAck});
        MqttToken token = this.tokenStore.getToken(mqttAck);
        if (token == null) {
            logger.fine("ClientState", "notifyReceivedAck", "662", new Object[]{new Integer(mqttAck.getMessageId())});
        } else if (mqttAck instanceof MqttPubRec) {
            logger.fine("ClientState", "notifyReceivedAck", "663", new Object[]{new Integer(mqttAck.getMessageId())});
            send(new MqttPubRel((MqttPubRec) mqttAck), token);
        } else if ((mqttAck instanceof MqttPubAck) || (mqttAck instanceof MqttPubComp)) {
            notifyResult(mqttAck, token, null);
        } else if (mqttAck instanceof MqttPingResp) {
            logger.fine("ClientState", "notifyReceivedAck", "664", new Object[]{new Integer(mqttAck.getMessageId())});
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = Math.max(0, this.pingOutstanding - 1);
                notifyResult(mqttAck, token, null);
                if (this.pingOutstanding == 0) {
                    this.tokenStore.removeToken(mqttAck);
                }
            }
        } else if (mqttAck instanceof MqttConnack) {
            logger.fine("ClientState", "notifyReceivedAck", "665", new Object[]{new Integer(mqttAck.getMessageId())});
            MqttConnack mqttConnack = (MqttConnack) mqttAck;
            int returnCode = mqttConnack.getReturnCode();
            if (returnCode == 0) {
                synchronized (this.queueLock) {
                    if (this.cleanSession) {
                        clearState();
                        this.tokenStore.saveToken(token, mqttAck);
                    }
                    this.inFlightPubRels = 0;
                    this.actualInFlight = 0;
                    restoreInflightMessages();
                    connected();
                }
                this.clientComms.connectComplete(mqttConnack, null);
                notifyResult(mqttAck, token, null);
                this.tokenStore.removeToken(mqttAck);
                synchronized (this.queueLock) {
                    this.queueLock.notifyAll();
                }
            } else {
                throw ExceptionHelper.createMqttException(returnCode);
            }
        } else {
            logger.fine("ClientState", "notifyReceivedAck", "666", new Object[]{new Integer(mqttAck.getMessageId())});
            notifyResult(mqttAck, token, null);
            releaseMessageId(mqttAck.getMessageId());
            this.tokenStore.removeToken(mqttAck);
        }
        checkQuiesceLock();
    }

    protected void notifyReceivedMsg(MqttWireMessage mqttWireMessage) throws MqttException {
        TBaseLogger.d("ClientState", "action - notifyReceivedMsg:" + mqttWireMessage.toString());
        this.lastInboundActivity = System.currentTimeMillis();
        log.fine("ClientState", "notifyReceivedMsg", "651", new Object[]{new Integer(mqttWireMessage.getMessageId()), mqttWireMessage});
        if (this.quiescing) {
            return;
        }
        if (mqttWireMessage instanceof MqttPublish) {
            MqttPublish mqttPublish = (MqttPublish) mqttWireMessage;
            int qos = mqttPublish.getMessage().getQos();
            if (qos == 0 || qos == 1) {
                CommsCallback commsCallback = this.callback;
                if (commsCallback != null) {
                    commsCallback.messageArrived(mqttPublish);
                }
            } else if (qos == 2) {
                this.persistence.put(getReceivedPersistenceKey(mqttWireMessage), mqttPublish);
                this.inboundQoS2.put(new Integer(mqttPublish.getMessageId()), mqttPublish);
                send(new MqttPubRec(mqttPublish), null);
            }
        } else if (mqttWireMessage instanceof MqttPubRel) {
            MqttPublish mqttPublish2 = (MqttPublish) this.inboundQoS2.get(new Integer(mqttWireMessage.getMessageId()));
            if (mqttPublish2 != null) {
                CommsCallback commsCallback2 = this.callback;
                if (commsCallback2 != null) {
                    commsCallback2.messageArrived(mqttPublish2);
                    return;
                }
                return;
            }
            send(new MqttPubComp(mqttWireMessage.getMessageId()), null);
        }
    }

    protected void notifyComplete(MqttToken mqttToken) throws MqttException {
        MqttWireMessage wireMessage = mqttToken.internalTok.getWireMessage();
        if (wireMessage != null && (wireMessage instanceof MqttAck)) {
            Logger logger = log;
            logger.fine("ClientState", "notifyComplete", "629", new Object[]{new Integer(wireMessage.getMessageId()), mqttToken, wireMessage});
            MqttAck mqttAck = (MqttAck) wireMessage;
            if (mqttAck instanceof MqttPubAck) {
                this.persistence.remove(getSendPersistenceKey(wireMessage));
                this.persistence.remove(getSendBufferedPersistenceKey(wireMessage));
                this.outboundQoS1.remove(new Integer(mqttAck.getMessageId()));
                decrementInFlight();
                releaseMessageId(wireMessage.getMessageId());
                this.tokenStore.removeToken(wireMessage);
                logger.fine("ClientState", "notifyComplete", "650", new Object[]{new Integer(mqttAck.getMessageId())});
            } else if (mqttAck instanceof MqttPubComp) {
                this.persistence.remove(getSendPersistenceKey(wireMessage));
                this.persistence.remove(getSendConfirmPersistenceKey(wireMessage));
                this.persistence.remove(getSendBufferedPersistenceKey(wireMessage));
                this.outboundQoS2.remove(new Integer(mqttAck.getMessageId()));
                this.inFlightPubRels--;
                decrementInFlight();
                releaseMessageId(wireMessage.getMessageId());
                this.tokenStore.removeToken(wireMessage);
                logger.fine("ClientState", "notifyComplete", "645", new Object[]{new Integer(mqttAck.getMessageId()), new Integer(this.inFlightPubRels)});
            }
            checkQuiesceLock();
        }
    }

    protected void notifyResult(MqttWireMessage mqttWireMessage, MqttToken mqttToken, MqttException mqttException) {
        TBaseLogger.d("ClientState", "action:notifyResult");
        mqttToken.internalTok.markComplete(mqttWireMessage, mqttException);
        mqttToken.internalTok.notifyComplete();
        if (mqttWireMessage != null && (mqttWireMessage instanceof MqttAck) && !(mqttWireMessage instanceof MqttPubRec)) {
            log.fine("ClientState", "notifyResult", "648", new Object[]{mqttToken.internalTok.getKey(), mqttWireMessage, mqttException});
            this.callback.asyncOperationComplete(mqttToken);
        }
        if (mqttWireMessage == null) {
            log.fine("ClientState", "notifyResult", "649", new Object[]{mqttToken.internalTok.getKey(), mqttException});
            this.callback.asyncOperationComplete(mqttToken);
        }
    }

    public void connected() {
        log.fine("ClientState", "connected", "631");
        this.connected = true;
        MqttPingSender mqttPingSender = this.pingSender;
        if (mqttPingSender != null) {
            mqttPingSender.start();
        }
    }

    public Vector resolveOldTokens(MqttException mqttException) {
        log.fine("ClientState", "resolveOldTokens", "632", new Object[]{mqttException});
        if (mqttException == null) {
            mqttException = new MqttException(32102);
        }
        Vector outstandingTokens = this.tokenStore.getOutstandingTokens();
        Enumeration elements = outstandingTokens.elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken = (MqttToken) elements.nextElement();
            synchronized (mqttToken) {
                if (!mqttToken.isComplete() && !mqttToken.internalTok.isCompletePending() && mqttToken.getException() == null) {
                    mqttToken.internalTok.setException(mqttException);
                }
            }
            if (!(mqttToken instanceof MqttDeliveryToken)) {
                this.tokenStore.removeToken(mqttToken.internalTok.getKey());
            }
        }
        return outstandingTokens;
    }

    public void disconnected(MqttException mqttException) {
        log.fine("ClientState", "disconnected", "633", new Object[]{mqttException});
        this.connected = false;
        try {
            if (this.cleanSession) {
                clearState();
            }
            this.pendingMessages.clear();
            this.pendingFlows.clear();
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void releaseMessageId(int i) {
        this.inUseMsgIds.remove(new Integer(i));
    }

    private synchronized int getNextMessageId() throws MqttException {
        int i = this.nextMsgId;
        int i2 = 0;
        do {
            int i3 = this.nextMsgId + 1;
            this.nextMsgId = i3;
            if (i3 > 65535) {
                this.nextMsgId = 1;
            }
            if (this.nextMsgId == i) {
                i2++;
                if (i2 == 2) {
                    throw ExceptionHelper.createMqttException(32001);
                }
            }
        } while (this.inUseMsgIds.containsKey(new Integer(this.nextMsgId)));
        Integer num = new Integer(this.nextMsgId);
        this.inUseMsgIds.put(num, num);
        return this.nextMsgId;
    }

    public void quiesce(long j) {
        if (j > 0) {
            log.fine("ClientState", "quiesce", "637", new Object[]{new Long(j)});
            synchronized (this.queueLock) {
                this.quiescing = true;
            }
            this.callback.quiesce();
            notifyQueueLock();
            synchronized (this.quiesceLock) {
                try {
                    if (this.tokenStore.count() > 0 || this.pendingFlows.size() > 0 || !this.callback.isQuiesced()) {
                        this.quiesceLock.wait(j);
                    }
                } catch (InterruptedException unused) {
                }
            }
            synchronized (this.queueLock) {
                this.pendingMessages.clear();
                this.pendingFlows.clear();
                this.quiescing = false;
                this.actualInFlight = 0;
            }
            log.fine("ClientState", "quiesce", "640");
        }
    }

    public void notifyQueueLock() {
        synchronized (this.queueLock) {
            log.fine("ClientState", "notifyQueueLock", "638");
            this.queueLock.notifyAll();
        }
    }

    protected void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        log.fine("ClientState", "deliveryComplete", "641", new Object[]{new Integer(mqttPublish.getMessageId())});
        this.persistence.remove(getReceivedPersistenceKey(mqttPublish));
        this.inboundQoS2.remove(new Integer(mqttPublish.getMessageId()));
    }

    protected void deliveryComplete(int i) throws MqttPersistenceException {
        log.fine("ClientState", "deliveryComplete", "641", new Object[]{new Integer(i)});
        this.persistence.remove(getReceivedPersistenceKey(i));
        this.inboundQoS2.remove(new Integer(i));
    }

    public int getActualInFlight() {
        return this.actualInFlight;
    }

    public int getMaxInFlight() {
        return this.maxInflight;
    }

    protected void close() {
        this.inUseMsgIds.clear();
        if (this.pendingMessages != null) {
            this.pendingMessages.clear();
        }
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.outboundQoS0.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
        this.inUseMsgIds = null;
        this.pendingMessages = null;
        this.pendingFlows = null;
        this.outboundQoS2 = null;
        this.outboundQoS1 = null;
        this.outboundQoS0 = null;
        this.inboundQoS2 = null;
        this.tokenStore = null;
        this.callback = null;
        this.clientComms = null;
        this.persistence = null;
        this.pingCommand = null;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("In use msgids", this.inUseMsgIds);
        properties.put("pendingMessages", this.pendingMessages);
        properties.put("pendingFlows", this.pendingFlows);
        properties.put("maxInflight", new Integer(this.maxInflight));
        properties.put("nextMsgID", new Integer(this.nextMsgId));
        properties.put("actualInFlight", new Integer(this.actualInFlight));
        properties.put("inFlightPubRels", new Integer(this.inFlightPubRels));
        properties.put("quiescing", Boolean.valueOf(this.quiescing));
        properties.put("pingoutstanding", new Integer(this.pingOutstanding));
        properties.put("lastOutboundActivity", new Long(this.lastOutboundActivity));
        properties.put("lastInboundActivity", new Long(this.lastInboundActivity));
        properties.put("outboundQoS2", this.outboundQoS2);
        properties.put("outboundQoS1", this.outboundQoS1);
        properties.put("outboundQoS0", this.outboundQoS0);
        properties.put("inboundQoS2", this.inboundQoS2);
        properties.put("tokens", this.tokenStore);
        return properties;
    }
}
