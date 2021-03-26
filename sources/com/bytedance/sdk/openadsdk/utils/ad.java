package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.f;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: RomUtils */
public class ad {
    public static boolean a;
    public static boolean b;
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";

    public static String a() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (g()) {
            return f();
        }
        if (h()) {
            return i();
        }
        if (d()) {
            return c();
        }
        String j = j();
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return Build.DISPLAY;
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    a = true;
                    b = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            b = true;
        }
        return a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (!k()) {
            return "";
        }
        return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (!e()) {
            return "";
        }
        return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                String d2 = d("ro.smartisan.version");
                return "smartisan_" + d2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(aj.m("kllk"));
    }

    public static String s() {
        if (!r()) {
            return "";
        }
        String m = aj.m("ro.build.version.kllkrom");
        return "coloros_" + d(m) + "_" + Build.DISPLAY;
    }

    public static boolean t() {
        try {
            if ((TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) && (TextUtils.isEmpty(Build.MANUFACTURER) || !Build.MANUFACTURER.toLowerCase().startsWith("huawei"))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r5 = null;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[ExcHandler: all (r4v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    public static String c(String str) {
        BufferedReader bufferedReader;
        Process exec;
        String str2 = "Exception while closing InputStream";
        String str3 = "ToolUtils";
        String str4 = "";
        Process process = null;
        try {
            exec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str4 = bufferedReader.readLine();
                exec.exitValue();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    u.c("ToolUtils", "Exception while closing InputStream", e2);
                }
            } catch (IllegalThreadStateException unused) {
                process = exec;
                try {
                    process.destroy();
                } catch (Throwable unused2) {
                }
                if (bufferedReader != null) {
                }
                return str4;
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    u.c("ToolUtils", "Unable to read sysprop " + str, th2);
                    return str4;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            u.c(str3, str2, e3);
                        }
                    }
                }
            }
        } catch (IllegalThreadStateException unused3) {
            bufferedReader = null;
            process = exec;
            process.destroy();
            if (bufferedReader != null) {
            }
            return str4;
        } catch (Throwable th3) {
        }
        return str4;
    }

    private static String d(String str) {
        String str2;
        try {
            str2 = u();
            try {
                if (TextUtils.isEmpty(str2)) {
                    final f fVar = new f(new a(str), 5, 2);
                    e.a().execute(new g() {
                        /* class com.bytedance.sdk.openadsdk.utils.ad.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            fVar.run();
                        }
                    });
                    str2 = (String) fVar.get(1, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* compiled from: RomUtils */
    public static class a implements Callable<String> {
        private String a;

        public a(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c = ad.c(this.a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            u.b("RomUtils", "property:" + c + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(c)) {
                try {
                    if (b.b()) {
                        u.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + c);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", c);
                    } else {
                        u.d("RomUtils", "SP-getPropertyFromSP:" + c);
                        ae.a("rom_info", p.a()).a("rom_property_info", c);
                    }
                } catch (Throwable unused) {
                }
            }
            return c;
        }
    }

    private static String u() {
        try {
            if (b.b()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                u.c("RomUtils", "get Property From SPMultiHelper..." + b2);
                return b2;
            }
            String b3 = ae.a("rom_info", p.a()).b("rom_property_info", "");
            u.c("RomUtils", "get Property From SP...=" + b3);
            return b3;
        } catch (Throwable unused) {
            return "";
        }
    }
}
