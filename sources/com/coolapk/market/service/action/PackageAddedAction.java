package com.coolapk.market.service.action;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.service.DownloadNotificationHelper;
import com.coolapk.market.service.ServiceAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UriUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/service/action/PackageAddedAction;", "Lcom/coolapk/market/service/ServiceAction;", "()V", "doPackageAddedAction", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getTaskKey", "", "isAppNewInstall", "", "packageName", "isThisAction", "action", "onHandleAction", "onStartAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PackageAddedAction.kt */
public final class PackageAddedAction implements ServiceAction {
    public static final String ACTION_PACKAGE_ADDED = "ACTION_PACKAGE_ADDED";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";

    @Override // com.coolapk.market.service.ServiceAction
    public void onStartAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/service/action/PackageAddedAction$Companion;", "", "()V", "ACTION_PACKAGE_ADDED", "", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PackageAddedAction.kt */
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
        return Intrinsics.areEqual(str, "ACTION_PACKAGE_ADDED");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public String getTaskKey(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        if (!TextUtils.isEmpty(stringExtra)) {
            StringBuilder sb = new StringBuilder();
            String action = intent.getAction();
            Intrinsics.checkNotNull(action);
            sb.append(action);
            sb.append(stringExtra);
            String md5 = StringUtils.toMd5(sb.toString());
            Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(intent.action!! + packageName)");
            LogUtils.v("[Packager added] Package Name: %s, key: %s", stringExtra, md5);
            return md5;
        }
        throw new RuntimeException("[Packager added] Package name is empty");
    }

    @Override // com.coolapk.market.service.ServiceAction
    public void onHandleAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        doPackageAddedAction(context, intent);
    }

    private final void doPackageAddedAction(Context context, Intent intent) {
        Extra extra;
        Extra extra2;
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_PACKAGE_NAME)!!");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        List<InstallState> installStateList = instance.getInstallStateList();
        Intrinsics.checkNotNullExpressionValue(installStateList, "installStateList");
        CollectionsKt.sortWith(installStateList, PackageAddedAction$doPackageAddedAction$1.INSTANCE);
        StringBuilder sb = new StringBuilder();
        InstallState installState = null;
        int i = 0;
        for (InstallState installState2 : installStateList) {
            Intrinsics.checkNotNullExpressionValue(installState2, "state");
            if (installState2.isComplete() && (extra2 = installState2.getExtra()) != null) {
                Intrinsics.checkNotNullExpressionValue(extra2, "state.extra ?: continue");
                Extra extra3 = installState2.getExtra();
                Intrinsics.checkNotNull(extra3);
                String string = extra3.getString("TITLE");
                String string2 = extra2.getString("PACKAGE_NAME");
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(string);
                i++;
                LogUtils.v("We have %s's install state", string);
                if (TextUtils.equals(string2, stringExtra)) {
                    installState = installState2;
                }
            }
        }
        LogUtils.v("We have %d install state(s)", Integer.valueOf(i));
        if (i > 3) {
            sb.append(context.getString(2131886511, Integer.valueOf(i)));
        }
        if (installState == null || installState.getExtra() == null) {
            ActionManager.statInstall(context, stringExtra, "0", "", isAppNewInstall(context, stringExtra), "");
            return;
        }
        Extra extra4 = installState.getExtra();
        Intrinsics.checkNotNull(extra4);
        String string3 = extra4.getString("TITLE");
        Extra extra5 = installState.getExtra();
        Intrinsics.checkNotNull(extra5);
        String string4 = extra5.getString("VERSION_NAME");
        Extra extra6 = installState.getExtra();
        Intrinsics.checkNotNull(extra6);
        String string5 = extra6.getString("APK_SIZE");
        Extra extra7 = installState.getExtra();
        Intrinsics.checkNotNull(extra7);
        String string6 = extra7.getString("EXTRA_ANALYSIS_DATA");
        NotificationCompat.Builder deleteIntent = new NotificationCompat.Builder(context, String.valueOf(2)).setTicker(context.getString(2131886512, string3)).setSmallIcon(2131231767).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099786)).setShowWhen(true).setAutoCancel(true).setDeleteIntent(PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_DISMISS"), 134217728));
        if (i > 1) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "bigTextBuilder.toString()");
            String str = sb2;
            deleteIntent.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
            deleteIntent.setContentTitle(context.getString(2131886513, Integer.valueOf(i)));
            deleteIntent.setContentText(str);
            deleteIntent.setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK"), 134217728));
            deleteIntent.addAction(2131231596, context.getString(2131886158), PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK"), 134217728));
            deleteIntent.addAction(2131231594, context.getString(2131886136), PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_CANCEL_CLICK"), 134217728));
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                Drawable loadIcon = packageManager.getPackageInfo(stringExtra, 0).applicationInfo.loadIcon(packageManager);
                if (loadIcon instanceof BitmapDrawable) {
                    deleteIntent.setLargeIcon(((BitmapDrawable) loadIcon).getBitmap());
                }
                deleteIntent.setContentTitle(string3);
                deleteIntent.setContentText(context.getString(2131886515, StringUtils.emptyIfNull(string4)));
                deleteIntent.setContentInfo(string5);
                deleteIntent.setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_APP_CLICK").putExtra("packageName", stringExtra), 134217728));
                deleteIntent.addAction(2131231596, context.getString(2131886158), PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK"), 134217728));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
        DownloadState downloadState = null;
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        List<DownloadState> downloadStateList = instance2.getDownloadStateList();
        Intrinsics.checkNotNullExpressionValue(downloadStateList, "DataManager.getInstance().downloadStateList");
        Iterator<DownloadState> it2 = downloadStateList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            DownloadState next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "state");
            if (next.isSuccess() && (extra = next.getExtra()) != null) {
                Intrinsics.checkNotNullExpressionValue(extra, "state.extra ?: continue");
                if (TextUtils.equals(extra.getString("PACKAGE_NAME"), stringExtra) && TextUtils.equals(UriUtils.trimScheme(next.getFilePath()), UriUtils.trimScheme(installState.getPath()))) {
                    downloadState = next;
                    break;
                }
            }
        }
        if (downloadState != null) {
            DownloadNotificationHelper.getInstance().cancelResult(context, downloadState.getKey());
        }
        if (AppHolder.getAppSetting().getBooleanPref("show_installed_notification_enabled")) {
            Object systemService = context.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(2, deleteIntent.build());
        }
        Uri parse = Uri.parse(installState.getFrom());
        ActionManager.statInstall(context, stringExtra, parse.getQueryParameter("aid"), parse.getQueryParameter("extra"), isAppNewInstall(context, stringExtra), string6);
        if (AppHolder.getAppSetting().shouldDeleteAfterInstalling() && !TextUtils.isEmpty(installState.getApkFilePath())) {
            String apkFilePath = installState.getApkFilePath();
            Intrinsics.checkNotNull(apkFilePath);
            boolean delete = new File(apkFilePath).delete();
            LogUtils.v("Apk file delete: %s, [%s]", Boolean.valueOf(delete), installState.getApkFilePath());
            if (!TextUtils.equals(installState.getPath(), installState.getApkFilePath())) {
                delete = new File(installState.getPath()).delete();
                LogUtils.v("Original file delete: %s, [%s]", Boolean.valueOf(delete), installState.getApkFilePath());
            }
            if (delete) {
                new Handler(Looper.getMainLooper()).post(new PackageAddedAction$doPackageAddedAction$2(context, string3));
            }
        }
    }

    private final boolean isAppNewInstall(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo.lastUpdateTime == packageInfo.firstInstallTime) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
