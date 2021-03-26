package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.c.c;
import com.ss.android.downloadlib.addownload.c.d;
import com.ss.android.downloadlib.addownload.f;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CleanSpaceHelper */
public class e {
    private Handler a;
    private com.ss.android.downloadlib.addownload.b.e b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);

    e(Handler handler) {
        this.a = handler;
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.b = eVar;
    }

    public boolean a() {
        return this.d.get();
    }

    public void a(boolean z) {
        this.d.set(z);
    }

    void a(final int i, final long j, long j2, final f.a aVar) {
        this.d.set(false);
        if (aVar != null) {
            if (!com.ss.android.downloadlib.h.e.f(i) || !com.ss.android.downloadlib.h.e.e(i)) {
                aVar.a();
                return;
            }
            long c2 = com.ss.android.downloadlib.h.e.c(i);
            this.c.set(false);
            final String a2 = this.b.b.a();
            final b b2 = com.ss.android.downloadlib.addownload.b.f.a().b(a2);
            if (b2 == null) {
                b2 = new b(this.b.b, this.b.c, this.b.d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(b2);
            }
            b2.e(false);
            if (k.l() != null) {
                k.l().a(b2.b());
            }
            d.a().a(b2.a());
            boolean d2 = com.ss.android.downloadlib.h.e.d(i);
            if (j2 > 0) {
                a(i, a2, j2, b2, j, aVar);
            } else if (d2) {
                a(a2, b2, new f.b() {
                    /* class com.ss.android.downloadlib.addownload.e.AnonymousClass1 */

                    @Override // com.ss.android.downloadlib.addownload.f.b
                    public void a(long j) {
                        e.this.a(i, a2, j, b2, j, aVar);
                    }
                });
            } else {
                c2 = 0;
            }
            this.a.postDelayed(new Runnable() {
                /* class com.ss.android.downloadlib.addownload.e.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (!e.this.c.get()) {
                        e.this.c.set(true);
                        aVar.a();
                    }
                }
            }, c2);
        }
    }

    private void a(String str, b bVar, final f.b bVar2) {
        if (bVar2 != null) {
            com.ss.android.socialbase.downloader.network.a.b.a(str, new j() {
                /* class com.ss.android.downloadlib.addownload.e.AnonymousClass3 */

                @Override // com.ss.android.socialbase.downloader.network.j
                public void a(Map<String, String> map) {
                    if (!e.this.c.get()) {
                        e.this.c.set(true);
                        long a2 = e.this.a(map);
                        if (a2 > 0) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("apk_size", Long.valueOf(a2));
                                jSONObject.putOpt("available_space", Long.valueOf(e.d()));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        bVar2.a(a2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public long a(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(entry.getKey())) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, long j, final b bVar, long j2, final f.a aVar) {
        this.c.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.h.e.a(i) + 1.0d) * ((double) j)).longValue() + com.ss.android.downloadlib.h.e.b(i)) - j2;
            long d2 = d();
            if (d2 < longValue) {
                a(bVar, jSONObject, longValue, d2);
                a(bVar);
                long d3 = d();
                if (d3 < longValue) {
                    bVar.d(true);
                    final String a2 = bVar.a();
                    d.a().a(a2, new com.ss.android.downloadlib.addownload.c.e() {
                        /* class com.ss.android.downloadlib.addownload.e.AnonymousClass4 */
                    });
                    z = a(i, bVar, str, longValue);
                    if (z) {
                        bVar.e(true);
                    }
                } else {
                    b(bVar, jSONObject, d2, d3);
                }
            }
        }
        if (!z) {
            this.a.post(new Runnable() {
                /* class com.ss.android.downloadlib.addownload.e.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a();
                }
            });
        }
    }

    private boolean a(int i, b bVar, String str, long j) {
        if (!com.ss.android.downloadlib.h.e.f(i)) {
            return false;
        }
        if (k.l() != null) {
            return k.l().a(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean a(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (!com.ss.android.downloadlib.h.e.f(id)) {
            return false;
        }
        if (k.l() != null && (z = k.l().a(id, downloadInfo.getUrl(), false, j))) {
            d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() {
                /* class com.ss.android.downloadlib.addownload.e.AnonymousClass6 */
            });
        }
        return z;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i) {
        if (com.ss.android.downloadlib.h.e.f(i) && k.l() != null && k.l().b()) {
            k.l().c();
        }
    }

    public static long b() {
        if (k.l() != null) {
            return k.l().a();
        }
        return 0;
    }

    private static void a(b bVar) {
        long d2 = d();
        if (k.l() != null) {
            k.l().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.h.e.g(bVar.s())) {
            c.a(k.a());
        }
        long d3 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(d3 - d2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    /* access modifiers changed from: private */
    public static long d() {
        return k.a(0);
    }

    private void a(b bVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }

    private void b(b bVar, JSONObject jSONObject, long j, long j2) {
        bVar.l("1");
        i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }
}
