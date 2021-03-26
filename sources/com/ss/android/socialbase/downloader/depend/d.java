package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.a;
import com.ss.android.socialbase.downloader.notification.b;

/* compiled from: AbsNotificationListener */
public abstract class d extends AbsDownloadListener implements s {
    protected abstract a a();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        b(downloadInfo);
        a(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        a(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        a(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        a(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        a(-1, downloadInfo, baseException, false);
    }

    private void b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification()) {
            a e = b.a().e(downloadInfo.getId());
            if (e == null) {
                b.a().a(a());
                return;
            }
            e.a(downloadInfo);
        }
    }

    private void a(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && i != 4) {
            a e = b.a().e(downloadInfo.getId());
            if (e == null) {
                e = a();
            }
            e.b(downloadInfo.getTotalBytes());
            if (i == -3) {
                e.a(downloadInfo.getTotalBytes());
            } else {
                e.a(downloadInfo.getCurBytes());
            }
            e.a(i, baseException, z);
        }
    }

    private void c(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            a e = b.a().e(downloadInfo.getId());
            if (e == null) {
                e = a();
            }
            e.a(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.s
    public void a(DownloadInfo downloadInfo) {
        a(11, downloadInfo, null, true);
    }
}
