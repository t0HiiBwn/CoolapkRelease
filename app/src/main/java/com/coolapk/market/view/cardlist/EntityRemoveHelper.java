package com.coolapk.market.view.cardlist;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityRemoveHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityRemoveHelper.kt */
public final class EntityRemoveHelper extends EntityDataFilter {
    private final EntityListFragment fragment;

    public EntityRemoveHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Entity entity : list) {
            String stringExtraData = EntityExtendsKt.getStringExtraData(entity, "removeEntityById", "");
            if (!(!Intrinsics.areEqual(stringExtraData, ""))) {
                stringExtraData = null;
            }
            if (stringExtraData != null) {
                arrayList.add(stringExtraData);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            CollectionsKt.removeAll((List) this.fragment.getDataList(), (Function1) new EntityRemoveHelper$modifyData$1(arrayList2));
        }
        return list;
    }
}
