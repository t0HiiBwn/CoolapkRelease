package com.coolapk.market.manager;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/manager/AppNotification$handleCloudInstallMessage$4", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/ServiceApp;", "onError", "", "e", "", "onNext", "serviceAppResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
public final class AppNotification$handleCloudInstallMessage$4 extends EmptySubscriber<Result<ServiceApp>> {
    AppNotification$handleCloudInstallMessage$4() {
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(AppHolder.getApplication(), th);
    }

    public void onNext(Result<ServiceApp> result) {
        Intrinsics.checkNotNullParameter(result, "serviceAppResult");
        if (result.getData() != null) {
            ActionManager.startDownload(AppHolder.getApplication(), result.getData(), 0);
        }
    }
}
