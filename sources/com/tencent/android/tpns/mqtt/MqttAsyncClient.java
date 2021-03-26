package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.ConnectActionListener;
import com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.internal.NetworkModule;
import com.tencent.android.tpns.mqtt.internal.SSLNetworkModule;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketNetworkModule;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketSecureNetworkModule;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpns.mqtt.persist.MemoryPersistence;
import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class MqttAsyncClient implements IMqttAsyncClient {
    private static final String CLASS_NAME = "MqttAsyncClient";
    private static final String CLIENT_ID_PREFIX = "paho";
    private static final long DISCONNECT_TIMEOUT = 10000;
    private static final char MAX_HIGH_SURROGATE = 56319;
    private static final char MIN_HIGH_SURROGATE = 55296;
    private static final long QUIESCE_TIMEOUT = 30000;
    private static final String TAG = "MqttAsyncClient";
    private static Object clientLock = new Object();
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "MqttAsyncClient");
    private static int reconnectDelay = 1000;
    private String clientId;
    protected ClientComms comms;
    private MqttConnectOptions connOpts;
    private ScheduledExecutorService executorService;
    private MqttCallback mqttCallback;
    private MqttClientPersistence persistence;
    private Timer reconnectTimer;
    private boolean reconnecting;
    private String serverURI;
    private Hashtable topics;
    private Object userContext;

    protected static boolean Character_isHighSurrogate(char c) {
        return c >= 55296 && c <= 56319;
    }

    public MqttAsyncClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this(str, str2, mqttClientPersistence, new TimerPingSender());
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender) throws MqttException {
        this(str, str2, mqttClientPersistence, mqttPingSender, null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ScheduledExecutorService scheduledExecutorService) throws MqttException {
        this.reconnecting = false;
        TBaseLogger.d("MqttAsyncClient", "init MqttAsyncClient");
        log.setResourceName(str2);
        if (str2 != null) {
            int i = 0;
            int i2 = 0;
            while (i < str2.length() - 1) {
                if (Character_isHighSurrogate(str2.charAt(i))) {
                    i++;
                }
                i2++;
                i++;
            }
            if (i2 <= 65535) {
                MqttConnectOptions.validateURI(str);
                this.serverURI = str;
                this.clientId = str2;
                this.persistence = mqttClientPersistence;
                if (mqttClientPersistence == null) {
                    this.persistence = new MemoryPersistence();
                }
                this.executorService = scheduledExecutorService;
                if (scheduledExecutorService == null) {
                    this.executorService = Executors.newScheduledThreadPool(10);
                }
                log.fine("MqttAsyncClient", "MqttAsyncClient", "101", new Object[]{str2, str, mqttClientPersistence});
                this.persistence.open(str2, str);
                this.comms = new ClientComms(this, this.persistence, mqttPingSender, this.executorService);
                this.persistence.close();
                this.topics = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    protected NetworkModule[] createNetworkModules(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        log.fine("MqttAsyncClient", "createNetworkModules", "116", new Object[]{str});
        String[] serverURIs = mqttConnectOptions.getServerURIs();
        if (serverURIs == null) {
            serverURIs = new String[]{str};
        } else if (serverURIs.length == 0) {
            serverURIs = new String[]{str};
        }
        NetworkModule[] networkModuleArr = new NetworkModule[serverURIs.length];
        for (int i = 0; i < serverURIs.length; i++) {
            networkModuleArr[i] = createNetworkModule(serverURIs[i], mqttConnectOptions);
        }
        log.fine("MqttAsyncClient", "createNetworkModules", "108");
        return networkModuleArr;
    }

    private NetworkModule createNetworkModule(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        SSLSocketFactoryFactory sSLSocketFactoryFactory;
        String[] enabledCipherSuites;
        SSLSocketFactoryFactory sSLSocketFactoryFactory2;
        String[] enabledCipherSuites2;
        Logger logger = log;
        logger.fine("MqttAsyncClient", "createNetworkModule", "115", new Object[]{str});
        SocketFactory socketFactory = mqttConnectOptions.getSocketFactory();
        int validateURI = MqttConnectOptions.validateURI(str);
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null && str.contains("_")) {
                try {
                    Field declaredField = URI.class.getDeclaredField("host");
                    declaredField.setAccessible(true);
                    declaredField.set(uri, getHostName(str.substring(uri.getScheme().length() + 3)));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                    throw ExceptionHelper.createMqttException(e.getCause());
                }
            }
            String host = uri.getHost();
            int port = uri.getPort();
            if (validateURI == 0) {
                if (port == -1) {
                    port = 1883;
                }
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                TCPNetworkModule tCPNetworkModule = new TCPNetworkModule(socketFactory, host, port, this.clientId);
                tCPNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return tCPNetworkModule;
            } else if (validateURI == 1) {
                if (port == -1) {
                    port = 8883;
                }
                if (socketFactory == null) {
                    sSLSocketFactoryFactory = new SSLSocketFactoryFactory();
                    Properties sSLProperties = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties != null) {
                        sSLSocketFactoryFactory.initialize(sSLProperties, null);
                    }
                    socketFactory = sSLSocketFactoryFactory.createSocketFactory(null);
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                SSLNetworkModule sSLNetworkModule = new SSLNetworkModule((SSLSocketFactory) socketFactory, host, port, this.clientId);
                SSLNetworkModule sSLNetworkModule2 = sSLNetworkModule;
                sSLNetworkModule2.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                sSLNetworkModule2.setSSLHostnameVerifier(mqttConnectOptions.getSSLHostnameVerifier());
                if (!(sSLSocketFactoryFactory == null || (enabledCipherSuites = sSLSocketFactoryFactory.getEnabledCipherSuites(null)) == null)) {
                    sSLNetworkModule2.setEnabledCiphers(enabledCipherSuites);
                }
                return sSLNetworkModule;
            } else if (validateURI == 3) {
                int i = port == -1 ? 80 : port;
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketNetworkModule webSocketNetworkModule = new WebSocketNetworkModule(socketFactory, str, host, i, this.clientId);
                webSocketNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return webSocketNetworkModule;
            } else if (validateURI != 4) {
                logger.fine("MqttAsyncClient", "createNetworkModule", "119", new Object[]{str});
                return null;
            } else {
                int i2 = port == -1 ? 443 : port;
                if (socketFactory == null) {
                    SSLSocketFactoryFactory sSLSocketFactoryFactory3 = new SSLSocketFactoryFactory();
                    Properties sSLProperties2 = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties2 != null) {
                        sSLSocketFactoryFactory3.initialize(sSLProperties2, null);
                    }
                    socketFactory = sSLSocketFactoryFactory3.createSocketFactory(null);
                    sSLSocketFactoryFactory2 = sSLSocketFactoryFactory3;
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory2 = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketSecureNetworkModule webSocketSecureNetworkModule = new WebSocketSecureNetworkModule((SSLSocketFactory) socketFactory, str, host, i2, this.clientId);
                webSocketSecureNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                if (!(sSLSocketFactoryFactory2 == null || (enabledCipherSuites2 = sSLSocketFactoryFactory2.getEnabledCipherSuites(null)) == null)) {
                    webSocketSecureNetworkModule.setEnabledCiphers(enabledCipherSuites2);
                }
                return webSocketSecureNetworkModule;
            }
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Malformed URI: " + str + ", " + e2.getMessage());
        }
    }

    private String getHostName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        return connect(new MqttConnectOptions(), obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect() throws MqttException, MqttSecurityException {
        return connect(null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        return connect(mqttConnectOptions, null, null);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006e: APUT  (r1v1 java.lang.Object[]), (4 ??[int, float, short, byte, char]), (r3v4 java.lang.String) */
    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            if (mqttConnectOptions == null) {
                mqttConnectOptions = new MqttConnectOptions();
            }
            this.connOpts = mqttConnectOptions;
            this.userContext = obj;
            boolean isAutomaticReconnect = mqttConnectOptions.isAutomaticReconnect();
            Logger logger = log;
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(mqttConnectOptions.isCleanSession());
            objArr[1] = new Integer(mqttConnectOptions.getConnectionTimeout());
            objArr[2] = new Integer(mqttConnectOptions.getKeepAliveInterval());
            objArr[3] = mqttConnectOptions.getUserName();
            String str = "[null]";
            objArr[4] = mqttConnectOptions.getPassword() == null ? str : "[notnull]";
            if (mqttConnectOptions.getWillMessage() != null) {
                str = "[notnull]";
            }
            objArr[5] = str;
            objArr[6] = obj;
            objArr[7] = iMqttActionListener;
            logger.fine("MqttAsyncClient", "connect", "103", objArr);
            this.comms.setNetworkModules(createNetworkModules(this.serverURI, mqttConnectOptions));
            this.comms.setReconnectCallback(new MqttReconnectCallback(isAutomaticReconnect));
            MqttToken mqttToken = new MqttToken(getClientId());
            ConnectActionListener connectActionListener = new ConnectActionListener(this, this.persistence, this.comms, mqttConnectOptions, mqttToken, obj, iMqttActionListener, this.reconnecting);
            mqttToken.setActionCallback(connectActionListener);
            mqttToken.setUserContext(this);
            MqttCallback mqttCallback2 = this.mqttCallback;
            if (mqttCallback2 instanceof MqttCallbackExtended) {
                connectActionListener.setMqttCallbackExtended((MqttCallbackExtended) mqttCallback2);
            }
            this.comms.setNetworkModuleIndex(0);
            connectActionListener.connect();
            return mqttToken;
        } else {
            throw new MqttException(32111);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return disconnect(30000, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect() throws MqttException {
        return disconnect(null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(long j) throws MqttException {
        return disconnect(j, null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(long j, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        this.comms.disconnect(new MqttDisconnect(), j, mqttToken);
        log.fine("MqttAsyncClient", "disconnect", "108");
        return mqttToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(30000, 10000);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly(long j) throws MqttException {
        disconnectForcibly(30000, j);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly(long j, long j2) throws MqttException {
        this.comms.disconnectForcibly(j, j2);
    }

    public void disconnectForcibly(long j, long j2, boolean z) throws MqttException {
        this.comms.disconnectForcibly(j, j2, z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public boolean isConnected() {
        return this.comms.isConnected();
    }

    public boolean isConnecting() {
        return this.comms.isConnecting();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public String getClientId() {
        return this.clientId;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public String getServerURI() {
        return this.serverURI;
    }

    public String getCurrentServerURI() {
        return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
    }

    protected MqttTopic getTopic(String str) {
        MqttTopic.validate(str, false);
        MqttTopic mqttTopic = (MqttTopic) this.topics.get(str);
        if (mqttTopic != null) {
            return mqttTopic;
        }
        MqttTopic mqttTopic2 = new MqttTopic(str, this.comms);
        this.topics.put(str, mqttTopic2);
        return mqttTopic2;
    }

    public IMqttToken checkPing(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        log.fine("MqttAsyncClient", "ping", "117");
        return null;
    }

    public MqttToken ping(IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        this.comms.sendNoWait(new MqttPingReq(), mqttToken);
        return mqttToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        TBaseLogger.d("MqttAsyncClient", "action - subscribe");
        if (strArr.length == iArr.length) {
            for (String str : strArr) {
                this.comms.removeMessageListener(str);
            }
            if (log.isLoggable(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i]);
                    MqttTopic.validate(strArr[i], true);
                }
                log.fine("MqttAsyncClient", "subscribe", "106", new Object[]{stringBuffer.toString(), obj, iMqttActionListener});
            }
            MqttToken mqttToken = new MqttToken(getClientId());
            mqttToken.setActionCallback(iMqttActionListener);
            mqttToken.setUserContext(obj);
            mqttToken.internalTok.setTopics(strArr);
            this.comms.sendNoWait(new MqttSubscribe(strArr, iArr), mqttToken);
            log.fine("MqttAsyncClient", "subscribe", "109");
            return mqttToken;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, iMqttActionListener, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (IMqttActionListener) null, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null, iMqttMessageListenerArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        if (iMqttMessageListenerArr.length == iArr.length && iArr.length == strArr.length) {
            IMqttToken subscribe = subscribe(strArr, iArr, obj, iMqttActionListener);
            for (int i = 0; i < strArr.length; i++) {
                this.comms.setMessageListener(strArr[i], iMqttMessageListenerArr[i]);
            }
            return subscribe;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return unsubscribe(new String[]{str}, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String str) throws MqttException {
        return unsubscribe(new String[]{str}, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        if (log.isLoggable(5)) {
            String str = "";
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    str = str + ", ";
                }
                str = str + strArr[i];
            }
            log.fine("MqttAsyncClient", "unsubscribe", "107", new Object[]{str, obj, iMqttActionListener});
        }
        for (String str2 : strArr) {
            MqttTopic.validate(str2, true);
        }
        for (String str3 : strArr) {
            this.comms.removeMessageListener(str3);
        }
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        mqttToken.internalTok.setTopics(strArr);
        this.comms.sendNoWait(new MqttUnsubscribe(strArr), mqttToken);
        log.fine("MqttAsyncClient", "unsubscribe", "110");
        return mqttToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
        this.comms.setCallback(mqttCallback2);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void setManualAcks(boolean z) {
        this.comms.setManualAcks(z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.comms.messageArrivedComplete(i, i2);
    }

    public static String generateClientId() {
        return "paho" + System.nanoTime();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.comms.getPendingDeliveryTokens();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i);
        mqttMessage.setRetained(z);
        return publish(str, mqttMessage, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i, z, null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        return publish(str, mqttMessage, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "publish", "111", new Object[]{str, obj, iMqttActionListener});
        MqttTopic.validate(str, false);
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(getClientId());
        mqttDeliveryToken.setActionCallback(iMqttActionListener);
        mqttDeliveryToken.setUserContext(obj);
        mqttDeliveryToken.setMessage(mqttMessage);
        mqttDeliveryToken.internalTok.setTopics(new String[]{str});
        MqttPublish mqttPublish = new MqttPublish(str, mqttMessage);
        TBaseLogger.d("MqttAsyncClient", "action - publish, message is MqttPublish");
        this.comms.sendNoWait(mqttPublish, mqttDeliveryToken);
        logger.fine("MqttAsyncClient", "publish", "112");
        return mqttDeliveryToken;
    }

    public void reconnect() throws MqttException {
        log.fine("MqttAsyncClient", "reconnect", "500", new Object[]{this.clientId});
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            stopReconnectCycle();
            attemptReconnect();
        } else {
            throw new MqttException(32111);
        }
    }

    /* access modifiers changed from: private */
    public void attemptReconnect() {
        log.fine("MqttAsyncClient", "attemptReconnect", "500", new Object[]{this.clientId});
        try {
            connect(this.connOpts, this.userContext, new MqttReconnectActionListener("attemptReconnect"));
        } catch (MqttSecurityException e) {
            log.fine("MqttAsyncClient", "attemptReconnect", "804", null, e);
        } catch (MqttException e2) {
            TBaseLogger.e("MqttAsyncClient", "attemptReconnect", e2);
        }
    }

    /* access modifiers changed from: private */
    public void startReconnectCycle() {
        log.fine("MqttAsyncClient", "startReconnectCycle", "503", new Object[]{this.clientId, new Long((long) reconnectDelay)});
        Timer timer = new Timer("MQTT Reconnect: " + this.clientId);
        this.reconnectTimer = timer;
        timer.schedule(new ReconnectTask(), (long) reconnectDelay);
    }

    /* access modifiers changed from: private */
    public void stopReconnectCycle() {
        log.fine("MqttAsyncClient", "stopReconnectCycle", "504", new Object[]{this.clientId});
        synchronized (clientLock) {
            if (this.connOpts.isAutomaticReconnect()) {
                Timer timer = this.reconnectTimer;
                if (timer != null) {
                    timer.cancel();
                    this.reconnectTimer = null;
                }
                reconnectDelay = 1000;
            }
        }
    }

    private class ReconnectTask extends TimerTask {
        private static final String methodName = "ReconnectTask.run";

        private ReconnectTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MqttAsyncClient.log.fine("MqttAsyncClient", "ReconnectTask.run", "506");
            MqttAsyncClient.this.attemptReconnect();
        }
    }

    class MqttReconnectCallback implements MqttCallbackExtended {
        final boolean automaticReconnect;

        @Override // com.tencent.android.tpns.mqtt.MqttCallbackExtended
        public void connectComplete(boolean z, String str) {
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        }

        MqttReconnectCallback(boolean z) {
            this.automaticReconnect = z;
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void connectionLost(Throwable th) {
            if (this.automaticReconnect) {
                MqttAsyncClient.this.comms.setRestingState(true);
                MqttAsyncClient.this.reconnecting = true;
                MqttAsyncClient.this.startReconnectCycle();
            }
        }
    }

    class MqttReconnectActionListener implements IMqttActionListener {
        final String methodName;

        MqttReconnectActionListener(String str) {
            this.methodName = str;
        }

        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
        public void onSuccess(IMqttToken iMqttToken) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "501", new Object[]{iMqttToken.getClient().getClientId()});
            MqttAsyncClient.this.comms.setRestingState(false);
            MqttAsyncClient.this.stopReconnectCycle();
        }

        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "502", new Object[]{iMqttToken.getClient().getClientId()});
            if (MqttAsyncClient.reconnectDelay < 128000) {
                MqttAsyncClient.reconnectDelay *= 2;
            }
            rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
        }

        private void rescheduleReconnectCycle(int i) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName + ":rescheduleReconnectCycle", "505", new Object[]{MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay)});
            synchronized (MqttAsyncClient.clientLock) {
                if (MqttAsyncClient.this.connOpts.isAutomaticReconnect()) {
                    if (MqttAsyncClient.this.reconnectTimer != null) {
                        MqttAsyncClient.this.reconnectTimer.schedule(new ReconnectTask(), (long) i);
                    } else {
                        int unused = MqttAsyncClient.reconnectDelay = i;
                        MqttAsyncClient.this.startReconnectCycle();
                    }
                }
            }
        }
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(disconnectedBufferOptions));
    }

    public int getBufferedMessageCount() {
        return this.comms.getBufferedMessageCount();
    }

    public MqttMessage getBufferedMessage(int i) {
        return this.comms.getBufferedMessage(i);
    }

    public void deleteBufferedMessage(int i) {
        this.comms.deleteBufferedMessage(i);
    }

    public int getInFlightMessageCount() {
        return this.comms.getActualInFlight();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void close() throws MqttException {
        close(false);
    }

    public void destroy() throws MqttException {
        close(true);
    }

    public void close(boolean z) throws MqttException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "close", "113");
        this.comms.close(z);
        logger.fine("MqttAsyncClient", "close", "114");
    }

    public Debug getDebug() {
        return new Debug(this.clientId, this.comms);
    }
}
