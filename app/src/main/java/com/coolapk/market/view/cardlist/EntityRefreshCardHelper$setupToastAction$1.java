package com.coolapk.market.view.cardlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityRefreshCardHelper.kt */
final class EntityRefreshCardHelper$setupToastAction$1 implements Runnable {
    final /* synthetic */ LinearLayout $view;
    final /* synthetic */ EntityRefreshCardHelper this$0;

    EntityRefreshCardHelper$setupToastAction$1(EntityRefreshCardHelper entityRefreshCardHelper, LinearLayout linearLayout) {
        this.this$0 = entityRefreshCardHelper;
        this.$view = linearLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
            /* class com.coolapk.market.view.cardlist.EntityRefreshCardHelper$setupToastAction$1.AnonymousClass1 */
            final /* synthetic */ EntityRefreshCardHelper$setupToastAction$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.this$0.this$0.removeToastAction();
            }
        }).start();
    }
}
