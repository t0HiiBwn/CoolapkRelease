package com.coolapk.market.view.main;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: DataListFragment.kt */
final /* synthetic */ class DataListFragment$shouldShowShareView$1 extends MutablePropertyReference0Impl {
    DataListFragment$shouldShowShareView$1(DataListFragment dataListFragment) {
        super(dataListFragment, DataListFragment.class, "url", "getUrl()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((DataListFragment) this.receiver).getUrl();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((DataListFragment) this.receiver).setUrl((String) obj);
    }
}
