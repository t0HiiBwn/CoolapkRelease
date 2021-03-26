package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: DownloadNotificationManager */
public class b {
    private static volatile b c;
    private static final Object e = new Object();
    private final long a = 1000;
    private final Map<Integer, Long> b = new HashMap();
    private final Set<String> d = new HashSet();
    private final SparseArray<a> f = new SparseArray<>();

    static boolean b(int i) {
        return i == 1 || i == 3;
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public void a(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.b.L()).getDownloadInfo(i);
        if (downloadInfo != null) {
            a(downloadInfo);
            b(downloadInfo);
        }
    }

    void a(DownloadInfo downloadInfo) {
        i x = com.ss.android.socialbase.downloader.downloader.b.x();
        if (x != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                x.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    void b(DownloadInfo downloadInfo) {
        if (c(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility());
    }

    public void a(int i, int i2, Notification notification) {
        Context L = com.ss.android.socialbase.downloader.downloader.b.L();
        if (L != null && i != 0 && notification != null) {
            if (i2 == 4) {
                synchronized (this.b) {
                    Long l = this.b.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null || Math.abs(currentTimeMillis - l.longValue()) >= 1000) {
                        this.b.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                    } else {
                        return;
                    }
                }
            }
            try {
                Intent intent = new Intent(L, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
                intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
                L.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(int i) {
        Context L = com.ss.android.socialbase.downloader.downloader.b.L();
        if (L != null && i != 0) {
            try {
                Intent intent = new Intent(L, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                L.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.f) {
                this.f.put(aVar.a(), aVar);
            }
        }
    }

    public a d(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(i);
            if (aVar != null) {
                this.f.remove(i);
                a.a("removeNotificationId " + i);
            }
        }
        return aVar;
    }

    public a e(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(i);
        }
        return aVar;
    }

    SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f) {
            sparseArray = this.f;
        }
        return sparseArray;
    }

    public void f(int i) {
        d(i);
        if (i != 0) {
            a().c(i);
        }
    }
}
