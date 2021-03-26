package com.coolapk.market.view.cardlist;

import com.coolapk.market.widget.hotplug.ViewPartPool;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$viewPartPool$2 extends Lambda implements Function0<ViewPartPool> {
    public static final EntityListFragment$viewPartPool$2 INSTANCE = new EntityListFragment$viewPartPool$2();

    EntityListFragment$viewPartPool$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewPartPool invoke() {
        ViewPartPool viewPartPool = new ViewPartPool();
        viewPartPool.setMaxRecycledViews(2131558707, 15);
        viewPartPool.setMaxRecycledViews(2131558661, 15);
        viewPartPool.setMaxRecycledViews(2131558896, 9);
        return viewPartPool;
    }
}
