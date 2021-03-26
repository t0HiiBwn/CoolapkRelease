package com.coolapk.market.view.wallpaper.coolpic;

import com.coolapk.market.widget.view.ImageLoadProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageViewFragment.kt */
final class ImageViewFragment$initData$1 implements Runnable {
    final /* synthetic */ ImageViewFragment this$0;

    ImageViewFragment$initData$1(ImageViewFragment imageViewFragment) {
        this.this$0 = imageViewFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageLoadProgressBar imageLoadProgressBar = ImageViewFragment.access$getPhotoBinding$p(this.this$0).progressBar;
        Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
        imageLoadProgressBar.setAlpha(1.0f);
    }
}
