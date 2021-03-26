package com.coolapk.market.view.app;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewListFragment.kt */
final class AppViewListFragment$onActivityCreated$16 implements Runnable {
    final /* synthetic */ AppViewListFragment this$0;

    AppViewListFragment$onActivityCreated$16(AppViewListFragment appViewListFragment) {
        this.this$0 = appViewListFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.this$0.isDataLoaded()) {
            this.this$0.addRefreshView();
        }
    }
}
