package com.coolapk.market.view.product.viewholder;

import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductSeriesVerticalHolder.kt */
final class ProductSeriesVerticalHolder$onClick$accepted$1 extends Lambda implements Function1<Throwable, Boolean> {
    final /* synthetic */ Product $product;
    final /* synthetic */ ProductSeriesVerticalHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductSeriesVerticalHolder$onClick$accepted$1(ProductSeriesVerticalHolder productSeriesVerticalHolder, Product product) {
        super(1);
        this.this$0 = productSeriesVerticalHolder;
        this.$product = product;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke(th));
    }

    public final boolean invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ProductSeriesVerticalHolder productSeriesVerticalHolder = this.this$0;
        UserAction userAction = this.$product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
        boolean z = true;
        if (userAction.getFollow() != 1) {
            z = false;
        }
        productSeriesVerticalHolder.setFollowText(z);
        return false;
    }
}
