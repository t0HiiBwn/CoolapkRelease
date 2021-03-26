package com.coolapk.market.view.album.albumv8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.Toolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailActivity$setToolbarTitle$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
public final class AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Ref.ObjectRef $newTitle$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$1(AlbumDetailActivity albumDetailActivity, String str, Ref.ObjectRef objectRef) {
        this.this$0 = albumDetailActivity;
        this.$title$inlined = str;
        this.$newTitle$inlined = objectRef;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        Toolbar toolbar = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setTitle("");
    }
}
