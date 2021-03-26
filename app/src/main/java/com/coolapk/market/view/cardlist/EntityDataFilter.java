package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import com.coolapk.market.model.Entity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "", "()V", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "removeData", "item", "removeData$presentation_coolapkAppRelease", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityDataFilter.kt */
public abstract class EntityDataFilter {
    public abstract List<Entity> modifyData(List<? extends Entity> list, boolean z);

    public void onActivityCreated(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<Entity> removeData$presentation_coolapkAppRelease(List<? extends Entity> list, Entity entity) {
        Intrinsics.checkNotNullParameter(list, "$this$removeData");
        Intrinsics.checkNotNullParameter(entity, "item");
        if (list instanceof ArrayList) {
            ((ArrayList) list).remove(entity);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Entity) obj) != entity) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
