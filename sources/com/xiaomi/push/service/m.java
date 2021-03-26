package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.bi;
import java.util.ArrayList;
import java.util.List;

public class m {
    private static m a;

    /* renamed from: a  reason: collision with other field name */
    private Context f1026a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f1027a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private m(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1026a = applicationContext;
        if (applicationContext == null) {
            this.f1026a = context;
        }
        SharedPreferences sharedPreferences = this.f1026a.getSharedPreferences("mipush_app_info", 0);
        String[] split = sharedPreferences.getString("unregistered_pkg_names", "").split(",");
        for (String str : split) {
            if (TextUtils.isEmpty(str)) {
                this.f1027a.add(str);
            }
        }
        String[] split2 = sharedPreferences.getString("disable_push_pkg_names", "").split(",");
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        String[] split3 = sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",");
        for (String str3 : split3) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static m a(Context context) {
        if (a == null) {
            a = new m(context);
        }
        return a;
    }

    public void a(String str) {
        synchronized (this.f1027a) {
            if (!this.f1027a.contains(str)) {
                this.f1027a.add(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bi.a(this.f1027a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m663a(String str) {
        boolean contains;
        synchronized (this.f1027a) {
            contains = this.f1027a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bi.a(this.b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m664b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bi.a(this.c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m665c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f1027a) {
            if (this.f1027a.contains(str)) {
                this.f1027a.remove(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bi.a(this.f1027a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bi.a(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f1026a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bi.a(this.c, ",")).commit();
            }
        }
    }
}
