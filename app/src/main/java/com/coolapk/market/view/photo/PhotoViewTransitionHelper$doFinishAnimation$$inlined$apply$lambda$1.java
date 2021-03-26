package com.coolapk.market.view.photo;

import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.coolapk.market.widget.view.SwipeScaleView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$doFinishAnimation$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
final class PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $currentAlpha$inlined;
    final /* synthetic */ Rect $endClipRect$inlined;
    final /* synthetic */ float $endScaleX$inlined;
    final /* synthetic */ float $endTranslateX$inlined;
    final /* synthetic */ float $endTranslateY$inlined;
    final /* synthetic */ FloatEvaluator $floatEvaluator$inlined;
    final /* synthetic */ RectEvaluator $rectEvaluator$inlined;
    final /* synthetic */ Rect $startClipRect$inlined;
    final /* synthetic */ float $startScale$inlined;
    final /* synthetic */ float $startTransitionX$inlined;
    final /* synthetic */ float $startTransitionY$inlined;
    final /* synthetic */ SwipeScaleView $view$inlined;
    final /* synthetic */ PhotoViewTransitionHelper this$0;

    PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$1(PhotoViewTransitionHelper photoViewTransitionHelper, SwipeScaleView swipeScaleView, FloatEvaluator floatEvaluator, float f, float f2, float f3, float f4, float f5, float f6, RectEvaluator rectEvaluator, Rect rect, Rect rect2, int i) {
        this.this$0 = photoViewTransitionHelper;
        this.$view$inlined = swipeScaleView;
        this.$floatEvaluator$inlined = floatEvaluator;
        this.$startTransitionX$inlined = f;
        this.$endTranslateX$inlined = f2;
        this.$startTransitionY$inlined = f3;
        this.$endTranslateY$inlined = f4;
        this.$startScale$inlined = f5;
        this.$endScaleX$inlined = f6;
        this.$rectEvaluator$inlined = rectEvaluator;
        this.$startClipRect$inlined = rect;
        this.$endClipRect$inlined = rect2;
        this.$currentAlpha$inlined = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        SwipeScaleView swipeScaleView = this.$view$inlined;
        Float evaluate = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startTransitionX$inlined), (Number) Float.valueOf(this.$endTranslateX$inlined));
        Intrinsics.checkNotNullExpressionValue(evaluate, "floatEvaluator.evaluate(…ansitionX, endTranslateX)");
        swipeScaleView.setTranslationX(evaluate.floatValue());
        SwipeScaleView swipeScaleView2 = this.$view$inlined;
        Float evaluate2 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startTransitionY$inlined), (Number) Float.valueOf(this.$endTranslateY$inlined));
        Intrinsics.checkNotNullExpressionValue(evaluate2, "floatEvaluator.evaluate(…ansitionY, endTranslateY)");
        swipeScaleView2.setTranslationY(evaluate2.floatValue());
        SwipeScaleView swipeScaleView3 = this.$view$inlined;
        Float evaluate3 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startScale$inlined), (Number) Float.valueOf(this.$endScaleX$inlined));
        Intrinsics.checkNotNullExpressionValue(evaluate3, "floatEvaluator.evaluate(…n, startScale, endScaleX)");
        swipeScaleView3.setScaleX(evaluate3.floatValue());
        SwipeScaleView swipeScaleView4 = this.$view$inlined;
        Float evaluate4 = this.$floatEvaluator$inlined.evaluate(animatedFraction, (Number) Float.valueOf(this.$startScale$inlined), (Number) Float.valueOf(this.$endScaleX$inlined));
        Intrinsics.checkNotNullExpressionValue(evaluate4, "floatEvaluator.evaluate(…n, startScale, endScaleX)");
        swipeScaleView4.setScaleY(evaluate4.floatValue());
        this.$view$inlined.setClipBounds(this.$rectEvaluator$inlined.evaluate(animatedFraction, this.$startClipRect$inlined, this.$endClipRect$inlined));
        ColorDrawable colorDrawable = this.this$0.colorDrawable;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        colorDrawable.setAlpha((int) (((Float) animatedValue).floatValue() * ((float) this.$currentAlpha$inlined)));
        View root = this.this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.this$0.colorDrawable);
    }
}
