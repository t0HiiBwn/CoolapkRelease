package com.coolapk.market.view.main;

import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/view/main/NavigationItem;", "invoke", "()[Lcom/coolapk/market/view/main/NavigationItem;"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class NavigationHelper$navigationItems$2 extends Lambda implements Function0<NavigationItem[]> {
    final /* synthetic */ NavigationHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationHelper$navigationItems$2(NavigationHelper navigationHelper) {
        super(0);
        this.this$0 = navigationHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NavigationItem[] invoke() {
        String appMode = AppHolder.getAppMetadata().getAppMode();
        return (appMode != null && appMode.hashCode() == -1480249367 && appMode.equals("community")) ? new NavigationItem[]{this.this$0.itemHome, this.this$0.itemPhoneBa, this.this$0.itemDiscovery, this.this$0.itemMine} : new NavigationItem[]{this.this$0.itemHome, this.this$0.itemPhoneBa, this.this$0.itemDiscovery, this.this$0.itemAppAndGame, this.this$0.itemMine};
    }
}
