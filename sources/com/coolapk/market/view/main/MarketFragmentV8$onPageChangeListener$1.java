package com.coolapk.market.view.main;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.InitBehavior;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/main/MarketFragmentV8$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MarketFragmentV8.kt */
public final class MarketFragmentV8$onPageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ MarketFragmentV8 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MarketFragmentV8$onPageChangeListener$1(MarketFragmentV8 marketFragmentV8) {
        this.this$0 = marketFragmentV8;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            Fragment viewPagerFragment = this.this$0.getViewPagerFragment(MarketFragmentV8.access$getViewPager$p(this.this$0).getCurrentItem());
            if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                ((InitBehavior) viewPagerFragment).initData();
            }
        }
    }
}
