package com.coolapk.market.widget.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/widget/view/FloatExpandedMenuView$showWithAnimator$1$1$2", "com/coolapk/market/widget/view/FloatExpandedMenuView$$special$$inlined$apply$lambda$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1$lambda$2(FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1 floatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1) {
        super(0);
        this.this$0 = floatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.this$0.isAnimating = false;
        this.this$0.this$0.setBackPressToHide();
    }
}
