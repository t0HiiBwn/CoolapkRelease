package com.coolapk.market.view.cardlist;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFixTopHelper.kt */
final class EntityListFixTopHelper$checkFixTopStatus$1 implements Runnable {
    final /* synthetic */ EntityListFixTopHelper this$0;

    EntityListFixTopHelper$checkFixTopStatus$1(EntityListFixTopHelper entityListFixTopHelper) {
        this.this$0 = entityListFixTopHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityListFixTopHelper.access$getTopViewContainer$p(this.this$0).requestLayout();
    }
}
