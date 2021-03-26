package com.coolapk.market.view.main;

import com.coolapk.market.widget.view.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$TabIndicatorHandler$onTabReselected$isShowed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TabLayout.Tab $tab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragment$TabIndicatorHandler$onTabReselected$isShowed$1(TabLayout.Tab tab) {
        super(0);
        this.$tab = tab;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        TabLayout.TabView tabView = this.$tab.getTabView();
        if (tabView != null) {
            tabView.setIndicatorViewState(false);
        }
    }
}
