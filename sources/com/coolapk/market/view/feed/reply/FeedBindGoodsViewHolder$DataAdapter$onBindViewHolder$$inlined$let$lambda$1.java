package com.coolapk.market.view.feed.reply;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.feed.reply.FeedBindGoodsViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/reply/FeedBindGoodsViewHolder$DataAdapter$onBindViewHolder$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewHolder.kt */
final class FeedBindGoodsViewHolder$DataAdapter$onBindViewHolder$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder$inlined;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ FeedBindGoodsViewHolder.DataAdapter this$0;

    FeedBindGoodsViewHolder$DataAdapter$onBindViewHolder$$inlined$let$lambda$1(FeedBindGoodsViewHolder.DataAdapter dataAdapter, int i, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = dataAdapter;
        this.$position$inlined = i;
        this.$holder$inlined = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedGoods item = this.this$0.getItem(this.$holder$inlined.getAdapterPosition());
        ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
        Context context = FeedBindGoodsViewHolder.this.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String mallName = item.getMallName();
        Intrinsics.checkNotNullExpressionValue(mallName, "feedGoods.mallName");
        actionManagerCompat.startFeedGoodsSellPage(context, mallName, item.getSellUrl(), item.getFromApi());
    }
}
