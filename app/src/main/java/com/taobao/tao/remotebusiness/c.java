package com.taobao.tao.remotebusiness;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RequestPoolManager */
public class c {
    private static ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();

    public static b a(String str) {
        b bVar = a.get(str);
        if (bVar == null) {
            synchronized (c.class) {
                bVar = a.get(str);
                if (bVar == null) {
                    bVar = new b();
                    a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
