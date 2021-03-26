package com.ss.android.downloadlib.d;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.h.f;
import com.ss.android.socialbase.appdownloader.e.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* compiled from: NotificationPusher */
public class g {

    /* compiled from: NotificationPusher */
    private static class a {
        private static g a = new g();
    }

    public static g a() {
        return a.a;
    }

    private g() {
    }

    public void a(b bVar) {
        b(bVar, 5);
    }

    public void b(b bVar) {
        if (bVar != null) {
            b(bVar, (long) com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_continue_delay_secs", 5));
        }
    }

    private void b(final b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") == 1) {
            a(s);
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.d.g.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                    JSONObject jSONObject = new JSONObject();
                    com.ss.android.downloadlib.h.k.a(jSONObject, "ttdownloader_type", (Object) 1);
                    f.c(downloadInfo, jSONObject);
                    if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                        com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", (Object) 1001);
                    } else {
                        g.this.a(s, bVar, jSONObject);
                    }
                    com.ss.android.downloadlib.e.a.a().a("download_notification_try_show", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                }
            }, j * 1000);
        }
    }

    public void c(b bVar) {
        c(bVar, 5);
    }

    public void d(b bVar) {
        c(bVar, (long) com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_install_delay_secs", 5));
    }

    private void c(final b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") == 1) {
            a(s);
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.d.g.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                    JSONObject jSONObject = new JSONObject();
                    com.ss.android.downloadlib.h.k.a(jSONObject, "ttdownloader_type", (Object) 2);
                    f.c(downloadInfo, jSONObject);
                    if (com.ss.android.downloadlib.h.k.b(bVar)) {
                        com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", (Object) 1002);
                    } else {
                        g.this.a(s, bVar, jSONObject);
                    }
                    com.ss.android.downloadlib.e.a.a().a("download_notification_try_show", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                }
            }, j * 1000);
        }
    }

    public void e(b bVar) {
        a(bVar, 5);
    }

    public void f(b bVar) {
        a(bVar, (long) com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_open_delay_secs", 5));
    }

    public void a(final b bVar, long j) {
        final int s = bVar.s();
        if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") == 1) {
            a(s);
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.d.g.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s);
                    JSONObject jSONObject = new JSONObject();
                    com.ss.android.downloadlib.h.k.a(jSONObject, "ttdownloader_type", (Object) 3);
                    f.c(downloadInfo, jSONObject);
                    if (com.ss.android.downloadlib.h.k.c(bVar.e())) {
                        com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", (Object) 1003);
                    } else {
                        g.this.a(s, bVar, jSONObject);
                    }
                    com.ss.android.downloadlib.e.a.a().a("download_notification_try_show", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                }
            }, j * 1000);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, b bVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.e.d.a()) {
            com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i);
        if (downloadInfo == null) {
            com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.b.a().e(i) != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(i);
        }
        com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(k.a(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        aVar.a(downloadInfo.getCurBytes());
        aVar.b(downloadInfo.getTotalBytes());
        aVar.a(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
        aVar.a((BaseException) null, false);
        com.ss.android.downloadlib.e.a.a().a("download_notification_show", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
    }

    public void a(int i) {
        DownloadInfo downloadInfo;
        if (c.a().a(i) == null && (downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i)) != null) {
            c.a().a(i, downloadInfo.getIconUrl());
        }
    }
}
