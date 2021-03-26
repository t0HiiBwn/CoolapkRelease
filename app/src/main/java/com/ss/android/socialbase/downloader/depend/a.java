package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: AbsDownloadExtListener */
public abstract class a extends AbsDownloadListener implements s {
    private static final String a = "a";

    @Override // com.ss.android.socialbase.downloader.depend.s
    public void a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
        }
    }
}
