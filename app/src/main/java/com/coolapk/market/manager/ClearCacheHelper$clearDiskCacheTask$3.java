package com.coolapk.market.manager;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ClearCacheHelper.kt */
final class ClearCacheHelper$clearDiskCacheTask$3 implements Action0 {
    public static final ClearCacheHelper$clearDiskCacheTask$3 INSTANCE = new ClearCacheHelper$clearDiskCacheTask$3();

    ClearCacheHelper$clearDiskCacheTask$3() {
    }

    @Override // rx.functions.Action0
    public final void call() {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Toast.show(application, 2131886492);
    }
}
