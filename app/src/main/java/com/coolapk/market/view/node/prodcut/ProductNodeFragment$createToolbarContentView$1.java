package com.coolapk.market.view.node.prodcut;

import android.view.View;
import com.coolapk.market.model.Product;
import com.coolapk.market.view.product.ProductPresenter;
import com.coolapk.market.view.product.ProductViewModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductNodeFragment.kt */
final class ProductNodeFragment$createToolbarContentView$1 implements View.OnClickListener {
    final /* synthetic */ Product $data;
    final /* synthetic */ ProductPresenter $presenter;
    final /* synthetic */ ProductViewModel $viewModel;

    ProductNodeFragment$createToolbarContentView$1(ProductPresenter productPresenter, Product product, ProductViewModel productViewModel) {
        this.$presenter = productPresenter;
        this.$data = product;
        this.$viewModel = productViewModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ProductPresenter productPresenter = this.$presenter;
        String id = this.$data.getId();
        if (id == null) {
            id = "";
        }
        productPresenter.followProduct(id, this.$viewModel.getFollowState(), !this.$viewModel.getFollowState());
    }
}
