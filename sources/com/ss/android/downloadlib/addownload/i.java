package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DownloadInsideHelper */
public class i {
    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 1;
    }

    public static boolean a(c cVar) {
        return cVar.t() && (cVar instanceof com.ss.android.downloadad.a.a.c) && cVar.A() == 1;
    }

    public static boolean b(c cVar) {
        return cVar != null && cVar.A() == 2;
    }

    public static int a(e eVar, boolean z, f fVar) {
        int i;
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.b() == null) {
            return 0;
        }
        try {
            i = a(fVar, fVar.c());
        } catch (Throwable th) {
            a.d("TAG", "redirectSavePathIfEmpty: throwable = " + th);
            i = 4;
        }
        fVar.a(i);
        if (i == 0) {
            fVar.a(new com.ss.android.downloadlib.d.a());
        }
        int a = d.j().a(fVar);
        b a2 = a(eVar, a);
        com.ss.android.downloadlib.addownload.b.f.a().a(a2);
        a2.g(a);
        a2.h(System.currentTimeMillis());
        a2.i(0L);
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        if (!a(fVar, a3, a) && eVar.b.k()) {
            String H = eVar.b.H();
            if (TextUtils.isEmpty(H)) {
                H = a3.c("download_start_toast_text");
            }
            if (TextUtils.isEmpty(H)) {
                H = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            k.d().a(2, fVar.b(), eVar.b, H, null, 0);
        }
        return a;
    }

    private static b a(e eVar, int i) {
        b bVar = new b(eVar.b, eVar.c, eVar.d, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("download_event_opt", 1) > 1) {
            try {
                String v = eVar.b.v();
                if (!TextUtils.isEmpty(v)) {
                    if (k.a().getPackageManager().getPackageInfo(v, 0) == null) {
                        z = false;
                    }
                    bVar.h(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a1, code lost:
        continue;
     */
    private static boolean a(f fVar, com.ss.android.socialbase.downloader.g.a aVar, int i) {
        boolean z;
        JSONArray e = aVar.e("ah_plans");
        if (!(e == null || e.length() == 0)) {
            int length = e.length();
            JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 < length) {
                    JSONObject optJSONObject = e.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("type");
                        optString.hashCode();
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -985763637:
                                if (optString.equals("plan_a")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -985763636:
                                if (optString.equals("plan_b")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -985763635:
                                if (optString.equals("plan_c")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -985763634:
                                if (optString.equals("plan_d")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -985763633:
                                if (optString.equals("plan_e")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -985763632:
                                if (optString.equals("plan_f")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case -985763631:
                                if (optString.equals("plan_g")) {
                                    c = 6;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                                if (com.ss.android.socialbase.appdownloader.b.a(optJSONObject, aVar).b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 2:
                                jSONObject = optJSONObject;
                                continue;
                            case 3:
                                if (com.ss.android.socialbase.appdownloader.b.c(optJSONObject).b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 6:
                                if (com.ss.android.socialbase.appdownloader.b.b(optJSONObject, aVar).b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") != 1) {
                    z = false;
                }
                if (z) {
                    return com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.L(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.a());
                }
            }
        }
        return false;
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int a(f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        JSONObject d = a.d("download_dir");
        if (d == null || TextUtils.isEmpty(d.optString("dir_name"))) {
            return -1;
        }
        String d2 = fVar.d();
        String N = fVar.N();
        if (TextUtils.isEmpty(N)) {
            N = com.ss.android.socialbase.appdownloader.c.a(str, d2, fVar.n(), true);
        }
        if (N.length() > 255) {
            N = N.substring(N.length() - 255);
        }
        if (TextUtils.isEmpty(d2)) {
            d2 = N;
        }
        String e = fVar.e();
        if (TextUtils.isEmpty(e)) {
            e = com.ss.android.socialbase.appdownloader.c.b();
        }
        String str2 = e + File.separator + com.ss.android.socialbase.appdownloader.c.a(d2, a);
        DownloadInfo a2 = d.j().a(fVar.b(), str);
        if (a2 != null && a2.isSavePathRedirected()) {
            fVar.c(a2.getSavePath());
            try {
                fVar.a(new JSONObject(a2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (a2 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(d.j().a(N, fVar.n()))) {
            return a2 != null ? 8 : 9;
        } else {
            int a3 = com.ss.android.socialbase.appdownloader.b.a(a);
            if (a3 != 0) {
                return a3;
            }
            fVar.c(str2);
            return a3;
        }
    }
}
