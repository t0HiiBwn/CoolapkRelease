package com.huawei.hms.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class n {
    static Map<String, s> a = new HashMap();
    private static n c;
    private q b = new q();

    private n() {
    }

    public static n a() {
        if (c == null) {
            d();
        }
        return c;
    }

    private static synchronized void d() {
        synchronized (n.class) {
            if (c == null) {
                c = new n();
            }
        }
    }

    public s a(String str) {
        return a.get(str);
    }

    public void a(String str, s sVar) {
        a.put(str, sVar);
    }

    public Set<String> b() {
        return a.keySet();
    }

    public q c() {
        return this.b;
    }
}
