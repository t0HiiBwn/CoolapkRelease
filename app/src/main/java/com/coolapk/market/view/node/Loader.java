package com.coolapk.market.view.node;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/Loader;", "", "checkIdentity", "", "loadData", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "loadingPlaceHolderRes", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
public interface Loader {
    boolean checkIdentity();

    Observable<Result<Entity>> loadData();

    int loadingPlaceHolderRes();
}
