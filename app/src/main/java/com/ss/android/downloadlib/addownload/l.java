package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.e.a;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReserveWifiStatusImpl */
public class l implements p {
    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(DownloadInfo downloadInfo, int i, int i2) {
        b a = f.a().a(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("pause_reserve_wifi", jSONObject, a);
    }
}
