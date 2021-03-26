package com.tencent.tpns.reflecttools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reflect {
    private final Object object;
    private final Class<?> type;

    private static class a {
        private a() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method exactMethod(String str, Class<?>[] clsArr) {
        Class<?> type2 = type();
        try {
            return type2.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return type2.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type2 = type2.getSuperclass();
                    if (type2 != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type2 != null);
            throw new NoSuchMethodException();
        }
    }

    private Field field0(String str) {
        Class<?> type2 = type();
        try {
            return (Field) accessible(type2.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(type2.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type2 = type2.getSuperclass();
                    if (type2 != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type2 != null);
            throw new ReflectException(e);
        }
    }

    public static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != a.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static Reflect on(Class<?> cls) {
        return new Reflect(cls);
    }

    /* access modifiers changed from: private */
    public static Reflect on(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect on(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Reflect on(String str) {
        return on(forName(str));
    }

    public static Reflect on(String str, ClassLoader classLoader) {
        return on(forName(str, classLoader));
    }

    private static Reflect on(Constructor<?> constructor, Object... objArr) {
        try {
            return on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    private static Reflect on(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return on(obj);
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    /* access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private Method similarMethod(String str, Class<?>[] clsArr) {
        Class<?> type2 = type();
        Method[] methods = type2.getMethods();
        for (Method method : methods) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            Method[] declaredMethods = type2.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            type2 = type2.getSuperclass();
        } while (type2 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        return clsArr;
    }

    private static Object unwrap(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public <P> P as(Class<P> cls) {
        final boolean z = this.object instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            /* class com.tencent.tpns.reflecttools.Reflect.AnonymousClass1 */

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                try {
                    return Reflect.on(Reflect.this.type, Reflect.this.object).call(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(Reflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        });
    }

    public Reflect call(String str) {
        return call(str, new Object[0]);
    }

    public Reflect call(String str, Object... objArr) {
        Class<?>[] types = types(objArr);
        try {
            return on(exactMethod(str, types), this.object, objArr);
        } catch (NoSuchMethodException unused) {
            try {
                return on(similarMethod(str, types), this.object, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public Reflect create(Object... objArr) {
        Class<?>[] types = types(objArr);
        try {
            return on(type().getDeclaredConstructor(types), objArr);
        } catch (NoSuchMethodException e) {
            Constructor<?>[] declaredConstructors = type().getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                if (match(constructor.getParameterTypes(), types)) {
                    return on(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public Reflect field(String str) {
        try {
            Field field0 = field0(str);
            return on(field0.getType(), field0.get(this.object));
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type2 = type();
        do {
            Field[] declaredFields = type2.getDeclaredFields();
            for (Field field : declaredFields) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type2 = type2.getSuperclass();
        } while (type2 != null);
        return linkedHashMap;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public <T> T get(String str) {
        return (T) field(str).get();
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String str, Object obj) {
        try {
            Field field0 = field0(str);
            if ((field0.getModifiers() & 16) == 16) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(field0, field0.getModifiers() & -17);
            }
            field0.set(this.object, unwrap(obj));
            return this;
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        return this.type;
    }
}
