package com.ss.android.socialbase.downloader.impls;

/* compiled from: DownloadProxy */
public class l {
    private static volatile com.ss.android.socialbase.downloader.downloader.l a;
    private static volatile com.ss.android.socialbase.downloader.downloader.l b;

    public static com.ss.android.socialbase.downloader.downloader.l a(boolean z) {
        if (z) {
            if (b == null) {
                synchronized (l.class) {
                    if (b == null) {
                        b = new o();
                    }
                }
            }
            return b;
        }
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }
}
