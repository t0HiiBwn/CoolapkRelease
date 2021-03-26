package com.coolapk.market.view.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$doLoadingBgAnim$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ AppViewV8Activity this$0;

    AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$2(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ProgressBar progressBar = AppViewV8Activity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        ImageView imageView = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        imageView.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ProgressBar progressBar = AppViewV8Activity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        ImageView imageView = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        imageView.setVisibility(8);
    }
}
