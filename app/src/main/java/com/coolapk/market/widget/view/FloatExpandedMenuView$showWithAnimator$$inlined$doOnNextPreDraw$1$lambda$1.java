package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/widget/view/FloatExpandedMenuView$showWithAnimator$1$1$1", "com/coolapk/market/widget/view/FloatExpandedMenuView$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1 this$0;

    FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1$lambda$1(FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1 floatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1) {
        this.this$0 = floatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this.this$0.this$0.bgMaskView.setAlpha(floatValue);
        this.this$0.this$0.contentView.setTranslationY((floatValue - ((float) 1)) * ((float) this.this$0.this$0.contentView.getHeight()));
    }
}
