package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "TimerPingSender";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "TimerPingSender");
    private ClientComms comms;
    private Timer timer;

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void start() {
        String clientId = this.comms.getClient().getClientId();
        log.fine("TimerPingSender", "start", "659", new Object[]{clientId});
        Timer timer2 = new Timer("MQTT Ping: " + clientId);
        this.timer = timer2;
        timer2.schedule(new PingTask(), this.comms.getKeepAlive());
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void stop() {
        log.fine("TimerPingSender", "stop", "661", null);
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void schedule(long j) {
        this.timer.schedule(new PingTask(), j);
    }

    private class PingTask extends TimerTask {
        private static final String methodName = "PingTask.run";

        private PingTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            TimerPingSender.log.fine("TimerPingSender", "PingTask.run", "660", new Object[]{new Long(System.currentTimeMillis())});
            TimerPingSender.this.comms.checkForActivity();
        }
    }
}
