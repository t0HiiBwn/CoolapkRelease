package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class t {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static String f1048a;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m674a() {
        return a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            b.m41a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m675a() {
        synchronized (t.class) {
            String str = f1048a;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    b = c();
                    if (TextUtils.isEmpty(b)) {
                        b = d();
                        if (TextUtils.isEmpty(b)) {
                            str2 = String.valueOf(s.a("ro.product.brand", "Android") + "_" + str2);
                        }
                    }
                }
                str2 = b;
            }
            f1048a = str2;
            return str2;
        }
    }

    public static String a(Context context) {
        if (l.m571b()) {
            return "";
        }
        String str = (String) bd.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m676a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m677a() {
        return TextUtils.equals((String) bd.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m678a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }

    private static String b() {
        String a2 = s.a("ro.build.version.emui", "");
        f1048a = a2;
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m679b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }

    private static String c() {
        String a2 = s.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f1048a = "ColorOS_" + a2;
        }
        return f1048a;
    }

    private static String d() {
        String a2 = s.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f1048a = "FuntouchOS_" + a2;
        }
        return f1048a;
    }
}
