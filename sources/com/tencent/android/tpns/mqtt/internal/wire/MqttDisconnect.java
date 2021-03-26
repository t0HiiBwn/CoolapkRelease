package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttDisconnect extends MqttWireMessage {
    public static final String KEY = "Disc";

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return "Disc";
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

    public MqttDisconnect() {
        super((byte) 14);
    }

    public MqttDisconnect(byte b, byte[] bArr) throws IOException {
        super((byte) 14);
    }
}
