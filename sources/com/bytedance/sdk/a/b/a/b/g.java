package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.b.f;
import com.bytedance.sdk.a.b.a.c.c;
import com.bytedance.sdk.a.b.a.e.b;
import com.bytedance.sdk.a.b.a.e.o;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* compiled from: StreamAllocation */
public final class g {
    static final /* synthetic */ boolean d = true;
    public final com.bytedance.sdk.a.b.a a;
    public final e b;
    public final p c;
    private f.a e;
    private ac f;
    private final j g;
    private final Object h;
    private final f i;
    private int j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private c o;

    public g(j jVar, com.bytedance.sdk.a.b.a aVar, e eVar, p pVar, Object obj) {
        this.g = jVar;
        this.a = aVar;
        this.b = eVar;
        this.c = pVar;
        this.i = new f(aVar, g(), eVar, pVar);
        this.h = obj;
    }

    public c a(v vVar, t.a aVar, boolean z) {
        try {
            c a2 = a(aVar.b(), aVar.c(), aVar.d(), vVar.r(), z).a(vVar, aVar, this);
            synchronized (this.g) {
                this.o = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    private c a(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.g) {
                if (a2.b == 0) {
                    return a2;
                }
            }
            if (a2.a(z2)) {
                return a2;
            }
            d();
        }
    }

    private c a(int i2, int i3, int i4, boolean z) throws IOException {
        c cVar;
        Socket f2;
        c cVar2;
        Socket socket;
        boolean z2;
        ac acVar;
        boolean z3;
        f.a aVar;
        synchronized (this.g) {
            if (this.m) {
                throw new IllegalStateException("released");
            } else if (this.o != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.n) {
                cVar = this.k;
                f2 = f();
                cVar2 = this.k;
                socket = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.l) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    com.bytedance.sdk.a.b.a.a.a.a(this.g, this.a, this, null);
                    c cVar3 = this.k;
                    if (cVar3 != null) {
                        cVar2 = cVar3;
                        z2 = true;
                        acVar = null;
                    } else {
                        acVar = this.f;
                    }
                } else {
                    acVar = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        com.bytedance.sdk.a.b.a.c.a(f2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
        if (z2) {
            this.c.a(this.b, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (acVar != null || ((aVar = this.e) != null && aVar.a())) {
            z3 = false;
        } else {
            this.e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (!this.n) {
                if (z3) {
                    List<ac> c2 = this.e.c();
                    int size = c2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        ac acVar2 = c2.get(i5);
                        com.bytedance.sdk.a.b.a.a.a.a(this.g, this.a, this, acVar2);
                        c cVar4 = this.k;
                        if (cVar4 != null) {
                            this.f = acVar2;
                            cVar2 = cVar4;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (acVar == null) {
                        acVar = this.e.b();
                    }
                    this.f = acVar;
                    this.j = 0;
                    cVar2 = new c(this.g, acVar);
                    a(cVar2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.c.a(this.b, cVar2);
            return cVar2;
        }
        cVar2.a(i2, i3, i4, z, this.b, this.c);
        g().b(cVar2.a());
        synchronized (this.g) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.a.b(this.g, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.a.a(this.g, this.a, this);
                cVar2 = this.k;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.c.a(this.b, cVar2);
        return cVar2;
    }

    private Socket f() {
        if (d || Thread.holdsLock(this.g)) {
            c cVar = this.k;
            if (cVar == null || !cVar.a) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    public void a(boolean z, c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.c.b(this.b, j2);
        synchronized (this.g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.k.b++;
                    }
                    cVar2 = this.k;
                    a2 = a(z, false, true);
                    if (this.k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar2 != null) {
            this.c.b(this.b, cVar2);
        }
        if (iOException != null) {
            this.c.a(this.b, iOException);
        } else if (z2) {
            this.c.g(this.b);
        }
    }

    public c a() {
        c cVar;
        synchronized (this.g) {
            cVar = this.o;
        }
        return cVar;
    }

    private d g() {
        return com.bytedance.sdk.a.b.a.a.a.a(this.g);
    }

    public synchronized c b() {
        return this.k;
    }

    public void c() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(false, true, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(true, false, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (d || Thread.holdsLock(this.g)) {
            if (z3) {
                this.o = null;
            }
            if (z2) {
                this.m = true;
            }
            c cVar = this.k;
            if (cVar == null) {
                return null;
            }
            if (z) {
                cVar.a = true;
            }
            if (this.o != null) {
                return null;
            }
            if (!this.m && !this.k.a) {
                return null;
            }
            b(this.k);
            if (this.k.d.isEmpty()) {
                this.k.e = System.nanoTime();
                if (com.bytedance.sdk.a.b.a.a.a.a(this.g, this.k)) {
                    socket = this.k.b();
                    this.k = null;
                    return socket;
                }
            }
            socket = null;
            this.k = null;
            return socket;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        synchronized (this.g) {
            cVar = null;
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.a == b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.a != b.REFUSED_STREAM || this.j > 1) {
                    this.f = null;
                }
                z = false;
                c cVar2 = this.k;
                a2 = a(z, false, true);
                if (this.k == null) {
                    if (this.l) {
                        cVar = cVar2;
                    }
                }
            } else {
                c cVar3 = this.k;
                if (cVar3 != null && (!cVar3.d() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.k.b == 0) {
                        ac acVar = this.f;
                        if (!(acVar == null || iOException == null)) {
                            this.i.a(acVar, iOException);
                        }
                        this.f = null;
                    }
                }
                z = false;
                c cVar2 = this.k;
                a2 = a(z, false, true);
                if (this.k == null) {
                }
            }
            z = true;
            c cVar2 = this.k;
            a2 = a(z, false, true);
            if (this.k == null) {
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        } else if (this.k == null) {
            this.k = cVar;
            this.l = z;
            cVar.d.add(new a(this, this.h));
        } else {
            throw new IllegalStateException();
        }
    }

    private void b(c cVar) {
        int size = cVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.d.get(i2).get() == this) {
                cVar.d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        } else if (this.o == null && this.k.d.size() == 1) {
            Socket a2 = a(true, false, false);
            this.k = cVar;
            cVar.d.add(this.k.d.get(0));
            return a2;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean e() {
        f.a aVar;
        return this.f != null || ((aVar = this.e) != null && aVar.a()) || this.i.a();
    }

    public String toString() {
        c b2 = b();
        return b2 != null ? b2.toString() : this.a.toString();
    }

    /* compiled from: StreamAllocation */
    public static final class a extends WeakReference<g> {
        public final Object a;

        a(g gVar, Object obj) {
            super(gVar);
            this.a = obj;
        }
    }
}
