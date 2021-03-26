package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.MobileApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "mobileApp", "Lcom/coolapk/market/model/MobileApp;", "call", "(Lcom/coolapk/market/model/MobileApp;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppPresenter.kt */
final class MobileAppPresenter$onCreateRequest$3<T, R> implements Func1<MobileApp, Boolean> {
    final /* synthetic */ MobileAppPresenter this$0;

    MobileAppPresenter$onCreateRequest$3(MobileAppPresenter mobileAppPresenter) {
        this.this$0 = mobileAppPresenter;
    }

    public final Boolean call(MobileApp mobileApp) {
        Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
        return Boolean.valueOf(!mobileApp.isSystemApp() || this.this$0.isShowSystem());
    }
}
