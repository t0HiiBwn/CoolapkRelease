package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttInputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsReceiver implements Runnable {
    private static final String CLASS_NAME = "CommsReceiver";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsReceiver");
    private ClientComms clientComms = null;
    private ClientState clientState = null;
    private MqttInputStream in;
    private Object lifecycle = new Object();
    private Thread recThread = null;
    private Future receiverFuture;
    private volatile boolean receiving;
    private boolean running = false;
    private final Semaphore runningSemaphore = new Semaphore(1);
    private String threadName;
    private CommsTokenStore tokenStore = null;

    public CommsReceiver(ClientComms clientComms2, ClientState clientState2, CommsTokenStore commsTokenStore, InputStream inputStream) {
        this.in = new MqttInputStream(clientState2, inputStream);
        this.clientComms = clientComms2;
        this.clientState = clientState2;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms2.getClient().getClientId());
        TBaseLogger.d("CommsReceiver", "init CommsReceiver");
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        log.fine("CommsReceiver", "start", "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.receiverFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.receiverFuture;
            if (future != null) {
                future.cancel(true);
            }
            log.fine("CommsReceiver", "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                if (!Thread.currentThread().equals(this.recThread)) {
                    try {
                        this.runningSemaphore.acquire();
                        semaphore = this.runningSemaphore;
                    } catch (InterruptedException unused) {
                        semaphore = this.runningSemaphore;
                    } catch (Throwable th) {
                        this.runningSemaphore.release();
                        throw th;
                    }
                    semaphore.release();
                }
            }
        }
        this.recThread = null;
        log.fine("CommsReceiver", "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        TBaseLogger.d("CommsReceiver", "Run loop to receive messages from the server, threadName:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.recThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            MqttToken mqttToken = null;
            while (this.running && this.in != null) {
                try {
                    Logger logger = log;
                    logger.fine("CommsReceiver", "run", "852");
                    this.receiving = this.in.available() > 0;
                    MqttWireMessage readMqttWireMessage = this.in.readMqttWireMessage();
                    this.receiving = false;
                    if (readMqttWireMessage != null) {
                        TBaseLogger.i("CommsReceiver", readMqttWireMessage.toString());
                    }
                    if (readMqttWireMessage instanceof MqttAck) {
                        mqttToken = this.tokenStore.getToken(readMqttWireMessage);
                        if (mqttToken != null) {
                            synchronized (mqttToken) {
                                this.clientState.notifyReceivedAck((MqttAck) readMqttWireMessage);
                            }
                        } else if ((readMqttWireMessage instanceof MqttPubRec) || (readMqttWireMessage instanceof MqttPubComp) || (readMqttWireMessage instanceof MqttPubAck)) {
                            logger.fine("CommsReceiver", "run", "857");
                        } else {
                            throw new MqttException(6);
                        }
                    } else if (readMqttWireMessage != null) {
                        this.clientState.notifyReceivedMsg(readMqttWireMessage);
                    }
                } catch (MqttException e) {
                    TBaseLogger.e("CommsReceiver", "run", e);
                    this.running = false;
                    this.clientComms.shutdownConnection(mqttToken, e);
                } catch (IOException e2) {
                    log.fine("CommsReceiver", "run", "853");
                    this.running = false;
                    if (!this.clientComms.isDisconnecting()) {
                        this.clientComms.shutdownConnection(mqttToken, new MqttException(32109, e2));
                    }
                } catch (Throwable th) {
                    this.receiving = false;
                    this.runningSemaphore.release();
                    throw th;
                }
                this.receiving = false;
                this.runningSemaphore.release();
            }
            log.fine("CommsReceiver", "run", "854");
        } catch (InterruptedException unused) {
            this.running = false;
        }
    }

    public boolean isRunning() {
        return this.running;
    }

    public boolean isReceiving() {
        return this.receiving;
    }
}
