package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownloadComponentManager */
public class d {
    private ExecutorService a;
    private ExecutorService b;
    private ScheduledExecutorService c;

    /* compiled from: DownloadComponentManager */
    private static class a {
        private static d a = new d();
    }

    public static d a() {
        return a.a;
    }

    private d() {
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable) {
        b(runnable, false);
    }

    public void a(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (!z || k.a()) {
                b().execute(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void b(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (!z || k.a()) {
                c().execute(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void a(Runnable runnable, long j) {
        try {
            d().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ExecutorService b() {
        if (this.a == null) {
            synchronized (d.class) {
                if (this.a == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.a;
    }

    public ExecutorService c() {
        if (this.b == null) {
            synchronized (d.class) {
                if (this.b == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.b;
    }

    public ScheduledExecutorService d() {
        if (this.c == null) {
            synchronized (d.class) {
                if (this.c == null) {
                    this.c = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.c;
    }

    public void e() {
        a(new Runnable() {
            /* class com.ss.android.downloadlib.d.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (d.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferences = com.ss.android.downloadlib.addownload.k.a().getSharedPreferences(strArr[i], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        i x = b.x();
                        if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
                            SparseArray<DownloadInfo> a2 = ((com.ss.android.socialbase.downloader.impls.d) x).a().a();
                            for (int size = a2.size() - 1; size >= 0; size--) {
                                DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                                if (downloadInfo != null) {
                                    Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).clearDownloadData(downloadInfo.getId());
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
