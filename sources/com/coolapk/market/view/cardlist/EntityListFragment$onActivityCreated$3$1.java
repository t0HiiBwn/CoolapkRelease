package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onActivityCreated$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Subscription $disposal;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$onActivityCreated$3$1(Subscription subscription) {
        super(0);
        this.$disposal = subscription;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$disposal.unsubscribe();
    }
}
