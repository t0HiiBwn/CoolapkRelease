package com.tencent.android.tpns.mqtt;

public interface IMqttDeliveryToken extends IMqttToken {
    MqttMessage getMessage() throws MqttException;
}
