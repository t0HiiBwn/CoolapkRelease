package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class l {
    private static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, o> f886a = null;
    private static int b = -1;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ all -> 0x002c }] */
    public static synchronized int a() {
        int i;
        boolean z;
        synchronized (l.class) {
            if (a == 0) {
                try {
                    int i2 = 1;
                    if (TextUtils.isEmpty(m566a("ro.miui.ui.version.code"))) {
                        if (TextUtils.isEmpty(m566a("ro.miui.ui.version.name"))) {
                            z = false;
                            if (z) {
                                i2 = 2;
                            }
                            a = i2;
                            b.b("isMIUI's value is: " + a);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    a = i2;
                } catch (Throwable th) {
                    b.a("get isMIUI failed", th);
                    a = 0;
                }
                b.b("isMIUI's value is: " + a);
            }
            i = a;
        }
        return i;
    }

    public static int a(Context context) {
        String a2 = m566a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a2) || !TextUtils.isDigitsOnly(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static o a(String str) {
        o b2 = b(str);
        return b2 == null ? o.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m565a() {
        synchronized (l.class) {
            int a2 = t.a();
            return (!m568a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m566a(String str) {
        try {
            return (String) bd.a("android.os.SystemProperties", "get", str, "");
        } catch (Exception e) {
            b.d("fail to get property. " + e);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m567a() {
        if (f886a == null) {
            HashMap hashMap = new HashMap();
            f886a = hashMap;
            hashMap.put("CN", o.China);
            f886a.put("FI", o.Europe);
            f886a.put("SE", o.Europe);
            f886a.put("NO", o.Europe);
            f886a.put("FO", o.Europe);
            f886a.put("EE", o.Europe);
            f886a.put("LV", o.Europe);
            f886a.put("LT", o.Europe);
            f886a.put("BY", o.Europe);
            f886a.put("MD", o.Europe);
            f886a.put("UA", o.Europe);
            f886a.put("PL", o.Europe);
            f886a.put("CZ", o.Europe);
            f886a.put("SK", o.Europe);
            f886a.put("HU", o.Europe);
            f886a.put("DE", o.Europe);
            f886a.put("AT", o.Europe);
            f886a.put("CH", o.Europe);
            f886a.put("LI", o.Europe);
            f886a.put("GB", o.Europe);
            f886a.put("IE", o.Europe);
            f886a.put("NL", o.Europe);
            f886a.put("BE", o.Europe);
            f886a.put("LU", o.Europe);
            f886a.put("FR", o.Europe);
            f886a.put("RO", o.Europe);
            f886a.put("BG", o.Europe);
            f886a.put("RS", o.Europe);
            f886a.put("MK", o.Europe);
            f886a.put("AL", o.Europe);
            f886a.put("GR", o.Europe);
            f886a.put("SI", o.Europe);
            f886a.put("HR", o.Europe);
            f886a.put("IT", o.Europe);
            f886a.put("SM", o.Europe);
            f886a.put("MT", o.Europe);
            f886a.put("ES", o.Europe);
            f886a.put("PT", o.Europe);
            f886a.put("AD", o.Europe);
            f886a.put("CY", o.Europe);
            f886a.put("DK", o.Europe);
            f886a.put("RU", o.Russia);
            f886a.put("IN", o.India);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m568a() {
        boolean z;
        synchronized (l.class) {
            z = true;
            if (a() != 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m569a(Context context) {
        return context != null && m570a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m570a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    private static o b(String str) {
        m567a();
        return f886a.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = s.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("ro.product.country.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = s.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            b.m41a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        b.m41a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static synchronized boolean m571b() {
        boolean z;
        synchronized (l.class) {
            z = a() == 2;
        }
        return z;
    }

    public static boolean c() {
        if (b < 0) {
            Object a2 = bd.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                b = 1;
            }
        }
        return b > 0;
    }

    public static boolean d() {
        return !o.China.name().equalsIgnoreCase(a(b()).name());
    }
}
