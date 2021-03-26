package com.ss.android.socialbase.downloader.f;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.f;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.d;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: SegmentReader */
class m implements Runnable {
    private volatile boolean A;
    private int B;
    private int C;
    private int D;
    private long E;
    private int F;
    private boolean G;
    private BaseException H;
    private boolean I;
    private boolean J;
    private d K;
    q a;
    final int b;
    volatile long c;
    volatile long d;
    volatile long e;
    volatile long f;
    String g;
    String h;
    String i;
    private final f j;
    private final c k;

    /* renamed from: l  reason: collision with root package name */
    private final DownloadInfo f1414l;
    private final a m;
    private i n;
    private com.ss.android.socialbase.downloader.model.d o;
    private final List<i> p = new ArrayList();
    private long q;
    private volatile long r;
    private volatile long s;
    private volatile long t = -1;
    private volatile long u;
    private Future v;
    private volatile boolean w;
    private volatile boolean x;
    private volatile boolean y;
    private Thread z;

    m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i2) {
        this.f1414l = downloadInfo;
        this.j = kVar;
        this.k = cVar;
        this.m = a.a(downloadInfo.getId());
        this.a = qVar;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        i a2;
        f fVar2;
        f fVar3;
        Process.setThreadPriority(10);
        try {
            this.z = Thread.currentThread();
            this.j.a(this);
            this.a.a(this);
            while (true) {
                a2 = this.j.a(this, this.a);
                if (a2 == null) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "no more segment, thread_index = " + this.b);
                    break;
                }
                try {
                    if (a(a2)) {
                        this.p.add(a2);
                        fVar3 = this.j;
                        fVar3.a(this, a2);
                    } else {
                        if (!this.w) {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download segment failed, segment = " + a2 + ", thread_index = " + this.b + ", failedException = " + this.H);
                        }
                        fVar2 = this.j;
                    }
                } catch (j unused) {
                    int i2 = this.B;
                    if (i2 >= 50) {
                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "segment apply failed " + this.B + "times, thread_index = " + this.b);
                        fVar2 = this.j;
                        break;
                    }
                    this.B = i2 + 1;
                    fVar3 = this.j;
                } catch (Throwable th) {
                    this.j.a(this, a2);
                    throw th;
                }
            }
            fVar2.a(this, a2);
            try {
                this.a.b(this);
                fVar = this.j;
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            try {
                this.a.b(this);
                this.j.b(this);
            } catch (Throwable unused3) {
            }
            this.z = null;
            throw th2;
        }
        fVar.b(this);
        this.z = null;
    }

    private boolean a(i iVar) throws BaseException {
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                i();
                return true;
            } catch (j e2) {
                this.H = e2;
                throw e2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        i();
        return false;
        if (!this.y) {
            i();
        } else {
            this.y = false;
            throw new j(5, "download");
        }
    }

    private void i() {
        this.E = this.c;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        j();
    }

    private void j() {
        i iVar = this.n;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.b);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.G = false;
        l();
    }

    private void l() {
        this.C = this.a.d ? this.f1414l.getRetryCount() : this.f1414l.getBackUpUrlRetryCount();
        this.D = 0;
    }

    boolean a(q qVar) {
        int i2 = this.F;
        if (i2 >= 30) {
            return false;
        }
        this.F = i2 + 1;
        q qVar2 = this.a;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.a = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.D + ", retryCount = " + this.C);
        this.H = baseException;
        this.a.b();
        this.j.a(this, this.a, iVar, baseException, this.D, this.C);
        int i2 = this.D;
        if (i2 < this.C) {
            this.D = i2 + 1;
            return true;
        } else if (a(baseException)) {
            return true;
        } else {
            this.j.a(this, this.a, iVar, baseException);
            return false;
        }
    }

    private boolean a(BaseException baseException) {
        if (!e.c(baseException)) {
            return false;
        }
        String str = this.a.a;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f1414l.isNeedHttpsToHttpRetry() || this.G) {
            return false;
        }
        this.G = true;
        l();
        return true;
    }

    private void b(i iVar) throws BaseException, h {
        c(iVar);
        a(iVar, this.o);
        this.j.a(this, iVar, this.a, this.o);
        this.a.c();
    }

    private void c(i iVar) throws BaseException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.d = 0;
            this.c = currentTimeMillis;
            this.q = iVar.d();
            this.s = iVar.f();
            this.t = this.q;
            this.K = new d();
            List<c> a2 = e.a(this.f1414l.getExtraHeaders(), this.f1414l.geteTag(), this.q, this.s);
            a2.add(new c("Segment-Index", String.valueOf(iVar.g())));
            a2.add(new c("Thread-Index", String.valueOf(this.b)));
            e.a(a2, this.f1414l);
            String str = this.a.a;
            if (this.G && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                str = str.replaceFirst("https", "http");
            }
            String str2 = this.a.b;
            com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.b);
            this.g = str;
            this.h = str2;
            i a3 = b.a(this.f1414l.isNeedDefaultHttpServiceBackUp(), this.f1414l.getMaxBytes(), str, str2, a2, 0, currentTimeMillis - this.E > 3000 && this.m.b("monitor_download_connect") > 0, this.f1414l);
            if (a3 != null) {
                this.n = a3;
                this.o = new com.ss.android.socialbase.downloader.model.d(str, a3);
                if (!this.w) {
                    if (a3 instanceof com.ss.android.socialbase.downloader.network.a) {
                        this.i = ((com.ss.android.socialbase.downloader.network.a) a3).e();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.i + ", threadIndex = " + this.b);
                    this.d = System.currentTimeMillis();
                    return;
                }
                throw new p("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } catch (BaseException e2) {
            throw e2;
        } catch (Throwable th) {
            this.d = System.currentTimeMillis();
            throw th;
        }
    }

    private void a(i iVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        if (dVar.b()) {
            return;
        }
        if (iVar.d() <= 0) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "parseHttpResponse: segment.getCurrentOffset = " + iVar.d());
            if (!dVar.a()) {
                int i2 = dVar.c;
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + dVar.c + " segment=" + iVar);
            }
            return;
        }
        int i3 = dVar.c;
        throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + dVar.c + " segment=" + iVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x014e, code lost:
        r21 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0152, code lost:
        if (r13 <= r21) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r15.c = (int) (r6 - (r13 - r21));
        r13 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x015d, code lost:
        r31.t = r13;
        r26.b(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead: bytesRead = " + (r13 - r4) + ", url = " + r31.a.a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0188, code lost:
        r9 = r26;
        r23 = r13;
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x020b, code lost:
        if (r31.x == false) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x020f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0210, code lost:
        r9 = r26;
        r23 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0215, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x022d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x022e, code lost:
        r9 = r26;
        r23 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0233, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0323, code lost:
        if (r31.x == false) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0326, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cc, code lost:
        r11 = r6 + 1;
        r8 = r23 - r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d4, code lost:
        if (r8 <= r13) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: redundant = " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r31.t = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ee, code lost:
        r23 = r11;
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f4, code lost:
        r23 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0108, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x010e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x010f, code lost:
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0113, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0135, code lost:
        r8 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r8.b(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x013a, code lost:
        r6 = r11;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x013f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0142, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01de A[SYNTHETIC, Splitter:B:123:0x01de] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0135 A[EDGE_INSN: B:250:0x0135->B:91:0x0135 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a A[SYNTHETIC, Splitter:B:42:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0145  */
    private void d(i iVar) throws BaseException {
        BaseException e2;
        long j2;
        String str;
        String str2;
        String str3;
        DownloadInfo downloadInfo;
        a aVar;
        a aVar2;
        InputStream inputStream;
        e eVar;
        Throwable th;
        a aVar3;
        a aVar4;
        long h2;
        long j3;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        a aVar5;
        e eVar2;
        e eVar3;
        int read;
        long j8;
        c cVar = this.k;
        this.e = System.currentTimeMillis();
        long d2 = iVar.d();
        boolean z2 = false;
        try {
            inputStream = this.n.a();
        } catch (BaseException e3) {
            e2 = e3;
            this.H = e2;
            throw e2;
        } catch (Throwable th2) {
            th = th2;
            j2 = d2;
            eVar = null;
            inputStream = null;
            aVar2 = null;
            try {
                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                th.printStackTrace();
                try {
                    e.a(th, "loopAndRead");
                    this.j.c(this, iVar);
                    e.a(inputStream);
                    if (eVar != null) {
                        if (aVar2 == null) {
                            try {
                                aVar2 = cVar.b();
                            } catch (Throwable unused) {
                                aVar4 = aVar2;
                                if (aVar4 != null) {
                                }
                                this.f = System.currentTimeMillis();
                                if (j2 > d2) {
                                }
                            }
                        }
                        aVar2.c = -1;
                        eVar.b(aVar2);
                        aVar4 = null;
                        if (aVar4 != null) {
                            cVar.a(aVar4);
                        }
                        this.f = System.currentTimeMillis();
                        if (j2 > d2) {
                            aVar = this.m;
                            downloadInfo = this.f1414l;
                            str3 = this.g;
                            str2 = this.h;
                            str = this.i;
                            if (!this.w) {
                            }
                            boolean z3 = true;
                            com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str3, str2, str, z3, this.n, this.H, j2 - d2, TimeUnit.MILLISECONDS.toNanos(this.f - this.e));
                            return;
                        }
                        return;
                    }
                    aVar4 = aVar2;
                    if (aVar4 != null) {
                    }
                    this.f = System.currentTimeMillis();
                    if (j2 > d2) {
                    }
                } catch (BaseException e4) {
                    this.H = e4;
                    throw e4;
                }
            } catch (Throwable unused2) {
                aVar3 = aVar2;
                if (aVar3 != null) {
                }
                this.f = System.currentTimeMillis();
                if (j2 > d2) {
                }
                throw th;
            }
        }
        if (inputStream != null) {
            try {
                h2 = this.o.h();
                j3 = 0;
                i2 = (h2 > 0 ? 1 : (h2 == 0 ? 0 : -1));
            } catch (BaseException e5) {
                e2 = e5;
                this.H = e2;
                throw e2;
            } catch (Throwable th3) {
                th = th3;
                j2 = d2;
                eVar = null;
                aVar2 = null;
                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                th.printStackTrace();
                e.a(th, "loopAndRead");
                this.j.c(this, iVar);
                e.a(inputStream);
                if (eVar != null) {
                }
                aVar4 = aVar2;
                if (aVar4 != null) {
                }
                this.f = System.currentTimeMillis();
                if (j2 > d2) {
                }
            }
            if (i2 != 0) {
                aVar2 = a(cVar, inputStream);
                try {
                } catch (BaseException e6) {
                    e2 = e6;
                    this.H = e2;
                    throw e2;
                } catch (Throwable th4) {
                    th = th4;
                    j2 = d2;
                    eVar = null;
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                    th.printStackTrace();
                    e.a(th, "loopAndRead");
                    this.j.c(this, iVar);
                    e.a(inputStream);
                    if (eVar != null) {
                    }
                    aVar4 = aVar2;
                    if (aVar4 != null) {
                    }
                    this.f = System.currentTimeMillis();
                    if (j2 > d2) {
                    }
                }
                if (this.x || this.w) {
                    throw new p("probe");
                }
                this.j.b(this, iVar);
                eVar = this.j.d(this, iVar);
                try {
                    if (iVar.f() > 0) {
                        try {
                            j4 = iVar.f();
                        } catch (BaseException e7) {
                            e2 = e7;
                        } catch (Throwable th5) {
                            th = th5;
                            j2 = d2;
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                            th.printStackTrace();
                            e.a(th, "loopAndRead");
                            this.j.c(this, iVar);
                            e.a(inputStream);
                            if (eVar != null) {
                            }
                            aVar4 = aVar2;
                            if (aVar4 != null) {
                            }
                            this.f = System.currentTimeMillis();
                            if (j2 > d2) {
                            }
                        }
                    } else {
                        j4 = i2 > 0 ? (h2 + d2) - 1 : Long.MAX_VALUE;
                    }
                    j5 = (long) aVar2.c;
                    j2 = d2 + j5;
                    j6 = j2;
                    try {
                        this.t = j6;
                        eVar.b(aVar2);
                        j2 = j6;
                        while (true) {
                            try {
                                if (this.A) {
                                }
                                eVar2 = eVar;
                                try {
                                    aVar2 = cVar.b();
                                    try {
                                        read = inputStream.read(aVar2.a);
                                        aVar2.c = read;
                                        if (read == -1) {
                                        }
                                        this.t = j8;
                                        eVar2.b(aVar2);
                                        eVar = eVar2;
                                        j2 = j8;
                                        z2 = false;
                                        j3 = 0;
                                        j4 = j4;
                                    } catch (BaseException e8) {
                                        e2 = e8;
                                        eVar3 = eVar2;
                                        this.H = e2;
                                        throw e2;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        eVar3 = eVar2;
                                        eVar = eVar3;
                                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                        th.printStackTrace();
                                        e.a(th, "loopAndRead");
                                        this.j.c(this, iVar);
                                        e.a(inputStream);
                                        if (eVar != null) {
                                        }
                                        aVar4 = aVar2;
                                        if (aVar4 != null) {
                                        }
                                        this.f = System.currentTimeMillis();
                                        if (j2 > d2) {
                                        }
                                    }
                                } catch (BaseException e9) {
                                    e2 = e9;
                                    this.H = e2;
                                    throw e2;
                                } catch (Throwable th7) {
                                    th = th7;
                                    eVar = eVar2;
                                    aVar2 = null;
                                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                    th.printStackTrace();
                                    e.a(th, "loopAndRead");
                                    this.j.c(this, iVar);
                                    e.a(inputStream);
                                    if (eVar != null) {
                                    }
                                    aVar4 = aVar2;
                                    if (aVar4 != null) {
                                    }
                                    this.f = System.currentTimeMillis();
                                    if (j2 > d2) {
                                    }
                                }
                            } catch (BaseException e10) {
                                e2 = e10;
                                this.H = e2;
                                throw e2;
                            } catch (Throwable th8) {
                                th = th8;
                                aVar2 = null;
                                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                th.printStackTrace();
                                e.a(th, "loopAndRead");
                                this.j.c(this, iVar);
                                e.a(inputStream);
                                if (eVar != null) {
                                }
                                aVar4 = aVar2;
                                if (aVar4 != null) {
                                }
                                this.f = System.currentTimeMillis();
                                if (j2 > d2) {
                                }
                            }
                        }
                        if (j7 > 0) {
                        }
                        this.j.c(this, iVar);
                        e.a(inputStream);
                        if (eVar != null) {
                        }
                        aVar5 = null;
                        if (aVar5 != null) {
                        }
                        this.f = System.currentTimeMillis();
                        if (j2 <= d2) {
                        }
                    } catch (BaseException e11) {
                        e2 = e11;
                        this.H = e2;
                        throw e2;
                    } catch (Throwable th9) {
                        th = th9;
                        j2 = j6;
                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                        th.printStackTrace();
                        e.a(th, "loopAndRead");
                        this.j.c(this, iVar);
                        e.a(inputStream);
                        if (eVar != null) {
                        }
                        aVar4 = aVar2;
                        if (aVar4 != null) {
                        }
                        this.f = System.currentTimeMillis();
                        if (j2 > d2) {
                        }
                    }
                } catch (BaseException e12) {
                    e2 = e12;
                    this.H = e2;
                    throw e2;
                } catch (Throwable th10) {
                    th = th10;
                    j2 = d2;
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                    th.printStackTrace();
                    e.a(th, "loopAndRead");
                    this.j.c(this, iVar);
                    e.a(inputStream);
                    if (eVar != null) {
                    }
                    aVar4 = aVar2;
                    if (aVar4 != null) {
                    }
                    this.f = System.currentTimeMillis();
                    if (j2 > d2) {
                    }
                }
                if (j2 > j4) {
                    long j9 = j4 + 1;
                    if (j2 > j9) {
                        try {
                            aVar2.c = (int) (j5 - (j2 - j9));
                            j6 = j9;
                            this.t = j6;
                            eVar.b(aVar2);
                            j2 = j6;
                            if (j7 > 0 || j7 == Long.MAX_VALUE || j2 > j7) {
                                this.j.c(this, iVar);
                                e.a(inputStream);
                                if (eVar != null) {
                                    try {
                                        a b2 = cVar.b();
                                        try {
                                            b2.c = -1;
                                            eVar.b(b2);
                                        } catch (Throwable unused3) {
                                            aVar5 = b2;
                                        }
                                    } catch (Throwable unused4) {
                                    }
                                }
                                aVar5 = null;
                                if (aVar5 != null) {
                                    cVar.a(aVar5);
                                }
                                this.f = System.currentTimeMillis();
                                if (j2 <= d2) {
                                    aVar = this.m;
                                    downloadInfo = this.f1414l;
                                    str3 = this.g;
                                    str2 = this.h;
                                    str = this.i;
                                    if (!this.w) {
                                    }
                                    boolean z3 = true;
                                    com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str3, str2, str, z3, this.n, this.H, j2 - d2, TimeUnit.MILLISECONDS.toNanos(this.f - this.e));
                                    return;
                                }
                                return;
                            }
                            try {
                                throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(d2), Long.valueOf(j7), Long.valueOf(j2), Long.valueOf(d2)));
                            } catch (BaseException e13) {
                                e2 = e13;
                                this.H = e2;
                                throw e2;
                            } catch (Throwable th11) {
                                th = th11;
                                aVar2 = null;
                                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                th.printStackTrace();
                                e.a(th, "loopAndRead");
                                this.j.c(this, iVar);
                                e.a(inputStream);
                                if (eVar != null) {
                                }
                                aVar4 = aVar2;
                                if (aVar4 != null) {
                                }
                                this.f = System.currentTimeMillis();
                                if (j2 > d2) {
                                }
                            }
                        } catch (BaseException e14) {
                            e2 = e14;
                            this.H = e2;
                            throw e2;
                        } catch (Throwable th12) {
                            th = th12;
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                            th.printStackTrace();
                            e.a(th, "loopAndRead");
                            this.j.c(this, iVar);
                            e.a(inputStream);
                            if (eVar != null) {
                            }
                            aVar4 = aVar2;
                            if (aVar4 != null) {
                            }
                            this.f = System.currentTimeMillis();
                            if (j2 > d2) {
                            }
                        }
                        while (true) {
                            if (this.A) {
                                try {
                                    if (this.r != j3) {
                                        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead:  change readEnd = " + j4 + ", segmentNewEndOffset = " + this.r + ", segment = " + iVar);
                                        j7 = m();
                                        if (j2 > j7) {
                                            break;
                                        }
                                        eVar2 = eVar;
                                        j4 = j7;
                                        aVar2 = cVar.b();
                                        read = inputStream.read(aVar2.a);
                                        aVar2.c = read;
                                        if (read == -1) {
                                            break;
                                        }
                                        long j10 = (long) read;
                                        j8 = j2 + j10;
                                        if (j8 > j4) {
                                            break;
                                        }
                                        this.t = j8;
                                        eVar2.b(aVar2);
                                        eVar = eVar2;
                                        j2 = j8;
                                        z2 = false;
                                        j3 = 0;
                                        j4 = j4;
                                    }
                                } catch (BaseException e15) {
                                    e2 = e15;
                                    this.H = e2;
                                    throw e2;
                                } catch (Throwable th13) {
                                    th = th13;
                                    aVar2 = null;
                                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                    th.printStackTrace();
                                    e.a(th, "loopAndRead");
                                    this.j.c(this, iVar);
                                    e.a(inputStream);
                                    if (eVar != null) {
                                    }
                                    aVar4 = aVar2;
                                    if (aVar4 != null) {
                                    }
                                    this.f = System.currentTimeMillis();
                                    if (j2 > d2) {
                                    }
                                }
                                synchronized (this) {
                                    try {
                                        this.A = z2;
                                    } catch (Throwable th14) {
                                        th = th14;
                                        throw th;
                                    }
                                    if (this.x || this.w) {
                                        break;
                                    }
                                }
                            }
                            eVar2 = eVar;
                            aVar2 = cVar.b();
                            read = inputStream.read(aVar2.a);
                            aVar2.c = read;
                            if (read == -1) {
                            }
                        }
                    }
                }
            } else {
                throw new f(1004, "the content-length is 0, contentLength = " + h2);
            }
        } else {
            throw new BaseException(1042, new IOException("inputStream is null"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    private a a(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i2;
        Throwable th;
        a b2 = cVar.b();
        try {
            i2 = inputStream.read(b2.a, 0, Math.min(b2.a.length, 1024));
            if (i2 != -1) {
                try {
                    b2.c = i2;
                    if (i2 == -1) {
                        cVar.a(b2);
                    }
                    return b2;
                } catch (Throwable th2) {
                    th = th2;
                    if (i2 == -1) {
                    }
                    throw th;
                }
            } else {
                throw new BaseException(1073, "probe");
            }
        } catch (Throwable th3) {
            th = th3;
            i2 = -1;
            if (i2 == -1) {
                cVar.a(b2);
            }
            throw th;
        }
    }

    private long m() {
        long j2 = this.r;
        this.r = 0;
        if (j2 <= 0) {
            return Long.MAX_VALUE;
        }
        return j2;
    }

    public boolean a(long j2) {
        long j3 = this.s;
        if (j2 <= 0 && j3 > 0) {
            return false;
        }
        if (j2 > j3 && j3 > 0) {
            return false;
        }
        this.r = j2;
        this.A = true;
        return true;
    }

    void a() {
        q qVar = this.a;
        try {
            synchronized (this.j) {
                long c2 = c();
                if (c2 > 0) {
                    this.u += c2;
                    qVar.a(c2);
                }
                this.t = -1;
            }
        } catch (Throwable unused) {
        }
    }

    public long b() {
        long c2;
        synchronized (this.j) {
            c2 = this.u + c();
        }
        return c2;
    }

    public long c() {
        synchronized (this.j) {
            long j2 = this.t;
            long j3 = this.q;
            if (j3 < 0 || j2 <= j3) {
                return 0;
            }
            return j2 - j3;
        }
    }

    public long d() {
        return this.t;
    }

    public void e() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.b);
        synchronized (this) {
            this.w = true;
            this.A = true;
        }
        j();
        Future future = this.v;
        if (future != null) {
            this.v = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    public void a(boolean z2) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.b);
        synchronized (this) {
            this.y = z2;
            this.x = true;
            this.A = true;
        }
        j();
        Thread thread = this.z;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.b);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    void a(Future future) {
        this.v = future;
    }

    void b(boolean z2) {
        this.I = z2;
    }

    boolean g() {
        return this.I;
    }

    public void c(boolean z2) {
        this.J = z2;
    }

    void b(long j2) {
        long j3 = this.t;
        d dVar = this.K;
        if (j3 >= 0 && dVar != null) {
            Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j3 + ", threadIndex = " + this.b);
            dVar.a(j3, j2);
        }
    }

    long a(long j2, long j3) {
        d dVar = this.K;
        if (dVar == null) {
            return -1;
        }
        return dVar.b(j2, j3);
    }

    long h() {
        return this.q;
    }
}
