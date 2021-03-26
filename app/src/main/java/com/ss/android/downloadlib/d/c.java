package com.ss.android.downloadlib.d;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.e.a;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AppDownloadLaunchResumeListener */
public class c implements g, k {
    @Override // com.ss.android.socialbase.downloader.depend.k
    public void a() {
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo != null) {
            a(downloadInfo, downloadInfo.getRealStatus(), z);
        }
    }

    public void a(DownloadInfo downloadInfo, int i, boolean z) {
        f.a().b();
        b a = f.a().a(downloadInfo);
        if (a == null) {
            com.ss.android.downloadlib.h.k.b();
            return;
        }
        if (z) {
            try {
                a.c(downloadInfo.getFailedResumeCount());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else if (a.C() != -1) {
            a.c(-1);
        } else {
            return;
        }
        i.a().a(a);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("download_id", downloadInfo.getId());
        jSONObject.put("name", downloadInfo.getName());
        jSONObject.put("url", downloadInfo.getUrl());
        jSONObject.put("download_time", downloadInfo.getDownloadTime());
        jSONObject.put("download_status", i);
        jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
        jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
        int i2 = 1;
        jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
        jSONObject.put("chunk_count", downloadInfo.getChunkCount());
        if (!z) {
            i2 = 2;
        }
        jSONObject.put("launch_resumed", i2);
        jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
        a.a().a("embeded_ad", "download_uncompleted", jSONObject, a);
    }

    @Override // com.ss.android.socialbase.downloader.depend.k
    public void b() {
        d.a().a(new Runnable() {
            /* class com.ss.android.downloadlib.d.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                f.a().b();
                for (b bVar : f.a().c().values()) {
                    int s = bVar.s();
                    if (s != 0) {
                        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(s);
                        if (a2.b("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(s)) != null) {
                            if (com.ss.android.downloadlib.h.k.b(bVar) && !com.ss.android.downloadlib.h.k.c(bVar.e())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < a2.a("noti_open_restart_times", 3)) {
                                    g.a().e(bVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < a2.a("noti_continue_restart_times", 3)) {
                                    g.a().a(bVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && e.c(downloadInfo) && !com.ss.android.downloadlib.h.k.b(bVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < a2.a("noti_install_restart_times", 3)) {
                                g.a().c(bVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000);
    }
}
