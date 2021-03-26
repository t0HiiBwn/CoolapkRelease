package com.coolapk.market.event;

import com.coolapk.market.model.GoodsListItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/event/GoodsItemEditEvent;", "", "goodsListItem", "", "Lcom/coolapk/market/model/GoodsListItem;", "(Ljava/util/List;)V", "getGoodsListItem", "()Ljava/util/List;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsItemEditEvent.kt */
public final class GoodsItemEditEvent {
    private final List<GoodsListItem> goodsListItem;

    public GoodsItemEditEvent(List<GoodsListItem> list) {
        this.goodsListItem = list;
    }

    public final List<GoodsListItem> getGoodsListItem() {
        return this.goodsListItem;
    }
}
