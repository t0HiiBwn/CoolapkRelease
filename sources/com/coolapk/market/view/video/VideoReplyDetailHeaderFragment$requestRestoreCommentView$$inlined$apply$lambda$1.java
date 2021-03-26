package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/video/VideoReplyDetailHeaderFragment$requestRestoreCommentView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoReplyDetailHeaderFragment.kt */
final class VideoReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float $startTranslateY$inlined;
    final /* synthetic */ VideoReplyDetailHeaderFragment this$0;

    VideoReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$1(VideoReplyDetailHeaderFragment videoReplyDetailHeaderFragment, float f) {
        this.this$0 = videoReplyDetailHeaderFragment;
        this.$startTranslateY$inlined = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View root = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        float f = this.$startTranslateY$inlined;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        root.setTranslationY(f * (((float) 1) - valueAnimator.getAnimatedFraction()));
    }
}
