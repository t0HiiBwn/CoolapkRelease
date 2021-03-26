package com.coolapk.market.view.center;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemCenterUserInfoBinding;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/center/MeUserInfoViewHolder$bindToContent$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: MeUserInfoViewHolder.kt */
final class MeUserInfoViewHolder$bindToContent$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ String $experienceTipMessage$inlined;
    final /* synthetic */ float $levelExperienceValue$inlined;
    final /* synthetic */ MeUserInfoViewHolder this$0;

    MeUserInfoViewHolder$bindToContent$$inlined$apply$lambda$1(MeUserInfoViewHolder meUserInfoViewHolder, float f, String str) {
        this.this$0 = meUserInfoViewHolder;
        this.$levelExperienceValue$inlined = f;
        this.$experienceTipMessage$inlined = str;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ((ItemCenterUserInfoBinding) this.this$0.getBinding()).progressBar.setProgress(this.$levelExperienceValue$inlined * floatValue);
        if (TextUtils.isEmpty(this.$experienceTipMessage$inlined)) {
            int i = (int) (this.$levelExperienceValue$inlined * floatValue);
            TextView textView = ((ItemCenterUserInfoBinding) this.this$0.getBinding()).curExperience;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.curExperience");
            textView.setText(String.valueOf(i));
        }
    }
}
