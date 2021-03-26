package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: GlobalInfo */
public class i {
    private static volatile i u;
    private static TTCustomController x = new TTCustomController() {
        /* class com.bytedance.sdk.openadsdk.core.i.AnonymousClass1 */
    };
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private int f = 0;
    private boolean g = true;
    private boolean h = false;
    private TTGlobalAppDownloadListener i;
    private final Set<Integer> j;
    private boolean k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f1313l;
    private a m;
    private TTDownloadEventLogger n;
    private TTSecAbs o;
    private String[] p;
    private TTCustomController q;
    private String r;
    private String s;
    private boolean t;
    private c v;
    private com.bytedance.sdk.openadsdk.core.g.c w;

    public boolean a() {
        return this.m.a();
    }

    public boolean b() {
        return this.t;
    }

    public boolean a(Activity activity) {
        return this.m.a(activity);
    }

    public a c() {
        return this.m;
    }

    private i() {
        Set<Integer> synchronizedSet = Collections.synchronizedSet(new HashSet());
        this.j = synchronizedSet;
        this.k = false;
        this.f1313l = null;
        this.m = new a();
        this.t = false;
        com.bytedance.sdk.openadsdk.i.g.a.a(p.a());
        synchronizedSet.add(4);
        Context a2 = p.a();
        if (a2 instanceof Application) {
            ((Application) a2).registerActivityLifecycleCallbacks(this.m);
        } else if (!(a2 == null || a2.getApplicationContext() == null)) {
            ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.t = ((ShortcutManager) p.a().getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            } catch (Throwable unused) {
            }
        }
    }

    public static i d() {
        if (u == null) {
            synchronized (i.class) {
                if (u == null) {
                    u = new i();
                }
            }
        }
        return u;
    }

    public void a(TTCustomController tTCustomController) {
        this.q = tTCustomController;
    }

    public TTCustomController e() {
        if (m.b != null) {
            return m.b;
        }
        TTCustomController tTCustomController = this.q;
        return tTCustomController == null ? x : tTCustomController;
    }

    public String f() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", (String) null);
        }
        return this.a;
    }

    public void a(String str) {
        e(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
        }
        this.a = str;
        y();
    }

    private void y() {
        HashMap hashMap = new HashMap();
        String f2 = d().f();
        if (TextUtils.isEmpty(f2)) {
            f2 = String.valueOf(164362);
        }
        hashMap.put("host_appid", f2);
        hashMap.put("sdk_version", "3.4.1.2");
        AppLog.setHeaderInfo(hashMap);
    }

    public String g() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null);
        }
        return this.b;
    }

    public void b(String str) {
        f(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.b = str;
    }

    public boolean h() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false);
        }
        return this.c;
    }

    public void a(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.c = z;
    }

    public String i() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null);
        }
        return this.d;
    }

    public void c(String str) {
        g(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.d = str;
    }

    public String j() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null);
        }
        return this.e;
    }

    public void d(String str) {
        h(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.e = str;
    }

    public void a(int i2) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i2));
        }
        this.f = i2;
    }

    public int k() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0);
        }
        return this.f;
    }

    public void b(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.g = z;
    }

    public boolean l() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", true);
        }
        return this.g;
    }

    public void c(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.h = z;
    }

    public void a(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        this.i = tTGlobalAppDownloadListener;
    }

    public TTDownloadEventLogger m() {
        return this.n;
    }

    public void a(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public TTSecAbs n() {
        return this.o;
    }

    public void a(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public boolean b(int i2) {
        if (!b.b()) {
            return this.j.contains(Integer.valueOf(i2));
        }
        String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "network_state", (String) null);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String[] split = b2.split(",");
        if (split.length <= 0) {
            return false;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && String.valueOf(i2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(int... iArr) {
        if (iArr != null) {
            try {
                this.j.clear();
                for (int i2 : iArr) {
                    this.j.add(Integer.valueOf(i2));
                }
                if (!b.b()) {
                    return;
                }
                if (!this.j.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : this.j) {
                        sb.append(num);
                        sb.append(",");
                    }
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "network_state", sb.toString());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.c("sp_global_info", "network_state");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void o() {
        e(this.a);
        f(this.b);
    }

    private static void e(String str) {
        z.a(str, "appid不能为空");
    }

    private static void f(String str) {
        z.a(str, "name不能为空");
    }

    private static void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            z.a(str.length() <= 1000, "keyword超长, 最长为1000");
        }
    }

    private static void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            z.a(str.length() <= 1000, "data超长, 最长为1000");
        }
    }

    public c p() {
        if (this.v == null) {
            this.v = new c(10, 8);
        }
        return this.v;
    }

    public c q() {
        if (this.v == null) {
            this.v = new c(10, 8, true);
        }
        return this.v;
    }

    public com.bytedance.sdk.openadsdk.core.g.c r() {
        if (this.w == null) {
            this.w = new com.bytedance.sdk.openadsdk.core.g.c(10, 8);
        }
        return this.w;
    }

    public boolean s() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false);
        }
        return this.k;
    }

    public void d(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public Bitmap t() {
        if (b.b()) {
            return f.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null));
        }
        return this.f1313l;
    }

    public void a(Bitmap bitmap) {
        if (b.b()) {
            String a2 = f.a(bitmap);
            if (!TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "pause_icon", a2);
            }
        }
        this.f1313l = bitmap;
    }

    public void a(String[] strArr) {
        if (b.b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i3 = i2 + 1;
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", sb2);
            }
        }
        this.p = strArr;
    }

    public String u() {
        if (b.b()) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "tob_ab_sdk_version", (String) null);
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            return b2;
        } else if (TextUtils.isEmpty(this.r)) {
            return "";
        } else {
            return this.r;
        }
    }

    public boolean v() {
        return "5001121".equals(this.a);
    }

    public boolean w() {
        return "com.union_test.toutiao".equals(aj.e());
    }

    public String x() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        String a2 = k.a();
        this.s = a2;
        if (!TextUtils.isEmpty(a2)) {
            return this.s;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        k.a(valueOf);
        this.s = valueOf;
        return valueOf;
    }
}
