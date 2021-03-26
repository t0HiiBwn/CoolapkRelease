package com.coolapk.market.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ToastUtils.kt */
final class ToastUtils$showToastInActivity$2 implements Runnable {
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ View $toastView;

    ToastUtils$showToastInActivity$2(View view, FrameLayout frameLayout) {
        this.$toastView = view;
        this.$container = frameLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$toastView.animate().alpha(0.0f).setDuration(160).setListener(new AnimatorListenerAdapter(this) {
            /* class com.coolapk.market.util.ToastUtils$showToastInActivity$2.AnonymousClass1 */
            final /* synthetic */ ToastUtils$showToastInActivity$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.this$0.$container.removeView(this.this$0.$toastView);
            }
        }).start();
    }
}
