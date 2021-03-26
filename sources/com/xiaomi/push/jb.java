package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;

public class jb {
    private static Context a;
    private static String b;

    public static Context a() {
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
            c.a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e);
        }
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static int b() {
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

    public static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }

    public static String c(Context context) {
        if (it.b()) {
            return "";
        }
        String str = (String) ac.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    public static boolean c() {
        return TextUtils.equals((String) ac.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    public static boolean d() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            c.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }

    public static synchronized String e() {
        synchronized (jb.class) {
            String str = b;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (b() <= 0) {
                String f = f();
                if (TextUtils.isEmpty(f)) {
                    f = g();
                    if (TextUtils.isEmpty(f)) {
                        f = h();
                        if (TextUtils.isEmpty(f)) {
                            str2 = String.valueOf(ja.a("ro.product.brand", "Android") + "_" + str2);
                        }
                    }
                }
                str2 = f;
            }
            b = str2;
            return str2;
        }
    }

    private static String f() {
        String a2 = ja.a("ro.build.version.emui", "");
        b = a2;
        return a2;
    }

    private static String g() {
        String a2 = ja.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            b = "ColorOS_" + a2;
        }
        return b;
    }

    private static String h() {
        String a2 = ja.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            b = "FuntouchOS_" + a2;
        }
        return b;
    }
}
