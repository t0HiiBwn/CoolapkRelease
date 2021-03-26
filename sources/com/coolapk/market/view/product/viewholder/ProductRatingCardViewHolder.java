package com.coolapk.market.view.product.viewholder;

import android.view.View;
import com.coolapk.market.view.product.ProductViewModel;
import com.coolapk.market.viewholder.BaseRatingCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductRatingCardViewHolder;", "Lcom/coolapk/market/viewholder/BaseRatingCardViewHolder;", "view", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/product/ProductViewModel;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductRatingCardViewHolder.kt */
public final class ProductRatingCardViewHolder extends BaseRatingCardViewHolder {
    private final ProductViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductRatingCardViewHolder(View view, ProductViewModel productViewModel) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        this.viewModel = productViewModel;
    }

    @Override // com.coolapk.market.viewholder.BaseRatingCardViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        super.bindTo(obj);
        this.itemView.setOnClickListener(new ProductRatingCardViewHolder$bindTo$1(this));
    }
}
