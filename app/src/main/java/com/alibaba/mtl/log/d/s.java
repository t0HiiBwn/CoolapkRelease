package com.alibaba.mtl.log.d;

import java.util.Map;

/* compiled from: UTAdapter */
public class s {
    public static void send(Map<String, String> map) {
        Object a;
        try {
            Object a2 = o.a("com.ut.mini.UTAnalytics", "getInstance");
            if (a2 != null && (a = o.a(a2, "getDefaultTracker")) != null) {
                o.a(a, "send", new Object[]{map}, Map.class);
            }
        } catch (Exception unused) {
        }
    }
}
