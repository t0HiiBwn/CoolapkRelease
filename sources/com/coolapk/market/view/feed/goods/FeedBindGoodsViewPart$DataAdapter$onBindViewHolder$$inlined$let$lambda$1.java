package com.coolapk.market.view.feed.goods;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$DataAdapter$onBindViewHolder$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
final class FeedBindGoodsViewPart$DataAdapter$onBindViewHolder$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder$inlined;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ FeedBindGoodsViewPart.DataAdapter this$0;

    FeedBindGoodsViewPart$DataAdapter$onBindViewHolder$$inlined$let$lambda$1(FeedBindGoodsViewPart.DataAdapter dataAdapter, int i, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = dataAdapter;
        this.$position$inlined = i;
        this.$holder$inlined = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedBindGoodsViewPart feedBindGoodsViewPart = FeedBindGoodsViewPart.this;
        List currentList = this.this$0.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        List mutableList = CollectionsKt.toMutableList((Collection) currentList);
        mutableList.remove(this.$holder$inlined.getAdapterPosition());
        Unit unit = Unit.INSTANCE;
        FeedBindGoodsViewPart.updateList$default(feedBindGoodsViewPart, mutableList, false, 2, null);
    }
}
