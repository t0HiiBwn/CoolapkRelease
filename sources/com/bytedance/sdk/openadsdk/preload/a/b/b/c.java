package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor */
final class c extends b {
    private static Class a;
    private final Object b = b();
    private final Field c = c();

    c() {
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.b.b.b
    public void a(AccessibleObject accessibleObject) {
        if (!b(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    boolean b(AccessibleObject accessibleObject) {
        if (!(this.b == null || this.c == null)) {
            try {
                a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.b, accessibleObject, Long.valueOf(((Long) a.getMethod("objectFieldOffset", Field.class).invoke(this.b, this.c)).longValue()), true);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
