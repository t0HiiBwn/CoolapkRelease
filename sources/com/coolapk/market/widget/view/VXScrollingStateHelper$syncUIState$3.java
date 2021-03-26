package com.coolapk.market.widget.view;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: VXProxyFloatingView.kt */
final class VXScrollingStateHelper$syncUIState$3 implements Runnable {
    final /* synthetic */ VXScrollingStateHelper this$0;

    VXScrollingStateHelper$syncUIState$3(VXScrollingStateHelper vXScrollingStateHelper) {
        this.this$0 = vXScrollingStateHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.checkFloatViewScrollOffset();
    }
}
