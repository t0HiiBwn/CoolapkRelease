package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.a.e;
import com.bytedance.sdk.a.b.a.b.d;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: OkHttpClient */
public class v implements Cloneable {
    static final List<w> a = c.a(w.HTTP_2, w.HTTP_1_1);
    static final List<k> b = c.a(k.a, k.c);
    final int A;
    final int B;
    final int C;
    final n c;
    final Proxy d;
    final List<w> e;
    final List<k> f;
    final List<t> g;
    final List<t> h;
    final p.a i;
    final ProxySelector j;
    final m k;
    final c l;
    final e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final com.bytedance.sdk.a.b.a.i.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.a = new com.bytedance.sdk.a.b.a.a() {
            /* class com.bytedance.sdk.a.b.v.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                return jVar.b(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.c a(j jVar, a aVar, g gVar, ac acVar) {
                return jVar.a(aVar, gVar, acVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(a aVar, a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public Socket a(j jVar, a aVar, g gVar) {
                return jVar.a(aVar, gVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void b(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                jVar.a(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public d a(j jVar) {
                return jVar.a;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public int a(aa.a aVar) {
                return aVar.c;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }
        };
    }

    public v() {
        this(new a());
    }

    v(a aVar) {
        boolean z2;
        this.c = aVar.a;
        this.d = aVar.b;
        this.e = aVar.c;
        List<k> list = aVar.d;
        this.f = list;
        this.g = c.a(aVar.e);
        this.h = c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<k> it2 = list.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                k next = it2.next();
                if (z2 || next.a()) {
                    z2 = true;
                }
            }
        }
        if (aVar.m != null || !z2) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager z3 = z();
            this.o = a(z3);
            this.p = com.bytedance.sdk.a.b.a.i.c.a(z3);
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        } else if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw c.a("No System TLS", (Exception) e2);
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw c.a("No System TLS", (Exception) e2);
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public Proxy d() {
        return this.d;
    }

    public ProxySelector e() {
        return this.j;
    }

    public m f() {
        return this.k;
    }

    e g() {
        c cVar = this.l;
        return cVar != null ? cVar.a : this.m;
    }

    public o h() {
        return this.v;
    }

    public SocketFactory i() {
        return this.n;
    }

    public SSLSocketFactory j() {
        return this.o;
    }

    public HostnameVerifier k() {
        return this.q;
    }

    public g l() {
        return this.r;
    }

    public b m() {
        return this.t;
    }

    public b n() {
        return this.s;
    }

    public j o() {
        return this.u;
    }

    public boolean p() {
        return this.w;
    }

    public boolean q() {
        return this.x;
    }

    public boolean r() {
        return this.y;
    }

    public n s() {
        return this.c;
    }

    public List<w> t() {
        return this.e;
    }

    public List<k> u() {
        return this.f;
    }

    public List<t> v() {
        return this.g;
    }

    public List<t> w() {
        return this.h;
    }

    public p.a x() {
        return this.i;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }

    public a y() {
        return new a(this);
    }

    /* compiled from: OkHttpClient */
    public static final class a {
        int A;
        n a;
        Proxy b;
        List<w> c;
        List<k> d;
        final List<t> e;
        final List<t> f;
        p.a g;
        ProxySelector h;
        m i;
        c j;
        e k;
        SocketFactory l;
        SSLSocketFactory m;
        com.bytedance.sdk.a.b.a.i.c n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new n();
            this.c = v.a;
            this.d = v.b;
            this.g = p.a(p.a);
            this.h = ProxySelector.getDefault();
            this.i = m.a;
            this.l = SocketFactory.getDefault();
            this.o = com.bytedance.sdk.a.b.a.i.e.a;
            this.p = g.a;
            this.q = b.a;
            this.r = b.a;
            this.s = new j();
            this.t = o.a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        a(v vVar) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = vVar.c;
            this.b = vVar.d;
            this.c = vVar.e;
            this.d = vVar.f;
            arrayList.addAll(vVar.g);
            arrayList2.addAll(vVar.h);
            this.g = vVar.i;
            this.h = vVar.j;
            this.i = vVar.k;
            this.k = vVar.m;
            this.j = vVar.l;
            this.l = vVar.n;
            this.m = vVar.o;
            this.n = vVar.p;
            this.o = vVar.q;
            this.p = vVar.r;
            this.q = vVar.s;
            this.r = vVar.t;
            this.s = vVar.u;
            this.t = vVar.v;
            this.u = vVar.w;
            this.v = vVar.x;
            this.w = vVar.y;
            this.x = vVar.z;
            this.y = vVar.A;
            this.z = vVar.B;
            this.A = vVar.C;
        }

        public a a(long j2, TimeUnit timeUnit) {
            this.x = c.a("timeout", j2, timeUnit);
            return this;
        }

        public a b(long j2, TimeUnit timeUnit) {
            this.y = c.a("timeout", j2, timeUnit);
            return this;
        }

        public a c(long j2, TimeUnit timeUnit) {
            this.z = c.a("timeout", j2, timeUnit);
            return this;
        }

        public a a(boolean z2) {
            this.u = z2;
            return this;
        }

        public a b(boolean z2) {
            this.v = z2;
            return this;
        }

        public v a() {
            return new v(this);
        }
    }
}
