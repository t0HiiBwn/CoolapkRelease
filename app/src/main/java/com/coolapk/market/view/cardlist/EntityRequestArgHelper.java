package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "internalRequestArg", "Lcom/coolapk/market/model/Entity;", "isCreated", "", "value", "requestArg", "getRequestArg", "()Lcom/coolapk/market/model/Entity;", "setRequestArg", "(Lcom/coolapk/market/model/Entity;)V", "internalSetExtraRequestProvider", "", "entity", "internalSetFragmentRequestArg", "modifyData", "", "list", "isRefresh", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityRequestArgHelper.kt */
public final class EntityRequestArgHelper extends EntityDataFilter {
    private final EntityListFragment fragment;
    private Entity internalRequestArg;
    private boolean isCreated;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        return list;
    }

    public EntityRequestArgHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final Entity getRequestArg() {
        return this.internalRequestArg;
    }

    public final void setRequestArg(Entity entity) {
        this.internalRequestArg = entity;
        internalSetFragmentRequestArg(entity);
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.isCreated = true;
        Entity entity = this.internalRequestArg;
        if (entity != null) {
            Intrinsics.checkNotNull(entity);
            internalSetExtraRequestProvider(entity);
        } else if (bundle != null) {
            Entity entity2 = (Entity) bundle.getParcelable("requestArg");
            this.internalRequestArg = entity2;
            if (entity2 != null) {
                Intrinsics.checkNotNull(entity2);
                internalSetExtraRequestProvider(entity2);
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Entity entity = this.internalRequestArg;
        if (entity != null) {
            String url = entity.getUrl();
            if (!(url == null || url.length() == 0)) {
                bundle.putParcelable("requestArg", this.internalRequestArg);
            }
        }
    }

    private final void internalSetFragmentRequestArg(Entity entity) {
        int i;
        boolean z;
        Integer entityFixed;
        if (this.isCreated && !this.fragment.onExtraRequestArgsAssembled$presentation_coolapkAppRelease(entity)) {
            EntityListFragment entityListFragment = this.fragment;
            List<Parcelable> dataList = entityListFragment.getDataList();
            if (entity != null) {
                String url = entity.getUrl();
                if (!(url == null || url.length() == 0)) {
                    ListIterator<Parcelable> listIterator = dataList.listIterator(dataList.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            i = -1;
                            break;
                        }
                        Parcelable previous = listIterator.previous();
                        if (!(previous instanceof Entity) || (entityFixed = ((Entity) previous).getEntityFixed()) == null || entityFixed.intValue() != 1) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            i = listIterator.nextIndex();
                            break;
                        }
                    }
                    dataList.subList(i + 1, dataList.size()).clear();
                    internalSetExtraRequestProvider(entity);
                    if (entityListFragment.isVisible()) {
                        entityListFragment.addRefreshView();
                        entityListFragment.setPage(1);
                        entityListFragment.reloadData();
                        return;
                    }
                    return;
                }
            }
            entityListFragment.setExtraRequestProvider(null);
        }
    }

    private final void internalSetExtraRequestProvider(Entity entity) {
        EntityListFragment entityListFragment = this.fragment;
        entityListFragment.setUrlParams("url=" + entity.getUrl() + "&title=" + entity.getTitle() + "&subTitle=" + entity.getSubTitle());
        entityListFragment.setExtraRequestProvider(new EntityRequestArgHelper$internalSetExtraRequestProvider$$inlined$apply$lambda$1(entityListFragment, entity));
    }
}
