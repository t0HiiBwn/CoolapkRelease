package com.coolapk.market.widget.video.cover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/video/cover/BaseControlCover$setControllerState$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseControlCover.kt */
public final class BaseControlCover$setControllerState$3 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $state;
    final /* synthetic */ BaseControlCover this$0;

    BaseControlCover$setControllerState$3(BaseControlCover baseControlCover, boolean z) {
        this.this$0 = baseControlCover;
        this.$state = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        if (this.$state) {
            this.this$0.getBottomContainer().setVisibility(0);
            this.this$0.getTopContainer().setVisibility(0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.$state) {
            this.this$0.getBottomContainer().setVisibility(8);
            this.this$0.getTopContainer().setVisibility(8);
        }
    }
}
