package com.coolapk.market.view.ad.tencent;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.qq.e.comm.managers.GDTADManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/ad/tencent/GDTAdManagerHolder;", "", "()V", "isInit", "", "()Z", "setInit", "(Z)V", "init", "", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GDTAdManagerHolder.kt */
public final class GDTAdManagerHolder {
    public static final GDTAdManagerHolder INSTANCE = new GDTAdManagerHolder();
    private static boolean isInit;

    private GDTAdManagerHolder() {
    }

    public final boolean isInit() {
        return isInit;
    }

    public final void setInit(boolean z) {
        isInit = z;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isInit) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("Ad.GDT_APP_ID");
            Intrinsics.checkNotNullExpressionValue(optString, "it");
            if (!(!StringsKt.isBlank(optString))) {
                optString = null;
            }
            if (optString == null) {
                optString = "1107915162";
            }
            GDTADManager.getInstance().initWith(context, optString);
            isInit = true;
        }
    }
}
