package com.coolapk.market.view.photo;

import android.graphics.PointF;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.subsamplingview.OnImageEventListener;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.PhotoViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016J\u0018\u0010\r\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$ImageFragment$onImageFileLoaded$1", "Lcom/coolapk/market/widget/subsamplingview/OnImageEventListener;", "isFirst", "", "isFirst$presentation_coolapkAppRelease", "()Z", "setFirst$presentation_coolapkAppRelease", "(Z)V", "onImageLoadError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPreviewLoadError", "onReady", "onTileLoadError", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$ImageFragment$onImageFileLoaded$1 extends OnImageEventListener {
    final /* synthetic */ boolean $finalScrollToTop;
    final /* synthetic */ float $heightPixels;
    final /* synthetic */ float $widthPixels;
    private boolean isFirst = true;
    final /* synthetic */ PhotoViewActivity.ImageFragment this$0;

    PhotoViewActivity$ImageFragment$onImageFileLoaded$1(PhotoViewActivity.ImageFragment imageFragment, boolean z, float f, float f2) {
        this.this$0 = imageFragment;
        this.$finalScrollToTop = z;
        this.$widthPixels = f;
        this.$heightPixels = f2;
    }

    public final boolean isFirst$presentation_coolapkAppRelease() {
        return this.isFirst;
    }

    public final void setFirst$presentation_coolapkAppRelease(boolean z) {
        this.isFirst = z;
    }

    @Override // com.coolapk.market.widget.subsamplingview.OnImageEventListener
    public void onReady() {
        super.onReady();
        if (this.isFirst) {
            PhotoViewCompat photoViewCompat = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat, "photoBinding.gifImageView");
            photoViewCompat.setVisibility(8);
            if (this.$finalScrollToTop) {
                SubsamplingScaleImageView subsamplingScaleImageView = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                SubsamplingScaleImageView subsamplingScaleImageView2 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
                subsamplingScaleImageView.scrollTo(subsamplingScaleImageView2.getScrollX(), 0);
            }
            this.isFirst = false;
            SubsamplingScaleImageView subsamplingScaleImageView3 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView3, "photoBinding.imageView");
            float maxScale = subsamplingScaleImageView3.getMaxScale();
            SubsamplingScaleImageView subsamplingScaleImageView4 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView4, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView5 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView5, "photoBinding.imageView");
            if (((float) subsamplingScaleImageView4.getSWidth()) * maxScale < ((float) subsamplingScaleImageView5.getWidth())) {
                SubsamplingScaleImageView subsamplingScaleImageView6 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView6, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView7 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView7, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView8 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView8, "photoBinding.imageView");
                subsamplingScaleImageView6.setMaxScale(((float) subsamplingScaleImageView7.getWidth()) / ((float) subsamplingScaleImageView8.getSWidth()));
            } else {
                SubsamplingScaleImageView subsamplingScaleImageView9 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView9, "photoBinding.imageView");
                float sHeight = ((float) subsamplingScaleImageView9.getSHeight()) * maxScale;
                SubsamplingScaleImageView subsamplingScaleImageView10 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView10, "photoBinding.imageView");
                if (sHeight < ((float) subsamplingScaleImageView10.getHeight())) {
                    SubsamplingScaleImageView subsamplingScaleImageView11 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView11, "photoBinding.imageView");
                    SubsamplingScaleImageView subsamplingScaleImageView12 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView12, "photoBinding.imageView");
                    SubsamplingScaleImageView subsamplingScaleImageView13 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView13, "photoBinding.imageView");
                    subsamplingScaleImageView11.setMaxScale(((float) subsamplingScaleImageView12.getHeight()) / ((float) subsamplingScaleImageView13.getSHeight()));
                }
            }
            SubsamplingScaleImageView subsamplingScaleImageView14 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView14, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView15 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView15, "photoBinding.imageView");
            float sWidth = ((float) subsamplingScaleImageView14.getSWidth()) / ((float) subsamplingScaleImageView15.getSHeight());
            SubsamplingScaleImageView subsamplingScaleImageView16 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView16, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView17 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView17, "photoBinding.imageView");
            if (sWidth < ((float) subsamplingScaleImageView16.getWidth()) / ((float) subsamplingScaleImageView17.getHeight())) {
                SubsamplingScaleImageView subsamplingScaleImageView18 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView18, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView19 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView19, "photoBinding.imageView");
                float width = ((float) subsamplingScaleImageView18.getWidth()) / ((float) subsamplingScaleImageView19.getSWidth());
                SubsamplingScaleImageView subsamplingScaleImageView20 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                SubsamplingScaleImageView subsamplingScaleImageView21 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView21, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView22 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView22, "photoBinding.imageView");
                subsamplingScaleImageView20.setScaleAndCenter(width, new PointF(((float) subsamplingScaleImageView21.getSWidth()) / 2.0f, (((float) subsamplingScaleImageView22.getSWidth()) / 2.0f) / (this.$widthPixels / this.$heightPixels)));
            }
            PhotoViewCompat photoViewCompat2 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat2, "photoBinding.thumbnailView");
            photoViewCompat2.setVisibility(8);
            PhotoViewTransitionHelper access$getHelper$p = PhotoViewActivity.ImageFragment.access$getHelper$p(this.this$0);
            SubsamplingScaleImageView subsamplingScaleImageView23 = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView23, "photoBinding.imageView");
            access$getHelper$p.onSourceLoad(subsamplingScaleImageView23, this.this$0.position);
        }
    }

    @Override // com.coolapk.market.widget.subsamplingview.OnImageEventListener
    public void onImageLoadError(Exception exc) {
        super.onImageLoadError(exc);
        if (exc != null) {
            Toast.error(this.this$0.getActivity(), exc);
        }
    }

    @Override // com.coolapk.market.widget.subsamplingview.OnImageEventListener
    public void onPreviewLoadError(Exception exc) {
        super.onPreviewLoadError(exc);
        if (exc != null) {
            Toast.error(this.this$0.getActivity(), exc);
        }
    }

    @Override // com.coolapk.market.widget.subsamplingview.OnImageEventListener
    public void onTileLoadError(Exception exc) {
        super.onTileLoadError(exc);
        if (exc != null) {
            Toast.error(this.this$0.getActivity(), exc);
        }
    }
}
