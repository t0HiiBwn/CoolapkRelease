package com.ali.auth.third.core.util;

import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils {
    private static final Map<String, Class<?>> a;
    private static final String b = ReflectionUtils.class.getSimpleName();

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("short", Short.TYPE);
        hashMap.put("int", Integer.TYPE);
        hashMap.put("long", Long.TYPE);
        hashMap.put("double", Double.TYPE);
        hashMap.put("float", Float.TYPE);
        hashMap.put("char", Character.TYPE);
        hashMap.put("boolean", Boolean.TYPE);
    }

    public static Object invoke(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
        Method method;
        try {
            Class<?> cls = Class.forName(str);
            if (strArr != null) {
                if (strArr.length != 0) {
                    method = cls.getMethod(str2, toClasses(strArr));
                    return method.invoke(obj, objArr);
                }
            }
            method = cls.getMethod(str2, new Class[0]);
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            String str3 = b;
            SDKLogger.e(str3, "Fail to invoke the " + str + "." + str2 + ", the error is " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Class<?> loadClassQuietly(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T newInstance(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                String str = b;
                SDKLogger.e(str, "Fail to create the instance of type " + cls.getName() + ", the error is " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return cls.newInstance();
    }

    public static Object newInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return newInstance(Class.forName(str), toClasses(strArr), objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            String str2 = b;
            SDKLogger.e(str2, "Fail to create the instance of type " + str + ", the error is " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public static Class<?>[] toClasses(String[] strArr) throws Exception {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 8) {
                clsArr[i] = a.get(str);
            }
            if (clsArr[i] == null) {
                clsArr[i] = Class.forName(str);
            }
        }
        return clsArr;
    }
}
