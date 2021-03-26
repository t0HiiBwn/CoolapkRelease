package com.coolapk.market.view.search;

import kotlin.Metadata;
import kotlin.Unit;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$loadHistory$2<T> implements Action1<Unit> {
    final /* synthetic */ SearchMainListFragment this$0;

    SearchMainListFragment$loadHistory$2(SearchMainListFragment searchMainListFragment) {
        this.this$0 = searchMainListFragment;
    }

    public final void call(Unit unit) {
        SearchMainListFragment.access$updateItemSearchHistory(this.this$0);
    }
}
