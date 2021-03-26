package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* compiled from: AbsDownloadServiceHandler */
public abstract class a implements n {
    private static final String e = "a";
    protected final SparseArray<DownloadTask> a = new SparseArray<>();
    protected volatile boolean b = false;
    protected volatile boolean c;
    protected volatile boolean d = false;
    private WeakReference<Service> f;
    private Handler g = new Handler(Looper.getMainLooper());
    private Runnable h = new Runnable() {
        /* class com.ss.android.socialbase.downloader.downloader.a.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.e, "tryDownload: 2 try");
            }
            if (!a.this.b) {
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    com.ss.android.socialbase.downloader.c.a.b(a.e, "tryDownload: 2 error");
                }
                a.this.a(b.L(), (ServiceConnection) null);
            }
        }
    };

    protected void a(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(m mVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(WeakReference weakReference) {
        this.f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        String str = e;
        com.ss.android.socialbase.downloader.c.a.c(str, "isServiceForeground = " + this.c);
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public IBinder a(Intent intent) {
        com.ss.android.socialbase.downloader.c.a.b(e, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f;
        if (weakReference == null || weakReference.get() == null) {
            com.ss.android.socialbase.downloader.c.a.d(e, "startForeground: downloadService is null, do nothing!");
            return;
        }
        String str = e;
        com.ss.android.socialbase.downloader.c.a.c(str, "startForeground  id = " + i + ", service = " + this.f.get() + ",  isServiceAlive = " + this.b);
        try {
            this.f.get().startForeground(i, notification);
            this.c = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f;
        if (weakReference != null && weakReference.get() != null) {
            String str = e;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopForeground  service = " + this.f.get() + ",  isServiceAlive = " + this.b);
            try {
                this.c = false;
                this.f.get().stopForeground(z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        this.b = false;
    }

    public void a(DownloadTask downloadTask) {
        if (downloadTask != null) {
            String str = e;
            com.ss.android.socialbase.downloader.c.a.b(str, "pendDownloadTask pendingTasks.size:" + this.a.size() + " downloadTask.getDownloadId():" + downloadTask.getDownloadId());
            if (this.a.get(downloadTask.getDownloadId()) == null) {
                synchronized (this.a) {
                    if (this.a.get(downloadTask.getDownloadId()) == null) {
                        this.a.put(downloadTask.getDownloadId(), downloadTask);
                    }
                }
            }
            com.ss.android.socialbase.downloader.c.a.b(str, "after pendDownloadTask pendingTasks.size:" + this.a.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(DownloadTask downloadTask) {
        if (downloadTask != null) {
            if (!this.b) {
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    com.ss.android.socialbase.downloader.c.a.b(e, "tryDownload but service is not alive");
                }
                if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
                    synchronized (this.a) {
                        a(downloadTask);
                        if (!this.d) {
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                com.ss.android.socialbase.downloader.c.a.b(e, "tryDownload: 1");
                            }
                            a(b.L(), (ServiceConnection) null);
                            this.d = true;
                        } else {
                            this.g.removeCallbacks(this.h);
                            this.g.postDelayed(this.h, 10);
                        }
                    }
                    return;
                }
                a(downloadTask);
                a(b.L(), (ServiceConnection) null);
                return;
            }
            if (this.a.get(downloadTask.getDownloadId()) != null) {
                synchronized (this.a) {
                    if (this.a.get(downloadTask.getDownloadId()) != null) {
                        this.a.remove(downloadTask.getDownloadId());
                    }
                }
            }
            com.ss.android.socialbase.downloader.impls.a C = b.C();
            if (C != null) {
                C.a(downloadTask);
            }
            e();
        }
    }

    protected void e() {
        SparseArray<DownloadTask> clone;
        String str = e;
        com.ss.android.socialbase.downloader.c.a.b(str, "resumePendingTask pendingTasks.size:" + this.a.size());
        synchronized (this.a) {
            clone = this.a.clone();
            this.a.clear();
        }
        com.ss.android.socialbase.downloader.impls.a C = b.C();
        if (C != null) {
            for (int i = 0; i < clone.size(); i++) {
                DownloadTask downloadTask = clone.get(clone.keyAt(i));
                if (downloadTask != null) {
                    C.a(downloadTask);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        com.ss.android.socialbase.downloader.c.a.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (!this.b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(e, "startService");
            }
            a(b.L(), (ServiceConnection) null);
        }
    }
}
