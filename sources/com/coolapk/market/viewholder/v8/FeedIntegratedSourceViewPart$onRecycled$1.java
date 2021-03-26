package com.coolapk.market.viewholder.v8;

import com.coolapk.market.viewholder.FeedSourceViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedIntegratedSourceViewPart.kt */
final /* synthetic */ class FeedIntegratedSourceViewPart$onRecycled$1 extends MutablePropertyReference0Impl {
    FeedIntegratedSourceViewPart$onRecycled$1(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        super(feedIntegratedSourceViewPart, FeedIntegratedSourceViewPart.class, "feedSource", "getFeedSource()Lcom/coolapk/market/viewholder/FeedSourceViewPart;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return FeedIntegratedSourceViewPart.access$getFeedSource$p((FeedIntegratedSourceViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((FeedIntegratedSourceViewPart) this.receiver).feedSource = (FeedSourceViewPart) obj;
    }
}
