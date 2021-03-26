package com.coolapk.market.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.download.DownloadJob;
import com.coolapk.market.download.Downloader;
import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.event.DownloadInfoEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.DownloadStartInterceptor;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.network.NetworkExecutorFactory;
import com.coolapk.market.processor.FileProcessorFactory;
import com.coolapk.market.service.work.DeleteApkWorker;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.appmanager.DownloadManagerActivity;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class DownloadService extends Service {
    public static final String ACTION_CLOSE = "DownloadService.ACTION_CLOSE";
    public static final String ACTION_START = "DownloadService.ACTION_START";
    public static final String ACTION_STOP = "DownloadService.ACTION_STOP";
    public static final int FLAG_WITH_AGAIN = 1;
    public static final int FLAG_WITH_AUTO = 3;
    public static final int FLAG_WITH_DELETE = 2;
    public static final int FLAG_WITH_WIFI_RESTART = 4;
    public static final String KEY_EXTRA = "EXTRA";
    public static final String KEY_FLAG = "FLAG";
    public static final String KEY_URL = "URL";
    private static final String TAG = "DownloadService";
    private String coolMarketKey;
    private boolean serviceShouldClose;

    private DownloadService getService() {
        return this;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.serviceShouldClose = false;
        LogUtils.v("DownloadService on create", new Object[0]);
        DataManager.getInstance().registerDownloadEvent(this);
        DataManager.getInstance().setDownloadStartInterceptor(new MyDownloadStartInterceptor());
        startForeground(1, new NotificationCompat.Builder(this, String.valueOf(1)).setContentTitle(getString(2131886684)).setContentText(getString(2131886953)).setSmallIcon(17301634).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, DownloadManagerActivity.class), 134217728)).build());
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r1.equals("DownloadService.ACTION_CLOSE") == false) goto L_0x0042;
     */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        char c = 0;
        if (this.serviceShouldClose) {
            LogUtils.v("We reject any intent when service closing", new Object[0]);
            return 2;
        }
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            String stringExtra = intent.getStringExtra("URL");
            int intExtra = intent.getIntExtra("FLAG", 0);
            LogUtils.v("Receive action: %s, url: %s, flag: %d", action, stringExtra, Integer.valueOf(intExtra));
            action.hashCode();
            switch (action.hashCode()) {
                case 987490800:
                    break;
                case 1002491994:
                    if (action.equals("DownloadService.ACTION_START")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1417812202:
                    if (action.equals("DownloadService.ACTION_STOP")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.serviceShouldClose = true;
                    Downloader.getInstance().destroy();
                    stopServiceWhenNecessary();
                    break;
                case 1:
                    Extra extra = (Extra) intent.getParcelableExtra("EXTRA");
                    if (intExtra != 1) {
                        if (intExtra == 3) {
                            startDownloadWithAuto(stringExtra, extra);
                            break;
                        } else {
                            startDownload(stringExtra, extra);
                            break;
                        }
                    } else {
                        startDownloadWithAgain(stringExtra, extra);
                        break;
                    }
                case 2:
                    if (intExtra != 2) {
                        if (intExtra == 4) {
                            stopDownloadWithWifiRestart(stringExtra);
                            break;
                        } else {
                            stopDownload(stringExtra);
                            break;
                        }
                    } else {
                        stopDownloadWithDelete(stringExtra);
                        break;
                    }
            }
        }
        return 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v("DownloadService on destroy", new Object[0]);
        DataManager.getInstance().unregisterDownloadEvent(this);
    }

    private void startDownload(String str, Extra extra) {
        String[] strArr = extra != null ? (String[]) extra.getTypeArray("HEADERS", new String[0]) : null;
        stopDownloadsWithAuto().subscribe((Subscriber<? super List<String>>) new EmptySubscriber());
        DataManager.getInstance().startDownload(str, AppHolder.getAppSetting().getDownloadDir(), tryMakeFileName(extra), extra, NetworkExecutorFactory.newExecutor(str, strArr)).subscribe((Subscriber<? super String>) new EmptySubscriber());
    }

    private void startDownloadWithAgain(String str, final Extra extra) {
        stopDownloadsWithAuto().subscribe((Subscriber<? super List<String>>) new EmptySubscriber());
        DataManager.getInstance().stopDownload(str).flatMap(new Func1<String, Observable<String>>() {
            /* class com.coolapk.market.service.DownloadService.AnonymousClass2 */

            public Observable<String> call(String str) {
                return DownloadService.this.deleteDownloadFile(str);
            }
        }).flatMap(new Func1<String, Observable<String>>() {
            /* class com.coolapk.market.service.DownloadService.AnonymousClass1 */

            public Observable<String> call(String str) {
                Extra extra = extra;
                return DataManager.getInstance().startDownload(str, AppHolder.getAppSetting().getDownloadDir(), DownloadService.tryMakeFileName(extra), extra, NetworkExecutorFactory.newExecutor(str, extra != null ? (String[]) extra.getTypeArray("HEADERS", new String[0]) : null));
            }
        }).subscribe((Subscriber<? super R>) new EmptySubscriber());
    }

    private void startDownloadWithAuto(String str, Extra extra) {
        String[] strArr = extra != null ? (String[]) extra.getTypeArray("HEADERS", new String[0]) : null;
        if (extra == null) {
            extra = new Extra();
        }
        extra.put("IS_AUTO_DOWNLOAD", true);
        DataManager.getInstance().startDownload(str, AppHolder.getAppSetting().getDownloadDir(), tryMakeFileName(extra), extra, NetworkExecutorFactory.newExecutor(str, strArr)).subscribe((Subscriber<? super String>) new EmptySubscriber());
    }

    private void stopDownload(String str) {
        boolean isDownloadJobAlive = DataManager.getInstance().isDownloadJobAlive(str);
        DataManager.getInstance().stopDownload(str).toBlocking().first();
        if (!isDownloadJobAlive) {
            DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(str);
            if (downloadStateWithUrl != null) {
                DownloadNotificationHelper.getInstance().cancelResult(this, downloadStateWithUrl.getKey());
            }
            stopServiceWhenNecessary();
        }
    }

    private void stopDownloadWithDelete(String str) {
        boolean isDownloadJobAlive = DataManager.getInstance().isDownloadJobAlive(str);
        Extra extra = new Extra();
        extra.put("IS_DELETE", true);
        DataManager.getInstance().stopDownload(str, extra).toBlocking().first();
        deleteDownloadFile(str).toBlocking().first();
        DataManager.getInstance().deleteDownloadInfo(str);
        EventBus.getDefault().post(new DownloadInfoEvent(str));
        if (!isDownloadJobAlive) {
            DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(str);
            if (downloadStateWithUrl != null) {
                DownloadNotificationHelper.getInstance().cancelResult(this, downloadStateWithUrl.getKey());
            }
            stopServiceWhenNecessary();
        }
    }

    private void stopDownloadWithWifiRestart(String str) {
        boolean isDownloadJobAlive = DataManager.getInstance().isDownloadJobAlive(str);
        Extra extra = new Extra();
        extra.put("IS_WIFI_RESTART", true);
        DataManager.getInstance().stopDownload(str, extra).toBlocking().first();
        if (!isDownloadJobAlive) {
            DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(str);
            if (downloadStateWithUrl != null) {
                DownloadNotificationHelper.getInstance().cancelResult(this, downloadStateWithUrl.getKey());
            }
            stopServiceWhenNecessary();
        }
    }

    /* access modifiers changed from: private */
    public Observable<String> deleteDownloadFile(final String str) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.coolapk.market.service.DownloadService.AnonymousClass3 */

            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    try {
                        DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(str);
                        if (downloadStateWithUrl != null && !TextUtils.isEmpty(downloadStateWithUrl.getFilePath())) {
                            LogUtils.v("File delete: %s, [%s]", Boolean.valueOf(new File(downloadStateWithUrl.getFilePath()).delete()), downloadStateWithUrl.getFileName());
                        }
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
            }
        });
    }

    private Observable<List<String>> stopDownloadsWithAuto() {
        return Observable.from(DataManager.getInstance().getDownloadStateList()).filter(new Func1<DownloadState, Boolean>() {
            /* class com.coolapk.market.service.DownloadService.AnonymousClass5 */

            public Boolean call(DownloadState downloadState) {
                Extra extra = downloadState.getExtra();
                return Boolean.valueOf(extra != null && extra.getBoolean("IS_AUTO_DOWNLOAD"));
            }
        }).concatMap(new Func1<DownloadState, Observable<String>>() {
            /* class com.coolapk.market.service.DownloadService.AnonymousClass4 */

            public Observable<String> call(DownloadState downloadState) {
                return DataManager.getInstance().stopDownload(downloadState.getUrl());
            }
        }).toList();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004f: APUT  (r0v30 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r1v11 java.lang.String) */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadEventChanged(DownloadEvent downloadEvent) {
        if (getService() != null) {
            if (this.serviceShouldClose) {
                LogUtils.v("Service should close, we do not notify any message", new Object[0]);
                stopServiceWhenNecessary();
                return;
            }
            DownloadState downloadState = downloadEvent.downloadState;
            if (downloadState != null) {
                int state = downloadState.getState();
                if (state == 2) {
                    LogUtils.v("Download start, [%s]", downloadState.getFileName());
                    Extra extra = downloadState.getExtra();
                    if (extra == null || !extra.getBoolean("IS_AUTO_DOWNLOAD")) {
                        DownloadNotificationHelper.getInstance().cancelResult(this, downloadState.getKey());
                        DownloadNotificationHelper.getInstance().onDownloadStart(this, downloadState);
                    }
                } else if (state == 3) {
                    LogUtils.v("Download running, [%s]", downloadState.getFileName());
                    Extra extra2 = downloadState.getExtra();
                    if (extra2 == null || !extra2.getBoolean("IS_AUTO_DOWNLOAD")) {
                        DownloadNotificationHelper.getInstance().onDownloadRunning(this, downloadState);
                    }
                } else if (state == 4) {
                    LogUtils.v("Download success, [%s]", downloadState.getFileName());
                    Extra extra3 = downloadState.getExtra();
                    if (extra3 == null || !extra3.getBoolean("IS_AUTO_DOWNLOAD")) {
                        DownloadNotificationHelper.getInstance().onDownloadSuccess(this, downloadState);
                    }
                    if (extra3 != null && UriUtils.isCoolMarketHost(downloadState.getUrl())) {
                        String string = extra3.getString("PACKAGE_NAME");
                        ActionManager.statDownloadComplete(this, string, extra3.getString("APK_ID"), Uri.parse(downloadState.getUrl()).getQueryParameter("extra"), !PackageUtils.isInstalled(this, string), extra3.getString("EXTRA_ANALYSIS_DATA"));
                        if (AppHolder.getAppSetting().isAutoInstallOnDownloaded() && FileProcessorFactory.canHandleWith(CoolFileUtils.getFileExtension(downloadState.getFilePath()))) {
                            if (TextUtils.equals(string, getPackageName())) {
                                LogUtils.v("Pending install action, [%s]", downloadState.getFileName());
                                this.coolMarketKey = downloadState.getKey();
                            } else {
                                LogUtils.v("Send install action, [%s]", downloadState.getFileName());
                                ActionManager.install(this, downloadState.getFilePath(), downloadState.getUrl(), downloadState.getExtra());
                            }
                        }
                    }
                    stopServiceWhenNecessary();
                } else if (state == 5) {
                    LogUtils.v("Download cancel, [%s]", downloadState.getFileName());
                    Extra extra4 = downloadState.getExtra();
                    if (extra4 == null || !extra4.getBoolean("IS_AUTO_DOWNLOAD")) {
                        if (extra4 == null || !extra4.getBoolean("IS_DELETE")) {
                            DownloadNotificationHelper.getInstance().onDownloadCancel(this, downloadState);
                        } else {
                            DownloadNotificationHelper.getInstance().cancelResult(this, downloadState.getKey());
                        }
                    }
                    stopServiceWhenNecessary();
                } else if (state == 6) {
                    Object[] objArr = new Object[2];
                    objArr[0] = downloadState.getFileName();
                    objArr[1] = downloadState.getError() != null ? downloadState.getError().toString() : "";
                    LogUtils.e("Download error, [%s], %s", objArr);
                    Extra extra5 = downloadState.getExtra();
                    if (extra5 != null && extra5.containsKey("PACKAGE_NAME")) {
                        DataManager instance = DataManager.getInstance();
                        String fileName = downloadState.getFileName();
                        instance.saveLog("download", fileName, downloadState.getUrl() + "\n" + downloadState.getError().toString());
                    }
                    if (extra5 == null || !extra5.getBoolean("IS_AUTO_DOWNLOAD")) {
                        DownloadNotificationHelper.getInstance().onDownloadError(this, downloadState);
                    }
                    stopServiceWhenNecessary();
                }
            }
        }
    }

    private void stopServiceWhenNecessary() {
        if (DataManager.getInstance().getDownloadTaskCount() <= 0) {
            if (this.coolMarketKey != null) {
                DownloadState downloadState = DataManager.getInstance().getDownloadState(this.coolMarketKey);
                if (downloadState != null && downloadState.isSuccess()) {
                    LogUtils.v("Send install action, [%s]", downloadState.getFileName());
                    ActionManager.install(this, downloadState.getFilePath(), downloadState.getUrl(), downloadState.getExtra());
                    DeleteApkWorker.setShouldDeleteCoolapkFilePath(downloadState.getFilePath());
                }
                this.coolMarketKey = null;
            }
            LogUtils.v("No job in queue, will stop the service", new Object[0]);
            stopForeground(true);
            stopSelf();
        }
    }

    /* access modifiers changed from: private */
    public static String tryMakeFileName(Extra extra) {
        if (!extra.containsKey("TITLE") || !extra.containsKey("PACKAGE_NAME") || !extra.containsKey("VERSION_NAME") || !extra.containsKey("VERSION_CODE") || !extra.containsKey("APK_ID")) {
            return null;
        }
        return createApkFilePreName(extra.getString("TITLE"), extra.getString("PACKAGE_NAME"), extra.getString("VERSION_NAME"), extra.getInt("VERSION_CODE"), extra.getString("APK_ID"), extra.getString("VERSION_ID"), extra.getString("DOWNLOAD_FROM"));
    }

    private static String createApkFilePreName(String str, String str2, String str3, int i, String str4, String str5, String str6) {
        String str7;
        if (str3 == null) {
            str3 = "no_version_name";
        }
        if (AppHolder.getAppSetting().isDownloadFileNameCNEnable()) {
            str7 = (str + "-" + str3).replaceAll("[^\\p{L}\\p{N}\\.]", "-");
        } else {
            str7 = str2 + "-" + str3.replaceAll("[^\\w|\\.]", "-");
        }
        if (TextUtils.isEmpty(str5)) {
            return str7 + "-" + i + "-" + str4;
        }
        return str7 + "-" + i + "-" + str4 + "-" + str5 + "-" + str6;
    }

    private static class MyDownloadStartInterceptor implements DownloadStartInterceptor {
        private MyDownloadStartInterceptor() {
        }

        @Override // com.coolapk.market.manager.DownloadStartInterceptor
        public Extra intercept(DownloadJob downloadJob) {
            downloadJob.getExtra().put("IS_WIFI_RESTART", false);
            downloadJob.getExtra().put("IS_DELETE", false);
            return downloadJob.getExtra();
        }
    }
}
