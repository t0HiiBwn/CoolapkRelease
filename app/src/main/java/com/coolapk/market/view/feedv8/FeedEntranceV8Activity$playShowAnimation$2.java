package com.coolapk.market.view.feedv8;

import android.animation.ValueAnimator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$playShowAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationValue", "value", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$playShowAnimation$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEntranceV8Activity$playShowAnimation$2(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        onAnimationValue(((Float) animatedValue).floatValue());
    }

    private final void onAnimationValue(float f) {
        this.this$0.setCloseButtonRotate(f);
    }
}
