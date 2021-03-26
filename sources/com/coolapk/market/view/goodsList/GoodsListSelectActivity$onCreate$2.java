package com.coolapk.market.view.goodsList;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsListSelectActivity.kt */
final class GoodsListSelectActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ GoodsListSelectActivity this$0;

    GoodsListSelectActivity$onCreate$2(GoodsListSelectActivity goodsListSelectActivity) {
        this.this$0 = goodsListSelectActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoodsListSelectActivity.access$getBinding$p(this.this$0).bottomSheet.dismissView();
    }
}
