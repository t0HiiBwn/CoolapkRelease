package com.coolapk.market.service;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.event.UninstallEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.service.action.InstallAction;
import com.coolapk.market.service.action.InstallQueueAction;
import com.coolapk.market.service.action.PackageAddedAction;
import com.coolapk.market.service.action.PackageRemovedAction;
import com.coolapk.market.service.action.UninstallAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/service/PackageService;", "Lcom/coolapk/market/service/TaskService;", "()V", "isFirstForeground", "", "serviceActions", "Ljava/util/ArrayList;", "Lcom/coolapk/market/service/ServiceAction;", "Lkotlin/collections/ArrayList;", "getServiceActions", "", "onCreate", "", "onDestroy", "onInstallEventChanged", "event", "Lcom/coolapk/market/event/InstallEvent;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onUninstallEventChanged", "Lcom/coolapk/market/event/UninstallEvent;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PackageService.kt */
public final class PackageService extends TaskService {
    public static final String ACTION_INSTALL = "ACTION_INSTALL";
    public static final String ACTION_INSTALL_QUEUE = "ACTION_INSTALL_QUEUE";
    public static final String ACTION_PACKAGE_ADDED = "ACTION_PACKAGE_ADDED";
    public static final String ACTION_PACKAGE_REMOVED = "ACTION_PACKAGE_REMOVED";
    public static final String ACTION_UNINSTALL = "ACTION_UNINSTALL";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_EXTRA = "EXTRA";
    public static final String KEY_FILE_PATH = "FILE_PATH";
    public static final String KEY_FOREGROUND = "FOREGROUND";
    public static final String KEY_FROM = "FROM";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_USE_SIGNATURES = "USE_SIGNATURES";
    private boolean isFirstForeground = true;
    private final ArrayList<ServiceAction> serviceActions = CollectionsKt.arrayListOf(new InstallQueueAction(), new InstallAction(), new UninstallAction(), new PackageAddedAction(), new PackageRemovedAction());

    public PackageService() {
        super("PackageService");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/service/PackageService$Companion;", "", "()V", "ACTION_INSTALL", "", "ACTION_INSTALL_QUEUE", "ACTION_PACKAGE_ADDED", "ACTION_PACKAGE_REMOVED", "ACTION_UNINSTALL", "KEY_EXTRA", "KEY_FILE_PATH", "KEY_FOREGROUND", "KEY_FROM", "KEY_PACKAGE_NAME", "KEY_TITLE", "KEY_USE_SIGNATURES", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PackageService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.service.TaskService
    protected List<ServiceAction> getServiceActions() {
        return this.serviceActions;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.v("PackageService create", new Object[0]);
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.service.TaskService, android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.isFirstForeground && Build.VERSION.SDK_INT >= 26) {
            if (intent != null ? intent.getBooleanExtra("FOREGROUND", false) : false) {
                this.isFirstForeground = false;
                startForeground(7, new NotificationCompat.Builder(getApplicationContext(), String.valueOf(6)).setContentTitle("酷安后台服务").setSmallIcon(2131231767).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099786)).setContentText("").setAutoCancel(true).build());
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
        LogUtils.v("PackageService destroy", new Object[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onInstallEventChanged(InstallEvent installEvent) {
        Intrinsics.checkNotNullParameter(installEvent, "event");
        InstallState installState = installEvent.installState;
        if (installState != null && installState.getState() == 6 && installState.getExtra() != null) {
            Extra extra = installState.getExtra();
            Intrinsics.checkNotNull(extra);
            String string = extra.getString("TITLE");
            if (TextUtils.isEmpty(string)) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                List<DownloadState> downloadStateList = instance.getDownloadStateList();
                Intrinsics.checkNotNullExpressionValue(downloadStateList, "DataManager.getInstance().downloadStateList");
                Iterator<DownloadState> it2 = downloadStateList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    DownloadState next = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next, "downloadState");
                    if (TextUtils.equals(next.getFilePathMd5(), installState.getKey())) {
                        string = next.getFileName();
                        break;
                    }
                }
                if (TextUtils.isEmpty(string)) {
                    Uri parse = Uri.parse(installState.getPath());
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(installState.path)");
                    string = parse.getLastPathSegment();
                }
            }
            Toast.show$default(this, getString(2131887271, new Object[]{string}), 0, false, 12, null);
            LogUtils.v("正在安装: %s", string);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onUninstallEventChanged(UninstallEvent uninstallEvent) {
        Intrinsics.checkNotNullParameter(uninstallEvent, "event");
        UninstallState uninstallState = DataManager.getInstance().getUninstallState(uninstallEvent.key);
        if (uninstallState != null && uninstallState.getState() == 2) {
            String title = uninstallState.getTitle();
            Toast.show$default(this, getString(2131887277, new Object[]{title}), 0, false, 12, null);
            LogUtils.v("正在卸载: %s", title);
        }
    }
}
