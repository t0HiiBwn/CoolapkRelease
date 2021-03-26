package com.coolapk.market.view.userv9;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupTabsView$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "initCurrentFragment", "", "onPageScrollStateChanged", "state", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupTabsView$2 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ UserSpaceV9Activity$setupTabsView$adapter$1 $adapter;
    final /* synthetic */ UserSpaceV9Activity this$0;

    UserSpaceV9Activity$setupTabsView$2(UserSpaceV9Activity userSpaceV9Activity, UserSpaceV9Activity$setupTabsView$adapter$1 userSpaceV9Activity$setupTabsView$adapter$1) {
        this.this$0 = userSpaceV9Activity;
        this.$adapter = userSpaceV9Activity$setupTabsView$adapter$1;
        AppHolder.getMainThreadHandler().postDelayed(new Runnable(this) {
            /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$setupTabsView$2.AnonymousClass1 */
            final /* synthetic */ UserSpaceV9Activity$setupTabsView$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.initCurrentFragment();
            }
        }, 300);
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            initCurrentFragment();
        }
    }

    public final void initCurrentFragment() {
        ScrollStateViewPager scrollStateViewPager = UserSpaceV9Activity.access$getBinding$p(this.this$0).viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        Object instantiateItem = this.$adapter.instantiateItem((ViewGroup) UserSpaceV9Activity.access$getBinding$p(this.this$0).viewPager, scrollStateViewPager.getCurrentItem());
        Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(…ng.viewPager, currentPos)");
        boolean z = instantiateItem instanceof Fragment;
        if (z && ((Fragment) instantiateItem).isVisible() && (instantiateItem instanceof InitBehavior)) {
            ((InitBehavior) instantiateItem).initData();
        }
        if (z && ((Fragment) instantiateItem).isVisible() && (instantiateItem instanceof RefreshRecyclerFragment)) {
            ((RefreshRecyclerFragment) instantiateItem).setRefreshEnable(false);
        }
    }
}
