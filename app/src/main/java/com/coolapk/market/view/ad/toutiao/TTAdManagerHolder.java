package com.coolapk.market.view.ad.toutiao;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/TTAdManagerHolder;", "", "()V", "isInit", "", "buildConfig", "Lcom/bytedance/sdk/openadsdk/TTAdConfig;", "context", "Landroid/content/Context;", "appId", "", "get", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "init", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTAdManagerHolder.kt */
public final class TTAdManagerHolder {
    public static final TTAdManagerHolder INSTANCE = new TTAdManagerHolder();
    private static boolean isInit;

    private TTAdManagerHolder() {
    }

    public final TTAdManager get() {
        TTAdManager adManager = TTAdSdk.getAdManager();
        Intrinsics.checkNotNullExpressionValue(adManager, "TTAdSdk.getAdManager()");
        return adManager;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isInit) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("Ad.TT_APP_ID");
            Intrinsics.checkNotNullExpressionValue(optString, "it");
            if (!(!StringsKt.isBlank(optString))) {
                optString = null;
            }
            if (optString == null) {
                optString = "5014732";
            }
            TTAdSdk.init(context, buildConfig(context, optString));
            isInit = true;
        }
    }

    private final TTAdConfig buildConfig(Context context, String str) {
        TTAdConfig build = new TTAdConfig.Builder().appName(context.getString(2131886221)).appId(str).allowShowNotify(true).titleBarTheme(1).debug(false).directDownloadNetworkType(4).supportMultiProcess(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "TTAdConfig.Builder()\n   …\n                .build()");
        return build;
    }
}
