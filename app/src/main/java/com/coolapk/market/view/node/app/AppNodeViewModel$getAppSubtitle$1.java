package com.coolapk.market.view.node.app;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.KotlinExtendKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewModel.kt */
final class AppNodeViewModel$getAppSubtitle$1 extends Lambda implements Function1<ServiceApp, String> {
    public static final AppNodeViewModel$getAppSubtitle$1 INSTANCE = new AppNodeViewModel$getAppSubtitle$1();

    AppNodeViewModel$getAppSubtitle$1() {
        super(1);
    }

    public final String invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            return KotlinExtendKt.toDisplayString(serviceApp.getHotNum()) + "热度  " + serviceApp.getCommentCount() + "讨论";
        } else if (serviceApp.getIsDownloadApp() == 1 || serviceApp.getIsForumApp() != 1) {
            return serviceApp.getDisplayVersionName() + "  " + serviceApp.getDownCount() + "下载  " + KotlinExtendKt.toDisplayString(serviceApp.getHotNum()) + "热度";
        } else {
            return serviceApp.getDisplayVersionName() + "  " + KotlinExtendKt.toDisplayString(serviceApp.getHotNum()) + "热度";
        }
    }
}
