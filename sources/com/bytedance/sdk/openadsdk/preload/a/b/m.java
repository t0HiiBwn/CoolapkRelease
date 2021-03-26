package com.bytedance.sdk.openadsdk.preload.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: UnsafeAllocator */
public abstract class m {
    public abstract <T> T a(Class<T> cls) throws Exception;

    public static m a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new m() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.m.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                public <T> T a(Class<T> cls) throws Exception {
                    b(cls);
                    return (T) method.invoke(obj, cls);
                }
            };
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new m() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.m.AnonymousClass2 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                    public <T> T a(Class<T> cls) throws Exception {
                        b(cls);
                        return (T) declaredMethod2.invoke(null, cls, Integer.valueOf(intValue));
                    }
                };
            } catch (Exception unused2) {
                try {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new m() {
                        /* class com.bytedance.sdk.openadsdk.preload.a.b.m.AnonymousClass3 */

                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                        public <T> T a(Class<T> cls) throws Exception {
                            b(cls);
                            return (T) declaredMethod3.invoke(null, cls, Object.class);
                        }
                    };
                } catch (Exception unused3) {
                    return new m() {
                        /* class com.bytedance.sdk.openadsdk.preload.a.b.m.AnonymousClass4 */

                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                        public <T> T a(Class<T> cls) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls);
                        }
                    };
                }
            }
        }
    }

    static void b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }
}
