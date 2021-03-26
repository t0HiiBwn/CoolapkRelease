package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
public final class x {
    public static String a = "CrashReport";
    public static boolean b = false;
    private static String c = "CrashReportInfo";

    private static boolean a(int i, String str, Object... objArr) {
        if (!b) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i == 0) {
            Log.i(a, str);
            return true;
        } else if (i == 1) {
            Log.d(a, str);
            return true;
        } else if (i == 2) {
            Log.w(a, str);
            return true;
        } else if (i == 3) {
            Log.e(a, str);
            return true;
        } else if (i != 5) {
            return false;
        } else {
            Log.i(c, str);
            return true;
        }
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean a(Throwable th) {
        if (!b) {
            return false;
        }
        return a(2, z.a(th), new Object[0]);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        if (!b) {
            return false;
        }
        return a(3, z.a(th), new Object[0]);
    }
}
