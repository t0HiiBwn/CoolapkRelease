package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.c;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.h.f;
import com.ss.android.socialbase.downloader.impls.k;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.model.e;
import com.ss.android.socialbase.downloader.network.i;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* compiled from: DownloadResponseHandler */
public class d {
    private static String b = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private long D;
    private volatile long E = 0;
    private volatile long F = 0;
    boolean a = false;
    private final DownloadInfo c;
    private final String d;
    private final b e;
    private final i f;
    private i g;
    private k h;
    private r i;
    private e j;
    private BaseException k;
    private volatile boolean l;
    private volatile boolean m;
    private final f n;
    private long o;
    private long p;
    private volatile long q;
    private volatile long r;
    private final boolean s;
    private final a t;
    private final com.ss.android.socialbase.downloader.a.a u;
    private final boolean v;
    private final long w;
    private final long x;
    private final boolean y;
    private boolean z;

    private boolean b(long j2, long j3) {
        return j2 > 65536 && j3 > 500;
    }

    public d(DownloadInfo downloadInfo, String str, i iVar, b bVar, f fVar) {
        boolean z2 = false;
        this.c = downloadInfo;
        this.d = str;
        i x2 = b.x();
        this.g = x2;
        if (x2 instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) x2;
            this.h = dVar.a();
            this.i = dVar.e();
        }
        this.f = iVar;
        this.e = bVar;
        this.n = fVar;
        long n2 = bVar.n();
        this.o = n2;
        this.p = n2;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        a a2 = a.a(downloadInfo.getId());
        this.t = a2;
        boolean z3 = a2.a("sync_strategy", 0) == 1;
        this.v = z3;
        if (z3) {
            this.w = Math.max((long) a2.a("sync_interval_ms_fg", 5000), 500L);
            this.x = Math.max((long) a2.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.w = 0;
            this.x = 0;
        }
        this.y = a2.b("monitor_rw") == 1 ? true : z2;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    public long a() {
        return this.o;
    }

    private boolean f() {
        return this.l || this.m;
    }

    public void b() {
        if (!this.l) {
            this.l = true;
            g();
        }
    }

    public void c() {
        if (!this.m) {
            synchronized (this.n) {
                this.m = true;
            }
            g();
        }
    }

    private void g() {
        ExecutorService l2;
        if (this.f != null && (l2 = b.l()) != null) {
            l2.execute(new Runnable() {
                /* class com.ss.android.socialbase.downloader.downloader.d.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.f.d();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(long j2, long j3, long j4) {
        this.o = j2;
        this.p = j2;
        this.q = j3;
        this.r = j4;
    }

    public void a(long j2, long j3) {
        this.q = j2;
        this.r = j3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02a4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02a5, code lost:
        r29 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        ((com.ss.android.socialbase.downloader.network.a) r31.f).a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02ce, code lost:
        r0 = r31.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d0, code lost:
        if (r0 != null) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02d2, code lost:
        r0.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02d5, code lost:
        if (r10 != null) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02d7, code lost:
        r10.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02dc, code lost:
        if (r31.s != false) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02e0, code lost:
        monitor-enter(r31.n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02e3, code lost:
        if (r31.m == false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02e5, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02ec, code lost:
        if (r31.j != null) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02ee, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x02f6, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x02fd, code lost:
        if (r31.j != null) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x02ff, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0302, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x030d, code lost:
        r31.D = java.lang.System.nanoTime() - r8;
        r10 = r31.t;
        r11 = r31.c;
        r12 = r31.d;
        r13 = r31.f;
        r14 = r31.l;
        r15 = r31.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0322, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0323, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x032e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0333, code lost:
        if (com.ss.android.socialbase.downloader.c.a.a() != false) goto L_0x0335;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0335, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r0, "ResponseHandler");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x033d, code lost:
        r0 = r31.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x033f, code lost:
        if (r0 != null) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0341, code lost:
        r0.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0344, code lost:
        if (r10 != null) goto L_0x0346;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0346, code lost:
        r10.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x034b, code lost:
        if (r31.s != false) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x034f, code lost:
        monitor-enter(r31.n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0352, code lost:
        if (r31.m == false) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0354, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x035b, code lost:
        if (r31.j != null) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x035d, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0365, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x036c, code lost:
        if (r31.j != null) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x036e, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0371, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
        r31.D = java.lang.System.nanoTime() - r8;
        r10 = r31.t;
        r11 = r31.c;
        r12 = r31.d;
        r13 = r31.f;
        r14 = r31.l;
        r15 = r31.m;
        r16 = r31.k;
        r17 = r31.o - r31.p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x041c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x041d, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0428, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0429, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x042a, code lost:
        r31.k = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x042c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x042d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x042e, code lost:
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0456, code lost:
        r0 = r31.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0458, code lost:
        if (r0 != null) goto L_0x045a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x045a, code lost:
        r0.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x045d, code lost:
        if (r10 != null) goto L_0x045f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x045f, code lost:
        r10.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0464, code lost:
        if (r31.s != false) goto L_0x0466;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0468, code lost:
        monitor-enter(r31.n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x046b, code lost:
        if (r31.m == false) goto L_0x046d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x046d, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0474, code lost:
        if (r31.j != null) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0476, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x047e, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0485, code lost:
        if (r31.j != null) goto L_0x0487;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0487, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x048a, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0497, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0498, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x04a3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x04aa, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x04b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x04b1, code lost:
        r2 = r31.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x04b3, code lost:
        if (r2 != null) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x04b5, code lost:
        r2.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x04b8, code lost:
        if (r10 != null) goto L_0x04ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x04ba, code lost:
        r10.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x04bf, code lost:
        if (r31.s != false) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x04c3, code lost:
        monitor-enter(r31.n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x04c6, code lost:
        if (r31.m == false) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x04c8, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x04cf, code lost:
        if (r31.j != null) goto L_0x04d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x04d1, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x04d9, code lost:
        a(r31.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x04e0, code lost:
        if (r31.j != null) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x04e2, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x04e5, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
        r31.D = java.lang.System.nanoTime() - r8;
        com.ss.android.socialbase.downloader.d.a.a(r31.t, r31.c, r31.d, r31.f, r31.l, r31.m, r31.k, r31.o - r31.p, r31.D, r7, r31.A, r31.B, r31.C, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0524, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0525, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0526, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r31.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0531, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02ab A[SYNTHETIC, Splitter:B:163:0x02ab] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x042d A[ExcHandler: BaseException (e com.ss.android.socialbase.downloader.exception.BaseException), Splitter:B:7:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04aa  */
    public void d() throws BaseException {
        com.ss.android.socialbase.downloader.e.b bVar;
        boolean z2;
        BaseException e2;
        Throwable th;
        long j2;
        if (!f() && this.e != null) {
            long a2 = com.ss.android.socialbase.downloader.i.e.a(this.f);
            if (a2 != 0) {
                long l2 = this.e.l();
                long nanoTime = System.nanoTime();
                boolean z3 = this.y;
                boolean z4 = this.f instanceof com.ss.android.socialbase.downloader.network.a;
                int i2 = 1;
                char c2 = 0;
                try {
                    e a3 = com.ss.android.socialbase.downloader.i.e.a(this.c.getTempPath(), this.c.getTempName(), this.t.a("flush_buffer_size_byte", -1));
                    this.j = a3;
                    long j3 = l2;
                    try {
                        a3.a(this.o);
                        InputStream a4 = this.f.a();
                        if (a4 != null) {
                            this.c.updateRealStartDownloadTime();
                            bVar = a(a4);
                            try {
                                this.c.setIsRwConcurrent(this.z);
                                this.a = this.c.getOpenLimitSpeed();
                                long j4 = com.ss.android.socialbase.downloader.constants.e.d;
                                long j5 = com.ss.android.socialbase.downloader.constants.e.e;
                                long j6 = j4 / (1000 / j5);
                                long currentTimeMillis = System.currentTimeMillis();
                                long j7 = 0;
                                long j8 = 0;
                                while (!f()) {
                                    z2 = z3;
                                    if (z2) {
                                        try {
                                            j7 = System.nanoTime();
                                        } catch (BaseException e3) {
                                            e2 = e3;
                                            com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e2);
                                            if (this.t.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            this.k = e2;
                                            throw e2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (z4) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                                            if (f()) {
                                            }
                                        }
                                    }
                                    com.ss.android.socialbase.downloader.f.a a5 = bVar.a();
                                    if (z2) {
                                        j2 = j6;
                                        this.A += System.nanoTime() - j7;
                                    } else {
                                        j2 = j6;
                                    }
                                    int i3 = a5.c;
                                    if (i3 != -1) {
                                        if (!this.c.isIgnoreDataVerify() && this.r > this.o - this.p && this.r < (this.o - this.p) + ((long) i3)) {
                                            i3 = (int) (this.r - (this.o - this.p));
                                        }
                                        if (z2) {
                                            j7 = System.nanoTime();
                                        }
                                        this.j.a(a5.a, 0, i3);
                                        if (z2) {
                                            this.B += System.nanoTime() - j7;
                                        }
                                        bVar.a(a5);
                                        long j9 = (long) i3;
                                        this.o += j9;
                                        j8 += j9;
                                        synchronized (this.n) {
                                            if (!this.s) {
                                                boolean b2 = this.n.b(j9);
                                                a(this.h);
                                                a(b2);
                                            } else if (!this.m) {
                                                boolean b3 = this.n.b(j9);
                                                a(this.h);
                                                a(b3);
                                            }
                                        }
                                        if (!this.c.isDownloadWithWifiValid()) {
                                            throw new c();
                                        } else if (!this.c.isPauseReserveWithWifiValid()) {
                                            throw new com.ss.android.socialbase.downloader.exception.e();
                                        } else if (this.c.isIgnoreDataVerify() || this.r < 0 || this.r > this.o - this.p) {
                                            if (this.a && j8 > j2) {
                                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                if (currentTimeMillis2 < j5) {
                                                    try {
                                                        Thread.sleep(j5 - currentTimeMillis2);
                                                    } catch (InterruptedException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                                currentTimeMillis = System.currentTimeMillis();
                                                j8 = 0;
                                            }
                                            z3 = z2;
                                            j6 = j2;
                                            c2 = 0;
                                            i2 = 1;
                                        }
                                    }
                                    i iVar = this.f;
                                    if (iVar != null) {
                                        iVar.d();
                                    }
                                    if (bVar != null) {
                                        bVar.b();
                                    }
                                    try {
                                        if (this.s) {
                                            synchronized (this.n) {
                                                if (!this.m) {
                                                    a(this.h);
                                                    if (this.j != null) {
                                                        h();
                                                    }
                                                }
                                            }
                                        } else {
                                            a(this.h);
                                            if (this.j != null) {
                                                h();
                                            }
                                        }
                                        com.ss.android.socialbase.downloader.i.e.a(this.j);
                                        this.D = System.nanoTime() - nanoTime;
                                        a aVar = this.t;
                                        DownloadInfo downloadInfo = this.c;
                                        String str = this.d;
                                        i iVar2 = this.f;
                                        boolean z5 = this.l;
                                        boolean z6 = this.m;
                                        BaseException baseException = this.k;
                                        long j10 = this.o - this.p;
                                        com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str, iVar2, z5, z6, baseException, j10, this.D, z2, this.A, this.B, this.C, null);
                                        if (this.c.isIgnoreDataVerify()) {
                                            long j11 = this.o - this.p;
                                            if (j11 >= 0 && this.r >= 0 && this.r != j11) {
                                                throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j11), Long.valueOf(a2), Long.valueOf(this.r), Long.valueOf(j3), Long.valueOf(this.q), Long.valueOf(this.o), Long.valueOf(this.p)));
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        com.ss.android.socialbase.downloader.i.e.a(this.j);
                                        throw th3;
                                    }
                                }
                                i iVar3 = this.f;
                                if (iVar3 != null) {
                                    iVar3.d();
                                }
                                if (bVar != null) {
                                    bVar.b();
                                }
                                try {
                                    if (this.s) {
                                        synchronized (this.n) {
                                            if (!this.m) {
                                                a(this.h);
                                                if (this.j != null) {
                                                    h();
                                                }
                                            }
                                        }
                                    } else {
                                        a(this.h);
                                        if (this.j != null) {
                                            h();
                                        }
                                    }
                                    Closeable[] closeableArr = new Closeable[i2];
                                    closeableArr[c2] = this.j;
                                    com.ss.android.socialbase.downloader.i.e.a(closeableArr);
                                    this.D = System.nanoTime() - nanoTime;
                                    a aVar2 = this.t;
                                    DownloadInfo downloadInfo2 = this.c;
                                    String str2 = this.d;
                                    i iVar4 = this.f;
                                    boolean z7 = this.l;
                                    z2 = z3;
                                    boolean z8 = this.m;
                                    com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar4, z7, z8, this.k, this.o - this.p, this.D, z2, this.A, this.B, this.C, null);
                                } catch (Throwable th4) {
                                    Closeable[] closeableArr2 = new Closeable[i2];
                                    closeableArr2[c2] = this.j;
                                    com.ss.android.socialbase.downloader.i.e.a(closeableArr2);
                                    throw th4;
                                }
                            } catch (BaseException e5) {
                                e2 = e5;
                                z2 = z3;
                                com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e2);
                                if (this.t.a("ignore_base_ex_on_stop_status")) {
                                }
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                }
                                this.k = e2;
                                throw e2;
                            } catch (Throwable th5) {
                                th = th5;
                                z2 = z3;
                                if (z4) {
                                }
                                com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                                if (f()) {
                                }
                            }
                        } else {
                            z2 = z3;
                            throw new BaseException(1042, new IOException("inputStream is null"));
                        }
                    } catch (IOException e6) {
                        throw new BaseException(1054, e6);
                    } catch (BaseException e7) {
                        e2 = e7;
                        bVar = null;
                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e2);
                        if (this.t.a("ignore_base_ex_on_stop_status")) {
                        }
                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                        }
                        this.k = e2;
                        throw e2;
                    } catch (Throwable th6) {
                        th = th6;
                        bVar = null;
                        if (z4) {
                        }
                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                        if (f()) {
                        }
                    }
                } catch (BaseException e8) {
                } catch (Throwable th7) {
                    th = th7;
                    z2 = z3;
                    bVar = null;
                    if (z4) {
                    }
                    com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                    if (f()) {
                    }
                }
            } else {
                throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0");
            }
        }
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int G = b.G();
        if (this.t.a("rw_concurrent", 0) == 1 && this.c.getChunkCount() == 1 && this.c.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, G, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, G);
        this.z = false;
        return cVar;
    }

    private void a(boolean z2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = uptimeMillis - this.F;
        if (this.v) {
            if (j2 > (this.u.b() ? this.w : this.x)) {
                h();
                this.F = uptimeMillis;
                return;
            }
            return;
        }
        long j3 = this.o - this.E;
        if (z2 || b(j3, j2)) {
            h();
            this.F = uptimeMillis;
        }
    }

    public long e() {
        return this.E;
    }

    private void h() {
        boolean z2;
        long nanoTime = this.y ? System.nanoTime() : 0;
        boolean z3 = false;
        try {
            this.j.a();
            z2 = true;
        } catch (Exception unused) {
            z2 = false;
        }
        if (z2) {
            this.c.updateRealDownloadTime(true);
            if (this.c.getChunkCount() > 1) {
                z3 = true;
            }
            l a2 = l.a(com.ss.android.socialbase.downloader.i.e.b());
            if (z3) {
                a(this.i);
                if (a2 != null) {
                    a2.c(this.c);
                } else {
                    this.i.a(this.c.getId(), this.c.getCurBytes());
                }
            } else if (a2 != null) {
                a2.c(this.c);
            } else {
                this.i.a(this.e.k(), this.o);
            }
            this.E = this.o;
        }
        if (this.y) {
            this.C += System.nanoTime() - nanoTime;
        }
    }

    private void a(i iVar) {
        b bVar;
        b bVar2;
        if (iVar != null) {
            l lVar = null;
            boolean z2 = iVar instanceof com.ss.android.socialbase.downloader.b.e;
            if (!z2 || (lVar = l.a(com.ss.android.socialbase.downloader.i.e.b())) != null) {
                if (this.e.d()) {
                    bVar = this.e.e();
                } else {
                    bVar = this.e;
                }
                if (bVar != null) {
                    bVar.b(this.o);
                    if (!z2 || lVar == null) {
                        bVar2 = bVar;
                        iVar.a(bVar.k(), bVar.s(), bVar.b(), this.o);
                    } else {
                        lVar.a(bVar.k(), bVar.s(), bVar.b(), this.o);
                        bVar2 = bVar;
                    }
                    if (bVar2.h()) {
                        boolean z3 = false;
                        if (bVar2.i()) {
                            long j2 = bVar2.j();
                            if (j2 > this.o) {
                                if (!z2 || lVar == null) {
                                    iVar.a(bVar2.k(), bVar2.b(), j2);
                                } else {
                                    lVar.a(bVar2.k(), bVar2.b(), j2);
                                }
                                z3 = true;
                            }
                        }
                        if (z3) {
                            return;
                        }
                        if (!z2 || lVar == null) {
                            iVar.a(bVar2.k(), bVar2.b(), this.o);
                        } else {
                            lVar.a(bVar2.k(), bVar2.b(), this.o);
                        }
                    }
                } else if (!this.e.d()) {
                } else {
                    if (!z2 || lVar == null) {
                        iVar.a(this.e.k(), this.e.s(), this.o);
                    } else {
                        lVar.a(this.e.k(), this.e.s(), this.o);
                    }
                }
            }
        }
    }
}
