package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.a.a.a;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.a.s;
import com.ss.android.downloadad.a.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.d.c;
import com.ss.android.downloadlib.d.e;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: TTDownloader */
public class g {
    private static volatile g a;
    private final a b = new e();
    private final f c = f.a();
    private final com.ss.android.downloadad.a.a d;
    private b e;
    private long f = System.currentTimeMillis();

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    private g(Context context) {
        b(context);
        this.d = a.a();
    }

    private void b(Context context) {
        k.a(context);
        Downloader.getInstance(k.a());
        f.a().b();
        d.j().a(k.a(), "misc_config", new com.ss.android.downloadlib.d.f(), new e(context), new c());
        c cVar = new c();
        d.j().a(cVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(cVar);
        d.j().a(new l());
        com.ss.android.socialbase.downloader.downloader.b.a(new com.ss.android.downloadlib.d.d());
        d.j().a(com.ss.android.downloadlib.g.c.a());
        d.a().a(new Runnable() {
            /* class com.ss.android.downloadlib.g.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.d.a(k.a());
            }
        }, 5000);
    }

    public a a() {
        return this.b;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.a.a d() {
        return this.d;
    }

    public b e() {
        if (this.e == null) {
            this.e = b.a();
        }
        return this.e;
    }

    private f h() {
        return this.c;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        h().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, s sVar, n nVar) {
        h().a(str, j, i, bVar, aVar, sVar, nVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        h().a(str, j, i, bVar, aVar);
    }

    public void a(String str, int i) {
        h().a(str, i);
    }

    public void a(String str, boolean z) {
        h().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        h().a(aVar);
    }

    public String f() {
        return k.m();
    }

    public void g() {
        d.a().e();
    }

    public DownloadInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.j().a(k.a(), str);
    }
}
