package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedExtraEntityViewPart.kt */
final class FeedExtraEntityViewPart$goodsInfoViewPart$2 extends Lambda implements Function0<FeedGoodsInfoViewPart> {
    final /* synthetic */ FeedExtraEntityViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedExtraEntityViewPart$goodsInfoViewPart$2(FeedExtraEntityViewPart feedExtraEntityViewPart) {
        super(0);
        this.this$0 = feedExtraEntityViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedGoodsInfoViewPart invoke() {
        FeedGoodsInfoViewPart feedGoodsInfoViewPart = new FeedGoodsInfoViewPart(this.this$0.getComponent());
        LayoutInflater from = LayoutInflater.from(FeedExtraEntityViewPart.access$getFrameLayout$p(this.this$0).getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(frameLayout.context)");
        feedGoodsInfoViewPart.createView(from, FeedExtraEntityViewPart.access$getFrameLayout$p(this.this$0));
        return feedGoodsInfoViewPart;
    }
}
