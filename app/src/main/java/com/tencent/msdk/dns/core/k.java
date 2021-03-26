package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.f;
import java.util.Set;

/* compiled from: LookupHelper */
public final class k {
    public static <LookupExtra extends f.a> void a(f.b bVar, j<LookupExtra> jVar) {
        a(bVar, jVar, false);
    }

    public static <LookupExtra extends f.a> void a(f.b bVar, j<LookupExtra> jVar, boolean z) {
        if (bVar == null) {
            throw new IllegalArgumentException("session".concat(" can not be null"));
        } else if (jVar != null) {
            b.b("prepareNonBlockLookupTask call, forRetry:%b", Boolean.valueOf(z));
            if (bVar.h().c()) {
                b.b("prepareNonBlockLookupTask start receive", new Object[0]);
                String[] c = bVar.c();
                if (bVar.i().lookupSuccess() || bVar.i().lookupFailed()) {
                    f f = bVar.f();
                    if (!z) {
                        jVar.s().remove(bVar);
                    }
                    jVar.q().remove(f);
                    if (bVar.i().lookupSuccess()) {
                        jVar.m().a(f, c);
                        jVar.n().merge(f, bVar.i());
                    }
                }
            } else if (!z) {
                jVar.s().add(bVar);
            }
        } else {
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }
    }

    public static <LookupExtra extends f.a> void a(final f<LookupExtra> fVar, final j<LookupExtra> jVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("dns".concat(" can not be null"));
        } else if (jVar != null) {
            jVar.o().a(new Runnable() {
                /* class com.tencent.msdk.dns.core.k.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Set<f> q = jVar.q();
                    if (q.contains(fVar)) {
                        LookupResult a2 = fVar.a(jVar.a());
                        if (a2.stat.lookupSuccess() || a2.stat.lookupFailed()) {
                            q.remove(fVar);
                            if (a2.stat.lookupSuccess()) {
                                jVar.m().a(fVar, a2.ipSet.ips);
                                jVar.n().merge(fVar, a2.stat);
                            }
                        }
                    }
                }
            });
        } else {
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }
    }
}
