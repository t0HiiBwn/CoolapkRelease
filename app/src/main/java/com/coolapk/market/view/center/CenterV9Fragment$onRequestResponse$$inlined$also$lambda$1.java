package com.coolapk.market.view.center;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/center/CenterV9Fragment$onRequestResponse$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
public final class CenterV9Fragment$onRequestResponse$$inlined$also$lambda$1 extends AnimatorListenerAdapter {
    final /* synthetic */ CenterV9Fragment this$0;

    CenterV9Fragment$onRequestResponse$$inlined$also$lambda$1(CenterV9Fragment centerV9Fragment) {
        this.this$0 = centerV9Fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        ImageView imageView = this.this$0.loadBg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.this$0.loadBg;
        if (imageView2 != null) {
            ViewExtendsKt.detachFromParent(imageView2);
        }
        this.this$0.isBgLoaded = true;
        View loadingView = this.this$0.getLoadingView();
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        loadingView.setVisibility(8);
    }
}
