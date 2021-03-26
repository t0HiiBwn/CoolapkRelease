package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: Device */
public class c {
    private static boolean a;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return b();
        }
        return true;
    }

    public static String a() {
        return b("ro.build.version.emui");
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                bufferedReader.close();
                f.a(bufferedReader);
                return str2;
            } catch (Throwable unused) {
                f.a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            f.a(bufferedReader);
            return str2;
        }
    }

    public static boolean b() {
        try {
            if ((TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) && (TextUtils.isEmpty(Build.MANUFACTURER) || !Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei"))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c() {
        if (!a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    b.a = true;
                    a = true;
                    return b.a;
                }
            } catch (Exception unused) {
            }
            a = true;
        }
        return b.a;
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
