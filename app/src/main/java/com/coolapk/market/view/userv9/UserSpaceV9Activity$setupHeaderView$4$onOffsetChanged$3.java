package com.coolapk.market.view.userv9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupHeaderView$4$onOffsetChanged$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupHeaderView$4$onOffsetChanged$3 extends AnimatorListenerAdapter {
    final /* synthetic */ UserSpaceV9Activity$setupHeaderView$4 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    UserSpaceV9Activity$setupHeaderView$4$onOffsetChanged$3(UserSpaceV9Activity$setupHeaderView$4 userSpaceV9Activity$setupHeaderView$4) {
        this.this$0 = userSpaceV9Activity$setupHeaderView$4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.setHidingAnimation(false);
        LinearLayout linearLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).userToolbar.toolbarActionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userToolbar.toolbarActionContainer");
        linearLayout.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        this.this$0.setHidingAnimation(false);
    }
}
