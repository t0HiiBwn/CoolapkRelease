package com.coolapk.market.view.feedv8.util;

import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/FeedGoods;", "kotlin.jvm.PlatformType", "t1", "t2", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$1<T1, T2, R> implements Func2<FeedGoods, Long, FeedGoods> {
    public static final FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$1 INSTANCE = new FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$1();

    FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$1() {
    }

    public final FeedGoods call(FeedGoods feedGoods, long j) {
        Intrinsics.checkNotNullParameter(feedGoods, "t1");
        return feedGoods;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ FeedGoods call(FeedGoods feedGoods, Long l) {
        return call(feedGoods, l.longValue());
    }
}
