package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: ExternalSpUtils */
public class k {
    public static void a(String str) {
        a("any_door_id", str);
    }

    public static String a() {
        return b("any_door_id", (String) null);
    }

    public static void a(long j, String str) {
        a("last_load_splash_ad_time" + str, j);
    }

    public static long b(String str) {
        return b("last_load_splash_ad_time" + str, 0);
    }

    public static void a(int i) {
        a("splash_storage_from", i);
    }

    public static void a(long j) {
        a("save_dpl_success_time", j);
    }

    public static long b() {
        return b("save_dpl_success_time", 0);
    }

    public static void c(String str) {
        a("save_dpl_success_ad_tag", str);
    }

    public static String c() {
        return b("save_dpl_success_ad_tag", "");
    }

    public static void d(String str) {
        a("save_dpl_success_materialmeta", str);
    }

    public static String d() {
        return b("save_dpl_success_materialmeta", "");
    }

    public static void e(String str) {
        a("save_playable_screen_shot_materialmeta", str);
    }

    public static String e() {
        return b("save_playable_screen_shot_materialmeta", "");
    }

    public static void a(boolean z) {
        a("is_landing_page_open_market", z);
    }

    public static boolean f() {
        return b("is_landing_page_open_market", false);
    }

    private static void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b.b()) {
                    a.a(str, Integer.valueOf(i));
                } else {
                    ae.a("", p.a()).a(str, i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b.b()) {
                    a.a(str, Boolean.valueOf(z));
                } else {
                    ae.a("", p.a()).a(str, z);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean b(String str, boolean z) {
        try {
            if (b.b()) {
                return a.a(str, z);
            }
            return ae.a("", p.a()).b(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    private static void a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b.b()) {
                    a.a(str, Long.valueOf(j));
                } else {
                    ae.a("", p.a()).a(str, j);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static long b(String str, long j) {
        try {
            if (b.b()) {
                return a.a(str, j);
            }
            return ae.a("", p.a()).b(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b.b()) {
                    a.a(str, str2);
                } else {
                    ae.a("", p.a()).a(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (b.b()) {
                return a.b(str, str2);
            }
            return ae.a("", p.a()).b(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
