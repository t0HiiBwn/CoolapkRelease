package com.tencent.tpns.baseapi.base;

import android.content.Context;
import com.tencent.tpns.baseapi.crosssp.a;

/* compiled from: ProGuard */
public class PushPreferences {
    private static a a;

    static synchronized a a(Context context) {
        a aVar;
        synchronized (PushPreferences.class) {
            if (a == null) {
                a = a.a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    public static long getLong(Context context, String str, long j) {
        return a(context).a(str, j);
    }

    public static void putLong(Context context, String str, long j) {
        a.C0158a a2 = a(context).a();
        a2.a(str, j);
        a2.b();
    }

    public static int getInt(Context context, String str, int i) {
        return a(context).a(str, i);
    }

    public static void putInt(Context context, String str, int i) {
        a.C0158a a2 = a(context).a();
        a2.a(str, i);
        a2.b();
    }

    public static String getString(Context context, String str, String str2) {
        return a(context).a(str, str2);
    }

    public static void putString(Context context, String str, String str2) {
        a.C0158a a2 = a(context).a();
        a2.a(str, str2);
        a2.b();
    }

    public static float getFloat(Context context, String str, float f) {
        return a(context).a(str, f);
    }

    public static void putFloat(Context context, String str, float f) {
        a.C0158a a2 = a(context).a();
        a2.a(str, f);
        a2.b();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return a(context).a(str, z);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        a.C0158a a2 = a(context).a();
        a2.a(str, z);
        a2.b();
    }

    public static void remove(Context context, String str) {
        if (a(context) != null) {
            a.C0158a a2 = a(context).a();
            a2.a(str);
            a2.b();
        }
    }
}
