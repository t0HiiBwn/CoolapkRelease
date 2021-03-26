package com.coolapk.market.widget.video.cover;

import com.coolapk.market.databinding.VideoErrorBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ErrorCover.kt */
final /* synthetic */ class ErrorCover$setViewBackground$1 extends MutablePropertyReference0Impl {
    ErrorCover$setViewBackground$1(ErrorCover errorCover) {
        super(errorCover, ErrorCover.class, "binding", "getBinding()Lcom/coolapk/market/databinding/VideoErrorBinding;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ErrorCover.access$getBinding$p((ErrorCover) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((ErrorCover) this.receiver).binding = (VideoErrorBinding) obj;
    }
}
