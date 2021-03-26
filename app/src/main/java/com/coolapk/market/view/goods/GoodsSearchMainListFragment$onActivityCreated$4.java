package com.coolapk.market.view.goods;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchMainListFragment.kt */
final class GoodsSearchMainListFragment$onActivityCreated$4 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ GoodsSearchMainListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsSearchMainListFragment$onActivityCreated$4(GoodsSearchMainListFragment goodsSearchMainListFragment) {
        super(1);
        this.this$0 = goodsSearchMainListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new GoodsSearchHotViewHolder(view, this.this$0.getBindingComponent(), null);
    }
}
