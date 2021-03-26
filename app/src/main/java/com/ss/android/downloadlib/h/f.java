package com.ss.android.downloadlib.h;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.appdownloader.f.c;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: EventAppendUtils */
public class f {
    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            c(downloadInfo, jSONObject);
            b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a != null) {
                jSONObject.put("is_update_download", a.U() ? 1 : 2);
                a(a, jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        b a;
        if (jSONObject != null && (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) != null) {
            try {
                c(downloadInfo, jSONObject);
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - a.S()));
                jSONObject.putOpt("click_download_size", Long.valueOf(a.T()));
                jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                a.z();
                i.a().a(a);
                jSONObject.put("click_pause_times", a.y());
                long totalBytes = downloadInfo.getTotalBytes();
                long curBytes = downloadInfo.getCurBytes();
                jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : ((double) curBytes) / ((double) totalBytes));
                jSONObject.put("download_status", downloadInfo.getRealStatus());
                long currentTimeMillis = System.currentTimeMillis();
                long G = a.G();
                if (G > 0) {
                    jSONObject.put("time_from_start_download", currentTimeMillis - G);
                }
                long A = a.A();
                if (A > 0) {
                    jSONObject.put("time_from_download_resume", currentTimeMillis - A);
                }
                jSONObject.putOpt("fail_status", Integer.valueOf(a.D()));
                jSONObject.putOpt("fail_msg", a.E());
                jSONObject.put("download_failed_times", a.w());
                jSONObject.put("can_show_notification", d.a() ? 1 : 2);
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getId());
                if (a != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(a.S()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(a.T()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(e.c(k.a()) ? 1 : 2));
        if (!e.b(k.a())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject != null && bVar != null) {
            try {
                jSONObject.put("is_patch_apply_handled", bVar.W() ? 1 : 0);
                jSONObject.put("origin_mime_type", bVar.V());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            JSONArray e = a.a(i).e("ah_report_config");
            if (e != null) {
                for (int i2 = 0; i2 < e.length(); i2++) {
                    try {
                        String string = e.getString(i2);
                        g.a a = com.ss.android.socialbase.appdownloader.b.a(string);
                        if (a != null) {
                            jSONObject.put(string, a.f() + "_" + a.g());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.L()) ? 1 : 2);
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject a(JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, "open_url", k.a(aVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject b(JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, c.i(), Integer.valueOf(k.b(k.a(), c.i())));
        return jSONObject;
    }
}
