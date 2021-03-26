package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public class BufferedMessage {
    private MqttWireMessage message;
    private MqttToken token;

    public BufferedMessage(MqttWireMessage mqttWireMessage, MqttToken mqttToken) {
        this.message = mqttWireMessage;
        this.token = mqttToken;
    }

    public MqttWireMessage getMessage() {
        return this.message;
    }

    public MqttToken getToken() {
        return this.token;
    }
}
