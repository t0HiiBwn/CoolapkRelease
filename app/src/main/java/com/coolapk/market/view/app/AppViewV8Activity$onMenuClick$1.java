package com.coolapk.market.view.app;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.User;
import com.coolapk.market.view.app.AppViewContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$onMenuClick$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "isLogin", "(Ljava/lang/Boolean;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$onMenuClick$1 extends EmptySubscriber<Boolean> {
    final /* synthetic */ AppViewV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewV8Activity$onMenuClick$1(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    public void onNext(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            boolean isFollowDeveloper = AppViewV8Activity.access$getViewModel$p(this.this$0).isFollowDeveloper();
            boolean z = !AppViewV8Activity.access$getViewModel$p(this.this$0).isFollowDeveloper();
            AppViewContract.Presenter presenter = this.this$0.presenter;
            ServiceApp serviceApp = this.this$0.getServiceApp();
            Intrinsics.checkNotNull(serviceApp);
            User developerProfile = serviceApp.getDeveloperProfile();
            Intrinsics.checkNotNull(developerProfile);
            Intrinsics.checkNotNullExpressionValue(developerProfile, "getServiceApp()!!.developerProfile!!");
            presenter.followUser(developerProfile.getUid(), isFollowDeveloper, z);
            AppViewV8Activity.access$getViewModel$p(this.this$0).setFollowDeveloper(z);
        }
    }
}
