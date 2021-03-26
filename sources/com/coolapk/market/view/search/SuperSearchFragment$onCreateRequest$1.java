package com.coolapk.market.view.search;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onCreateRequest$1 implements Action0 {
    final /* synthetic */ SuperSearchFragment this$0;

    SuperSearchFragment$onCreateRequest$1(SuperSearchFragment superSearchFragment) {
        this.this$0 = superSearchFragment;
    }

    @Override // rx.functions.Action0
    public final void call() {
        if (this.this$0.shouldLoadMore) {
            this.this$0.shouldLoadMore = false;
            SuperSearchFragment superSearchFragment = this.this$0;
            superSearchFragment.loadMore(superSearchFragment.getDataList().isEmpty());
        }
    }
}
