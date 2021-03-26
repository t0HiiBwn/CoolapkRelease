package com.coolapk.market.view.feed.goods;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/goods/CreateGoodsViewPart$handleDone$3", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/FeedGoods;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
public final class CreateGoodsViewPart$handleDone$3 extends EmptySubscriber<FeedGoods> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ CreateGoodsViewPart this$0;

    CreateGoodsViewPart$handleDone$3(CreateGoodsViewPart createGoodsViewPart, Function1 function1, Function0 function0) {
        this.this$0 = createGoodsViewPart;
        this.$callback = function1;
        this.$dismissAction = function0;
    }

    public void onNext(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "t");
        super.onNext((CreateGoodsViewPart$handleDone$3) feedGoods);
        this.$callback.invoke(feedGoods);
        this.$dismissAction.invoke();
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getContext(), th);
    }
}
