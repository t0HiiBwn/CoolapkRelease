package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.r;

/* compiled from: CleanTask */
class b implements Runnable {
    private static long a = 300000;

    /* renamed from: a  reason: collision with other field name */
    private static b f45a;
    private static boolean j;

    private b() {
    }

    static void init() {
        if (!j) {
            i.a("CleanTask", "init TimeoutEventManager");
            f45a = new b();
            r.a().a(5, f45a, a);
            j = true;
        }
    }

    static void destroy() {
        r.a().f(5);
        j = false;
        f45a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CleanTask", "clean TimeoutEvent");
        e.a().g();
        r.a().a(5, f45a, a);
    }
}
