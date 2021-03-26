package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class g {
    private static final String TAG = "SecurityComp115301: ";

    public static void b(String str, String str2) {
    }

    public static void a(String str, String str2) {
        Log.v(f(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(f(str), str2);
    }

    public static void d(String str, String str2) {
        Log.w(f(str), str2);
    }

    public static void e(String str, String str2) {
        Log.e(f(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(f(str), str2, th);
    }

    private static String f(String str) {
        return "SecurityComp115301: " + str;
    }
}
