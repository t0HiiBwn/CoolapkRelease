package com.tencent.msdk.dns.base.log;

import android.util.Log;
import java.util.Locale;

/* compiled from: DnsLog */
public final class b {
    private static int a;

    static {
        int i = 6;
        int i2 = 7;
        while (i >= 2 && Log.isLoggable("HTTPDNS", i)) {
            i2 = i;
            i--;
        }
        a = i2;
    }

    public static void a(int i) {
        a = Math.min(i, a);
    }

    public static void a(ILogNode iLogNode) {
        c.a(iLogNode);
    }

    public static boolean b(int i) {
        return i >= a;
    }

    public static void a(String str, Object... objArr) {
        a(null, str, objArr);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        a(2, th, str, objArr);
    }

    public static void b(String str, Object... objArr) {
        b(null, str, objArr);
    }

    public static void b(Throwable th, String str, Object... objArr) {
        a(3, th, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        c(null, str, objArr);
    }

    public static void c(Throwable th, String str, Object... objArr) {
        a(5, th, str, objArr);
    }

    private static void a(int i, Throwable th, String str, Object... objArr) {
        try {
            if (i >= a) {
                c.a(i, "HTTPDNS", String.format(Locale.US, str, objArr), th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
