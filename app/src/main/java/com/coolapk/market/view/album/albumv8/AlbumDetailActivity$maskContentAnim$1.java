package com.coolapk.market.view.album.albumv8;

import android.animation.ValueAnimator;
import com.coolapk.market.widget.photoview.PhotoView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
final class AlbumDetailActivity$maskContentAnim$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$maskContentAnim$1(AlbumDetailActivity albumDetailActivity) {
        this.this$0 = albumDetailActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        PhotoView photoView = AlbumDetailActivity.access$getBinding$p(this.this$0).maskView;
        Intrinsics.checkNotNullExpressionValue(photoView, "binding.maskView");
        photoView.setAlpha(floatValue);
    }
}
