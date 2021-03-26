package com.coolapk.market.view.base;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/base/CoolApkVXNestBaseActivity$installViewAppendView$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolApkVXNestBaseActivity.kt */
public final class CoolApkVXNestBaseActivity$installViewAppendView$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ CoolApkVXNestBaseActivity$installViewAppendView$adapter$1 $adapter;
    final /* synthetic */ CoolApkVXNestBaseActivity this$0;

    CoolApkVXNestBaseActivity$installViewAppendView$1(CoolApkVXNestBaseActivity coolApkVXNestBaseActivity, CoolApkVXNestBaseActivity$installViewAppendView$adapter$1 coolApkVXNestBaseActivity$installViewAppendView$adapter$1) {
        this.this$0 = coolApkVXNestBaseActivity;
        this.$adapter = coolApkVXNestBaseActivity$installViewAppendView$adapter$1;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = CoolApkVXNestBaseActivity.access$getBinding$p(this.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            Object instantiateItem = this.$adapter.instantiateItem((ViewGroup) CoolApkVXNestBaseActivity.access$getBinding$p(this.this$0).viewPager, scrollStateViewPager.getCurrentItem());
            Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(…ng.viewPager, currentPos)");
            if ((instantiateItem instanceof Fragment) && ((Fragment) instantiateItem).isVisible() && (instantiateItem instanceof InitBehavior)) {
                ((InitBehavior) instantiateItem).initData();
            }
        }
    }
}
