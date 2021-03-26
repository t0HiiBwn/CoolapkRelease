package com.coolapk.market.widget.view;

import com.coolapk.market.widget.hotplug.ViewPartPool;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: RelativeInfoView.kt */
final /* synthetic */ class RelativeInfoView$notifyDataSetChange$1 extends MutablePropertyReference0Impl {
    RelativeInfoView$notifyDataSetChange$1(RelativeInfoView relativeInfoView) {
        super(relativeInfoView, RelativeInfoView.class, "viewPartPool", "getViewPartPool()Lcom/coolapk/market/widget/hotplug/ViewPartPool;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((RelativeInfoView) this.receiver).getViewPartPool();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((RelativeInfoView) this.receiver).setViewPartPool((ViewPartPool) obj);
    }
}
