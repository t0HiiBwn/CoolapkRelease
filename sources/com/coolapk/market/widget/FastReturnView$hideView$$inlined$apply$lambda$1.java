package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/coolapk/market/widget/FastReturnView$hideView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView$hideView$$inlined$apply$lambda$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $immediately$inlined;
    final /* synthetic */ FastReturnView this$0;

    FastReturnView$hideView$$inlined$apply$lambda$1(FastReturnView fastReturnView, boolean z) {
        this.this$0 = fastReturnView;
        this.$immediately$inlined = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.this$0.setVisibility(4);
        this.this$0.setOnTouchListener(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.this$0.setVisibility(4);
        this.this$0.setOnTouchListener(null);
    }
}
