package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.a;

/* compiled from: DownloadNotificationListener */
public class b extends d {
    private Context a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private a g;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = com.ss.android.socialbase.downloader.downloader.b.L();
        }
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public b(a aVar) {
        this.a = com.ss.android.socialbase.downloader.downloader.b.L();
        this.g = aVar;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d
    public a a() {
        Context context;
        a aVar = this.g;
        return (aVar != null || (context = this.a) == null) ? aVar : new a(context, this.b, this.c, this.d, this.e, this.f);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onPrepare(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onStart(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onPause(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onProgress(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo != null && this.a != null) {
            if (downloadInfo.canShowNotification() && !downloadInfo.isAutoInstallWithoutNotification()) {
                super.onSuccessed(downloadInfo);
            }
            com.ss.android.socialbase.appdownloader.f.a.a(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo != null && this.a != null && downloadInfo.canShowNotification() && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onFailed(downloadInfo, baseException);
        }
    }
}
