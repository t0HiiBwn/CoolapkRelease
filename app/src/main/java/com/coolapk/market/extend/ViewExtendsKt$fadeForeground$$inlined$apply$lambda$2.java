package com.coolapk.market.extend;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$fadeForeground$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$fadeForeground$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Drawable $oldForeground$inlined;
    final /* synthetic */ View $this_fadeForeground$inlined;

    ViewExtendsKt$fadeForeground$$inlined$apply$lambda$2(View view, Drawable drawable) {
        this.$this_fadeForeground$inlined = view;
        this.$oldForeground$inlined = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.$this_fadeForeground$inlined.setForeground(this.$oldForeground$inlined);
    }
}
