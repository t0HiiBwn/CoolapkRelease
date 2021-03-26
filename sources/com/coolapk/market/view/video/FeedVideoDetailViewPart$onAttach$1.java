package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVideoDetailViewPart.kt */
final /* synthetic */ class FeedVideoDetailViewPart$onAttach$1 extends MutablePropertyReference0Impl {
    FeedVideoDetailViewPart$onAttach$1(FeedVideoDetailViewPart feedVideoDetailViewPart) {
        super(feedVideoDetailViewPart, FeedVideoDetailViewPart.class, "detailControlCover", "getDetailControlCover()Lcom/coolapk/market/view/video/DetailControlCover;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return FeedVideoDetailViewPart.access$getDetailControlCover$p((FeedVideoDetailViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((FeedVideoDetailViewPart) this.receiver).detailControlCover = (DetailControlCover) obj;
    }
}
