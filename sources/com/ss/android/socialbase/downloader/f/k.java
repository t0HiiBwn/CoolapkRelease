package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.h.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.d;
import com.ss.android.socialbase.downloader.network.c;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: SegmentDispatcher */
public class k implements f, c.a {
    private final boolean A;
    private final e.b B = new e.b() {
        /* class com.ss.android.socialbase.downloader.f.k.AnonymousClass1 */
        private int b;

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f || k.this.g) {
                return -1;
            }
            synchronized (k.this) {
                if (k.this.j == null) {
                    if (k.this.k == null) {
                        long j = k.this.v;
                        if (j <= 0) {
                            return -1;
                        }
                        this.b++;
                        m a2 = k.this.a(false, System.currentTimeMillis(), j);
                        if (a2 == null) {
                            return j;
                        }
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        k.this.c(a2);
                        a2.f();
                        return ((long) ((this.b / k.this.i.size()) + 1)) * j;
                    }
                }
                return -1;
            }
        }
    };
    private final e.b C = new e.b() {
        /* class com.ss.android.socialbase.downloader.f.k.AnonymousClass2 */

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            return k.this.r();
        }
    };
    private final DownloadInfo a;
    private final n b;
    private final b c;
    private final f d;
    private final g e;
    private volatile boolean f = false;
    private volatile boolean g = false;
    private final List<m> h = new ArrayList();
    private final List<q> i = new ArrayList();
    private d j;
    private d k;
    private volatile boolean l = true;
    private long m;
    private final LinkedList<i> n = new LinkedList<>();
    private final List<i> o = new ArrayList();
    private int p;
    private BaseException q;
    private volatile boolean r;
    private final Object s = new Object();
    private final com.ss.android.socialbase.downloader.i.d t;
    private final e u;
    private long v;
    private long w;
    private long x;
    private float y;
    private int z;

    public k(DownloadInfo downloadInfo, n nVar, f fVar) {
        boolean z2 = false;
        this.a = downloadInfo;
        this.b = nVar;
        b bVar = new b(nVar.d(), nVar.e());
        this.c = bVar;
        this.d = fVar;
        this.e = new g(downloadInfo, fVar, bVar);
        this.u = new e();
        this.t = new com.ss.android.socialbase.downloader.i.d();
        this.A = a.a(downloadInfo.getId()).b("debug") == 1 ? true : z2;
    }

    /* JADX INFO: finally extract failed */
    public void a(List<i> list) throws BaseException, InterruptedException {
        try {
            f();
            b(list);
            e();
            g();
            i();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.a.increaseAllConnectTime(currentTimeMillis2);
                this.a.setFirstSpeedTime(currentTimeMillis2);
                if (this.g || this.f) {
                    if (!this.g && !this.f) {
                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                        b();
                    }
                    try {
                        synchronized (this) {
                            while (!this.n.isEmpty()) {
                                i poll = this.n.poll();
                                if (poll != null) {
                                    a(this.o, poll, true);
                                }
                            }
                            c(this.o);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.u.b();
                    return;
                }
                this.d.a(this.m);
                h();
                d();
                if (!this.g && !this.f) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                    b();
                }
                try {
                    synchronized (this) {
                        while (!this.n.isEmpty()) {
                            i poll2 = this.n.poll();
                            if (poll2 != null) {
                                a(this.o, poll2, true);
                            }
                        }
                        c(this.o);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                this.u.b();
                return;
            } catch (Throwable th3) {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                this.a.increaseAllConnectTime(currentTimeMillis3);
                this.a.setFirstSpeedTime(currentTimeMillis3);
                throw th3;
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        this.u.b();
        throw th;
    }

    private void b(List<i> list) {
        long totalBytes = this.a.getTotalBytes();
        this.m = totalBytes;
        if (totalBytes <= 0) {
            this.m = this.a.getExpectFileLength();
        }
        synchronized (this) {
            this.n.clear();
            if (list != null) {
                if (!list.isEmpty()) {
                    for (i iVar : list) {
                        a((List<i>) this.n, new i(iVar), false);
                    }
                    d(this.n);
                    c(this.n);
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
                }
            }
            a((List<i>) this.n, new i(0, -1), false);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
        }
    }

    private void c() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.s) {
            if (this.j == null && this.k == null) {
                this.s.wait();
            }
        }
        if (this.j == null && this.k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    private void d() throws BaseException {
        try {
            this.e.a((d) this.c);
        } catch (p unused) {
        } catch (BaseException e2) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            a(e2);
            throw e2;
        }
        if (!this.g && !this.f) {
            if (this.r || this.q == null) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
            throw this.q;
        }
    }

    private void c(List<i> list) {
        long b2 = o.b(list);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.a.getCurBytes() + ", totalBytes = " + this.a.getTotalBytes() + ", downloadedBytes = " + b2);
        if (this.a.getCurBytes() != this.a.getTotalBytes() && this.a.getCurBytes() != b2) {
            this.a.setCurBytes(b2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        return;
     */
    private void e() {
        int i2 = 1;
        int a2 = (this.m <= 0 || this.l) ? 1 : this.b.a();
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + a2);
        if (a2 > 0) {
            i2 = a2;
        }
        synchronized (this) {
            while (true) {
                if (this.h.size() < i2) {
                    if (!this.g) {
                        if (!this.f) {
                            a(j());
                            if (this.b.f()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    private void f() {
        this.i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.i.add(new q(str, false));
                }
            }
        }
        this.b.a(this.i.size());
    }

    private void g() {
        n nVar = this.b;
        this.v = nVar.i();
        this.w = nVar.j();
        this.y = nVar.n();
        int i2 = this.z;
        if (i2 > 0) {
            this.u.a(this.B, (long) i2);
        }
    }

    private void h() {
        if (this.w > 0) {
            this.x = System.currentTimeMillis();
            this.u.a(this.C, 0);
        }
    }

    private void i() {
        List<String> backUpUrls;
        int k2 = this.b.k();
        if (k2 <= 0) {
            this.l = false;
            e();
            return;
        }
        c a2 = c.a();
        a2.a(this.a.getUrl(), this, 2000);
        if (k2 > 2 && (backUpUrls = this.a.getBackUpUrls()) != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    a2.a(str, this, 2000);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (!this.g && !this.f) {
            List<q> list2 = null;
            try {
                list2 = c(str, list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            synchronized (this) {
                if (list2 != null) {
                    b(str, list2);
                }
                this.l = false;
                this.b.a(this.i.size());
                Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                e();
            }
        }
    }

    private void b(String str, List<q> list) {
        int a2;
        if (this.A) {
            Iterator<q> it2 = list.iterator();
            while (it2.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it2.next());
            }
        }
        int k2 = this.b.k();
        if ((k2 == 1 || k2 == 3) && (a2 = a(str)) >= 0 && a2 < this.i.size()) {
            this.i.addAll(a2 + 1, list);
        } else {
            this.i.addAll(list);
        }
    }

    private int a(String str) {
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.i.get(i2).a, str)) {
                return i2;
            }
        }
        return -1;
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z2;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.A) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        q qVar = new q(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.c, linkedList);
                        }
                        linkedList.add(qVar);
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    z2 = false;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        LinkedList linkedList2 = (LinkedList) entry.getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((q) linkedList2.pollFirst());
                            i2--;
                            z2 = true;
                        }
                    }
                    if (i2 <= 0) {
                        break;
                    }
                } while (z2);
                return arrayList;
            }
        }
        return null;
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.i.size();
            if (this.b.b()) {
                this.p++;
            }
            qVar = this.i.get(size);
        }
        return qVar;
    }

    private void a(List<i> list, i iVar, boolean z2) {
        long c2 = iVar.c();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && c2 >= list.get(i2).c()) {
            i2++;
        }
        list.add(i2, iVar);
        if (z2) {
            iVar.a(size);
        }
    }

    private void d(List<i> list) {
        i iVar = list.get(0);
        long c2 = iVar.c();
        if (c2 > 0) {
            i iVar2 = new i(0, c2 - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
            list.add(0, iVar2);
        }
        Iterator<i> it2 = list.iterator();
        if (it2.hasNext()) {
            i next = it2.next();
            while (it2.hasNext()) {
                i next2 = it2.next();
                if (next.f() < next2.c() - 1) {
                    com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.c() - 1));
                    next.c(next2.c() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = list.get(list.size() - 1);
        long totalBytes = this.a.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.c(-1);
        }
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.c, qVar, this.h.size());
        this.h.add(mVar);
        mVar.a(b.q().submit(mVar));
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.A) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.b);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (this.f || this.g) {
            return null;
        }
        synchronized (this) {
            i b2 = b(mVar, qVar);
            if (b2 != null) {
                b2.h();
                if (b2.a != null) {
                    return new i(b2);
                }
            }
            return b2;
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    private i b(m mVar, q qVar) {
        while (!this.n.isEmpty()) {
            i poll = this.n.poll();
            if (poll != null) {
                a(this.o, poll, true);
                if (a(poll) > 0 || this.m <= 0) {
                    return poll;
                }
            }
        }
        m();
        i c2 = c(mVar, qVar);
        if (c2 == null || a(c2) <= 0) {
            i p2 = p();
            if (p2 != null) {
                return p2;
            }
            return null;
        }
        a(this.o, c2, true);
        return c2;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, d dVar) throws BaseException, h {
        synchronized (this) {
            if (this.f || this.g) {
                throw new p("connected");
            }
            b(mVar, iVar, qVar, dVar);
            mVar.b(false);
            if (this.m <= 0) {
                long totalBytes = this.a.getTotalBytes();
                this.m = totalBytes;
                if (totalBytes <= 0) {
                    this.m = dVar.j();
                }
                e();
            } else if (this.b.f()) {
                e();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) throws BaseException {
        synchronized (this) {
            e(mVar, iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        synchronized (this) {
            if (iVar.a == mVar) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment " + iVar);
                iVar.d(mVar.d());
                iVar.a = null;
                mVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) throws BaseException {
        e a2;
        synchronized (this) {
            l lVar = new l(this.a, this.c, iVar);
            this.e.a(lVar);
            a2 = lVar.a();
        }
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i2, int i3) {
        boolean b2 = com.ss.android.socialbase.downloader.i.e.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074) {
            b2 = true;
        }
        if (b2 || i2 >= i3) {
            c(mVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.b == 0) {
                this.q = baseException;
            }
            if (l()) {
                if (this.q == null) {
                    this.q = baseException;
                }
                a(this.q);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.b);
        synchronized (this) {
            mVar.c(true);
            this.h.remove(mVar);
            m();
            if (this.h.isEmpty()) {
                k();
            } else if (n()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (m mVar2 : this.h) {
                    mVar2.e();
                }
                k();
            }
        }
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.c.c();
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        for (m mVar : this.h) {
            if (!mVar.g()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean c(m mVar) {
        synchronized (this) {
            q d2 = d(mVar);
            if (d2 == null) {
                return false;
            }
            return mVar.a(d2);
        }
    }

    private q d(m mVar) {
        q qVar;
        Iterator<q> it2 = this.i.iterator();
        q qVar2 = null;
        while (true) {
            if (!it2.hasNext()) {
                qVar = null;
                break;
            }
            qVar = it2.next();
            if (qVar != mVar.a && !qVar.d()) {
                if (qVar2 == null) {
                    qVar2 = qVar;
                }
                if (qVar.a() <= 0) {
                    break;
                }
            }
        }
        if (this.b.b()) {
            if (qVar != null) {
                return qVar;
            }
            if (this.b.c()) {
                return null;
            }
        }
        return qVar2;
    }

    private void b(m mVar, i iVar, q qVar, d dVar) throws BaseException, h {
        if (!qVar.d) {
            a(dVar);
            if (this.k == null) {
                this.k = dVar;
                if (this.a.getTotalBytes() <= 0) {
                    this.a.setTotalBytes(dVar.j());
                }
                synchronized (this.s) {
                    this.s.notify();
                }
            }
        } else if (this.j == null) {
            this.j = dVar;
            synchronized (this.s) {
                this.s.notify();
            }
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(qVar.a, dVar.b, iVar.d());
            }
            long j2 = dVar.j();
            if (j2 > 0) {
                for (i iVar2 : this.o) {
                    if (iVar2.f() <= 0 || iVar2.f() > j2 - 1) {
                        iVar2.c(j2 - 1);
                    }
                }
            }
        }
    }

    private void e(m mVar, i iVar) throws j {
        i iVar2;
        long j2;
        i iVar3;
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: start " + iVar);
        if (iVar.a == mVar) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: " + mVar + " is already the owner of " + iVar);
        } else if (iVar.a != null) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.a);
            throw new j(1, "segment already has an owner");
        } else if (mVar.h() == iVar.d()) {
            long c2 = iVar.c();
            int a2 = a(c2);
            if (a2 == -1 || (iVar2 = this.o.get(a2)) == null) {
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + a2);
                throw new j(2, "segment not exist");
            }
            if (iVar2 != iVar) {
                boolean z2 = false;
                if (iVar2.c() != iVar.c() || a(iVar2) <= 0) {
                    j2 = c2;
                } else {
                    m mVar2 = iVar2.a;
                    if (mVar2 != null) {
                        j2 = c2;
                        if (mVar.e - mVar2.e <= 1000 || iVar2.e() - iVar.e() >= a(iVar) / 2) {
                            Log.i("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2);
                        }
                    } else {
                        j2 = c2;
                    }
                    if (mVar2 != null) {
                        Log.i("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2);
                        mVar2.a(true);
                    } else {
                        Log.i("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2);
                    }
                    iVar.c(iVar2.f());
                    iVar.b(iVar2.j());
                    this.o.set(a2, iVar);
                    z2 = true;
                }
                if (!z2) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                    throw new j(2, "segment not exist, but has another same segment");
                }
            } else {
                j2 = c2;
            }
            long a3 = iVar.a();
            int i2 = a2 - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                i iVar4 = this.o.get(i2);
                long f2 = iVar4.f();
                if (f2 <= 0 || f2 >= j2) {
                    if (a3 <= 0 && iVar4.e() > j2) {
                        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar4 + ", segment = " + iVar);
                        this.o.remove(iVar);
                        throw new j(3, "prev overstep");
                    } else if (iVar4.a == null) {
                        iVar4.c(j2 - 1);
                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar4);
                        if (iVar4.a() > 0) {
                            Log.d("SegmentDispatcher", "applySegmentLocked:q break");
                            break;
                        }
                    } else {
                        long j3 = j2 - 1;
                        if (iVar4.a.a(j3)) {
                            iVar4.c(j3);
                            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar4);
                        } else {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar4);
                            throw new j(4, "prev end adjust fail");
                        }
                    }
                }
                i2--;
            }
            int i3 = a2 + 1;
            int size = this.o.size();
            while (true) {
                if (i3 >= size) {
                    break;
                }
                iVar3 = this.o.get(i3);
                if (iVar3.a() > 0 || iVar3.a != null) {
                    break;
                }
                i3++;
            }
            long f3 = iVar.f();
            long c3 = iVar3.c();
            if (f3 <= 0 || f3 >= c3) {
                long j4 = c3 - 1;
                iVar.c(j4);
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: segment set end:" + j4 + ", later = " + iVar3);
            }
            Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
            iVar.a = mVar;
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + iVar);
        } else {
            throw new j(5, "applySegment");
        }
    }

    private void a(d dVar) throws BaseException {
        d dVar2 = this.j;
        if (dVar2 != null || (dVar2 = this.k) != null) {
            long j2 = dVar.j();
            long j3 = dVar2.j();
            if (j2 != j3) {
                throw new BaseException(1074, "total len not equals,len=" + j2 + ",sLen=" + j3 + ",code=" + dVar.c + ",sCode=" + dVar2.c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a);
            } else if (!TextUtils.equals(dVar.c(), dVar2.c())) {
                throw new BaseException(1074, "etag not equals with main url");
            }
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "cancel");
        this.f = true;
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
        this.e.a();
        this.c.c();
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause");
        this.g = true;
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
        this.e.b();
        this.c.c();
    }

    private int a(long j2) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.o.get(i2);
            if (iVar.c() == j2) {
                return i2;
            }
            if (iVar.c() > j2) {
                return -1;
            }
        }
        return -1;
    }

    private void m() {
        if (this.m > 0) {
            synchronized (this) {
                int size = this.o.size();
                if (size > 1) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 1; i3 < size; i3++) {
                        i iVar = this.o.get(i2);
                        i iVar2 = this.o.get(i3);
                        if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
                            arrayList.add(iVar2);
                            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                        } else if (iVar2.e() > iVar.e()) {
                            i2++;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.o.removeAll(arrayList);
                    }
                }
            }
        }
    }

    private boolean n() {
        long j2 = this.m;
        if (j2 <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a2 = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a2);
            if (a2 >= j2) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    private i c(m mVar, q qVar) {
        int size = this.o.size();
        long j2 = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            long a2 = a(i3, size);
            if (a2 > j2) {
                i2 = i3;
                j2 = a2;
            }
        }
        long g2 = this.b.g();
        long h2 = this.b.h();
        if (i2 < 0 || j2 <= g2) {
            return null;
        }
        i iVar = this.o.get(i2);
        if (this.b.m()) {
            float d2 = d(mVar, qVar);
            long curBytes = (long) (((float) (this.m - this.a.getCurBytes())) * d2);
            if (curBytes < g2) {
                curBytes = g2;
            }
            if (h2 <= 0 || curBytes <= h2) {
                h2 = curBytes;
            }
            long j3 = g2 / 2;
            long j4 = j2 - j3;
            if (h2 > j4) {
                h2 = j4;
            } else if (h2 < j3) {
                h2 = j3;
            }
            i iVar2 = new i(iVar.e() + (j2 - h2), iVar.f());
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j2 + ", childLength = " + h2 + ", ratio = " + d2 + ", threadIndex = " + mVar.b);
            return iVar2;
        }
        i iVar3 = new i(iVar.e() + (j2 / 2), iVar.f());
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ",child = " + iVar3);
        return iVar3;
    }

    private float d(m mVar, q qVar) {
        long b2 = mVar.b();
        int size = this.h.size();
        if (size <= 1) {
            size = this.b.a();
        }
        float f2 = 1.0f;
        if (b2 <= 0) {
            float l2 = this.b.l();
            if (l2 <= 0.0f || l2 >= 1.0f) {
                l2 = 1.0f / ((float) size);
            }
            if (mVar.b == 0) {
                return l2;
            }
            if (size > 1) {
                f2 = 1.0f - l2;
                size--;
            }
        } else {
            long o2 = o();
            if (o2 > b2) {
                return ((float) b2) / ((float) o2);
            }
        }
        return f2 / ((float) size);
    }

    private long o() {
        long j2 = 0;
        for (m mVar : this.h) {
            j2 += mVar.b();
        }
        return j2;
    }

    private i p() {
        int i2 = 0;
        while (true) {
            i q2 = q();
            if (q2 == null) {
                return null;
            }
            m mVar = q2.a;
            if (mVar == null) {
                return q2;
            }
            if (q2.j() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b(currentTimeMillis);
            if (currentTimeMillis - mVar.e <= 2000 || !a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500, 1.0d)) {
                int i3 = i2 + 1;
                if (i2 > 2) {
                    if (this.A) {
                        Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + q2);
                    }
                    return q2;
                }
                try {
                    synchronized (this) {
                        wait(500);
                    }
                    i2 = i3;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                if (this.A) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q2 + ", owner.threadIndex = " + mVar.b);
                }
                return q2;
            }
        }
    }

    private i q() {
        int j2;
        i iVar = null;
        int i2 = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (j2 = iVar2.j()) < i2) {
                iVar = iVar2;
                i2 = j2;
            }
        }
        return iVar;
    }

    private long a(int i2, int i3) {
        i iVar = this.o.get(i2);
        long a2 = a(iVar);
        int i4 = i2 + 1;
        i iVar2 = i4 < i3 ? this.o.get(i4) : null;
        if (iVar2 == null) {
            return a2;
        }
        long c2 = iVar2.c() - iVar.e();
        if (a2 == -1) {
            return c2;
        }
        return Math.min(a2, c2);
    }

    private long a(i iVar) {
        long b2 = iVar.b();
        if (b2 != -1) {
            return b2;
        }
        long j2 = this.m;
        return j2 > 0 ? j2 - iVar.e() : b2;
    }

    /* access modifiers changed from: private */
    public m a(boolean z2, long j2, long j3) {
        m mVar = null;
        for (m mVar2 : this.h) {
            if ((mVar2.b != 0 || z2) && mVar2.c > 0 && mVar2.d <= 0 && j2 - mVar2.c > j3) {
                if (mVar == null || mVar2.c < mVar.c) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    /* access modifiers changed from: private */
    public long r() {
        if (this.f || this.g) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            b(currentTimeMillis);
            long j2 = this.b.j();
            if (j2 > 0) {
                long j3 = this.x;
                if (j3 > 0 && currentTimeMillis - j3 > j2 && a(currentTimeMillis, j2)) {
                    this.x = currentTimeMillis;
                    this.z++;
                }
            }
        }
        return 2000;
    }

    private void b(long j2) {
        this.t.a(this.a.getCurBytes(), j2);
        for (m mVar : this.h) {
            mVar.b(j2);
        }
    }

    private boolean a(m mVar, long j2, long j3, long j4, double d2) {
        if (mVar.e <= 0) {
            return false;
        }
        long b2 = this.t.b(j2, j3);
        int size = this.h.size();
        long j5 = size > 0 ? b2 / ((long) size) : b2;
        long a2 = mVar.a(j2, j3);
        if (a2 >= j4 && ((double) a2) >= ((double) j5) * d2) {
            return false;
        }
        Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + b2 + ", threadAvgSpeed = " + j5 + ", poorSpeed = " + j4 + ", speed = " + a2 + ",threadIndex = " + mVar.b);
        return true;
    }

    private boolean a(long j2, long j3) {
        long j4 = j2 - j3;
        long b2 = this.t.b(j4, j2);
        int size = this.h.size();
        if (size > 0) {
            b2 /= (long) size;
        }
        m a2 = a(j4, j2, (long) Math.max(10.0f, ((float) b2) * this.y), size / 2);
        if (a2 != null) {
            c(a2);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a2.b);
            a2.f();
            return true;
        }
        m a3 = a(true, j2, j3);
        if (a3 == null) {
            return false;
        }
        c(a3);
        com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a3.b);
        a3.f();
        return true;
    }

    private m a(long j2, long j3, long j4, int i2) {
        long j5;
        long j6 = Long.MAX_VALUE;
        int i3 = 0;
        m mVar = null;
        for (m mVar2 : this.h) {
            if (mVar2.e > 0) {
                i3++;
                if (mVar2.e < j2) {
                    long a2 = mVar2.a(j2, j3);
                    if (this.A) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a2 + ", threadIndex = " + mVar2.b);
                        j5 = 0;
                    } else {
                        j5 = 0;
                    }
                    if (a2 >= j5 && a2 < j6) {
                        j6 = a2;
                        mVar = mVar2;
                    }
                }
                j6 = j6;
            }
        }
        if (mVar == null || i3 < i2 || j6 >= j4) {
            return null;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j6 + ", threadIndex = " + mVar.b);
        return mVar;
    }
}
