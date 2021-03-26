package com.coolapk.market.view.goods.detail;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemFeedGoodsInfoBinding;
import com.coolapk.market.viewholder.v8.FeedGoodsViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "any", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDataListFragment.kt */
final class GoodsDataListFragment$onActivityCreated$2 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    public static final GoodsDataListFragment$onActivityCreated$2 INSTANCE = new GoodsDataListFragment$onActivityCreated$2();

    GoodsDataListFragment$onActivityCreated$2() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        invoke(viewHolder, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View root = ((ItemFeedGoodsInfoBinding) ((FeedGoodsViewHolder) viewHolder).getGoodsInfoViewPart().getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.goodsInfoViewPart.binding.root");
        root.setVisibility(8);
    }
}
