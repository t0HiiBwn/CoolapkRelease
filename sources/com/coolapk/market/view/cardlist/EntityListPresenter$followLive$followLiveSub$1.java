package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
final class EntityListPresenter$followLive$followLiveSub$1 implements Action0 {
    final /* synthetic */ boolean $isFollow;
    final /* synthetic */ String $liveId;
    final /* synthetic */ EntityListPresenter this$0;

    EntityListPresenter$followLive$followLiveSub$1(EntityListPresenter entityListPresenter, String str, boolean z) {
        this.this$0 = entityListPresenter;
        this.$liveId = str;
        this.$isFollow = z;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.getView().onLiveFollowStart(this.$liveId, this.$isFollow);
    }
}
