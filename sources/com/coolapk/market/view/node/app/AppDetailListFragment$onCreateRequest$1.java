package com.coolapk.market.view.node.app;

import com.coolapk.market.model.Entity;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppDetailListFragment.kt */
final class AppDetailListFragment$onCreateRequest$1<V> implements Callable<List<? extends Entity>> {
    final /* synthetic */ AppDetailListFragment this$0;

    AppDetailListFragment$onCreateRequest$1(AppDetailListFragment appDetailListFragment) {
        this.this$0 = appDetailListFragment;
    }

    /* Return type fixed from 'java.util.List<com.coolapk.market.model.Entity>' to match base method */
    @Override // java.util.concurrent.Callable
    public final List<? extends Entity> call() {
        return this.this$0.createData();
    }
}
