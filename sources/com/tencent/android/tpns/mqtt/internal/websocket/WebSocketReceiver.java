package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WebSocketReceiver implements Runnable {
    private static final String CLASS_NAME = "WebSocketReceiver";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "WebSocketReceiver");
    private InputStream input;
    private Object lifecycle = new Object();
    private PipedOutputStream pipedOutputStream;
    private Thread receiverThread = null;
    private volatile boolean receiving;
    private boolean running = false;
    private boolean stopping = false;

    public WebSocketReceiver(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.input = inputStream;
        PipedOutputStream pipedOutputStream2 = new PipedOutputStream();
        this.pipedOutputStream = pipedOutputStream2;
        pipedInputStream.connect(pipedOutputStream2);
    }

    public void start(String str) {
        log.fine("WebSocketReceiver", "start", "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                Thread thread = new Thread(this, str);
                this.receiverThread = thread;
                thread.start();
            }
        }
    }

    public void stop() {
        boolean z = true;
        this.stopping = true;
        synchronized (this.lifecycle) {
            log.fine("WebSocketReceiver", "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                closeOutputStream();
            } else {
                z = false;
            }
        }
        if (z && !Thread.currentThread().equals(this.receiverThread)) {
            try {
                this.receiverThread.join();
            } catch (InterruptedException unused) {
            }
        }
        this.receiverThread = null;
        log.fine("WebSocketReceiver", "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.running && this.input != null) {
            try {
                log.fine("WebSocketReceiver", "run", "852");
                this.receiving = this.input.available() > 0;
                WebSocketFrame webSocketFrame = new WebSocketFrame(this.input);
                if (!webSocketFrame.isCloseFlag()) {
                    for (int i = 0; i < webSocketFrame.getPayload().length; i++) {
                        this.pipedOutputStream.write(webSocketFrame.getPayload()[i]);
                    }
                    this.pipedOutputStream.flush();
                } else if (!this.stopping) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                }
                this.receiving = false;
            } catch (IOException unused) {
                stop();
            }
        }
    }

    private void closeOutputStream() {
        try {
            this.pipedOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public boolean isRunning() {
        return this.running;
    }

    public boolean isReceiving() {
        return this.receiving;
    }
}
