package com.coolapk.market.view.photo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.widget.view.PhotoViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0005\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$ImageFragment$loadCompressed$1", "Lcom/bumptech/glide/request/target/DrawableImageViewTarget;", "onResourceReady", "", "resource", "Landroid/graphics/drawable/Drawable;", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$ImageFragment$loadCompressed$1 extends DrawableImageViewTarget {
    final /* synthetic */ PhotoViewActivity.ImageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhotoViewActivity$ImageFragment$loadCompressed$1(PhotoViewActivity.ImageFragment imageFragment, ImageView imageView) {
        super(imageView);
        this.this$0 = imageFragment;
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
    }

    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        super.onResourceReady((PhotoViewActivity$ImageFragment$loadCompressed$1) drawable, (Transition<? super PhotoViewActivity$ImageFragment$loadCompressed$1>) transition);
        PhotoViewTransitionHelper access$getHelper$p = PhotoViewActivity.ImageFragment.access$getHelper$p(this.this$0);
        PhotoViewCompat photoViewCompat = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).gifImageView;
        Intrinsics.checkNotNullExpressionValue(photoViewCompat, "photoBinding.gifImageView");
        access$getHelper$p.onSourceLoad(photoViewCompat, this.this$0.position);
        PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).progressBar.setMonitorUrl("");
        PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).gifImageView.enable();
        this.this$0.allowExit = true;
        TextView textView = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).loadSourceButton;
        Intrinsics.checkNotNullExpressionValue(textView, "photoBinding.loadSourceButton");
        textView.setVisibility(8);
        PhotoViewCompat photoViewCompat2 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).thumbnailView;
        Intrinsics.checkNotNullExpressionValue(photoViewCompat2, "photoBinding.thumbnailView");
        photoViewCompat2.setVisibility(8);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            Resources resources = this.this$0.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (intrinsicHeight / intrinsicWidth > displayMetrics.heightPixels / displayMetrics.widthPixels) {
                PhotoViewCompat photoViewCompat3 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).gifImageView;
                Intrinsics.checkNotNullExpressionValue(photoViewCompat3, "photoBinding.gifImageView");
                photoViewCompat3.setScaleType(ImageView.ScaleType.FIT_START);
            }
        }
    }
}
