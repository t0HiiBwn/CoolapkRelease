package com.ss.android.a.a.b.a;

import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: DownloadCompletedListener */
public interface a {
    void a(c cVar, com.ss.android.a.a.b.a aVar, b bVar);

    void a(DownloadInfo downloadInfo);

    void a(DownloadInfo downloadInfo, BaseException baseException, String str);

    void a(DownloadInfo downloadInfo, String str);

    void b(DownloadInfo downloadInfo, String str);
}
