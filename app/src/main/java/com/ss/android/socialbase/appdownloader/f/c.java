package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.constants.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* compiled from: RomUtils */
public class c {
    public static String a = null;
    public static String b = "";
    public static String c = null;
    private static String d = "";
    private static String e;
    private static String f;
    private static String g;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean b() {
        return a("MIUI");
    }

    public static boolean c() {
        return a("VIVO");
    }

    public static boolean d() {
        n();
        return a(a);
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a("SAMSUNG");
    }

    public static String g() {
        if (e == null) {
            a("");
        }
        return e;
    }

    public static String h() {
        if (f == null) {
            a("");
        }
        return f;
    }

    public static String i() {
        if (c == null) {
            a("");
        }
        return c;
    }

    private static void n() {
        if (TextUtils.isEmpty(a)) {
            a = e.b;
            d = "ro.build.version." + e.c + "rom";
            b = "com." + e.c + ".market";
        }
    }

    public static boolean a(String str) {
        n();
        String str2 = e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b2 = b("ro.miui.ui.version.name");
        f = b2;
        if (!TextUtils.isEmpty(b2)) {
            e = "MIUI";
            c = "com.xiaomi.market";
        } else {
            String b3 = b("ro.build.version.emui");
            f = b3;
            if (!TextUtils.isEmpty(b3)) {
                e = "EMUI";
                c = "com.huawei.appmarket";
            } else {
                String b4 = b(d);
                f = b4;
                if (!TextUtils.isEmpty(b4)) {
                    e = a;
                    if (g.a(b) > -1) {
                        c = b;
                    } else {
                        c = "com.heytap.market";
                    }
                } else {
                    String b5 = b("ro.vivo.os.version");
                    f = b5;
                    if (!TextUtils.isEmpty(b5)) {
                        e = "VIVO";
                        c = "com.bbk.appstore";
                    } else {
                        String b6 = b("ro.smartisan.version");
                        f = b6;
                        if (!TextUtils.isEmpty(b6)) {
                            e = "SMARTISAN";
                            c = "com.smartisanos.appstore";
                        } else {
                            String b7 = b("ro.gn.sv.version");
                            f = b7;
                            if (!TextUtils.isEmpty(b7)) {
                                e = "QIONEE";
                                c = "com.gionee.aora.market";
                            } else {
                                String b8 = b("ro.lenovo.lvp.version");
                                f = b8;
                                if (!TextUtils.isEmpty(b8)) {
                                    e = "LENOVO";
                                    c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains("SAMSUNG")) {
                                    e = "SAMSUNG";
                                    c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    e = "ZTE";
                                    c = "zte.com.market";
                                } else if (j().toLowerCase().contains("NUBIA")) {
                                    e = "NUBIA";
                                    c = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        e = "FLYME";
                                        c = "com.meizu.mstore";
                                    } else {
                                        f = "unknown";
                                        e = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.i.e.a(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.i.e.a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            com.ss.android.socialbase.downloader.i.e.a(bufferedReader);
            return null;
        }
    }

    public static final String j() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean k() {
        o();
        return "V10".equals(g);
    }

    public static boolean l() {
        o();
        return "V11".equals(g);
    }

    public static boolean m() {
        o();
        return "V12".equals(g);
    }

    private static void o() {
        if (g == null) {
            try {
                g = b("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = g;
            if (str == null) {
                str = "";
            }
            g = str;
        }
    }
}
