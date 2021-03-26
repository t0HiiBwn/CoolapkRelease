package com.coolapk.market.service.action;

import android.content.Context;
import android.content.Intent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.LogUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/service/action/UpgradeAppsAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "getTaskKey", "", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "onHandleAction", "", "context", "Landroid/content/Context;", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpgradeAppsAction.kt */
public final class UpgradeAppsAction implements ServiceAction {
    public static final String ACTION_UPGRADE = "ACTION_UPGRADE";
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return "ACTION_UPGRADE";
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/service/action/UpgradeAppsAction$Companion;", "", "()V", "ACTION_UPGRADE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UpgradeAppsAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.service.ServiceAction
    public boolean isThisAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        return Intrinsics.areEqual("ACTION_UPGRADE", str);
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        LogUtils.v("升级应用", new Object[0]);
        List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
        Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "DataManager.getInstance(…AppUpgradeListFast(false)");
        for (T t : mobileAppUpgradeListFast) {
            Intrinsics.checkNotNullExpressionValue(t, "mobileApp");
            UpgradeInfo upgradeInfo = t.getUpgradeInfo();
            if (upgradeInfo != null) {
                ActionManager.startDownload(context, (MobileApp) t, upgradeInfo.getDownloadUrlTypeSmart());
            }
        }
    }
}
