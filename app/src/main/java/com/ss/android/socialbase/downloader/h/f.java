package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.model.b;

/* compiled from: IDownloadRunnableCallback */
public interface f {
    g a(BaseException baseException, long j);

    g a(b bVar, BaseException baseException, long j);

    b a(int i);

    void a(long j) throws BaseException;

    void a(BaseException baseException, boolean z);

    void a(b bVar);

    void a(com.ss.android.socialbase.downloader.network.g gVar);

    void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j) throws BaseException, h;

    boolean a(BaseException baseException);

    void b(BaseException baseException);

    boolean b(long j) throws BaseException;

    void c(BaseException baseException);
}
