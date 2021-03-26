package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class dd {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static WeakReference<da> e = null;
    private static int f = 10;

    /* compiled from: OfflineLocManager */
    static class a implements Runnable {
        private int a = 2;
        private Context b;
        private dc c;

        a(Context context) {
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (dd.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        da a2 = dg.a(dd.e);
                        dg.a(this.b, a2, ce.i, dd.a, 2097152, "6");
                        if (a2.e == null) {
                            a2.e = new cl(new cn(new co(new cn())));
                        }
                        db.a(l, this.c.a(), a2);
                    }
                } catch (Throwable th) {
                    cg.c(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    da a3 = dg.a(dd.e);
                    dg.a(this.b, a3, ce.i, dd.a, 2097152, "6");
                    a3.h = 14400000;
                    if (a3.g == null) {
                        a3.g = new dk(new dj(this.b, new Cdo(), new cl(new cn(new co())), new String(cc.a(10)), bi.f(this.b), bm.t(this.b), bm.m(this.b), bm.h(this.b), bm.a(), Build.MANUFACTURER, Build.DEVICE, bm.v(this.b), bi.c(this.b), Build.MODEL, bi.d(this.b), bi.b(this.b)));
                    }
                    if (TextUtils.isEmpty(a3.i)) {
                        a3.i = "fKey";
                    }
                    a3.f = new ds(this.b, a3.h, a3.i, new dq(this.b, dd.b, dd.f * 1024, dd.c * 1024, "offLocKey", dd.d * 1024));
                    db.a(a3);
                } catch (Throwable th2) {
                    cg.c(th2, "ofm", "uold");
                }
            }
        }
    }

    public static void a(Context context) {
        cg.c().submit(new a(context));
    }
}
