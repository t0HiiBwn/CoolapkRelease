package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
final class FeedBindGoodsViewPart$showInViewGroup$5 implements View.OnClickListener {
    final /* synthetic */ FeedBindGoodsViewPart this$0;

    FeedBindGoodsViewPart$showInViewGroup$5(FeedBindGoodsViewPart feedBindGoodsViewPart) {
        this.this$0 = feedBindGoodsViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedBindGoodsHelper feedBindGoodsHelper = FeedBindGoodsHelper.INSTANCE;
        Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
        Intrinsics.checkNotNull(activityNullable);
        feedBindGoodsHelper.showCreateGoodsDialog(activityNullable, new Function1<FeedGoods, Unit>(this) {
            /* class com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart$showInViewGroup$5.AnonymousClass1 */
            final /* synthetic */ FeedBindGoodsViewPart$showInViewGroup$5 this$0;

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
                this.this$0.this$0.insertFeedGoods(feedGoods);
            }
        });
    }
}
