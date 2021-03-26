package com.tencent.tpns.baseapi.core.b;

import android.os.PowerManager;

/* compiled from: ProGuard */
public class b {
    private static b a;
    private PowerManager.WakeLock b = null;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public PowerManager.WakeLock b() {
        return this.b;
    }

    public void a(PowerManager.WakeLock wakeLock) {
        this.b = wakeLock;
    }
}
