package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/widget/view/FabVerticalMenuLayout$setCollapsed$3$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FabVerticalMenuLayout.kt */
final class FabVerticalMenuLayout$setCollapsed$$inlined$apply$lambda$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ FabVerticalMenuLayout this$0;

    FabVerticalMenuLayout$setCollapsed$$inlined$apply$lambda$2(FabVerticalMenuLayout fabVerticalMenuLayout) {
        this.this$0 = fabVerticalMenuLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Activity activity = UiUtils.getActivity(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (!(activity instanceof TranslucentActivity)) {
            ThemeUtils.setNavigationBarColor(activity, intValue);
        }
        this.this$0.setBackgroundColor(intValue);
    }
}
