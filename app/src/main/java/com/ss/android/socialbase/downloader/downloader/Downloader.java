package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.i.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

public class Downloader {
    private static volatile Downloader instance;
    private String globalDefaultSavePath;

    private Downloader() {
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        synchronized (Downloader.class) {
            initOrCover(downloaderBuilder, false);
        }
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        synchronized (Downloader.class) {
            if (downloaderBuilder != null) {
                if (instance == null) {
                    instance = downloaderBuilder.build();
                } else if (!b.P()) {
                    b.a(downloaderBuilder);
                } else if (z) {
                    b.b(downloaderBuilder);
                }
            }
        }
    }

    Downloader(DownloaderBuilder downloaderBuilder) {
        b.a(downloaderBuilder);
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    b.a(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }

    public static DownloadTask with(Context context) {
        getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        c.a().d(i);
    }

    public int getDownloadId(String str, String str2) {
        return c.a().a(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return c.a().a(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        c.a().c(i, z);
    }

    public void resume(int i) {
        c.a().f(i);
    }

    public boolean canResume(int i) {
        return c.a().e(i);
    }

    public void restart(int i) {
        c.a().g(i);
    }

    public void pauseAll() {
        c.a().c();
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return c.a().b(str);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        c.a().a(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        c.a().b(list);
    }

    public long getCurBytes(int i) {
        return c.a().h(i);
    }

    public int getStatus(int i) {
        return c.a().i(i);
    }

    public boolean isDownloading(int i) {
        boolean j;
        if (!a.a(4194304)) {
            return c.a().j(i);
        }
        synchronized (this) {
            j = c.a().j(i);
        }
        return j;
    }

    public DownloadInfo getDownloadInfo(int i) {
        return c.a().k(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return c.a().b(str, str2);
    }

    public ab getDownloadNotificationEventListener(int i) {
        return c.a().l(i);
    }

    public void setDownloadNotificationEventListener(int i, ab abVar) {
        c.a().a(i, abVar);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return c.a().c(str);
    }

    public void clearDownloadData(int i) {
        c.a().d(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        c.a().d(i, z);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        c.a().n(i);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        c.a().a(i, null, g.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().a(i, iDownloadListener, g.MAIN, false);
        }
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.MAIN, true);
        }
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener != null) {
            c.a().a(i, iDownloadListener, g.MAIN, true, z);
        }
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.MAIN, false);
        }
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.SUB, true);
        }
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.SUB, false);
        }
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        c.a().a(i, null, g.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().a(i, iDownloadListener, g.SUB, false);
        }
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        c.a().a(i, null, g.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().a(i, iDownloadListener, g.NOTIFICATION, false);
        }
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.NOTIFICATION, true);
        }
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            c.a().b(i, iDownloadListener, g.NOTIFICATION, false);
        }
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return c.a().a(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return c.a().d();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return c.a().d(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return c.a().e(str);
    }

    public void destoryDownloader() {
        b.a();
    }

    public void setLogLevel(int i) {
        c.a().p(i);
    }

    public void registerDownloadCacheSyncListener(k kVar) {
        c.a().a(kVar);
    }

    public void unRegisterDownloadCacheSyncListener(k kVar) {
        c.a().b(kVar);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return c.a().e();
    }

    public void setDownloadInMultiProcess() {
        if (a.a(4194304)) {
            synchronized (this) {
                b.b();
            }
            return;
        }
        b.b();
    }

    public t getDownloadFileUriProvider(int i) {
        return c.a().r(i);
    }

    public void registerDownloaderProcessConnectedListener(ae aeVar) {
        c.a().a(aeVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ae aeVar) {
        c.a().b(aeVar);
    }

    public boolean isDownloadServiceForeground(int i) {
        return c.a().c(i).b();
    }

    public p getReserveWifiStatusListener() {
        return b.O();
    }

    public void setReserveWifiStatusListener(p pVar) {
        b.a(pVar);
    }

    public void setThrottleNetSpeed(int i, long j) {
        c.a().a(i, j);
    }

    public File getGlobalSaveDir() {
        File file = null;
        if (TextUtils.isEmpty(this.globalDefaultSavePath)) {
            return null;
        }
        try {
            File file2 = new File(this.globalDefaultSavePath);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                    return file2;
                } else if (file2.isDirectory()) {
                    return file2;
                } else {
                    file2.delete();
                    file2.mkdirs();
                    return file2;
                }
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
            return file;
        }
    }

    public void setDefaultSavePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.globalDefaultSavePath = str;
        }
    }
}
