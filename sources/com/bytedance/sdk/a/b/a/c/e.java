package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.l;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.s;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: HttpHeaders */
public final class e {
    private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(aa aaVar) {
        return a(aaVar.g());
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar != m.a) {
            List<l> a2 = l.a(sVar, rVar);
            if (!a2.isEmpty()) {
                mVar.a(sVar, a2);
            }
        }
    }

    public static boolean b(aa aaVar) {
        if (aaVar.a().b().equals("HEAD")) {
            return false;
        }
        int c = aaVar.c();
        if (((c >= 100 && c < 200) || c == 204 || c == 304) && a(aaVar) == -1 && !"chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
