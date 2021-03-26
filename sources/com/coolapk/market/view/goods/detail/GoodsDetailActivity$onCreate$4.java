package com.coolapk.market.view.goods.detail;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$onCreate$4<T> implements Observer<Integer> {
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$onCreate$4(GoodsDetailActivity goodsDetailActivity) {
        this.this$0 = goodsDetailActivity;
    }

    public final void onChanged(Integer num) {
        if (num != null) {
            GoodsDetailActivity.access$getBinding$p(this.this$0).mainContent.setBackgroundColor(num.intValue());
        }
    }
}
