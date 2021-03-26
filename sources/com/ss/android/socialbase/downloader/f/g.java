package com.ss.android.socialbase.downloader.f;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.c;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.h.f;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: MultiSegmentWriter */
class g {
    private final List<l> a = new LinkedList();
    private final List<l> b = new ArrayList();
    private final DownloadInfo c;
    private final i d;
    private final a e;
    private final f f;
    private final c g;
    private BaseException h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;

    /* renamed from: l  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.a.a f1412l;
    private final boolean m;
    private final long n;
    private final long o;
    private final boolean p;
    private long q;
    private volatile long r;
    private volatile long s;

    private boolean a(long j2, long j3) {
        return j2 > 65536 && j3 > 500;
    }

    g(DownloadInfo downloadInfo, f fVar, c cVar) {
        boolean z = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.r = 0;
        this.s = 0;
        this.c = downloadInfo;
        this.d = b.x();
        this.f = fVar;
        this.g = cVar;
        this.f1412l = com.ss.android.socialbase.downloader.a.a.a();
        a a2 = a.a(downloadInfo.getId());
        this.e = a2;
        boolean z2 = a2.a("sync_strategy", 0) == 1;
        this.m = z2;
        if (z2) {
            this.n = Math.max((long) a2.a("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max((long) a2.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0;
            this.o = 0;
        }
        this.p = a2.b("monitor_rw") == 1 ? true : z;
    }

    void a(l lVar) {
        synchronized (this) {
            this.a.add(lVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f3 A[Catch:{ all -> 0x03d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x02ab A[SYNTHETIC, Splitter:B:215:0x02ab] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x02ca A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x03f5 A[SYNTHETIC, Splitter:B:309:0x03f5] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0415 A[SYNTHETIC] */
    void a(d dVar) throws BaseException {
        long j2;
        long j3;
        int i2;
        Throwable th;
        Throwable th2;
        long j4;
        p e2;
        long j5;
        int i3;
        BaseException e3;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        Throwable th7;
        if (!this.j && !this.k) {
            com.ss.android.socialbase.downloader.network.b.e();
            this.h = null;
            DownloadInfo downloadInfo = this.c;
            f fVar = this.f;
            c cVar = this.g;
            long curBytes = downloadInfo.getCurBytes();
            long nanoTime = System.nanoTime();
            boolean z = this.p;
            long j6 = 0;
            boolean z2 = true;
            boolean z3 = false;
            try {
                downloadInfo.updateRealStartDownloadTime();
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                int i4 = 0;
                while (true) {
                    if (z) {
                        try {
                            j7 = System.nanoTime();
                        } catch (p e4) {
                            e2 = e4;
                            i2 = i4;
                            j4 = j8;
                        } catch (BaseException e5) {
                            e3 = e5;
                            j2 = j6;
                            i3 = i4;
                            j5 = j8;
                            if (this.e.a("ignore_base_ex_on_stop_status")) {
                            }
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                            }
                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                            this.h = e3;
                            throw e3;
                        } catch (Throwable th8) {
                            th4 = th8;
                            j2 = j6;
                            i2 = i4;
                            j3 = j8;
                            try {
                                if (!this.j) {
                                }
                                if (i2 > 0) {
                                }
                                if (!this.k) {
                                }
                                th5 = null;
                                synchronized (this) {
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                if (i2 > 0) {
                                }
                                if (!this.k) {
                                }
                                th2 = null;
                                synchronized (this) {
                                }
                            }
                        }
                    }
                    try {
                        a a2 = dVar.a();
                        if (z) {
                            j6 += System.nanoTime() - j7;
                        }
                        j2 = j6;
                        try {
                            int i5 = a2.c;
                            if (i5 == -1) {
                                try {
                                    a(a2.b);
                                    cVar.a(a2);
                                    j6 = j2;
                                } catch (p e6) {
                                    e2 = e6;
                                    i2 = i4;
                                    j4 = j8;
                                    j6 = j2;
                                    try {
                                        this.h = e2;
                                        throw e2;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        j2 = j6;
                                        j3 = j4;
                                        if (i2 > 0) {
                                            try {
                                                fVar.b((long) i2);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        if (!this.k) {
                                            try {
                                                c();
                                            } catch (Throwable th11) {
                                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th11);
                                                th2 = th11;
                                            }
                                        }
                                        th2 = null;
                                        synchronized (this) {
                                            c(this.a);
                                            this.a.clear();
                                        }
                                        com.ss.android.socialbase.downloader.d.a.a(this.e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                        if (th2 != null) {
                                            if (!this.j && !this.k && this.h == null) {
                                                z2 = false;
                                            }
                                            if (!z2) {
                                                try {
                                                    e.a(th2, "loopAndWrite_finally");
                                                } catch (BaseException e7) {
                                                    this.h = e7;
                                                    throw e7;
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (BaseException e8) {
                                    e3 = e8;
                                    i3 = i4;
                                    j5 = j8;
                                    if (this.e.a("ignore_base_ex_on_stop_status")) {
                                    }
                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    }
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                                    this.h = e3;
                                    throw e3;
                                } catch (Throwable th12) {
                                    th4 = th12;
                                    i2 = i4;
                                    j3 = j8;
                                    if (!this.j) {
                                    }
                                    if (i2 > 0) {
                                    }
                                    if (!this.k) {
                                    }
                                    th5 = null;
                                    synchronized (this) {
                                    }
                                }
                            } else {
                                if (z) {
                                    j7 = System.nanoTime();
                                }
                                a2.b.b(a2);
                                if (z) {
                                    j8 += System.nanoTime() - j7;
                                }
                                j4 = j8;
                                try {
                                    cVar.a(a2);
                                    if (this.i) {
                                        if (this.j) {
                                            break;
                                        }
                                        try {
                                            if (this.k) {
                                                break;
                                            }
                                            this.i = z3;
                                        } catch (p e9) {
                                            e2 = e9;
                                            i2 = i4;
                                            j6 = j2;
                                            this.h = e2;
                                            throw e2;
                                        } catch (BaseException e10) {
                                            e3 = e10;
                                            i3 = i4;
                                            j5 = j4;
                                            if (this.e.a("ignore_base_ex_on_stop_status") || (!this.j && !this.k)) {
                                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                    e3.printStackTrace();
                                                }
                                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                                                this.h = e3;
                                                throw e3;
                                            }
                                            if (i3 > 0) {
                                                try {
                                                    fVar.b((long) i3);
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (!this.k) {
                                                try {
                                                    c();
                                                } catch (Throwable th13) {
                                                    th3 = th13;
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th3);
                                                }
                                            }
                                            th3 = null;
                                            synchronized (this) {
                                                c(this.a);
                                                this.a.clear();
                                            }
                                            com.ss.android.socialbase.downloader.d.a.a(this.e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j5, this.q, null);
                                            if (th3 != null) {
                                                if (!this.j && !this.k && this.h == null) {
                                                    z2 = false;
                                                }
                                                if (!z2) {
                                                    try {
                                                        e.a(th3, "loopAndWrite_finally");
                                                        return;
                                                    } catch (BaseException e11) {
                                                        this.h = e11;
                                                        throw e11;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th14) {
                                            th4 = th14;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.j) {
                                                if (!this.k) {
                                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                        th4.printStackTrace();
                                                    }
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  e = " + th4);
                                                    try {
                                                        e.a(th4, "loopAndWrite");
                                                        if (i2 > 0) {
                                                            try {
                                                                fVar.b((long) i2);
                                                            } catch (Throwable unused3) {
                                                            }
                                                        }
                                                        if (!this.k) {
                                                            try {
                                                                c();
                                                            } catch (Throwable th15) {
                                                                th6 = th15;
                                                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th6);
                                                            }
                                                        }
                                                        th6 = null;
                                                        synchronized (this) {
                                                            c(this.a);
                                                            this.a.clear();
                                                        }
                                                        com.ss.android.socialbase.downloader.d.a.a(this.e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                                        if (th6 != null) {
                                                            if (!this.j && !this.k && this.h == null) {
                                                                z2 = false;
                                                            }
                                                            if (!z2) {
                                                                try {
                                                                    e.a(th6, "loopAndWrite_finally");
                                                                    return;
                                                                } catch (BaseException e12) {
                                                                    this.h = e12;
                                                                    throw e12;
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } catch (BaseException e13) {
                                                        this.h = e13;
                                                        throw e13;
                                                    }
                                                }
                                            }
                                            if (i2 > 0) {
                                                try {
                                                    fVar.b((long) i2);
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                            if (!this.k) {
                                                try {
                                                    c();
                                                } catch (Throwable th16) {
                                                    th5 = th16;
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th5);
                                                }
                                            }
                                            th5 = null;
                                            synchronized (this) {
                                                c(this.a);
                                                this.a.clear();
                                            }
                                            com.ss.android.socialbase.downloader.d.a.a(this.e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                            if (th5 != null) {
                                                if (!this.j && !this.k && this.h == null) {
                                                    z2 = false;
                                                }
                                                if (!z2) {
                                                    try {
                                                        e.a(th5, "loopAndWrite_finally");
                                                        return;
                                                    } catch (BaseException e14) {
                                                        this.h = e14;
                                                        throw e14;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    i4 += i5;
                                    if (i4 >= 65536) {
                                        try {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            if (uptimeMillis - j9 > 100) {
                                                try {
                                                    a(uptimeMillis, fVar.b((long) i4));
                                                    if (!com.ss.android.socialbase.downloader.network.b.a) {
                                                        if (downloadInfo.isOnlyWifi()) {
                                                            throw new c();
                                                        } else if (downloadInfo.isDownloadFromReserveWifi()) {
                                                            if (downloadInfo.isPauseReserveOnWifi()) {
                                                                throw new com.ss.android.socialbase.downloader.exception.e();
                                                            }
                                                        }
                                                    }
                                                    j9 = uptimeMillis;
                                                    j6 = j2;
                                                    j8 = j4;
                                                    j7 = j7;
                                                    i4 = 0;
                                                    z3 = false;
                                                } catch (p e15) {
                                                    e2 = e15;
                                                    j6 = j2;
                                                    i2 = 0;
                                                    this.h = e2;
                                                    throw e2;
                                                } catch (BaseException e16) {
                                                    e3 = e16;
                                                    j5 = j4;
                                                    i3 = 0;
                                                    if (this.e.a("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                    }
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                                                    this.h = e3;
                                                    throw e3;
                                                } catch (Throwable th17) {
                                                    th4 = th17;
                                                    j3 = j4;
                                                    i2 = 0;
                                                    if (!this.j) {
                                                    }
                                                    if (i2 > 0) {
                                                    }
                                                    if (!this.k) {
                                                    }
                                                    th5 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                        } catch (p e17) {
                                            e2 = e17;
                                            i2 = i4;
                                            j6 = j2;
                                            this.h = e2;
                                            throw e2;
                                        } catch (BaseException e18) {
                                            e3 = e18;
                                            i3 = i4;
                                            j5 = j4;
                                            if (this.e.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                                            this.h = e3;
                                            throw e3;
                                        } catch (Throwable th18) {
                                            th4 = th18;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.j) {
                                            }
                                            if (i2 > 0) {
                                            }
                                            if (!this.k) {
                                            }
                                            th5 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    j6 = j2;
                                    j8 = j4;
                                    j7 = j7;
                                    z3 = false;
                                } catch (p e19) {
                                    e2 = e19;
                                    i2 = i4;
                                    j6 = j2;
                                    this.h = e2;
                                    throw e2;
                                } catch (BaseException e20) {
                                    e3 = e20;
                                    i3 = i4;
                                    j5 = j4;
                                    if (this.e.a("ignore_base_ex_on_stop_status")) {
                                    }
                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    }
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                                    this.h = e3;
                                    throw e3;
                                } catch (Throwable th19) {
                                    th4 = th19;
                                    i2 = i4;
                                    j3 = j4;
                                    if (!this.j) {
                                    }
                                    if (i2 > 0) {
                                    }
                                    if (!this.k) {
                                    }
                                    th5 = null;
                                    synchronized (this) {
                                    }
                                }
                            }
                        } catch (p e21) {
                            e2 = e21;
                            i2 = i4;
                            j4 = j8;
                            j6 = j2;
                            this.h = e2;
                            throw e2;
                        } catch (BaseException e22) {
                            e3 = e22;
                            i3 = i4;
                            j5 = j8;
                            if (this.e.a("ignore_base_ex_on_stop_status")) {
                            }
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                            }
                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                            this.h = e3;
                            throw e3;
                        } catch (Throwable th20) {
                            th4 = th20;
                            i2 = i4;
                            j3 = j8;
                            if (!this.j) {
                            }
                            if (i2 > 0) {
                            }
                            if (!this.k) {
                            }
                            th5 = null;
                            synchronized (this) {
                            }
                        }
                    } catch (p e23) {
                        e2 = e23;
                        i2 = i4;
                        j4 = j8;
                        this.h = e2;
                        throw e2;
                    } catch (BaseException e24) {
                        e3 = e24;
                        j2 = j6;
                        i3 = i4;
                        j5 = j8;
                        if (this.e.a("ignore_base_ex_on_stop_status")) {
                        }
                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                        }
                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                        this.h = e3;
                        throw e3;
                    } catch (Throwable th21) {
                        th4 = th21;
                        j2 = j6;
                        i2 = i4;
                        j3 = j8;
                        if (!this.j) {
                        }
                        if (i2 > 0) {
                        }
                        if (!this.k) {
                        }
                        th5 = null;
                        synchronized (this) {
                        }
                    }
                }
                if (i4 > 0) {
                    try {
                        fVar.b((long) i4);
                    } catch (Throwable unused5) {
                    }
                }
                if (!this.k) {
                    try {
                        c();
                    } catch (Throwable th22) {
                        th7 = th22;
                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th7);
                    }
                }
                th7 = null;
                synchronized (this) {
                    c(this.a);
                    this.a.clear();
                }
                com.ss.android.socialbase.downloader.d.a.a(this.e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j4, this.q, null);
                if (th7 != null) {
                    if (!this.j && !this.k && this.h == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            e.a(th7, "loopAndWrite_finally");
                        } catch (BaseException e25) {
                            this.h = e25;
                            throw e25;
                        }
                    }
                }
            } catch (p e26) {
                e2 = e26;
                j4 = 0;
                i2 = 0;
                this.h = e2;
                throw e2;
            } catch (BaseException e27) {
                e3 = e27;
                j5 = 0;
                j2 = 0;
                i3 = 0;
                if (this.e.a("ignore_base_ex_on_stop_status")) {
                }
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                }
                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e3);
                this.h = e3;
                throw e3;
            } catch (Throwable th23) {
                th4 = th23;
                j3 = 0;
                j2 = 0;
                i2 = 0;
                if (!this.j) {
                }
                if (i2 > 0) {
                }
                if (!this.k) {
                }
                th5 = null;
                synchronized (this) {
                }
            }
        }
    }

    private void a(long j2, boolean z) throws IOException {
        long j3 = j2 - this.s;
        if (this.m) {
            if (j3 > (this.f1412l.b() ? this.n : this.o)) {
                c();
                this.s = j2;
                return;
            }
            return;
        }
        long curBytes = this.c.getCurBytes() - this.r;
        if (z || a(curBytes, j3)) {
            c();
            this.s = j2;
        }
    }

    private void a(e eVar) {
        synchronized (this) {
            this.b.add((l) eVar);
        }
    }

    private void c() throws IOException {
        boolean z = this.p;
        long nanoTime = z ? System.nanoTime() : 0;
        DownloadInfo downloadInfo = this.c;
        i iVar = this.d;
        List<l> list = this.a;
        List<l> list2 = this.b;
        Map<Long, i> l2 = iVar.l(downloadInfo.getId());
        if (l2 == null) {
            l2 = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            a(list);
            try {
                b(list);
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            a(list, l2);
            if (list2.size() > 0) {
                c(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            iVar.a(downloadInfo.getId(), l2);
            iVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    private void a(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.b();
        }
    }

    private void b(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.c();
        }
    }

    private void c(List<l> list) {
        for (l lVar : list) {
            lVar.d();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        for (l lVar : list) {
            i e2 = lVar.e();
            i iVar = map.get(Long.valueOf(e2.c()));
            if (iVar == null) {
                map.put(Long.valueOf(e2.c()), new i(e2));
            } else {
                iVar.a(e2.d());
                iVar.c(e2.f());
            }
        }
    }

    public void a() {
        this.k = true;
        this.i = true;
    }

    public void b() {
        this.j = true;
        this.i = true;
    }
}
