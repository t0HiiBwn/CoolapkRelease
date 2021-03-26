package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttSuback extends MqttAck {
    private int[] grantedQos;

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    public MqttSuback(byte b, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        this.grantedQos = new int[(bArr.length - 2)];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.grantedQos[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttAck, com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int i = 0; i < this.grantedQos.length; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(this.grantedQos[i]);
        }
        return stringBuffer.toString();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }
}
