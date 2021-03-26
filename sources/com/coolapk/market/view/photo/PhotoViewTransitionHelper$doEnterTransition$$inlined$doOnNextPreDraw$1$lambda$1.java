package com.coolapk.market.view.photo;

import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$doEnterTransition$1$animator$1$1", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
final class PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ Rect $endBounds$inlined;
    final /* synthetic */ FloatEvaluator $floatEvaluator$inlined;
    final /* synthetic */ RectEvaluator $rectEvaluator$inlined;
    final /* synthetic */ Rect $startClipRect$inlined;
    final /* synthetic */ float $startScale$inlined;
    final /* synthetic */ float $startTransitionX$inlined;
    final /* synthetic */ float $startTransitionY$inlined;
    final /* synthetic */ PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1 this$0;

    PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$1(FloatEvaluator floatEvaluator, float f, float f2, float f3, RectEvaluator rectEvaluator, Rect rect, Rect rect2, PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1 photoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1) {
        this.$floatEvaluator$inlined = floatEvaluator;
        this.$startTransitionX$inlined = f;
        this.$startTransitionY$inlined = f2;
        this.$startScale$inlined = f3;
        this.$rectEvaluator$inlined = rectEvaluator;
        this.$startClipRect$inlined = rect;
        this.$endBounds$inlined = rect2;
        this.this$0 = photoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        SwipeScaleView swipeScaleView = this.this$0.$view$inlined;
        Float valueOf = Float.valueOf(0.0f);
        Float evaluate = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startTransitionX$inlined), (Number) valueOf);
        Intrinsics.checkNotNullExpressionValue(evaluate, "floatEvaluator.evaluate(…on, startTransitionX, 0f)");
        swipeScaleView.setTranslationX(evaluate.floatValue());
        SwipeScaleView swipeScaleView2 = this.this$0.$view$inlined;
        Float evaluate2 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startTransitionY$inlined), (Number) valueOf);
        Intrinsics.checkNotNullExpressionValue(evaluate2, "floatEvaluator.evaluate(…on, startTransitionY, 0f)");
        swipeScaleView2.setTranslationY(evaluate2.floatValue());
        SwipeScaleView swipeScaleView3 = this.this$0.$view$inlined;
        Float valueOf2 = Float.valueOf(1.0f);
        Float evaluate3 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startScale$inlined), (Number) valueOf2);
        Intrinsics.checkNotNullExpressionValue(evaluate3, "floatEvaluator.evaluate(fraction, startScale, 1f)");
        swipeScaleView3.setScaleX(evaluate3.floatValue());
        SwipeScaleView swipeScaleView4 = this.this$0.$view$inlined;
        Float evaluate4 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startScale$inlined), (Number) valueOf2);
        Intrinsics.checkNotNullExpressionValue(evaluate4, "floatEvaluator.evaluate(fraction, startScale, 1f)");
        swipeScaleView4.setScaleY(evaluate4.floatValue());
        this.this$0.$view$inlined.setClipBounds(this.$rectEvaluator$inlined.evaluate(animatedFraction, this.$startClipRect$inlined, this.$endBounds$inlined));
        this.this$0.this$0.colorDrawable.setAlpha((int) (animatedFraction * ((float) 255)));
        View root = this.this$0.this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.this$0.this$0.colorDrawable);
    }
}
