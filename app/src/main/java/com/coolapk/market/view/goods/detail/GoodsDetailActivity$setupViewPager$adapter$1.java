package com.coolapk.market.view.goods.detail;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.goods.detail.GoodsDataListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/goods/detail/GoodsDetailActivity$setupViewPager$adapter$1", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "getPageTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
public final class GoodsDetailActivity$setupViewPager$adapter$1 extends FragmentStatePagerAdapter {
    final /* synthetic */ List $tabApiList;
    final /* synthetic */ GoodsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsDetailActivity$setupViewPager$adapter$1(GoodsDetailActivity goodsDetailActivity, List list, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.this$0 = goodsDetailActivity;
        this.$tabApiList = list;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        ConfigPage configPage = (ConfigPage) this.$tabApiList.get(i);
        GoodsDataListFragment.Companion companion = GoodsDataListFragment.Companion;
        Intrinsics.checkNotNullExpressionValue(configPage, "tabApi");
        String url = configPage.getUrl();
        String str = "";
        if (url == null) {
            url = str;
        }
        String title = configPage.getTitle();
        if (title == null) {
            title = str;
        }
        String subTitle = configPage.getSubTitle();
        if (subTitle != null) {
            str = subTitle;
        }
        GoodsDataListFragment newInstance = companion.newInstance(url, title, str);
        Entity lastSelectedSubPage = EntityExtendsKt.getLastSelectedSubPage(configPage);
        if (lastSelectedSubPage != null) {
            newInstance.getEntityRequestArgHelper().setRequestArg(lastSelectedSubPage);
        }
        return newInstance;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public String getItemTag(int i) {
        StringBuilder sb = new StringBuilder();
        Object obj = this.$tabApiList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "tabApiList[position]");
        sb.append(((ConfigPage) obj).getTitle());
        sb.append('_');
        sb.append(i);
        return sb.toString();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.$tabApiList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public String getPageTitle(int i) {
        Object obj = this.$tabApiList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "tabApiList[position]");
        return EntityExtendsKt.getLastSelectedSubPageTitle((ConfigPage) obj);
    }
}
