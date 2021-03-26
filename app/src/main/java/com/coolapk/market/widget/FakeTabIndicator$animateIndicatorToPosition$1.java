package com.coolapk.market.widget;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
/* compiled from: FakeTabIndicator.kt */
final class FakeTabIndicator$animateIndicatorToPosition$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $startLeft;
    final /* synthetic */ int $startRight;
    final /* synthetic */ int $targetLeft;
    final /* synthetic */ int $targetRight;
    final /* synthetic */ FakeTabIndicator this$0;

    FakeTabIndicator$animateIndicatorToPosition$1(FakeTabIndicator fakeTabIndicator, int i, int i2, int i3, int i4) {
        this.this$0 = fakeTabIndicator;
        this.$startLeft = i;
        this.$targetLeft = i2;
        this.$startRight = i3;
        this.$targetRight = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animator");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.this$0.setIndicatorPosition(FakeTabIndicator.Companion.lerp(this.$startLeft, this.$targetLeft, animatedFraction), FakeTabIndicator.Companion.lerp(this.$startRight, this.$targetRight, animatedFraction));
    }
}
