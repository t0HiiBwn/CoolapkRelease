package com.coolapk.market.view.dyhv8;

import androidx.fragment.app.Fragment;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.dyhv8.SimpleArticleListFragment;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\r"}, d2 = {"com/coolapk/market/view/dyhv8/DyhDetailFragment$parseIconTab$1", "Lcom/coolapk/market/view/main/DataListViewPagerConverter$Callback;", "pageCount", "", "getPageCount", "()I", "tabCount", "getTabCount", "getTitle", "", "index", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
public final class DyhDetailFragment$parseIconTab$1 implements DataListViewPagerConverter.Callback {
    final /* synthetic */ List $tabList;
    private final int tabCount;
    final /* synthetic */ DyhDetailFragment this$0;

    DyhDetailFragment$parseIconTab$1(DyhDetailFragment dyhDetailFragment, List list) {
        this.this$0 = dyhDetailFragment;
        this.$tabList = list;
        Intrinsics.checkNotNull(list);
        this.tabCount = list.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public boolean isTabClickable(int i) {
        return DataListViewPagerConverter.Callback.DefaultImpls.isTabClickable(this, i);
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public void onOpenNewActivity(int i) {
        DataListViewPagerConverter.Callback.DefaultImpls.onOpenNewActivity(this, i);
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getTabCount() {
        return this.tabCount;
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getPageCount() {
        List list = this.$tabList;
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public String getTitle(int i) {
        List list = this.$tabList;
        Intrinsics.checkNotNull(list);
        Object obj = list.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "tabList!![index]");
        String title = ((Entity) obj).getTitle();
        Intrinsics.checkNotNull(title);
        return title;
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public Fragment onCreateFragment(int i) {
        List list = this.$tabList;
        Intrinsics.checkNotNull(list);
        Entity entity = (Entity) list.get(i);
        SimpleArticleListFragment.Companion companion = SimpleArticleListFragment.Companion;
        DyhModel dyhModel = this.this$0.viewModel.getDyhModel();
        Intrinsics.checkNotNullExpressionValue(dyhModel, "viewModel.dyhModel");
        String id = dyhModel.getId();
        Intrinsics.checkNotNull(id);
        Intrinsics.checkNotNullExpressionValue(id, "viewModel.dyhModel.id!!");
        Intrinsics.checkNotNullExpressionValue(entity, "tab");
        String url = entity.getUrl();
        Intrinsics.checkNotNull(url);
        Intrinsics.checkNotNullExpressionValue(url, "tab.url!!");
        DyhModel dyhModel2 = this.this$0.viewModel.getDyhModel();
        Intrinsics.checkNotNullExpressionValue(dyhModel2, "viewModel.dyhModel");
        SimpleArticleListFragment newInstance = companion.newInstance(id, url, dyhModel2.getStatus());
        newInstance.setRecordId(this.this$0.id + '_' + entity.getTitle());
        return newInstance;
    }
}
