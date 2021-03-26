package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class ba {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static WeakReference<ax> e = null;
    private static int f = 10;

    /* compiled from: OfflineLocManager */
    static class a implements Runnable {
        private int a;
        private Context b;
        private az c;

        a(Context context, int i) {
            this.b = context;
            this.a = i;
        }

        a(Context context, az azVar) {
            this(context, 1);
            this.c = azVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (ba.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        ax a2 = bd.a(ba.e);
                        bd.a(this.b, a2, z.i, ba.a, 2097152, "6");
                        if (a2.e == null) {
                            a2.e = new aj(new al(new an(new al())));
                        }
                        ay.a(l, this.c.a(), a2);
                    }
                } catch (Throwable th) {
                    ab.b(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    ax a3 = bd.a(ba.e);
                    bd.a(this.b, a3, z.i, ba.a, 2097152, "6");
                    a3.h = 14400000;
                    if (a3.g == null) {
                        a3.g = new bh(new bg(this.b, new bl(), new aj(new al(new an())), new String(v.a(10)), k.f(this.b), n.x(this.b), n.m(this.b), n.h(this.b), n.a(), Build.MANUFACTURER, Build.DEVICE, n.A(this.b), k.c(this.b), Build.MODEL, k.d(this.b), k.b(this.b)));
                    }
                    if (TextUtils.isEmpty(a3.i)) {
                        a3.i = "fKey";
                    }
                    a3.f = new bp(this.b, a3.h, a3.i, new bn(this.b, ba.b, ba.f * 1024, ba.c * 1024, "offLocKey", ba.d * 1024));
                    ay.a(a3);
                } catch (Throwable th2) {
                    ab.b(th2, "ofm", "uold");
                }
            }
        }
    }

    public static synchronized void a(int i, boolean z, int i2, int i3) {
        synchronized (ba.class) {
            a = i;
            b = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            c = i2;
            if (i2 / 5 > f) {
                f = i2 / 5;
            }
            d = i3;
        }
    }

    public static void a(Context context) {
        ab.d().submit(new a(context, 2));
    }

    public static synchronized void a(az azVar, Context context) {
        synchronized (ba.class) {
            ab.d().submit(new a(context, azVar));
        }
    }
}
