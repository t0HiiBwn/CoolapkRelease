package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientComms {
    public static String BUILD_LEVEL = "L${build.level}";
    private static final String CLASS_NAME = "ClientComms";
    private static final byte CLOSED = 4;
    private static final byte CONNECTED = 0;
    private static final byte CONNECTING = 1;
    private static final byte DISCONNECTED = 3;
    private static final byte DISCONNECTING = 2;
    private static final String TAG = "ClientComms";
    public static String VERSION = "${project.version}";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientComms");
    private CommsCallback callback;
    private IMqttAsyncClient client;
    private ClientState clientState;
    private boolean closePending = false;
    private Object conLock = new Object();
    private MqttConnectOptions conOptions;
    private byte conState = 3;
    private DisconnectedMessageBuffer disconnectedMessageBuffer;
    private ExecutorService executorService;
    private int networkModuleIndex;
    private NetworkModule[] networkModules;
    private MqttClientPersistence persistence;
    private MqttPingSender pingSender;
    private CommsReceiver receiver;
    private boolean resting = false;
    private CommsSender sender;
    private boolean stoppingComms = false;
    private CommsTokenStore tokenStore;

    public ClientComms(IMqttAsyncClient iMqttAsyncClient, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ExecutorService executorService2) throws MqttException {
        TBaseLogger.d("ClientComms", "init ClientComms");
        this.conState = 3;
        this.client = iMqttAsyncClient;
        this.persistence = mqttClientPersistence;
        this.pingSender = mqttPingSender;
        if (mqttPingSender != null) {
            mqttPingSender.init(this);
        }
        this.executorService = executorService2;
        this.tokenStore = new CommsTokenStore(getClient().getClientId());
        this.callback = new CommsCallback(this);
        ClientState clientState2 = new ClientState(mqttClientPersistence, this.tokenStore, this.callback, this, mqttPingSender);
        this.clientState = clientState2;
        this.callback.setClientState(clientState2);
        log.setResourceName(getClient().getClientId());
    }

    CommsReceiver getReceiver() {
        return this.receiver;
    }

    private void shutdownExecutorService() {
        this.executorService.shutdown();
        try {
            if (!this.executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                this.executorService.shutdownNow();
                if (!this.executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                    log.fine("ClientComms", "shutdownExecutorService", "executorService did not terminate");
                }
            }
        } catch (InterruptedException unused) {
            this.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    void internalSend(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        TBaseLogger.d("ClientComms", "action - internalSend");
        Logger logger = log;
        logger.fine("ClientComms", "internalSend", "200", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
        if (mqttToken.getClient() == null) {
            mqttToken.internalTok.setClient(getClient());
            ClientState clientState2 = this.clientState;
            if (clientState2 != null) {
                try {
                    clientState2.send(mqttWireMessage, mqttToken);
                } catch (MqttException e) {
                    if (mqttWireMessage instanceof MqttPublish) {
                        this.clientState.undo((MqttPublish) mqttWireMessage);
                    }
                    throw e;
                }
            }
        } else {
            logger.fine("ClientComms", "internalSend", "213", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
            throw new MqttException(32201);
        }
    }

    public void sendNoWait(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (isConnected() || ((!isConnected() && (mqttWireMessage instanceof MqttConnect)) || (isDisconnecting() && (mqttWireMessage instanceof MqttDisconnect)))) {
            DisconnectedMessageBuffer disconnectedMessageBuffer2 = this.disconnectedMessageBuffer;
            if (disconnectedMessageBuffer2 == null || disconnectedMessageBuffer2.getMessageCount() == 0) {
                internalSend(mqttWireMessage, mqttToken);
                return;
            }
            log.fine("ClientComms", "sendNoWait", "507", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else if (this.disconnectedMessageBuffer != null) {
            log.fine("ClientComms", "sendNoWait", "508", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else {
            log.fine("ClientComms", "sendNoWait", "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public void close(boolean z) throws MqttException {
        synchronized (this.conLock) {
            if (!isClosed()) {
                if (!isDisconnected() || z) {
                    log.fine("ClientComms", "close", "224");
                    if (isConnecting()) {
                        TBaseLogger.e("ClientComms", "close when is isConnecting");
                    } else if (isConnected()) {
                        TBaseLogger.e("ClientComms", "close when is isConnected");
                    } else if (isDisconnecting()) {
                        this.closePending = true;
                    }
                }
                this.conState = 4;
                shutdownExecutorService();
                this.clientState.close();
                this.clientState = null;
                this.callback = null;
                this.persistence = null;
                this.sender = null;
                this.pingSender = null;
                this.receiver = null;
                this.networkModules = null;
                this.conOptions = null;
                this.tokenStore = null;
            }
        }
    }

    public void connect(MqttConnectOptions mqttConnectOptions, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (!isDisconnected() || this.closePending) {
                log.fine("ClientComms", "connect", "207", new Object[]{new Byte(this.conState)});
                if (isClosed() || this.closePending) {
                    throw new MqttException(32111);
                } else if (isConnecting()) {
                    throw new MqttException(32110);
                } else if (isDisconnecting()) {
                    throw new MqttException(32102);
                } else {
                    throw ExceptionHelper.createMqttException(32100);
                }
            } else {
                log.fine("ClientComms", "connect", "214");
                this.conState = 1;
                this.conOptions = mqttConnectOptions;
                MqttConnect mqttConnect = new MqttConnect(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
                this.clientState.setKeepAliveSecs((long) this.conOptions.getKeepAliveInterval());
                this.clientState.setCleanSession(this.conOptions.isCleanSession());
                this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
                this.tokenStore.open();
                new ConnectBG(this, mqttToken, mqttConnect, this.executorService).start();
            }
        }
    }

    public void connectComplete(MqttConnack mqttConnack, MqttException mqttException) throws MqttException {
        int returnCode = mqttConnack.getReturnCode();
        synchronized (this.conLock) {
            if (returnCode == 0) {
                log.fine("ClientComms", "connectComplete", "215");
                this.conState = 0;
                return;
            }
        }
        log.fine("ClientComms", "connectComplete", "204", new Object[]{new Integer(returnCode)});
        if (mqttException != null) {
            throw mqttException;
        }
    }

    public void shutdownConnection(MqttToken mqttToken, MqttException mqttException) {
        boolean z;
        boolean z2;
        CommsCallback commsCallback;
        MqttClientPersistence mqttClientPersistence;
        NetworkModule networkModule;
        synchronized (this.conLock) {
            if (!this.stoppingComms && !this.closePending) {
                if (!isClosed()) {
                    this.stoppingComms = true;
                    log.fine("ClientComms", "shutdownConnection", "216");
                    z = false;
                    if (!isConnected()) {
                        if (!isDisconnecting()) {
                            z2 = false;
                            this.conState = 2;
                        }
                    }
                    z2 = true;
                    this.conState = 2;
                }
            }
            return;
        }
        if (mqttToken != null && !mqttToken.isComplete()) {
            mqttToken.internalTok.setException(mqttException);
        }
        CommsCallback commsCallback2 = this.callback;
        if (commsCallback2 != null) {
            commsCallback2.stop();
        }
        CommsReceiver commsReceiver = this.receiver;
        if (commsReceiver != null) {
            commsReceiver.stop();
        }
        try {
            NetworkModule[] networkModuleArr = this.networkModules;
            if (!(networkModuleArr == null || (networkModule = networkModuleArr[this.networkModuleIndex]) == null)) {
                networkModule.stop();
            }
        } catch (Throwable unused) {
        }
        this.tokenStore.quiesce(new MqttException(32102));
        MqttToken handleOldTokens = handleOldTokens(mqttToken, mqttException);
        try {
            this.clientState.disconnected(mqttException);
            if (this.callback != null && this.clientState.getCleanSession()) {
                this.callback.removeMessageListeners();
            }
        } catch (Exception unused2) {
        }
        CommsSender commsSender = this.sender;
        if (commsSender != null) {
            commsSender.stop();
        }
        MqttPingSender mqttPingSender = this.pingSender;
        if (mqttPingSender != null) {
            mqttPingSender.stop();
        }
        try {
            if (this.disconnectedMessageBuffer == null && (mqttClientPersistence = this.persistence) != null) {
                mqttClientPersistence.close();
            }
        } catch (Exception unused3) {
        }
        synchronized (this.conLock) {
            log.fine("ClientComms", "shutdownConnection", "217");
            this.conState = 3;
            this.stoppingComms = false;
        }
        boolean z3 = handleOldTokens != null;
        CommsCallback commsCallback3 = this.callback;
        if (commsCallback3 != null) {
            z = true;
        }
        if (z3 && z) {
            commsCallback3.asyncOperationComplete(handleOldTokens);
        }
        if (z2 && (commsCallback = this.callback) != null) {
            commsCallback.connectionLost(mqttException);
        }
        synchronized (this.conLock) {
            if (this.closePending) {
                try {
                    close(true);
                } catch (Throwable unused4) {
                }
            }
        }
    }

    private MqttToken handleOldTokens(MqttToken mqttToken, MqttException mqttException) {
        log.fine("ClientComms", "handleOldTokens", "222");
        MqttToken mqttToken2 = null;
        if (mqttToken != null) {
            try {
                if (this.tokenStore.getToken(mqttToken.internalTok.getKey()) == null) {
                    this.tokenStore.saveToken(mqttToken, mqttToken.internalTok.getKey());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.clientState.resolveOldTokens(mqttException).elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken3 = (MqttToken) elements.nextElement();
            if (!mqttToken3.internalTok.getKey().equals("Disc")) {
                if (!mqttToken3.internalTok.getKey().equals("Con")) {
                    CommsCallback commsCallback = this.callback;
                    if (commsCallback != null) {
                        commsCallback.asyncOperationComplete(mqttToken3);
                    }
                }
            }
            mqttToken2 = mqttToken3;
        }
        return mqttToken2;
    }

    public void disconnect(MqttDisconnect mqttDisconnect, long j, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (isClosed()) {
                log.fine("ClientComms", "disconnect", "223");
                throw ExceptionHelper.createMqttException(32111);
            } else if (isDisconnected()) {
                log.fine("ClientComms", "disconnect", "211");
                throw ExceptionHelper.createMqttException(32101);
            } else if (!isDisconnecting()) {
                if (Thread.currentThread() == this.callback.getThread()) {
                    log.fine("ClientComms", "disconnect", "210");
                }
                log.fine("ClientComms", "disconnect", "218");
                this.conState = 2;
                new DisconnectBG(mqttDisconnect, j, mqttToken, this.executorService).start();
            } else {
                log.fine("ClientComms", "disconnect", "219");
                throw ExceptionHelper.createMqttException(32102);
            }
        }
    }

    public void disconnectForcibly(long j, long j2) throws MqttException {
        disconnectForcibly(j, j2, true);
    }

    public void disconnectForcibly(long j, long j2, boolean z) throws MqttException {
        ClientState clientState2 = this.clientState;
        if (clientState2 != null) {
            clientState2.quiesce(j);
        }
        MqttToken mqttToken = new MqttToken(this.client.getClientId());
        if (z) {
            try {
                internalSend(new MqttDisconnect(), mqttToken);
                mqttToken.waitForCompletion(j2);
            } catch (Throwable unused) {
            }
        }
        mqttToken.internalTok.markComplete(null, null);
        shutdownConnection(mqttToken, null);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 0;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.conLock) {
            z = true;
            if (this.conState != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean isDisconnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 3;
        }
        return z;
    }

    public boolean isDisconnecting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 2;
        }
        return z;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 4;
        }
        return z;
    }

    public boolean isResting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.resting;
        }
        return z;
    }

    public void setCallback(MqttCallback mqttCallback) {
        CommsCallback commsCallback = this.callback;
        if (commsCallback != null) {
            commsCallback.setCallback(mqttCallback);
        }
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.callback.setReconnectCallback(mqttCallbackExtended);
    }

    public void setManualAcks(boolean z) {
        this.callback.setManualAcks(z);
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.callback.messageArrivedComplete(i, i2);
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callback.setMessageListener(str, iMqttMessageListener);
    }

    public void removeMessageListener(String str) {
        this.callback.removeMessageListener(str);
    }

    protected MqttTopic getTopic(String str) {
        return new MqttTopic(str, this);
    }

    public void setNetworkModuleIndex(int i) {
        this.networkModuleIndex = i;
    }

    public int getNetworkModuleIndex() {
        return this.networkModuleIndex;
    }

    public NetworkModule[] getNetworkModules() {
        return this.networkModules;
    }

    public void setNetworkModules(NetworkModule[] networkModuleArr) {
        this.networkModules = networkModuleArr;
    }

    public MqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.tokenStore.getOutstandingDelTokens();
    }

    protected void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        this.clientState.deliveryComplete(mqttPublish);
    }

    protected void deliveryComplete(int i) throws MqttPersistenceException {
        this.clientState.deliveryComplete(i);
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public long getKeepAlive() {
        return this.clientState.getKeepAlive();
    }

    public ClientState getClientState() {
        return this.clientState;
    }

    public MqttConnectOptions getConOptions() {
        return this.conOptions;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("conState", new Integer(this.conState));
        properties.put("serverURI", getClient().getServerURI());
        properties.put("callback", this.callback);
        properties.put("stoppingComms", new Boolean(this.stoppingComms));
        return properties;
    }

    private class ConnectBG implements Runnable {
        ClientComms clientComms = null;
        MqttConnect conPacket;
        MqttToken conToken;
        private String threadName;

        ConnectBG(ClientComms clientComms2, MqttToken mqttToken, MqttConnect mqttConnect, ExecutorService executorService) {
            this.clientComms = clientComms2;
            this.conToken = mqttToken;
            this.conPacket = mqttConnect;
            this.threadName = "MQTT Con: " + ClientComms.this.getClient().getClientId();
        }

        void start() {
            ClientComms.this.executorService.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            MqttDeliveryToken[] outstandingDelTokens;
            TBaseLogger.dd("ClientComms", "ConnectBG mqtt thread");
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "connectBG:run", "220");
            MqttException e = null;
            try {
                for (MqttDeliveryToken mqttDeliveryToken : ClientComms.this.tokenStore.getOutstandingDelTokens()) {
                    mqttDeliveryToken.internalTok.setException(null);
                }
                ClientComms.this.tokenStore.saveToken(this.conToken, this.conPacket);
                NetworkModule networkModule = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
                networkModule.start();
                ClientComms.this.receiver = new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getInputStream());
                ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.sender = new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getOutputStream());
                ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.internalSend(this.conPacket, this.conToken);
            } catch (MqttException e2) {
                e = e2;
                ClientComms.log.fine("ClientComms", "connectBG:run", "212", null, e);
            } catch (Throwable th) {
                ClientComms.log.fine("ClientComms", "connectBG:run", "209", null, th);
                e = ExceptionHelper.createMqttException(th);
            }
            if (e != null) {
                ClientComms.this.shutdownConnection(this.conToken, e);
            }
        }
    }

    private class DisconnectBG implements Runnable {
        MqttDisconnect disconnect;
        long quiesceTimeout;
        private String threadName;
        MqttToken token;

        DisconnectBG(MqttDisconnect mqttDisconnect, long j, MqttToken mqttToken, ExecutorService executorService) {
            this.disconnect = mqttDisconnect;
            this.quiesceTimeout = j;
            this.token = mqttToken;
        }

        void start() {
            this.threadName = "MQTT Disc: " + ClientComms.this.getClient().getClientId();
            ClientComms.this.executorService.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "disconnectBG:run", "221");
            TBaseLogger.i("disconnectBG:run", "disconnectBG:run");
            ClientComms.this.clientState.quiesce(this.quiesceTimeout);
            try {
                ClientComms.this.internalSend(this.disconnect, this.token);
                this.token.internalTok.waitUntilSent();
            } catch (Throwable th) {
                this.token.internalTok.markComplete(null, null);
                ClientComms.this.shutdownConnection(this.token, null);
                throw th;
            }
            this.token.internalTok.markComplete(null, null);
            ClientComms.this.shutdownConnection(this.token, null);
        }
    }

    public MqttToken checkForActivity() {
        return checkForActivity(null);
    }

    public MqttToken checkForActivity(IMqttActionListener iMqttActionListener) {
        try {
            return this.clientState.checkForActivity(iMqttActionListener);
        } catch (MqttException e) {
            handleRunException(e);
        } catch (Exception e2) {
            handleRunException(e2);
        }
        return null;
    }

    private void handleRunException(Exception exc) {
        MqttException mqttException;
        log.fine("ClientComms", "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        shutdownConnection(null, mqttException);
    }

    public void setRestingState(boolean z) {
        this.resting = z;
    }

    public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer disconnectedMessageBuffer2) {
        this.disconnectedMessageBuffer = disconnectedMessageBuffer2;
    }

    public int getBufferedMessageCount() {
        return this.disconnectedMessageBuffer.getMessageCount();
    }

    public MqttMessage getBufferedMessage(int i) {
        return ((MqttPublish) this.disconnectedMessageBuffer.getMessage(i).getMessage()).getMessage();
    }

    public void deleteBufferedMessage(int i) {
        this.disconnectedMessageBuffer.deleteMessage(i);
    }

    public void notifyConnect() {
        if (this.disconnectedMessageBuffer != null) {
            log.fine("ClientComms", "notifyConnect", "509");
            this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
            this.executorService.execute(this.disconnectedMessageBuffer);
        }
    }

    class ReconnectDisconnectedBufferCallback implements IDisconnectedBufferCallback {
        final String methodName;

        ReconnectDisconnectedBufferCallback(String str) {
            this.methodName = str;
        }

        @Override // com.tencent.android.tpns.mqtt.internal.IDisconnectedBufferCallback
        public void publishBufferedMessage(BufferedMessage bufferedMessage) throws MqttException {
            if (ClientComms.this.isConnected()) {
                while (ClientComms.this.clientState.getActualInFlight() >= ClientComms.this.clientState.getMaxInFlight() - 1) {
                    Thread.yield();
                }
                ClientComms.log.fine("ClientComms", this.methodName, "510", new Object[]{bufferedMessage.getMessage().getKey()});
                ClientComms.this.internalSend(bufferedMessage.getMessage(), bufferedMessage.getToken());
                ClientComms.this.clientState.unPersistBufferedMessage(bufferedMessage.getMessage());
                return;
            }
            ClientComms.log.fine("ClientComms", this.methodName, "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public int getActualInFlight() {
        return this.clientState.getActualInFlight();
    }
}
