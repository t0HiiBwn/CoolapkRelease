package com.coolapk.market.view.feedv8.util;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/util/FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$3", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/FeedGoods;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
public final class FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$3 extends EmptySubscriber<FeedGoods> {
    final /* synthetic */ FeedGoodsHelper$showLoadingGoodsDialog$2 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$3(FeedGoodsHelper$showLoadingGoodsDialog$2 feedGoodsHelper$showLoadingGoodsDialog$2) {
        this.this$0 = feedGoodsHelper$showLoadingGoodsDialog$2;
    }

    public void onNext(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "t");
        super.onNext((FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$3) feedGoods);
        this.this$0.$callback.invoke(feedGoods);
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(this.this$0.$activity, th);
    }
}
