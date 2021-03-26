package com.coolapk.market.service.action;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/service/action/UpdateAppStatusAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "getTaskKey", "", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "onHandleAction", "", "context", "Landroid/content/Context;", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpdateAppStatusAction.kt */
public final class UpdateAppStatusAction implements ServiceAction {
    public static final String ACTION_UPDATE_MOBILE_APP_STATUS = "ACTION_UPDATE_MOBILE_APP_STATUS";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/service/action/UpdateAppStatusAction$Companion;", "", "()V", "ACTION_UPDATE_MOBILE_APP_STATUS", "", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UpdateAppStatusAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.service.ServiceAction
    public boolean isThisAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        return Intrinsics.areEqual(str, "ACTION_UPDATE_MOBILE_APP_STATUS");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return "ACTION_UPDATE_MOBILE_APP_STATUS:" + intent.getStringExtra("PACKAGE_NAME");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        boolean z;
        MobileApp.Builder builder;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(stringExtra, 8192);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo != null) {
                LocalApk app = LocalApkUtils.getApp(context.getPackageManager(), packageInfo, !AppHolder.getAppSetting().getBooleanPref("show_hide_apps"));
                if (app != null) {
                    MobileApp mobileApp = DataManager.getInstance().getMobileApp(stringExtra);
                    if (mobileApp != null) {
                        builder = MobileApp.newBuilder(mobileApp);
                        Intrinsics.checkNotNullExpressionValue(builder, "MobileApp.newBuilder(app)");
                        if (mobileApp.getLastUpdateTime() == app.getLastUpdateTime() && !TextUtils.isEmpty(mobileApp.getApkMd5()) && mobileApp.getVersionCode() == app.getVersionCode()) {
                            z = false;
                            if (z) {
                                String fileMd5 = CoolFileUtils.getFileMd5(app.getFilePath());
                                LogUtils.d("Get %s's MD5: %s", app.getAppName(), fileMd5);
                                builder.apkMd5(fileMd5);
                            }
                            builder.packageName(app.getPackageName());
                            builder.appName(app.getAppName());
                            builder.versionName(app.getVersionName());
                            builder.versionCode(app.getVersionCode());
                            builder.apkLength(app.getApkLength());
                            builder.systemApp(app.isSystemApp());
                            builder.exist(true);
                            builder.apkPath(app.getFilePath());
                            builder.firstInstallTime(app.getFirstInstallTime());
                            builder.lastUpdateTime(app.getLastUpdateTime());
                            builder.modified(System.currentTimeMillis());
                            LogUtils.v("Save %s's data", app.getAppName());
                            DataManager.getInstance().saveMobileApp(builder.build());
                            return;
                        }
                    } else {
                        builder = MobileApp.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builder, "MobileApp.newBuilder()");
                        builder.dbId(0);
                        builder.created(0);
                    }
                    z = true;
                    if (z) {
                    }
                    builder.packageName(app.getPackageName());
                    builder.appName(app.getAppName());
                    builder.versionName(app.getVersionName());
                    builder.versionCode(app.getVersionCode());
                    builder.apkLength(app.getApkLength());
                    builder.systemApp(app.isSystemApp());
                    builder.exist(true);
                    builder.apkPath(app.getFilePath());
                    builder.firstInstallTime(app.getFirstInstallTime());
                    builder.lastUpdateTime(app.getLastUpdateTime());
                    builder.modified(System.currentTimeMillis());
                    LogUtils.v("Save %s's data", app.getAppName());
                    DataManager.getInstance().saveMobileApp(builder.build());
                    return;
                }
                return;
            }
            LogUtils.v("Delete %s's data", stringExtra);
            DataManager.getInstance().deleteMobileApp(stringExtra);
        }
    }
}
