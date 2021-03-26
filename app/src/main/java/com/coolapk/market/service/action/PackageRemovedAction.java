package com.coolapk.market.service.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/service/action/PackageRemovedAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "getTaskKey", "", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "onHandleAction", "", "context", "Landroid/content/Context;", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PackageRemovedAction.kt */
public final class PackageRemovedAction implements ServiceAction {
    public static final String ACTION_PACKAGE_REMOVED = "ACTION_PACKAGE_REMOVED";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/service/action/PackageRemovedAction$Companion;", "", "()V", "ACTION_PACKAGE_REMOVED", "", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PackageRemovedAction.kt */
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
        return Intrinsics.areEqual(str, "ACTION_PACKAGE_REMOVED");
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
            LogUtils.v("[Packager removed] Package Name: %s, key: %s", stringExtra, md5);
            return md5;
        }
        throw new RuntimeException("[Packager removed] Package name is empty");
    }
}
