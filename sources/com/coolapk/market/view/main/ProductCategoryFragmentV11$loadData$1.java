package com.coolapk.market.view.main;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.LoadingViewBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/main/ProductCategoryFragmentV11$loadData$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/ProductBrand;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCategoryFragmentV11.kt */
public final class ProductCategoryFragmentV11$loadData$1 extends EmptySubscriber<List<? extends ProductBrand>> {
    final /* synthetic */ ProductCategoryFragmentV11 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ProductCategoryFragmentV11$loadData$1(ProductCategoryFragmentV11 productCategoryFragmentV11) {
        this.this$0 = productCategoryFragmentV11;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        ClientException clientException = (ClientException) (!(th instanceof ClientException) ? null : th);
        if (clientException == null || (str = clientException.getMessage()) == null) {
            str = "获取信息失败，请重试";
        }
        LoadingViewBinding loadingViewBinding = this.this$0.getBinding().loadingView;
        Intrinsics.checkNotNullExpressionValue(loadingViewBinding, "binding.loadingView");
        BindingExtensionKt.setLoadingError(loadingViewBinding, str, new ProductCategoryFragmentV11$loadData$1$onError$1(this));
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(List<? extends ProductBrand> list) {
        Intrinsics.checkNotNullParameter(list, "t");
        super.onNext((ProductCategoryFragmentV11$loadData$1) list);
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = this.this$0.getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.recyclerView");
        preventAutoScrollRecyclerView.setVisibility(0);
        LoadingViewBinding loadingViewBinding = this.this$0.getBinding().loadingView;
        Intrinsics.checkNotNullExpressionValue(loadingViewBinding, "binding.loadingView");
        BindingExtensionKt.setLoadingFinished(loadingViewBinding);
        List<? extends ProductBrand> list2 = list;
        this.this$0.getDataList().addAll(list2);
        this.this$0.getAdapter().notifyDataSetChanged();
        if ((!list2.isEmpty()) && this.this$0.isAdded()) {
            this.this$0.onBrandClick((Entity) CollectionsKt.first((List<? extends Object>) list));
        }
    }
}
