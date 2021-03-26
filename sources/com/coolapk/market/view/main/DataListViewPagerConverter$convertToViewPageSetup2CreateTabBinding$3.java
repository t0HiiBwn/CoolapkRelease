package com.coolapk.market.view.main;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/main/DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$3", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
public final class DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$3 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1 $adapter;
    final /* synthetic */ RefreshRecyclerTabsBinding $binding;

    DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$3(RefreshRecyclerTabsBinding refreshRecyclerTabsBinding, DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1 dataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1) {
        this.$binding = refreshRecyclerTabsBinding;
        this.$adapter = dataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = this.$binding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            Object instantiateItem = this.$adapter.instantiateItem((ViewGroup) this.$binding.viewPager, scrollStateViewPager.getCurrentItem());
            Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(…ng.viewPager, currentPos)");
            if ((instantiateItem instanceof Fragment) && ((Fragment) instantiateItem).isVisible() && (instantiateItem instanceof InitBehavior)) {
                ((InitBehavior) instantiateItem).initData();
            }
        }
    }
}
