package com.coolapk.market.manager;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/manager/ClearCacheHelper$clearCacheAndGC$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onCompleted", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ClearCacheHelper.kt */
public final class ClearCacheHelper$clearCacheAndGC$1 extends EmptySubscriber<Object> {
    ClearCacheHelper$clearCacheAndGC$1() {
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onCompleted() {
        super.onCompleted();
        System.gc();
    }
}
