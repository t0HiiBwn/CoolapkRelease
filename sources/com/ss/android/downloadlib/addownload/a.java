package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.f.c;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* compiled from: AdDelayTaskManager */
public class a implements l.a {
    private static final String a = "a";
    private static a b;
    private l c = new l(Looper.getMainLooper(), this);
    private long d;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private a() {
    }

    public void a(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.b.a aVar = new com.ss.android.downloadlib.addownload.b.a((long) downloadInfo.getId(), j, j2, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        if (a2.a("back_miui_silent_install", 1) == 0 && ((c.k() || c.l()) && i.a(k.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (e.a(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.c.obtainMessage(200, aVar);
                obtainMessage.arg1 = 2;
                this.c.sendMessageDelayed(obtainMessage, (long) a2.a("check_silent_install_interval", 60000));
                return;
            }
            b d2 = f.a().d(aVar.b);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
            }
            k.g().a(null, new BaseException(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.e.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
        }
        if (k.r()) {
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            long t = k.t();
            if (currentTimeMillis < k.u()) {
                long u = k.u() - currentTimeMillis;
                t += u;
                this.d = System.currentTimeMillis() + u;
            } else {
                this.d = System.currentTimeMillis();
            }
            l lVar = this.c;
            lVar.sendMessageDelayed(lVar.obtainMessage(200, aVar), t);
        }
    }

    private void a(com.ss.android.downloadlib.addownload.b.a aVar, int i) {
        if (k.k() != null) {
            if ((!k.k().a() || k.s()) && aVar != null) {
                if (2 == i) {
                    b d2 = f.a().d(aVar.b);
                    JSONObject jSONObject = new JSONObject();
                    int i2 = -1;
                    try {
                        jSONObject.put("ttdownloader_type", "miui_silent_install");
                        if (k.d(k.a(), aVar.d)) {
                            jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                            i2 = 4;
                        } else {
                            jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                            i2 = 5;
                        }
                    } catch (Exception unused) {
                    }
                    k.g().a(null, new BaseException(i2, jSONObject.toString()), i2);
                    com.ss.android.downloadlib.e.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
                }
                if (k.d(k.a(), aVar.d)) {
                    com.ss.android.downloadlib.e.a.a().a("delayinstall_installed", aVar.b);
                } else if (!k.a(aVar.g)) {
                    com.ss.android.downloadlib.e.a.a().a("delayinstall_file_lost", aVar.b);
                } else if (com.ss.android.downloadlib.addownload.a.a.a().a(aVar.d)) {
                    com.ss.android.downloadlib.e.a.a().a("delayinstall_conflict_with_back_dialog", aVar.b);
                } else {
                    com.ss.android.downloadlib.e.a.a().a("delayinstall_install_start", aVar.b);
                    d.a(k.a(), (int) aVar.a);
                }
            }
        }
    }

    @Override // com.ss.android.downloadlib.h.l.a
    public void a(Message message) {
        if (message.what == 200) {
            a((com.ss.android.downloadlib.addownload.b.a) message.obj, message.arg1);
        }
    }
}
