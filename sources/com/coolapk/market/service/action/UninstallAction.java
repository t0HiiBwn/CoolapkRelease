package com.coolapk.market.service.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/service/action/UninstallAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "doUninstallAction", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getTaskKey", "", "isThisAction", "", "action", "onHandleAction", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UninstallAction.kt */
public final class UninstallAction implements ServiceAction {
    public static final String ACTION_UNINSTALL = "ACTION_UNINSTALL";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_EXTRA = "EXTRA";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    public static final String KEY_TITLE = "TITLE";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/service/action/UninstallAction$Companion;", "", "()V", "ACTION_UNINSTALL", "", "KEY_EXTRA", "KEY_PACKAGE_NAME", "KEY_TITLE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UninstallAction.kt */
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
        return Intrinsics.areEqual(str, "ACTION_UNINSTALL");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        if (!TextUtils.isEmpty(stringExtra)) {
            StringBuilder sb = new StringBuilder();
            String action = intent.getAction();
            Intrinsics.checkNotNull(action);
            sb.append(action);
            sb.append(stringExtra);
            String md5 = StringUtils.toMd5(sb.toString());
            Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(intent.action!! + packageName)");
            LogUtils.v("[Uninstall] Package Name: %s, key: %s", stringExtra, md5);
            return md5;
        }
        throw new RuntimeException("[Uninstall] Package name is empty");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        DataManager.getInstance().deliverUninstallWait(intent.getStringExtra("PACKAGE_NAME"), intent.getStringExtra("TITLE"));
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        doUninstallAction(context, intent);
    }

    private final void doUninstallAction(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        String stringExtra2 = intent.getStringExtra("TITLE");
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        DataManager.getInstance().uninstall(context, stringExtra, stringExtra2, appSetting.isInstallSilent());
    }
}
