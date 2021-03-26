package com.tencent.msdk.dns.core.b;

import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.h;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.k;
import java.util.List;
import java.util.Set;

/* compiled from: Retry */
public final class a implements h {
    @Override // com.tencent.msdk.dns.core.h
    public int a() {
        return 1;
    }

    @Override // com.tencent.msdk.dns.core.h
    public void a(j jVar) {
        if (jVar != null) {
            List<f.b> s = jVar.s();
            b.b("Retry lookup for %s(%d) nonBlock session:%d  start", jVar.b(), Integer.valueOf(jVar.g()), Integer.valueOf(s.size()));
            for (f.b bVar : s) {
                if ("Udp".equals(bVar.f().a().a)) {
                    k.a(bVar.e(), jVar, true);
                }
            }
            b.b("Retry lookup for %s(%d) nonBlock session:%d finish.", jVar.b(), Integer.valueOf(jVar.g()), Integer.valueOf(s.size()));
            return;
        }
        throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.h
    public <LookupExtra extends f.a> void b(j<LookupExtra> jVar) {
        if (jVar != null) {
            b.b("Retry lookup for %s(%d) block", jVar.b(), Integer.valueOf(jVar.g()));
            Set<f> q = jVar.q();
            synchronized (q) {
                for (f fVar : q) {
                    if ("Udp".equals(fVar.a().a)) {
                        k.a(fVar, jVar);
                    }
                }
            }
            jVar.o().a();
            return;
        }
        throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
    }
}
