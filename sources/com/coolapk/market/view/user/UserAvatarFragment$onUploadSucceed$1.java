package com.coolapk.market.view.user;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/user/UserAvatarFragment$onUploadSucceed$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onCompleted", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserAvatarFragment.kt */
public final class UserAvatarFragment$onUploadSucceed$1 extends EmptySubscriber<Object> {
    final /* synthetic */ String $avatar;
    final /* synthetic */ UserAvatarFragment this$0;

    UserAvatarFragment$onUploadSucceed$1(UserAvatarFragment userAvatarFragment, String str) {
        this.this$0 = userAvatarFragment;
        this.$avatar = str;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onCompleted() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        loginSession.setUserAvatar(this.$avatar);
        EventBus.getDefault().post(loginSession);
        if (this.this$0.getActivity() != null) {
            this.this$0.requireActivity().finish();
        }
    }
}
