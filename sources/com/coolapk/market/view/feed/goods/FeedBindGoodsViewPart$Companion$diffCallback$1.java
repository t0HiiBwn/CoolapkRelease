package com.coolapk.market.view.feed.goods;

import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$Companion$diffCallback$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/coolapk/market/model/FeedGoods;", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
public final class FeedBindGoodsViewPart$Companion$diffCallback$1 extends DiffUtil.ItemCallback<FeedGoods> {
    FeedBindGoodsViewPart$Companion$diffCallback$1() {
    }

    public boolean areItemsTheSame(FeedGoods feedGoods, FeedGoods feedGoods2) {
        Intrinsics.checkNotNullParameter(feedGoods, "oldItem");
        Intrinsics.checkNotNullParameter(feedGoods2, "newItem");
        return Intrinsics.areEqual(feedGoods, feedGoods2);
    }

    public boolean areContentsTheSame(FeedGoods feedGoods, FeedGoods feedGoods2) {
        Intrinsics.checkNotNullParameter(feedGoods, "oldItem");
        Intrinsics.checkNotNullParameter(feedGoods2, "newItem");
        return Intrinsics.areEqual(feedGoods, feedGoods2);
    }
}
