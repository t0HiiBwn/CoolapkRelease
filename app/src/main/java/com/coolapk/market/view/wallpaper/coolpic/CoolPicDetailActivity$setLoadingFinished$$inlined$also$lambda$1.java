package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity$setLoadingFinished$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
public final class CoolPicDetailActivity$setLoadingFinished$$inlined$also$lambda$1 extends AnimatorListenerAdapter {
    final /* synthetic */ CoolPicDetailActivity this$0;

    CoolPicDetailActivity$setLoadingFinished$$inlined$also$lambda$1(CoolPicDetailActivity coolPicDetailActivity) {
        this.this$0 = coolPicDetailActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        FrameLayout frameLayout = CoolPicDetailActivity.access$getBinding$p(this.this$0).loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(8);
        this.this$0.isLoading = false;
    }
}
