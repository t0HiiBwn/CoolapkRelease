package com.coolapk.market.view.main;

import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/main/ProductFragmentVX$onActivityCreated$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductFragmentVX.kt */
public final class ProductFragmentVX$onActivityCreated$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ ProductFragmentVX this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ProductFragmentVX$onActivityCreated$1(ProductFragmentVX productFragmentVX) {
        this.this$0 = productFragmentVX;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        String title = ((ConfigPage) this.this$0.configPages.get(i)).getTitle();
        if (title == null) {
            title = "";
        }
        instance.recordHomeTabEvent(title);
    }
}
