package com.ss.android.downloadlib;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.d.g;
import com.ss.android.downloadlib.h.e;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdDownloadCompletedEventHandlerImpl */
public class a implements com.ss.android.downloadad.a.a, b.c, a.AbstractC0102a {
    private static String a = "a";
    private static volatile a d;
    private long b;
    private b c;

    private a() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.a.b.b bVar) {
        synchronized (a.class) {
            if (downloadInfo == null || bVar == null) {
                k.b();
            } else if (bVar.F() == 1) {
                g.a().d(bVar);
                String c2 = c(downloadInfo, bVar);
                f.a().b(downloadInfo.getUrl(), c2);
                Map<Long, com.ss.android.downloadad.a.b.b> a2 = f.a().a(downloadInfo.getUrl(), c2);
                bVar.f(System.currentTimeMillis());
                bVar.e(2);
                bVar.b(c2);
                a2.put(Long.valueOf(bVar.b()), bVar);
                i.a().a(a2.values());
                b(bVar);
                f.a().a(downloadInfo, c2);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    a().a(bVar);
                    a().b(downloadInfo, bVar);
                    if (bVar.K()) {
                        com.ss.android.downloadlib.addownload.a.a.a().a((long) downloadInfo.getId(), bVar.b(), bVar.l(), c2, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                    }
                    com.ss.android.downloadlib.addownload.e.a.a(downloadInfo, bVar.b(), bVar.d(), c2);
                }
            }
        }
    }

    public synchronized void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!k.a()) {
                final com.ss.android.downloadad.a.b.b a2 = f.a().a(str);
                if (a2 == null) {
                    d.a().a(str);
                    return;
                }
                com.ss.android.downloadlib.addownload.f a3 = f.a().a(a2.a());
                if (a3 != null) {
                    a3.e();
                }
                if (!a2.a.get()) {
                    if (com.ss.android.socialbase.downloader.g.a.a(a2.s()).b("notification_opt_2") == 1) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(a2.s());
                    }
                    new com.ss.android.downloadlib.b.b().a(a2, new com.ss.android.downloadlib.b.g() {
                        /* class com.ss.android.downloadlib.a.AnonymousClass1 */

                        @Override // com.ss.android.downloadlib.b.g
                        public void a(boolean z) {
                            String str = a.a;
                            com.ss.android.socialbase.downloader.c.a.b(str, "appBackForeground->" + z);
                            if (z) {
                                boolean z2 = false;
                                if (com.ss.android.downloadlib.b.f.c(a2)) {
                                    z2 = com.ss.android.downloadlib.b.a.a(str, a2);
                                }
                                if (!z2 && com.ss.android.downloadlib.b.f.d(a2) && a2.J() == 4) {
                                    com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                                }
                            } else if (!com.ss.android.downloadlib.b.a.a(str, a2) && a2.J() == 4) {
                                com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                            }
                        }
                    }, e.a(a2).a("try_applink_delay_after_installed", 0));
                    g.a().f(a2);
                    a(str, a2);
                    com.ss.android.downloadlib.addownload.a.a.a().b(str);
                    DownloadInfo a4 = a(Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
                    if (a4 != null) {
                        if (com.ss.android.socialbase.downloader.g.a.a(a4.getId()).b("no_hide_notification") != 1) {
                            com.ss.android.socialbase.downloader.notification.b.a().a(a4.getId());
                        }
                        f.a().b(a4, str);
                        com.ss.android.downloadlib.addownload.c.d.a(a4);
                    } else {
                        f.a().b(null, str);
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
    }

    void a(DownloadInfo downloadInfo, com.ss.android.downloadad.a.b.b bVar, int i) {
        long max;
        if (downloadInfo != null && bVar != null) {
            d();
            long currentTimeMillis = System.currentTimeMillis();
            bVar.b(currentTimeMillis);
            bVar.g(k.a(Environment.getDataDirectory(), -1));
            if (i != 2000) {
                max = 2000;
            } else {
                long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_failed_delay_time", 120000L);
                if (a2 >= 0) {
                    max = Math.max(a2, 30000L);
                } else {
                    return;
                }
            }
            b bVar2 = new b(bVar.b(), downloadInfo.getId(), currentTimeMillis, i);
            d.a().a(bVar2, max);
            this.c = bVar2;
            i.a().a(bVar);
        }
    }

    /* compiled from: AdDownloadCompletedEventHandlerImpl */
    private static class b implements Runnable {
        private long a;
        private int b;
        private long c;
        private int d;
        private long e;

        private b(long j, int i, long j2, int i2) {
            this.a = j;
            this.b = i;
            this.c = j2;
            this.d = i2;
        }

        /* access modifiers changed from: private */
        public void b() {
            this.e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    a.a().a(this.a, this.b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
            if (((double) r9) < r1) goto L_0x0069;
         */
        boolean a() {
            DownloadInfo downloadInfo;
            double d2;
            JSONObject jSONObject;
            Exception e2;
            com.ss.android.downloadad.a.b.b d3 = f.a().d(this.a);
            boolean z = false;
            if (d3 == null || k.b(d3) || d3.a.get() || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(d3.s())) == null) {
                return false;
            }
            long L = d3.L();
            long a2 = k.a(Environment.getDataDirectory());
            long min = Math.min(524288000L, a2 / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d4 = (double) totalBytes;
            double d5 = ((double) min) + (2.5d * d4);
            if (L <= -1 || totalBytes <= -1) {
                d2 = d4;
            } else {
                d2 = d4;
            }
            z = true;
            boolean a3 = com.ss.android.socialbase.appdownloader.b.a(com.ss.android.downloadlib.addownload.k.a());
            JSONObject jSONObject2 = new JSONObject();
            int a4 = a(z, d3, downloadInfo, a3, jSONObject2);
            this.d = a4;
            try {
                jSONObject = jSONObject2;
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(a4));
                    jSONObject.putOpt("available_space", Long.valueOf(L / 1048576));
                    jSONObject.putOpt("total_space", Long.valueOf(a2 / 1048576));
                    int i = (totalBytes > 0 ? 1 : (totalBytes == 0 ? 0 : -1));
                    if (i > 0) {
                        jSONObject.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                    }
                    int i2 = 2;
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (L > 0 && i > 0) {
                        jSONObject.put("available_space_ratio", ((double) L) / d2);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(a3 ? 1 : 2));
                    if (d3.U()) {
                        i2 = 1;
                    }
                    jSONObject.put("is_update_download", i2);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    com.ss.android.downloadlib.e.a.a().a("install_failed", jSONObject, (com.ss.android.downloadad.a.b.a) d3);
                    return true;
                }
            } catch (Exception e4) {
                e2 = e4;
                jSONObject = jSONObject2;
                e2.printStackTrace();
                com.ss.android.downloadlib.e.a.a().a("install_failed", jSONObject, (com.ss.android.downloadad.a.b.a) d3);
                return true;
            }
            com.ss.android.downloadlib.e.a.a().a("install_failed", jSONObject, (com.ss.android.downloadad.a.b.a) d3);
            return true;
        }

        private int a(boolean z, com.ss.android.downloadad.a.b.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int i = 1;
            if (a2.a("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.i.e.a(checkMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.d;
            if (i2 != 2000) {
                return i2;
            }
            if (a2.a("install_failed_check_signature", 1) == 1 && k.d(com.ss.android.downloadlib.addownload.k.a(), bVar.e())) {
                if (!k.a(k.h(com.ss.android.downloadlib.addownload.k.a(), downloadInfo.getTargetFilePath()), k.g(com.ss.android.downloadlib.addownload.k.a(), bVar.e()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.e;
            long j2 = this.c;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (bVar.B() <= this.c) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    public void a(final long j, int i) {
        long a2 = com.ss.android.socialbase.downloader.g.a.a(i).a("check_install_finish_hijack_delay_time", 900000L);
        if (a2 >= 0) {
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.a.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    a.a().a(j);
                }
            }, Math.max(a2, 300000L));
        }
    }

    public void a(long j) {
        int i;
        d.a aVar;
        try {
            com.ss.android.downloadad.a.b.b d2 = f.a().d(j);
            if (d2 != null && !k.b(d2)) {
                if (!d2.a.get()) {
                    Pair<d.a, Integer> b2 = d.a().b(d2);
                    if (b2 != null) {
                        aVar = (d.a) b2.first;
                        i = ((Integer) b2.second).intValue();
                    } else {
                        aVar = d.a().a(d2);
                        i = -1;
                    }
                    if (aVar != null) {
                        d.a().b(aVar.a);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("installed_app_name", aVar.d);
                        jSONObject.put("installed_pkg_name", aVar.a);
                        if (i != -1) {
                            jSONObject.put("error_code", i);
                            com.ss.android.downloadlib.h.f.a(jSONObject, d2.s());
                            com.ss.android.downloadlib.e.a.a().a("install_finish_hijack", jSONObject, (com.ss.android.downloadad.a.b.a) d2);
                            return;
                        }
                        com.ss.android.downloadlib.e.a.a().a("install_finish_may_hijack", jSONObject, (com.ss.android.downloadad.a.b.a) d2);
                    }
                }
            }
        } catch (Throwable th) {
            k.a(th);
        }
    }

    public void a(String str, com.ss.android.downloadad.a.b.b bVar) {
        if (bVar != null && k.b(bVar) && bVar.a.compareAndSet(false, true)) {
            int i = 4;
            if (bVar.J() != 4) {
                i = 3;
            }
            com.ss.android.downloadlib.e.a.a().a(bVar.j(), "install_finish", a(bVar, str, i), bVar);
            i.a().a(bVar);
        }
    }

    private static DownloadInfo a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (k.a(com.ss.android.downloadlib.addownload.k.a(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (!(jSONObject == null || downloadInfo == null)) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.k.a().b().name());
                int i2 = 0;
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = ((double) downloadInfo.getCurBytes()) / 1048576.0d;
                double realDownloadTime = ((double) downloadInfo.getRealDownloadTime()) / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    String str = a;
                    com.ss.android.socialbase.downloader.c.a.b(str, "download speed : " + d2 + "MB/s");
                }
                try {
                    if (Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).isDownloadServiceForeground(downloadInfo.getId())) {
                        i2 = 1;
                    }
                    jSONObject.put("is_download_service_foreground", i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.i.e.c(com.ss.android.downloadlib.addownload.k.a())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                b(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long a2 = k.a(0);
            double d2 = (double) a2;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = (double) totalBytes;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (a2 > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void b(DownloadInfo downloadInfo, final com.ss.android.downloadad.a.b.b bVar) {
        if (downloadInfo != null && bVar != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_finish_check_ttmd5", 1) != 0) {
            final String targetFilePath = downloadInfo.getTargetFilePath();
            if (!TextUtils.isEmpty(targetFilePath)) {
                d.a().b(new Runnable() {
                    /* class com.ss.android.downloadlib.a.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        String a2 = com.ss.android.downloadlib.h.a.a(targetFilePath);
                        if (!TextUtils.isEmpty(a2)) {
                            com.ss.android.downloadlib.addownload.k.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), a2).apply();
                        }
                    }
                });
            }
        }
    }

    private static void b(com.ss.android.downloadad.a.b.b bVar) {
        if (bVar != null) {
            String O = TextUtils.isEmpty(bVar.O()) ? "" : bVar.O();
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s());
            bVar.l("");
            i.a().a(bVar);
            JSONObject a2 = a(new JSONObject(), downloadInfo);
            int i = 1;
            try {
                a2.putOpt("finish_reason", O);
                a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadad.a.b.b a3 = f.a().a(downloadInfo);
            com.ss.android.downloadlib.h.f.a(a2, downloadInfo.getId());
            try {
                a2.put("download_failed_times", a3.w());
                a2.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
                if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                    a2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
                }
                a2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
                a2.put("has_send_download_failed_finally", a3.b.get() ? 1 : 2);
                if (!a3.U()) {
                    i = 2;
                }
                a2.put("is_update_download", i);
                com.ss.android.downloadlib.h.f.a(a3, a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.a().a("download_finish", a2, (com.ss.android.downloadad.a.b.a) bVar);
        }
    }

    /* access modifiers changed from: private */
    public void c(com.ss.android.downloadad.a.b.b bVar) {
        SystemClock.sleep(20000);
        int i = 15;
        while (i > 0) {
            if (k.b(bVar)) {
                a(bVar.e());
                return;
            }
            i--;
            if (i != 0) {
                SystemClock.sleep(20000);
            } else {
                return;
            }
        }
    }

    private int a(com.ss.android.downloadad.a.b.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int b2 = com.ss.android.socialbase.appdownloader.c.b(com.ss.android.downloadlib.addownload.k.a(), downloadInfo);
        int b3 = k.b(com.ss.android.downloadlib.addownload.k.a(), str);
        if (b2 > 0 && b3 > 0 && b2 != b3) {
            return b3 > b2 ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.ss.android.downloadlib.addownload.k.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.h.a.a(downloadInfo.getTargetFilePath());
        }
        int a2 = com.ss.android.downloadlib.h.a.a(string, com.ss.android.downloadlib.h.a.b(str));
        try {
            jSONObject.put("ttmd5_status", a2);
        } catch (Throwable unused) {
        }
        if (a2 == 0) {
            return 3000;
        }
        return a2 == 1 ? 3002 : 3001;
    }

    public static String c(DownloadInfo downloadInfo, com.ss.android.downloadad.a.b.b bVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = com.ss.android.downloadlib.addownload.k.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
        return str;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
    public void b() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppForeground()");
        d();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
    public void c() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppBackground()");
        a(6);
    }

    synchronized void d() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
            this.c = null;
        }
    }

    @Override // com.ss.android.downloadad.a.a
    public void a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b >= 120000) {
            d.a().a(new RunnableC0091a(i), this.b > 0 ? 2000 : 8000);
            this.b = currentTimeMillis;
        }
    }

    /* access modifiers changed from: private */
    public void a(ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.b> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.a.b.b bVar : concurrentHashMap.values()) {
            if (bVar.a.get()) {
                if (currentTimeMillis - bVar.G() >= ((long) (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000))) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.F() == 1) {
                if (d(bVar) <= 0 && currentTimeMillis - bVar.G() >= ((long) (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000))) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.F() != 2) {
                arrayList.add(Long.valueOf(bVar.b()));
            } else if (!bVar.X()) {
                if (k.b(bVar)) {
                    if (bVar.J() == 4) {
                        i = bVar.J();
                    }
                    com.ss.android.downloadlib.e.a.a().a(a(bVar, bVar.e(), i), bVar);
                    arrayList.add(Long.valueOf(bVar.b()));
                    com.ss.android.downloadlib.addownload.c.d.a(bVar);
                } else if (currentTimeMillis - bVar.G() >= ((long) (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("finish_event_expire_hours", 168) * 60 * 60 * 1000))) {
                    arrayList.add(Long.valueOf(bVar.b()));
                } else if (TextUtils.isEmpty(bVar.e())) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            }
        }
        f.a().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        if (downloadInfo != null && aVar != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("ah_report_config") != null) {
            b(downloadInfo, aVar);
        }
    }

    private int d(com.ss.android.downloadad.a.b.b bVar) {
        int realStatus;
        double a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("download_failed_finally_hours", 48.0d);
        if (a2 <= 0.0d) {
            return -1;
        }
        if (((double) (System.currentTimeMillis() - bVar.G())) < a2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.b.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && bVar.b.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.D()));
                jSONObject.putOpt("fail_msg", bVar.E());
                jSONObject.put("download_failed_times", bVar.w());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", ((double) downloadInfo.getCurBytes()) / ((double) downloadInfo.getTotalBytes()));
                }
                jSONObject.put("is_update_download", bVar.U() ? 1 : 2);
                com.ss.android.downloadlib.e.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                i.a().a(bVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    private void b(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.downloadad.a.b.b a2 = f.a().a(downloadInfo);
        if (a2 != null) {
            JSONObject jSONObject = new JSONObject();
            aVar.a(jSONObject);
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.h.f.a(jSONObject, downloadInfo.getId());
            com.ss.android.downloadlib.e.a.a().a("embeded_ad", "ah_result", jSONObject, a2);
        }
    }

    public void a(com.ss.android.downloadad.a.b.b bVar) {
        d.a().a(new c(bVar));
    }

    /* compiled from: AdDownloadCompletedEventHandlerImpl */
    private class c implements Runnable {
        private final com.ss.android.downloadad.a.b.b b;

        public c(com.ss.android.downloadad.a.b.b bVar) {
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.j(true);
                a.this.c(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.b.j(false);
                throw th;
            }
            this.b.j(false);
        }
    }

    /* renamed from: com.ss.android.downloadlib.a$a  reason: collision with other inner class name */
    /* compiled from: AdDownloadCompletedEventHandlerImpl */
    private class RunnableC0091a implements Runnable {
        private final int b;

        public RunnableC0091a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.a().b();
                ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.b> c = f.a().c();
                if (c != null && !c.isEmpty()) {
                    a.this.a(c, this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject a(com.ss.android.downloadad.a.b.b bVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.a a2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.h.f.a(jSONObject, bVar.s());
            com.ss.android.downloadlib.h.f.a(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.U() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.aa() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.Q() ? "1" : "2");
            if (downloadInfo != null) {
                a(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (bVar.B() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - bVar.B());
                    }
                } catch (Throwable unused) {
                }
                String a3 = com.ss.android.socialbase.downloader.i.e.a(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(a3) && (a2 = com.ss.android.socialbase.appdownloader.a.a(a3)) != null) {
                    a2.a(jSONObject);
                }
            }
            int a4 = a(bVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", a4);
            if (a4 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (a4 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.a.b.b a2 = f.a().a(downloadInfo);
        if (a2 == null) {
            k.b();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(((double) j) / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf(((double) (j2 - j)) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf(((double) (j3 - j2)) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.h.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.e.a.a().a("cleanup", jSONObject, a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
