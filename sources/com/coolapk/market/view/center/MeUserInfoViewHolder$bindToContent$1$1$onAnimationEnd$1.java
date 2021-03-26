package com.coolapk.market.view.center;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemCenterUserInfoBinding;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.center.MeUserInfoViewHolder$bindToContent$1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/center/MeUserInfoViewHolder$bindToContent$1$1$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserInfoViewHolder.kt */
public final class MeUserInfoViewHolder$bindToContent$1$1$onAnimationEnd$1 extends AnimatorListenerAdapter {
    final /* synthetic */ MeUserInfoViewHolder$bindToContent$1.AnonymousClass1 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MeUserInfoViewHolder$bindToContent$1$1$onAnimationEnd$1(MeUserInfoViewHolder$bindToContent$1.AnonymousClass1 r1) {
        this.this$0 = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        TextView textView = ((ItemCenterUserInfoBinding) this.this$0.this$0.this$0.getBinding()).curExperience;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.curExperience");
        UserProfile userProfile = this.this$0.this$0.this$0.getPresenter().getUserProfile();
        textView.setText(String.valueOf(userProfile != null ? Integer.valueOf(userProfile.getLevelExperience()) : null));
    }
}
