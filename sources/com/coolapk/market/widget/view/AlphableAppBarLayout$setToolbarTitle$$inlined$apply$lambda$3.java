package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ColorUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "ani", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/widget/view/AlphableAppBarLayout$setToolbarTitle$1$3"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlphableAppBarLayout.kt */
final class AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$3 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ String $newTitle$inlined;
    final /* synthetic */ Toolbar $toolbar$inlined;

    AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$3(String str, Toolbar toolbar) {
        this.$newTitle$inlined = str;
        this.$toolbar$inlined = toolbar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "ani");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        SpannableString spannableString = new SpannableString(this.$newTitle$inlined);
        spannableString.setSpan(new ForegroundColorSpan(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getMainTextColor(), floatValue)), 0, this.$newTitle$inlined.length(), 33);
        this.$toolbar$inlined.setTitle(spannableString);
    }
}
