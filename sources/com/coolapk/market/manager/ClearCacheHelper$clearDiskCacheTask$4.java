package com.coolapk.market.manager;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/manager/ClearCacheHelper$clearDiskCacheTask$4", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onCompleted", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ClearCacheHelper.kt */
public final class ClearCacheHelper$clearDiskCacheTask$4 extends EmptySubscriber<Object> {
    ClearCacheHelper$clearDiskCacheTask$4() {
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onCompleted() {
        super.onCompleted();
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Toast.show(application, 2131886551);
    }
}
