package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.c.c;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.e;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.rest.share.AbsRestDns;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CacheHelper */
public final class d {
    private final List<Runnable> a = new Vector();
    private final Map<String, a> b = new ConcurrentHashMap();
    private final Set<l<g>> c = Collections.synchronizedSet(com.tencent.msdk.dns.base.a.a.b());
    private final f<g> d;
    private final e e;

    d(f<g> fVar, e eVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("dns".concat(" can not be null"));
        } else if (eVar != null) {
            this.d = fVar;
            this.e = eVar;
            a();
        } else {
            throw new IllegalArgumentException("cache".concat(" can not be null"));
        }
    }

    public LookupResult a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.e.a(str);
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    public void a(final l<g> lVar, com.tencent.msdk.dns.core.rest.share.a.a aVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
        } else if (aVar == null) {
            throw new IllegalArgumentException("rsp".concat(" can not be null"));
        } else if (com.tencent.msdk.dns.core.rest.share.a.a.a != aVar) {
            final String str = lVar.b;
            AbsRestDns.Statistics statistics = new AbsRestDns.Statistics(aVar.d, aVar.c, aVar.e);
            statistics.errorCode = 0;
            this.e.a(str, new LookupResult(aVar.d, statistics));
            a aVar2 = this.b.get(str);
            if (aVar2 != null) {
                if (aVar2.a != null) {
                    DnsExecutors.a.a(aVar2.a);
                    aVar2.a = null;
                }
                if (aVar2.b != null) {
                    DnsExecutors.a.a(aVar2.b);
                    aVar2.b = null;
                }
            } else {
                aVar2 = new a();
            }
            final AnonymousClass1 r6 = new Runnable() {
                /* class com.tencent.msdk.dns.core.rest.share.d.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    b.b("Cache of %s(%d) expired", str, Integer.valueOf(d.this.d.a().b));
                    d.this.e.b(str);
                    d.this.a.remove(this);
                }
            };
            aVar2.a = r6;
            this.a.add(r6);
            DnsExecutors.a.a(r6, (long) (aVar.e * 1000));
            if (lVar.k) {
                int i = lVar.i;
                final int i2 = this.d.a().b;
                if (lVar.g || i != i2 || lVar.m) {
                    lVar = new l.a(lVar).a(false).c(i2).e(false).a();
                }
                this.c.add(lVar);
                AnonymousClass2 r9 = new Runnable() {
                    /* class com.tencent.msdk.dns.core.rest.share.d.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        b.b("%.2f of TTL goes by, lookup for %s(%d) async", Float.valueOf(0.75f), str, Integer.valueOf(i2));
                        DnsExecutors.b.execute(new Runnable() {
                            /* class com.tencent.msdk.dns.core.rest.share.d.AnonymousClass2.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                LookupResult<IStatisticsMerge> c = com.tencent.msdk.dns.core.d.c(lVar);
                                c.a(c);
                                if (c.stat.lookupSuccess() || c.stat.lookupFailed()) {
                                    DnsExecutors.a.a(r6);
                                    d.this.a.remove(r6);
                                }
                            }
                        });
                        d.this.a.remove(this);
                    }
                };
                aVar2.b = r9;
                this.a.add(r9);
                DnsExecutors.a.a(r9, (long) (((float) aVar.e) * 0.75f * 1000.0f));
            }
            if (!this.b.containsKey(str)) {
                this.b.put(str, aVar2);
            }
        }
    }

    private void a() {
        com.tencent.msdk.dns.base.c.d.a(new c() {
            /* class com.tencent.msdk.dns.core.rest.share.d.AnonymousClass3 */

            @Override // com.tencent.msdk.dns.base.c.c
            public void a() {
                b.b("Network changed, clear caches", new Object[0]);
                d.this.e.a();
                synchronized (d.this.a) {
                    for (Runnable runnable : d.this.a) {
                        DnsExecutors.a.a(runnable);
                    }
                }
                synchronized (d.this.c) {
                    b.b("Network changed, enable async lookup", new Object[0]);
                    Iterator it2 = d.this.c.iterator();
                    while (it2.hasNext()) {
                        l lVar = (l) it2.next();
                        b.b("Async lookup for %s start", lVar.b);
                        final l a2 = new l.a(lVar).e(true).a();
                        DnsExecutors.b.execute(new Runnable() {
                            /* class com.tencent.msdk.dns.core.rest.share.d.AnonymousClass3.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                c.a(com.tencent.msdk.dns.core.d.c(a2));
                            }
                        });
                        it2.remove();
                    }
                }
            }
        });
    }

    /* compiled from: CacheHelper */
    private static class a {
        public Runnable a;
        public Runnable b;

        private a() {
        }
    }
}
