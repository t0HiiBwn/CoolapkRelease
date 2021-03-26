package com.coolapk.market.view.feed.goods;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$syncGoodsData$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
public final class FeedBindGoodsViewPart$syncGoodsData$1 extends EmptySubscriber<String> {
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ FeedBindGoodsViewPart this$0;

    FeedBindGoodsViewPart$syncGoodsData$1(FeedBindGoodsViewPart feedBindGoodsViewPart, Function0 function0) {
        this.this$0 = feedBindGoodsViewPart;
        this.$dismissAction = function0;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(AppHolder.getApplication(), th);
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "t");
        super.onNext((FeedBindGoodsViewPart$syncGoodsData$1) str);
        Toast.show$default(AppHolder.getApplication(), str, 0, false, 12, null);
        EventBus eventBus = EventBus.getDefault();
        String id = FeedBindGoodsViewPart.access$getData$p(this.this$0).getId();
        if (id == null) {
            id = "";
        }
        List currentList = this.this$0.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        eventBus.post(new FeedIncludeGoodsEvent(id, currentList));
        this.$dismissAction.invoke();
    }
}
