package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: NpthHandlerThread */
public class h {
    private static volatile HandlerThread a;
    private static volatile Handler b;
    private static volatile Handler c;

    public static HandlerThread a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new HandlerThread("default_npth_thread");
                    a.start();
                    b = new Handler(a.getLooper());
                }
            }
        }
        return a;
    }

    public static Handler b() {
        if (b == null) {
            a();
        }
        return b;
    }
}
