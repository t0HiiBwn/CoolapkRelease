package com.coolapk.market.view.node;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/Product;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
final class ProductNodeLoader$loadData$1<T, R> implements Func1<Result<Product>, Result<Entity>> {
    public static final ProductNodeLoader$loadData$1 INSTANCE = new ProductNodeLoader$loadData$1();

    ProductNodeLoader$loadData$1() {
    }

    public final Result<Entity> call(Result<Product> result) {
        if (!(result instanceof Result)) {
            return null;
        }
        return result;
    }
}
