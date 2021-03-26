package com.coolapk.market.view.dyhv8;

import com.coolapk.market.view.main.DataListViewPagerConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
final /* synthetic */ class DyhDetailFragment$scrollToTop$1 extends MutablePropertyReference0Impl {
    DyhDetailFragment$scrollToTop$1(DyhDetailFragment dyhDetailFragment) {
        super(dyhDetailFragment, DyhDetailFragment.class, "viewPagerConverter", "getViewPagerConverter()Lcom/coolapk/market/view/main/DataListViewPagerConverter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return DyhDetailFragment.access$getViewPagerConverter$p((DyhDetailFragment) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((DyhDetailFragment) this.receiver).viewPagerConverter = (DataListViewPagerConverter) obj;
    }
}
