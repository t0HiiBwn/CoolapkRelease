package com.coolapk.market.view.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.main.MainFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$MyComplexViewHelperCallback$onPageSelected$1 implements Runnable {
    final /* synthetic */ MainFragment.MyComplexViewHelperCallback this$0;

    MainFragment$MyComplexViewHelperCallback$onPageSelected$1(MainFragment.MyComplexViewHelperCallback myComplexViewHelperCallback) {
        this.this$0 = myComplexViewHelperCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView currentRecyclerView = MainFragment.this.getComplexViewHelper().getCurrentRecyclerView();
        RecyclerView.LayoutManager layoutManager = currentRecyclerView != null ? currentRecyclerView.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            MainFragment.this.showHomeRefreshIcon(((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= 7);
        }
    }
}
