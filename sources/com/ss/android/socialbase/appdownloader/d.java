package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.f;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AppDownloader */
public class d {
    private static final String a = "d";
    private static volatile d b;
    private static boolean k;
    private static boolean l;
    private c c;
    private com.ss.android.socialbase.appdownloader.c.d d;
    private h e;
    private g f;
    private m g;
    private String h;
    private String i;
    private DownloadReceiver j;
    private boolean m = false;
    private f n;
    private j o;
    private af p;

    public c a() {
        return this.c;
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.d;
    }

    public h c() {
        return this.e;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i = str;
        }
    }

    public String d() {
        return this.i;
    }

    public f e() {
        return this.n;
    }

    public boolean f() {
        return a.b().optInt("package_flag_config", 1) == 1;
    }

    public j g() {
        return this.o;
    }

    public void a(j jVar) {
        this.o = jVar;
    }

    public File h() {
        return Downloader.getInstance(b.L()).getGlobalSaveDir();
    }

    public String i() {
        return this.h;
    }

    private d() {
    }

    public static d j() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    @Deprecated
    public void a(Context context, String str, c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, h hVar) {
        if (cVar != null) {
            this.c = cVar;
        }
        if (dVar != null) {
            this.d = dVar;
        }
        if (hVar != null) {
            this.e = hVar;
        }
        c(context);
    }

    private void c(Context context) {
        if (context != null && !k) {
            if (com.ss.android.socialbase.appdownloader.f.c.m()) {
                b.a(true);
            }
            e.a("application/vnd.android.package-archive");
            b.a(context);
            b.a(new com.ss.android.socialbase.appdownloader.d.b());
            p();
            q();
            k = true;
        }
    }

    public void b(String str) {
        Downloader.getInstance(b.L()).setDefaultSavePath(str);
    }

    private void p() {
        if (!l) {
            if (this.j == null) {
                this.j = new DownloadReceiver();
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter2.addDataScheme("package");
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter3.addDataScheme("file");
                b.L().registerReceiver(this.j, intentFilter);
                b.L().registerReceiver(this.j, intentFilter2);
                b.L().registerReceiver(this.j, intentFilter3);
                l = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void q() {
        if (Build.VERSION.SDK_INT >= 21) {
            r.a(new r.b() {
                /* class com.ss.android.socialbase.appdownloader.d.AnonymousClass1 */

                @Override // com.ss.android.socialbase.downloader.impls.r.b
                public void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.a(downloadInfo, j, z, i);
                }
            });
        }
    }

    public static boolean a(Context context, int i2) {
        return c.a(context, i2, true) == 1;
    }

    public void a(Context context, int i2, int i3) {
        switch (i3) {
            case -4:
            case -1:
                Downloader.getInstance(context).restart(i2);
                return;
            case -3:
                c.a(context, i2, true);
                return;
            case -2:
                Downloader.getInstance(context).resume(i2);
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                try {
                    Downloader.getInstance(context).pause(i2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014f A[LOOP:0: B:68:0x0149->B:70:0x014f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0163 A[Catch:{ all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0169 A[Catch:{ all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x032a  */
    public int a(f fVar) {
        String str;
        int i2;
        boolean z;
        n P;
        List<com.ss.android.socialbase.downloader.depend.m> A;
        String m2;
        boolean z2;
        int i3;
        final DownloadTask throttleNetSpeed;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (fVar == null || fVar.b() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.c> a2 = a(fVar.f());
            String c2 = fVar.c();
            if (TextUtils.isEmpty(c2)) {
                return 0;
            }
            final int u = fVar.u();
            final boolean z3 = u == 0;
            String N = fVar.N();
            final String d2 = fVar.d();
            if (TextUtils.isEmpty(N)) {
                N = c.a(c2, d2, fVar.n(), z3);
            }
            if (N.length() > 255) {
                N = N.substring(N.length() - 255);
            }
            if (TextUtils.isEmpty(d2)) {
                d2 = N;
            }
            String n2 = fVar.n();
            if (N.endsWith(".apk") && !c.c(fVar.n())) {
                n2 = "application/vnd.android.package-archive";
            }
            String e2 = fVar.e();
            if (TextUtils.isEmpty(fVar.e())) {
                e2 = c.b();
            }
            if (TextUtils.isEmpty(e2)) {
                return 0;
            }
            if (TextUtils.isEmpty(N)) {
                return 0;
            }
            int a3 = b.a(c2, e2);
            if (a.a(fVar.ad()).a("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(b.L()).getDownloadInfo(a3)) != null) {
                try {
                    fVar.a(new JSONObject(downloadInfo.getDownloadSettingString()));
                } catch (Throwable unused) {
                }
            }
            a.a(a3, fVar.ad());
            boolean M = fVar.M();
            boolean z4 = (M || !com.ss.android.socialbase.downloader.i.e.d(e2, N) || Downloader.getInstance(fVar.b()).getDownloadInfo(a3) != null) ? M : true;
            com.ss.android.socialbase.appdownloader.e.b l2 = fVar.l();
            if (l2 == null && (fVar.g() || fVar.h())) {
                if (fVar.p() != null) {
                    l2 = new com.ss.android.socialbase.appdownloader.e.b(fVar.p());
                } else {
                    z = z4;
                    i2 = a3;
                    str = e2;
                    l2 = new com.ss.android.socialbase.appdownloader.e.b(fVar.b(), a3, d2, str, N, fVar.m());
                    P = fVar.P();
                    if (P == null) {
                        P = new n() {
                            /* class com.ss.android.socialbase.appdownloader.d.AnonymousClass2 */

                            @Override // com.ss.android.socialbase.downloader.depend.n
                            public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
                                if (d.this.e != null) {
                                    d.this.e.a(downloadInfo, baseException, i);
                                }
                            }
                        };
                    }
                    A = b.A();
                    if (!A.isEmpty() && fVar.T().isEmpty()) {
                        for (com.ss.android.socialbase.downloader.depend.m mVar : A) {
                            fVar.a(mVar);
                        }
                    }
                    m2 = fVar.m();
                    if (TextUtils.isEmpty(m2)) {
                        jSONObject = new JSONObject(m2);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", fVar.i());
                    jSONObject.put("auto_install_without_notification", fVar.h());
                    m2 = jSONObject.toString();
                    z2 = !fVar.g() || fVar.h();
                    if (z2 || a.a(i2).b("enable_notification_ui") < 1) {
                        i3 = i2;
                    } else {
                        i3 = i2;
                        com.ss.android.socialbase.appdownloader.e.c.a().a(i3, fVar.aa());
                    }
                    throttleNetSpeed = Downloader.with(fVar.b()).url(c2).backUpUrls(fVar.ab()).name(N).title(d2).savePath(str).onlyWifi(fVar.j()).extraHeaders(a2).depend(P).retryCount(fVar.y()).backUpUrlRetryCount(fVar.z()).showNotification(z2).extra(m2).mimeType(n2).minProgressTimeMsInterval(fVar.F()).maxProgressCount(fVar.G()).mainThreadListener(fVar.k()).notificationListener(l2).notificationEventListener(a(fVar.Q())).force(z).autoResumed(fVar.s()).showNotificationForAutoResumed(fVar.t()).chunkStategy(fVar.q()).chunkAdjustCalculator(fVar.r()).needHttpsToHttpRetry(fVar.o()).packageName(fVar.v()).md5(fVar.w()).expectFileLength(fVar.x()).needRetryDelay(fVar.A()).retryDelayTimeArray(fVar.B()).needDefaultHttpServiceBackUp(fVar.C()).needReuseFirstConnection(fVar.D()).needReuseChunkRunnable(fVar.H()).needIndependentProcess(fVar.I()).enqueueType(fVar.L()).monitorDepend(fVar.O()).retryDelayTimeCalculator(fVar.E()).headConnectionAvailable(fVar.J()).fileUriProvider(fVar.R()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.K()).notificationClickCallback(fVar.S()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.X()).monitorScene(fVar.Y()).extraMonitorStatus(fVar.Z()).executorGroup(fVar.V()).throttleNetSpeed(fVar.W());
                    if (throttleNetSpeed != null && !fVar.T().isEmpty()) {
                        throttleNetSpeed.setDownloadCompleteHandlers(fVar.T());
                    }
                    if (throttleNetSpeed != null) {
                        if (!z2 || !fVar.U() || fVar.a() == null || fVar.a().isFinishing() || com.ss.android.socialbase.appdownloader.e.d.a()) {
                            String str2 = a;
                            com.ss.android.socialbase.downloader.c.a.b(str2, "notification permission need not request, start download :" + d2);
                            a(throttleNetSpeed, u, z3);
                            throttleNetSpeed.getDownloadInfo();
                        } else {
                            com.ss.android.socialbase.appdownloader.e.d.a(fVar.a(), new com.ss.android.socialbase.appdownloader.c.n() {
                                /* class com.ss.android.socialbase.appdownloader.d.AnonymousClass3 */

                                @Override // com.ss.android.socialbase.appdownloader.c.n
                                public void a() {
                                    String str = d.a;
                                    com.ss.android.socialbase.downloader.c.a.b(str, "notification permission granted, start download :" + d2);
                                    d.this.a(throttleNetSpeed, u, z3);
                                }

                                @Override // com.ss.android.socialbase.appdownloader.c.n
                                public void b() {
                                    String str = d.a;
                                    com.ss.android.socialbase.downloader.c.a.b(str, "notification permission denied, start download :" + d2);
                                    d.this.a(throttleNetSpeed, u, z3);
                                }
                            });
                        }
                    }
                    return i3;
                }
            }
            z = z4;
            i2 = a3;
            str = e2;
            P = fVar.P();
            if (P == null) {
            }
            A = b.A();
            while (r13.hasNext()) {
            }
            m2 = fVar.m();
            try {
                if (TextUtils.isEmpty(m2)) {
                }
                jSONObject.put("auto_install_with_notification", fVar.i());
                jSONObject.put("auto_install_without_notification", fVar.h());
                m2 = jSONObject.toString();
            } catch (Throwable unused2) {
            }
            if (!fVar.g()) {
            }
            if (z2) {
            }
            i3 = i2;
            throttleNetSpeed = Downloader.with(fVar.b()).url(c2).backUpUrls(fVar.ab()).name(N).title(d2).savePath(str).onlyWifi(fVar.j()).extraHeaders(a2).depend(P).retryCount(fVar.y()).backUpUrlRetryCount(fVar.z()).showNotification(z2).extra(m2).mimeType(n2).minProgressTimeMsInterval(fVar.F()).maxProgressCount(fVar.G()).mainThreadListener(fVar.k()).notificationListener(l2).notificationEventListener(a(fVar.Q())).force(z).autoResumed(fVar.s()).showNotificationForAutoResumed(fVar.t()).chunkStategy(fVar.q()).chunkAdjustCalculator(fVar.r()).needHttpsToHttpRetry(fVar.o()).packageName(fVar.v()).md5(fVar.w()).expectFileLength(fVar.x()).needRetryDelay(fVar.A()).retryDelayTimeArray(fVar.B()).needDefaultHttpServiceBackUp(fVar.C()).needReuseFirstConnection(fVar.D()).needReuseChunkRunnable(fVar.H()).needIndependentProcess(fVar.I()).enqueueType(fVar.L()).monitorDepend(fVar.O()).retryDelayTimeCalculator(fVar.E()).headConnectionAvailable(fVar.J()).fileUriProvider(fVar.R()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.K()).notificationClickCallback(fVar.S()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.X()).monitorScene(fVar.Y()).extraMonitorStatus(fVar.Z()).executorGroup(fVar.V()).throttleNetSpeed(fVar.W());
            throttleNetSpeed.setDownloadCompleteHandlers(fVar.T());
            if (throttleNetSpeed != null) {
            }
            return i3;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.d.a.a(fVar.O(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.i.e.b(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.c.a.e(a, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i2, boolean z) {
        if (downloadTask != null) {
            downloadTask.download();
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setAntiHijackErrorCode(i2);
            }
            if (downloadInfo != null && z) {
                downloadInfo.setSavePathRedirected(z);
            }
        }
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                    if (cVar.a().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || c.c(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private ab a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new ab() {
            /* class com.ss.android.socialbase.appdownloader.d.AnonymousClass4 */

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (!(i == 1 || i == 3)) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            eVar.a(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            eVar.a(b.L(), str);
                            return;
                        case 10:
                            eVar.a(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                eVar.a(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public String a() {
                return eVar.a();
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a2 = a(context, str, h());
                if (a2 == null) {
                    a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, context.getFilesDir());
                }
                return (a2 != null || !a.c().a("get_download_info_by_list")) ? a2 : b(context, str);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public m k() {
        return this.g;
    }

    public g l() {
        return this.f;
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public p m() {
        return Downloader.getInstance(b.L()).getReserveWifiStatusListener();
    }

    public void a(p pVar) {
        Downloader.getInstance(b.L()).setReserveWifiStatusListener(pVar);
    }

    public void a(af afVar) {
        this.p = afVar;
    }

    public af n() {
        return this.p;
    }
}
