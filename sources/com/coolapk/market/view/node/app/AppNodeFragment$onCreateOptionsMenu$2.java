package com.coolapk.market.view.node.app;

import android.view.Menu;
import android.view.MenuItem;
import com.coolapk.market.model.ServiceApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/node/app/AppNodeFragment;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onCreateOptionsMenu$2 extends Lambda implements Function1<AppNodeFragment, Unit> {
    final /* synthetic */ Menu $menu;
    final /* synthetic */ ServiceApp $serviceApp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onCreateOptionsMenu$2(ServiceApp serviceApp, Menu menu) {
        super(1);
        this.$serviceApp = serviceApp;
        this.$menu = menu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppNodeFragment appNodeFragment) {
        invoke(appNodeFragment);
        return Unit.INSTANCE;
    }

    public final void invoke(AppNodeFragment appNodeFragment) {
        Intrinsics.checkNotNullParameter(appNodeFragment, "it");
        MenuItem findItem = this.$menu.findItem(2131361854);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_add_album)");
        ServiceApp serviceApp = this.$serviceApp;
        boolean z = false;
        findItem.setVisible(serviceApp != null && serviceApp.getIsDownloadApp() == 1);
        MenuItem findItem2 = this.$menu.findItem(2131361912);
        Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.action_history)");
        ServiceApp serviceApp2 = this.$serviceApp;
        findItem2.setVisible(serviceApp2 != null && serviceApp2.getIsDownloadApp() == 1);
        MenuItem findItem3 = this.$menu.findItem(2131361900);
        Intrinsics.checkNotNullExpressionValue(findItem3, "menu.findItem(R.id.action_download_again)");
        ServiceApp serviceApp3 = this.$serviceApp;
        if (serviceApp3 != null && serviceApp3.getIsDownloadApp() == 1) {
            z = true;
        }
        findItem3.setVisible(z);
    }
}
