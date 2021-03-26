package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$1$1$1", "com/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailHeaderFragment.kt */
final class PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1 this$0;

    PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$1(PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1 pictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1) {
        this.this$0 = pictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.this$0.$fragment$inlined.getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "fragment.view ?: return@addUpdateListener");
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
            view.setTranslationY(((float) view.getHeight()) * (((float) 1) - valueAnimator.getAnimatedFraction()));
        }
    }
}
