package com.ypz.bangscreentools;

import android.util.Log;
import java.lang.reflect.Method;

public class SystemProperties {
    private static Method getStringProperty;
    private static SystemProperties single;

    public static SystemProperties getSingle() {
        if (single == null) {
            synchronized (SystemProperties.class) {
                single = new SystemProperties();
            }
        }
        return single;
    }

    private SystemProperties() {
        getStringProperty = getMethod(getClass("android.os.SystemProperties"));
    }

    private Class getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            Log.e("BangScreenTools", e.getMessage());
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException e2) {
                Log.e("BangScreenTools", e2.getMessage());
                return null;
            }
        }
    }

    private Method getMethod(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", String.class);
        } catch (Exception e) {
            Log.e("BangScreenTools", e.getMessage());
            return null;
        }
    }

    public final String get(String str) {
        if (str == null) {
            return "";
        }
        try {
            Method method = getStringProperty;
            Object obj = null;
            if (method != null) {
                obj = method.invoke(null, str);
            }
            String str2 = (String) obj;
            if (str2 != null) {
                return str2.trim();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
