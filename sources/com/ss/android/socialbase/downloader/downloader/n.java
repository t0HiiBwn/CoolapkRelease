package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* compiled from: IDownloadServiceHandler */
public interface n<T extends DownloadService> {
    IBinder a(Intent intent);

    void a(int i);

    void a(int i, Notification notification);

    void a(Intent intent, int i, int i2);

    void a(m mVar);

    void a(WeakReference<T> weakReference);

    void a(boolean z);

    boolean a();

    void b(DownloadTask downloadTask);

    boolean b();

    void c();

    void c(DownloadTask downloadTask);

    void d();

    void f();
}
