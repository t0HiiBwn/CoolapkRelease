package com.ss.android.downloadlib.f;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* compiled from: Monitor */
public class a {
    public static void a() {
        if (k.b) {
            throw new RuntimeException();
        }
    }

    public static void a(Throwable th) {
        if (!k.b) {
            th.printStackTrace();
            return;
        }
        throw new RuntimeException(th);
    }

    public static void a(long j, BaseException baseException) {
        if (!k.b) {
            com.ss.android.downloadlib.e.a.a().b(j, baseException);
            return;
        }
        throw new RuntimeException(baseException.getErrorMessage());
    }
}
