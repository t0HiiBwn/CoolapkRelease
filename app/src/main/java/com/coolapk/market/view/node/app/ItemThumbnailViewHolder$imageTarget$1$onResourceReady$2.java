package com.coolapk.market.view.node.app;

import com.coolapk.market.imageloader.Size;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ItemThumbnailViewHolder.kt */
final class ItemThumbnailViewHolder$imageTarget$1$onResourceReady$2 implements Runnable {
    final /* synthetic */ Size $resource;
    final /* synthetic */ ItemThumbnailViewHolder$imageTarget$1 this$0;

    ItemThumbnailViewHolder$imageTarget$1$onResourceReady$2(ItemThumbnailViewHolder$imageTarget$1 itemThumbnailViewHolder$imageTarget$1, Size size) {
        this.this$0 = itemThumbnailViewHolder$imageTarget$1;
        this.$resource = size;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.this$0.loadImage(this.$resource);
    }
}
