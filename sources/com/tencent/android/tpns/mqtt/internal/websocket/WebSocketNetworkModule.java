package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.SocketFactory;

public class WebSocketNetworkModule extends TCPNetworkModule {
    private static final String CLASS_NAME = "WebSocketNetworkModule";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "WebSocketNetworkModule");
    private String host;
    private ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
    private PipedInputStream pipedInputStream;
    private int port;
    ByteBuffer recievedPayload;
    private String uri;
    private WebSocketReceiver webSocketReceiver;

    public WebSocketNetworkModule(SocketFactory socketFactory, String str, String str2, int i, String str3) {
        super(socketFactory, str2, i, str3);
        this.uri = str;
        this.host = str2;
        this.port = i;
        this.pipedInputStream = new PipedInputStream();
        log.setResourceName(str3);
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void start() throws IOException, MqttException {
        super.start();
        new WebSocketHandshake(getSocketInputStream(), getSocketOutputStream(), this.uri, this.host, this.port).execute();
        WebSocketReceiver webSocketReceiver2 = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
        this.webSocketReceiver = webSocketReceiver2;
        webSocketReceiver2.start("webSocketReceiver");
    }

    OutputStream getSocketOutputStream() throws IOException {
        return super.getOutputStream();
    }

    InputStream getSocketInputStream() throws IOException {
        return super.getInputStream();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public InputStream getInputStream() throws IOException {
        return this.pipedInputStream;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public OutputStream getOutputStream() throws IOException {
        return this.outputStream;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void stop() throws IOException {
        getSocketOutputStream().write(new WebSocketFrame((byte) 8, true, "1000".getBytes()).encodeFrame());
        getSocketOutputStream().flush();
        WebSocketReceiver webSocketReceiver2 = this.webSocketReceiver;
        if (webSocketReceiver2 != null) {
            webSocketReceiver2.stop();
        }
        super.stop();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public String getServerURI() {
        return "ws://" + this.host + ":" + this.port;
    }
}
