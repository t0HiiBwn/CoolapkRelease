package com.ss.android.socialbase.downloader.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.List;

/* compiled from: DownloadChunkRunnable */
public class b implements Runnable {
    private static final String a = "b";
    private com.ss.android.socialbase.downloader.model.b b;
    private com.ss.android.socialbase.downloader.model.b c;
    private d d;
    private final DownloadTask e;
    private DownloadInfo f;
    private final f g;
    private i h;
    private com.ss.android.socialbase.downloader.downloader.i i;
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.l = false;
        this.c = bVar;
        this.e = downloadTask;
        if (downloadTask != null) {
            this.f = downloadTask.getDownloadInfo();
        }
        this.g = fVar;
        this.i = com.ss.android.socialbase.downloader.downloader.b.x();
        this.c.a(this);
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.h = iVar;
    }

    private String c() {
        return this.f.getConnectionUrl();
    }

    /* JADX INFO: finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.b = this.c;
        while (true) {
            try {
                this.b.a(this);
                if (a(this.b)) {
                    this.b.a(false);
                    if (!e()) {
                        this.b = this.g.a(this.b.s());
                        if (e() || this.b == null) {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        break;
                    }
                } else {
                    this.b.a(false);
                    break;
                }
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.model.b bVar = this.b;
                if (bVar != null) {
                    bVar.a(false);
                }
                d();
                this.g.a(this);
                throw th2;
            }
        }
        com.ss.android.socialbase.downloader.model.b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.a(false);
        }
        d();
        this.g.a(this);
    }

    public void a(long j2, long j3) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(j2, j3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01a9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01ad, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01ae, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01b3, code lost:
        if (e() == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01b8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        com.ss.android.socialbase.downloader.i.e.a(r0, "downloadChunkInner");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01c0, code lost:
        r30.g.b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01ca, code lost:
        r14 = r6;
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01d3, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01d6, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01db, code lost:
        if (com.ss.android.socialbase.downloader.i.e.b(r0) != false) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01dd, code lost:
        r30.g.a(r0, r13);
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01e5, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01ec, code lost:
        if (r30.g.a(r0) != false) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01f2, code lost:
        if (com.ss.android.socialbase.downloader.i.e.a(r0) != false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01f4, code lost:
        r30.g.a(r0, true);
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01fc, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x01fd, code lost:
        if (r5 != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0201, code lost:
        if (r30.d != null) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0209, code lost:
        if (com.ss.android.socialbase.downloader.i.a.a(32) != false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x020b, code lost:
        r2 = r30.d.a() - r30.d.e();
        r4 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x021a, code lost:
        if (r4 > 0) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x021c, code lost:
        a(r31, r30.d.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0226, code lost:
        if (r4 < 0) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0229, code lost:
        r21 = r30.d.a() - r14;
        a(r31, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0235, code lost:
        r30.g.b(r0);
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x023d, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x023e, code lost:
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0246, code lost:
        if (com.ss.android.socialbase.downloader.i.a.a(16) == false) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0248, code lost:
        r0 = r30.g.a(r31, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x024f, code lost:
        r0 = r30.g.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0257, code lost:
        if (r0 != com.ss.android.socialbase.downloader.exception.g.RETURN) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0259, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x025c, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x026e, code lost:
        if (r30.f.isNeedChunkDowngradeRetry() == false) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0288, code lost:
        r30.g.c(r0);
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0290, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0291, code lost:
        r30.g.b(r0);
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0299, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x029a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x029b, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x029e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016f, code lost:
        r5 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01a9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:81:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ad A[ExcHandler: all (th java.lang.Throwable), Splitter:B:20:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b5 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d A[LOOP:0: B:1:0x0004->B:171:0x025d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0259 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x01d3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x00f6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    private boolean a(com.ss.android.socialbase.downloader.model.b bVar) {
        long j2;
        boolean z;
        BaseException e2;
        Throwable th;
        com.ss.android.socialbase.downloader.model.b e3;
        while (true) {
            com.ss.android.socialbase.downloader.model.b bVar2 = (!bVar.d() || !bVar.f() || (e3 = bVar.e()) == null || e3.s() != bVar.s()) ? null : e3;
            if (bVar2 != null && bVar2.i()) {
                return true;
            }
            long n = bVar.n();
            long p = bVar.p();
            long n2 = bVar.n();
            if (bVar2 != null) {
                n2 = bVar2.n();
                n = bVar2.n();
                p = bVar2.p();
            }
            long j3 = 0;
            boolean z2 = false;
            try {
                if (e()) {
                    d();
                    return false;
                }
                String c2 = c();
                boolean z3 = this.h != null;
                this.l = z3;
                bVar.b(z3);
                try {
                    if (!this.l) {
                        List<c> a2 = e.a(this.f.getExtraHeaders(), this.f.geteTag(), n, p);
                        a2.add(new c("Chunk-Index", String.valueOf(bVar.s())));
                        e.a(a2, this.f);
                        this.h = com.ss.android.socialbase.downloader.downloader.b.a(this.f.isNeedDefaultHttpServiceBackUp(), this.f.getMaxBytes(), c2, a2);
                    }
                    i iVar = this.h;
                    if (!(iVar == null || this.g == null)) {
                        try {
                            int b2 = iVar.b();
                            if (b2 < 200 || b2 >= 300) {
                                this.g.a(this.h);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            if (!e()) {
                            }
                        }
                    }
                } catch (BaseException e4) {
                    throw e4;
                } catch (Throwable th3) {
                    th = th3;
                }
                if (!e()) {
                    d();
                    return false;
                }
                i iVar2 = this.h;
                if (iVar2 != null) {
                    if (!this.l) {
                        try {
                            int b3 = iVar2.b();
                            if (!e.d(b3)) {
                                throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(b3)));
                            }
                        } catch (BaseException e5) {
                            throw e5;
                        } catch (Throwable th4) {
                            e.a(th4, "ChunkRunnableGetResponseCode");
                        }
                    }
                    z = false;
                    j2 = n2;
                    try {
                        this.d = new d(this.f, c2, this.h, bVar, this.g);
                        if (bVar2 != null) {
                            long c3 = bVar2.c(false);
                            if (p != 0 && p >= n) {
                                c3 = (p - n) + 1;
                            }
                            this.d.a(bVar2.n(), bVar2.p(), c3);
                        }
                        this.d.d();
                        d();
                        return true;
                    } catch (BaseException e6) {
                        e2 = e6;
                        z2 = false;
                        if (e()) {
                        }
                    } catch (Throwable th5) {
                    }
                } else {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
            } catch (BaseException e7) {
                e2 = e7;
                j2 = n2;
                z = false;
                if (e()) {
                }
            } catch (Throwable th6) {
            }
            bVar.b(z);
            d();
            d();
        }
        d();
        return z;
        throw th;
        i iVar3 = this.h;
        if (!(iVar3 == null || this.g == null)) {
            try {
                int b4 = iVar3.b();
                if (b4 < 200 || b4 >= 300) {
                    this.g.a(this.h);
                }
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
        }
        throw th;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j2) {
        com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
        if (e2 != null) {
            if (e2.h()) {
                this.i.a(e2.k(), e2.b(), j2);
            }
            e2.b(j2);
            this.i.a(e2.k(), e2.s(), e2.b(), j2);
        } else if (bVar.d()) {
            this.i.a(bVar.k(), bVar.s(), j2);
        }
    }

    private void d() {
        i iVar = this.h;
        if (iVar != null) {
            iVar.d();
            this.h = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        d dVar = this.d;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void b() {
        this.k = true;
        d dVar = this.d;
        if (dVar != null) {
            dVar.c();
        }
    }
}
