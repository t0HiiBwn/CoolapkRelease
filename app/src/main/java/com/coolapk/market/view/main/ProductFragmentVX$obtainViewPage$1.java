package com.coolapk.market.view.main;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductFragmentVX.kt */
final /* synthetic */ class ProductFragmentVX$obtainViewPage$1 extends MutablePropertyReference0Impl {
    ProductFragmentVX$obtainViewPage$1(ProductFragmentVX productFragmentVX) {
        super(productFragmentVX, ProductFragmentVX.class, "viewPager", "getViewPager()Landroidx/viewpager/widget/ViewPager;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ProductFragmentVX.access$getViewPager$p((ProductFragmentVX) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((ProductFragmentVX) this.receiver).viewPager = (ViewPager) obj;
    }
}
