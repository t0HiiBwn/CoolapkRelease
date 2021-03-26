package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.view.View;
import com.coolapk.market.databinding.SplashViewBinding;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
final class SplashView$exeAutoFinish$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ SplashView this$0;

    SplashView$exeAutoFinish$1(SplashView splashView) {
        this.this$0 = splashView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        SplashViewBinding binding = this.this$0.getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setAlpha(floatValue);
    }
}
