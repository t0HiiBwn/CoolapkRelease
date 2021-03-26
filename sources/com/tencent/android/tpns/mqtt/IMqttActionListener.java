package com.tencent.android.tpns.mqtt;

public interface IMqttActionListener {
    void onFailure(IMqttToken iMqttToken, Throwable th);

    void onSuccess(IMqttToken iMqttToken);
}
