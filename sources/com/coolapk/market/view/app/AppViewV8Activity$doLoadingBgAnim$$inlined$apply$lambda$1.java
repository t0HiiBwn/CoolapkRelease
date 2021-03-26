package com.coolapk.market.view.app;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/app/AppViewV8Activity$doLoadingBgAnim$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
final class AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ AppViewV8Activity this$0;

    AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$1(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ProgressBar progressBar = AppViewV8Activity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        progressBar.setAlpha(((Float) animatedValue).floatValue());
        ImageView imageView = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        imageView.setAlpha(((Float) animatedValue2).floatValue());
        FrameLayout frameLayout = AppViewV8Activity.access$getBinding$p(this.this$0).appViewRecycler;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appViewRecycler");
        Object animatedValue3 = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((float) 1) - ((Float) animatedValue3).floatValue());
    }
}
