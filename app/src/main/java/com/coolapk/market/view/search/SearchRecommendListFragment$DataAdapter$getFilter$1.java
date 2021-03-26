package com.coolapk.market.view.search;

import android.text.TextUtils;
import com.coolapk.market.view.search.SearchRecommendListFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchRecommendListFragment.kt */
final class SearchRecommendListFragment$DataAdapter$getFilter$1<T> implements Action1<String> {
    final /* synthetic */ SearchRecommendListFragment.DataAdapter this$0;

    SearchRecommendListFragment$DataAdapter$getFilter$1(SearchRecommendListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    public final void call(String str) {
        if (!TextUtils.isEmpty(str)) {
            SearchRecommendListFragment searchRecommendListFragment = SearchRecommendListFragment.this;
            Intrinsics.checkNotNullExpressionValue(str, "it");
            searchRecommendListFragment.clearDataAndReload(str);
            synchronized (SearchRecommendListFragment.this.filterLock) {
                while (SearchRecommendListFragment.this.isTaskLoading) {
                    try {
                        SearchRecommendListFragment.this.filterLock.wait();
                        break;
                    } catch (InterruptedException unused) {
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
