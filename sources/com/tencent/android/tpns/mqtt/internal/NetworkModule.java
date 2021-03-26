package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface NetworkModule {
    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    String getServerURI();

    void start() throws IOException, MqttException;

    void stop() throws IOException;
}
