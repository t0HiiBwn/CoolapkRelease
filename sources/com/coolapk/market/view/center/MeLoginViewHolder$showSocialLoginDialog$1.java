package com.coolapk.market.view.center;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MeLoginViewHolder.kt */
final class MeLoginViewHolder$showSocialLoginDialog$1 implements View.OnClickListener {
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ MeLoginViewHolder this$0;

    MeLoginViewHolder$showSocialLoginDialog$1(MeLoginViewHolder meLoginViewHolder, AlertDialog alertDialog) {
        this.this$0 = meLoginViewHolder;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.this$0.onClick(view);
        this.$dialog.dismiss();
    }
}
