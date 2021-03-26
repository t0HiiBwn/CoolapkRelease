package com.ss.android.downloadlib.b;

import android.os.Build;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.a.a;

/* compiled from: AppInstallOptimiseHelper */
public class c {
    public static void a(final b bVar, final a aVar) {
        boolean b = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!b && Build.VERSION.SDK_INT >= 29) {
            k.c();
        }
        boolean b2 = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!b && b2 && bVar != null) {
            bVar.l(true);
        }
        aVar.a();
        com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + b2);
        if (!b2) {
            com.ss.android.socialbase.downloader.a.a.a().a(new a.AbstractC0102a() {
                /* class com.ss.android.downloadlib.b.c.AnonymousClass1 */

                @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
                public void c() {
                }

                @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
                public void b() {
                    com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                    com.ss.android.socialbase.downloader.a.a.a().b(this);
                    if (!k.b(bVar)) {
                        bVar.m(true);
                        com.ss.android.downloadlib.e.a.a().a("install_delay_invoke", bVar);
                        aVar.a();
                    }
                }
            });
        }
    }
}
