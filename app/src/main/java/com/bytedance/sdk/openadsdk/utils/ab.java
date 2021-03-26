package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;

/* compiled from: Reflection */
public class ab {
    private static Object a;
    private static Method b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        Method method;
        Object obj = a;
        if (!(obj == null || (method = b) == null)) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a() {
        return a("L");
    }
}
