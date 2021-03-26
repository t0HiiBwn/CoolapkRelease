package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.a = b.z();
        this.a.a(new WeakReference(this));
    }
}
