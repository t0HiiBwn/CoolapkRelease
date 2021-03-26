package com.coolapk.market.widget.video.cover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/video/cover/ControllerCover$setTopContainerState$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
public final class ControllerCover$setTopContainerState$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $state;
    final /* synthetic */ ControllerCover this$0;

    ControllerCover$setTopContainerState$1(ControllerCover controllerCover, boolean z) {
        this.this$0 = controllerCover;
        this.$state = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationStart(animator);
        if (this.$state) {
            View root = ControllerCover.access$getBinding$p(this.this$0).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setSystemUiVisibility(this.this$0.defaultSystemUIFlag);
            LinearLayout linearLayout = ControllerCover.access$getBinding$p(this.this$0).topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            linearLayout.setVisibility(0);
            return;
        }
        View root2 = ControllerCover.access$getBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        root2.setSystemUiVisibility(5638);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        if (!this.$state) {
            LinearLayout linearLayout = ControllerCover.access$getBinding$p(this.this$0).topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            linearLayout.setVisibility(8);
        }
    }
}
