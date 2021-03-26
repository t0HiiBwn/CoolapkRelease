package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import java.util.concurrent.ScheduledExecutorService;

public class MqttClient implements IMqttClient {
    protected MqttAsyncClient aClient;
    protected long timeToWait;

    public MqttClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public MqttClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this.aClient = null;
        this.timeToWait = -1;
        this.aClient = new MqttAsyncClient(str, str2, mqttClientPersistence);
    }

    public MqttClient(String str, String str2, MqttClientPersistence mqttClientPersistence, ScheduledExecutorService scheduledExecutorService) throws MqttException {
        this.aClient = null;
        this.timeToWait = -1;
        this.aClient = new MqttAsyncClient(str, str2, mqttClientPersistence, new ScheduledExecutorPingSender(scheduledExecutorService), scheduledExecutorService);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void connect() throws MqttSecurityException, MqttException {
        connect(new MqttConnectOptions());
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void connect(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException {
        this.aClient.connect(mqttConnectOptions, null, null).waitForCompletion(getTimeToWait());
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken connectWithResult(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException {
        IMqttToken connect = this.aClient.connect(mqttConnectOptions, null, null);
        connect.waitForCompletion(getTimeToWait());
        return connect;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void disconnect() throws MqttException {
        this.aClient.disconnect().waitForCompletion();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void disconnect(long j) throws MqttException {
        this.aClient.disconnect(j, null, null).waitForCompletion();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void disconnectForcibly() throws MqttException {
        this.aClient.disconnectForcibly();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void disconnectForcibly(long j) throws MqttException {
        this.aClient.disconnectForcibly(j);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void disconnectForcibly(long j, long j2) throws MqttException {
        this.aClient.disconnectForcibly(j, j2);
    }

    public void disconnectForcibly(long j, long j2, boolean z) throws MqttException {
        this.aClient.disconnectForcibly(j, j2, z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String str) throws MqttException {
        subscribe(new String[]{str}, new int[]{1});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String[] strArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        subscribe(strArr, iArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String str, int i) throws MqttException {
        subscribe(new String[]{str}, new int[]{i});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String[] strArr, int[] iArr) throws MqttException {
        IMqttToken subscribe = this.aClient.subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
        subscribe.waitForCompletion(getTimeToWait());
        int[] grantedQos = subscribe.getGrantedQos();
        for (int i = 0; i < grantedQos.length; i++) {
            iArr[i] = grantedQos[i];
        }
        if (grantedQos.length == 1 && iArr[0] == 128) {
            throw new MqttException(128);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String str, IMqttMessageListener iMqttMessageListener) throws MqttException {
        subscribe(new String[]{str}, new int[]{1}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        subscribe(strArr, iArr, iMqttMessageListenerArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String str, int i, IMqttMessageListener iMqttMessageListener) throws MqttException {
        subscribe(new String[]{str}, new int[]{i}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        subscribe(strArr, iArr);
        for (int i = 0; i < strArr.length; i++) {
            this.aClient.comms.setMessageListener(strArr[i], iMqttMessageListenerArr[i]);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String str) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{1});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String str, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{1}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String str, int i) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{i});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String str, int i, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{i}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String[] strArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        return subscribeWithResponse(strArr, iArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        return subscribeWithResponse(strArr, iArr, iMqttMessageListenerArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String[] strArr, int[] iArr) throws MqttException {
        IMqttToken subscribe = this.aClient.subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
        subscribe.waitForCompletion(getTimeToWait());
        return subscribe;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttToken subscribeWithResponse(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        IMqttToken subscribeWithResponse = subscribeWithResponse(strArr, iArr);
        for (int i = 0; i < strArr.length; i++) {
            this.aClient.comms.setMessageListener(strArr[i], iMqttMessageListenerArr[i]);
        }
        return subscribeWithResponse;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void unsubscribe(String str) throws MqttException {
        unsubscribe(new String[]{str});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void unsubscribe(String[] strArr) throws MqttException {
        this.aClient.unsubscribe(strArr, (Object) null, (IMqttActionListener) null).waitForCompletion(getTimeToWait());
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i);
        mqttMessage.setRetained(z);
        publish(str, mqttMessage);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        this.aClient.publish(str, mqttMessage, (Object) null, (IMqttActionListener) null).waitForCompletion(getTimeToWait());
    }

    public void setTimeToWait(long j) throws IllegalArgumentException {
        if (j >= -1) {
            this.timeToWait = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    public long getTimeToWait() {
        return this.timeToWait;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void close() throws MqttException {
        this.aClient.close(false);
    }

    public void close(boolean z) throws MqttException {
        this.aClient.close(z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public String getClientId() {
        return this.aClient.getClientId();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.aClient.getPendingDeliveryTokens();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public String getServerURI() {
        return this.aClient.getServerURI();
    }

    public String getCurrentServerURI() {
        return this.aClient.getCurrentServerURI();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public MqttTopic getTopic(String str) {
        return this.aClient.getTopic(str);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public boolean isConnected() {
        return this.aClient.isConnected();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void setCallback(MqttCallback mqttCallback) {
        this.aClient.setCallback(mqttCallback);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void setManualAcks(boolean z) {
        this.aClient.setManualAcks(z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttClient
    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.aClient.messageArrivedComplete(i, i2);
    }

    public static String generateClientId() {
        return MqttAsyncClient.generateClientId();
    }

    public void reconnect() throws MqttException {
        this.aClient.reconnect();
    }

    public Debug getDebug() {
        return this.aClient.getDebug();
    }
}
