package com.coolapk.market.view.dyhv8;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.widget.view.TabLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/dyhv8/DyhDetailFragment$parseIconTab$tabSelectListener$1", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
public final class DyhDetailFragment$parseIconTab$tabSelectListener$1 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ DyhDetailFragment this$0;

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    DyhDetailFragment$parseIconTab$tabSelectListener$1(DyhDetailFragment dyhDetailFragment) {
        this.this$0 = dyhDetailFragment;
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        FragmentActivity activity = this.this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
        ((DyhDetailActivity) activity).setPage(Integer.valueOf(tab.getPosition()));
    }
}
