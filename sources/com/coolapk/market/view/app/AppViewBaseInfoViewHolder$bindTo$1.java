package com.coolapk.market.view.app;

import android.widget.TextView;
import com.coolapk.market.databinding.ItemAppViewBaseInfoBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
final class AppViewBaseInfoViewHolder$bindTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ItemAppViewBaseInfoBinding $binding;
    final /* synthetic */ AppViewBaseInfoViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewBaseInfoViewHolder$bindTo$1(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder, ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding) {
        super(0);
        this.this$0 = appViewBaseInfoViewHolder;
        this.$binding = itemAppViewBaseInfoBinding;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        AppViewViewModel access$getViewModel$p = AppViewBaseInfoViewHolder.access$getViewModel$p(this.this$0);
        TextView textView = this.$binding.changeLogContentView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.changeLogContentView");
        access$getViewModel$p.setShrinkChangeLog(textView.getLineCount() > 4);
    }
}
