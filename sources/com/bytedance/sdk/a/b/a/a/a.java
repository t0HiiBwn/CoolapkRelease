package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.a.c;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.a.c.f;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor */
public final class a implements t {
    final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        e eVar = this.a;
        aa a2 = eVar != null ? eVar.a(aVar.a()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
        y yVar = a3.a;
        aa aaVar = a3.b;
        e eVar2 = this.a;
        if (eVar2 != null) {
            eVar2.a(a3);
        }
        if (a2 != null && aaVar == null) {
            com.bytedance.sdk.a.b.a.c.a(a2.h());
        }
        if (yVar == null && aaVar == null) {
            return new aa.a().a(aVar.a()).a(w.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (yVar == null) {
            return aaVar.i().b(a(aaVar)).a();
        }
        try {
            aa a4 = aVar.a(yVar);
            if (a4 == null && a2 != null) {
            }
            if (aaVar != null) {
                if (a4.c() == 304) {
                    aa a5 = aaVar.i().a(a(aaVar.g(), a4.g())).a(a4.l()).b(a4.m()).b(a(aaVar)).a(a(a4)).a();
                    a4.h().close();
                    this.a.a();
                    this.a.a(aaVar, a5);
                    return a5;
                }
                com.bytedance.sdk.a.b.a.c.a(aaVar.h());
            }
            aa a6 = a4.i().b(a(aaVar)).a(a(a4)).a();
            if (this.a != null) {
                if (e.b(a6) && c.a(a6, yVar)) {
                    return a(this.a.a(a6), a6);
                }
                if (f.a(yVar.b())) {
                    try {
                        this.a.b(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a6;
        } finally {
            if (a2 != null) {
                com.bytedance.sdk.a.b.a.c.a(a2.h());
            }
        }
    }

    private static aa a(aa aaVar) {
        return (aaVar == null || aaVar.h() == null) ? aaVar : aaVar.i().a((ab) null).a();
    }

    private aa a(final b bVar, aa aaVar) throws IOException {
        r a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return aaVar;
        }
        final com.bytedance.sdk.a.a.e d = aaVar.h().d();
        final d a3 = l.a(a2);
        return aaVar.i().a(new h(aaVar.a("Content-Type"), aaVar.h().b(), l.a(new s() {
            /* class com.bytedance.sdk.a.b.a.a.a.AnonymousClass1 */
            boolean a;

            @Override // com.bytedance.sdk.a.a.s
            public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                try {
                    long a2 = d.a(cVar, j);
                    if (a2 == -1) {
                        if (!this.a) {
                            this.a = true;
                            a3.close();
                        }
                        return -1;
                    }
                    cVar.a(a3.c(), cVar.b() - a2, a2);
                    a3.u();
                    return a2;
                } catch (IOException e2) {
                    if (!this.a) {
                        this.a = true;
                        bVar.b();
                    }
                    throw e2;
                }
            }

            @Override // com.bytedance.sdk.a.a.s
            public com.bytedance.sdk.a.a.t a() {
                return d.a();
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.a = true;
                    bVar.b();
                }
                d.close();
            }
        }))).a();
    }

    private static com.bytedance.sdk.a.b.r a(com.bytedance.sdk.a.b.r rVar, com.bytedance.sdk.a.b.r rVar2) {
        r.a aVar = new r.a();
        int a2 = rVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = rVar.a(i);
            String b = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b.startsWith("1")) && (!a(a3) || rVar2.a(a3) == null)) {
                com.bytedance.sdk.a.b.a.a.a.a(aVar, a3, b);
            }
        }
        int a4 = rVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = rVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.a.a(aVar, a5, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }
}
