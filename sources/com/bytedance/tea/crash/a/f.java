package com.bytedance.tea.crash.a;

import android.content.Context;

/* compiled from: CrashANRHandler */
public class f {
    private static volatile f a;
    private final c b;

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    private f(Context context) {
        this.b = new c(context);
    }

    public void a() {
        this.b.a();
    }
}
