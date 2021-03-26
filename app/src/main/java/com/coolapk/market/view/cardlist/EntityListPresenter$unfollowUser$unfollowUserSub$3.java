package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListPresenter.kt */
final class EntityListPresenter$unfollowUser$unfollowUserSub$3<T> implements Action1<Integer> {
    final /* synthetic */ String $uid;
    final /* synthetic */ EntityListPresenter this$0;

    EntityListPresenter$unfollowUser$unfollowUserSub$3(EntityListPresenter entityListPresenter, String str) {
        this.this$0 = entityListPresenter;
        this.$uid = str;
    }

    public final void call(Integer num) {
        this.this$0.unfollowUserAction.remove(this.$uid);
        this.this$0.getView().onUnfollowUserComplete(this.$uid, num, null);
    }
}
