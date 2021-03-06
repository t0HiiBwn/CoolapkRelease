package com.coolapk.market.view.app;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.AppViewContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$doFollowFunction$1", "Lrx/Subscriber;", "", "onCompleted", "", "onError", "e", "", "onNext", "isLogin", "(Ljava/lang/Boolean;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$doFollowFunction$1 extends Subscriber<Boolean> {
    final /* synthetic */ AppViewV8Activity this$0;

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewV8Activity$doFollowFunction$1(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    public void onNext(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            boolean isFollow = AppViewV8Activity.access$getViewModel$p(this.this$0).isFollow();
            boolean z = !AppViewV8Activity.access$getViewModel$p(this.this$0).isFollow();
            AppViewContract.Presenter presenter = this.this$0.presenter;
            ServiceApp serviceApp = this.this$0.getServiceApp();
            Intrinsics.checkNotNull(serviceApp);
            presenter.followApp(serviceApp.getApkId(), isFollow, z);
            AppViewV8Activity.access$getViewModel$p(this.this$0).setFollowApp(z);
        }
    }
}
