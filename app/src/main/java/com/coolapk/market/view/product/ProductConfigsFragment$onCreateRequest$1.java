package com.coolapk.market.view.product;

import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ProductConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/ProductConfig;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductConfigsFragment.kt */
final class ProductConfigsFragment$onCreateRequest$1<T, R> implements Func1<ProductConfig, List<? extends HolderItem>> {
    final /* synthetic */ ProductConfigsFragment this$0;

    ProductConfigsFragment$onCreateRequest$1(ProductConfigsFragment productConfigsFragment) {
        this.this$0 = productConfigsFragment;
    }

    public final List<HolderItem> call(ProductConfig productConfig) {
        ProductConfigsFragment productConfigsFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(productConfig, "it");
        return productConfigsFragment.configDataToDataList(productConfig.getConfigData());
    }
}
