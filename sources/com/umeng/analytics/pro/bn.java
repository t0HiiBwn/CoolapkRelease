package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* compiled from: TEnumHelper */
public class bn {
    public static bm a(Class<? extends bm> cls, int i) {
        try {
            return (bm) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
