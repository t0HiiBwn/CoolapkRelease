package com.coolapk.market.view.product;

import com.coolapk.market.view.product.viewholder.ProductLocalData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductSeriesListFragment.kt */
final class ProductSeriesListFragment$onActivityCreated$6 extends Lambda implements Function1<Object, Boolean> {
    public static final ProductSeriesListFragment$onActivityCreated$6 INSTANCE = new ProductSeriesListFragment$onActivityCreated$6();

    ProductSeriesListFragment$onActivityCreated$6() {
        super(1);
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return (!(obj instanceof ProductLocalData) || !Intrinsics.areEqual(((ProductLocalData) obj).getType(), "series_more")) ? null : 1;
    }
}
