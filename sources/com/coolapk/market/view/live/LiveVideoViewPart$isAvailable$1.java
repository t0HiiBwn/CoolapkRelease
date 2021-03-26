package com.coolapk.market.view.live;

import com.coolapk.market.widget.video.SharedPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final /* synthetic */ class LiveVideoViewPart$isAvailable$1 extends MutablePropertyReference0Impl {
    LiveVideoViewPart$isAvailable$1(LiveVideoViewPart liveVideoViewPart) {
        super(liveVideoViewPart, LiveVideoViewPart.class, "player", "getPlayer()Lcom/coolapk/market/widget/video/SharedPlayer;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return LiveVideoViewPart.access$getPlayer$p((LiveVideoViewPart) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((LiveVideoViewPart) this.receiver).player = (SharedPlayer) obj;
    }
}
