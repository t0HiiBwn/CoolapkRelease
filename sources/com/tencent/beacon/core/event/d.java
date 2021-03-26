package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* compiled from: EventStrategyBean */
public final class d {
    private static d a;
    private int b = UploadStrategy.DEFAULT_REAL_NUM_UPLOAD;
    private int c = UploadStrategy.DEFAULT_REAL_TIME_DELAY;
    private int d = UploadStrategy.DEFAULT_COM_NUM_DB;
    private int e = UploadStrategy.DEFAULT_COMMON_DELAY;
    private int f = UploadStrategy.DEFAULT_COM_NUM_UPLOAD;
    private boolean g = UploadStrategy.DEFAULT_COM_POLL_UP;
    private boolean h = true;
    private Set<String> i = null;
    private Map<String, Float> j = null;
    private boolean k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1426l = false;
    private int m = 10485760;
    private boolean n = false;
    private float o = 1.0f;
    private boolean p = UploadStrategy.DEFAULT_SENSOR_ENABLE;
    private boolean q = true;
    private boolean r = true;
    private boolean s = true;
    private int t = 1;
    private long u = 6400;
    private int v = 20;
    private int w = 300;
    private boolean x = false;
    private int y = 1;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    public final synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.b = h.a(map.get("realNumUp"), this.b, 1, 50);
                this.c = h.a(map.get("realDelayUp"), this.c, 10, 600);
                this.d = h.a(map.get("comNumDB"), this.d, 1, 50);
                this.e = h.a(map.get("comDelayDB"), this.e, 30, 600);
                this.f = h.a(map.get("comNumUp"), this.f, 1, 100);
                this.h = h.a(map.get("heartOnOff"), this.h);
                this.k = h.a(map.get("tidyEF"), this.k);
                this.f1426l = h.a(map.get("lauEveSim"), this.f1426l);
                this.g = h.a(map.get("comPollUp"), this.g);
                this.m = h.a(map.get("dailyNetFlowLimit"), this.m, 204800, 10485760);
                b.b = h.a(map.get("accessTestOnOff"), b.b);
                this.n = h.a(map.get("zeroPeakOnOff"), this.n);
                String str = map.get("zeroPeakRate");
                if (str != null) {
                    String trim = str.trim();
                    if (trim.length() > 0) {
                        String[] split = trim.split(",");
                        if (split.length == 2) {
                            try {
                                this.o = Float.valueOf(split[0]).floatValue() / Float.valueOf(split[1]).floatValue();
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                this.x = h.a(map.get("straOnOff"), this.x);
                this.y = h.a(map.get("straDayMaxCount"), this.y, 1, Integer.MAX_VALUE);
                if (this.c != UploadStrategy.DEFAULT_REAL_TIME_DELAY) {
                    TunnelModule.getInstance().updateSchedule();
                }
                if (this.e != UploadStrategy.DEFAULT_COMMON_DELAY) {
                    TunnelModule.getInstance().updateSchedule();
                }
                this.p = h.a(map.get("sensorEnable"), this.p);
                this.q = h.a(map.get("acceleEnable"), this.q);
                this.r = h.a(map.get("gyroEnable"), this.r);
                this.s = h.a(map.get("magneticEnable"), this.s);
                this.t = h.a(map.get("gatherCount"), this.t, 1, 50);
                this.u = h.a(map.get("gatherDur"), this.u);
                this.v = h.a(map.get("hertzCount"), this.v, 20, 100);
                this.w = h.a(map.get("consuming"), this.w, 60, 86400);
                return;
            } catch (Exception e2) {
                b.a(e2);
            }
        }
        return;
    }

    public final synchronized int b() {
        return this.b;
    }

    public final synchronized int c() {
        return this.c;
    }

    public final synchronized int d() {
        return this.d;
    }

    public final synchronized int e() {
        return this.e;
    }

    public final synchronized int f() {
        return this.f;
    }

    public final synchronized void a(Set<String> set) {
        this.i = set;
    }

    public final synchronized boolean a(String str) {
        boolean z;
        z = false;
        Set<String> set = this.i;
        if (set != null && set.size() > 0) {
            z = this.i.contains(str);
        }
        return z;
    }

    public final synchronized void b(Set<String> set) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        for (String str : set) {
            String[] split = str.split(",");
            if (split.length == 3) {
                try {
                    this.j.put(split[0].toLowerCase(), Float.valueOf(Float.valueOf(split[1]).floatValue() / Float.valueOf(split[2]).floatValue()));
                } catch (Exception unused) {
                }
            }
        }
    }

    public final synchronized boolean b(String str) {
        Map<String, Float> map = this.j;
        boolean z = true;
        if (map != null) {
            if (map.get(str) != null) {
                if (new Random().nextInt(1000) + 1 > ((int) (this.j.get(str.toLowerCase()).floatValue() * 1000.0f))) {
                    z = false;
                }
                return z;
            }
        }
        return true;
    }

    public final synchronized boolean g() {
        boolean z;
        z = true;
        if (this.n) {
            Calendar instance = Calendar.getInstance();
            int i2 = instance.get(11);
            int i3 = instance.get(12);
            if (i2 == 0 && i3 >= 0 && 30 >= i3) {
                if (new Random().nextInt(1000) + 1 > ((int) (this.o * 1000.0f))) {
                    z = false;
                }
            }
        }
        return z;
    }

    public final boolean h() {
        return this.g;
    }

    public final boolean i() {
        return this.k;
    }

    public final boolean j() {
        return this.f1426l;
    }

    public final int k() {
        return this.m;
    }

    public final int l() {
        return this.y;
    }

    public final boolean m() {
        return this.x;
    }

    public final boolean n() {
        return this.p;
    }

    public final boolean o() {
        return this.q;
    }

    public final boolean p() {
        return this.r;
    }

    public final boolean q() {
        return this.s;
    }

    public final int r() {
        return this.t;
    }

    public final long s() {
        return this.u;
    }

    public final int t() {
        return this.v;
    }

    public final int u() {
        return this.w;
    }
}
