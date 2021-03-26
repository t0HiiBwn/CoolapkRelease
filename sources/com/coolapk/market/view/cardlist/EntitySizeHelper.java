package com.coolapk.market.view.cardlist;

import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntitySizeHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntitySizeHelper.kt */
public final class EntitySizeHelper extends EntityDataFilter {
    private final EntityListFragment fragment;

    public EntitySizeHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<Parcelable> dataList = this.fragment.getDataList();
        if (dataList.size() <= 1 || this.fragment.getConfigHelper().getMaxSize() == -1) {
            return list;
        }
        int maxSize = this.fragment.getConfigHelper().getMaxSize();
        if (dataList.size() >= maxSize) {
            return CollectionsKt.emptyList();
        }
        int size = (dataList.size() + list.size()) - maxSize;
        if (size <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list.subList(0, list.size() - size));
        return arrayList;
    }
}
