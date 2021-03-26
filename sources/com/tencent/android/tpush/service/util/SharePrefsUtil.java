package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;

/* compiled from: ProGuard */
public class SharePrefsUtil {
    public static final String SHAREPRE_WATCH_PORT = "tpush_watchdog_port";
    static int a = 100;
    private static SharedPreferences b;

    public static String getString(Context context, String str, String str2) {
        a(context);
        return b.getString(a(str), str2);
    }

    public static void setString(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putString(a(str), str2);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static int getInt(Context context, String str, int i) {
        a(context);
        return b.getInt(a(str), i);
    }

    public static void setInt(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putInt(a(str), i);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static int getSeqId(Context context) {
        int i = a + 1;
        a = i;
        if (i == Integer.MAX_VALUE) {
            a = 1;
        }
        TLogger.i("SharePrefsUtil", "seqId = " + a);
        return a;
    }

    public static long getLong(Context context, String str, long j) {
        a(context);
        return b.getLong(a(str), j);
    }

    public static void setLong(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putLong(a(str), j);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static void setBoolean(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putBoolean(a(str), z);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        a(context);
        try {
            return b.getBoolean(a(str), z);
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "getBoolean", th);
            return z;
        }
    }

    private static SharedPreferences a(Context context) {
        if (b == null) {
            b = context.getSharedPreferences("tpush.vip.shareprefs", 0);
        }
        return b;
    }

    private static String a(String str) {
        return Util.getKey(str);
    }
}
