package com.coolapk.market.view.feedv8.util;

import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FeedGoods;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showLoadingGoodsDialog$1 extends Lambda implements Function1<FeedGoods, Unit> {
    public static final FeedGoodsHelper$showLoadingGoodsDialog$1 INSTANCE = new FeedGoodsHelper$showLoadingGoodsDialog$1();

    FeedGoodsHelper$showLoadingGoodsDialog$1() {
        super(1);
    }

    public final void invoke(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "it");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
        invoke(feedGoods);
        return Unit.INSTANCE;
    }
}
