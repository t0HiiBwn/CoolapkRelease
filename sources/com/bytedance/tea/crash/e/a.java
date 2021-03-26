package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.tea.crash.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommonParams */
public class a {
    private Context a;
    private d b;
    private Map<String, Object> c;

    public a(Context context, d dVar) {
        this.a = context;
        this.b = dVar;
    }

    public Map<String, Object> a() {
        Map<String, Object> a2 = this.b.a();
        if (a2 == null) {
            a2 = new HashMap<>(4);
        }
        if (a(a2)) {
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128);
                a2.put("version_name", packageInfo.versionName);
                a2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (a2.get("update_version_code") == null) {
                    Object obj = null;
                    if (packageInfo.applicationInfo.metaData != null) {
                        obj = packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE");
                    }
                    if (obj == null) {
                        obj = a2.get("version_code");
                    }
                    a2.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                a2.put("version_name", com.bytedance.tea.crash.g.a.e(this.a));
                a2.put("version_code", Integer.valueOf(com.bytedance.tea.crash.g.a.f(this.a)));
                if (a2.get("update_version_code") == null) {
                    a2.put("update_version_code", a2.get("version_code"));
                }
            }
        }
        return a2;
    }

    public Map<String, Object> b() {
        if (this.c == null) {
            this.c = this.b.g();
        }
        return this.c;
    }

    public static boolean a(Map<String, Object> map) {
        return map == null || map.isEmpty() || (!map.containsKey("app_version") && !map.containsKey("version_name")) || !map.containsKey("version_code") || !map.containsKey("update_version_code");
    }

    public d c() {
        return this.b;
    }

    public String d() {
        return com.bytedance.tea.crash.g.a.d(this.a);
    }

    public String e() {
        return this.b.b();
    }
}
