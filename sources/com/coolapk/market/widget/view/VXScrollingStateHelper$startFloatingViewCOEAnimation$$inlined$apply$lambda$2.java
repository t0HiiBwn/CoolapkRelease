package com.coolapk.market.widget.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/widget/view/VXScrollingStateHelper$startFloatingViewCOEAnimation$2$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: VXProxyFloatingView.kt */
final class VXScrollingStateHelper$startFloatingViewCOEAnimation$$inlined$apply$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $assumedDuration$inlined;
    final /* synthetic */ FloatingState $pendingState$inlined;
    final /* synthetic */ VXScrollingStateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VXScrollingStateHelper$startFloatingViewCOEAnimation$$inlined$apply$lambda$2(VXScrollingStateHelper vXScrollingStateHelper, FloatingState floatingState, long j) {
        super(0);
        this.this$0 = vXScrollingStateHelper;
        this.$pendingState$inlined = floatingState;
        this.$assumedDuration$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.setFloatingState(this.$pendingState$inlined);
    }
}
