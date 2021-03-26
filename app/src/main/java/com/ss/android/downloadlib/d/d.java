package com.ss.android.downloadlib.d;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.d.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* compiled from: InnerEventListenerImpl */
public class d implements c {
    @Override // com.ss.android.socialbase.downloader.d.c
    public void a(int i, String str, JSONObject jSONObject) {
        b a;
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i);
        if (downloadInfo != null && (a = f.a().a(downloadInfo)) != null) {
            if ("install_view_result".equals(str)) {
                jSONObject = com.ss.android.downloadlib.h.k.a(jSONObject);
                a.a(jSONObject, downloadInfo);
                com.ss.android.downloadlib.h.k.a(jSONObject, "model_id", Long.valueOf(a.b()));
            }
            com.ss.android.downloadlib.e.a.a().a(str, jSONObject, (com.ss.android.downloadad.a.b.a) a);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.c
    public void b(int i, String str, JSONObject jSONObject) {
        b a;
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i);
        if (downloadInfo != null && (a = f.a().a(downloadInfo)) != null) {
            com.ss.android.downloadlib.e.a.a().a(str, jSONObject, a);
        }
    }
}
