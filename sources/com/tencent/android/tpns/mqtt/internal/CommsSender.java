package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttOutputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CommsSender implements Runnable {
    private static final String CLASS_NAME = "CommsSender";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsSender");
    private ClientComms clientComms = null;
    private ClientState clientState = null;
    private Object lifecycle = new Object();
    private MqttOutputStream out;
    private boolean running = false;
    private final Semaphore runningSemaphore = new Semaphore(1);
    private Thread sendThread = null;
    private Future senderFuture;
    private String threadName;
    private CommsTokenStore tokenStore = null;

    public CommsSender(ClientComms clientComms2, ClientState clientState2, CommsTokenStore commsTokenStore, OutputStream outputStream) {
        this.out = new MqttOutputStream(clientState2, outputStream);
        this.clientComms = clientComms2;
        this.clientState = clientState2;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms2.getClient().getClientId());
        TBaseLogger.d("CommsSender", "init CommsSender");
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.senderFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.senderFuture;
            if (future != null) {
                future.cancel(true);
            }
            log.fine("CommsSender", "stop", "800");
            if (this.running) {
                this.running = false;
                if (!Thread.currentThread().equals(this.sendThread)) {
                    while (this.running) {
                        try {
                            this.clientState.notifyQueueLock();
                            this.runningSemaphore.tryAcquire(100, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException unused) {
                            semaphore = this.runningSemaphore;
                        } catch (Throwable th) {
                            this.runningSemaphore.release();
                            throw th;
                        }
                    }
                    semaphore = this.runningSemaphore;
                    semaphore.release();
                }
            }
            this.sendThread = null;
            log.fine("CommsSender", "stop", "801");
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        TBaseLogger.d("CommsSender", "Run loop sender messages to the server, threadName:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.sendThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            MqttWireMessage mqttWireMessage = null;
            while (this.running && this.out != null) {
                try {
                    try {
                        mqttWireMessage = this.clientState.get();
                        if (mqttWireMessage != null) {
                            TBaseLogger.i("CommsSender", "message:" + mqttWireMessage.toString());
                            if (mqttWireMessage instanceof MqttAck) {
                                this.out.write(mqttWireMessage);
                                this.out.flush();
                            } else {
                                MqttToken token = this.tokenStore.getToken(mqttWireMessage);
                                if (token != null) {
                                    synchronized (token) {
                                        this.out.write(mqttWireMessage);
                                        try {
                                            this.out.flush();
                                        } catch (IOException e) {
                                            if (!(mqttWireMessage instanceof MqttDisconnect)) {
                                                throw e;
                                            }
                                        }
                                        this.clientState.notifySent(mqttWireMessage);
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            log.fine("CommsSender", "run", "803");
                            this.running = false;
                        }
                    } catch (MqttException e2) {
                        handleRunException(mqttWireMessage, e2);
                    } catch (Exception e3) {
                        handleRunException(mqttWireMessage, e3);
                    }
                } catch (Throwable th) {
                    this.running = false;
                    this.runningSemaphore.release();
                    throw th;
                }
            }
            this.running = false;
            this.runningSemaphore.release();
            log.fine("CommsSender", "run", "805");
        } catch (InterruptedException unused) {
            this.running = false;
        }
    }

    private void handleRunException(MqttWireMessage mqttWireMessage, Exception exc) {
        MqttException mqttException;
        log.fine("CommsSender", "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        this.running = false;
        this.clientComms.shutdownConnection(null, mqttException);
    }
}
