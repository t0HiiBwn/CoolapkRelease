package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: RomUtils */
public class l {
    private static final CharSequence a = "sony";
    private static final CharSequence b = "amigo";
    private static final CharSequence c = "funtouch";

    public static String a() {
        if (c.c()) {
            return j();
        }
        if (c.d()) {
            return l();
        }
        if (m()) {
            return n();
        }
        String k = k();
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        if (e()) {
            return d();
        }
        if (f()) {
            return g();
        }
        if (c()) {
            return b();
        }
        String h = h();
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        return Build.DISPLAY;
    }

    public static String b() {
        return a("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            return true;
        }
        return false;
    }

    public static String d() {
        return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
    }

    public static boolean e() {
        String a2 = a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(a2) && a2.toLowerCase(Locale.getDefault()).contains(c);
    }

    public static boolean f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(b);
    }

    public static String g() {
        return Build.DISPLAY + "_" + a("ro.gn.sv.version");
    }

    public static String h() {
        if (!i()) {
            return "";
        }
        return "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static String j() {
        if (!c.c()) {
            return "";
        }
        return "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String k() {
        String a2 = c.a();
        if (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return a2 + "_" + Build.DISPLAY;
    }

    public static String l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            return str.toLowerCase(Locale.getDefault()).contains("oppo");
        }
        return false;
    }

    public static String n() {
        if (!m()) {
            return "";
        }
        return "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    private static String a(String str) {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                f.a(bufferedReader2);
                return str2;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                f.a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            f.a(bufferedReader);
            return str2;
        }
    }
}
