package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushAnalyticsUtils */
public class k {
    public static void a(Context context, String str, String str2, o oVar) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            HMSLog.i("PushAnalyticsUtils", "Not support report BI");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("msgId", oVar.a());
        bundle.putString("sdkVer", String.valueOf(50002300));
        bundle.putString("cmd", oVar.j());
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("notifyId", str2);
        bundle.putString("ueid", oVar.w());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        bundle.putString("eventId", str);
        PushProxy proxy = ProxyCenter.getInstance().getProxy();
        if (proxy != null) {
            bundle.putInt("proxyType", proxy.getProxyType());
        }
        pushAnalytics.report(context, bundle);
    }

    public static void a(Context context, String str, String str2) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            HMSLog.i("PushAnalyticsUtils", "Not support report BI");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("msgId", str);
        bundle.putString("sdkVer", String.valueOf(50002300));
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("ueid", str);
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        bundle.putString("eventId", str2);
        PushProxy proxy = ProxyCenter.getInstance().getProxy();
        if (proxy != null) {
            bundle.putInt("proxyType", proxy.getProxyType());
        }
        pushAnalytics.report(context, bundle);
    }
}
