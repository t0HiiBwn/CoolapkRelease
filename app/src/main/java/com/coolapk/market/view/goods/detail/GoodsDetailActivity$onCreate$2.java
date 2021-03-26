package com.coolapk.market.view.goods.detail;

import androidx.lifecycle.Observer;
import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FeedGoods;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$onCreate$2<T> implements Observer<FeedGoods> {
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$onCreate$2(GoodsDetailActivity goodsDetailActivity) {
        this.this$0 = goodsDetailActivity;
    }

    public final void onChanged(FeedGoods feedGoods) {
        boolean z = GoodsDetailActivity.access$getBinding$p(this.this$0).getModel() == null && feedGoods != null;
        GoodsDetailActivity.access$getBinding$p(this.this$0).setModel(feedGoods);
        GoodsDetailActivity.access$getBinding$p(this.this$0).executePendingBindings();
        if (z) {
            GoodsDetailActivity goodsDetailActivity = this.this$0;
            Intrinsics.checkNotNullExpressionValue(feedGoods, "it");
            goodsDetailActivity.onFirstFeedGoodsLoad(feedGoods);
        }
    }
}
