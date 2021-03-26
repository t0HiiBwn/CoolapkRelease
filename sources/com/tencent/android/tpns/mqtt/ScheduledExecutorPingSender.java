package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "ScheduledExecutorPingSender";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ScheduledExecutorPingSender");
    private String clientid;
    private ClientComms comms;
    private ScheduledExecutorService executorService;
    private ScheduledFuture scheduledFuture;

    public ScheduledExecutorPingSender(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            return;
        }
        throw new IllegalArgumentException("ExecutorService cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            this.clientid = clientComms.getClient().getClientId();
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void start() {
        log.fine("ScheduledExecutorPingSender", "start", "659", new Object[]{this.clientid});
        schedule(this.comms.getKeepAlive());
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void stop() {
        log.fine("ScheduledExecutorPingSender", "stop", "661", null);
        ScheduledFuture scheduledFuture2 = this.scheduledFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void schedule(long j) {
        this.scheduledFuture = this.executorService.schedule(new PingRunnable(), j, TimeUnit.MILLISECONDS);
    }

    private class PingRunnable implements Runnable {
        private static final String methodName = "PingTask.run";

        private PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
            ScheduledExecutorPingSender.log.fine("ScheduledExecutorPingSender", "PingTask.run", "660", new Object[]{new Long(System.currentTimeMillis())});
            ScheduledExecutorPingSender.this.comms.checkForActivity();
            Thread.currentThread().setName(name);
        }
    }
}
