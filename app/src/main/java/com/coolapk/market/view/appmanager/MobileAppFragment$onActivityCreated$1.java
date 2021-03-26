package com.coolapk.market.view.appmanager;

import com.coolapk.market.view.appmanager.MobileAppContract;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppFragment.kt */
final /* synthetic */ class MobileAppFragment$onActivityCreated$1 extends MutablePropertyReference0Impl {
    MobileAppFragment$onActivityCreated$1(MobileAppFragment mobileAppFragment) {
        super(mobileAppFragment, MobileAppFragment.class, "presenter", "getPresenter()Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return MobileAppFragment.access$getPresenter$p((MobileAppFragment) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((MobileAppFragment) this.receiver).presenter = (MobileAppContract.Presenter) obj;
    }
}
