package com.coolapk.market.view.goods;

import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.feed.pick.GoodsCouponSearchListFragment;
import com.coolapk.market.widget.view.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, d2 = {"com/coolapk/market/view/goods/GoodsCouponSearchActivity$onCreate$2", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "updateIndicatorView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsCouponSearchActivity.kt */
public final class GoodsCouponSearchActivity$onCreate$2 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ GoodsCouponSearchActivity this$0;

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GoodsCouponSearchActivity$onCreate$2(GoodsCouponSearchActivity goodsCouponSearchActivity) {
        this.this$0 = goodsCouponSearchActivity;
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (tab.getPosition() == 2) {
            GoodsCouponSearchActivity goodsCouponSearchActivity = this.this$0;
            goodsCouponSearchActivity.isAscPriceSort = !goodsCouponSearchActivity.isAscPriceSort;
            String str = this.this$0.isAscPriceSort ? "asc" : "desc";
            Fragment viewPagerFragment = this.this$0.getViewPagerFragment(2);
            if (!(viewPagerFragment instanceof GoodsCouponSearchListFragment)) {
                viewPagerFragment = null;
            }
            GoodsCouponSearchListFragment goodsCouponSearchListFragment = (GoodsCouponSearchListFragment) viewPagerFragment;
            if (goodsCouponSearchListFragment != null) {
                goodsCouponSearchListFragment.resetSort(str);
            }
            updateIndicatorView();
        }
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        View view = this.this$0.priceIndicatorView;
        if (view != null) {
            ViewKt.setVisible(view, tab.getPosition() == 2);
        }
        updateIndicatorView();
    }

    private final void updateIndicatorView() {
        if (this.this$0.isAscPriceSort) {
            View view = this.this$0.priceIndicatorView;
            if (view != null) {
                view.setRotation(90.0f);
                return;
            }
            return;
        }
        View view2 = this.this$0.priceIndicatorView;
        if (view2 != null) {
            view2.setRotation(-90.0f);
        }
    }
}
