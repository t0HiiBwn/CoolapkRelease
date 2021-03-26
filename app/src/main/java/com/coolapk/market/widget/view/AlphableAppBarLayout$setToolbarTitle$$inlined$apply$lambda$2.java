package com.coolapk.market.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.Toolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/widget/view/AlphableAppBarLayout$setToolbarTitle$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlphableAppBarLayout.kt */
public final class AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ String $newTitle$inlined;
    final /* synthetic */ Toolbar $toolbar$inlined;

    AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$2(String str, Toolbar toolbar) {
        this.$newTitle$inlined = str;
        this.$toolbar$inlined = toolbar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        this.$toolbar$inlined.setTitle(this.$newTitle$inlined);
    }
}
