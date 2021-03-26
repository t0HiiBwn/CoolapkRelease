package com.coolapk.market.view.goodsList;

import com.coolapk.market.model.GoodsListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/GoodsListItem;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsListDetailFragment.kt */
final class FeedGoodsListDetailFragment$goodsList$2 extends Lambda implements Function0<List<GoodsListItem>> {
    final /* synthetic */ FeedGoodsListDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedGoodsListDetailFragment$goodsList$2(FeedGoodsListDetailFragment feedGoodsListDetailFragment) {
        super(0);
        this.this$0 = feedGoodsListDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<GoodsListItem> invoke() {
        return this.this$0.getFeed$presentation_coolapkAppRelease().getGoodsListItem();
    }
}
