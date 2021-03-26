package com.tencent.tpns.mqttchannel.api;

/* compiled from: ProGuard */
public enum MqttConnectState {
    DISCONNECTED(0),
    CONNECTED(1),
    CONNECTFAIL(2),
    CONNECTING(3),
    DISCONNECTING(4),
    SUBTOPICS(5),
    UNKOWN(10);
    
    private int a;

    private MqttConnectState(int i) {
        this.a = i;
    }

    public static MqttConnectState from(int i) {
        if (i == 0) {
            return DISCONNECTED;
        }
        if (i == 1) {
            return CONNECTED;
        }
        if (i == 2) {
            return CONNECTFAIL;
        }
        if (i == 3) {
            return CONNECTING;
        }
        if (i == 4) {
            return DISCONNECTING;
        }
        if (i != 5) {
            return UNKOWN;
        }
        return SUBTOPICS;
    }

    public int getType() {
        return this.a;
    }
}
