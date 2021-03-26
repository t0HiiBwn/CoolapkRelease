package com.coolapk.market.widget.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/widget/view/FloatExpandedMenuView$hideWithAnimator$1$3"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $detach$inlined;
    final /* synthetic */ FloatExpandedMenuView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$3(FloatExpandedMenuView floatExpandedMenuView, boolean z) {
        super(0);
        this.this$0 = floatExpandedMenuView;
        this.$detach$inlined = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Function0<Unit> dismissListener = this.this$0.getDismissListener();
        if (dismissListener != null) {
            dismissListener.invoke();
        }
    }
}
