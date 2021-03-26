package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.a.c;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class MqttChannel implements IMqttChannel {
    private static MqttChannel a;
    private c b;

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void bindAccount(String str, OnMqttCallback onMqttCallback) {
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unBindAccount(OnMqttCallback onMqttCallback) {
    }

    private MqttChannel(Context context) {
        this.b = new c(context);
    }

    public static synchronized MqttChannel getInstance(Context context) {
        MqttChannel mqttChannel;
        synchronized (MqttChannel.class) {
            if (a == null) {
                a = new MqttChannel(context);
            }
            mqttChannel = a;
        }
        return mqttChannel;
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void startConnect(OnMqttCallback onMqttCallback) {
        this.b.startConnect(onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void ping(OnMqttCallback onMqttCallback) {
        this.b.ping(onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void stopConnect(OnMqttCallback onMqttCallback) {
        this.b.stopConnect(onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void getConnectState(OnMqttCallback onMqttCallback) {
        this.b.getConnectState(onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendRequest(String str, JSONObject jSONObject, OnMqttCallback onMqttCallback) {
        this.b.sendRequest(str, jSONObject, onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendPublishData(String str, String str2, OnMqttCallback onMqttCallback) {
        this.b.sendPublishData(str, str2, onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void subscrbie(String str, OnMqttCallback onMqttCallback) {
        this.b.subscrbie(str, onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unSubscrbie(String str, OnMqttCallback onMqttCallback) {
        this.b.unSubscrbie(str, onMqttCallback);
    }
}
