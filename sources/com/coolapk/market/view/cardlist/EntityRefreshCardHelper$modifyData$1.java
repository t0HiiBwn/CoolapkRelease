package com.coolapk.market.view.cardlist;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityRefreshCardHelper.kt */
final class EntityRefreshCardHelper$modifyData$1 implements Runnable {
    final /* synthetic */ Entity $data;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ EntityRefreshCardHelper this$0;

    EntityRefreshCardHelper$modifyData$1(EntityRefreshCardHelper entityRefreshCardHelper, Entity entity, boolean z) {
        this.this$0 = entityRefreshCardHelper;
        this.$data = entity;
        this.$isRefresh = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.removeToastAction();
        this.this$0.setupToastAction(this.$data, this.$isRefresh);
    }
}
