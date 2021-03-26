package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData */
public class bu implements Serializable {
    private static Map<Class<? extends bi>, Map<? extends bp, bu>> d = new HashMap();
    public final String a;
    public final byte b;
    public final bv c;

    public bu(String str, byte b2, bv bvVar) {
        this.a = str;
        this.b = b2;
        this.c = bvVar;
    }

    public static void a(Class<? extends bi> cls, Map<? extends bp, bu> map) {
        d.put(cls, map);
    }

    public static Map<? extends bp, bu> a(Class<? extends bi> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }
}
