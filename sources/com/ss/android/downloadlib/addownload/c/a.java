package com.ss.android.downloadlib.addownload.c;

import com.ss.android.a.a.a.e;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: AppDownloadDiskSpaceHandler */
public class a implements r {
    private int a;

    public void a(int i) {
        this.a = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j, long j2, q qVar) {
        long j3;
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(this.a);
        if (!a(a2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d.a().c();
        long a3 = k.a(0);
        a();
        long a4 = k.a(0);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (a4 < j2) {
            long b = b(a2);
            if (b > 0) {
                a4 = k.a(0);
            }
            j3 = b;
        } else {
            j3 = 0;
        }
        j.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + a4 + ", cleaned = " + (a4 - a3), null);
        a(a3, a4, j2, currentTimeMillis2, j3);
        if (a4 < j2) {
            return false;
        }
        if (qVar == null) {
            return true;
        }
        qVar.a();
        return true;
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().b() >= aVar.a("clear_space_min_time_interval", 600000);
    }

    private void a() {
        e o = com.ss.android.downloadlib.addownload.k.o();
        if (o != null) {
            o.a();
        }
        c.a();
        c.b();
    }

    private long b(com.ss.android.socialbase.downloader.g.a aVar) {
        long a2 = aVar.a("clear_space_sleep_time", 0L);
        if (a2 <= 0) {
            return 0;
        }
        if (a2 > 5000) {
            a2 = 5000;
        }
        j.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + a2, null);
        try {
            Thread.sleep(a2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return a2;
    }

    private void a(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(this.a);
        if (downloadInfo != null) {
            try {
                com.ss.android.downloadlib.a.a().a(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
