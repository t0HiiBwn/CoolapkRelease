package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
final class EntityListPresenter$followUser$followUserSub$4<T> implements Action1<Throwable> {
    final /* synthetic */ String $uid;
    final /* synthetic */ EntityListPresenter this$0;

    EntityListPresenter$followUser$followUserSub$4(EntityListPresenter entityListPresenter, String str) {
        this.this$0 = entityListPresenter;
        this.$uid = str;
    }

    public final void call(Throwable th) {
        this.this$0.followUserAction.remove(this.$uid);
        this.this$0.getView().onFollowUserComplete(this.$uid, null, th);
    }
}
