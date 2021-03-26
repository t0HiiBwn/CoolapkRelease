package com.coolapk.market.view.main;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: MarketFragmentV8.kt */
final /* synthetic */ class MarketFragmentV8$obtainViewPage$1 extends MutablePropertyReference0Impl {
    MarketFragmentV8$obtainViewPage$1(MarketFragmentV8 marketFragmentV8) {
        super(marketFragmentV8, MarketFragmentV8.class, "viewPager", "getViewPager()Landroidx/viewpager/widget/ViewPager;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return MarketFragmentV8.access$getViewPager$p((MarketFragmentV8) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((MarketFragmentV8) this.receiver).viewPager = (ViewPager) obj;
    }
}
