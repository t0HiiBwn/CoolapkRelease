package com.coolapk.market.util;

import java.lang.reflect.Field;

public class XposedUtils {
    public static final String sBridgeXposedBridge = "de.robv.android.xposed.XposedBridge";

    public static boolean hasXposed() {
        try {
            return ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void disableXposed() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, true);
        } catch (Throwable unused) {
        }
    }
}
