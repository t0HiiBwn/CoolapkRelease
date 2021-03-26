package com.coolapk.market.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/main/DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "getPageTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
public final class DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1 extends FragmentStatePagerAdapter {
    final /* synthetic */ DataListViewPagerConverter.Callback $callback;
    final /* synthetic */ DataListViewPagerConverter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1(DataListViewPagerConverter dataListViewPagerConverter, DataListViewPagerConverter.Callback callback, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.this$0 = dataListViewPagerConverter;
        this.$callback = callback;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.$callback.onCreateFragment(i);
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public String getItemTag(int i) {
        return this.$callback.getTitle(i) + '_' + i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.$callback.getPageCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public String getPageTitle(int i) {
        return this.$callback.getTitle(i);
    }
}
