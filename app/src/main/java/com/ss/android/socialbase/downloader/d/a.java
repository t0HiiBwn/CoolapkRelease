package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.o;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.g;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadMonitorHelper */
public class a {
    public static void a(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask != null) {
            try {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (downloadInfo != null) {
                    z monitorDepend = downloadTask.getMonitorDepend();
                    boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
                    if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof c)) {
                        isMonitorStatus = a(((c) monitorDepend).a(), i);
                    }
                    if (isMonitorStatus) {
                        try {
                            n depend = downloadTask.getDepend();
                            if (depend != null) {
                                depend.a(downloadInfo, baseException, i);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        a(monitorDepend, downloadInfo, baseException, i);
                        a(b.g(), downloadInfo, baseException, i);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(z zVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (zVar != null) {
            try {
                String b = zVar.b();
                if (TextUtils.isEmpty(b)) {
                    b = "default";
                }
                JSONObject a = a(b, downloadInfo, baseException, i);
                if (a == null) {
                    a = new JSONObject();
                }
                zVar.a(a);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (bVar != null && downloadInfo.isNeedSDKMonitor() && !TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            try {
                JSONObject a = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
                if (a == null) {
                    a = new JSONObject();
                }
                if (i == -1) {
                    a.put("status", baseException.getErrorCode());
                    bVar.a("download_failed", a, null, null);
                    return;
                }
                a(i, a, downloadInfo);
                bVar.a("download_common", a, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String a(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        JSONException e;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                o k = b.k();
                String str8 = "";
                int i3 = 0;
                if (k != null) {
                    str4 = k.b();
                    str3 = a(str4);
                    str2 = k.a();
                    i2 = k.c();
                } else {
                    str4 = str8;
                    str3 = str4;
                    str2 = str3;
                    i2 = 0;
                }
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", str2);
                jSONObject2.put("device_id", str4);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put("update_version", i2);
                jSONObject2.put("download_status", i);
                jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                if (downloadInfo != null) {
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i4 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? str8 : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : str8);
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : str8);
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i4 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i4);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : str8);
                    try {
                        String url = downloadInfo.getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            Uri parse = Uri.parse(url);
                            str6 = parse.getHost();
                            str5 = parse.getPath();
                            str7 = parse.getLastPathSegment();
                            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str7)) {
                                try {
                                    str5 = str5.substring(0, str5.length() - str7.length());
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        } else {
                            str7 = str8;
                            str6 = str7;
                            str5 = str6;
                        }
                        jSONObject2.put("url_host", str6);
                        jSONObject2.put("url_path", str5);
                        jSONObject2.put("url_last_path_segment", str7);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (baseException != null) {
                    i3 = baseException.getErrorCode();
                }
                jSONObject2.put("error_code", i3);
                if (baseException != null) {
                    str8 = baseException.getErrorMessage();
                }
                jSONObject2.put("error_msg", str8);
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056 A[Catch:{ all -> 0x002a, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8 A[Catch:{ JSONException -> 0x0103 }] */
    public static void a(g gVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a;
        int a2;
        String str4;
        String str5;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        b g;
        int httpStatusCode;
        if (downloadInfo != null && (a2 = (a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).a("monitor_download_connect", 0)) > 0 && !TextUtils.isEmpty(str)) {
            int i2 = -1;
            if (gVar != null) {
                try {
                    i2 = gVar.b();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
                if (gVar instanceof com.ss.android.socialbase.downloader.network.a) {
                    str4 = ((com.ss.android.socialbase.downloader.network.a) gVar).e();
                    if (i2 < 200 || i2 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (!e.c(b.L())) {
                                i2 = 1049;
                            } else {
                                try {
                                    e.a((Throwable) iOException, "");
                                } catch (BaseException e) {
                                    i2 = e.getErrorCode();
                                    str5 = e.getErrorMessage();
                                }
                            }
                        }
                    }
                    str5 = null;
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    path = parse.getPath();
                    lastPathSegment = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                        path = path.substring(0, path.length() - lastPathSegment.length());
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", a.c("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.putOpt("host_ip", str2);
                    jSONObject.putOpt("host_real_ip", str4);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                    jSONObject.put("net_lib", i);
                    jSONObject.put("connect_type", str3);
                    jSONObject.put("status_code", i2);
                    if (str5 != null) {
                        jSONObject.put("err_msg", e.a(str5, a.a("exception_msg_length", 500)));
                    }
                    jSONObject.put("connect_time", j);
                    jSONObject.put("pkg_name", downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((a2 == 1 || a2 == 3) && (g = b.g()) != null) {
                        g.a("download_connect", jSONObject, null, null);
                    }
                    if (a2 != 2 || a2 == 3) {
                        b.N().a(downloadInfo.getId(), "download_connect", jSONObject);
                    }
                    return;
                }
            }
            str4 = null;
            if (downloadInfo.getCurRetryTime() == 0) {
            }
            if (iOException != null) {
            }
            str5 = null;
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            path = parse.getPath();
            lastPathSegment = parse.getLastPathSegment();
            try {
                path = path.substring(0, path.length() - lastPathSegment.length());
            } catch (Throwable unused) {
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put("setting_tag", a.c("setting_tag"));
                jSONObject.put("url_host", host);
                jSONObject.putOpt("host_ip", str2);
                jSONObject.putOpt("host_real_ip", str4);
                jSONObject.put("url_path", path);
                jSONObject.put("url_last_path_segment", lastPathSegment);
                jSONObject.put("net_lib", i);
                jSONObject.put("connect_type", str3);
                jSONObject.put("status_code", i2);
                if (str5 != null) {
                }
                jSONObject.put("connect_time", j);
                jSONObject.put("pkg_name", downloadInfo.getPackageName());
                jSONObject.put("name", downloadInfo.getTitle());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            g.a("download_connect", jSONObject, null, null);
            if (a2 != 2) {
            }
            b.N().a(downloadInfo.getId(), "download_connect", jSONObject);
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1, -1, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0163  */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static void a(String str, int i, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String str5;
        int i2;
        JSONObject jSONObject2;
        long j6;
        int i3;
        int i4;
        double nanos;
        String str6;
        int i5;
        b g;
        if (i > 0 && j2 > 0) {
            try {
                Uri parse = Uri.parse(str2);
                String host = parse.getHost();
                String path = parse.getPath();
                String lastPathSegment = parse.getLastPathSegment();
                if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                    try {
                        path = path.substring(0, path.length() - lastPathSegment.length());
                    } catch (Throwable unused) {
                    }
                }
                if (z) {
                    i2 = 1;
                } else if (z2) {
                    i2 = 2;
                } else if (baseException != null) {
                    if (!e.c(b.L())) {
                        i2 = 1049;
                    } else {
                        i2 = baseException.getErrorCode();
                    }
                    str5 = baseException.getErrorMessage();
                    jSONObject2 = new JSONObject();
                    ?? r16 = -1;
                    if (iVar == null) {
                        i3 = iVar instanceof com.ss.android.socialbase.downloader.network.e ? 0 : 1;
                        String a = iVar.a("X-Cache");
                        if (!TextUtils.isEmpty(a)) {
                            r16 = a.toLowerCase().contains("hit");
                        }
                        if (aVar.a("monitor_sla", 1) == 1 && !z && !z2 && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
                            ((com.ss.android.socialbase.downloader.network.a) iVar).a(jSONObject2, true);
                        }
                        j6 = j;
                        i4 = r16 == true ? 1 : 0;
                    } else {
                        j6 = j;
                        i4 = -1;
                        i3 = -1;
                    }
                    double d = ((double) j6) / 1048576.0d;
                    double d2 = (double) j2;
                    nanos = d2 / ((double) TimeUnit.SECONDS.toNanos(1));
                    jSONObject2.put("setting_tag", aVar.c("setting_tag"));
                    jSONObject2.put("url_host", host);
                    jSONObject2.putOpt("host_ip", str3);
                    jSONObject2.putOpt("host_real_ip", str4);
                    jSONObject2.put("url_path", path);
                    jSONObject2.put("url_last_path_segment", lastPathSegment);
                    jSONObject2.put("net_lib", i3);
                    jSONObject2.put("hit_cdn_cache", i4);
                    jSONObject2.put("status_code", i2);
                    if (str5 != null) {
                        jSONObject2.put("err_msg", e.a(str5, aVar.a("exception_msg_length", 500)));
                    }
                    jSONObject2.put("download_sec", nanos);
                    jSONObject2.put("download_mb", d);
                    if (nanos > 0.0d) {
                        jSONObject2.put("download_speed", d / nanos);
                    }
                    if (z3) {
                        jSONObject2.put("rw_read_time", ((double) j3) / d2);
                        jSONObject2.put("rw_write_time", ((double) j4) / d2);
                        jSONObject2.put("rw_sync_time", ((double) j5) / d2);
                    }
                    jSONObject2.put("pkg_name", downloadInfo.getPackageName());
                    jSONObject2.put("name", downloadInfo.getTitle());
                    if (i != 1 || i == 3) {
                        g = b.g();
                        if (g == null) {
                            str6 = str;
                            g.a(str6, jSONObject2, null, null);
                        } else {
                            str6 = str;
                        }
                        i5 = 2;
                    } else {
                        i5 = 2;
                        str6 = str;
                    }
                    if (i != i5 || i == 3) {
                        b.N().a(downloadInfo.getId(), str6, jSONObject2);
                    }
                    return;
                } else {
                    i2 = 0;
                }
                str5 = null;
                jSONObject2 = new JSONObject();
                ?? r16 = -1;
                if (iVar == null) {
                }
                double d = ((double) j6) / 1048576.0d;
                double d2 = (double) j2;
                nanos = d2 / ((double) TimeUnit.SECONDS.toNanos(1));
                jSONObject2.put("setting_tag", aVar.c("setting_tag"));
                jSONObject2.put("url_host", host);
                jSONObject2.putOpt("host_ip", str3);
                jSONObject2.putOpt("host_real_ip", str4);
                jSONObject2.put("url_path", path);
                jSONObject2.put("url_last_path_segment", lastPathSegment);
                jSONObject2.put("net_lib", i3);
                jSONObject2.put("hit_cdn_cache", i4);
                jSONObject2.put("status_code", i2);
                if (str5 != null) {
                }
                jSONObject2.put("download_sec", nanos);
                jSONObject2.put("download_mb", d);
                if (nanos > 0.0d) {
                }
                if (z3) {
                }
                jSONObject2.put("pkg_name", downloadInfo.getPackageName());
                jSONObject2.put("name", downloadInfo.getTitle());
                if (i != 1) {
                }
                g = b.g();
                if (g == null) {
                }
                i5 = 2;
                if (i != i5) {
                }
                b.N().a(downloadInfo.getId(), str6, jSONObject2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
