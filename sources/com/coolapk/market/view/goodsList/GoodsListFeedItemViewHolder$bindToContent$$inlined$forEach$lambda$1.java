package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.view.View;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/coolapk/market/view/goodsList/GoodsListFeedItemViewHolder$bindToContent$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsListFeedItemViewHolder.kt */
final class GoodsListFeedItemViewHolder$bindToContent$$inlined$forEach$lambda$1 implements View.OnLongClickListener {
    final /* synthetic */ GoodsListFeedItemViewHolder this$0;

    GoodsListFeedItemViewHolder$bindToContent$$inlined$forEach$lambda$1(GoodsListFeedItemViewHolder goodsListFeedItemViewHolder) {
        this.this$0 = goodsListFeedItemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Feed access$getFeed$p = GoodsListFeedItemViewHolder.access$getFeed$p(this.this$0);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(access$getFeed$p, context);
        return true;
    }
}
