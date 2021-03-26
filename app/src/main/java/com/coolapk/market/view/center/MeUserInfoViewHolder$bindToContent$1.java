package com.coolapk.market.view.center;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.coolapk.market.databinding.ItemCenterUserInfoBinding;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: MeUserInfoViewHolder.kt */
final class MeUserInfoViewHolder$bindToContent$1<T> implements Action1<Long> {
    final /* synthetic */ MeUserInfoViewHolder this$0;

    MeUserInfoViewHolder$bindToContent$1(MeUserInfoViewHolder meUserInfoViewHolder) {
        this.this$0 = meUserInfoViewHolder;
    }

    public final void call(Long l2) {
        ((ItemCenterUserInfoBinding) this.this$0.getBinding()).curExperience.animate().setListener(new AnimatorListenerAdapter(this) {
            /* class com.coolapk.market.view.center.MeUserInfoViewHolder$bindToContent$1.AnonymousClass1 */
            final /* synthetic */ MeUserInfoViewHolder$bindToContent$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ((ItemCenterUserInfoBinding) this.this$0.this$0.getBinding()).curExperience.animate().translationY(-20.0f).setDuration(0).start();
                ((ItemCenterUserInfoBinding) this.this$0.this$0.getBinding()).curExperience.animate().setListener(new MeUserInfoViewHolder$bindToContent$1$1$onAnimationEnd$1(this)).alpha(1.0f).translationY(0.0f).setDuration(200).start();
            }
        }).alpha(0.0f).translationY(20.0f).setDuration(200).start();
    }
}
