package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/ViewVisibilityController$doHide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewVisibilityController.kt */
public final class ViewVisibilityController$doHide$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewVisibilityController this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ViewVisibilityController$doHide$1(ViewVisibilityController viewVisibilityController) {
        this.this$0 = viewVisibilityController;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.isHidingAnimation = false;
        this.this$0.view.setVisibility(8);
        Function0<Unit> onHide = this.this$0.getOnHide();
        if (onHide != null) {
            onHide.invoke();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        this.this$0.isHidingAnimation = false;
    }
}
