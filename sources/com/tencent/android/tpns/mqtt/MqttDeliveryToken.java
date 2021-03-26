package com.tencent.android.tpns.mqtt;

public class MqttDeliveryToken extends MqttToken implements IMqttDeliveryToken {
    public MqttDeliveryToken() {
    }

    public MqttDeliveryToken(String str) {
        super(str);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttDeliveryToken
    public MqttMessage getMessage() throws MqttException {
        return this.internalTok.getMessage();
    }

    protected void setMessage(MqttMessage mqttMessage) {
        this.internalTok.setMessage(mqttMessage);
    }
}
