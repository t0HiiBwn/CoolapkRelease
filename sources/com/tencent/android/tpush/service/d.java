package com.tencent.android.tpush.service;

import android.os.PowerManager;

/* compiled from: ProGuard */
public class d {
    private static d a;
    private PowerManager.WakeLock b = null;

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public PowerManager.WakeLock b() {
        return this.b;
    }
}
