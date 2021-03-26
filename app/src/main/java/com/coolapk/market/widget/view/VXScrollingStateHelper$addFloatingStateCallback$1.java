package com.coolapk.market.widget.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/view/VXScrollingStateHelper$addFloatingStateCallback$1", "Lcom/coolapk/market/widget/view/ScrollStateHelperCallback;", "onFloatingStateChanged", "", "state", "Lcom/coolapk/market/widget/view/FloatingState;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXProxyFloatingView.kt */
public final class VXScrollingStateHelper$addFloatingStateCallback$1 implements ScrollStateHelperCallback {
    final /* synthetic */ Function1 $callback;

    VXScrollingStateHelper$addFloatingStateCallback$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // com.coolapk.market.widget.view.ScrollStateHelperCallback
    public void onFloatingStateChanged(FloatingState floatingState) {
        Intrinsics.checkNotNullParameter(floatingState, "state");
        this.$callback.invoke(floatingState);
    }
}
