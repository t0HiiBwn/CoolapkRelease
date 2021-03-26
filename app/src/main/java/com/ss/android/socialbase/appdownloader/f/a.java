package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* compiled from: AppInstallUtils */
public class a {
    public static void a(DownloadInfo downloadInfo) {
        b(downloadInfo);
    }

    private static void b(final DownloadInfo downloadInfo) {
        final Context L = b.L();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || c.b(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int a = z ? c.a(L, downloadInfo.getId(), false) : 2;
        b.l().execute(new Runnable() {
            /* class com.ss.android.socialbase.appdownloader.f.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                ab downloadNotificationEventListener = Downloader.getInstance(L).getDownloadNotificationEventListener(downloadInfo.getId());
                if (b2 != null || downloadNotificationEventListener != null) {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        try {
                            PackageInfo a2 = c.a(downloadInfo, file);
                            if (a2 != null) {
                                String packageName = (a == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? a2.packageName : downloadInfo.getPackageName();
                                if (b2 != null) {
                                    b2.a(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                                }
                                if (downloadNotificationEventListener != null) {
                                    downloadNotificationEventListener.a(1, downloadInfo, packageName, "");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
