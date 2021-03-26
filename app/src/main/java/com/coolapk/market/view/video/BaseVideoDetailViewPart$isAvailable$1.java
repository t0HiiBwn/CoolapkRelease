package com.coolapk.market.view.video;

import com.coolapk.market.widget.video.SharedPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseVideoDetailViewPart.kt */
final /* synthetic */ class BaseVideoDetailViewPart$isAvailable$1 extends MutablePropertyReference0Impl {
    BaseVideoDetailViewPart$isAvailable$1(BaseVideoDetailViewPart baseVideoDetailViewPart) {
        super(baseVideoDetailViewPart, BaseVideoDetailViewPart.class, "player", "getPlayer()Lcom/coolapk/market/widget/video/SharedPlayer;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return BaseVideoDetailViewPart.access$getPlayer$p((BaseVideoDetailViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((BaseVideoDetailViewPart) this.receiver).player = (SharedPlayer) obj;
    }
}
