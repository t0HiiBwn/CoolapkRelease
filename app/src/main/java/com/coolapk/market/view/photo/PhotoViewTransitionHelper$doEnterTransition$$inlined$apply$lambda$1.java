package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.view.View;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$doEnterTransition$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
final class PhotoViewTransitionHelper$doEnterTransition$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ PhotoViewTransitionHelper this$0;

    PhotoViewTransitionHelper$doEnterTransition$$inlined$apply$lambda$1(PhotoViewTransitionHelper photoViewTransitionHelper) {
        this.this$0 = photoViewTransitionHelper;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.this$0.colorDrawable.setAlpha((int) (((float) 255) * animatedFraction));
        View root = this.this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.this$0.colorDrawable);
        SwipeScaleView swipeScaleView = this.this$0.binding.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
        float f = (animatedFraction * 0.2f) + 0.8f;
        swipeScaleView.setScaleX(f);
        SwipeScaleView swipeScaleView2 = this.this$0.binding.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView2, "binding.swipeScaleView");
        swipeScaleView2.setScaleY(f);
    }
}
