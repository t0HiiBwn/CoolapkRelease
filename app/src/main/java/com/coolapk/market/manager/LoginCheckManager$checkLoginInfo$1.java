package com.coolapk.market.manager;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.network.ClientException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/manager/LoginCheckManager$checkLoginInfo$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/LoginInfo;", "onError", "", "e", "", "onNext", "info", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginCheckManager.kt */
public final class LoginCheckManager$checkLoginInfo$1 extends EmptySubscriber<LoginInfo> {
    final /* synthetic */ boolean $isCoolBoot;

    LoginCheckManager$checkLoginInfo$1(boolean z) {
        this.$isCoolBoot = z;
    }

    public void onNext(LoginInfo loginInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "info");
        LoginCheckManager loginCheckManager = LoginCheckManager.INSTANCE;
        LoginCheckManager.isChecking = false;
        LoginCheckManager.INSTANCE.onLoginInfoLoaded(loginInfo, this.$isCoolBoot);
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        LoginCheckManager loginCheckManager = LoginCheckManager.INSTANCE;
        LoginCheckManager.isChecking = false;
        if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
            LoginCheckManager loginCheckManager2 = LoginCheckManager.INSTANCE;
            Throwable cause = th.getCause();
            String message = cause != null ? cause.getMessage() : null;
            if (message == null) {
                message = "";
            }
            loginCheckManager2.onSessionCheckError(message);
        }
    }
}
