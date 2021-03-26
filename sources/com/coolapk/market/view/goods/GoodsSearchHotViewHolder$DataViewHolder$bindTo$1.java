package com.coolapk.market.view.goods;

import android.content.Context;
import android.view.View;
import com.coolapk.market.view.goods.GoodsSearchHotViewHolder;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchHotViewHolder.kt */
final class GoodsSearchHotViewHolder$DataViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ Object $data;
    final /* synthetic */ GoodsSearchHotViewHolder.DataViewHolder this$0;

    GoodsSearchHotViewHolder$DataViewHolder$bindTo$1(GoodsSearchHotViewHolder.DataViewHolder dataViewHolder, Object obj) {
        this.this$0 = dataViewHolder;
        this.$data = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.coolapk.market.view.goods.GoodsCouponSearchActivity");
        GoodsCouponSearchActivity.inputKeywords$default((GoodsCouponSearchActivity) context, String.valueOf(this.$data), false, 2, null);
    }
}
