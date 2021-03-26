package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

public class b {
    private static final String TAG = "SecurityComp115301: ";

    public static void c(String str, String str2) {
    }

    public static void b(String str, String str2) {
        Log.v(i(str), str2);
    }

    public static void d(String str, String str2) {
        Log.i(i(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(i(str), str2);
    }

    public static void f(String str, String str2) {
        Log.e(i(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(i(str), str2, th);
    }

    private static String i(String str) {
        return "SecurityComp115301: " + str;
    }
}
