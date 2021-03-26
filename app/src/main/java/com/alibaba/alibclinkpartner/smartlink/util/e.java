package com.alibaba.alibclinkpartner.smartlink.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static final Map<String, Class<?>> a;
    private static final Map<String, Class<?>> b = new HashMap();
    private static final Map<String, Method> c = new HashMap();
    private static final Map<String, Field> d = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("short", Short.TYPE);
        hashMap.put("int", Integer.TYPE);
        hashMap.put("long", Long.TYPE);
        hashMap.put("double", Double.TYPE);
        hashMap.put("float", Float.TYPE);
        hashMap.put("char", Character.TYPE);
    }

    public static <T> T a(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                ALSLLogUtil.e("ALSLReflectionUtils", "newInstance", "reflection error , errmsg =" + e.toString());
                return null;
            }
        }
        return cls.newInstance();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static Object a(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
        Method method;
        try {
            Map<String, Class<?>> map = b;
            Class<?> cls = map.get(str);
            if (cls == null) {
                cls = Class.forName(str);
                map.put(str, cls);
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr != null) {
                for (String str3 : strArr) {
                    stringBuffer.append(str3);
                }
            }
            String str4 = str + str2 + stringBuffer.toString();
            Map<String, Method> map2 = c;
            Method method2 = map2.get(str4);
            if (method2 != null) {
                return method2.invoke(obj, objArr);
            }
            if (strArr != null) {
                if (strArr.length != 0) {
                    method = cls.getMethod(str2, a(strArr));
                    if (method != null) {
                        return null;
                    }
                    map2.put(str4, method);
                    return method.invoke(obj, objArr);
                }
            }
            method = cls.getMethod(str2, new Class[0]);
            if (method != null) {
            }
        } catch (Exception e) {
            ALSLLogUtil.e("ALSLReflectionUtils", "invoke", "reflection error , errmsg =" + e.toString());
            return null;
        }
    }

    public static Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return a(Class.forName(str), a(strArr), objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            ALSLLogUtil.e("ALSLReflectionUtils", "newInstance", "reflection error , errmsg =" + e2.toString());
            return null;
        }
    }

    private static Class<?>[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 7) {
                clsArr[i] = a.get(str);
            }
            if (clsArr[i] == null) {
                if ("boolean".equals(str)) {
                    clsArr[i] = Boolean.TYPE;
                } else {
                    clsArr[i] = Class.forName(str);
                }
            }
        }
        return clsArr;
    }
}
