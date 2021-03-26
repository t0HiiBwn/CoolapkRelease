package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/event/GoodsEditEvent;", "", "goodsList", "Lcom/coolapk/market/model/Feed;", "(Lcom/coolapk/market/model/Feed;)V", "getGoodsList", "()Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsEditEvent.kt */
public final class GoodsEditEvent {
    private final Feed goodsList;

    public GoodsEditEvent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "goodsList");
        this.goodsList = feed;
    }

    public final Feed getGoodsList() {
        return this.goodsList;
    }
}
