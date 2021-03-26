package com.ss.android.downloadlib.e;

import android.os.Build;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.c.d;
import com.ss.android.downloadad.a.a.c;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventHandler */
public class a {

    /* renamed from: com.ss.android.downloadlib.e.a$a  reason: collision with other inner class name */
    /* compiled from: AdEventHandler */
    private static class C0096a {
        private static a a = new a();
    }

    public static a a() {
        return C0096a.a;
    }

    private a() {
    }

    public void a(long j, int i) {
        e e = f.a().e(j);
        if (e.w()) {
            k.b();
        } else if (e.c.l()) {
            int i2 = 1;
            b bVar = e.c;
            String c = i == 1 ? bVar.c() : bVar.b();
            String a = k.a(e.c.d(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.i.e.c(com.ss.android.downloadlib.addownload.k.a())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(c, a, jSONObject, e);
            if ("click".equals(a) && e.b != null) {
                c.a().a(j, e.b.u());
            }
        }
    }

    public void a(long j, int i, DownloadInfo downloadInfo) {
        e e = f.a().e(j);
        if (e.w()) {
            k.b();
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        if (i == 1) {
            str = k.a(e.c.i(), "storage_deny");
        } else if (i == 2) {
            str = k.a(e.c.e(), "click_start");
            com.ss.android.downloadlib.h.f.a(downloadInfo, jSONObject);
        } else if (i == 3) {
            str = k.a(e.c.f(), "click_pause");
            com.ss.android.downloadlib.h.f.b(downloadInfo, jSONObject);
        } else if (i == 4) {
            str = k.a(e.c.g(), "click_continue");
            com.ss.android.downloadlib.h.f.c(downloadInfo, jSONObject);
        } else if (i == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.h.f.a(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = k.a(e.c.h(), "click_install");
        }
        a(null, str, jSONObject, 0, 1, e);
    }

    public void b(long j, int i) {
        a(j, i, (DownloadInfo) null);
    }

    public void a(String str, int i, e eVar) {
        a(null, str, null, (long) i, 0, eVar);
    }

    public void a(long j, boolean z, int i) {
        e e = f.a().e(j);
        if (e.w()) {
            k.b();
        } else if (e.b.B() != null) {
            if (e.b instanceof c) {
                ((c) e.b).a(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, (com.ss.android.downloadad.a.b.a) e);
        }
    }

    public void a(long j, BaseException baseException) {
        e e = f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("download_failed", jSONObject, (com.ss.android.downloadad.a.b.a) e);
    }

    public void b(long j, BaseException baseException) {
        a(j, baseException, (JSONObject) null);
    }

    public void a(long j, BaseException baseException, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (baseException != null) {
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("ttdownloader_message", baseException.getErrorMessage());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a("download_sdk_error", jSONObject, j);
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.a.b.b a = f.a().a(downloadInfo);
        if (a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                com.ss.android.downloadlib.h.f.c(downloadInfo, jSONObject);
                a.a(System.currentTimeMillis());
                a(a.j(), "download_resume", jSONObject, a);
                i.a().a(a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(JSONObject jSONObject, com.ss.android.downloadad.a.b.b bVar) {
        a(bVar.j(), "install_finish", jSONObject, bVar);
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo != null) {
            com.ss.android.downloadad.a.b.b a = f.a().a(downloadInfo);
            if (a == null) {
                k.b();
            } else if (!a.a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
                    jSONObject.putOpt("fail_status", Integer.valueOf(a.D()));
                    jSONObject.putOpt("fail_msg", a.E());
                    jSONObject.put("download_failed_times", a.w());
                    if (downloadInfo.getTotalBytes() > 0) {
                        jSONObject.put("download_percent", ((double) downloadInfo.getCurBytes()) / ((double) downloadInfo.getTotalBytes()));
                    }
                    jSONObject.put("download_status", downloadInfo.getRealStatus());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.G() > 0) {
                        jSONObject.put("time_from_start_download", currentTimeMillis - a.G());
                    }
                    if (a.A() > 0) {
                        jSONObject.put("time_from_download_resume", currentTimeMillis - a.A());
                    }
                    int i = 1;
                    jSONObject.put("is_update_download", a.U() ? 1 : 2);
                    jSONObject.put("can_show_notification", d.a() ? 1 : 2);
                    if (!a.b.get()) {
                        i = 2;
                    }
                    jSONObject.put("has_send_download_failed_finally", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(a.j(), "download_cancel", jSONObject, a);
            }
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo != null) {
            com.ss.android.downloadad.a.b.b a = f.a().a(downloadInfo);
            if (a == null) {
                k.b();
            } else if (!a.a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    com.ss.android.downloadlib.h.f.c(downloadInfo, jSONObject);
                    com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
                    if (baseException != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                        jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                        a.d(baseException.getErrorCode());
                        a.a(baseException.getErrorMessage());
                    }
                    a.x();
                    jSONObject.put("download_failed_times", a.w());
                    if (downloadInfo.getTotalBytes() > 0) {
                        jSONObject.put("download_percent", ((double) downloadInfo.getCurBytes()) / ((double) downloadInfo.getTotalBytes()));
                    }
                    int i = 1;
                    jSONObject.put("has_send_download_failed_finally", a.b.get() ? 1 : 2);
                    com.ss.android.downloadlib.h.f.a(a, jSONObject);
                    if (!a.U()) {
                        i = 2;
                    }
                    jSONObject.put("is_update_download", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(a.j(), "download_failed", jSONObject, a);
                i.a().a(a);
            }
        }
    }

    public void a(String str, com.ss.android.downloadad.a.b.b bVar) {
        a(str, (JSONObject) null, bVar);
    }

    public void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.a.b.b d = f.a().d(j);
        if (d != null) {
            a(str, jSONObject, d);
            return;
        }
        e e = f.a().e(j);
        if (e.w()) {
            k.b();
        } else {
            a(str, jSONObject, e);
        }
    }

    public void a(String str, JSONObject jSONObject, e eVar) {
        JSONObject jSONObject2 = new JSONObject();
        k.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", k.a(jSONObject2, jSONObject), eVar);
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.a.b.b bVar) {
        JSONObject jSONObject2 = new JSONObject();
        k.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", k.a(jSONObject2, jSONObject), bVar);
    }

    public void a(String str, com.ss.android.a.a.b.c cVar, b bVar, com.ss.android.a.a.b.a aVar) {
        a(str, new e(cVar.d(), cVar, bVar, aVar));
    }

    public void a(String str, long j) {
        com.ss.android.downloadad.a.b.b d = f.a().d(j);
        if (d != null) {
            a(str, (com.ss.android.downloadad.a.b.a) d);
        } else {
            a(str, f.a().e(j));
        }
    }

    public void a(String str, com.ss.android.downloadad.a.b.a aVar) {
        a((String) null, str, aVar);
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, String str2, com.ss.android.downloadad.a.b.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        a(str, str2, jSONObject, 0, 0, aVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.a.b.a aVar) {
        if (aVar == null || ((aVar instanceof e) && ((e) aVar).w())) {
            k.b();
            return;
        }
        try {
            d.a c = new d.a().a(k.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
            if (j <= 0) {
                j = aVar.l();
            }
            d.a a = c.b(j).d(aVar.i()).a(aVar.n()).a(k.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
            if (i <= 0) {
                i = 2;
            }
            a(a.a(i).a(aVar.m()).a());
        } catch (Exception e) {
            k.a(e);
        }
    }

    private JSONObject a(com.ss.android.downloadad.a.b.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            k.a(aVar.g(), jSONObject);
            k.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt("package_name", aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.c.g());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.c.h());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                com.ss.android.downloadlib.h.f.b(jSONObject, aVar);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(com.ss.android.a.a.c.d dVar) {
        if (com.ss.android.downloadlib.addownload.k.b() != null) {
            if (dVar.e()) {
                com.ss.android.downloadlib.addownload.k.b().a(dVar);
            } else {
                com.ss.android.downloadlib.addownload.k.b().b(dVar);
            }
        }
    }
}
