package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* compiled from: OpenDeviceId */
public class ar {
    private static aq a;
    private static boolean b;

    public static synchronized String a(Context context) {
        synchronized (ar.class) {
            if (context == null) {
                throw new RuntimeException("Context is null");
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                b(context);
                aq aqVar = a;
                if (aqVar != null) {
                    try {
                        return aqVar.a(context);
                    } catch (Exception unused) {
                    }
                }
                return null;
            } else {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
        }
    }

    private static void b(Context context) {
        if (a == null && !b) {
            synchronized (ar.class) {
                if (a == null && !b) {
                    a = as.a(context);
                    b = true;
                }
            }
        }
    }
}
