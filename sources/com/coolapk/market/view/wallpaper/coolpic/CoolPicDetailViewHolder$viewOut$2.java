package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ValueAnimator;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.ItemCoolpicDetailBinding;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
final class CoolPicDetailViewHolder$viewOut$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    CoolPicDetailViewHolder$viewOut$2(CoolPicDetailViewHolder coolPicDetailViewHolder) {
        this.this$0 = coolPicDetailViewHolder;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        CoolPicDetailViewHolder coolPicDetailViewHolder = this.this$0;
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) coolPicDetailViewHolder.getBinding()).sizeViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sizeViewContainer");
        CoolPicDetailViewHolder.access$setViewHeight(coolPicDetailViewHolder, linearLayout, (int) floatValue);
    }
}
