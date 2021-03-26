package com.coolapk.market.view.goods.detail;

import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$setupActionToolbar$1 implements View.OnClickListener {
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$setupActionToolbar$1(GoodsDetailActivity goodsDetailActivity) {
        this.this$0 = goodsDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        BaseActivity baseActivity = activity;
        FeedGoods model = GoodsDetailActivity.access$getBinding$p(this.this$0).getModel();
        ActionManagerCompat.startActivityByUrl$default(baseActivity, model != null ? model.getSellUrl() : null, null, null, 12, null);
    }
}
