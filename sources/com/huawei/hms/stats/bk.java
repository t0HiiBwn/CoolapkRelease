package com.huawei.hms.stats;

import android.util.Pair;
import java.util.List;
import java.util.Map;

public class bk extends ac {

    /* renamed from: com.huawei.hms.stats.bk$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bf.values().length];
            a = iArr;
            try {
                iArr[bf.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bf.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bf.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static x a(List<w> list, String str, String str2, String str3, String str4) {
        af.b("hmsSdk", "generate UploadData");
        x a = ac.a();
        if (a == null) {
            return null;
        }
        a.a(b(ae.a().d(), str, str2, str3));
        a.a(c(str, str2));
        a.a(b(str2, str, str4));
        a.a(c.f(str, str2));
        a.a(list);
        return a;
    }

    protected static bm b(String str, String str2, String str3, String str4) {
        bm a = ac.a(str, str2, str3, str4);
        String a2 = bg.a().a(c.k(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String a3 = e.a().a(b.e() + a2 + currentTimeMillis);
        a.b(String.valueOf(currentTimeMillis));
        a.g(a3);
        return a;
    }

    protected static bn b(String str, String str2, String str3) {
        bn a = ac.a(str, str2, str3);
        Pair<String, String> b = bg.a().b(str2, str);
        a.f((String) b.first);
        a.g((String) b.second);
        a.h(bi.b());
        a.e(bg.a().f(str2, str));
        return a;
    }

    protected static bl c(String str, String str2) {
        bl a = ac.a(str, str2);
        be a2 = bg.a().a(str, str2);
        a.f(bg.a().a(c.k(str, str2)));
        a.d(c.a(str, str2));
        a.g(bg.a().c(str, str2));
        int i = AnonymousClass1.a[a2.a().ordinal()];
        if (i == 1) {
            a.c(a2.b());
        } else if (i == 2) {
            a.b(a2.b());
        } else if (i == 3) {
            a.e(a2.b());
        }
        return a;
    }

    public static Map<String, String> c(String str, String str2, String str3) {
        Map<String, String> b = b(str, str3);
        Map<String, String> l = c.l(str, str2);
        if (l == null) {
            return b;
        }
        b.putAll(l);
        return b;
    }
}
