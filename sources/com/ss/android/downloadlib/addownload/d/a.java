package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.c;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ApkSizeInterceptor */
public class a implements d {
    private static c a;

    public static c a() {
        return a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(final b bVar, int i, final c cVar) {
        DownloadInfo a2;
        if (bVar == null || bVar.ab() || !a(bVar) || (a2 = g.a((Context) null).a(bVar.a())) == null) {
            return false;
        }
        long a3 = j.a(a2.getId(), a2.getCurBytes(), a2.getTotalBytes());
        long totalBytes = a2.getTotalBytes();
        if (a3 <= 0 || totalBytes <= 0 || totalBytes > ((long) a(bVar.s()))) {
            return false;
        }
        a = new c() {
            /* class com.ss.android.downloadlib.addownload.d.a.AnonymousClass1 */

            @Override // com.ss.android.downloadlib.addownload.a.c
            public void a() {
                c unused = a.a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.c
            public void b() {
                c unused = a.a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                cVar.a(bVar);
            }
        };
        TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", a(totalBytes - a3)), "继续", "暂停");
        bVar.n(true);
        return true;
    }

    private int a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean a(com.ss.android.downloadad.a.b.a aVar) {
        if (e.a(aVar).a("pause_optimise_apk_size_switch", 0) != 1 || !aVar.q()) {
            return false;
        }
        return true;
    }

    private static String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        } else if (j >= 1048576) {
            return (j / 1048576) + "M";
        } else {
            return decimalFormat.format((double) (((float) j) / 1048576.0f)) + "M";
        }
    }
}
