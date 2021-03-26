package com.coolapk.market.view.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.graphics.Rect;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, d2 = {"com/coolapk/market/view/photo/PhotoViewTransitionHelper$doEnterTransition$1$animator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease", "com/coolapk/market/view/photo/PhotoViewTransitionHelper$$special$$inlined$apply$lambda$2"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
public final class PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Rect $endBounds$inlined;
    final /* synthetic */ FloatEvaluator $floatEvaluator$inlined;
    final /* synthetic */ RectEvaluator $rectEvaluator$inlined;
    final /* synthetic */ Rect $startClipRect$inlined;
    final /* synthetic */ float $startScale$inlined;
    final /* synthetic */ float $startTransitionX$inlined;
    final /* synthetic */ float $startTransitionY$inlined;
    final /* synthetic */ PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1 this$0;

    PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$2(FloatEvaluator floatEvaluator, float f, float f2, float f3, RectEvaluator rectEvaluator, Rect rect, Rect rect2, PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1 photoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1) {
        this.$floatEvaluator$inlined = floatEvaluator;
        this.$startTransitionX$inlined = f;
        this.$startTransitionY$inlined = f2;
        this.$startScale$inlined = f3;
        this.$rectEvaluator$inlined = rectEvaluator;
        this.$startClipRect$inlined = rect;
        this.$endBounds$inlined = rect2;
        this.this$0 = photoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.$view$inlined.setClipBounds(null);
    }
}
