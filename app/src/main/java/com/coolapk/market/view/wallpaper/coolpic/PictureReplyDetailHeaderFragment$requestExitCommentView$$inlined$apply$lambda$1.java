package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$requestExitCommentView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailHeaderFragment.kt */
final class PictureReplyDetailHeaderFragment$requestExitCommentView$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float $startTranslateY$inlined;
    final /* synthetic */ PictureReplyDetailHeaderFragment this$0;

    PictureReplyDetailHeaderFragment$requestExitCommentView$$inlined$apply$lambda$1(PictureReplyDetailHeaderFragment pictureReplyDetailHeaderFragment, float f) {
        this.this$0 = pictureReplyDetailHeaderFragment;
        this.$startTranslateY$inlined = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View root = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        root.setTranslationY(((((float) recyclerView.getHeight()) - this.$startTranslateY$inlined) * valueAnimator.getAnimatedFraction()) + this.$startTranslateY$inlined);
    }
}
