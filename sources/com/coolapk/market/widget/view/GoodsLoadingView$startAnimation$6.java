package com.coolapk.market.widget.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsLoadingView.kt */
final class GoodsLoadingView$startAnimation$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $silentTime;
    final /* synthetic */ GoodsLoadingView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsLoadingView$startAnimation$6(GoodsLoadingView goodsLoadingView, long j) {
        super(0);
        this.this$0 = goodsLoadingView;
        this.$silentTime = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.delayStartAnimation(this.$silentTime);
    }
}
