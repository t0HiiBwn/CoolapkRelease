package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.c;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadPercentInterceptor */
public class b implements d {
    private static c a;

    public static c a() {
        return a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(final com.ss.android.downloadad.a.b.b bVar, int i, final c cVar) {
        DownloadInfo a2;
        if (bVar == null || bVar.ac() || !a(bVar) || (a2 = g.a((Context) null).a(bVar.a())) == null) {
            return false;
        }
        long curBytes = a2.getCurBytes();
        long totalBytes = a2.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int a3 = j.a(a2.getId(), (int) ((curBytes * 100) / totalBytes));
            if (a3 > a(bVar.s())) {
                a = new c() {
                    /* class com.ss.android.downloadlib.addownload.d.b.AnonymousClass1 */

                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void a() {
                        c unused = b.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void b() {
                        c unused = b.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                        cVar.a(bVar);
                    }
                };
                TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a3)), "继续", "暂停");
                bVar.o(true);
                return true;
            }
        }
        return false;
    }

    private int a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_download_percent", 50);
    }

    private boolean a(com.ss.android.downloadad.a.b.a aVar) {
        if (e.a(aVar).a("pause_optimise_download_percent_switch", 0) != 1 || !aVar.q()) {
            return false;
        }
        return true;
    }
}
