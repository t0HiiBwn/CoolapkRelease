package com.coolapk.market.view.cardlist;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListContract;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "isRefresh", "", "page", "", "createRequest", "com/coolapk/market/view/cardlist/EntityRequestArgHelper$internalSetExtraRequestProvider$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityRequestArgHelper.kt */
final class EntityRequestArgHelper$internalSetExtraRequestProvider$$inlined$apply$lambda$1<T> implements NewAsyncListContract.RequestProvider<List<? extends Entity>> {
    final /* synthetic */ Entity $entity$inlined;
    final /* synthetic */ EntityListFragment $this_apply;

    EntityRequestArgHelper$internalSetExtraRequestProvider$$inlined$apply$lambda$1(EntityListFragment entityListFragment, Entity entity) {
        this.$this_apply = entityListFragment;
        this.$entity$inlined = entity;
    }

    /* Return type fixed from 'rx.Observable<java.util.List<com.coolapk.market.model.Entity>>' to match base method */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.RequestProvider
    public final Observable<List<? extends Entity>> createRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String url = this.$entity$inlined.getUrl();
        String title = this.$entity$inlined.getTitle();
        String subTitle = this.$entity$inlined.getSubTitle();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this.$this_apply, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId2 = (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this.$this_apply, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this.$this_apply, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str = EntityExtendsKt.getPageContext(findLastEntity$default2);
        }
        return instance.getDataList(url, title, subTitle, i, entityId, entityId2, str).map(RxUtils.checkResultToData());
    }
}
