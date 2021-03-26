package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public interface IMqttToken {
    IMqttActionListener getActionCallback();

    IMqttAsyncClient getClient();

    MqttException getException();

    int[] getGrantedQos();

    int getMessageId();

    MqttWireMessage getResponse();

    boolean getSessionPresent();

    String[] getTopics();

    Object getUserContext();

    boolean isComplete();

    void setActionCallback(IMqttActionListener iMqttActionListener);

    void setUserContext(Object obj);

    void waitForCompletion() throws MqttException;

    void waitForCompletion(long j) throws MqttException;
}
