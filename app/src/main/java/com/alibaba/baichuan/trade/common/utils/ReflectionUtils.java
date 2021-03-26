package com.alibaba.baichuan.trade.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils {
    private static final Map<String, Class<?>> a;
    private static final Map<String, Class<?>> b = new HashMap();
    private static final Map<String, Method> c = new HashMap();
    private static final Map<String, Field> d = new HashMap();
    private static final String e = ReflectionUtils.class.getSimpleName();

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

    public static Field getField(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            String str2 = cls.getName() + str;
            Map<String, Field> map = d;
            Field field = map.get(str2);
            if (field != null) {
                return field;
            }
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            map.put(str2, declaredField);
            return declaredField;
        } catch (Exception unused) {
            return getField(cls.getSuperclass(), str);
        }
    }

    public static Object getFieldValue(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        String str2 = obj.getClass().getName() + str;
        try {
            Map<String, Field> map = d;
            Field field = map.get(str2);
            if (field == null) {
                field = obj.getClass().getDeclaredField(str);
                field.setAccessible(true);
                map.put(str2, field);
            }
            return field.get(obj);
        } catch (Exception unused) {
            return getField(obj.getClass().getSuperclass(), str);
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (clsArr.length > 0) {
                for (Class<?> cls2 : clsArr) {
                    stringBuffer.append(cls2.getName());
                }
            }
            String str2 = cls.getName() + str + stringBuffer.toString();
            Map<String, Method> map = c;
            Method method = map.get(str2);
            if (method != null) {
                return method;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            map.put(str2, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            return getMethod(cls.getSuperclass(), str, new Class[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static Object invoke(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
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
                    method = cls.getMethod(str2, toClasses(strArr));
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
        } catch (Exception e2) {
            AlibcLogger.e(e, "Fail to invoke the " + str + "." + str2 + ", the error is " + e2.getMessage());
            return null;
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
            } catch (Exception e2) {
                String str = e;
                StringBuilder sb = new StringBuilder();
                sb.append("Fail to create the instance of type ");
                sb.append(cls != null ? cls.getName() : null);
                sb.append(", the error is ");
                sb.append(e2.getMessage());
                AlibcLogger.e(str, sb.toString());
                return null;
            }
        }
        return cls.newInstance();
    }

    public static Object newInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return newInstance(Class.forName(str), toClasses(strArr), objArr);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            String str2 = e;
            AlibcLogger.e(str2, "Fail to create the instance of type " + str + ", the error is " + e3.getMessage());
            return null;
        }
    }

    public static void set(Object obj, String str, Object obj2) {
        try {
            Map<String, Field> map = d;
            Field field = map.get(obj.getClass().getName() + str);
            if (field == null) {
                field = obj.getClass().getField(str);
                field.setAccessible(true);
                map.put(obj.getClass().getName() + str, field);
            }
            field.set(obj, obj2);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public static Class<?>[] toClasses(String[] strArr) {
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
