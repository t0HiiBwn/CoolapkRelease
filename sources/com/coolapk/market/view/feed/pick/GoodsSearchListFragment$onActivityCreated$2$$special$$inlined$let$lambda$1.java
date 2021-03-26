package com.coolapk.market.view.feed.pick;

import android.view.View;
import com.coolapk.market.model.Goods;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/pick/GoodsSearchListFragment$onActivityCreated$2$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchListFragment.kt */
final class GoodsSearchListFragment$onActivityCreated$2$$special$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ Object $any$inlined;
    final /* synthetic */ GoodsSearchListFragment$onActivityCreated$2 this$0;

    GoodsSearchListFragment$onActivityCreated$2$$special$$inlined$let$lambda$1(GoodsSearchListFragment$onActivityCreated$2 goodsSearchListFragment$onActivityCreated$2, Object obj) {
        this.this$0 = goodsSearchListFragment$onActivityCreated$2;
        this.$any$inlined = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoodsSearchListFragment goodsSearchListFragment = this.this$0.this$0;
        Object obj = this.$any$inlined;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Goods");
        goodsSearchListFragment.convertPearGoodsToFeedGoods((Goods) obj);
    }
}
