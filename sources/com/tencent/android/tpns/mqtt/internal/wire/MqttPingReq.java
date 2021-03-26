package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttPingReq extends MqttWireMessage {
    public static final String KEY = "Ping";

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return "Ping";
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte getMessageInfo() {
        return 0;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttPingReq() {
        super((byte) 12);
    }

    public MqttPingReq(byte b, byte[] bArr) throws IOException {
        super((byte) 12);
    }
}
