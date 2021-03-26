package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.a.a.a;
import com.ss.android.a.a.a.b;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.i;
import com.ss.android.a.a.a.r;
import com.ss.android.downloadlib.addownload.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: DownloadConfigureImpl */
class e implements a {
    e() {
    }

    @Override // com.ss.android.a.a.a
    public a a(h hVar) {
        k.a(hVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(f fVar) {
        k.a(fVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(com.ss.android.a.a.a.k kVar) {
        k.a(kVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(g gVar) {
        k.a(gVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(i iVar) {
        k.a(iVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(com.ss.android.a.a.c.a aVar) {
        k.a(aVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(String str) {
        k.a(str);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public a a(final b bVar) {
        k.a(bVar);
        com.ss.android.socialbase.downloader.a.a.a().a(new a.c() {
            /* class com.ss.android.downloadlib.e.AnonymousClass1 */

            @Override // com.ss.android.socialbase.downloader.a.a.c
            public boolean a() {
                return bVar.a();
            }
        });
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getChunkAdjustCalculator() == null) {
            downloaderBuilder.chunkAdjustCalculator(d.a());
        }
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new ah() {
                /* class com.ss.android.downloadlib.e.AnonymousClass2 */

                @Override // com.ss.android.socialbase.downloader.depend.ah
                public boolean b(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ah
                public boolean a(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                    if (a2.b("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.a(k.a(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(k.a()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean d = d(downloadInfo);
                    if (a2.a("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return d;
                }

                private boolean d(DownloadInfo downloadInfo) {
                    String str;
                    r q = k.q();
                    if (q == null) {
                        return false;
                    }
                    com.ss.android.downloadad.a.b.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a2 == null || !a2.c()) {
                        str = com.ss.android.downloadlib.addownload.i.a(downloadInfo);
                    } else {
                        str = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("ad_notification_jump_url", (String) null);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        return q.a(k.a(), str);
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ah
                public boolean c(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.a.b.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a2 != null) {
                        com.ss.android.downloadlib.b.a.a(a2);
                    } else {
                        com.ss.android.downloadlib.h.h.b(k.a(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                    return true;
                }
            });
        }
        if (downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
            downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.d.b());
        }
        Downloader.init(downloaderBuilder);
        return this;
    }
}
