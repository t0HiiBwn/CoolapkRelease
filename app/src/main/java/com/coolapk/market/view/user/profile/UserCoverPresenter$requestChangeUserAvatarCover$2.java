package com.coolapk.market.view.user.profile;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/user/profile/UserCoverPresenter$requestChangeUserAvatarCover$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserCoverPresenter.kt */
public final class UserCoverPresenter$requestChangeUserAvatarCover$2 extends EmptySubscriber<String> {
    final /* synthetic */ String $url;
    final /* synthetic */ UserCoverPresenter this$0;

    UserCoverPresenter$requestChangeUserAvatarCover$2(UserCoverPresenter userCoverPresenter, String str) {
        this.this$0 = userCoverPresenter;
        this.$url = str;
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "t");
        super.onNext((UserCoverPresenter$requestChangeUserAvatarCover$2) str);
        Toast.show$default(this.this$0.activity, "更换成功", 0, false, 12, null);
        this.this$0.notifyUserCoverChanged(this.$url);
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.activity, th);
    }
}
