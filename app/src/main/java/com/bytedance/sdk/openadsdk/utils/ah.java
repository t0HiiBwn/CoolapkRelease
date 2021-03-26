package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: TTReflectUtils */
public class ah {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> a = a(str);
            if (a != null) {
                return a.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            u.a("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str, true, a());
        } catch (ClassNotFoundException unused) {
            try {
                return Class.forName(str, true, ah.class.getClassLoader());
            } catch (ClassNotFoundException unused2) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException unused3) {
                    return null;
                }
            }
        }
    }

    private static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? ah.class.getClassLoader() : contextClassLoader;
    }
}
