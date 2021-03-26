package com.coolapk.market.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectUtils {
    private static final HashMap<String, Constructor> constructorCache = new HashMap<>();
    private static final HashMap<String, Field> fieldCache = new HashMap<>();
    private static final HashMap<String, Method> methodCache = new HashMap<>();

    public static Class<?>[] getClassesAsArray(Class<?>... clsArr) {
        return clsArr;
    }

    public static Field findField(Class<?> cls, String str) throws Throwable {
        String str2 = cls.getName() + '#' + str;
        HashMap<String, Field> hashMap = fieldCache;
        if (hashMap.containsKey(str2)) {
            Field field = hashMap.get(str2);
            if (field != null) {
                return field;
            }
            throw new NoSuchFieldError(str2);
        }
        try {
            Field findFieldRecursiveImpl = findFieldRecursiveImpl(cls, str);
            findFieldRecursiveImpl.setAccessible(true);
            hashMap.put(str2, findFieldRecursiveImpl);
            return findFieldRecursiveImpl;
        } catch (NoSuchFieldException unused) {
            fieldCache.put(str2, null);
            throw new NoSuchFieldError(str2);
        }
    }

    private static Field findFieldRecursiveImpl(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    return cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e;
        }
    }

    public static Constructor findConstructor(Class<?> cls, Class<?>... clsArr) throws Throwable {
        String str = cls.getName() + '#' + getParametersString(clsArr) + "#constructor";
        HashMap<String, Constructor> hashMap = constructorCache;
        if (hashMap.containsKey(str)) {
            Constructor constructor = hashMap.get(str);
            if (constructor != null) {
                return constructor;
            }
            throw new NoSuchMethodError(str);
        }
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            hashMap.put(str, declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            constructorCache.put(str, null);
            throw new NoSuchMethodError(str);
        }
    }

    public static Method findMethodExact(Class<?> cls, String str, Class<?>... clsArr) throws Throwable {
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#exact";
        HashMap<String, Method> hashMap = methodCache;
        if (hashMap.containsKey(str2)) {
            Method method = hashMap.get(str2);
            if (method != null) {
                return method;
            }
            throw new NoSuchMethodError(str2);
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            hashMap.put(str2, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            methodCache.put(str2, null);
            throw new NoSuchMethodError(str2);
        }
    }

    private static String getParametersString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = true;
        for (Class<?> cls : clsArr) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private static Class<?>[] getParameterClasses(ClassLoader classLoader, Object[] objArr) throws ClassNotFoundException {
        Class<?>[] clsArr = null;
        for (int length = objArr.length - 1; length >= 0; length--) {
            Object obj = objArr[length];
            if (obj != null) {
                if (clsArr == null) {
                    clsArr = new Class[(length + 1)];
                }
                if (obj instanceof Class) {
                    clsArr[length] = (Class) obj;
                } else if (obj instanceof String) {
                    clsArr[length] = findClass((String) obj, classLoader);
                } else {
                    throw new ClassNotFoundException("parameter type must either be specified as Class or String", null);
                }
            } else {
                throw new ClassNotFoundException("parameter type must not be null", null);
            }
        }
        return clsArr == null ? new Class[0] : clsArr;
    }

    public static Class<?> findClass(String str, ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader.loadClass(str);
    }

    public static ReflectObject wrap(Object obj) {
        return new ReflectObject(obj);
    }

    public static class ReflectObject {
        private Object object;

        private ReflectObject(Object obj) {
            this.object = obj;
        }

        public ReflectObject getChildField(String str) throws Throwable {
            return ReflectUtils.wrap(ReflectUtils.findField(this.object.getClass(), str).get(this.object));
        }

        public void setChildField(String str, Object obj) throws Throwable {
            ReflectUtils.findField(this.object.getClass(), str).set(this.object, obj);
        }

        public ReflectObject callMethod(String str, Object... objArr) throws Throwable {
            Class[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr.getClass();
            }
            return ReflectUtils.wrap(ReflectUtils.findMethodExact(this.object.getClass(), str, clsArr).invoke(this.object, objArr));
        }

        public <T> T getAs(Class<T> cls) {
            return (T) this.object;
        }

        public <T> T get() {
            return (T) this.object;
        }
    }
}
