package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/FakeTabIndicator$animateIndicatorToPosition$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FakeTabIndicator.kt */
public final class FakeTabIndicator$animateIndicatorToPosition$2 extends AnimatorListenerAdapter {
    final /* synthetic */ int $position;
    final /* synthetic */ FakeTabIndicator this$0;

    FakeTabIndicator$animateIndicatorToPosition$2(FakeTabIndicator fakeTabIndicator, int i) {
        this.this$0 = fakeTabIndicator;
        this.$position = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.this$0.setMSelectedPosition$presentation_coolapkAppRelease(this.$position);
        this.this$0.setMSelectionOffset$presentation_coolapkAppRelease(0.0f);
    }
}
