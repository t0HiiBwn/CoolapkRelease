package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a;
import com.bytedance.sdk.a.b.a.e.b;
import com.bytedance.sdk.a.b.a.e.f;
import com.bytedance.sdk.a.b.a.e.g;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.k;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.q;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* compiled from: RealConnection */
public final class c extends g.b implements i {
    public boolean a;
    public int b;
    public int c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final j g;
    private final ac h;
    private Socket i;
    private Socket j;
    private q k;
    private w l;
    private g m;
    private e n;
    private d o;

    public c(j jVar, ac acVar) {
        this.g = jVar;
        this.h = acVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void a(int i2, int i3, int i4, boolean z, com.bytedance.sdk.a.b.e eVar, p pVar) {
        IOException e2;
        if (this.l == null) {
            List<k> f = this.h.a().f();
            b bVar = new b(f);
            if (this.h.a().i() == null) {
                if (f.contains(k.c)) {
                    String f2 = this.h.a().a().f();
                    if (!com.bytedance.sdk.a.b.a.g.e.b().b(f2)) {
                        throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
                    }
                } else {
                    throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            }
            e eVar2 = null;
            do {
                try {
                    if (!this.h.d()) {
                        a(i2, i3, i4, eVar, pVar);
                        if (this.i != null) {
                        }
                        if (!this.h.d() && this.i == null) {
                            throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
                        } else if (this.m != null) {
                            synchronized (this.g) {
                                this.c = this.m.a();
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        try {
                            a(i2, i3, eVar, pVar);
                        } catch (IOException e3) {
                            e2 = e3;
                            com.bytedance.sdk.a.b.a.c.a(this.j);
                            com.bytedance.sdk.a.b.a.c.a(this.i);
                            this.j = null;
                            this.i = null;
                            this.n = null;
                            this.o = null;
                            this.k = null;
                            this.l = null;
                            this.m = null;
                            pVar.a(eVar, this.h.c(), this.h.b(), null, e2);
                            if (eVar2 != null) {
                            }
                            throw eVar2;
                        }
                    }
                    a(bVar, eVar, pVar);
                    pVar.a(eVar, this.h.c(), this.h.b(), this.l);
                    if (!this.h.d()) {
                    }
                    if (this.m != null) {
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    com.bytedance.sdk.a.b.a.c.a(this.j);
                    com.bytedance.sdk.a.b.a.c.a(this.i);
                    this.j = null;
                    this.i = null;
                    this.n = null;
                    this.o = null;
                    this.k = null;
                    this.l = null;
                    this.m = null;
                    pVar.a(eVar, this.h.c(), this.h.b(), null, e2);
                    if (eVar2 != null) {
                        eVar2 = new e(e2);
                    } else {
                        eVar2.a(e2);
                    }
                    if (!z || bVar.a(e2)) {
                        throw eVar2;
                    }
                    do {
                        if (!this.h.d()) {
                        }
                        a(bVar, eVar, pVar);
                        pVar.a(eVar, this.h.c(), this.h.b(), this.l);
                        if (!this.h.d()) {
                        }
                        if (this.m != null) {
                        }
                    } while (bVar.a(e2));
                    throw eVar2;
                }
            } while (bVar.a(e2));
            throw eVar2;
        }
        throw new IllegalStateException("already connected");
    }

    private void a(int i2, int i3, int i4, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        y e2 = e();
        s a2 = e2.a();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3, eVar, pVar);
            e2 = a(i3, i4, e2, a2);
            if (e2 != null) {
                com.bytedance.sdk.a.b.a.c.a(this.i);
                this.i = null;
                this.o = null;
                this.n = null;
                pVar.a(eVar, this.h.c(), this.h.b(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i2, int i3, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        Proxy b2 = this.h.b();
        this.i = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.h.a().c().createSocket() : new Socket(b2);
        pVar.a(eVar, this.h.c(), b2);
        this.i.setSoTimeout(i3);
        try {
            com.bytedance.sdk.a.b.a.g.e.b().a(this.i, this.h.c(), i2);
            try {
                this.n = l.a(l.b(this.i));
                this.o = l.a(l.a(this.i));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        if (this.h.a().i() == null) {
            this.l = w.HTTP_1_1;
            this.j = this.i;
            return;
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.k);
        if (this.l == w.HTTP_2) {
            this.j.setSoTimeout(0);
            g a2 = new g.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a();
            this.m = a2;
            a2.c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0113 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0119 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011c  */
    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e2;
        a a2 = this.h.a();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            SSLSocket sSLSocket2 = (SSLSocket) a2.i().createSocket(this.i, a2.a().f(), a2.a().g(), true);
            try {
                k a3 = bVar.a(sSLSocket2);
                if (a3.d()) {
                    com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket2, a2.a().f(), a2.e());
                }
                sSLSocket2.startHandshake();
                q a4 = q.a(sSLSocket2.getSession());
                if (a2.j().verify(a2.a().f(), sSLSocket2.getSession())) {
                    a2.k().a(a2.a().f(), a4.b());
                    if (a3.d()) {
                        str = com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket2);
                    }
                    this.j = sSLSocket2;
                    this.n = l.a(l.b(sSLSocket2));
                    this.o = l.a(l.a(this.j));
                    this.k = a4;
                    this.l = str != null ? w.a(str) : w.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket2);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) a4.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + a2.a().f() + " not verified:\n    certificate: " + com.bytedance.sdk.a.b.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            } catch (AssertionError e3) {
                e2 = e3;
                sSLSocket = sSLSocket2;
                try {
                    if (!com.bytedance.sdk.a.b.a.c.a(e2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket);
                    }
                    com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                }
                com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket);
                throw th;
            }
        } catch (AssertionError e4) {
            e2 = e4;
            if (!com.bytedance.sdk.a.b.a.c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    private y a(int i2, int i3, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.n, this.o);
            this.n.a().a((long) i2, TimeUnit.MILLISECONDS);
            this.o.a().a((long) i3, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.b();
            aa a2 = aVar.a(false).a(yVar).a();
            long a3 = com.bytedance.sdk.a.b.a.c.e.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            com.bytedance.sdk.a.a.s b2 = aVar.b(a3);
            com.bytedance.sdk.a.b.a.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int c2 = a2.c();
            if (c2 != 200) {
                if (c2 == 407) {
                    y a4 = this.h.a().d().a(this.h, a2);
                    if (a4 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a2.a("Connection"))) {
                        return a4;
                    } else {
                        yVar = a4;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a2.c());
                }
            } else if (this.n.c().e() && this.o.c().e()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private y e() {
        return new y.a().a(this.h.a().a()).a("Host", com.bytedance.sdk.a.b.a.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", com.bytedance.sdk.a.b.a.d.a()).d();
    }

    public boolean a(a aVar, ac acVar) {
        if (this.d.size() >= this.c || this.a || !com.bytedance.sdk.a.b.a.a.a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(a().a().a().f())) {
            return true;
        }
        if (this.m == null || acVar == null || acVar.b().type() != Proxy.Type.DIRECT || this.h.b().type() != Proxy.Type.DIRECT || !this.h.c().equals(acVar.c()) || acVar.a().j() != com.bytedance.sdk.a.b.a.i.e.a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), c().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (sVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        if (this.k == null || !com.bytedance.sdk.a.b.a.i.e.a.a(sVar.f(), (X509Certificate) this.k.b().get(0))) {
            return false;
        }
        return true;
    }

    public com.bytedance.sdk.a.b.a.c.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        if (this.m != null) {
            return new f(vVar, aVar, gVar, this.m);
        }
        this.j.setSoTimeout(aVar.c());
        this.n.a().a((long) aVar.c(), TimeUnit.MILLISECONDS);
        this.o.a().a((long) aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(vVar, gVar, this.n, this.o);
    }

    @Override // com.bytedance.sdk.a.b.i
    public ac a() {
        return this.h;
    }

    public Socket b() {
        return this.j;
    }

    /* JADX INFO: finally extract failed */
    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        g gVar = this.m;
        if (gVar != null) {
            return !gVar.d();
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    if (this.n.e()) {
                        this.j.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.j.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.j.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.i iVar) throws IOException {
        iVar.a(b.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(g gVar) {
        synchronized (this.g) {
            this.c = gVar.a();
        }
    }

    public q c() {
        return this.k;
    }

    public boolean d() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(":");
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        q qVar = this.k;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}
