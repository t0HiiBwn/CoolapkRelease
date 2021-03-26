package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CollectController */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();
    private static Object b = new Object();

    private b() {
    }

    public void a() {
        synchronized (b) {
            a.clear();
        }
    }

    /* compiled from: CollectController */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!a.containsKey(str)) {
                return true;
            }
            return a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
