package com.coolapk.market.view.feed.reply;

import android.view.View;
import com.coolapk.market.databinding.ItemFeedGoodsDetailImageBinding;
import com.coolapk.market.view.feed.reply.FeedGoodsDetailViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsDetailViewHolder.kt */
final class FeedGoodsDetailViewHolder$ImageViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ ItemFeedGoodsDetailImageBinding $binding;
    final /* synthetic */ FeedGoodsDetailViewHolder.ImageViewHolder this$0;

    FeedGoodsDetailViewHolder$ImageViewHolder$bindTo$1(FeedGoodsDetailViewHolder.ImageViewHolder imageViewHolder, ItemFeedGoodsDetailImageBinding itemFeedGoodsDetailImageBinding) {
        this.this$0 = imageViewHolder;
        this.$binding = itemFeedGoodsDetailImageBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedGoodsDetailViewHolder feedGoodsDetailViewHolder = this.this$0.this$0;
        int adapterPosition = this.this$0.getAdapterPosition();
        ItemFeedGoodsDetailImageBinding itemFeedGoodsDetailImageBinding = this.$binding;
        Intrinsics.checkNotNullExpressionValue(itemFeedGoodsDetailImageBinding, "binding");
        View root = itemFeedGoodsDetailImageBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        feedGoodsDetailViewHolder.onImageClick(adapterPosition, root);
    }
}
