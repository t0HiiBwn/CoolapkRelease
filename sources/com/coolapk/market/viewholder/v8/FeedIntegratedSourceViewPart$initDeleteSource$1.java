package com.coolapk.market.viewholder.v8;

import com.coolapk.market.viewholder.FeedSourceDeletedViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedIntegratedSourceViewPart.kt */
final /* synthetic */ class FeedIntegratedSourceViewPart$initDeleteSource$1 extends MutablePropertyReference0Impl {
    FeedIntegratedSourceViewPart$initDeleteSource$1(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        super(feedIntegratedSourceViewPart, FeedIntegratedSourceViewPart.class, "deletedSource", "getDeletedSource()Lcom/coolapk/market/viewholder/FeedSourceDeletedViewPart;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return FeedIntegratedSourceViewPart.access$getDeletedSource$p((FeedIntegratedSourceViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((FeedIntegratedSourceViewPart) this.receiver).deletedSource = (FeedSourceDeletedViewPart) obj;
    }
}
