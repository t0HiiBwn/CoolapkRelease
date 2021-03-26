package com.coolapk.market.view.node.app;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewModel.kt */
final class AppNodeViewModel$getChangeLogSubtitle$1 extends Lambda implements Function1<ServiceApp, String> {
    final /* synthetic */ AppNodeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeViewModel$getChangeLogSubtitle$1(AppNodeViewModel appNodeViewModel) {
        super(1);
        this.this$0 = appNodeViewModel;
    }

    public final String invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        return "版本：" + serviceApp.getDisplayVersionName() + "    大小：" + serviceApp.getApkSizeFormat() + "    更新时间：" + DateUtils.getTimeDescription(this.this$0.appContext, serviceApp.getLastUpdate());
    }
}
