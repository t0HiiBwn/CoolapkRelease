package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class it {
    private static int a = 0;
    private static int b = -1;
    private static Map<String, iw> c;

    public static String a(String str) {
        try {
            return (String) ac.a("android.os.SystemProperties", "get", str, "");
        } catch (Exception e) {
            c.a(e);
        } catch (Throwable unused) {
        }
        return null;
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (it.class) {
            z = true;
            if (c() != 1) {
                z = false;
            }
        }
        return z;
    }

    public static iw b(String str) {
        iw c2 = c(str);
        return c2 == null ? iw.Global : c2;
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (it.class) {
            z = c() == 2;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ all -> 0x002c }] */
    public static synchronized int c() {
        int i;
        boolean z;
        synchronized (it.class) {
            if (a == 0) {
                try {
                    int i2 = 1;
                    if (TextUtils.isEmpty(a("ro.miui.ui.version.code"))) {
                        if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
                            z = false;
                            if (z) {
                                i2 = 2;
                            }
                            a = i2;
                            c.b("isMIUI's value is: " + a);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    a = i2;
                } catch (Throwable th) {
                    c.a("get isMIUI failed", th);
                    a = 0;
                }
                c.b("isMIUI's value is: " + a);
            }
            i = a;
        }
        return i;
    }

    private static iw c(String str) {
        h();
        return c.get(str.toUpperCase());
    }

    public static synchronized String d() {
        synchronized (it.class) {
            int b2 = jb.b();
            return (!a() || b2 <= 0) ? "" : b2 < 2 ? "alpha" : b2 < 3 ? "development" : "stable";
        }
    }

    public static boolean e() {
        if (b < 0) {
            Object a2 = ac.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                b = 1;
            }
        }
        return b > 0;
    }

    public static String f() {
        String a2 = ja.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("ro.product.country.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = ja.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            c.a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        c.a("locale.default.country = " + country);
        return country;
    }

    public static boolean g() {
        return !iw.China.name().equalsIgnoreCase(b(f()).name());
    }

    private static void h() {
        if (c == null) {
            HashMap hashMap = new HashMap();
            c = hashMap;
            hashMap.put("CN", iw.China);
            c.put("FI", iw.Europe);
            c.put("SE", iw.Europe);
            c.put("NO", iw.Europe);
            c.put("FO", iw.Europe);
            c.put("EE", iw.Europe);
            c.put("LV", iw.Europe);
            c.put("LT", iw.Europe);
            c.put("BY", iw.Europe);
            c.put("MD", iw.Europe);
            c.put("UA", iw.Europe);
            c.put("PL", iw.Europe);
            c.put("CZ", iw.Europe);
            c.put("SK", iw.Europe);
            c.put("HU", iw.Europe);
            c.put("DE", iw.Europe);
            c.put("AT", iw.Europe);
            c.put("CH", iw.Europe);
            c.put("LI", iw.Europe);
            c.put("GB", iw.Europe);
            c.put("IE", iw.Europe);
            c.put("NL", iw.Europe);
            c.put("BE", iw.Europe);
            c.put("LU", iw.Europe);
            c.put("FR", iw.Europe);
            c.put("RO", iw.Europe);
            c.put("BG", iw.Europe);
            c.put("RS", iw.Europe);
            c.put("MK", iw.Europe);
            c.put("AL", iw.Europe);
            c.put("GR", iw.Europe);
            c.put("SI", iw.Europe);
            c.put("HR", iw.Europe);
            c.put("IT", iw.Europe);
            c.put("SM", iw.Europe);
            c.put("MT", iw.Europe);
            c.put("ES", iw.Europe);
            c.put("PT", iw.Europe);
            c.put("AD", iw.Europe);
            c.put("CY", iw.Europe);
            c.put("DK", iw.Europe);
            c.put("RU", iw.Russia);
            c.put("IN", iw.India);
        }
    }
}
