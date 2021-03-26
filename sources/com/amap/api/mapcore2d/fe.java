package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class fe {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    private static WeakReference<fa> d = null;
    private static int e = 10;

    public static synchronized void a(final fd fdVar, final Context context) {
        synchronized (fe.class) {
            Cdo.d().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.fe.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (fe.class) {
                            String l2 = Long.toString(System.currentTimeMillis());
                            fa a2 = fh.a(fe.d);
                            fh.a(context, a2, dm.i, fe.a, 2097152, "6");
                            if (a2.e == null) {
                                a2.e = new de(new dg(new di(new dg())));
                            }
                            fb.a(l2, fdVar.a(), a2);
                        }
                    } catch (Throwable th) {
                        Cdo.c(th, "ofm", "aple");
                    }
                }
            });
        }
    }

    public static void a(final Context context) {
        Cdo.d().submit(new Runnable() {
            /* class com.amap.api.mapcore2d.fe.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    fa a2 = fh.a(fe.d);
                    fh.a(context, a2, dm.i, fe.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new fl(new fk(context, new fp(), new de(new dg(new di())), new String(dj.a(10)), cq.f(context), cu.v(context), cu.m(context), cu.h(context), cu.a(), Build.MANUFACTURER, Build.DEVICE, cu.x(context), cq.c(context), Build.MODEL, cq.d(context), cq.b(context)));
                    }
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    a2.f = new ft(context, a2.h, a2.i, new fr(context, fe.b, fe.e * 1024, fe.c * 1024));
                    fb.a(a2);
                } catch (Throwable th) {
                    Cdo.c(th, "ofm", "uold");
                }
            }
        });
    }
}
