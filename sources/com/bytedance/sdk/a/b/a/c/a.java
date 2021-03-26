package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.d;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.l;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.util.List;

/* compiled from: BridgeInterceptor */
public final class a implements t {
    private final m a;

    public a(m mVar) {
        this.a = mVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        y a2 = aVar.a();
        y.a e = a2.e();
        z d = a2.d();
        if (d != null) {
            u a3 = d.a();
            if (a3 != null) {
                e.a("Content-Type", a3.toString());
            }
            long b = d.b();
            if (b != -1) {
                e.a("Content-Length", Long.toString(b));
                e.b("Transfer-Encoding");
            } else {
                e.a("Transfer-Encoding", "chunked");
                e.b("Content-Length");
            }
        }
        boolean z = false;
        if (a2.a("Host") == null) {
            e.a("Host", c.a(a2.a(), false));
        }
        if (a2.a("Connection") == null) {
            e.a("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
            z = true;
            e.a("Accept-Encoding", "gzip");
        }
        List<l> a4 = this.a.a(a2.a());
        if (!a4.isEmpty()) {
            e.a("Cookie", a(a4));
        }
        if (a2.a("User-Agent") == null) {
            e.a("User-Agent", d.a());
        }
        aa a5 = aVar.a(e.d());
        e.a(this.a, a2.a(), a5.g());
        aa.a a6 = a5.i().a(a2);
        if (z && "gzip".equalsIgnoreCase(a5.a("Content-Encoding")) && e.b(a5)) {
            j jVar = new j(a5.h().d());
            a6.a(a5.g().c().b("Content-Encoding").b("Content-Length").a());
            a6.a(new h(a5.a("Content-Type"), -1, com.bytedance.sdk.a.a.l.a(jVar)));
        }
        return a6.a();
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
