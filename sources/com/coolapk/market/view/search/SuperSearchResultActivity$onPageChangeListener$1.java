package com.coolapk.market.view.search;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/search/SuperSearchResultActivity$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchResultActivity.kt */
public final class SuperSearchResultActivity$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ SuperSearchResultActivity this$0;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SuperSearchResultActivity$onPageChangeListener$1(SuperSearchResultActivity superSearchResultActivity) {
        this.this$0 = superSearchResultActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        StatisticHelper.Companion.getInstance().recordEvent("V9搜索界面", this.this$0.getTitles()[i]);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = SuperSearchResultActivity.access$getBinding$p(this.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            Fragment viewPagerFragment = this.this$0.getViewPagerFragment(scrollStateViewPager.getCurrentItem());
            if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                ((InitBehavior) viewPagerFragment).initData();
            }
        }
    }
}
