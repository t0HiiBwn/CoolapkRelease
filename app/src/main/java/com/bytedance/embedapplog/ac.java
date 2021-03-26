package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class ac {
    private static final CharSequence a = "sony";
    private static final CharSequence b = "amigo";
    private static final CharSequence c = "funtouch";

    public static boolean a() {
        try {
            if (Class.forName("miui.os.Build").getName().length() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            return str.toLowerCase().contains("oppo");
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[SYNTHETIC, Splitter:B:13:0x003c] */
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
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return str2;
            } catch (Throwable unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return str2;
            }
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
            }
            return str2;
        }
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean d() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean e() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String i() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean f() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String a2 = a("ro.build.version.incremental");
        return !TextUtils.isEmpty(a2) && a2.contains("VIBEUI_V2");
    }

    public static boolean g() {
        return i().toUpperCase().contains("NUBIA");
    }

    public static boolean h() {
        return i().toUpperCase().contains("ASUS");
    }

    public static boolean a(Context context) {
        return i().toUpperCase().contains("HUAWEI");
    }
}
