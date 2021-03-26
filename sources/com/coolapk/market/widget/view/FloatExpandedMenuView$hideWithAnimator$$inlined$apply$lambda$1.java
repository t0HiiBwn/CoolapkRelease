package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/widget/view/FloatExpandedMenuView$hideWithAnimator$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ boolean $detach$inlined;
    final /* synthetic */ FloatExpandedMenuView this$0;

    FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$1(FloatExpandedMenuView floatExpandedMenuView, boolean z) {
        this.this$0 = floatExpandedMenuView;
        this.$detach$inlined = z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this.this$0.bgMaskView.setAlpha(floatValue);
        this.this$0.contentView.setTranslationY((floatValue - ((float) 1)) * ((float) this.this$0.contentView.getHeight()));
    }
}
