package com.coolapk.market.view.node.app;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.widget.ActionButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/node/app/AppNodeToolbar;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeToolbar$updateWithAppMode$1 extends Lambda implements Function1<AppNodeToolbar, Unit> {
    final /* synthetic */ AppNodeToolbar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeToolbar$updateWithAppMode$1(AppNodeToolbar appNodeToolbar) {
        super(1);
        this.this$0 = appNodeToolbar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppNodeToolbar appNodeToolbar) {
        invoke(appNodeToolbar);
        return Unit.INSTANCE;
    }

    public final void invoke(AppNodeToolbar appNodeToolbar) {
        Intrinsics.checkNotNullParameter(appNodeToolbar, "it");
        LinearLayout linearLayout = AppNodeToolbar.access$getBinding$p(this.this$0).scoreViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.scoreViewContainer");
        linearLayout.setVisibility(4);
        ActionButton actionButton = AppNodeToolbar.access$getBinding$p(this.this$0).actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "binding.actionButton");
        actionButton.setVisibility(8);
        ActionButton actionButton2 = AppNodeToolbar.access$getBinding$p(this.this$0).followActionView;
        Intrinsics.checkNotNullExpressionValue(actionButton2, "binding.followActionView");
        actionButton2.setVisibility(0);
        TextView textView = AppNodeToolbar.access$getBinding$p(this.this$0).hotView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hotView");
        textView.setVisibility(0);
    }
}
