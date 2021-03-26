package com.coolapk.market.view.userv9;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Presenter$requestChangeFollowState$4", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
public final class UserSpaceV9Presenter$requestChangeFollowState$4 extends EmptySubscriber<Integer> {
    final /* synthetic */ boolean $newState;
    final /* synthetic */ UserSpaceV9Presenter this$0;

    UserSpaceV9Presenter$requestChangeFollowState$4(UserSpaceV9Presenter userSpaceV9Presenter, boolean z) {
        this.this$0 = userSpaceV9Presenter;
        this.$newState = z;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(this.this$0.getContext(), th);
        this.this$0.getViewModel().setFollow(!this.$newState);
    }
}
