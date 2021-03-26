package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.downloader.a;

/* compiled from: DefaultDownloadServiceHandler */
public class h extends a {
    private static final String e = "h";

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void c() {
        if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
            this.b = true;
            this.d = false;
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(e, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(e, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.i.a.a(262144)) {
            this.b = true;
        }
        e();
    }
}
