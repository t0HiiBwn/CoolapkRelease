package com.kepler.sdk;

import android.text.TextUtils;
import android.util.Log;

public class j {
    public static void a(String str, String str2) {
        if ((i.a.booleanValue() & (!TextUtils.isEmpty(str))) && (!TextUtils.isEmpty(str2))) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if ((i.a.booleanValue() & (!TextUtils.isEmpty(str))) && (!TextUtils.isEmpty(str2))) {
            Log.w(str, str2);
        }
    }

    public static void a(Throwable th) {
        if (i.a.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    public static void a(Throwable th, String str) {
        if (!af.c(str)) {
            Log.w("kepler_exception_info", str);
        }
        if (th != null) {
            th.printStackTrace();
        }
    }
}
