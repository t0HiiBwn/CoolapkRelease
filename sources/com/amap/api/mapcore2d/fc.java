package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: MarkInfoManager */
public class fc {
    static WeakReference<fa> a;

    public static void a(final Context context) {
        Cdo.d().submit(new Runnable() {
            /* class com.amap.api.mapcore2d.fc.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (fc.class) {
                    fa a2 = fh.a(fc.a);
                    fh.a(context, a2, dm.j, 50, 102400, "10");
                    if (a2.g == null) {
                        a2.g = new fl(new fk(context, new fp(), new de(new di(new dg())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", cq.b(context), cq.c(context), fc.c(context)));
                    }
                    a2.h = 14400000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "eKey";
                    }
                    if (a2.f == null) {
                        a2.f = new ft(context, a2.h, a2.i, new fq(5, a2.a, new fv(context, false)));
                    }
                    fb.a(a2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static String c(Context context) {
        String v = cu.v(context);
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        String h = cu.h(context);
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String m = cu.m(context);
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        return cu.b(context);
    }
}
