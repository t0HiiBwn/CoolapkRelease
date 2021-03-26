package com.blankj.utilcode.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class ReflectUtils {
    private final Object object;
    private final Class<?> type;

    private ReflectUtils(Class<?> cls) {
        this(cls, cls);
    }

    private ReflectUtils(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public static ReflectUtils reflect(String str) throws ReflectException {
        return reflect(forName(str));
    }

    public static ReflectUtils reflect(String str, ClassLoader classLoader) throws ReflectException {
        return reflect(forName(str, classLoader));
    }

    public static ReflectUtils reflect(Class<?> cls) throws ReflectException {
        return new ReflectUtils(cls);
    }

    public static ReflectUtils reflect(Object obj) throws ReflectException {
        return new ReflectUtils(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils newInstance() {
        return newInstance(new Object[0]);
    }

    public ReflectUtils newInstance(Object... objArr) {
        Class<?>[] argsType = getArgsType(objArr);
        try {
            return newInstance(type().getDeclaredConstructor(argsType), objArr);
        } catch (NoSuchMethodException e) {
            ArrayList arrayList = new ArrayList();
            Constructor<?>[] declaredConstructors = type().getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                if (match(constructor.getParameterTypes(), argsType)) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                sortConstructors(arrayList);
                return newInstance(arrayList.get(0), objArr);
            }
            throw new ReflectException(e);
        }
    }

    private Class<?>[] getArgsType(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private void sortConstructors(List<Constructor<?>> list) {
        Collections.sort(list, new Comparator<Constructor<?>>() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass1 */

            public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                int length = parameterTypes.length;
                for (int i = 0; i < length; i++) {
                    if (!parameterTypes[i].equals(parameterTypes2[i])) {
                        return ReflectUtils.this.wrapper(parameterTypes[i]).isAssignableFrom(ReflectUtils.this.wrapper(parameterTypes2[i])) ? 1 : -1;
                    }
                }
                return 0;
            }
        });
    }

    private ReflectUtils newInstance(Constructor<?> constructor, Object... objArr) {
        try {
            return new ReflectUtils(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils field(String str) {
        try {
            Field field = getField(str);
            return new ReflectUtils(field.getType(), field.get(this.object));
        } catch (IllegalAccessException e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils field(String str, Object obj) {
        try {
            getField(str).set(this.object, unwrap(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field getField(String str) throws IllegalAccessException {
        Field accessibleField = getAccessibleField(str);
        if ((accessibleField.getModifiers() & 16) == 16) {
            try {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(accessibleField, accessibleField.getModifiers() & -17);
            } catch (NoSuchFieldException unused) {
                accessibleField.setAccessible(true);
            }
        }
        return accessibleField;
    }

    private Field getAccessibleField(String str) {
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

    private Object unwrap(Object obj) {
        return obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj;
    }

    public ReflectUtils method(String str) throws ReflectException {
        return method(str, new Object[0]);
    }

    public ReflectUtils method(String str, Object... objArr) throws ReflectException {
        Class<?>[] argsType = getArgsType(objArr);
        try {
            return method(exactMethod(str, argsType), this.object, objArr);
        } catch (NoSuchMethodException unused) {
            try {
                return method(similarMethod(str, argsType), this.object, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }
    }

    private ReflectUtils method(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return reflect(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return reflect(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
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

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type2 = type();
        ArrayList arrayList = new ArrayList();
        Method[] methods = type2.getMethods();
        for (Method method : methods) {
            if (isSimilarSignature(method, str, clsArr)) {
                arrayList.add(method);
            }
        }
        if (!arrayList.isEmpty()) {
            sortMethods(arrayList);
            return arrayList.get(0);
        }
        do {
            Method[] declaredMethods = type2.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    arrayList.add(method2);
                }
            }
            if (!arrayList.isEmpty()) {
                sortMethods(arrayList);
                return arrayList.get(0);
            }
            type2 = type2.getSuperclass();
        } while (type2 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private void sortMethods(List<Method> list) {
        Collections.sort(list, new Comparator<Method>() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass2 */

            public int compare(Method method, Method method2) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                int length = parameterTypes.length;
                for (int i = 0; i < length; i++) {
                    if (!parameterTypes[i].equals(parameterTypes2[i])) {
                        return ReflectUtils.this.wrapper(parameterTypes[i]).isAssignableFrom(ReflectUtils.this.wrapper(parameterTypes2[i])) ? 1 : -1;
                    }
                }
                return 0;
            }
        });
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (!(clsArr2[i] == NULL.class || wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }

    private <T extends AccessibleObject> T accessible(T t) {
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

    public <P> P proxy(Class<P> cls) {
        final boolean z = this.object instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            /* class com.blankj.utilcode.util.ReflectUtils.AnonymousClass3 */

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                int i;
                String name = method.getName();
                try {
                    return ReflectUtils.reflect(ReflectUtils.this.object).method(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) ReflectUtils.this.object;
                        if (objArr == null) {
                            i = 0;
                        } else {
                            i = objArr.length;
                        }
                        if (i == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.property(name.substring(3)));
                        }
                        if (i == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.property(name.substring(2)));
                        }
                        if (i == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        });
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

    private Class<?> type() {
        return this.type;
    }

    /* access modifiers changed from: private */
    public Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectUtils) && this.object.equals(((ReflectUtils) obj).get());
    }

    public String toString() {
        return this.object.toString();
    }

    private static class NULL {
        private NULL() {
        }
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }
}
