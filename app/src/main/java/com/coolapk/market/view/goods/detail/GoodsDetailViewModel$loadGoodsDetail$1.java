package com.coolapk.market.view.goods.detail;

import androidx.lifecycle.MutableLiveData;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.goods.detail.GoodsDetailViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/goods/detail/GoodsDetailViewModel$loadGoodsDetail$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/FeedGoods;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailPresenter.kt */
public final class GoodsDetailViewModel$loadGoodsDetail$1 extends EmptySubscriber<FeedGoods> {
    final /* synthetic */ GoodsDetailViewModel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GoodsDetailViewModel$loadGoodsDetail$1(GoodsDetailViewModel goodsDetailViewModel) {
        this.this$0 = goodsDetailViewModel;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        MutableLiveData<GoodsDetailViewModel.LoadingStatus> loadingStatus = this.this$0.getLoadingStatus();
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        loadingStatus.setValue(new GoodsDetailViewModel.LoadingStatus(false, message));
    }

    public void onNext(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "t");
        super.onNext((GoodsDetailViewModel$loadGoodsDetail$1) feedGoods);
        this.this$0.getLoadingStatus().setValue(new GoodsDetailViewModel.LoadingStatus(false, null, 2, null));
        this.this$0.getFeedGoods().setValue(feedGoods);
    }
}
