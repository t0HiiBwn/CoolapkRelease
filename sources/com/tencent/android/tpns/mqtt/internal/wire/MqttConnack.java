package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttConnack extends MqttAck {
    public static final String KEY = "Con";
    private int returnCode;
    private boolean sessionPresent;

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttConnack(byte b, byte[] bArr) throws IOException {
        super((byte) 2);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.sessionPresent = (dataInputStream.readUnsignedByte() & 1) != 1 ? false : true;
        this.returnCode = dataInputStream.readUnsignedByte();
        dataInputStream.close();
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttAck, com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        return super.toString() + " session present:" + this.sessionPresent + " return code: " + this.returnCode;
    }

    public boolean getSessionPresent() {
        return this.sessionPresent;
    }
}
