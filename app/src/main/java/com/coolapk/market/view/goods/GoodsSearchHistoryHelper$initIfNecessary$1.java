package com.coolapk.market.view.goods;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchHistoryHelper.kt */
final /* synthetic */ class GoodsSearchHistoryHelper$initIfNecessary$1 extends MutablePropertyReference0Impl {
    GoodsSearchHistoryHelper$initIfNecessary$1(GoodsSearchHistoryHelper goodsSearchHistoryHelper) {
        super(goodsSearchHistoryHelper, GoodsSearchHistoryHelper.class, "storeList", "getStoreList()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return GoodsSearchHistoryHelper.access$getStoreList$p((GoodsSearchHistoryHelper) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        GoodsSearchHistoryHelper goodsSearchHistoryHelper = (GoodsSearchHistoryHelper) this.receiver;
        GoodsSearchHistoryHelper.storeList = (List) obj;
    }
}
