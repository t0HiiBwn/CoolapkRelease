package com.huawei.hms.stats;

import java.util.Map;

public abstract class c {
    public static String a(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.l() : "";
    }

    public static void a(String str, String str2, long j) {
        p o = o(str, str2);
        if (o != null) {
            o.a(j);
        }
    }

    public static String b(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.g() : "";
    }

    public static String c(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.h() : "";
    }

    public static String d(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.i() : "";
    }

    public static String e(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.j() : "";
    }

    public static String f(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.k() : "";
    }

    public static int g(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.c();
        }
        return 7;
    }

    public static int h(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.d();
        }
        return 10;
    }

    public static boolean i(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.n();
        }
        return true;
    }

    public static boolean j(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.o();
        }
        return false;
    }

    public static boolean k(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.m();
        }
        return true;
    }

    public static Map<String, String> l(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.a();
        }
        return null;
    }

    public static String m(String str, String str2) {
        p o = o(str, str2);
        return o != null ? o.p() : "";
    }

    public static long n(String str, String str2) {
        p o = o(str, str2);
        if (o != null) {
            return o.q();
        }
        return 0;
    }

    private static p o(String str, String str2) {
        s a = n.a().a(str);
        if (a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a.a(str2);
        }
        p a2 = a.a("oper");
        return a2 == null ? a.a("maint") : a2;
    }
}
