package com.coolapk.market.service.install;

import com.coolapk.market.AppHolder;
import com.coolapk.market.event.ApplicationVisibleEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.service.DownloadNotificationHelper;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.UriUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/service/install/InstallQueue;", "", "()V", "dataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/coolapk/market/service/install/InstallJob;", "add", "", "job", "appIsForeground", "", "hasJob", "isInstall", "filePath", "", "nextInstallJob", "onApplicationVisibleEventChanged", "event", "Lcom/coolapk/market/event/ApplicationVisibleEvent;", "onAttach", "onDetach", "poll", "tryInstall", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: InstallQueue.kt */
public final class InstallQueue {
    public static final Companion Companion = new Companion(null);
    private final ConcurrentLinkedQueue<InstallJob> dataList = new ConcurrentLinkedQueue<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/service/install/InstallQueue$Companion;", "", "()V", "getDownloadStateWithInstallPath", "Lcom/coolapk/market/model/DownloadState;", "path", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: InstallQueue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadState getDownloadStateWithInstallPath(String str) {
            T t;
            boolean z;
            Intrinsics.checkNotNullParameter(str, "path");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            List<DownloadState> downloadStateList = instance.getDownloadStateList();
            Intrinsics.checkNotNullExpressionValue(downloadStateList, "DataManager.getInstance().downloadStateList");
            Iterator<T> it2 = downloadStateList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                T t2 = t;
                Intrinsics.checkNotNullExpressionValue(t2, "state");
                if (!t2.isSuccess() || !Intrinsics.areEqual(UriUtils.trimScheme(t2.getFilePath()), UriUtils.trimScheme(str))) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return t;
        }
    }

    public final synchronized void add(InstallJob installJob) {
        Intrinsics.checkNotNullParameter(installJob, "job");
        if (this.dataList.contains(installJob)) {
            LogUtils.d("待安装列表已经有相同的任务，无需加入: " + installJob.getFilePath(), new Object[0]);
            return;
        }
        LogUtils.d("加入待安装列表: " + installJob.getFilePath(), new Object[0]);
        this.dataList.add(installJob);
    }

    public final synchronized InstallJob poll() {
        InstallJob poll;
        poll = this.dataList.poll();
        Intrinsics.checkNotNullExpressionValue(poll, "dataList.poll()");
        return poll;
    }

    public final boolean appIsForeground() {
        return AppHolder.getActivityLifeCycle().isAppForeground();
    }

    public final boolean hasJob() {
        return !this.dataList.isEmpty();
    }

    public final boolean isInstall(String str) {
        Extra extra;
        MobileApp mobileApp;
        Intrinsics.checkNotNullParameter(str, "filePath");
        DownloadState downloadStateWithInstallPath = Companion.getDownloadStateWithInstallPath(str);
        if (downloadStateWithInstallPath == null || (extra = downloadStateWithInstallPath.getExtra()) == null) {
            return false;
        }
        String string = extra.getString("PACKAGE_NAME");
        int i = extra.getInt("VERSION_CODE");
        if (string == null || i == 0 || (mobileApp = DataManager.getInstance().getMobileApp(string)) == null || i != mobileApp.getVersionCode()) {
            return false;
        }
        return true;
    }

    public final synchronized InstallJob nextInstallJob() {
        InstallJob installJob;
        installJob = null;
        if (appIsForeground()) {
            while (hasJob()) {
                installJob = poll();
                LogUtils.d("取出任务，准备安装: " + installJob.getFilePath(), new Object[0]);
                if (!isInstall(installJob.getFilePath())) {
                    break;
                }
                LogUtils.d("该应用已经被安装过，无需再安装: " + installJob.getFilePath(), new Object[0]);
                installJob = null;
            }
        } else {
            LogUtils.d("酷安不在前台显示，等待用户操作", new Object[0]);
        }
        return installJob;
    }

    public final synchronized void tryInstall() {
        InstallJob nextInstallJob = nextInstallJob();
        if (nextInstallJob != null) {
            LogUtils.d("进行安装: " + nextInstallJob.getFilePath(), new Object[0]);
            ActionManager.installImmediately(AppHolder.getCurrentActivity(), nextInstallJob.getFilePath(), nextInstallJob.getFrom(), nextInstallJob.getExtra(), nextInstallJob.getUseSignatures());
            DownloadState downloadStateWithInstallPath = Companion.getDownloadStateWithInstallPath(nextInstallJob.getFilePath());
            if (downloadStateWithInstallPath != null) {
                DownloadNotificationHelper.getInstance().cancelResult(AppHolder.getApplication(), downloadStateWithInstallPath.getKey());
            }
        }
    }

    public final void onAttach() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    public final void onDetach() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onApplicationVisibleEventChanged(ApplicationVisibleEvent applicationVisibleEvent) {
        Intrinsics.checkNotNullParameter(applicationVisibleEvent, "event");
        if (applicationVisibleEvent.isShown()) {
            LogUtils.d("App在前台，检查安装任务", new Object[0]);
            ActionManager.startInstallQueueService(AppHolder.getCurrentActivity());
        }
    }
}
