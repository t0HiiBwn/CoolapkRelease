package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityVideoHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "tempDetachAutoPlay", "", "getTempDetachAutoPlay", "()Z", "setTempDetachAutoPlay", "(Z)V", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityVideoHelper.kt */
public final class EntityVideoHelper extends EntityDataFilter {
    private final EntityListFragment fragment;
    private boolean tempDetachAutoPlay;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        return list;
    }

    public EntityVideoHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    public final boolean getTempDetachAutoPlay() {
        return this.tempDetachAutoPlay;
    }

    public final void setTempDetachAutoPlay(boolean z) {
        this.tempDetachAutoPlay = z;
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fragment.getRecyclerView().addOnScrollListener(new EntityVideoHelper$onActivityCreated$1(this));
    }
}
