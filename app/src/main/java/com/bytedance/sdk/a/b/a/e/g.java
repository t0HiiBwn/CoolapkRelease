package com.bytedance.sdk.a.b.a.e;

import android.os.SystemClock;
import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.b.a.e.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection */
public final class g implements Closeable {
    static final ExecutorService a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean s = true;
    final boolean b;
    final b c;
    final Map<Integer, i> d = new LinkedHashMap();
    final String e;
    int f;
    int g;
    boolean h;
    final m i;
    long j = 0;
    long k;

    /* renamed from: l  reason: collision with root package name */
    n f1271l = new n();
    final n m;
    boolean n;
    final Socket o;
    final j p;
    final c q;
    final Set<Integer> r;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private int v;

    /* compiled from: Http2Connection */
    public static abstract class b {
        public static final b f = new b() {
            /* class com.bytedance.sdk.a.b.a.e.g.b.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.b.a.e.g.b
            public void a(i iVar) throws IOException {
                iVar.a(b.REFUSED_STREAM);
            }
        };

        public void a(g gVar) {
        }

        public abstract void a(i iVar) throws IOException;
    }

    boolean d(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    g(a aVar) {
        n nVar = new n();
        this.m = nVar;
        this.n = false;
        this.r = new LinkedHashSet();
        this.i = aVar.f;
        boolean z = aVar.g;
        this.b = z;
        this.c = aVar.e;
        int i2 = 2;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : i2;
        if (aVar.g) {
            this.f1271l.a(7, 16777216);
        }
        String str = aVar.b;
        this.e = str;
        this.t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", str), true));
        nVar.a(7, 65535);
        nVar.a(5, 16384);
        this.k = (long) nVar.d();
        this.o = aVar.a;
        this.p = new j(aVar.d, z);
        this.q = new c(new h(aVar.c, z));
    }

    synchronized i a(int i2) {
        return this.d.get(Integer.valueOf(i2));
    }

    synchronized i b(int i2) {
        i remove;
        remove = this.d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.m.c(Integer.MAX_VALUE);
    }

    public i a(List<c> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    private i b(int i2, List<c> list, boolean z) throws IOException {
        int i3;
        i iVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.p) {
            synchronized (this) {
                if (!this.h) {
                    i3 = this.g;
                    this.g = i3 + 2;
                    iVar = new i(i3, this, z3, false, list);
                    if (z && this.k != 0) {
                        if (iVar.b != 0) {
                            z2 = false;
                            if (iVar.b()) {
                                this.d.put(Integer.valueOf(i3), iVar);
                            }
                        }
                    }
                    z2 = true;
                    if (iVar.b()) {
                    }
                } else {
                    throw new a();
                }
            }
            if (i2 == 0) {
                this.p.a(z3, i3, i2, list);
            } else if (!this.b) {
                this.p.a(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.p.b();
        }
        return iVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.p.c());
        r6 = (long) r3;
        r8.k -= r6;
     */
    public void a(int i2, boolean z, com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.p.a(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j4 = this.k;
                        if (j4 > 0) {
                            break;
                        } else if (this.d.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
            }
            j2 -= j3;
            this.p.a(z && j2 == 0, i2, cVar, min);
        }
    }

    void a(long j2) {
        this.k += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    void a(final int i2, final b bVar) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}) {
            /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(i2, bVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    void b(int i2, b bVar) throws IOException {
        this.p.a(i2, bVar);
    }

    void a(final int i2, final long j2) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}) {
            /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass2 */

            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.p.a(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    void a(final boolean z, final int i2, final int i3, final l lVar) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i2), Integer.valueOf(i3)}) {
            /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass3 */

            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(z, i2, i3, lVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    void b(boolean z, int i2, int i3, l lVar) throws IOException {
        synchronized (this.p) {
            if (lVar != null) {
                lVar.a();
            }
            this.p.a(z, i2, i3);
        }
    }

    synchronized l c(int i2) {
        Map<Integer, l> map;
        map = this.u;
        return map != null ? map.remove(Integer.valueOf(i2)) : null;
    }

    public void b() throws IOException {
        this.p.b();
    }

    public void a(b bVar) throws IOException {
        synchronized (this.p) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.p.a(this.f, bVar, com.bytedance.sdk.a.b.a.c.a);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(b.NO_ERROR, b.CANCEL);
    }

    void a(b bVar, b bVar2) throws IOException {
        IOException e2;
        i[] iVarArr;
        if (s || !Thread.holdsLock(this)) {
            l[] lVarArr = null;
            try {
                a(bVar);
                e2 = null;
            } catch (IOException e3) {
                e2 = e3;
            }
            synchronized (this) {
                if (!this.d.isEmpty()) {
                    iVarArr = (i[]) this.d.values().toArray(new i[this.d.size()]);
                    this.d.clear();
                } else {
                    iVarArr = null;
                }
                Map<Integer, l> map = this.u;
                if (map != null) {
                    this.u = null;
                    lVarArr = (l[]) map.values().toArray(new l[this.u.size()]);
                }
            }
            if (iVarArr != null) {
                for (i iVar : iVarArr) {
                    try {
                        iVar.a(bVar2);
                    } catch (IOException e4) {
                        if (e2 != null) {
                            e2 = e4;
                        }
                    }
                }
            }
            if (lVarArr != null) {
                for (l lVar : lVarArr) {
                    lVar.c();
                }
            }
            try {
                this.p.close();
            } catch (IOException e5) {
                if (e2 == null) {
                    e2 = e5;
                }
            }
            try {
                this.o.close();
            } catch (IOException e6) {
                e2 = e6;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    public void c() throws IOException {
        a(true);
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.p.a();
            this.p.b(this.f1271l);
            int d2 = this.f1271l.d();
            if (d2 != 65535) {
                this.p.a(0, (long) (d2 - 65535));
            }
        }
        Thread thread = new Thread(this.q);
        thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    public synchronized boolean d() {
        return this.h;
    }

    /* compiled from: Http2Connection */
    public static class a {
        Socket a;
        String b;
        e c;
        d d;
        b e = b.f;
        m f = m.a;
        boolean g;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, e eVar, d dVar) {
            this.a = socket;
            this.b = str;
            this.c = eVar;
            this.d = dVar;
            return this;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* compiled from: Http2Connection */
    class c extends com.bytedance.sdk.a.b.a.b implements h.b {
        final h a;

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a() {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        c(h hVar) {
            super("OkHttp %s", g.this.e);
            this.a = hVar;
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            g gVar;
            b bVar;
            b bVar2 = b.INTERNAL_ERROR;
            b bVar3 = b.INTERNAL_ERROR;
            try {
                this.a.a(this);
                while (this.a.a(false, (h.b) this)) {
                }
                bVar2 = b.NO_ERROR;
                bVar = b.CANCEL;
                try {
                    gVar = g.this;
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                bVar2 = b.PROTOCOL_ERROR;
                bVar = b.PROTOCOL_ERROR;
                gVar = g.this;
            } catch (Throwable th) {
                try {
                    g.this.a(bVar2, bVar3);
                } catch (IOException unused3) {
                }
                com.bytedance.sdk.a.b.a.c.a(this.a);
                throw th;
            }
            gVar.a(bVar2, bVar);
            com.bytedance.sdk.a.b.a.c.a(this.a);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, e eVar, int i2) throws IOException {
            if (g.this.d(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            i a2 = g.this.a(i);
            if (a2 == null) {
                g.this.a(i, b.PROTOCOL_ERROR);
                eVar.h((long) i2);
                return;
            }
            a2.a(eVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2, List<c> list) {
            i a2;
            if (g.this.d(i)) {
                g.this.a(i, list, z);
                return;
            }
            synchronized (g.this) {
                a2 = g.this.a(i);
                if (a2 == null) {
                    if (!g.this.h) {
                        if (i > g.this.f) {
                            if (i % 2 != g.this.g % 2) {
                                final i iVar = new i(i, g.this, false, z, list);
                                g.this.f = i;
                                g.this.d.put(Integer.valueOf(i), iVar);
                                g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.e, Integer.valueOf(i)}) {
                                    /* class com.bytedance.sdk.a.b.a.e.g.c.AnonymousClass1 */

                                    @Override // com.bytedance.sdk.a.b.a.b
                                    public void b() {
                                        try {
                                            g.this.c.a(iVar);
                                        } catch (IOException e) {
                                            com.bytedance.sdk.a.b.a.g.e b = com.bytedance.sdk.a.b.a.g.e.b();
                                            b.a(4, "Http2Connection.Listener failure for " + g.this.e, e);
                                            try {
                                                iVar.a(b.PROTOCOL_ERROR);
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            a2.a(list);
            if (z) {
                a2.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, b bVar) {
            if (g.this.d(i)) {
                g.this.c(i, bVar);
                return;
            }
            i b = g.this.b(i);
            if (b != null) {
                b.c(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            int i;
            synchronized (g.this) {
                int d = g.this.m.d();
                if (z) {
                    g.this.m.a();
                }
                g.this.m.a(nVar);
                a(nVar);
                int d2 = g.this.m.d();
                iVarArr = null;
                if (d2 == -1 || d2 == d) {
                    j = 0;
                } else {
                    j = (long) (d2 - d);
                    if (!g.this.n) {
                        g.this.a(j);
                        g.this.n = true;
                    }
                    if (!g.this.d.isEmpty()) {
                        iVarArr = (i[]) g.this.d.values().toArray(new i[g.this.d.size()]);
                    }
                }
                g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.e) {
                    /* class com.bytedance.sdk.a.b.a.e.g.c.AnonymousClass2 */

                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g.this.c.a(g.this);
                    }
                });
            }
            if (!(iVarArr == null || j == 0)) {
                for (i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
        }

        private void a(final n nVar) {
            g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.e}) {
                /* class com.bytedance.sdk.a.b.a.e.g.c.AnonymousClass3 */

                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.p.a(nVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2) {
            if (z) {
                l c2 = g.this.c(i);
                if (c2 != null) {
                    c2.b();
                    return;
                }
                return;
            }
            g.this.a(true, i, i2, (l) null);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, b bVar, f fVar) {
            i[] iVarArr;
            fVar.g();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.d.values().toArray(new i[g.this.d.size()]);
                g.this.h = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i && iVar.c()) {
                    iVar.c(b.REFUSED_STREAM);
                    g.this.b(iVar.a());
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g.this.k += j;
                    g.this.notifyAll();
                }
                return;
            }
            i a2 = g.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, int i2, List<c> list) {
            g.this.a(i2, list);
        }
    }

    void a(final int i2, final List<c> list) {
        synchronized (this) {
            if (this.r.contains(Integer.valueOf(i2))) {
                a(i2, b.PROTOCOL_ERROR);
                return;
            }
            this.r.add(Integer.valueOf(i2));
            this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
                /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass4 */

                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    if (g.this.i.a(i2, list)) {
                        try {
                            g.this.p.a(i2, b.CANCEL);
                            synchronized (g.this) {
                                g.this.r.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    void a(final int i2, final List<c> list, final boolean z) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
            /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass5 */

            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean a2 = g.this.i.a(i2, list, z);
                if (a2) {
                    try {
                        g.this.p.a(i2, b.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (a2 || z) {
                    synchronized (g.this) {
                        g.this.r.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    void a(final int i2, e eVar, final int i3, final boolean z) throws IOException {
        final com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        long j2 = (long) i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.b() == j2) {
            this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
                /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass6 */

                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        boolean a2 = g.this.i.a(i2, cVar, i3, z);
                        if (a2) {
                            g.this.p.a(i2, b.CANCEL);
                        }
                        if (a2 || z) {
                            synchronized (g.this) {
                                g.this.r.remove(Integer.valueOf(i2));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cVar.b() + " != " + i3);
    }

    void c(final int i2, final b bVar) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
            /* class com.bytedance.sdk.a.b.a.e.g.AnonymousClass7 */

            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.i.a(i2, bVar);
                synchronized (g.this) {
                    g.this.r.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
