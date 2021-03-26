package com.coolapk.market.view.photo;

import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
final class PhotoViewActivity$ImageFragment$initData$1 implements Runnable {
    final /* synthetic */ PhotoViewActivity.ImageFragment this$0;

    PhotoViewActivity$ImageFragment$initData$1(PhotoViewActivity.ImageFragment imageFragment) {
        this.this$0 = imageFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageLoadProgressBar imageLoadProgressBar = PhotoViewActivity.ImageFragment.access$getPhotoBinding$p(this.this$0).progressBar;
        Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
        imageLoadProgressBar.setAlpha(1.0f);
    }
}
