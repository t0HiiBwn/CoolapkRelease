package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class TTAdSdk {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static TTAdManager init(Context context, final TTAdConfig tTAdConfig) {
        final long currentTimeMillis = System.currentTimeMillis();
        z.a((Object) context, "Context is null, please check.");
        z.a(tTAdConfig, "TTAdConfig is null, please check.");
        p.a(context);
        updateAdConfig(tTAdConfig);
        if (tTAdConfig != null) {
            updatePaid(tTAdConfig.isPaid());
        }
        if (!a.get()) {
            a(context, tTAdConfig);
            a.set(true);
        }
        TTAdManager adManager = getAdManager();
        e.a().execute(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.TTAdSdk.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("init_time_cusuming", currentTimeMillis);
                    jSONObject.put("is_async", tTAdConfig.isAsyncInit());
                    jSONObject.put("is_multi_process", tTAdConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", tTAdConfig.isDebug());
                    jSONObject.put("isuse_texture_view", tTAdConfig.isUseTextureView());
                    a.a().a("pangle_sdk_init", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return adManager;
    }

    public static TTAdManager getAdManager() {
        return TTAdManagerFactory.a();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            d.a(tTAdConfig.getHttpStack());
        }
        e.a(true);
        e.a(new com.bytedance.sdk.openadsdk.g.b.a());
        m.a = tTAdConfig.isAsyncInit();
        m.b = tTAdConfig.getCustomController();
        if (tTAdConfig.isDebug()) {
            u.b();
            i.d().a(tTAdConfig.getAppId());
        }
        TTAdManager instance = TTAdManagerFactory.getInstance(context, tTAdConfig.isSupportMultiProcess());
        if (tTAdConfig.isDebug()) {
            instance.openDebugMode();
        }
        instance.setAppId(tTAdConfig.getAppId()).setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(tTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(tTAdConfig.isUseTextureView()).setTTDownloadEventLogger(tTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).setTTSecAbs(tTAdConfig.getTTSecAbs()).setCustomController(tTAdConfig.getCustomController());
        try {
            com.bytedance.sdk.openadsdk.utils.p.a();
        } catch (Throwable unused) {
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        if (tTAdConfig != null) {
            if (!TextUtils.isEmpty(tTAdConfig.getData())) {
                i.d().d(tTAdConfig.getData());
            }
            if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
                i.d().c(tTAdConfig.getKeywords());
            }
        }
    }

    public static void updatePaid(boolean z) {
        i.d().a(z);
    }
}
