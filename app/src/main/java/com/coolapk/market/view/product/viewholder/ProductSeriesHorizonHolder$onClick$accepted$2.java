package com.coolapk.market.view.product.viewholder;

import android.widget.TextView;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.widget.view.FollowStyleTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductSeriesHorizonHolder.kt */
final class ProductSeriesHorizonHolder$onClick$accepted$2 extends Lambda implements Function1<Throwable, Boolean> {
    final /* synthetic */ Product $product;
    final /* synthetic */ ProductSeriesHorizonHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductSeriesHorizonHolder$onClick$accepted$2(ProductSeriesHorizonHolder productSeriesHorizonHolder, Product product) {
        super(1);
        this.this$0 = productSeriesHorizonHolder;
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
        ProductSeriesHorizonHolder productSeriesHorizonHolder = this.this$0;
        TextView textView = productSeriesHorizonHolder.binding.subtitleView2;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subtitleView2");
        FollowStyleTextView followStyleTextView = this.this$0.binding.actionButton2;
        Intrinsics.checkNotNullExpressionValue(followStyleTextView, "binding.actionButton2");
        FollowStyleTextView followStyleTextView2 = followStyleTextView;
        UserAction userAction = this.$product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
        boolean z = true;
        if (userAction.getFollow() != 1) {
            z = false;
        }
        productSeriesHorizonHolder.setFollowText(textView, followStyleTextView2, z, this.$product.getFollowNum());
        return false;
    }
}
