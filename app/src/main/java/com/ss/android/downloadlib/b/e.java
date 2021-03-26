package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.d;
import com.ss.android.socialbase.downloader.a.a;

/* compiled from: AppLinkMonitor */
public class e implements a.AbstractC0092a {
    private long a;

    /* compiled from: AppLinkMonitor */
    private static class a {
        private static e a = new e(null);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
    public void c() {
    }

    /* synthetic */ e(AnonymousClass1 r1) {
        this();
    }

    public static e a() {
        return a.a;
    }

    private e() {
        this.a = 0;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
    public void b() {
        this.a = System.currentTimeMillis();
    }

    /* renamed from: com.ss.android.downloadlib.b.e$1  reason: invalid class name */
    /* compiled from: AppLinkMonitor */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ d b;
        final /* synthetic */ e c;

        @Override // java.lang.Runnable
        public void run() {
            if (!com.ss.android.socialbase.downloader.a.a.a().b() || System.currentTimeMillis() - this.c.a <= this.a) {
                this.b.a(true);
            } else {
                this.b.a(false);
            }
        }
    }

    public void a(String str, d dVar) {
        a(str, dVar, 5000);
    }

    public void a(final String str, final d dVar, long j) {
        if (dVar != null) {
            int optInt = k.i().optInt("check_applink_result_delay");
            if (optInt > 0) {
                j = (long) (optInt * 1000);
            }
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.b.e.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (com.ss.android.downloadlib.h.k.c(str)) {
                        dVar.a(true);
                    } else {
                        dVar.a(false);
                    }
                }
            }, j);
        }
    }
}
