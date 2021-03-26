package com.coolapk.market.view.feedv8;

import android.transition.TransitionManager;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "call", "com/coolapk/market/view/feedv8/GoodsContentHolder$onCreateContentView$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$5 implements Action0 {
    final /* synthetic */ GoodsContentHolder this$0;

    GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$5(GoodsContentHolder goodsContentHolder) {
        this.this$0 = goodsContentHolder;
    }

    @Override // rx.functions.Action0
    public final void call() {
        TransitionManager.beginDelayedTransition(this.this$0.getBinding$presentation_coolapkAppRelease().warningView);
        if (this.this$0.getAdapter$presentation_coolapkAppRelease().getImageUrls().isEmpty()) {
            LinearLayout linearLayout = this.this$0.getBinding$presentation_coolapkAppRelease().warningView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.warningView");
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = this.this$0.getBinding$presentation_coolapkAppRelease().warningView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.warningView");
        linearLayout2.setVisibility(8);
    }
}
