package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsCallback implements Runnable {
    private static final String CLASS_NAME = "CommsCallback";
    private static final int INBOUND_QUEUE_SIZE = 10;
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsCallback");
    private Future callbackFuture;
    private Thread callbackThread;
    private Hashtable callbacks;
    private ClientComms clientComms;
    private ClientState clientState;
    private Vector completeQueue;
    private Object lifecycle = new Object();
    private boolean manualAcks = false;
    private Vector messageQueue;
    private MqttCallback mqttCallback;
    private boolean quiescing = false;
    private MqttCallbackExtended reconnectInternalCallback;
    public boolean running = false;
    private final Semaphore runningSemaphore = new Semaphore(1);
    private Object spaceAvailable = new Object();
    private String threadName;
    private Object workAvailable = new Object();

    CommsCallback(ClientComms clientComms2) {
        this.clientComms = clientComms2;
        this.messageQueue = new Vector(10);
        this.completeQueue = new Vector(10);
        this.callbacks = new Hashtable();
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    public void setClientState(ClientState clientState2) {
        this.clientState = clientState2;
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.messageQueue.clear();
                this.completeQueue.clear();
                this.running = true;
                this.quiescing = false;
                this.callbackFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.callbackFuture;
            if (future != null) {
                future.cancel(true);
            }
            if (this.running) {
                Logger logger = log;
                logger.fine("CommsCallback", "stop", "700");
                this.running = false;
                if (!Thread.currentThread().equals(this.callbackThread)) {
                    try {
                        synchronized (this.workAvailable) {
                            logger.fine("CommsCallback", "stop", "701");
                            this.workAvailable.notifyAll();
                        }
                        this.runningSemaphore.acquire();
                        semaphore = this.runningSemaphore;
                    } catch (InterruptedException unused) {
                        semaphore = this.runningSemaphore;
                    } catch (Throwable th) {
                        this.runningSemaphore.release();
                        throw th;
                    }
                    semaphore.release();
                }
            }
            this.callbackThread = null;
            log.fine("CommsCallback", "stop", "703");
        }
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.reconnectInternalCallback = mqttCallbackExtended;
    }

    public void setManualAcks(boolean z) {
        this.manualAcks = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MqttToken mqttToken;
        MqttPublish mqttPublish;
        TBaseLogger.d("CommsCallback", "run loop callback thread:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.callbackThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            while (this.running) {
                try {
                    synchronized (this.workAvailable) {
                        if (this.running && this.messageQueue.isEmpty() && this.completeQueue.isEmpty()) {
                            log.fine("CommsCallback", "run", "704");
                            this.workAvailable.wait();
                        }
                    }
                } catch (InterruptedException unused) {
                }
                try {
                    if (this.running) {
                        synchronized (this.completeQueue) {
                            if (!this.completeQueue.isEmpty()) {
                                mqttToken = (MqttToken) this.completeQueue.elementAt(0);
                                this.completeQueue.removeElementAt(0);
                            } else {
                                mqttToken = null;
                            }
                        }
                        if (mqttToken != null) {
                            handleActionComplete(mqttToken);
                        }
                        synchronized (this.messageQueue) {
                            if (!this.messageQueue.isEmpty()) {
                                mqttPublish = (MqttPublish) this.messageQueue.elementAt(0);
                                this.messageQueue.removeElementAt(0);
                            } else {
                                mqttPublish = null;
                            }
                        }
                        if (mqttPublish != null) {
                            handleMessage(mqttPublish);
                        }
                    }
                    if (this.quiescing) {
                        this.clientState.checkQuiesceLock();
                    }
                    this.runningSemaphore.release();
                    synchronized (this.spaceAvailable) {
                        log.fine("CommsCallback", "run", "706");
                        this.spaceAvailable.notifyAll();
                    }
                } catch (Throwable th) {
                    this.runningSemaphore.release();
                    synchronized (this.spaceAvailable) {
                        log.fine("CommsCallback", "run", "706");
                        this.spaceAvailable.notifyAll();
                        throw th;
                    }
                }
            }
        } catch (InterruptedException unused2) {
            this.running = false;
        }
    }

    private void handleActionComplete(MqttToken mqttToken) throws MqttException {
        synchronized (mqttToken) {
            log.fine("CommsCallback", "handleActionComplete", "705", new Object[]{mqttToken.internalTok.getKey()});
            if (mqttToken.isComplete()) {
                this.clientState.notifyComplete(mqttToken);
            }
            mqttToken.internalTok.notifyComplete();
            if (!mqttToken.internalTok.isNotified()) {
                if (this.mqttCallback != null && (mqttToken instanceof MqttDeliveryToken) && mqttToken.isComplete()) {
                    this.mqttCallback.deliveryComplete((MqttDeliveryToken) mqttToken);
                }
                fireActionEvent(mqttToken);
            }
            if (mqttToken.isComplete() && ((mqttToken instanceof MqttDeliveryToken) || (mqttToken.getActionCallback() instanceof IMqttActionListener))) {
                mqttToken.internalTok.setNotified(true);
            }
        }
    }

    public void connectionLost(MqttException mqttException) {
        try {
            if (!(this.mqttCallback == null || mqttException == null)) {
                log.fine("CommsCallback", "connectionLost", "708", new Object[]{mqttException});
                this.mqttCallback.connectionLost(mqttException);
            }
            MqttCallbackExtended mqttCallbackExtended = this.reconnectInternalCallback;
            if (mqttCallbackExtended != null && mqttException != null) {
                mqttCallbackExtended.connectionLost(mqttException);
            }
        } catch (Throwable th) {
            TBaseLogger.e("CommsCallback", "connectionLost", th);
        }
    }

    public void fireActionEvent(MqttToken mqttToken) {
        IMqttActionListener actionCallback;
        if (mqttToken != null && (actionCallback = mqttToken.getActionCallback()) != null) {
            if (mqttToken.getException() == null) {
                log.fine("CommsCallback", "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
                actionCallback.onSuccess(mqttToken);
                return;
            }
            log.fine("CommsCallback", "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
            actionCallback.onFailure(mqttToken, mqttToken.getException());
        }
    }

    public void messageArrived(MqttPublish mqttPublish) {
        if (this.mqttCallback != null || this.callbacks.size() > 0) {
            synchronized (this.spaceAvailable) {
                while (this.running && !this.quiescing && this.messageQueue.size() >= 10) {
                    try {
                        log.fine("CommsCallback", "messageArrived", "709");
                        this.spaceAvailable.wait(200);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (!this.quiescing) {
                this.messageQueue.addElement(mqttPublish);
                synchronized (this.workAvailable) {
                    log.fine("CommsCallback", "messageArrived", "710");
                    this.workAvailable.notifyAll();
                }
            }
        }
    }

    public void quiesce() {
        this.quiescing = true;
        synchronized (this.spaceAvailable) {
            log.fine("CommsCallback", "quiesce", "711");
            this.spaceAvailable.notifyAll();
        }
    }

    public boolean isQuiesced() {
        return this.quiescing && this.completeQueue.size() == 0 && this.messageQueue.size() == 0;
    }

    private void handleMessage(MqttPublish mqttPublish) throws MqttException, Exception {
        String topicName = mqttPublish.getTopicName();
        log.fine("CommsCallback", "handleMessage", "713", new Object[]{new Integer(mqttPublish.getMessageId()), topicName});
        deliverMessage(topicName, mqttPublish.getMessageId(), mqttPublish.getMessage());
        if (this.manualAcks) {
            return;
        }
        if (mqttPublish.getMessage().getQos() == 1) {
            this.clientComms.internalSend(new MqttPubAck(mqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (mqttPublish.getMessage().getQos() == 2) {
            this.clientComms.deliveryComplete(mqttPublish);
            MqttPubComp mqttPubComp = new MqttPubComp(mqttPublish);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        if (i2 == 1) {
            this.clientComms.internalSend(new MqttPubAck(i), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (i2 == 2) {
            this.clientComms.deliveryComplete(i);
            MqttPubComp mqttPubComp = new MqttPubComp(i);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
    }

    public void asyncOperationComplete(MqttToken mqttToken) {
        if (this.running) {
            this.completeQueue.addElement(mqttToken);
            synchronized (this.workAvailable) {
                log.fine("CommsCallback", "asyncOperationComplete", "715", new Object[]{mqttToken.internalTok.getKey()});
                this.workAvailable.notifyAll();
            }
            return;
        }
        try {
            handleActionComplete(mqttToken);
        } catch (Throwable th) {
            TBaseLogger.e("CommsCallback", "asyncOperationComplete", th);
            this.clientComms.shutdownConnection(null, new MqttException(th));
        }
    }

    protected Thread getThread() {
        return this.callbackThread;
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callbacks.put(str, iMqttMessageListener);
    }

    public void removeMessageListener(String str) {
        this.callbacks.remove(str);
    }

    public void removeMessageListeners() {
        this.callbacks.clear();
    }

    protected boolean deliverMessage(String str, int i, MqttMessage mqttMessage) throws Exception {
        Enumeration keys = this.callbacks.keys();
        boolean z = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (MqttTopic.isMatched(str2, str)) {
                mqttMessage.setId(i);
                ((IMqttMessageListener) this.callbacks.get(str2)).messageArrived(str, mqttMessage);
                z = true;
            }
        }
        if (this.mqttCallback == null || z) {
            return z;
        }
        mqttMessage.setId(i);
        this.mqttCallback.messageArrived(str, mqttMessage);
        return true;
    }
}
