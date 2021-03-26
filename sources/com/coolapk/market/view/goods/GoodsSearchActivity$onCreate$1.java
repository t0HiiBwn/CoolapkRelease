package com.coolapk.market.view.goods;

import android.view.View;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchActivity.kt */
final class GoodsSearchActivity$onCreate$1 implements View.OnClickListener {
    final /* synthetic */ GoodsSearchActivity this$0;

    GoodsSearchActivity$onCreate$1(GoodsSearchActivity goodsSearchActivity) {
        this.this$0 = goodsSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedGoodsHelper.showAddGoodsDialog$default(FeedGoodsHelper.INSTANCE, this.this$0, null, new Function1<FeedGoods, Unit>(this) {
            /* class com.coolapk.market.view.goods.GoodsSearchActivity$onCreate$1.AnonymousClass1 */
            final /* synthetic */ GoodsSearchActivity$onCreate$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
                invoke(feedGoods);
                return Unit.INSTANCE;
            }

            public final void invoke(FeedGoods feedGoods) {
                Intrinsics.checkNotNullParameter(feedGoods, "it");
                this.this$0.this$0.setFeedGoodsPickedAndFinished(feedGoods);
            }
        }, 2, null);
    }
}
