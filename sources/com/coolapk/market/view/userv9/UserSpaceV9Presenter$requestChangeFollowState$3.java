package com.coolapk.market.view.userv9;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
final class UserSpaceV9Presenter$requestChangeFollowState$3 implements Action0 {
    final /* synthetic */ UserSpaceV9Presenter this$0;

    UserSpaceV9Presenter$requestChangeFollowState$3(UserSpaceV9Presenter userSpaceV9Presenter) {
        this.this$0 = userSpaceV9Presenter;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.isRequesting = false;
    }
}
