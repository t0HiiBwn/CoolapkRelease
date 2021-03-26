package com.coolapk.market.view.node;

import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.widget.view.IndicatorView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/node/NodeHelper$setupIndicatorAndViewPager$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
public final class NodeHelper$setupIndicatorAndViewPager$2 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ IndicatorView $indicator;

    NodeHelper$setupIndicatorAndViewPager$2(IndicatorView indicatorView) {
        this.$indicator = indicatorView;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        this.$indicator.setSelectedIndex(i);
    }
}
