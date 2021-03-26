package com.huawei.hms.stats;

import android.content.Context;

public final class bo {
    private static final String[] a = {"ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag"};
    private static bo b = null;
    private static final Object c = new Object();
    private Context d;

    private bo() {
    }

    public static bo a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        synchronized (bo.class) {
            if (b == null) {
                b = new bo();
            }
        }
    }

    public void a(Context context) {
        synchronized (c) {
            if (this.d != null) {
                af.c("HiAnalyticsDataManager", "DataManager already initialized.");
                return;
            }
            this.d = context;
            n.a().c().a(this.d);
            n.a().c().g(context.getPackageName());
            bg.a().a(context);
        }
    }

    public void a(String str) {
        if (this.d == null) {
            af.c("HiAnalyticsDataManager", "clearDataByTag() sdk is not init");
            return;
        }
        af.b("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearDataByTag(String appid) is execute.");
        ap.c(this.d, str);
    }

    public void b(String str) {
        af.b("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.d;
        if (context == null) {
            af.c("hmsSdk", "sdk is not init");
            return;
        }
        n.a().c().h(az.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
