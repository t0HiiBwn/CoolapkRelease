package com.coolapk.market.service.action;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.event.AppCheckForUpgradeEvent;
import com.coolapk.market.event.CheckForUpgradeEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.appmanager.UpgradeManagerActivity;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/service/action/CheckForUpgradeAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "checkForAll", "", "checkForUpdate", "packageName", "", "getTaskKey", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "notifyUpgrade", "context", "Landroid/content/Context;", "onHandleAction", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CheckForUpgradeAction.kt */
public final class CheckForUpgradeAction implements ServiceAction {
    public static final String ACTION_CHECK_FOR_UPGRADE = "ACTION_CHECK_FOR_UPGRADE";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_NOTIFY = "NOTIFY";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/service/action/CheckForUpgradeAction$Companion;", "", "()V", "ACTION_CHECK_FOR_UPGRADE", "", "KEY_NOTIFY", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CheckForUpgradeAction.kt */
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
        return Intrinsics.areEqual("ACTION_CHECK_FOR_UPGRADE", str);
    }

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        if (TextUtils.isEmpty(stringExtra)) {
            return "ACTION_CHECK_FOR_UPGRADE";
        }
        return "ACTION_CHECK_FOR_UPGRADE:" + stringExtra;
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            EventBus.getDefault().post(new CheckForUpgradeEvent(true));
            LogUtils.v("检查所有的应用更新", new Object[0]);
            checkForAll();
            if (intent.getBooleanExtra("NOTIFY", true)) {
                try {
                    LogUtils.v("通知栏提示有应用更新", new Object[0]);
                    notifyUpgrade(context);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            LogUtils.v("通知其他组件应用已经更新", new Object[0]);
            EventBus.getDefault().post(new CheckForUpgradeEvent(false));
            return;
        }
        LogUtils.v("检查更新" + stringExtra, new Object[0]);
        checkForUpdate(stringExtra);
        EventBus.getDefault().post(new AppCheckForUpgradeEvent(stringExtra));
    }

    private final void checkForAll() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        List<MobileApp> mobileAppExistListFast = instance.getMobileAppExistListFast();
        if (mobileAppExistListFast == null || mobileAppExistListFast.isEmpty()) {
            LogUtils.v("没有应用需要检查更新", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (MobileApp mobileApp : mobileAppExistListFast) {
                try {
                    Intrinsics.checkNotNullExpressionValue(mobileApp, "app");
                    String str = (mobileApp.isSystemApp() ? "1" : "0") + "," + mobileApp.getVersionCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(",");
                    String apkMd5 = mobileApp.getApkMd5();
                    Intrinsics.checkNotNull(apkMd5);
                    sb.append(apkMd5);
                    jSONObject.put(mobileApp.getPackageName(), sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            DataManager instance2 = DataManager.getInstance();
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            List<R> firstOrDefault = instance2.checkForUpgradeAppList(mobileAppExistListFast, appSetting.isCheckCoolapkBetaVersion()).map(RxUtils.checkResultToData()).flatMap(CheckForUpgradeAction$checkForAll$upgradeInfoList$1.INSTANCE).map(CheckForUpgradeAction$checkForAll$upgradeInfoList$2.INSTANCE).toList().toBlocking().firstOrDefault(CollectionsKt.emptyList());
            LogUtils.v("清除本地数据库应用的UpgradeInfo", new Object[0]);
            DataManager.getInstance().clearMobileAppUpgradeInfo();
            LogUtils.v("更新本地数据库应用的UpgradeInfo, 共有" + firstOrDefault.size() + (char) 20010, new Object[0]);
            DataManager.getInstance().updateMobileAppUpgradeInfoList(firstOrDefault);
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
    }

    private final void checkForUpdate(String str) {
        try {
            MobileApp mobileApp = DataManager.getInstance().getMobileApp(str);
            if (mobileApp == null) {
                LogUtils.v("没有对应的应用，不检查更新，包名：" + str, new Object[0]);
                return;
            }
            DataManager instance = DataManager.getInstance();
            List<MobileApp> listOf = CollectionsKt.listOf(mobileApp);
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            R firstOrDefault = instance.checkForUpgradeAppList(listOf, appSetting.isCheckCoolapkBetaVersion()).map(RxUtils.checkResultToData()).flatMap(CheckForUpgradeAction$checkForUpdate$upgradeInfo$1.INSTANCE).map(CheckForUpgradeAction$checkForUpdate$upgradeInfo$2.INSTANCE).toBlocking().firstOrDefault(null);
            LogUtils.v("清除应用" + str + "的UpgradeInfo", new Object[0]);
            DataManager.getInstance().clearMobileAppUpgradeInfo(str);
            if (firstOrDefault != null) {
                LogUtils.v("更新应用" + str + "的UpgradeInfo", new Object[0]);
                DataManager.getInstance().updateMobileAppUpgradeInfo(firstOrDefault);
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    private final void notifyUpgrade(Context context) {
        List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
        if (mobileAppUpgradeListFast != null && !mobileAppUpgradeListFast.isEmpty() && DataManager.getInstance().getPreferencesBoolean("show_upgrade_notification_enabled", true)) {
            CollectionsKt.sortWith(mobileAppUpgradeListFast, CheckForUpgradeAction$notifyUpgrade$1.INSTANCE);
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, UpgradeManagerActivity.class), 134217728);
            String string = context.getString(2131886502, Integer.valueOf(mobileAppUpgradeListFast.size()));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…e_update_apps, data.size)");
            int min = Math.min(mobileAppUpgradeListFast.size(), 3);
            String str = "";
            for (int i = 0; i < min; i++) {
                MobileApp mobileApp = mobileAppUpgradeListFast.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(", ");
                Intrinsics.checkNotNullExpressionValue(mobileApp, "apkCard");
                sb.append(mobileApp.getAppName());
                str = sb.toString();
            }
            if (mobileAppUpgradeListFast.size() > 3) {
                str = str + context.getString(2131886501, Integer.valueOf(mobileAppUpgradeListFast.size()));
            }
            if (str.length() > 2) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str = str.substring(2);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
            }
            String str2 = string;
            String str3 = str;
            NotificationCompat.Builder style = new NotificationCompat.Builder(context, String.valueOf(3)).setTicker(str2).setContentTitle(str2).setContentText(str3).setSmallIcon(2131231767).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099786)).setShowWhen(true).setAutoCancel(true).setContentIntent(activity).setStyle(new NotificationCompat.BigTextStyle().bigText(str3));
            style.addAction(2131231595, context.getString(2131886156), PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_UPGRADE_ALL_APP_CLICK"), 134217728));
            style.addAction(2131231596, context.getString(2131886158), PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_START_APP_UPGRADE_CLICK"), 134217728));
            try {
                Object systemService = context.getSystemService("notification");
                if (systemService != null) {
                    ((NotificationManager) systemService).notify(3, style.build());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }
}
