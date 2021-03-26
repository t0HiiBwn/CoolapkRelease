package com.tencent.tpns.baseapi.base.util;

import java.util.HashMap;

/* compiled from: ProGuard */
public class MemoryCacheManager {
    private static volatile HashMap<Object, Object> a = new HashMap<>(10);

    public static synchronized void put(Object obj, Object obj2) {
        synchronized (MemoryCacheManager.class) {
            a.put(obj, obj2);
        }
    }

    public static synchronized Object get(Object obj) {
        Object obj2;
        synchronized (MemoryCacheManager.class) {
            obj2 = a.get(obj);
        }
        return obj2;
    }

    public static synchronized Object remove(Object obj) {
        Object remove;
        synchronized (MemoryCacheManager.class) {
            remove = a.remove(obj);
        }
        return remove;
    }

    public static boolean containsKey(Object obj) {
        return a.containsKey(obj);
    }
}
