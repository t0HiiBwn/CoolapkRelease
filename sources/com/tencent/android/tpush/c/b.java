package com.tencent.android.tpush.c;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public class b {
    private static a a;
    private static String b;

    public static a a(Context context) {
        if (!e.a(a)) {
            TLogger.dd("MidHelper", "read the new one");
            a = new c(context, 3).d();
        }
        if (!e.a(a)) {
            TLogger.dd("MidHelper", "load from the old one");
            a = new c(context, 0).d();
        }
        a aVar = a;
        return aVar != null ? aVar : new a();
    }

    public static String b(Context context) {
        if (!e.b(b)) {
            synchronized (b.class) {
                if (!e.b(b)) {
                    b = a(context).b();
                }
            }
        }
        return b;
    }
}
