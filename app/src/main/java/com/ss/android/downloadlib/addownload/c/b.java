package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.h.e;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CleanSpaceTask */
public class b implements Runnable {
    private DownloadInfo a;

    public b(DownloadInfo downloadInfo) {
        this.a = downloadInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = com.ss.android.downloadlib.addownload.b.f.a().a(r12.a);
     */
    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.a.b.b a2;
        if (this.a != null && a2 != null) {
            a.a().a("cleanspace_task", a2);
            long longValue = Double.valueOf((e.a(this.a.getId()) + 1.0d) * ((double) this.a.getTotalBytes())).longValue() - this.a.getCurBytes();
            long a3 = k.a(0);
            if (com.ss.android.downloadlib.addownload.k.l() != null) {
                com.ss.android.downloadlib.addownload.k.l().e();
            }
            c.a();
            c.b();
            if (e.g(a2.s())) {
                c.a(com.ss.android.downloadlib.addownload.k.a());
            }
            long a4 = k.a(0);
            if (a4 >= longValue) {
                a2.l("1");
                i.a().a(a2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("quite_clean_size", Long.valueOf(a4 - a3));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a.a().a("cleanspace_download_after_quite_clean", jSONObject, a2);
                Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).restart(this.a.getId());
            } else if (com.ss.android.downloadlib.addownload.k.l() != null) {
                a2.d(false);
                d.a().a(a2.a(), new e() {
                    /* class com.ss.android.downloadlib.addownload.c.b.AnonymousClass1 */
                });
                if (com.ss.android.downloadlib.addownload.k.l().a(this.a.getId(), this.a.getUrl(), true, longValue)) {
                    a2.e(true);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a.a().a("cleanspace_window_show", jSONObject2, a2);
            }
        }
    }
}
