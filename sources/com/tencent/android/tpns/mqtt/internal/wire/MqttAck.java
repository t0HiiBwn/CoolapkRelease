package com.tencent.android.tpns.mqtt.internal.wire;

public abstract class MqttAck extends MqttWireMessage {
    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte getMessageInfo() {
        return 0;
    }

    public MqttAck(byte b) {
        super(b);
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        return super.toString() + " msgId " + this.msgId;
    }
}
