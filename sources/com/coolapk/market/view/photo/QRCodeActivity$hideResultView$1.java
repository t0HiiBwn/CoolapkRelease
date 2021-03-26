package com.coolapk.market.view.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.coolapk.market.util.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/photo/QRCodeActivity$hideResultView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
public final class QRCodeActivity$hideResultView$1 extends AnimatorListenerAdapter {
    final /* synthetic */ QRCodeActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    QRCodeActivity$hideResultView$1(QRCodeActivity qRCodeActivity) {
        this.this$0 = qRCodeActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        RelativeLayout relativeLayout = QRCodeActivity.access$getBinding$p(this.this$0).resultView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.resultView");
        relativeLayout.setVisibility(8);
        this.this$0.restartCamera();
        FrameLayout frameLayout = QRCodeActivity.access$getBinding$p(this.this$0).resultMaskView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.resultMaskView");
        frameLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = QRCodeActivity.access$getBinding$p(this.this$0).resultView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.resultView");
        relativeLayout2.setTranslationY(0.0f);
        FrameLayout frameLayout2 = QRCodeActivity.access$getBinding$p(this.this$0).resultMaskView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.resultMaskView");
        frameLayout2.setClickable(false);
        ThemeUtils.setNavigationBarColor(this.this$0.getActivity(), 0);
    }
}
