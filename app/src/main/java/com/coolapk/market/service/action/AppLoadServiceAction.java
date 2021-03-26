package com.coolapk.market.service.action;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.LoadMobileAppEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/service/action/AppLoadServiceAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "getTaskKey", "", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "onHandleAction", "", "context", "Landroid/content/Context;", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppLoadServiceAction.kt */
public final class AppLoadServiceAction implements ServiceAction {
    public static final String ACTION_LOAD_MOBILE_APP = "ACTION_LOAD_MOBILE_APP";
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return "ACTION_LOAD_MOBILE_APP";
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/service/action/AppLoadServiceAction$Companion;", "", "()V", "ACTION_LOAD_MOBILE_APP", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppLoadServiceAction.kt */
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
        return Intrinsics.areEqual("ACTION_LOAD_MOBILE_APP", str);
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        EventBus.getDefault().post(new LoadMobileAppEvent(true));
        DataManager.getInstance().setMobileAppNotExist();
        List<LocalApk> appList = LocalApkUtils.getAppList(context.getPackageManager(), !AppHolder.getAppSetting().getBooleanPref("show_hide_apps"));
        Intrinsics.checkNotNullExpressionValue(appList, "LocalApkUtils.getAppList…geManager, !showHideApps)");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        List<MobileApp> mobileAppList = instance.getMobileAppList();
        Intrinsics.checkNotNullExpressionValue(mobileAppList, "DataManager.getInstance().mobileAppList");
        List<MobileApp> list = mobileAppList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            linkedHashMap.put(t2.getPackageName(), t);
        }
        ArrayList arrayList = new ArrayList();
        LogUtils.d("开始插入或更新应用", new Object[0]);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (LocalApk localApk : appList) {
            Intrinsics.checkNotNullExpressionValue(localApk, "apk");
            MobileApp mobileApp = (MobileApp) linkedHashMap.get(localApk.getPackageName());
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            if (mobileApp != null) {
                contentValues.put("_id", Long.valueOf(mobileApp.getDbId()));
                contentValues.put("created", Long.valueOf(currentTimeMillis));
                z = (mobileApp.getLastUpdateTime() == localApk.getLastUpdateTime() && !TextUtils.isEmpty(mobileApp.getApkMd5()) && mobileApp.getVersionCode() == localApk.getVersionCode()) ? false : true;
            }
            if (z) {
                LogUtils.d("获取 %s's MD5", localApk.getAppName());
                contentValues.put("apkMd5", CoolFileUtils.getFileMd5(localApk.getFilePath()));
            }
            contentValues.put("packageName", localApk.getPackageName());
            contentValues.put("appName", localApk.getAppName());
            contentValues.put("versionName", localApk.getVersionName());
            contentValues.put("versionCode", Integer.valueOf(localApk.getVersionCode()));
            contentValues.put("apkLength", Long.valueOf(localApk.getApkLength()));
            contentValues.put("isSystem", Boolean.valueOf(localApk.isSystemApp()));
            contentValues.put("isExist", (Boolean) true);
            contentValues.put("apkPath", localApk.getFilePath());
            contentValues.put("firstInstallTime", Long.valueOf(localApk.getFirstInstallTime()));
            contentValues.put("lastUpdateTime", Long.valueOf(localApk.getLastUpdateTime()));
            contentValues.put("modified", Long.valueOf(currentTimeMillis));
            arrayList.add(contentValues);
            if (mobileApp != null) {
                i2++;
                LogUtils.d("更新: %s", contentValues.toString());
            } else {
                i++;
                LogUtils.d("插入: %s", contentValues.toString());
            }
        }
        DataManager.getInstance().insertOrUpdateContentValuesList("app", arrayList);
        LogUtils.i("应用一共有: %d, 数据库应用: %d, 插入: %d, 更新: %d", Integer.valueOf(appList.size()), Integer.valueOf(linkedHashMap.size()), Integer.valueOf(i), Integer.valueOf(i2));
        LogUtils.i("删除不存在应用: %d", Integer.valueOf(DataManager.getInstance().deleteMobileAppNotExist()));
        EventBus.getDefault().post(new LoadMobileAppEvent(false));
    }
}
