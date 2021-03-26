package com.tencent.android.tpush.stat.event;

/* compiled from: ProGuard */
public enum EventType {
    PAGE_VIEW(1),
    LAUNCH(2),
    SESSION_ENV(2),
    ERROR(3),
    BACKGROUND(4),
    CUSTOM(5),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005),
    MQTT(2000),
    LBS(10001),
    ERRCODE(3000);
    
    private int v;

    private EventType(int i) {
        this.v = i;
    }

    public int GetIntValue() {
        return this.v;
    }
}
