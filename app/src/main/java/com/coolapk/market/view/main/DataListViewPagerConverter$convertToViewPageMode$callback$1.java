package com.coolapk.market.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0013"}, d2 = {"com/coolapk/market/view/main/DataListViewPagerConverter$convertToViewPageMode$callback$1", "Lcom/coolapk/market/view/main/DataListViewPagerConverter$Callback;", "pageCount", "", "getPageCount", "()I", "tabCount", "getTabCount", "getEntityAtIndex", "Lcom/coolapk/market/model/Entity;", "index", "getTitle", "", "isTabClickable", "", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onOpenNewActivity", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
public final class DataListViewPagerConverter$convertToViewPageMode$callback$1 implements DataListViewPagerConverter.Callback {
    final /* synthetic */ List $newActivityEntity;
    final /* synthetic */ List $pageEntities;
    final /* synthetic */ DataListViewPagerConverter this$0;

    DataListViewPagerConverter$convertToViewPageMode$callback$1(DataListViewPagerConverter dataListViewPagerConverter, List list, List list2) {
        this.this$0 = dataListViewPagerConverter;
        this.$newActivityEntity = list;
        this.$pageEntities = list2;
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getTabCount() {
        return this.$newActivityEntity.size() + this.$pageEntities.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getPageCount() {
        return this.$pageEntities.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public String getTitle(int i) {
        String title = getEntityAtIndex(i).getTitle();
        return title != null ? title : "";
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public Fragment onCreateFragment(int i) {
        Entity entityAtIndex = getEntityAtIndex(i);
        DataListViewPagerConverter dataListViewPagerConverter = this.this$0;
        String url = entityAtIndex.getUrl();
        String str = "";
        if (url == null) {
            url = str;
        }
        if (dataListViewPagerConverter.isFlexList(url)) {
            FallsListFragment.Companion companion = FallsListFragment.Companion;
            String url2 = entityAtIndex.getUrl();
            if (url2 != null) {
                str = url2;
            }
            return companion.newInstance(str, entityAtIndex.getTitle(), entityAtIndex.getSubTitle());
        }
        DataListFragment.Companion companion2 = DataListFragment.Companion;
        String url3 = entityAtIndex.getUrl();
        if (url3 == null) {
            url3 = str;
        }
        return DataListFragment.Companion.newInstance$default(companion2, url3, entityAtIndex.getTitle(), entityAtIndex.getSubTitle(), 0, 8, null);
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public void onOpenNewActivity(int i) {
        Entity entityAtIndex = getEntityAtIndex(i);
        FragmentActivity requireActivity = this.this$0.getFragment().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        ActionManagerCompat.startActivityByUrl(requireActivity, entityAtIndex.getUrl(), entityAtIndex.getTitle(), entityAtIndex.getSubTitle());
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public boolean isTabClickable(int i) {
        String url = getEntityAtIndex(i).getUrl();
        return !(url == null || StringsKt.isBlank(url));
    }

    private final Entity getEntityAtIndex(int i) {
        if (i < this.$pageEntities.size()) {
            Object obj = this.$pageEntities.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "pageEntities[index]");
            return (Entity) obj;
        }
        Object obj2 = this.$newActivityEntity.get(i - this.$pageEntities.size());
        Intrinsics.checkNotNullExpressionValue(obj2, "newActivityEntity[index - pageEntities.size]");
        return (Entity) obj2;
    }
}
