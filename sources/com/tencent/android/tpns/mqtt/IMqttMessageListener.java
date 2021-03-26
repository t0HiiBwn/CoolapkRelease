package com.tencent.android.tpns.mqtt;

public interface IMqttMessageListener {
    void messageArrived(String str, MqttMessage mqttMessage) throws Exception;
}
