package com.coolapk.market.receiver;

import android.content.Context;
import android.content.Intent;
import com.coolapk.market.util.PendingAppsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/receiver/PackageReceiverImpl;", "Lcom/coolapk/market/receiver/PackageReceiver;", "()V", "onPackageAdded", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "packageName", "", "onPackageRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PackageReceiverImpl.kt */
public final class PackageReceiverImpl extends PackageReceiver {
    @Override // com.coolapk.market.receiver.PackageReceiver
    public void onPackageAdded(Context context, Intent intent, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "packageName");
        PendingAppsUtils.doAddAction(context, str);
    }

    @Override // com.coolapk.market.receiver.PackageReceiver
    public void onPackageRemoved(Context context, Intent intent, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "packageName");
        PendingAppsUtils.doRemoveAction(context, str);
        PendingAppsUtils.INSTANCE.doPendingReinstallAction(context, str);
    }
}
