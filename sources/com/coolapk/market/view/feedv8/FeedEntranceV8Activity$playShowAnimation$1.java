package com.coolapk.market.view.feedv8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$playShowAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$playShowAnimation$1 extends AnimatorListenerAdapter {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEntranceV8Activity$playShowAnimation$1(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        FeedEntranceV8Activity.access$getImageView$p(this.this$0).setVisibility(0);
    }
}
