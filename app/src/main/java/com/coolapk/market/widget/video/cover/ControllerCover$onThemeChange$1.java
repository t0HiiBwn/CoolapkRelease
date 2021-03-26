package com.coolapk.market.widget.video.cover;

import com.coolapk.market.databinding.VideoControllerBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
final /* synthetic */ class ControllerCover$onThemeChange$1 extends MutablePropertyReference0Impl {
    ControllerCover$onThemeChange$1(ControllerCover controllerCover) {
        super(controllerCover, ControllerCover.class, "binding", "getBinding()Lcom/coolapk/market/databinding/VideoControllerBinding;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ControllerCover.access$getBinding$p((ControllerCover) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((ControllerCover) this.receiver).binding = (VideoControllerBinding) obj;
    }
}
