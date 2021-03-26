package com.coolapk.market.view.main;

import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.widget.view.TabLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/main/DataListViewPagerConverter$convertToViewPageMode$2", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
public final class DataListViewPagerConverter$convertToViewPageMode$2 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ DataListViewPagerConverter$convertToViewPageMode$callback$1 $callback;
    final /* synthetic */ EntityCard $card;
    final /* synthetic */ List $newActivityEntity;
    final /* synthetic */ List $pageEntities;
    final /* synthetic */ DataListViewPagerConverter this$0;

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    DataListViewPagerConverter$convertToViewPageMode$2(DataListViewPagerConverter dataListViewPagerConverter, DataListViewPagerConverter$convertToViewPageMode$callback$1 dataListViewPagerConverter$convertToViewPageMode$callback$1, List list, EntityCard entityCard, List list2) {
        this.this$0 = dataListViewPagerConverter;
        this.$callback = dataListViewPagerConverter$convertToViewPageMode$callback$1;
        this.$pageEntities = list;
        this.$card = entityCard;
        this.$newActivityEntity = list2;
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        StatisticHelper.Companion.getInstance().recordDataListTabEvent(String.valueOf(tab.getText()));
        if (tab.getPosition() < this.$callback.getPageCount()) {
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            String str = this.this$0.fixedRecordId;
            Object obj = this.$pageEntities.get(tab.getPosition());
            Intrinsics.checkNotNullExpressionValue(obj, "pageEntities[tab.position]");
            instance.recordEntityEvent(str, (Entity) obj, this.this$0.getFragment().getDataList().size(), this.$card, "Tab");
            return;
        }
        Entity entity = (Entity) this.$newActivityEntity.get(tab.getPosition() - this.$pageEntities.size());
        StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
        String str2 = this.this$0.fixedRecordId;
        Intrinsics.checkNotNullExpressionValue(entity, "item");
        instance2.recordEntityEvent(str2, entity, this.this$0.getFragment().getDataList().size(), this.$card, "Page");
    }
}
