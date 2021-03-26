package com.coolapk.market.view.feedv8;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "part", "Lcom/coolapk/market/model/FeedMultiPart;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$startSubmitFeed$1<T, R> implements Func1<FeedMultiPart, Observable<? extends Result<Entity>>> {
    public static final BaseFeedContentHolder$startSubmitFeed$1 INSTANCE = new BaseFeedContentHolder$startSubmitFeed$1();

    BaseFeedContentHolder$startSubmitFeed$1() {
    }

    public final Observable<? extends Result<Entity>> call(FeedMultiPart feedMultiPart) {
        String id = feedMultiPart.id();
        Intrinsics.checkNotNullExpressionValue(id, "part.id()");
        if (id.length() > 0) {
            return DataManager.getInstance().changeFeed(feedMultiPart);
        }
        return DataManager.getInstance().createFeed(feedMultiPart);
    }
}
