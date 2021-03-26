package com.coolapk.market.view.wallpaper.coolpic;

import android.graphics.PointF;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.subsamplingview.OnImageEventListener;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/ImageViewFragment$onImageFileLoaded$1", "Lcom/coolapk/market/widget/subsamplingview/OnImageEventListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onImageLoadError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPreviewLoadError", "onReady", "onTileLoadError", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageViewFragment.kt */
public final class ImageViewFragment$onImageFileLoaded$1 extends OnImageEventListener {
    final /* synthetic */ float $heightPixels;
    final /* synthetic */ float $widthPixels;
    private boolean isFirst = true;
    final /* synthetic */ ImageViewFragment this$0;

    ImageViewFragment$onImageFileLoaded$1(ImageViewFragment imageViewFragment, float f, float f2) {
        this.this$0 = imageViewFragment;
        this.$widthPixels = f;
        this.$heightPixels = f2;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }

    @Override // com.coolapk.market.widget.subsamplingview.OnImageEventListener
    public void onReady() {
        super.onReady();
        if (this.isFirst) {
            PhotoView photoView = ImageViewFragment.access$getPhotoBinding$p(this.this$0).gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoView, "photoBinding.gifImageView");
            photoView.setVisibility(8);
            this.isFirst = false;
            SubsamplingScaleImageView subsamplingScaleImageView = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            float maxScale = subsamplingScaleImageView.getMaxScale();
            SubsamplingScaleImageView subsamplingScaleImageView2 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView3 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView3, "photoBinding.imageView");
            if (((float) subsamplingScaleImageView2.getSWidth()) * maxScale < ((float) subsamplingScaleImageView3.getWidth())) {
                SubsamplingScaleImageView subsamplingScaleImageView4 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView4, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView5 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView5, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView6 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView6, "photoBinding.imageView");
                subsamplingScaleImageView4.setMaxScale(((float) subsamplingScaleImageView5.getWidth()) / ((float) subsamplingScaleImageView6.getSWidth()));
            } else {
                SubsamplingScaleImageView subsamplingScaleImageView7 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView7, "photoBinding.imageView");
                float sHeight = ((float) subsamplingScaleImageView7.getSHeight()) * maxScale;
                SubsamplingScaleImageView subsamplingScaleImageView8 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView8, "photoBinding.imageView");
                if (sHeight < ((float) subsamplingScaleImageView8.getHeight())) {
                    SubsamplingScaleImageView subsamplingScaleImageView9 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView9, "photoBinding.imageView");
                    SubsamplingScaleImageView subsamplingScaleImageView10 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView10, "photoBinding.imageView");
                    SubsamplingScaleImageView subsamplingScaleImageView11 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView11, "photoBinding.imageView");
                    subsamplingScaleImageView9.setMaxScale(((float) subsamplingScaleImageView10.getHeight()) / ((float) subsamplingScaleImageView11.getSHeight()));
                }
            }
            SubsamplingScaleImageView subsamplingScaleImageView12 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView12, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView13 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView13, "photoBinding.imageView");
            float sWidth = ((float) subsamplingScaleImageView12.getSWidth()) / ((float) subsamplingScaleImageView13.getSHeight());
            SubsamplingScaleImageView subsamplingScaleImageView14 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView14, "photoBinding.imageView");
            SubsamplingScaleImageView subsamplingScaleImageView15 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView15, "photoBinding.imageView");
            if (sWidth < ((float) subsamplingScaleImageView14.getWidth()) / ((float) subsamplingScaleImageView15.getHeight())) {
                SubsamplingScaleImageView subsamplingScaleImageView16 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView16, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView17 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView17, "photoBinding.imageView");
                float width = ((float) subsamplingScaleImageView16.getWidth()) / ((float) subsamplingScaleImageView17.getSWidth());
                SubsamplingScaleImageView subsamplingScaleImageView18 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                SubsamplingScaleImageView subsamplingScaleImageView19 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView19, "photoBinding.imageView");
                SubsamplingScaleImageView subsamplingScaleImageView20 = ImageViewFragment.access$getPhotoBinding$p(this.this$0).imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView20, "photoBinding.imageView");
                subsamplingScaleImageView18.setScaleAndCenter(width, new PointF(((float) subsamplingScaleImageView19.getSWidth()) / 2.0f, (((float) subsamplingScaleImageView20.getSWidth()) / 2.0f) / (this.$widthPixels / this.$heightPixels)));
            }
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
