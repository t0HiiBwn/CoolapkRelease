package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppEnvironment */
public class e {
    private static String a = "AppEnvironment";
    private static volatile e b = null;
    private static String d = "ad_style";
    private static String e = "ad_id";
    private static String f = "rit";
    private static String g = "request_id";
    private static String h = "ad_slot_type";
    private static String i = "net_type";
    private static String j = "low_memory";
    private static String k = "total_max_memory_rate";
    private Map<String, String> c;

    /* renamed from: l  reason: collision with root package name */
    private long f1309l = a.a("tt_sp_app_env", "last_app_env_time", 0L);
    private boolean m = false;

    private e() {
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        hashMap.put(d, "default");
        this.c.put(e, "default");
        this.c.put(f, "default");
        this.c.put(g, "default");
        this.c.put(h, "default");
        this.c.put(i, "default");
        this.c.put(j, "default");
        this.c.put(k, "default");
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.c.put(e, lVar.ag());
            Map<String, String> map = this.c;
            String str = f;
            map.put(str, "" + aj.d(lVar.aj()));
            this.c.put(g, aj.h(lVar.aj()));
            Map<String, String> map2 = this.c;
            String str2 = h;
            map2.put(str2, "" + aj.c(lVar.aj()));
            this.c.put(i, x.f(p.a()));
            if (lVar.C()) {
                this.c.put(d, "is_playable");
            }
            d();
        }
    }

    private void d() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((((double) runtime.maxMemory()) * 1.0d) / 1048576.0d);
        float f2 = (float) ((((double) runtime.totalMemory()) * 1.0d) / 1048576.0d);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) p.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
        String str = a;
        u.f(str, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        String str2 = a;
        u.f(str2, "maxMemory: " + maxMemory);
        String str3 = a;
        u.f(str3, "totalMemory: " + f2);
        String str4 = a;
        u.f(str4, "freeMemory: " + ((float) ((((double) runtime.freeMemory()) * 1.0d) / 1048576.0d)));
        int i2 = (int) ((f2 / maxMemory) * 100.0f);
        String str5 = a;
        u.f(str5, "totalMaxRate: " + i2);
        this.c.put(j, String.valueOf(memoryInfo.lowMemory));
        this.c.put(k, String.valueOf(i2));
    }

    public Map<String, String> b() {
        return this.c;
    }

    public void c() {
        if (!this.m && !aj.a(this.f1309l, System.currentTimeMillis())) {
            this.m = true;
            com.bytedance.sdk.openadsdk.j.e.a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.e.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject e = e.this.e();
                    if (e != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e.this.f1309l = currentTimeMillis;
                        a.a("tt_sp_app_env", "last_app_env_time", Long.valueOf(currentTimeMillis));
                        com.bytedance.sdk.openadsdk.g.a.a().a(e);
                    }
                    e.this.m = false;
                }
            }, 1);
        }
    }

    /* access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context a2 = p.a();
            if (a2 == null) {
                return null;
            }
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 4111);
            ApplicationInfo applicationInfo = a2.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", i.d().f());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
