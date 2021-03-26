package com.coolapk.market.view.appmanager;

import android.content.DialogInterface;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.MobileApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppFragment.kt */
final class MobileAppFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ MobileApp $mobileApp;
    final /* synthetic */ MobileAppFragment$DataAdapter$onCreateViewHolder$1 this$0;

    MobileAppFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1(MobileAppFragment$DataAdapter$onCreateViewHolder$1 mobileAppFragment$DataAdapter$onCreateViewHolder$1, MobileApp mobileApp) {
        this.this$0 = mobileAppFragment$DataAdapter$onCreateViewHolder$1;
        this.$mobileApp = mobileApp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MobileApp mobileApp = this.$mobileApp;
        Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
        String packageName = mobileApp.getPackageName();
        MobileApp mobileApp2 = this.$mobileApp;
        Intrinsics.checkNotNullExpressionValue(mobileApp2, "mobileApp");
        ActionManager.uninstall(this.this$0.this$0.this$0.getActivity(), packageName, mobileApp2.getAppName());
    }
}
