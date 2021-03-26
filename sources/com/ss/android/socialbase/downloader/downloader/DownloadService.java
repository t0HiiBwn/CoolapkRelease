package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.c.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class DownloadService extends Service {
    private static final String b = "DownloadService";
    protected n a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        n y = b.y();
        this.a = y;
        y.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.a != null);
        a.b(str, sb.toString());
        n nVar = this.a;
        if (nVar != null) {
            return nVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (a.a()) {
            a.b(b, "DownloadService onStartCommand");
        }
        this.a.c();
        ExecutorService l = b.l();
        if (l != null) {
            l.execute(new Runnable() {
                /* class com.ss.android.socialbase.downloader.downloader.DownloadService.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.a != null) {
                        DownloadService.this.a.a(intent, i, i2);
                    }
                }
            });
        }
        return b.j() ? 2 : 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (a.a()) {
            a.b(b, "Service onDestroy");
        }
        n nVar = this.a;
        if (nVar != null) {
            nVar.d();
            this.a = null;
        }
        super.onDestroy();
    }
}
