package com.coolapk.market.view.node.app;

import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.DownloadExtendDialog;
import com.coolapk.market.view.app.VersionLowerAlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onOptionsItemSelected$6 extends Lambda implements Function1<ServiceApp, Object> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onOptionsItemSelected$6(AppNodeFragment appNodeFragment) {
        super(1);
        this.this$0 = appNodeFragment;
    }

    public final Object invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        if (!TextUtils.isEmpty(serviceApp.getExtendFile())) {
            DownloadExtendDialog newInstance = DownloadExtendDialog.newInstance(serviceApp, true);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            return Unit.INSTANCE;
        } else if (serviceApp.getSupportAndroidVersion() <= Build.VERSION.SDK_INT) {
            return Boolean.valueOf(ActionManager.startDownload(this.this$0.getActivity(), serviceApp, 0, 1));
        } else {
            VersionLowerAlertDialog newInstance2 = VersionLowerAlertDialog.newInstance(serviceApp, 0, 1);
            FragmentManager childFragmentManager2 = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            newInstance2.show(childFragmentManager2, (String) null);
            return Unit.INSTANCE;
        }
    }
}
