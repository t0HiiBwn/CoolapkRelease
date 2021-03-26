package com.bytedance.embedapplog;

import android.util.Log;

public class bo {
    public static boolean a;
    public static boolean b;

    public static void a(String str, Throwable th) {
        if (b) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void b(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void c(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void d(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }

    public static void a(Throwable th) {
        Log.e("TeaLog", "U SHALL NOT PASS!", th);
    }
}
