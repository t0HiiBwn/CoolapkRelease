package com.coolapk.market.view.node.app;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewModel.kt */
final class AppNodeViewModel$getDeveloperName$1 extends Lambda implements Function1<ServiceApp, String> {
    public static final AppNodeViewModel$getDeveloperName$1 INSTANCE = new AppNodeViewModel$getDeveloperName$1();

    AppNodeViewModel$getDeveloperName$1() {
        super(1);
    }

    public final String invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        String str = null;
        User developerProfile = serviceApp.getDeveloperProfile();
        if (developerProfile == null) {
            return str;
        }
        if (Intrinsics.areEqual("3", developerProfile.getType())) {
            return developerProfile.getTitle();
        }
        return developerProfile.getUserName();
    }
}
