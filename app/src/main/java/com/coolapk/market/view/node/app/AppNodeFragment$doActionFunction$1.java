package com.coolapk.market.view.node.app;

import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.State;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.view.app.DownloadExtendDialog;
import com.coolapk.market.view.app.VersionLowerAlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$doActionFunction$1 extends Lambda implements Function1<ServiceApp, Unit> {
    final /* synthetic */ ClickInfo.ClickHandleListener $clickListener;
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$doActionFunction$1(AppNodeFragment appNodeFragment, ClickInfo.ClickHandleListener clickHandleListener) {
        super(1);
        this.this$0 = appNodeFragment;
        this.$clickListener = clickHandleListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServiceApp serviceApp) {
        invoke(serviceApp);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0039: APUT  (r4v0 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r7v1 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c2: APUT  (r3v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r11v2 java.lang.String) */
    public final void invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        String str = null;
        UpgradeInfo upgradeInfo = null;
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
        if (mobileAppExistFast != null) {
            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
        }
        String packageName = serviceApp.getPackageName();
        String[] strArr = new String[4];
        strArr[0] = serviceApp.getDownloadUrlMd5(0);
        strArr[1] = serviceApp.getDownloadUrlMd5(2);
        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
        State findLatestState = StateUtils.findLatestState(packageName, strArr);
        if (findLatestState == null || ((findLatestState instanceof DownloadState) && ((DownloadState) findLatestState).getState() == 0)) {
            if (!TextUtils.isEmpty(serviceApp.getExtendFile())) {
                DownloadExtendDialog newInstance = DownloadExtendDialog.newInstance(serviceApp, false);
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
                return;
            } else if (serviceApp.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                VersionLowerAlertDialog newInstance2 = VersionLowerAlertDialog.newInstance(serviceApp, 0, 0);
                FragmentManager childFragmentManager2 = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                newInstance2.show(childFragmentManager2, (String) null);
                return;
            }
        }
        ClickInfo.Builder uninstallKey = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0)).uninstallKey(serviceApp.getPackageName());
        String[] strArr2 = new String[4];
        strArr2[0] = serviceApp.getDownloadUrlMd5(0);
        strArr2[1] = serviceApp.getDownloadUrlMd5(2);
        strArr2[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        if (upgradeInfo != null) {
            str = upgradeInfo.getDownloadUrlMd5(1);
        }
        strArr2[3] = str;
        ClickInfo.Builder downloadKeys = uninstallKey.downloadKeys(strArr2);
        ClickInfo.ClickHandleListener clickHandleListener = this.$clickListener;
        if (clickHandleListener != null) {
            downloadKeys.clickHandleListener(clickHandleListener);
        }
        StateUtils.handleClick(this.this$0.getActivity(), downloadKeys.build(), this.this$0.getView());
    }
}
