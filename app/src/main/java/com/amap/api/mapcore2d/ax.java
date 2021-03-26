package com.amap.api.mapcore2d;

import java.util.Locale;
import java.util.Random;

/* compiled from: MapServerUrl */
class ax {
    private static ax b;
    private String a = "http://tm.amap.com";

    private ax() {
    }

    public static synchronized ax a() {
        ax axVar;
        synchronized (ax.class) {
            if (b == null) {
                b = new ax();
            }
            axVar = b;
        }
        return axVar;
    }

    public String b() {
        String str;
        int nextInt = new Random(System.currentTimeMillis()).nextInt(100000) % 4;
        if (q.m == 2) {
            str = String.format(Locale.US, "http://wprd0%d.is.autonavi.com", Integer.valueOf(nextInt + 1));
        } else {
            str = String.format(Locale.US, "http://webrd0%d.is.autonavi.com", Integer.valueOf(nextInt + 1));
        }
        return str + q.a();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return "http://grid.amap.com/grid/%d/%d/%d?ds=" + q.i;
    }

    public String e() {
        return String.format(Locale.US, "http://mst0%d.is.autonavi.com", Integer.valueOf((new Random(System.currentTimeMillis()).nextInt(100000) % 4) + 1));
    }
}
