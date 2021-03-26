package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.d.i;

/* compiled from: EventType */
public enum f {
    ALARM(65501, 30, "alarmData", 5000),
    COUNTER(65502, 30, "counterData", 5000),
    OFFLINE_COUNTER(65133, 30, "counterData", 5000),
    STAT(65503, 30, "statData", 5000);
    
    static String TAG = "EventType";
    private int e;
    private int h;
    private int i = 25;
    private int j = 180;
    private int k;
    private boolean m;
    private String t;

    private f(int i2, int i3, String str, int i4) {
        this.e = i2;
        this.h = i3;
        this.m = true;
        this.t = str;
        this.k = i4;
    }

    public int a() {
        return this.e;
    }

    public boolean isOpen() {
        return this.m;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public int b() {
        return this.h;
    }

    public void b(int i2) {
        String str = TAG;
        i.a(str, "[setTriggerCount]", this.t, i2 + "");
        this.h = i2;
    }

    public static f a(int i2) {
        f[] values = values();
        for (f fVar : values) {
            if (fVar != null && fVar.a() == i2) {
                return fVar;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m16a() {
        return this.t;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.j;
    }

    public void setStatisticsInterval(int i2) {
        this.i = i2;
        this.j = i2;
    }

    public int e() {
        return this.k;
    }

    public void c(int i2) {
        this.k = i2;
    }
}
