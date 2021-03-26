package com.coolapk.market.view.cardlist;

import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityRefreshCardHelper.kt */
final class EntityRefreshCardHelper$setDismissCallback$dismissAction$1 implements Runnable {
    final /* synthetic */ List $dataList;
    final /* synthetic */ Entity $entity;
    final /* synthetic */ EntityRefreshCardHelper this$0;

    EntityRefreshCardHelper$setDismissCallback$dismissAction$1(EntityRefreshCardHelper entityRefreshCardHelper, List list, Entity entity) {
        this.this$0 = entityRefreshCardHelper;
        this.$dataList = list;
        this.$entity = entity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int indexOf = this.$dataList.indexOf(this.$entity);
        if (indexOf >= 0) {
            this.$dataList.remove(indexOf);
            if (indexOf > 0) {
                List list = this.$dataList;
                int i = indexOf - 1;
                list.set(i, list.get(i));
            }
        }
        this.this$0.removeDismissCallback(this.$entity);
    }
}
