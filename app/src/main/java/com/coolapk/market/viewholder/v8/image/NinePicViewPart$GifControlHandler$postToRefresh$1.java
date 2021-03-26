package com.coolapk.market.viewholder.v8.image;

import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$GifControlHandler$postToRefresh$1 implements Runnable {
    final /* synthetic */ int $index;
    final /* synthetic */ NinePicViewPart.GifControlHandler this$0;

    NinePicViewPart$GifControlHandler$postToRefresh$1(NinePicViewPart.GifControlHandler gifControlHandler, int i) {
        this.this$0 = gifControlHandler;
        this.$index = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NinePicViewPart.ImageViewPart imageViewPart = (NinePicViewPart.ImageViewPart) CollectionsKt.getOrNull(NinePicViewPart.this.currentImageViewPartList, this.$index);
        if (imageViewPart != null) {
            Object obj = NinePicViewPart.this.currentImageArgs.get(this.$index);
            Intrinsics.checkNotNullExpressionValue(obj, "currentImageArgs.get(index)");
            imageViewPart.bindToContent(obj);
        }
    }
}
