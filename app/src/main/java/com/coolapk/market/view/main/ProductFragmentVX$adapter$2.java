package com.coolapk.market.view.main;

import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.main.ProductFragmentVX;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/ProductFragmentVX$PagerAdapter;", "Lcom/coolapk/market/view/main/ProductFragmentVX;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductFragmentVX.kt */
final class ProductFragmentVX$adapter$2 extends Lambda implements Function0<ProductFragmentVX.PagerAdapter> {
    final /* synthetic */ ProductFragmentVX this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductFragmentVX$adapter$2(ProductFragmentVX productFragmentVX) {
        super(0);
        this.this$0 = productFragmentVX;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ProductFragmentVX.PagerAdapter invoke() {
        ProductFragmentVX productFragmentVX = this.this$0;
        FragmentManager childFragmentManager = productFragmentVX.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return new ProductFragmentVX.PagerAdapter(productFragmentVX, childFragmentManager);
    }
}
