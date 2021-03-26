package com.tencent.android.tpns.mqtt;

public interface MqttPersistable {
    byte[] getHeaderBytes() throws MqttPersistenceException;

    int getHeaderLength() throws MqttPersistenceException;

    int getHeaderOffset() throws MqttPersistenceException;

    byte[] getPayloadBytes() throws MqttPersistenceException;

    int getPayloadLength() throws MqttPersistenceException;

    int getPayloadOffset() throws MqttPersistenceException;
}
