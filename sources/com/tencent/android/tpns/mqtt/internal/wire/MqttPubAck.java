package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttPubAck extends MqttAck {
    public MqttPubAck(byte b, byte[] bArr) throws IOException {
        super((byte) 4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public MqttPubAck(MqttPublish mqttPublish) {
        super((byte) 4);
        this.msgId = mqttPublish.getMessageId();
    }

    public MqttPubAck(int i) {
        super((byte) 4);
        this.msgId = i;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }
}
