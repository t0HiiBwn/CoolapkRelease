package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/video/FeedVideoDetailViewPart$enterCommentView$2$1$1", "com/coolapk/market/view/video/FeedVideoDetailViewPart$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVideoDetailViewPart.kt */
final class FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1 this$0;

    FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1$lambda$1(FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1 feedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1) {
        this.this$0 = feedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FeedVideoDetailViewPart feedVideoDetailViewPart = this.this$0.this$0;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        feedVideoDetailViewPart.setCommentViewFraction(valueAnimator.getAnimatedFraction());
    }
}
