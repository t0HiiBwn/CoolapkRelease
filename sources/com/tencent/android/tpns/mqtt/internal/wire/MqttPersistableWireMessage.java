package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;

public abstract class MqttPersistableWireMessage extends MqttWireMessage implements MqttPersistable {
    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getHeaderOffset() throws MqttPersistenceException {
        return 0;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getPayloadLength() throws MqttPersistenceException {
        return 0;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getPayloadOffset() throws MqttPersistenceException {
        return 0;
    }

    public MqttPersistableWireMessage(byte b) {
        super(b);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public byte[] getHeaderBytes() throws MqttPersistenceException {
        try {
            return getHeader();
        } catch (Throwable th) {
            throw new MqttPersistenceException(th.getCause());
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getHeaderLength() throws MqttPersistenceException {
        return getHeaderBytes().length;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public byte[] getPayloadBytes() throws MqttPersistenceException {
        try {
            return getPayload();
        } catch (Throwable th) {
            throw new MqttPersistenceException(th.getCause());
        }
    }
}
