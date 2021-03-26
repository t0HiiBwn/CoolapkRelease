package com.coolapk.market.view.product;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/product/ProductBrandListActivity$loadProductList$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/ProductBrand;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductBrandListActivity.kt */
public final class ProductBrandListActivity$loadProductList$1 extends EmptySubscriber<List<? extends ProductBrand>> {
    final /* synthetic */ ProductBrandListActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ProductBrandListActivity$loadProductList$1(ProductBrandListActivity productBrandListActivity) {
        this.this$0 = productBrandListActivity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        String str = "获取信息失败，请重试";
        if (th instanceof ClientException) {
            ProductBrandListActivity productBrandListActivity = this.this$0;
            String message = th.getMessage();
            if (message != null) {
                str = message;
            }
            productBrandListActivity.setLoadingError(str);
        } else {
            this.this$0.setLoadingError(str);
        }
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(List<? extends ProductBrand> list) {
        Intrinsics.checkNotNullParameter(list, "t");
        super.onNext((ProductBrandListActivity$loadProductList$1) list);
        this.this$0.brandList = new ArrayList();
        ArrayList arrayList = this.this$0.brandList;
        if (arrayList != null) {
            arrayList.addAll(list);
        }
        this.this$0.requestCreateFragment();
        this.this$0.setLoadingFinished();
    }
}
