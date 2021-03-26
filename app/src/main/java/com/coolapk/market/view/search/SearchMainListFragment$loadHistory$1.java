package com.coolapk.market.view.search;

import android.database.Cursor;
import com.coolapk.market.local.Db;
import com.coolapk.market.manager.DataManager;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$loadHistory$1<V> implements Callable<Unit> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ SearchMainListFragment this$0;

    SearchMainListFragment$loadHistory$1(SearchMainListFragment searchMainListFragment, String str) {
        this.this$0 = searchMainListFragment;
        this.$keyword = str;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Db dataBase = instance.getDataBase();
        Cursor query = dataBase.query("SELECT * FROM searchHistory WHERE keyword LIKE ? ORDER BY modified DESC", '%' + this.$keyword + '%');
        SearchMainListFragment.access$getHistoryDataSet$p(this.this$0).clear();
        Intrinsics.checkNotNullExpressionValue(query, "cursor");
        int count = query.getCount();
        for (int i = 0; i < count; i++) {
            query.moveToPosition(i);
            SearchMainListFragment.access$getHistoryDataSet$p(this.this$0).add(query.getString(1));
        }
        query.close();
    }
}
