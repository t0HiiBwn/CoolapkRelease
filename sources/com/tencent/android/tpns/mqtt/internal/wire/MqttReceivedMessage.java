package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttMessage;

public class MqttReceivedMessage extends MqttMessage {
    public void setMessageId(int i) {
        super.setId(i);
    }

    public int getMessageId() {
        return super.getId();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttMessage
    public void setDuplicate(boolean z) {
        super.setDuplicate(z);
    }
}
