package com.coolapk.market.view.userv9;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupTabsView$adapter$1", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupTabsView$adapter$1 extends FragmentStatePagerAdapter {
    final /* synthetic */ UserSpaceV9Activity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserSpaceV9Activity$setupTabsView$adapter$1(UserSpaceV9Activity userSpaceV9Activity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.this$0 = userSpaceV9Activity;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return UserSpaceV9Activity.access$getTabHelper$p(this.this$0).getFragmentItem(i);
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public String getItemTag(int i) {
        UserSpaceV9Activity userSpaceV9Activity = this.this$0;
        String string = userSpaceV9Activity.getString(UserSpaceV9Activity.access$getTabHelper$p(userSpaceV9Activity).getTabList().get(i).intValue());
        Intrinsics.checkNotNullExpressionValue(string, "getString(tabHelper.tabList.get(position))");
        return string;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return UserSpaceV9Activity.access$getTabHelper$p(this.this$0).getTabList().size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        UserSpaceV9Activity userSpaceV9Activity = this.this$0;
        return userSpaceV9Activity.getString(UserSpaceV9Activity.access$getTabHelper$p(userSpaceV9Activity).getTabList().get(i).intValue());
    }
}
