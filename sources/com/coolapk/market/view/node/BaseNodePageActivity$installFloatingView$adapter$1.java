package com.coolapk.market.view.node;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.DataListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$installFloatingView$adapter$1", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "getPageTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$installFloatingView$adapter$1 extends FragmentStatePagerAdapter {
    final /* synthetic */ Function1 $factor;
    final /* synthetic */ List $tabApiList;
    final /* synthetic */ BaseNodePageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNodePageActivity$installFloatingView$adapter$1(BaseNodePageActivity baseNodePageActivity, List list, Function1 function1, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.this$0 = baseNodePageActivity;
        this.$tabApiList = list;
        this.$factor = function1;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        DataListFragment dataListFragment;
        ConfigPage configPage = (ConfigPage) this.$tabApiList.get(i);
        Function1 function1 = this.$factor;
        if (function1 == null || (dataListFragment = (EntityListFragment) function1.invoke(configPage)) == null) {
            DataListFragment.Companion companion = DataListFragment.Companion;
            String url = configPage.getUrl();
            if (url == null) {
                url = "";
            }
            String title = configPage.getTitle();
            if (title == null) {
                title = "";
            }
            String subTitle = configPage.getSubTitle();
            if (subTitle == null) {
                subTitle = "";
            }
            dataListFragment = DataListFragment.Companion.newInstance$default(companion, url, title, subTitle, 0, 8, null);
        }
        Entity lastSelectedSubPage = EntityExtendsKt.getLastSelectedSubPage(configPage);
        if (lastSelectedSubPage != null) {
            dataListFragment.getEntityRequestArgHelper().setRequestArg(lastSelectedSubPage);
        }
        return dataListFragment;
    }

    @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
    public String getItemTag(int i) {
        return ((ConfigPage) this.$tabApiList.get(i)).getTitle() + '_' + i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.$tabApiList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public String getPageTitle(int i) {
        return EntityExtendsKt.getLastSelectedSubPageTitle((ConfigPage) this.$tabApiList.get(i));
    }
}
