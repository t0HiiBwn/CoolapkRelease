package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
final class EntityListPresenter$followUser$followUserSub$1 implements Action0 {
    final /* synthetic */ String $uid;
    final /* synthetic */ EntityListPresenter this$0;

    EntityListPresenter$followUser$followUserSub$1(EntityListPresenter entityListPresenter, String str) {
        this.this$0 = entityListPresenter;
        this.$uid = str;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.getView().onFollowUserStart(this.$uid);
    }
}
