package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: AbsNotificationItem */
public abstract class a {
    protected Notification a;
    private int b;
    private long c;
    private long d;
    private String e;
    private int f = 0;
    private long g;
    private int h;
    private boolean i;

    public abstract void a(BaseException baseException, boolean z);

    public a(int i2, String str) {
        this.b = i2;
        this.e = str;
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            this.b = downloadInfo.getId();
            this.e = downloadInfo.getTitle();
        }
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public long c() {
        return this.d;
    }

    public void b(long j) {
        this.d = j;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f != i2) {
            this.f = i2;
            a(baseException, z);
        }
    }

    public long f() {
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
        return this.g;
    }

    public void a(long j, long j2) {
        this.c = j;
        this.d = j2;
        this.f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.b != 0 && notification != null) {
            b.a().a(this.b, this.f, notification);
        }
    }

    public synchronized void g() {
        this.h++;
    }

    public int h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    protected void a(boolean z) {
        this.i = z;
    }
}
