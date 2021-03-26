package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import java.util.Enumeration;
import java.util.Hashtable;

public class MemoryPersistence implements MqttClientPersistence {
    private Hashtable data;

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void close() throws MqttPersistenceException {
        this.data.clear();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public Enumeration keys() throws MqttPersistenceException {
        return this.data.keys();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public MqttPersistable get(String str) throws MqttPersistenceException {
        return (MqttPersistable) this.data.get(str);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void open(String str, String str2) throws MqttPersistenceException {
        this.data = new Hashtable();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void put(String str, MqttPersistable mqttPersistable) throws MqttPersistenceException {
        this.data.put(str, mqttPersistable);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void remove(String str) throws MqttPersistenceException {
        this.data.remove(str);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void clear() throws MqttPersistenceException {
        this.data.clear();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public boolean containsKey(String str) throws MqttPersistenceException {
        return this.data.containsKey(str);
    }
}
