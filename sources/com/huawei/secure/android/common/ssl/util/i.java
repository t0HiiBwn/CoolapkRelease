package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class i {
    private static final String FILE_NAME = "aegis";
    private static SharedPreferences am;

    public static synchronized SharedPreferences f(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (i.class) {
            if (am == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    am = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
                } else {
                    am = context.getApplicationContext().getSharedPreferences("aegis", 0);
                }
            }
            sharedPreferences = am;
        }
        return sharedPreferences;
    }

    public static void a(String str, long j, Context context) {
        f(context).edit().putLong(str, j).apply();
    }

    public static long b(String str, long j, Context context) {
        return f(context).getLong(str, j);
    }

    public static void a(String str, int i, Context context) {
        f(context).edit().putInt(str, i).apply();
    }

    public static int b(String str, int i, Context context) {
        return f(context).getInt(str, i);
    }

    public static void a(String str, String str2, Context context) {
        f(context).edit().putString(str, str2).apply();
    }

    public static String b(String str, String str2, Context context) {
        return f(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        f(context).edit().remove(str).apply();
    }

    public static void g(Context context) {
        f(context).edit().clear().apply();
    }
}
