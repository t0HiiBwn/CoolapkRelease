package com.coolapk.market.view.search;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$onCreateRequest$2 implements Action0 {
    final /* synthetic */ SearchMainListFragment this$0;

    SearchMainListFragment$onCreateRequest$2(SearchMainListFragment searchMainListFragment) {
        this.this$0 = searchMainListFragment;
    }

    @Override // rx.functions.Action0
    public final void call() {
        if (this.this$0.shouldRefresh) {
            this.this$0.shouldRefresh = false;
        }
    }
}
