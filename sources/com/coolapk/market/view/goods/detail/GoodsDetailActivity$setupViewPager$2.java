package com.coolapk.market.view.goods.detail;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/goods/detail/GoodsDetailActivity$setupViewPager$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "initData", "", "currentPos", "", "onPageScrollStateChanged", "state", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
public final class GoodsDetailActivity$setupViewPager$2 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ GoodsDetailActivity$setupViewPager$adapter$1 $adapter;
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$setupViewPager$2(GoodsDetailActivity goodsDetailActivity, GoodsDetailActivity$setupViewPager$adapter$1 goodsDetailActivity$setupViewPager$adapter$1) {
        this.this$0 = goodsDetailActivity;
        this.$adapter = goodsDetailActivity$setupViewPager$adapter$1;
        ScrollStateViewPager scrollStateViewPager = GoodsDetailActivity.access$getBinding$p(goodsDetailActivity).viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        initData(scrollStateViewPager.getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = GoodsDetailActivity.access$getBinding$p(this.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            initData(scrollStateViewPager.getCurrentItem());
        }
    }

    private final void initData(int i) {
        Object instantiateItem = this.$adapter.instantiateItem((ViewGroup) GoodsDetailActivity.access$getBinding$p(this.this$0).viewPager, i);
        Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(…ng.viewPager, currentPos)");
        if ((instantiateItem instanceof Fragment) && ((Fragment) instantiateItem).isVisible() && (instantiateItem instanceof InitBehavior)) {
            ((InitBehavior) instantiateItem).initData();
        }
    }
}
