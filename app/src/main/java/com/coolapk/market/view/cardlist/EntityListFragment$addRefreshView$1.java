package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$addRefreshView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$addRefreshView$1(EntityListFragment entityListFragment) {
        super(0);
        this.this$0 = entityListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (!this.this$0.isRefreshing() && !this.this$0.isLoadingMore()) {
            if (this.this$0.getPage() == 1) {
                this.this$0.reloadData();
            } else {
                this.this$0.loadMore();
            }
            this.this$0.addRefreshView();
        }
    }
}
