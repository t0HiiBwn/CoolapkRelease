package com.coolapk.market.view.collectionList;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002 \u0004*.\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionDetailFragment.kt */
final class CollectionDetailFragment$onCreateRequest$loadCollrctionItemList$1<R> implements Func0<Observable<List<Entity>>> {
    final /* synthetic */ int $page;
    final /* synthetic */ CollectionDetailFragment this$0;

    CollectionDetailFragment$onCreateRequest$loadCollrctionItemList$1(CollectionDetailFragment collectionDetailFragment, int i) {
        this.this$0 = collectionDetailFragment;
        this.$page = i;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<List<Entity>> call() {
        DataManager instance = DataManager.getInstance();
        String access$getColId$p = CollectionDetailFragment.access$getColId$p(this.this$0);
        int i = this.$page;
        String str = null;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this.this$0, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this.this$0, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getEntityId();
        }
        return instance.getCollectionItemList(access$getColId$p, i, entityId, str).compose(RxUtils.apiCommonToData());
    }
}
