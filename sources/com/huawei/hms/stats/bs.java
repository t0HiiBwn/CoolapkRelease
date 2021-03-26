package com.huawei.hms.stats;

import android.content.Context;
import java.util.LinkedHashMap;

public abstract class bs {
    private static bq a;

    public static void a() {
        if (c() != null && bd.a().b()) {
            a.a(-1);
        }
    }

    public static void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (c() != null && bd.a().b()) {
            if (i == 1 || i == 0) {
                a.a(i, str, linkedHashMap);
                return;
            }
            af.b("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (c() != null) {
            a.a(context, str, str2);
        }
    }

    public static boolean b() {
        return bv.a().c();
    }

    private static synchronized bq c() {
        bq bqVar;
        synchronized (bs.class) {
            if (a == null) {
                a = bv.a().b();
            }
            bqVar = a;
        }
        return bqVar;
    }
}
