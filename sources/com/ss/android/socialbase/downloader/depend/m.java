package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: IDownloadCompleteHandler */
public interface m {
    void a(DownloadInfo downloadInfo) throws BaseException;

    boolean b(DownloadInfo downloadInfo);
}
