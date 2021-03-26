package com.ss.android.downloadlib.g;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.b.c;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: AppInstallInvokeInterceptor */
public class a implements j {
    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, final i iVar) {
        a(downloadInfo, new com.ss.android.downloadlib.guide.install.a() {
            /* class com.ss.android.downloadlib.g.a.AnonymousClass1 */

            @Override // com.ss.android.downloadlib.guide.install.a
            public void a() {
                iVar.a();
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.a aVar) {
        b a = f.a().a(downloadInfo);
        if (a == null || !com.ss.android.downloadlib.b.i.a(a)) {
            b(downloadInfo, aVar);
        } else {
            TTDelegateActivity.a(a, new com.ss.android.downloadlib.guide.install.a() {
                /* class com.ss.android.downloadlib.g.a.AnonymousClass2 */

                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    a.this.b(downloadInfo, aVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.a aVar) {
        b a = f.a().a(downloadInfo);
        boolean a2 = com.ss.android.downloadlib.b.f.a(a);
        boolean b = com.ss.android.downloadlib.b.f.b(a);
        if (!a2 || !b) {
            aVar.a();
        } else {
            c.a(a, new com.ss.android.downloadlib.guide.install.a() {
                /* class com.ss.android.downloadlib.g.a.AnonymousClass3 */

                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    aVar.a();
                }
            });
        }
    }
}
