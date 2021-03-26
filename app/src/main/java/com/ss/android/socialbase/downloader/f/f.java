package com.ss.android.socialbase.downloader.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.model.d;

/* compiled from: ISegmentCallback */
interface f {
    i a(m mVar, q qVar);

    void a(m mVar);

    void a(m mVar, i iVar);

    void a(m mVar, i iVar, q qVar, d dVar) throws BaseException, h;

    void a(m mVar, q qVar, i iVar, BaseException baseException);

    void a(m mVar, q qVar, i iVar, BaseException baseException, int i, int i2);

    void b(m mVar);

    void b(m mVar, i iVar) throws BaseException;

    void c(m mVar, i iVar);

    e d(m mVar, i iVar) throws BaseException;
}
