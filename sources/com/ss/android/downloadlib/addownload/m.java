package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.c;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.h.e;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* compiled from: ReverseWifiHelper */
public class m {
    private static c a;

    public static boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static c a() {
        return a;
    }

    public static void a(c cVar) {
        a = cVar;
    }

    public static boolean a(final b bVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.d.c cVar) {
        if (bVar == null || downloadInfo == null) {
            k.b();
            return false;
        }
        final int id = downloadInfo.getId();
        boolean b = e.b(bVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(b ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
        if (!b || !a(i)) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.i.e.b(k.a())) {
            if (downloadInfo.isPauseReserveOnWifi()) {
                downloadInfo.stopPauseReserveOnWifi();
                a.a().a("pause_reserve_wifi_cancel_on_wifi", (com.ss.android.downloadad.a.b.a) bVar);
            }
        } else if (!downloadInfo.hasPauseReservedOnWifi()) {
            a(new c() {
                /* class com.ss.android.downloadlib.addownload.m.AnonymousClass1 */

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    m.a((c) null);
                    DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(id);
                    if (downloadInfo != null) {
                        downloadInfo.startPauseReserveOnWifi();
                        r.a().a(downloadInfo);
                        a.a().a("pause_reserve_wifi_confirm", (com.ss.android.downloadad.a.b.a) bVar);
                    }
                    cVar.a(bVar);
                }

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void b() {
                    m.a((c) null);
                    DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(id);
                    if (downloadInfo != null) {
                        downloadInfo.stopPauseReserveOnWifi();
                    }
                    a.a().a("pause_reserve_wifi_cancel", (com.ss.android.downloadad.a.b.a) bVar);
                    cVar.a(bVar);
                }
            });
            TTDelegateActivity.b(bVar);
            return true;
        }
        return false;
    }
}
