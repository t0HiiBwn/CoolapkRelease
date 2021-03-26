package com.coolapk.market.view.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$onCreate$4$overSwipe$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$onCreate$4$overSwipe$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ int $currentAlpha$inlined;
    final /* synthetic */ int $delta$inlined;
    final /* synthetic */ PhotoViewActivity$onCreate$4 this$0;

    PhotoViewActivity$onCreate$4$overSwipe$$inlined$apply$lambda$2(PhotoViewActivity$onCreate$4 photoViewActivity$onCreate$4, int i, int i2) {
        this.this$0 = photoViewActivity$onCreate$4;
        this.$delta$inlined = i;
        this.$currentAlpha$inlined = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.colorDrawable.setAlpha(255);
        View root = this.this$0.this$0.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.this$0.colorDrawable);
    }
}
