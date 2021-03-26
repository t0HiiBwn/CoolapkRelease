package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.Map;

public class c {
    private static final String a = "c";
    private PLSharedPreferences b = null;

    public c() {
    }

    public c(Context context) {
        String packageName = context.getPackageName();
        Logger.d(a, "get pkgname from context is{%s}", packageName);
        this.b = new PLSharedPreferences(context, "share_pre_grs_conf_" + packageName);
        a(context);
    }

    private void a(Context context) {
        try {
            String l = Long.toString((long) context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a2 = a("version", "");
            if (!l.equals(a2)) {
                Logger.i(a, "app version changed! old version{%s} and new version{%s}", a2, l);
                b();
                b("version", l);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(a, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a() {
        return a("cp", "");
    }

    public String a(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public void a(String str) {
        this.b.remove(str);
    }

    public void b() {
        this.b.clear();
    }

    public void b(String str, String str2) {
        this.b.putString(str, str2);
    }

    public Map<String, ?> c() {
        return this.b.getAll();
    }
}
