package com.coolapk.market.view.app;

import android.content.DialogInterface;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
final class AppViewBaseInfoViewHolder$onClick$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ AppViewBaseInfoViewHolder this$0;

    AppViewBaseInfoViewHolder$onClick$1(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder) {
        this.this$0 = appViewBaseInfoViewHolder;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ActionManager.startDownload(this.this$0.getContext(), AppViewBaseInfoViewHolder.access$getServiceApp$p(this.this$0), 0);
    }
}
