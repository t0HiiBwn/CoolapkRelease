package com.tencent.android.tpush.stat.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

/* compiled from: ProGuard */
public class c {
    private static SharedPreferences a;

    static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (c.class) {
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    a = context.getSharedPreferences(".tpush_mta", 4);
                } else {
                    a = context.getSharedPreferences(".tpush_mta", 0);
                }
                if (a == null) {
                    a = PreferenceManager.getDefaultSharedPreferences(context);
                }
                sharedPreferences = a;
            } catch (Throwable unused) {
                return null;
            }
        }
        return sharedPreferences;
    }

    public static long a(Context context, String str, long j) {
        return a(context).getLong(a.a(context, "tpush_" + str), j);
    }

    public static void b(Context context, String str, long j) {
        String a2 = a.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(a2, j);
        edit.commit();
    }

    public static int a(Context context, String str, int i) {
        return a(context).getInt(a.a(context, "tpush_" + str), i);
    }

    public static void b(Context context, String str, int i) {
        String a2 = a.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(a2, i);
        edit.commit();
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(a.a(context, "tpush_" + str), str2);
    }

    public static void b(Context context, String str, String str2) {
        String a2 = a.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(a2, str2);
        edit.commit();
    }
}
