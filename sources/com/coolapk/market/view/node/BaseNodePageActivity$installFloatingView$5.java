package com.coolapk.market.view.node;

import com.coolapk.market.widget.view.FloatingState;
import com.coolapk.market.widget.view.TabLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$installFloatingView$5", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$installFloatingView$5 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ BaseNodePageActivity this$0;

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$installFloatingView$5(BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = baseNodePageActivity;
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (this.this$0.getHelper$presentation_coolapkAppRelease().getCurrentFloatTop() != this.this$0.getHelper$presentation_coolapkAppRelease().getMinFloatingTop() && this.this$0.getHelper$presentation_coolapkAppRelease().getFloatingState() == FloatingState.DRAGGING) {
            this.this$0.getHelper$presentation_coolapkAppRelease().startFloatingViewCOEAnimation(-10000.0f);
        }
    }
}
