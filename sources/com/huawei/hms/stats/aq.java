package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class aq {
    private static aq a;
    private static Map<String, Long> c = new HashMap();
    private Context b;

    public static aq a() {
        return b();
    }

    private static synchronized aq b() {
        aq aqVar;
        synchronized (aq.class) {
            if (a == null) {
                a = new aq();
            }
            aqVar = a;
        }
        return aqVar;
    }

    private void b(Context context) {
        String str;
        String b2 = k.b(context);
        b.b(b2);
        if (bd.a().b()) {
            String b3 = ap.b(context, "global_v2", "app_ver", "");
            ap.a(context, "global_v2", "app_ver", b2);
            b.c(b3);
            if (TextUtils.isEmpty(b3)) {
                str = "app ver is first save!";
            } else if (!b3.equals(b2)) {
                af.b("HiAnalyticsEventServer", "the appVers are different!");
                a().a("", "alltype", b3);
                return;
            } else {
                return;
            }
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        af.b("HiAnalyticsEventServer", str);
    }

    public void a(Context context) {
        this.b = context;
        b(context);
        n.a().c().c(k.a());
    }

    public void a(String str, int i) {
        if (this.b == null) {
            af.c("HiAnalyticsEventServer", "onReport() null context or SDK was not init.");
            return;
        }
        af.b("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(str, bb.a(i), b.f());
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = bb.a("yyyy-MM-dd", currentTimeMillis);
        }
        aw.a().a(new as(str2, jSONObject, str, bb.a(i), currentTimeMillis));
    }

    public void a(String str, String str2) {
        if (c.i(str, str2)) {
            long n = c.n(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - n > 30000) {
                af.a("HiAnalyticsEventServer", "begin to call onReport!");
                c.a(str, str2, currentTimeMillis);
                a(str, str2, b.f());
                return;
            }
            af.c("HiAnalyticsEventServer", "autoReport timeout. interval < 30s ");
            return;
        }
        af.b("HiAnalyticsEventServer", "auto report is closed tag:" + str);
    }

    public void a(String str, String str2, String str3) {
        if (c.j(str, str2)) {
            String a2 = m.a(this.b);
            if (!"WIFI".equals(a2)) {
                af.b("HiAnalyticsEventServer", "strNetworkType is :" + a2);
                return;
            }
        }
        aw.a().a(new at(str, str2, str3));
    }
}
