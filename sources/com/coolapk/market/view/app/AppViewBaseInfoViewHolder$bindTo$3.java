package com.coolapk.market.view.app;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
final class AppViewBaseInfoViewHolder$bindTo$3 implements View.OnClickListener {
    final /* synthetic */ AppViewBaseInfoViewHolder this$0;

    AppViewBaseInfoViewHolder$bindTo$3(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder) {
        this.this$0 = appViewBaseInfoViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AppViewBaseInfoViewHolder.access$getViewModel$p(this.this$0).setIntroduceMaxWords(AppViewBaseInfoViewHolder.access$getViewModel$p(this.this$0).getIntroduceMaxWords() != null ? null : 60);
    }
}
