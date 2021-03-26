package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttTopic;

public interface DestinationProvider {
    MqttTopic getTopic(String str);
}
