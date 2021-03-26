package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.d;

/* compiled from: AppInstallFinishInterceptor */
public class b {
    public void a(final com.ss.android.downloadad.a.b.b bVar, final g gVar, int i) {
        d.a().a(new Runnable() {
            /* class com.ss.android.downloadlib.b.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (i.a(bVar)) {
                    gVar.a(false);
                } else if (!f.a(bVar)) {
                    gVar.a(false);
                } else {
                    f.a(bVar, new h() {
                        /* class com.ss.android.downloadlib.b.b.AnonymousClass1.AnonymousClass1 */

                        @Override // com.ss.android.downloadlib.b.h
                        public void a(boolean z) {
                            gVar.a(z);
                        }
                    });
                }
            }
        }, (long) i);
    }
}
