package com.coolapk.market.view.main;

import com.coolapk.market.view.main.MainFragment;
import com.coolapk.market.widget.view.TabLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$TabIndicatorHandler$onTabSelected$1 implements Runnable {
    final /* synthetic */ TabLayout.Tab $tab;
    final /* synthetic */ MainFragment.TabIndicatorHandler this$0;

    MainFragment$TabIndicatorHandler$onTabSelected$1(MainFragment.TabIndicatorHandler tabIndicatorHandler, TabLayout.Tab tab) {
        this.this$0 = tabIndicatorHandler;
        this.$tab = tab;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.checkTabIndicatorState(this.$tab);
    }
}
