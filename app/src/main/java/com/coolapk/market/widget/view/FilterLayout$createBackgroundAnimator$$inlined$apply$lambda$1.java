package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/widget/view/FilterLayout$createBackgroundAnimator$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FilterLayout.kt */
final class FilterLayout$createBackgroundAnimator$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $from$inlined;
    final /* synthetic */ int $to$inlined;
    final /* synthetic */ FilterLayout this$0;

    FilterLayout$createBackgroundAnimator$$inlined$apply$lambda$1(FilterLayout filterLayout, int i, int i2) {
        this.this$0 = filterLayout;
        this.$from$inlined = i;
        this.$to$inlined = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FilterLayout filterLayout = this.this$0;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        filterLayout.dispatchBackgroundColorListener(((Integer) animatedValue).intValue());
    }
}
