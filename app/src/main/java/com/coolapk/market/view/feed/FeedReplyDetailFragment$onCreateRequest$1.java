package com.coolapk.market.view.feed;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/FeedReply;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailFragment.kt */
final class FeedReplyDetailFragment$onCreateRequest$1<T, R> implements Func1<FeedReply, Observable<? extends List<? extends Entity>>> {
    final /* synthetic */ int $page;
    final /* synthetic */ FeedReplyDetailFragment this$0;

    FeedReplyDetailFragment$onCreateRequest$1(FeedReplyDetailFragment feedReplyDetailFragment, int i) {
        this.this$0 = feedReplyDetailFragment;
        this.$page = i;
    }

    public final Observable<? extends List<Entity>> call(FeedReply feedReply) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(feedReply, "it");
        return instance.getFeedReplySubList(feedReply.getId(), feedReply.getReplyType(), this.$page, null, this.this$0.findLastItem()).compose(RxUtils.apiCommonToData());
    }
}
