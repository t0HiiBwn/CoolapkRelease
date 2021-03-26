package com.coolapk.market.extend;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/extend/ViewExtendsKt$fadeForeground$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$fadeForeground$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ColorDrawable $colorAccentBackground;
    final /* synthetic */ Drawable $oldForeground$inlined;
    final /* synthetic */ View $this_fadeForeground$inlined;

    ViewExtendsKt$fadeForeground$$inlined$apply$lambda$1(ColorDrawable colorDrawable, View view, Drawable drawable) {
        this.$colorAccentBackground = colorDrawable;
        this.$this_fadeForeground$inlined = view;
        this.$oldForeground$inlined = drawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ColorDrawable colorDrawable = this.$colorAccentBackground;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        colorDrawable.setAlpha(((Integer) animatedValue).intValue());
        this.$this_fadeForeground$inlined.setForeground(this.$colorAccentBackground);
    }
}
