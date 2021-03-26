package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityVideoDetailViewPart.kt */
final /* synthetic */ class EntityVideoDetailViewPart$onAttach$1 extends MutablePropertyReference0Impl {
    EntityVideoDetailViewPart$onAttach$1(EntityVideoDetailViewPart entityVideoDetailViewPart) {
        super(entityVideoDetailViewPart, EntityVideoDetailViewPart.class, "detailControlCover", "getDetailControlCover()Lcom/coolapk/market/view/video/DetailControlCover;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return EntityVideoDetailViewPart.access$getDetailControlCover$p((EntityVideoDetailViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((EntityVideoDetailViewPart) this.receiver).detailControlCover = (DetailControlCover) obj;
    }
}
