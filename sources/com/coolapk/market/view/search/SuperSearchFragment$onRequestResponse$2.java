package com.coolapk.market.view.search;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.LogUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onRequestResponse$2 implements Runnable {
    final /* synthetic */ SuperSearchFragment this$0;

    SuperSearchFragment$onRequestResponse$2(SuperSearchFragment superSearchFragment) {
        this.this$0 = superSearchFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        RecyclerView recyclerView2 = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        Intrinsics.checkNotNull(adapter);
        Intrinsics.checkNotNullExpressionValue(adapter, "recyclerView.adapter!!");
        if (findLastCompletelyVisibleItemPosition == adapter.getItemCount() - 1) {
            LogUtils.d("数据不够满一屏，继续加载", new Object[0]);
            this.this$0.loadMore(false);
            return;
        }
        this.this$0.reportExposureApp();
    }
}
