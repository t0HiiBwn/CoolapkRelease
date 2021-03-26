package com.coolapk.market.widget.video.cover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/video/cover/ControllerCover$setBottomContainerState$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
public final class ControllerCover$setBottomContainerState$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $state;
    final /* synthetic */ ControllerCover this$0;

    ControllerCover$setBottomContainerState$1(ControllerCover controllerCover, boolean z) {
        this.this$0 = controllerCover;
        this.$state = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationStart(animator);
        if (this.$state) {
            LinearLayout linearLayout = ControllerCover.access$getBinding$p(this.this$0).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
            linearLayout.setVisibility(0);
            ProgressBar progressBar = ControllerCover.access$getBinding$p(this.this$0).progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setVisibility(4);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        if (!this.$state) {
            LinearLayout linearLayout = ControllerCover.access$getBinding$p(this.this$0).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
            linearLayout.setVisibility(8);
            if (!(this.this$0.isUnseekable)) {
                ProgressBar progressBar = ControllerCover.access$getBinding$p(this.this$0).progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
                progressBar.setVisibility(0);
            }
        }
    }
}
