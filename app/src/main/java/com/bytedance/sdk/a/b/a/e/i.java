package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: Http2Stream */
public final class i {
    static final /* synthetic */ boolean i = true;
    long a = 0;
    long b;
    final int c;
    final g d;
    final a e;
    final c f = new c();
    final c g = new c();
    b h = null;
    private final List<c> j;
    private List<c> k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1272l;
    private final b m;

    i(int i2, g gVar, boolean z, boolean z2, List<c> list) {
        Objects.requireNonNull(gVar, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.c = i2;
        this.d = gVar;
        this.b = (long) gVar.m.d();
        b bVar = new b((long) gVar.f1271l.d());
        this.m = bVar;
        a aVar = new a();
        this.e = aVar;
        bVar.b = z2;
        aVar.b = z;
        this.j = list;
    }

    public int a() {
        return this.c;
    }

    public synchronized boolean b() {
        if (this.h != null) {
            return false;
        }
        if ((this.m.b || this.m.a) && ((this.e.b || this.e.a) && this.f1272l)) {
            return false;
        }
        return true;
    }

    public boolean c() {
        if (this.d.b == ((this.c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public synchronized List<c> d() throws IOException {
        List<c> list;
        if (c()) {
            this.f.a();
            while (this.k == null && this.h == null) {
                try {
                    l();
                } catch (Throwable th) {
                    this.f.h();
                    throw th;
                }
            }
            this.f.h();
            list = this.k;
            if (list != null) {
                this.k = null;
            } else {
                throw new o(this.h);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public t e() {
        return this.f;
    }

    public t f() {
        return this.g;
    }

    public s g() {
        return this.m;
    }

    public r h() {
        synchronized (this) {
            if (!this.f1272l) {
                if (!c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.e;
    }

    public void a(b bVar) throws IOException {
        if (d(bVar)) {
            this.d.b(this.c, bVar);
        }
    }

    public void b(b bVar) {
        if (d(bVar)) {
            this.d.a(this.c, bVar);
        }
    }

    private boolean d(b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.h != null) {
                    return false;
                }
                if (this.m.b && this.e.b) {
                    return false;
                }
                this.h = bVar;
                notifyAll();
                this.d.b(this.c);
                return true;
            }
        }
        throw new AssertionError();
    }

    void a(List<c> list) {
        boolean z;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f1272l = true;
                if (this.k == null) {
                    this.k = list;
                    z = b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.k = arrayList;
                }
            }
            if (!z) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    void a(e eVar, int i2) throws IOException {
        if (i || !Thread.holdsLock(this)) {
            this.m.a(eVar, (long) i2);
            return;
        }
        throw new AssertionError();
    }

    void i() {
        boolean b2;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.m.b = true;
                b2 = b();
                notifyAll();
            }
            if (!b2) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    synchronized void c(b bVar) {
        if (this.h == null) {
            this.h = bVar;
            notifyAll();
        }
    }

    /* compiled from: Http2Stream */
    private final class b implements s {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;
        private final com.bytedance.sdk.a.a.c e = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c f = new com.bytedance.sdk.a.a.c();
        private final long g;

        b(long j) {
            this.g = j;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            long a2;
            if (j >= 0) {
                synchronized (i.this) {
                    b();
                    c();
                    if (this.f.b() == 0) {
                        return -1;
                    }
                    com.bytedance.sdk.a.a.c cVar2 = this.f;
                    a2 = cVar2.a(cVar, Math.min(j, cVar2.b()));
                    i.this.a += a2;
                    if (i.this.a >= ((long) (i.this.d.f1271l.d() / 2))) {
                        i.this.d.a(i.this.c, i.this.a);
                        i.this.a = 0;
                    }
                }
                synchronized (i.this.d) {
                    i.this.d.j += a2;
                    if (i.this.d.j >= ((long) (i.this.d.f1271l.d() / 2))) {
                        i.this.d.a(0, i.this.d.j);
                        i.this.d.j = 0;
                    }
                }
                return a2;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        private void b() throws IOException {
            i.this.f.a();
            while (this.f.b() == 0 && !this.b && !this.a && i.this.h == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.f.h();
                }
            }
        }

        void a(e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (c || !Thread.holdsLock(i.this)) {
                while (j > 0) {
                    synchronized (i.this) {
                        z = this.b;
                        z2 = true;
                        z3 = this.f.b() + j > this.g;
                    }
                    if (z3) {
                        eVar.h(j);
                        i.this.b(b.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        eVar.h(j);
                        return;
                    } else {
                        long a2 = eVar.a(this.e, j);
                        if (a2 != -1) {
                            j -= a2;
                            synchronized (i.this) {
                                if (this.f.b() != 0) {
                                    z2 = false;
                                }
                                this.f.a(this.e);
                                if (z2) {
                                    i.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return i.this.f;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.a = true;
                this.f.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.a) {
                throw new IOException("stream closed");
            } else if (i.this.h != null) {
                throw new o(i.this.h);
            }
        }
    }

    void j() throws IOException {
        boolean z;
        boolean b2;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.m.b && this.m.a && (this.e.b || this.e.a);
                b2 = b();
            }
            if (z) {
                a(b.CANCEL);
            } else if (!b2) {
                this.d.b(this.c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* compiled from: Http2Stream */
    final class a implements r {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;
        private final com.bytedance.sdk.a.a.c e = new com.bytedance.sdk.a.a.c();

        a() {
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (c || !Thread.holdsLock(i.this)) {
                this.e.a_(cVar, j);
                while (this.e.b() >= 16384) {
                    a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.g.a();
                while (i.this.b <= 0 && !this.b && !this.a && i.this.h == null) {
                    try {
                        i.this.l();
                    } catch (Throwable th) {
                        i.this.g.h();
                        throw th;
                    }
                }
                i.this.g.h();
                i.this.k();
                min = Math.min(i.this.b, this.e.b());
                i.this.b -= min;
            }
            i.this.g.a();
            try {
                i.this.d.a(i.this.c, z && min == this.e.b(), this.e, min);
            } finally {
                i.this.g.h();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (c || !Thread.holdsLock(i.this)) {
                synchronized (i.this) {
                    i.this.k();
                }
                while (this.e.b() > 0) {
                    a(false);
                    i.this.d.b();
                }
                return;
            }
            throw new AssertionError();
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return i.this.g;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (c || !Thread.holdsLock(i.this)) {
                synchronized (i.this) {
                    if (this.a) {
                        return;
                    }
                }
                if (!i.this.e.b) {
                    if (this.e.b() > 0) {
                        while (this.e.b() > 0) {
                            a(true);
                        }
                    } else {
                        i.this.d.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.a = true;
                }
                i.this.d.b();
                i.this.j();
                return;
            }
            throw new AssertionError();
        }
    }

    void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.e.a) {
            throw new IOException("stream closed");
        } else if (this.e.b) {
            throw new IOException("stream finished");
        } else if (this.h != null) {
            throw new o(this.h);
        }
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* compiled from: Http2Stream */
    class c extends com.bytedance.sdk.a.a.a {
        c() {
        }

        @Override // com.bytedance.sdk.a.a.a
        protected void a_() {
            i.this.b(b.CANCEL);
        }

        @Override // com.bytedance.sdk.a.a.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void h() throws IOException {
            if (b()) {
                throw b((IOException) null);
            }
        }
    }
}
