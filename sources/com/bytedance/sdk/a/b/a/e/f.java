package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.c;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.i;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec */
public final class f implements c {
    private static final com.bytedance.sdk.a.a.f b;
    private static final com.bytedance.sdk.a.a.f c;
    private static final com.bytedance.sdk.a.a.f d;
    private static final com.bytedance.sdk.a.a.f e;
    private static final com.bytedance.sdk.a.a.f f;
    private static final com.bytedance.sdk.a.a.f g;
    private static final com.bytedance.sdk.a.a.f h;
    private static final com.bytedance.sdk.a.a.f i;
    private static final List<com.bytedance.sdk.a.a.f> j;
    private static final List<com.bytedance.sdk.a.a.f> k;
    final g a;
    private final v l;
    private final t.a m;
    private final g n;
    private i o;

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a("connection");
        b = a2;
        com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a("host");
        c = a3;
        com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a("keep-alive");
        d = a4;
        com.bytedance.sdk.a.a.f a5 = com.bytedance.sdk.a.a.f.a("proxy-connection");
        e = a5;
        com.bytedance.sdk.a.a.f a6 = com.bytedance.sdk.a.a.f.a("transfer-encoding");
        f = a6;
        com.bytedance.sdk.a.a.f a7 = com.bytedance.sdk.a.a.f.a("te");
        g = a7;
        com.bytedance.sdk.a.a.f a8 = com.bytedance.sdk.a.a.f.a("encoding");
        h = a8;
        com.bytedance.sdk.a.a.f a9 = com.bytedance.sdk.a.a.f.a("upgrade");
        i = a9;
        j = com.bytedance.sdk.a.b.a.c.a(a2, a3, a4, a5, a7, a6, a8, a9, c.c, c.d, c.e, c.f);
        k = com.bytedance.sdk.a.b.a.c.a(a2, a3, a4, a5, a7, a6, a8, a9);
    }

    public f(v vVar, t.a aVar, g gVar, g gVar2) {
        this.l = vVar;
        this.m = aVar;
        this.a = gVar;
        this.n = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j2) {
        return this.o.h();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        if (this.o == null) {
            i a2 = this.n.a(b(yVar), yVar.d() != null);
            this.o = a2;
            a2.e().a((long) this.m.c(), TimeUnit.MILLISECONDS);
            this.o.f().a((long) this.m.d(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.n.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.o.h().close();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        aa.a a2 = a(this.o.d());
        if (!z || com.bytedance.sdk.a.b.a.a.a.a(a2) != 100) {
            return a2;
        }
        return null;
    }

    public static List<c> b(y yVar) {
        com.bytedance.sdk.a.b.r c2 = yVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new c(c.c, yVar.b()));
        arrayList.add(new c(c.d, i.a(yVar.a())));
        String a2 = yVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.f, a2));
        }
        arrayList.add(new c(c.e, yVar.a().b()));
        int a3 = c2.a();
        for (int i2 = 0; i2 < a3; i2++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(c2.a(i2).toLowerCase(Locale.US));
            if (!j.contains(a4)) {
                arrayList.add(new c(a4, c2.b(i2)));
            }
        }
        return arrayList;
    }

    public static aa.a a(List<c> list) throws IOException {
        r.a aVar = new r.a();
        int size = list.size();
        k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                com.bytedance.sdk.a.a.f fVar = cVar.g;
                String a2 = cVar.h.a();
                if (fVar.equals(c.b)) {
                    kVar = k.a("HTTP/1.1 " + a2);
                } else if (!k.contains(fVar)) {
                    com.bytedance.sdk.a.b.a.a.a.a(aVar, fVar.a(), a2);
                }
            } else if (kVar != null && kVar.b == 100) {
                aVar = new r.a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new aa.a().a(w.HTTP_2).a(kVar.b).a(kVar.c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        this.a.c.f(this.a.b);
        return new h(aaVar.a("Content-Type"), e.a(aaVar), l.a(new a(this.o.g())));
    }

    /* compiled from: Http2Codec */
    class a extends com.bytedance.sdk.a.a.h {
        boolean a = false;
        long b = 0;

        a(s sVar) {
            super(sVar);
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = b().a(cVar, j);
                if (a2 > 0) {
                    this.b += a2;
                }
                return a2;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (!this.a) {
                this.a = true;
                f.this.a.a(false, (c) f.this, this.b, iOException);
            }
        }
    }
}
