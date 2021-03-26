package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: SimpleVideoDetailViewPart.kt */
final /* synthetic */ class SimpleVideoDetailViewPart$onAttach$1 extends MutablePropertyReference0Impl {
    SimpleVideoDetailViewPart$onAttach$1(SimpleVideoDetailViewPart simpleVideoDetailViewPart) {
        super(simpleVideoDetailViewPart, SimpleVideoDetailViewPart.class, "detailControlCover", "getDetailControlCover()Lcom/coolapk/market/view/video/DetailControlCover;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return SimpleVideoDetailViewPart.access$getDetailControlCover$p((SimpleVideoDetailViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((SimpleVideoDetailViewPart) this.receiver).detailControlCover = (DetailControlCover) obj;
    }
}
