package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.af;

/* compiled from: SpCache */
class h {
    private String a;
    private Context b;

    h(Context context, String str) {
        this.b = context;
        this.a = TextUtils.isEmpty(str) ? "" : str;
    }

    private Context b() {
        Context context = this.b;
        return context == null ? p.a() : context;
    }

    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.a + "_cache_" + str;
    }

    private String c() {
        return this.a + "_adslot";
    }

    private String d() {
        return this.a + "_adslot_preload";
    }

    String a(String str) {
        try {
            if (b.b()) {
                return a.b(g(str), "material_data", (String) null);
            }
            return f(g(str)).getString("material_data", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    long b(String str) {
        try {
            if (b.b()) {
                return a.a(g(str), "create_time", 0L);
            }
            return f(g(str)).getLong("create_time", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    boolean c(String str) {
        try {
            if (b.b()) {
                return a.a(g(str), "has_played", true);
            }
            return f(g(str)).getBoolean("has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    void a(String str, String str2) {
        try {
            if (b.b()) {
                a.a(g(str), "has_played", (Boolean) false);
                a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                a.a(g(str), "material_data", str2);
                return;
            }
            f(g(str)).edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
        } catch (Throwable unused) {
        }
    }

    void d(String str) {
        try {
            if (b.b()) {
                a.a(g(str));
            } else {
                f(g(str)).edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    AdSlot e(String str) {
        String str2;
        try {
            if (b.b()) {
                str2 = a.b(c(), str, (String) null);
            } else {
                str2 = f(c()).getString(str, null);
            }
            return af.a(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = af.a(adSlot);
                    if (b.b()) {
                        a.a(c(), adSlot.getCodeId(), a2);
                    } else {
                        f(c()).edit().putString(adSlot.getCodeId(), a2).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = af.a(adSlot);
                    if (b.b()) {
                        a.a(d(), "preload_data", a2);
                    } else {
                        f(d()).edit().putString("preload_data", a2).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    AdSlot a() {
        String str;
        try {
            if (b.b()) {
                str = a.b(d(), "preload_data", (String) null);
                a.a(d());
            } else {
                SharedPreferences f = f(d());
                String string = f.getString("preload_data", null);
                f.edit().clear().apply();
                str = string;
            }
            return af.a(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
