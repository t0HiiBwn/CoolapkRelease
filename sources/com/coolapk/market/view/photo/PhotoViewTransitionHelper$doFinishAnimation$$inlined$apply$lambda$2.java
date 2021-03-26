package com.coolapk.market.view.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.graphics.Rect;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/photo/PhotoViewTransitionHelper$doFinishAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
public final class PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
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

    PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$2(PhotoViewTransitionHelper photoViewTransitionHelper, SwipeScaleView swipeScaleView, FloatEvaluator floatEvaluator, float f, float f2, float f3, float f4, float f5, float f6, RectEvaluator rectEvaluator, Rect rect, Rect rect2, int i) {
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

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.getActivity().finish();
        this.this$0.getActivity().overridePendingTransition(0, 0);
    }
}
