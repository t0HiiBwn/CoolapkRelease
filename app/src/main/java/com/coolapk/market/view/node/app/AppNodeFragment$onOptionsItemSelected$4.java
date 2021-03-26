package com.coolapk.market.view.node.app;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onOptionsItemSelected$4 extends Lambda implements Function1<ServiceApp, Boolean> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onOptionsItemSelected$4(AppNodeFragment appNodeFragment) {
        super(1);
        this.this$0 = appNodeFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ServiceApp serviceApp) {
        return Boolean.valueOf(invoke(serviceApp));
    }

    public final boolean invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        return ActionManager.openApp(this.this$0.getActivity(), serviceApp.getPackageName());
    }
}
