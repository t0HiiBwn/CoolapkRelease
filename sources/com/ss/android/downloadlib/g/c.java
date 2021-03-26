package com.ss.android.downloadlib.g;

import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BeforeAppInstallInterceptorManager */
public class c implements j {
    private static volatile c a;
    private List<j> b;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private c() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new b());
        this.b.add(new a());
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        if (downloadInfo != null && this.b.size() != 0) {
            a(downloadInfo, 0, iVar);
        } else if (iVar != null) {
            iVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void a(final DownloadInfo downloadInfo, final int i, final i iVar) {
        if (i == this.b.size() || i < 0) {
            iVar.a();
        } else {
            this.b.get(i).a(downloadInfo, new i() {
                /* class com.ss.android.downloadlib.g.c.AnonymousClass1 */

                @Override // com.ss.android.socialbase.appdownloader.c.i
                public void a() {
                    c.this.a(downloadInfo, i + 1, iVar);
                }
            });
        }
    }
}
