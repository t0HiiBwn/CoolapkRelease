package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: CallServerInterceptor */
public final class b implements t {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        aa aaVar;
        g gVar = (g) aVar;
        c g = gVar.g();
        g f = gVar.f();
        c cVar = (c) gVar.e();
        y a2 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        g.a(a2);
        gVar.i().a(gVar.h(), a2);
        aa.a aVar2 = null;
        if (f.c(a2.b()) && a2.d() != null) {
            if ("100-continue".equalsIgnoreCase(a2.a("Expect"))) {
                g.a();
                gVar.i().e(gVar.h());
                aVar2 = g.a(true);
            }
            if (aVar2 == null) {
                gVar.i().d(gVar.h());
                a aVar3 = new a(g.a(a2, a2.d().b()));
                d a3 = l.a(aVar3);
                a2.d().a(a3);
                a3.close();
                gVar.i().a(gVar.h(), aVar3.a);
            } else if (!cVar.d()) {
                f.d();
            }
        }
        g.b();
        if (aVar2 == null) {
            gVar.i().e(gVar.h());
            aVar2 = g.a(false);
        }
        aa a4 = aVar2.a(a2).a(f.b().c()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        gVar.i().a(gVar.h(), a4);
        int c = a4.c();
        if (!this.a || c != 101) {
            aaVar = a4.i().a(g.a(a4)).a();
        } else {
            aaVar = a4.i().a(com.bytedance.sdk.a.b.a.c.c).a();
        }
        if ("close".equalsIgnoreCase(aaVar.a().a("Connection")) || "close".equalsIgnoreCase(aaVar.a("Connection"))) {
            f.d();
        }
        if ((c != 204 && c != 205) || aaVar.h().b() <= 0) {
            return aaVar;
        }
        throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + aaVar.h().b());
    }

    /* compiled from: CallServerInterceptor */
    static final class a extends com.bytedance.sdk.a.a.g {
        long a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a_(cVar, j);
            this.a += j;
        }
    }
}
