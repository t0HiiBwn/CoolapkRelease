package com.coolapk.market.design;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class CoolapkCardView$checkShouldCopyChildState$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ View $this_doOnAttach;
    final /* synthetic */ CoolapkCardView this$0;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    public CoolapkCardView$checkShouldCopyChildState$$inlined$doOnAttach$1(View view, CoolapkCardView coolapkCardView) {
        this.$this_doOnAttach = view;
        this.this$0 = coolapkCardView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        if (!this.this$0.isClickable()) {
            boolean z = false;
            int i = this.this$0.debugTextView != null ? 1 : 0;
            if (this.this$0.getChildCount() > i) {
                View childAt = this.this$0.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(childOffset)");
                z = childAt.isClickable();
            }
            this.this$0.setFocusable(z);
            this.this$0.setClickable(z);
            this.this$0.setAddStatesFromChildren(z);
        }
    }
}
