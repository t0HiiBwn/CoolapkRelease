package com.ss.android.socialbase.downloader.exception;

/* compiled from: DownloadHttpException */
public class b extends BaseException {
    private final int a;

    public b(int i, int i2, String str) {
        super(i, str);
        this.a = i2;
    }

    public int a() {
        return this.a;
    }
}
