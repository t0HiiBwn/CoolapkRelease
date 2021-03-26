package com.coolapk.market.view.goodsList;

import com.coolapk.market.model.Feed;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/Feed;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
final class GoodGoodsEditListFragment$feed$2 extends Lambda implements Function0<Feed> {
    final /* synthetic */ GoodGoodsEditListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodGoodsEditListFragment$feed$2(GoodGoodsEditListFragment goodGoodsEditListFragment) {
        super(0);
        this.this$0 = goodGoodsEditListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Feed invoke() {
        Object obj = this.this$0.requireArguments().get("DATA");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
        return (Feed) obj;
    }
}
