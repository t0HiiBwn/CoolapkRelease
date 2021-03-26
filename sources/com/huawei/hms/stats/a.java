package com.huawei.hms.stats;

public abstract class a {
    public static String a(String str, String str2) {
        o k = k(str, str2);
        return k != null ? k.e() : "";
    }

    public static String b(String str, String str2) {
        o k = k(str, str2);
        return k != null ? k.f() : "";
    }

    public static String c(String str, String str2) {
        o k = k(str, str2);
        return k != null ? k.g() : "";
    }

    public static String d(String str, String str2) {
        o k = k(str, str2);
        return k != null ? k.h() : "";
    }

    public static boolean e(String str, String str2) {
        p a;
        s a2 = n.a().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.e();
    }

    public static boolean f(String str, String str2) {
        p a;
        s a2 = n.a().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.f();
    }

    public static boolean g(String str, String str2) {
        o k = k(str, str2);
        return k != null && k.a();
    }

    public static boolean h(String str, String str2) {
        o k = k(str, str2);
        return k != null && k.c();
    }

    public static boolean i(String str, String str2) {
        o k = k(str, str2);
        return k != null && k.d();
    }

    public static boolean j(String str, String str2) {
        o k = k(str, str2);
        return k != null && k.b();
    }

    private static o k(String str, String str2) {
        p a;
        s a2 = n.a().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return null;
        }
        return a.b();
    }
}
