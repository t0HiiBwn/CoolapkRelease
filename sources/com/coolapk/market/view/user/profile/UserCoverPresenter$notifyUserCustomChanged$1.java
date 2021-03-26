package com.coolapk.market.view.user.profile;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverPresenter.kt */
final class UserCoverPresenter$notifyUserCustomChanged$1 implements Runnable {
    final /* synthetic */ String $url;
    final /* synthetic */ UserCoverPresenter this$0;

    UserCoverPresenter$notifyUserCustomChanged$1(UserCoverPresenter userCoverPresenter, String str) {
        this.this$0 = userCoverPresenter;
        this.$url = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.requestChangeUserAvatarCover(this.$url);
    }
}
