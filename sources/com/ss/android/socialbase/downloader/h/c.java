package com.ss.android.socialbase.downloader.h;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.i;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* compiled from: DownloadRunnable */
public class c implements f, Runnable {
    private static final String a = "c";
    private r A;
    private volatile int B = 5;
    private boolean C = false;
    private boolean D = false;
    private String E;
    private boolean F = false;
    private long G;
    private long H;
    private final a I;
    private int J = 0;
    private volatile k K = null;
    private Future b;
    private final DownloadTask c;
    private volatile boolean d = false;
    private AtomicInteger e;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile d g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private volatile i n = i.RUN_STATUS_NONE;
    private final com.ss.android.socialbase.downloader.downloader.i o;
    private DownloadInfo p;
    private g q;
    private final g r;
    private f s;
    private final f t;
    private q u;
    private final e v;
    private volatile BaseException w;
    private com.ss.android.socialbase.downloader.network.i x;
    private com.ss.android.socialbase.downloader.network.g y;
    private x z;

    private boolean K() {
        return false;
    }

    public c(DownloadTask downloadTask, Handler handler) {
        this.c = downloadTask;
        if (downloadTask != null) {
            this.p = downloadTask.getDownloadInfo();
            this.q = downloadTask.getChunkStrategy();
            this.s = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.A = downloadTask.getDiskSpaceHandler();
            this.u = a(downloadTask);
            this.I = a.a(this.p.getId());
        } else {
            this.I = a.c();
        }
        h();
        this.o = b.x();
        this.r = b.H();
        this.t = b.J();
        this.v = new e(downloadTask, handler);
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
            if (retryCount < 0) {
                retryCount = 0;
            }
            AtomicInteger atomicInteger = this.e;
            if (atomicInteger == null) {
                this.e = new AtomicInteger(retryCount);
            } else {
                atomicInteger.set(retryCount);
            }
        }
    }

    public void a() {
        this.n = i.RUN_STATUS_PAUSE;
        if (this.K != null) {
            this.K.b();
        }
        if (this.g != null) {
            this.g.b();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = i.RUN_STATUS_PAUSE;
            p();
        }
        try {
            Iterator it2 = ((ArrayList) this.f.clone()).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        this.n = i.RUN_STATUS_CANCELED;
        if (this.K != null) {
            this.K.a();
        }
        if (this.g != null) {
            this.g.c();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = i.RUN_STATUS_CANCELED;
            p();
        }
        I();
    }

    public DownloadTask c() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r9 <= 0) goto L_0x005e;
     */
    private int a(long j2, List<com.ss.android.socialbase.downloader.model.b> list) {
        int i2;
        int i3;
        if (C()) {
            if (!this.i) {
                g gVar = this.q;
                if (gVar != null) {
                    i3 = gVar.a(j2);
                } else {
                    i3 = this.r.a(j2);
                }
                l b2 = com.ss.android.socialbase.downloader.network.k.a().b();
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("NetworkQuality is : %s", b2.name()));
                this.p.setNetworkQuality(b2.name());
                f fVar = this.s;
                if (fVar != null) {
                    i2 = fVar.a(i3, b2);
                } else {
                    i2 = this.t.a(i3, b2);
                }
            } else if (list != null) {
                i2 = list.size();
            } else {
                i2 = this.p.getChunkCount();
            }
        }
        i2 = 1;
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i2), this.p.getName(), String.valueOf(j2)));
        }
        return i2;
    }

    private boolean i() {
        int status = this.p.getStatus();
        if (status == 1 || this.p.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        b(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f3, code lost:
        if (r9.I.a("fix_file_exist_update_download_info") != false) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        com.ss.android.socialbase.downloader.exception.a e2;
        Throwable th;
        DownloadTask downloadTask;
        boolean z2 = false;
        boolean z3 = true;
        try {
            int id = this.p.getId();
            if (this.o != null) {
                if (com.ss.android.socialbase.downloader.i.a.a(2048)) {
                    this.o.d();
                }
                DownloadInfo b2 = this.o.b(id);
                if (b2 != null) {
                    if (!b2.isNewTask()) {
                        String savePath = this.p.getSavePath();
                        String md5 = this.p.getMd5();
                        this.p.copyFromCacheData(b2, true);
                        boolean z4 = com.ss.android.socialbase.downloader.i.a.a(4096) && b2 != this.p;
                        try {
                            if (savePath.equals(b2.getSavePath()) && com.ss.android.socialbase.downloader.i.e.a(b2, false, md5)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.exception.a(b2.getName());
                                } catch (com.ss.android.socialbase.downloader.exception.a e3) {
                                    throw e3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = z4;
                                    try {
                                        downloadTask = this.c;
                                        com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.e.b(th, "checkTaskCache")), this.p.getStatus());
                                        if (z2) {
                                        }
                                    } catch (Throwable th3) {
                                        if (z2) {
                                            if (z3) {
                                                try {
                                                } catch (SQLiteException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            this.o.a(this.p);
                                        }
                                        throw th3;
                                    }
                                }
                            } else if (b.a(b2) != id) {
                                try {
                                    this.o.f(id);
                                } catch (SQLiteException e5) {
                                    e5.printStackTrace();
                                }
                            } else {
                                z3 = z4;
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.a e6) {
                            e2 = e6;
                            throw e2;
                        } catch (Throwable th4) {
                            th = th4;
                            z2 = z4;
                            z3 = false;
                            downloadTask = this.c;
                            if (!(downloadTask == null || this.p == null)) {
                                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.e.b(th, "checkTaskCache")), this.p.getStatus());
                            }
                            if (z2) {
                                return;
                            }
                            if (!z3 || this.I.a("fix_file_exist_update_download_info")) {
                                this.o.a(this.p);
                                return;
                            }
                            return;
                        }
                    }
                }
                this.p.reset();
            } else {
                z3 = false;
            }
            try {
                h();
                if (z3) {
                    try {
                        this.o.a(this.p);
                    } catch (SQLiteException e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (com.ss.android.socialbase.downloader.exception.a e8) {
                e2 = e8;
                throw e2;
            } catch (Throwable th5) {
                th = th5;
                z2 = z3;
                z3 = false;
                downloadTask = this.c;
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.e.b(th, "checkTaskCache")), this.p.getStatus());
                if (z2) {
                }
            }
        } catch (com.ss.android.socialbase.downloader.exception.a e9) {
            e2 = e9;
            throw e2;
        } catch (Throwable th6) {
            th = th6;
            z3 = false;
            downloadTask = this.c;
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.e.b(th, "checkTaskCache")), this.p.getStatus());
            if (z2) {
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        b.a(this.c, 3);
        try {
            com.ss.android.socialbase.downloader.network.b.a().b();
            k();
            com.ss.android.socialbase.downloader.network.b.a().c();
            b.b(this.c, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.b.a().c();
            throw th;
        }
    }

    private void k() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo != null && this.H > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable unused) {
        }
        try {
            y interceptor = this.c.getInterceptor();
            if (interceptor != null && interceptor.a()) {
                this.v.e();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!i()) {
            z monitorDepend = this.c.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.p;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.p;
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            l();
            if (this.C) {
                if (this.B > 0) {
                    this.B--;
                } else if (this.p.getCurBytes() != this.p.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                } else if (this.p.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                } else if (this.p.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void l() {
        boolean z2;
        try {
            this.n = i.RUN_STATUS_NONE;
            this.p.updateStartDownloadTime();
            this.p.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.p.setFirstSpeedTime(-1);
            try {
                j();
                z2 = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "file exist " + e2.a());
                this.E = e2.a();
                z2 = true;
            }
            if (!this.C) {
                this.v.b();
            }
            this.C = false;
            if (!v()) {
                if (!TextUtils.isEmpty(this.E) && z2) {
                    if (this.p.isExpiredRedownload()) {
                        if (this.p.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(this.p.getLastModified())) {
                            String str2 = a;
                            com.ss.android.socialbase.downloader.c.a.b(str2, "dcache::curt=" + System.currentTimeMillis() + " expired=" + this.p.getCacheExpiredTime());
                            if (System.currentTimeMillis() > this.p.getCacheExpiredTime()) {
                                this.F = true;
                                com.ss.android.socialbase.downloader.c.a.b(str2, "dcache::expired=true");
                            }
                        } else {
                            this.F = false;
                            com.ss.android.socialbase.downloader.c.a.b(a, "dcache::last modify is emtpy, so just return cache");
                        }
                    }
                    if (!this.F) {
                        m();
                        p();
                        return;
                    }
                }
                while (!v()) {
                    try {
                        F();
                        B();
                        E();
                        List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
                        G();
                        if (n()) {
                            com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments return");
                            s();
                            p();
                            return;
                        }
                        String connectionUrl = this.p.getConnectionUrl();
                        if (v()) {
                            s();
                            p();
                            return;
                        }
                        long d2 = this.i ? com.ss.android.socialbase.downloader.i.e.d(this.p) : 0;
                        com.ss.android.socialbase.downloader.model.b a2 = a(this.p, d2);
                        List<com.ss.android.socialbase.downloader.model.c> a3 = a(a2);
                        com.ss.android.socialbase.downloader.i.e.a(a3, this.p);
                        this.p.setPreconnectLevel(0);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        try {
                            a(connectionUrl, a3, d2);
                            this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                            if (v()) {
                                s();
                                p();
                                return;
                            }
                            long totalBytes = this.p.getTotalBytes();
                            a(totalBytes);
                            int a4 = a(totalBytes, c2);
                            if (v()) {
                                s();
                                p();
                                return;
                            } else if (a4 > 0) {
                                boolean z3 = a4 == 1;
                                this.h = z3;
                                if (z3) {
                                    if (this.x == null) {
                                        try {
                                            currentTimeMillis2 = System.currentTimeMillis();
                                            a(connectionUrl, a3);
                                        } finally {
                                            this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                        }
                                    }
                                    if (v()) {
                                        s();
                                        p();
                                        return;
                                    }
                                    this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                    o();
                                    a(a2, connectionUrl, this.x);
                                } else {
                                    if (!this.p.isNeedReuseFirstConnection()) {
                                        r();
                                    }
                                    if (v()) {
                                        s();
                                        p();
                                        return;
                                    }
                                    o();
                                    this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                    if (this.i) {
                                        a(a4, c2);
                                    } else {
                                        a(totalBytes, a4);
                                    }
                                }
                                s();
                                p();
                                return;
                            } else {
                                throw new BaseException(1032, "chunkCount is 0");
                            }
                        } catch (Throwable th) {
                            this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                            throw th;
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                        m();
                    } catch (BaseException e3) {
                        String str3 = a;
                        com.ss.android.socialbase.downloader.c.a.d(str3, "downloadInner: baseException = " + e3);
                        if (this.n != i.RUN_STATUS_PAUSE) {
                            if (e3.getErrorCode() == 1025 || e3.getErrorCode() == 1009) {
                                this.n = i.RUN_STATUS_END_RIGHT_NOW;
                                s();
                                p();
                                return;
                            } else if (a(e3)) {
                                if (com.ss.android.socialbase.downloader.i.e.a(e3)) {
                                    H();
                                }
                                if (a(e3, 0) == com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                    s();
                                    p();
                                    return;
                                }
                                s();
                            } else {
                                b(e3);
                            }
                        }
                    } catch (h e4) {
                        String str4 = a;
                        com.ss.android.socialbase.downloader.c.a.d(str4, "downloadInner: retry throwable for " + e4.a());
                        if (this.n != i.RUN_STATUS_PAUSE) {
                            AtomicInteger atomicInteger = this.e;
                            if (atomicInteger != null && atomicInteger.get() > 0) {
                                this.p.updateCurRetryTime(this.e.decrementAndGet());
                                this.p.setStatus(5);
                                s();
                            } else if (this.e == null) {
                                b(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                            } else if (this.p.trySwitchToNextBackupUrl()) {
                                this.p.setStatus(5);
                                this.e.set(this.p.getRetryCount());
                                this.p.updateCurRetryTime(this.e.get());
                                s();
                            } else {
                                b(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e4.a())));
                            }
                        }
                    } catch (Throwable th2) {
                        s();
                        throw th2;
                    }
                }
                p();
            }
        } finally {
            p();
        }
    }

    private void m() {
        com.ss.android.socialbase.downloader.c.a.b(a, "finishWithFileExist");
        if (a.c().b("fix_end_for_file_exist_error", true)) {
            if (this.E.equals(this.p.getName())) {
                this.n = i.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.n = i.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.E.equals(this.p.getTargetFilePath())) {
            this.n = i.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.n = i.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean n() throws BaseException, InterruptedException {
        if (this.p.isExpiredRedownload() || this.p.getChunkCount() != 1 || this.p.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject d2 = a.a(this.p.getId()).d("segment_config");
        List<com.ss.android.socialbase.downloader.f.i> n2 = this.o.n(this.p.getId());
        if (this.p.getCurBytes() > 0) {
            if (n2 == null || n2.isEmpty()) {
                return false;
            }
            if (d2 == null) {
                d2 = new JSONObject();
            }
        }
        if (d2 == null) {
            return false;
        }
        this.K = new k(this.p, n.a(d2), this);
        if (v()) {
            com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments: is stopped by user");
            if (this.n == i.RUN_STATUS_CANCELED) {
                this.K.a();
            } else {
                this.K.b();
            }
            return true;
        }
        this.K.a(n2);
        return true;
    }

    private void o() {
        if (a.a(this.p.getId()).a("reset_retain_retry_times", 0) == 1 && this.J < 3) {
            this.e.set(this.p.isBackUpUrlUsed() ? this.p.getBackUpUrlRetryCount() : this.p.getRetryCount());
            this.J++;
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, h {
        b(str, list, j2);
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            try {
                a(str, gVar, j2);
            } catch (Throwable unused) {
                this.D = true;
            }
        }
        if (this.y == null || this.D) {
            a(str, list);
            a(str, this.x, j2);
        }
    }

    private void p() {
        boolean z2;
        boolean z3;
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "endDownloadRunnable::runStatus=" + this.n);
        int i2 = 0;
        boolean z4 = (this.n == i.RUN_STATUS_PAUSE || this.n == i.RUN_STATUS_CANCELED) ? false : true;
        try {
            z3 = w();
            z2 = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.v.a((BaseException) e2);
            } else {
                this.v.a(new BaseException(1046, e2));
            }
            z3 = true;
            z2 = true;
        }
        if (z3 || z2) {
            this.m.set(false);
            if (z4) {
                try {
                    com.ss.android.socialbase.downloader.impls.a C2 = b.C();
                    if (C2 != null) {
                        C2.a(this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    z monitorDepend = this.c.getMonitorDepend();
                    DownloadInfo downloadInfo = this.p;
                    BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.i.e.b(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.p;
                    if (downloadInfo2 != null) {
                        i2 = downloadInfo2.getStatus();
                    }
                    com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i2);
                }
            }
        } else {
            this.C = true;
            com.ss.android.socialbase.downloader.c.a.b(a, "jump to restart");
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, h {
        com.ss.android.socialbase.downloader.network.a.c a2;
        boolean z2 = true;
        if (this.p.getChunkCount() == 1 && (a2 = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
            this.y = a2;
            this.p.setPreconnectLevel(1);
        }
        if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
            try {
                int b2 = this.I.b("net_lib_strategy");
                if (this.I.a("monitor_download_connect", 0) <= 0) {
                    z2 = false;
                }
                this.y = b.a(str, list, b2, z2, this.p);
            } catch (Throwable th) {
                this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.e.i(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, h {
        com.ss.android.socialbase.downloader.network.i iVar;
        if (this.x == null) {
            com.ss.android.socialbase.downloader.network.a.d dVar = null;
            if (this.p.getChunkCount() == 1) {
                dVar = com.ss.android.socialbase.downloader.network.a.a.a().b(str, list);
            }
            if (dVar != null) {
                a(this.x);
                this.p.setPreconnectLevel(2);
                this.x = dVar;
            } else {
                try {
                    iVar = b.a(this.p.isNeedDefaultHttpServiceBackUp(), this.p.getMaxBytes(), str, null, list, this.I.b("net_lib_strategy"), this.I.a("monitor_download_connect", 0) > 0, this.p);
                    this.x = iVar;
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    a(this.x);
                    throw th;
                }
                a(iVar);
            }
            if (this.x == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            gVar.c();
            this.y = null;
        }
    }

    private void r() {
        com.ss.android.socialbase.downloader.network.i iVar = this.x;
        if (iVar != null) {
            iVar.d();
            this.x = null;
        }
    }

    private void s() {
        q();
        r();
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j2) {
        return new b.a(downloadInfo.getId()).a(-1).a(0L).e(j2).b(j2).c(0).d(downloadInfo.getTotalBytes() - j2).a();
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.e.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
        if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
            a2.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "dcache::add head IF_MODIFIED_SINCE=" + this.p.getLastModified());
        }
        return a2;
    }

    private void t() throws BaseException {
        if (this.g == null) {
            return;
        }
        if (this.n == i.RUN_STATUS_CANCELED) {
            this.p.setStatus(-4);
            this.g.c();
        } else if (this.n == i.RUN_STATUS_PAUSE) {
            this.p.setStatus(-2);
            this.g.b();
        } else {
            this.g.d();
        }
    }

    private boolean u() {
        return this.n == i.RUN_STATUS_CANCELED || this.n == i.RUN_STATUS_PAUSE;
    }

    private boolean v() {
        if (!u() && this.p.getStatus() != -2) {
            return false;
        }
        if (u()) {
            return true;
        }
        if (this.p.getStatus() == -2) {
            this.n = i.RUN_STATUS_PAUSE;
            return true;
        } else if (this.p.getStatus() != -4) {
            return true;
        } else {
            this.n = i.RUN_STATUS_CANCELED;
            return true;
        }
    }

    private boolean w() {
        if (this.n == i.RUN_STATUS_ERROR) {
            this.v.a(this.w);
        } else if (this.n == i.RUN_STATUS_CANCELED) {
            this.v.c();
        } else if (this.n == i.RUN_STATUS_PAUSE) {
            this.v.d();
        } else if (this.n == i.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.v.g();
            } catch (BaseException e2) {
                this.v.a(e2);
            }
        } else if (this.n == i.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.v.a(this.E);
            } catch (BaseException e3) {
                this.v.a(e3);
            }
        } else if (this.n == i.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.v.a(this.w, false);
            return false;
        } else if (this.n == i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            if (this.n != i.RUN_STATUS_RETRY_DELAY || x()) {
                try {
                    if (!y()) {
                        return false;
                    }
                    this.v.f();
                    com.ss.android.socialbase.downloader.impls.r.a().d();
                } catch (Throwable th) {
                    b(new BaseException(1008, com.ss.android.socialbase.downloader.i.e.b(th, "doTaskStatusHandle onComplete")));
                }
            } else {
                com.ss.android.socialbase.downloader.c.a.b(a, "doTaskStatusHandle retryDelay");
                z();
                if (this.n == i.RUN_STATUS_RETRY_DELAY) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    private boolean x() {
        if (this.p.getChunkCount() <= 1) {
            return this.p.getCurBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
        if (c2 == null || c2.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar == null || !bVar.i()) {
                return false;
            }
            while (r0.hasNext()) {
            }
        }
        return true;
    }

    private boolean y() {
        if (this.p.isChunked()) {
            DownloadInfo downloadInfo = this.p;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.p.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.p.getTotalBytes());
        if (this.p.getCurBytes() > 0) {
            if (this.p.isIgnoreDataVerify()) {
                return true;
            }
            if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                return true;
            }
        }
        this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.p.reset();
        this.o.a(this.p);
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.e.a(this.p);
        return false;
    }

    private void z() {
        this.n = i.RUN_STATUS_NONE;
    }

    private long A() {
        return this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount());
    }

    private void B() throws h, BaseException {
        com.ss.android.socialbase.downloader.impls.a C2;
        int id = this.p.getId();
        int a2 = com.ss.android.socialbase.downloader.downloader.b.a(this.p);
        if (!this.p.isDownloaded() || this.p.isExpiredRedownload() || this.F) {
            DownloadInfo b2 = this.o.b(a2);
            if (!(b2 == null || (C2 = com.ss.android.socialbase.downloader.downloader.b.C()) == null || b2.getId() == id || !b2.equalsTask(this.p))) {
                if (!C2.a(b2.getId())) {
                    List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(a2);
                    com.ss.android.socialbase.downloader.i.e.a(this.p);
                    this.o.f(a2);
                    if (b2 != null && b2.isBreakpointAvailable()) {
                        this.p.copyFromCacheData(b2, false);
                        this.o.a(this.p);
                        if (c2 != null) {
                            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                                bVar.b(id);
                                this.o.a(bVar);
                            }
                        }
                        throw new h("retry task because id generator changed");
                    }
                    return;
                }
                this.o.f(id);
                throw new BaseException(1025, "another same task is downloading");
            }
            return;
        }
        throw new BaseException(1009, "file has downloaded");
    }

    private void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i2) {
            a(list, this.p.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void a(long j2, int i2) throws BaseException {
        long j3 = j2 / ((long) i2);
        int id = this.p.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            com.ss.android.socialbase.downloader.model.b a2 = new b.a(id).a(i3).a(j4).e(j4).b(j4).c(i3 == i2 + -1 ? 0 : (j4 + j3) - 1).a();
            arrayList.add(a2);
            this.o.a(a2);
            j4 += j3;
            i3++;
        }
        this.p.setChunkCount(i2);
        this.o.a(id, i2);
        a(arrayList, j2);
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j2) throws BaseException {
        long j3;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    j3 = j2 - bVar.n();
                } else {
                    j3 = (bVar.p() - bVar.n()) + 1;
                }
                if (j3 > 0) {
                    bVar.a(j3);
                    if (!this.p.isNeedReuseFirstConnection() || this.x == null || (this.p.isHeadConnectionAvailable() && !this.D)) {
                        this.f.add(new b(bVar, this.c, this));
                    } else if (bVar.s() == 0) {
                        this.f.add(new b(bVar, this.c, this.x, this));
                    } else if (bVar.s() > 0) {
                        this.f.add(new b(bVar, this.c, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.i.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it2 = this.f.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (this.n == i.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.n == i.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> d2 = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.e(d2)) {
                    if (!v()) {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        return;
                    }
                }
                if (!(d2 == null || d2.isEmpty())) {
                    for (Future future : d2) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        } else {
            ArrayList arrayList2 = new ArrayList(this.f.size());
            Iterator<b> it3 = this.f.iterator();
            while (it3.hasNext()) {
                b next2 = it3.next();
                if (this.n == i.RUN_STATUS_CANCELED) {
                    next2.b();
                } else if (this.n == i.RUN_STATUS_PAUSE) {
                    next2.a();
                } else {
                    arrayList2.add(Executors.callable(next2));
                }
            }
            if (!v()) {
                try {
                    com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
                } catch (InterruptedException e2) {
                    throw new BaseException(1020, e2);
                }
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, com.ss.android.socialbase.downloader.network.i iVar) throws BaseException {
        bVar.a(this.p.getTotalBytes() - bVar.n());
        this.p.setChunkCount(1);
        this.o.a(this.p.getId(), 1);
        this.g = new d(this.p, str, iVar, bVar, this);
        t();
    }

    private boolean C() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        if ((!this.i || this.p.getChunkCount() > 1) && !this.p.isChunkDowngradeRetryUsed() && this.j && !this.l) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0108, code lost:
        if (r5 > r24) goto L_0x0165;
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(long j2) throws BaseException {
        long j3;
        boolean z2;
        long j4;
        String tempPath = this.p.getTempPath();
        String tempName = this.p.getTempName();
        if (!com.ss.android.socialbase.downloader.i.e.b(j2)) {
            com.ss.android.socialbase.downloader.model.e a2 = com.ss.android.socialbase.downloader.i.e.a(tempPath, tempName, -1);
            try {
                long length = new File(tempPath, tempName).length();
                long j5 = j2 - length;
                long d2 = com.ss.android.socialbase.downloader.i.e.d(tempPath);
                a a3 = a.a(this.p.getId());
                if (a3.a("space_fill_part_download", 0) == 1) {
                    this.G = 0;
                    if (j5 <= 0) {
                        j5 = this.p.getTotalBytes() - this.p.getCurBytes();
                    }
                    if (d2 < j5) {
                        String str = a;
                        com.ss.android.socialbase.downloader.c.a.d(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.i.e.a(j2) + "MB, downloaded = " + com.ss.android.socialbase.downloader.i.e.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.i.e.a(j5) + "MB, available = " + com.ss.android.socialbase.downloader.i.e.a(d2) + "MB");
                        int i2 = (d2 > 0 ? 1 : (d2 == 0 ? 0 : -1));
                        if (i2 > 0) {
                            int a4 = a3.a("space_fill_min_keep_mb", 100);
                            if (a4 > 0) {
                                long j6 = d2 - (((long) a4) * 1048576);
                                com.ss.android.socialbase.downloader.c.a.d(str, "checkSpaceOverflow: minKeep = " + a4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.e.a(j6) + "MB");
                                if (j6 > 0) {
                                    this.G = this.p.getCurBytes() + j6;
                                    j4 = j6;
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.d(d2, j5);
                                }
                            } else {
                                j4 = d2;
                            }
                            if (length < j2) {
                                j3 = j4 + length;
                            }
                        } else if (a3.a("download_when_space_negative", 0) == 1) {
                            j3 = j2;
                            z2 = false;
                            a2.b(j2);
                            com.ss.android.socialbase.downloader.i.e.a(a2);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("availableSpace ");
                            sb.append(i2 == 0 ? "=" : "<");
                            sb.append(" 0");
                            throw new BaseException(1052, sb.toString());
                        }
                    }
                } else {
                    int i3 = (d2 > 0 ? 1 : (d2 == 0 ? 0 : -1));
                    if (i3 <= 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("availableSpace ");
                        sb2.append(i3 == 0 ? "=" : "<");
                        sb2.append(" 0");
                        throw new BaseException(1052, sb2.toString());
                    } else if (d2 < j5) {
                        throw new com.ss.android.socialbase.downloader.exception.d(d2, j5);
                    }
                }
                j3 = j2;
                z2 = true;
                try {
                    a2.b(j2);
                } catch (Throwable th) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.e(str2, "checkSpaceOverflow: setLength2 ex = " + th + ", mustSetLength = " + z2);
                    if (z2) {
                        throw new BaseException(1040, th);
                    }
                }
                com.ss.android.socialbase.downloader.i.e.a(a2);
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.i.e.a(a2);
                throw th2;
            }
        }
    }

    private void D() throws BaseException {
        long j2;
        int a2;
        try {
            j2 = com.ss.android.socialbase.downloader.i.e.d(this.p.getTempPath());
        } catch (BaseException unused) {
            j2 = 0;
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.i.e.a(j2) + "MB");
        if (j2 > 0) {
            long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
            if (j2 < totalBytes && (a2 = a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j3 = j2 - (((long) a2) * 1048576);
                com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.e.a(j3) + "MB");
                if (j3 > 0) {
                    this.G = this.p.getCurBytes() + j3 + 1048576;
                    return;
                } else {
                    this.G = 0;
                    throw new com.ss.android.socialbase.downloader.exception.d(j2, totalBytes);
                }
            }
        }
        this.G = 0;
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.e.a(com.ss.android.socialbase.downloader.downloader.b.L(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        } else if (!this.p.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.c();
        } else if (!this.p.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.e();
        }
    }

    private void F() throws BaseException {
        if (TextUtils.isEmpty(this.p.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        } else if (!TextUtils.isEmpty(this.p.getName())) {
            File file = new File(this.p.getSavePath());
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    throw new BaseException(1030, "download savePath directory can not created");
                }
            } else if (!file.isDirectory()) {
                throw new BaseException(1031, "download savePath is not a directory");
            }
        } else {
            throw new BaseException(1029, "download name can not be empty");
        }
    }

    private boolean a(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2) && (this.k || this.j)) {
            return true;
        }
        if ((i2 == 201 || i2 == 416) && this.p.getCurBytes() > 0) {
            return true;
        }
        return false;
    }

    private void a(String str, String str2) throws h {
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.e.a(this.p);
        this.i = false;
        this.p.resetDataForEtagEndure(str);
        this.o.a(this.p);
        throw new h(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca A[Catch:{ BaseException -> 0x0226, h -> 0x0224, all -> 0x021d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d0 A[Catch:{ BaseException -> 0x0226, h -> 0x0224, all -> 0x021d }] */
    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j2) throws BaseException, h {
        String str2;
        long j3;
        boolean z2;
        if (gVar != null) {
            try {
                com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, gVar);
                int i2 = dVar.c;
                String d2 = dVar.d();
                if (TextUtils.isEmpty(this.p.getMimeType()) && !TextUtils.isEmpty(d2)) {
                    this.p.setMimeType(d2);
                }
                boolean b2 = dVar.b();
                this.j = b2;
                this.p.setSupportPartial(b2);
                this.k = dVar.a();
                String str3 = this.p.geteTag();
                String c2 = dVar.c();
                String f2 = dVar.f();
                String g2 = dVar.g();
                String str4 = a;
                com.ss.android.socialbase.downloader.c.a.b(str4, "dcache=last_modified=" + f2 + " CACHE_CONTROL=" + g2 + " max-age=" + dVar.k());
                if (!TextUtils.isEmpty(g2)) {
                    this.p.setCacheControl(g2);
                    if (dVar.k() > 0) {
                        this.p.setCacheExpiredTime(System.currentTimeMillis() + (dVar.k() * 1000));
                    }
                }
                if (this.p.isExpiredRedownload() && this.F && !TextUtils.isEmpty(this.E)) {
                    if (i2 != 304) {
                        if (!TextUtils.equals(f2, this.p.getLastModified())) {
                            z2 = false;
                            if (z2) {
                                com.ss.android.socialbase.downloader.i.e.a(this.p);
                            } else {
                                com.ss.android.socialbase.downloader.c.a.b(str4, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                                throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                if (!TextUtils.isEmpty(f2)) {
                    this.p.setLastModified(f2);
                }
                if (a(i2, str3, c2)) {
                    if (gVar instanceof com.ss.android.socialbase.downloader.network.i) {
                        if (!TextUtils.isEmpty(str3) && str3.equals(c2)) {
                            c2 = "";
                        }
                        a(c2, "eTag of server file changed");
                    } else {
                        throw new com.ss.android.socialbase.downloader.exception.b(1002, i2, "");
                    }
                }
                if (this.j || this.k) {
                    if (this.k && j2 > 0) {
                        if (gVar instanceof com.ss.android.socialbase.downloader.network.i) {
                            a("", "http head request not support");
                        } else {
                            throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                        }
                    }
                    long h2 = dVar.h();
                    if (TextUtils.isEmpty(this.p.getName())) {
                        str2 = com.ss.android.socialbase.downloader.i.e.a(gVar, this.p.getUrl());
                    } else {
                        str2 = "";
                    }
                    boolean i3 = dVar.i();
                    this.l = i3;
                    if (i3 || h2 != 0 || (gVar instanceof com.ss.android.socialbase.downloader.network.i)) {
                        if (!i3) {
                            String b3 = com.ss.android.socialbase.downloader.i.e.b(gVar, "Content-Range");
                            j3 = (TextUtils.isEmpty(b3) || !com.ss.android.socialbase.downloader.i.a.a(2)) ? j2 + h2 : com.ss.android.socialbase.downloader.i.e.b(b3);
                        } else {
                            j3 = -1;
                        }
                        if (!v()) {
                            if (this.p.getExpectFileLength() <= 0 || a.a(this.p.getId()).b("force_check_file_length") != 1 || this.p.getExpectFileLength() == j3) {
                                this.v.a(j3, c2, str2);
                                return;
                            }
                            throw new BaseException(1070, "expectFileLength = " + this.p.getExpectFileLength() + " , totalLength = " + j3);
                        }
                        return;
                    }
                    throw new BaseException(1004, "");
                } else if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (h e3) {
                throw e3;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.e.a(th, "HandleFirstConnection");
            }
        }
    }

    public boolean d() {
        return this.m.get();
    }

    public int e() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.v.a();
    }

    private void G() {
        long e2 = com.ss.android.socialbase.downloader.i.e.e(this.p);
        long curBytes = this.p.getCurBytes();
        if (e2 != curBytes) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.d(str, "checkTaskCanResume: offset = " + e2 + ", curBytes = " + curBytes);
        }
        this.p.setCurBytes(e2);
        boolean z2 = e2 > 0;
        this.i = z2;
        if (!z2 && !this.F) {
            com.ss.android.socialbase.downloader.c.a.c(a, "checkTaskCanResume: deleteAllDownloadFiles");
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.e.a(this.p);
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j2) throws BaseException {
        if (this.G > 0 && this.p.getCurBytes() > this.G) {
            D();
        }
        return this.v.a(j2);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        if (!this.h) {
            synchronized (this) {
                this.f.remove(bVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        if (this.K != null && com.ss.android.socialbase.downloader.i.e.h(baseException) && this.e.get() < this.p.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.i.e.b(baseException)) {
            if (this.h && !this.d) {
                com.ss.android.socialbase.downloader.i.e.a(this.p);
                this.d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.e;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                return false;
            }
        }
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.f)) {
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "onError:" + baseException.getMessage());
        this.n = i.RUN_STATUS_ERROR;
        this.w = baseException;
        I();
    }

    private void H() {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.d(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.e.a(this.p);
            this.i = false;
            this.p.resetDataForEtagEndure("");
            this.o.a(this.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        a(baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z2) {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAllChunkRetryWithReset");
        this.n = i.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.w = baseException;
        I();
        if (!(z2 ? d(baseException) : false)) {
            H();
        }
    }

    private void I() {
        try {
            Iterator it2 = ((ArrayList) this.f.clone()).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.c(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* access modifiers changed from: private */
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.p.setForbiddenBackupUrls(list, this.n == i.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a C2 = com.ss.android.socialbase.downloader.downloader.b.C();
            if (C2 != null) {
                C2.l(this.p.getId());
            }
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a C2;
        if (!v() && (C2 = com.ss.android.socialbase.downloader.downloader.b.C()) != null) {
            C2.l(this.p.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.g a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2) {
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.e.g(baseException))) {
            return a(baseException, j2);
        }
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        this.v.a(bVar, baseException, this.n == i.RUN_STATUS_RETRY_DELAY);
        if (this.n != i.RUN_STATUS_RETRY_DELAY && this.p.isNeedRetryDelay()) {
            long A2 = A();
            if (A2 > 0) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.c(str, "onSingleChunkRetry with delay time " + A2);
                try {
                    Thread.sleep(A2);
                } catch (Throwable th) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.g.CONTINUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011a  */
    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.g a(BaseException baseException, long j2) {
        boolean z2;
        long j3;
        long j4;
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        boolean z3 = true;
        if (baseException == null || baseException.getErrorCode() != 1047) {
            if (!com.ss.android.socialbase.downloader.i.e.g(baseException)) {
                if (d(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.g.RETURN;
                }
                z2 = false;
                if (!z2 && K()) {
                    I();
                }
                e eVar = this.v;
                if (this.n != i.RUN_STATUS_RETRY_DELAY) {
                    z3 = false;
                }
                eVar.a(baseException, z3);
                return this.n != i.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.exception.g.RETURN : com.ss.android.socialbase.downloader.exception.g.CONTINUE;
            } else if (this.A == null) {
                b(baseException);
                return com.ss.android.socialbase.downloader.exception.g.RETURN;
            } else {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                AnonymousClass2 r6 = new com.ss.android.socialbase.downloader.depend.q() {
                    /* class com.ss.android.socialbase.downloader.h.c.AnonymousClass2 */

                    @Override // com.ss.android.socialbase.downloader.depend.q
                    public void a() {
                        synchronized (c.this) {
                            atomicBoolean.set(true);
                            c.this.J();
                        }
                    }
                };
                if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                    com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                    j4 = dVar.a();
                    j3 = dVar.b();
                } else {
                    j3 = this.p.getTotalBytes();
                    j4 = -1;
                }
                synchronized (this) {
                    if (this.A.a(j4, j3, r6)) {
                        if (!a.a(this.p.getId()).b("not_delete_when_clean_space", false)) {
                            y();
                        }
                        if (!atomicBoolean.get()) {
                            if (this.n != i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                                this.n = i.RUN_STATUS_WAITING_ASYNC_HANDLER;
                                I();
                                this.v.h();
                            }
                            return com.ss.android.socialbase.downloader.exception.g.RETURN;
                        }
                    } else if (this.n == i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.g.RETURN;
                    } else {
                        b(baseException);
                        return com.ss.android.socialbase.downloader.exception.g.RETURN;
                    }
                }
                if (d(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.g.RETURN;
                }
            }
        } else if (this.z == null || this.p.isForbiddenRetryed()) {
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.g.RETURN;
            }
            z2 = false;
            I();
            e eVar = this.v;
            if (this.n != i.RUN_STATUS_RETRY_DELAY) {
            }
            eVar.a(baseException, z3);
            if (this.n != i.RUN_STATUS_RETRY_DELAY) {
            }
        } else {
            AnonymousClass1 r0 = new com.ss.android.socialbase.downloader.depend.b() {
                /* class com.ss.android.socialbase.downloader.h.c.AnonymousClass1 */

                @Override // com.ss.android.socialbase.downloader.depend.b, com.ss.android.socialbase.downloader.depend.w
                public void a(List<String> list) {
                    super.a(list);
                    c.this.a(list);
                }
            };
            boolean a2 = this.z.a(r0);
            this.p.setForbiddenRetryed();
            if (a2) {
                if (!r0.a()) {
                    I();
                    this.v.h();
                    this.n = i.RUN_STATUS_WAITING_ASYNC_HANDLER;
                    return com.ss.android.socialbase.downloader.exception.g.RETURN;
                }
            }
            z2 = false;
            I();
            e eVar = this.v;
            if (this.n != i.RUN_STATUS_RETRY_DELAY) {
            }
            eVar.a(baseException, z3);
            if (this.n != i.RUN_STATUS_RETRY_DELAY) {
            }
        }
        z2 = true;
        I();
        e eVar = this.v;
        if (this.n != i.RUN_STATUS_RETRY_DELAY) {
        }
        eVar.a(baseException, z3);
        if (this.n != i.RUN_STATUS_RETRY_DELAY) {
        }
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.e;
        boolean z2 = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.p.trySwitchToNextBackupUrl()) {
                    this.e.set(this.p.getBackUpUrlRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                } else if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry())) {
                    b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                } else {
                    this.e.set(this.p.getRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                    this.p.setHttpsToHttpRetryUsed(true);
                }
                z2 = false;
            }
            if (this.n != i.RUN_STATUS_RETRY_DELAY && z2) {
                this.p.updateCurRetryTime(this.e.decrementAndGet());
            }
            return false;
        }
        b(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        com.ss.android.socialbase.downloader.model.b a2;
        if (this.p.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
        if (c2 == null || c2.isEmpty()) {
            return null;
        }
        for (int i3 = 0; i3 < c2.size(); i3++) {
            com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
            if (!(bVar == null || (a2 = a(bVar, i2)) == null)) {
                return a2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(com.ss.android.socialbase.downloader.network.g gVar) {
        boolean z2;
        if (gVar != null) {
            try {
                int b2 = gVar.b();
                this.p.setHttpStatusCode(b2);
                this.p.setHttpStatusMessage(com.ss.android.socialbase.downloader.i.b.a(b2));
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z2) {
                this.p.setHttpStatusCode(-1);
                this.p.setHttpStatusMessage("");
                return;
            }
            return;
        }
        z2 = false;
        if (z2) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        if (r9.f() != false) goto L_0x006e;
     */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b bVar, int i2) {
        com.ss.android.socialbase.downloader.model.b bVar2;
        com.ss.android.socialbase.downloader.model.b bVar3 = null;
        if (!bVar.d()) {
            return null;
        }
        long c2 = bVar.c(true);
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "reuseChunk retainLen:" + c2 + " chunkIndex:" + i2);
        boolean z2 = false;
        if (!bVar.f() && c2 > com.ss.android.socialbase.downloader.constants.e.f && this.p.isNeedReuseChunkRunnable()) {
            List<com.ss.android.socialbase.downloader.model.b> a2 = bVar.a(this.p.getChunkCount(), this.p.getTotalBytes());
            if (a2 != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar4 : a2) {
                    this.o.b(bVar4);
                }
            }
        }
        z2 = true;
        if (z2 && bVar.f()) {
            int i3 = 1;
            while (true) {
                if (i3 >= bVar.g().size()) {
                    break;
                }
                bVar2 = bVar.g().get(i3);
                if (bVar2 != null) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.b(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar2.s() + " currentOffset:" + bVar2.n() + "  startOffset:" + bVar2.l() + " contentLen:" + bVar2.q());
                    if (bVar2.s() < 0 || (!bVar2.i() && !bVar2.c())) {
                        break;
                    }
                }
                i3++;
            }
            bVar3 = bVar2;
            if (bVar3 != null) {
                long n2 = bVar.n();
                String str3 = a;
                com.ss.android.socialbase.downloader.c.a.b(str3, "unComplete chunk " + bVar.s() + " curOffset:" + n2 + " reuseChunk chunkIndex:" + i2 + " for subChunk:" + bVar3.s());
                this.o.a(bVar3.k(), bVar3.s(), bVar3.b(), i2);
                bVar3.c(i2);
                bVar3.a(true);
            }
        }
        return bVar3;
    }

    private q a(DownloadTask downloadTask) {
        q retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.q(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.b.K();
    }

    public Future g() {
        return this.b;
    }

    public void a(Future future) {
        this.b = future;
    }

    public void c(long j2) {
        com.ss.android.socialbase.downloader.network.i iVar = this.x;
        if (iVar != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
