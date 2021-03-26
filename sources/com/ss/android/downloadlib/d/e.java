package com.ss.android.downloadlib.d;

import android.content.Context;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* compiled from: NewDownloadCompletedEventDispatcher */
public class e implements d {
    private Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        a.a().a(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        Context context = this.a;
        if (context != null && (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) != null && downloadInfo.getStatus() != 0) {
            b a2 = f.a().a(downloadInfo);
            if (a2 == null) {
                k.b();
            } else if (i2 == 1) {
                a.a(downloadInfo, a2);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    com.ss.android.downloadlib.addownload.a.a().a(downloadInfo, a2.b(), a2.l(), a2.e(), downloadInfo.getTitle(), a2.d(), downloadInfo.getTargetFilePath());
                }
            } else if (i2 == 3) {
                com.ss.android.downloadlib.e.a.a().a("download_notification", "download_notification_install", a.b(new JSONObject(), downloadInfo), a2);
            } else if (i2 == 5) {
                com.ss.android.downloadlib.e.a.a().a("download_notification", "download_notification_pause", a2);
            } else if (i2 == 6) {
                com.ss.android.downloadlib.e.a.a().a("download_notification", "download_notification_continue", a2);
            } else if (i2 == 7) {
                com.ss.android.downloadlib.e.a.a().a("download_notification", "download_notification_click", a2);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i, boolean z) {
        if (com.ss.android.downloadlib.addownload.k.n() != null) {
            return com.ss.android.downloadlib.addownload.k.n().a(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            com.ss.android.downloadlib.f.a().a(downloadInfo);
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("report_download_cancel", 1) == 1) {
                com.ss.android.downloadlib.e.a.a().a(downloadInfo, new BaseException(1012, ""));
            } else {
                com.ss.android.downloadlib.e.a.a().b(downloadInfo, new BaseException(1012, ""));
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.a;
        if (context != null && (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) != null && downloadInfo.getStatus() == -3) {
            downloadInfo.setPackageName(str2);
            com.ss.android.downloadlib.addownload.b.a().a(this.a, downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        return com.ss.android.downloadlib.addownload.b.a().b();
    }
}
