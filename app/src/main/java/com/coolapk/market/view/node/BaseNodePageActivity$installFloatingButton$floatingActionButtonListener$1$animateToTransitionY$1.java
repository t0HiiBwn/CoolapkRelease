package com.coolapk.market.view.node;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1$animateToTransitionY$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1$animateToTransitionY$1 extends AnimatorListenerAdapter {
    final /* synthetic */ BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1$animateToTransitionY$1(BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1) {
        this.this$0 = baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.isMoveDownAnimating = 0;
    }
}
