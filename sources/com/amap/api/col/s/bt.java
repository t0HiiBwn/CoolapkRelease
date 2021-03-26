package com.amap.api.col.s;

import android.content.Context;

/* compiled from: AdiuManager */
public class bt {
    private static bt a;
    private final Context b;
    private final String c = ca.a(bs.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private bt(Context context) {
        this.b = context.getApplicationContext();
    }

    public static bt a(Context context) {
        if (a == null) {
            synchronized (bt.class) {
                if (a == null) {
                    a = new bt(context);
                }
            }
        }
        return a;
    }

    public final void a(String str) {
        bu.a(this.b).a(this.c);
        bu.a(this.b).b(str);
    }
}
