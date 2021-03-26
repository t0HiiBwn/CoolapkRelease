package com.coolapk.market.view.feed.pick;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemGoodsBinding;
import com.coolapk.market.view.goods.GoodsViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "any", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchListFragment.kt */
final class GoodsSearchListFragment$onActivityCreated$2 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    final /* synthetic */ GoodsSearchListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsSearchListFragment$onActivityCreated$2(GoodsSearchListFragment goodsSearchListFragment) {
        super(2);
        this.this$0 = goodsSearchListFragment;
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
        GoodsViewHolder goodsViewHolder = (GoodsViewHolder) viewHolder;
        TextView textView = ((ItemGoodsBinding) goodsViewHolder.getBinding()).goShoppingView;
        Intrinsics.checkNotNullExpressionValue(textView, "vh.binding.goShoppingView");
        textView.setText("分享好物");
        ((ItemGoodsBinding) goodsViewHolder.getBinding()).goShoppingView.setOnClickListener(new GoodsSearchListFragment$onActivityCreated$2$$special$$inlined$let$lambda$1(this, obj));
        TextView textView2 = ((ItemGoodsBinding) goodsViewHolder.getBinding()).discountPriceView;
        Intrinsics.checkNotNullExpressionValue(textView2, "it");
        textView2.setText(StringsKt.replace$default(textView2.getText().toString(), "券后", "", false, 4, (Object) null));
    }
}
