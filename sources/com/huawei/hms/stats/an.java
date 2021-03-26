package com.huawei.hms.stats;

import java.util.HashMap;
import java.util.Map;

public final class an {
    private static an a;
    private volatile Map<String, ao> b = new HashMap();

    private an() {
    }

    public static an a() {
        if (a == null) {
            b();
        }
        return a;
    }

    private ao b(String str) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, new ao());
        }
        return this.b.get(str);
    }

    private static synchronized void b() {
        synchronized (an.class) {
            if (a == null) {
                a = new an();
            }
        }
    }

    public ao a(String str, long j) {
        ao b2 = b(str);
        b2.a(j);
        return b2;
    }

    public void a(String str) {
        b(str).c();
    }
}
