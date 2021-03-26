package com.pgl.sys.ces.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static Activity a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null) {
                int i = Build.VERSION.SDK_INT;
            }
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke);
            if (map.size() < 1) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(Context context) {
        String str;
        try {
            str = context.getPackageName();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str.trim();
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Application b() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        String str;
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String c(Context context) {
        String str;
        try {
            str = context.getFilesDir().getAbsolutePath();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str.trim();
    }

    public static String d() {
        String str;
        try {
            str = Environment.getDataDirectory().getPath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        String str;
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str.trim();
    }
}
