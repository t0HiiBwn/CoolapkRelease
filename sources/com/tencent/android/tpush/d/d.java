package com.tencent.android.tpush.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.a.b;
import com.tencent.android.tpush.d.a.c;
import com.tencent.android.tpush.d.a.e;
import com.tencent.android.tpush.d.a.f;
import com.tencent.android.tpush.d.a.g;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

/* compiled from: ProGuard */
public class d {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static Boolean g = false;
    public static String h = "";
    private static volatile d i = null;
    private static volatile c j = null;
    private Boolean k;
    private Context l = null;
    private int m = -1;

    private d(Context context) {
        this.l = context;
        if (j != null) {
            return;
        }
        if (!i.a(context).c() || !XGPushConfig.isNotTryFcm(context)) {
            String g2 = g();
            if (a.b(this.l)) {
                TLogger.ii("OtherPushManager", "USE XgSys");
                j = new g(this.l);
            } else if (ChannelUtils.isBrandXiaoMi() || "blackshark".equals(g2)) {
                TLogger.ii("OtherPushManager", "USE xiaomi");
                j = new com.tencent.android.tpush.d.a.d();
            } else if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
                TLogger.ii("OtherPushManager", "USE huawei");
                j = new b();
            } else if (ChannelUtils.isBrandMeiZu()) {
                TLogger.ii("OtherPushManager", "USE meizu");
                j = new c();
            } else if ("oppo".equals(g2) || "oneplus".equals(g2) || "realme".equals(g2)) {
                TLogger.ii("OtherPushManager", "USE oppo");
                j = new e();
            } else if ("vivo".equals(g2)) {
                TLogger.ii("OtherPushManager", "USE vivo");
                j = new f();
            } else {
                TLogger.ii("OtherPushManager", "deviceType: " + g2);
            }
        } else {
            TLogger.e("OtherPushManager", "USE FCM");
            XGPushConfig.setNotTryFcm(context, false);
            j = new com.tencent.android.tpush.d.a.a();
        }
    }

    public boolean a() {
        if (j == null || this.l == null) {
            return false;
        }
        return j.d(this.l);
    }

    public boolean b() {
        boolean z = false;
        if (!(j == null || this.l == null)) {
            if (j.e(this.l) == 8) {
                z = true;
            }
            if (z) {
                TLogger.ii("OtherPushManager", "UseXgSysDevice!");
            }
        }
        return z;
    }

    public static void a(d dVar, c cVar) {
        i = dVar;
        j = cVar;
    }

    public static d a(Context context) {
        if (i == null) {
            synchronized (d.class) {
                if (i == null) {
                    i = new d(context);
                }
            }
        }
        return i;
    }

    public void c() {
        if (j != null && this.l != null && j.d(this.l)) {
            j.a(this.l);
        }
    }

    public void d() {
        if (j != null && this.l != null && j.d(this.l)) {
            j.b(this.l);
        }
    }

    public int e() {
        if (j == null || this.l == null || !j.d(this.l)) {
            return -1;
        }
        return j.e(this.l);
    }

    public String f() {
        if (j == null || this.l == null || !j.d(this.l)) {
            return null;
        }
        return j.c(this.l);
    }

    public static String g() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public static void a(Context context, String str, String str2) {
        String str3 = "";
        try {
            str3 = SharePrefsUtil.getString(context, "other_push_error_code", str3);
        } catch (Throwable th) {
            TLogger.w(str, "save returnMsg error: " + th.getMessage());
            return;
        }
        if (!str2.equals(str3)) {
            SharePrefsUtil.setString(context, "other_push_error_code", str2);
        }
    }

    public static String h() {
        return Build.MODEL;
    }

    public static void a(Context context, String str) {
        a = str;
    }

    public static void b(Context context, String str) {
        b = str;
    }

    public static void c(Context context, String str) {
        c = str;
    }

    public static void d(Context context, String str) {
        d = str;
    }

    public static void e(Context context, String str) {
        e = str;
    }

    public static void f(Context context, String str) {
        f = str;
    }

    public static void a(Context context, boolean z) {
        g = Boolean.valueOf(z);
    }

    public String i() {
        if (j != null) {
            return j.a();
        }
        return null;
    }

    public boolean j() {
        if (j == null || this.l == null) {
            return false;
        }
        if (this.k == null) {
            this.k = Boolean.valueOf(j.d(this.l));
        }
        return this.k.booleanValue();
    }
}
