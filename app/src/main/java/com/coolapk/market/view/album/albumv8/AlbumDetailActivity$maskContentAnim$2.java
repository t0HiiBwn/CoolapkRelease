package com.coolapk.market.view.album.albumv8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.coolapk.market.widget.photoview.PhotoView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailActivity$maskContentAnim$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
public final class AlbumDetailActivity$maskContentAnim$2 extends AnimatorListenerAdapter {
    final /* synthetic */ AlbumDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumDetailActivity$maskContentAnim$2(AlbumDetailActivity albumDetailActivity) {
        this.this$0 = albumDetailActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        if (!AlbumDetailActivity.access$getViewModel$p(this.this$0).getShowContentView()) {
            AppBarLayout appBarLayout = AlbumDetailActivity.access$getBinding$p(this.this$0).appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
            if (!appBarLayout.isShown()) {
                AlbumDetailActivity.access$getViewModel$p(this.this$0).setShowContentView(true);
                AppBarLayout appBarLayout2 = AlbumDetailActivity.access$getBinding$p(this.this$0).appBar;
                Intrinsics.checkNotNullExpressionValue(appBarLayout2, "binding.appBar");
                appBarLayout2.setVisibility(0);
            }
        }
        PhotoView photoView = AlbumDetailActivity.access$getBinding$p(this.this$0).maskView;
        Intrinsics.checkNotNullExpressionValue(photoView, "binding.maskView");
        photoView.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationCancel(animator);
        if (!AlbumDetailActivity.access$getViewModel$p(this.this$0).getShowContentView()) {
            AppBarLayout appBarLayout = AlbumDetailActivity.access$getBinding$p(this.this$0).appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
            if (!appBarLayout.isShown()) {
                AlbumDetailActivity.access$getViewModel$p(this.this$0).setShowContentView(true);
                AppBarLayout appBarLayout2 = AlbumDetailActivity.access$getBinding$p(this.this$0).appBar;
                Intrinsics.checkNotNullExpressionValue(appBarLayout2, "binding.appBar");
                appBarLayout2.setVisibility(0);
            }
        }
    }
}
