package com.coolapk.market.event;

import com.coolapk.market.model.GoodsListItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/event/GoodsAddedEvent;", "", "goodsListItem", "Lcom/coolapk/market/model/GoodsListItem;", "(Lcom/coolapk/market/model/GoodsListItem;)V", "getGoodsListItem", "()Lcom/coolapk/market/model/GoodsListItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsAddedEvent.kt */
public final class GoodsAddedEvent {
    private final GoodsListItem goodsListItem;

    public GoodsAddedEvent(GoodsListItem goodsListItem2) {
        this.goodsListItem = goodsListItem2;
    }

    public final GoodsListItem getGoodsListItem() {
        return this.goodsListItem;
    }
}
