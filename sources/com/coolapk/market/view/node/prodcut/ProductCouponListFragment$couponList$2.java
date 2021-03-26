package com.coolapk.market.view.node.prodcut;

import com.coolapk.market.model.ProductCoupon;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/ProductCoupon;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductCouponListFragment.kt */
final class ProductCouponListFragment$couponList$2 extends Lambda implements Function0<ArrayList<ProductCoupon>> {
    final /* synthetic */ ProductCouponListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductCouponListFragment$couponList$2(ProductCouponListFragment productCouponListFragment) {
        super(0);
        this.this$0 = productCouponListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ArrayList<ProductCoupon> invoke() {
        ArrayList<ProductCoupon> parcelableArrayList = this.this$0.requireArguments().getParcelableArrayList("COUPON_LIST");
        Intrinsics.checkNotNull(parcelableArrayList);
        return parcelableArrayList;
    }
}
