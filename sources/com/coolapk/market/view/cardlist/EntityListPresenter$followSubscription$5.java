package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
final class EntityListPresenter$followSubscription$5<T> implements Action1<Throwable> {
    final /* synthetic */ int $followNum;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $isFollow;
    final /* synthetic */ EntityListPresenter this$0;

    EntityListPresenter$followSubscription$5(EntityListPresenter entityListPresenter, String str, boolean z, int i) {
        this.this$0 = entityListPresenter;
        this.$id = str;
        this.$isFollow = z;
        this.$followNum = i;
    }

    public final void call(Throwable th) {
        this.this$0.followDyhRunningId = null;
        this.this$0.getView().onFollowSubscriptionComplete(this.$id, this.$isFollow, String.valueOf(this.$followNum), th);
    }
}
