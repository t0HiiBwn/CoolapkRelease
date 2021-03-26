package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/ViewVisibilityController$createShowAdapter$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewVisibilityController.kt */
public final class ViewVisibilityController$createShowAdapter$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewVisibilityController this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ViewVisibilityController$createShowAdapter$1(ViewVisibilityController viewVisibilityController) {
        this.this$0 = viewVisibilityController;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        Function0<Unit> onShow = this.this$0.getOnShow();
        if (onShow != null) {
            onShow.invoke();
        }
    }
}
