package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.view.View;
import com.coolapk.market.widget.view.SwipeScaleView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$doFinishAnimation$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
final class PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$3 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $currentAlpha$inlined;
    final /* synthetic */ float $initScale;
    final /* synthetic */ PhotoViewTransitionHelper this$0;

    PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$3(float f, PhotoViewTransitionHelper photoViewTransitionHelper, int i) {
        this.$initScale = f;
        this.this$0 = photoViewTransitionHelper;
        this.$currentAlpha$inlined = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this.this$0.colorDrawable.setAlpha((int) (((float) this.$currentAlpha$inlined) * floatValue));
        View root = this.this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.this$0.colorDrawable);
        SwipeScaleView swipeScaleView = this.this$0.binding.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
        swipeScaleView.setAlpha(floatValue);
        SwipeScaleView swipeScaleView2 = this.this$0.binding.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView2, "binding.swipeScaleView");
        float f = (floatValue * 0.3f) + 0.7f;
        swipeScaleView2.setScaleX(this.$initScale * f);
        SwipeScaleView swipeScaleView3 = this.this$0.binding.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView3, "binding.swipeScaleView");
        swipeScaleView3.setScaleY(f * this.$initScale);
    }
}
