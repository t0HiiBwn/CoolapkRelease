package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* compiled from: ProGuard */
public class e {
    private static SharedPreferences a;

    static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (e.class) {
            if (a == null) {
                a = context.getSharedPreferences(".tpns.vip.service.xml", 0);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        if (!a(context).contains(str)) {
            return str2;
        }
        return a(context).getString(str, str2);
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(str, str2);
        a(edit);
    }

    private static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
