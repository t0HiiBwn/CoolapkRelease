package com.coolapk.market.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onGlobalLayout"}, k = 3, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
final class FastReturnView$dependentAboveOn$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ View $view;
    final /* synthetic */ FastReturnView this$0;

    FastReturnView$dependentAboveOn$1(FastReturnView fastReturnView, View view) {
        this.this$0 = fastReturnView;
        this.$view = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean z = this.$view.getVisibility() == 8;
        if (z != this.this$0.dependentViewGone) {
            this.this$0.dependentViewGone = z;
            this.this$0.updateBottomMargin();
        }
    }
}
