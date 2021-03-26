package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* compiled from: StatisticsManager */
public class fg {
    private static WeakReference<fa> a;

    public static synchronized void a(final ff ffVar, final Context context) {
        synchronized (fg.class) {
            Cdo.d().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.fg.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (fg.class) {
                            fg.b(context, ffVar.a());
                        }
                    } catch (Throwable th) {
                        Cdo.c(th, "stm", "as");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, byte[] bArr) throws IOException {
        fa a2 = fh.a(a);
        fh.a(context, a2, dm.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new dh();
        }
        Random random = new Random();
        try {
            fb.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            Cdo.c(th, "stm", "wts");
        }
    }

    public static void a(final Context context) {
        Cdo.d().submit(new Runnable() {
            /* class com.amap.api.mapcore2d.fg.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    fa a2 = fh.a(fg.a);
                    fh.a(context, a2, dm.h, 1000, 307200, "2");
                    if (a2.g == null) {
                        a2.g = new fi(new fm(context, new fj(new fn(new fp()))));
                    }
                    a2.h = 3600000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "cKey";
                    }
                    if (a2.f == null) {
                        a2.f = new ft(context, a2.h, a2.i, new fq(30, a2.a, new fv(context, false)));
                    }
                    fb.a(a2);
                } catch (Throwable th) {
                    Cdo.c(th, "stm", "usd");
                }
            }
        });
    }
}
