package com.tencent.msdk.dns.core;

import android.os.SystemClock;
import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.b;
import com.tencent.msdk.dns.core.c.a;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.local.LocalDns;
import com.tencent.msdk.dns.core.stat.StatisticsMerge;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: DnsManager */
public final class d {
    private static final Map<String, a> a = com.tencent.msdk.dns.base.a.a.a();
    private static final Map<l, b> b = new ConcurrentHashMap();
    private static i.a c = new a.C0149a();
    private static h d = new com.tencent.msdk.dns.core.b.a();
    private static IStatisticsMerge.a e = new com.tencent.msdk.dns.core.stat.a();
    private static volatile g f = null;

    static {
        a(new LocalDns());
        a(new com.tencent.msdk.dns.core.rest.c.b(1));
        a(new com.tencent.msdk.dns.core.rest.c.b(2));
        a(new com.tencent.msdk.dns.core.rest.b.b(1));
        a(new com.tencent.msdk.dns.core.rest.b.b(2));
        a(new com.tencent.msdk.dns.core.rest.a.b(1));
        a(new com.tencent.msdk.dns.core.rest.a.b(2));
    }

    public static synchronized void a(f fVar) {
        a aVar;
        synchronized (d.class) {
            if (fVar != null) {
                String str = fVar.a().a;
                Map<String, a> map = a;
                if (map.containsKey(str)) {
                    aVar = map.get(str);
                } else {
                    a aVar2 = new a();
                    map.put(str, aVar2);
                    aVar = aVar2;
                }
                int i = fVar.a().b;
                if (i == 1) {
                    aVar.b = fVar;
                } else if (i == 2) {
                    aVar.c = fVar;
                } else if (i == 3) {
                    aVar.a = fVar;
                }
            } else {
                throw new IllegalArgumentException("dns".concat(" can not be null"));
            }
        }
    }

    public static void a(g gVar) {
        f = gVar;
    }

    public static <LookupExtra extends f.a> LookupResult<IStatisticsMerge> a(l<LookupExtra> lVar) {
        a aVar = a.get(lVar.e);
        if (aVar == null) {
            return new LookupResult<>(IpSet.EMPTY, new StatisticsMerge(lVar.a));
        }
        LookupExtra lookupextra = lVar.d;
        j a2 = j.a(lVar);
        a2.a(com.tencent.msdk.dns.base.e.d.a());
        i a3 = c.a(a2.l());
        a2.a(a3);
        IStatisticsMerge<LookupExtra> a4 = e.a(lookupextra.getClass(), lVar.a);
        a2.a(a4);
        LookupResult b2 = aVar.b.b(lVar);
        if (b2.stat.lookupSuccess()) {
            com.tencent.msdk.dns.base.log.b.b("getResultFromCache by ipv4:" + Arrays.toString(b2.ipSet.ips), new Object[0]);
            a2.m().a(aVar.b, b2.ipSet.ips);
            a2.n().merge(aVar.b, b2.stat);
        }
        LookupResult b3 = aVar.c.b(lVar);
        if (b3.stat.lookupSuccess()) {
            com.tencent.msdk.dns.base.log.b.b("getResultFromCache by ipv6:" + Arrays.toString(b3.ipSet.ips), new Object[0]);
            a2.m().a(aVar.c, b3.ipSet.ips);
            a2.n().merge(aVar.c, b3.stat);
        }
        if (!b2.stat.lookupSuccess() && !b3.stat.lookupSuccess()) {
            return new LookupResult<>(IpSet.EMPTY, new StatisticsMerge(lVar.a));
        }
        IpSet a5 = a3.a();
        a4.statResult(a5);
        LookupResult<IStatisticsMerge> lookupResult = new LookupResult<>(a5, a4);
        com.tencent.msdk.dns.base.log.b.b("getResultFromCache by httpdns cache:" + lookupResult.ipSet + "; " + lookupResult.stat, new Object[0]);
        return lookupResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x03a8 A[SYNTHETIC, Splitter:B:145:0x03a8] */
    public static <LookupExtra extends f.a> LookupResult<IStatisticsMerge> b(l<LookupExtra> lVar) {
        CountDownLatch countDownLatch;
        String str;
        String str2;
        Throwable th;
        Selector p;
        int i;
        b.c cVar;
        c cVar2;
        CountDownLatch countDownLatch2;
        int i2;
        String str3;
        if (lVar != null) {
            com.tencent.msdk.dns.base.log.b.a("DnsManager.lookup(%s) called", lVar);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map<l, b> map = b;
            b bVar = map.get(lVar);
            if (bVar != null) {
                com.tencent.msdk.dns.base.log.b.b("The same lookup task(for %s) is running, just wait for it", lVar);
                try {
                    if (bVar.a.await((long) (((float) lVar.c) * 1.2f), TimeUnit.MILLISECONDS)) {
                        return bVar.b.a;
                    }
                    com.tencent.msdk.dns.base.log.b.b("Await for running lookup for %s timeout", lVar);
                    return new LookupResult<>(IpSet.EMPTY, new StatisticsMerge(lVar.a));
                } catch (Exception e2) {
                    com.tencent.msdk.dns.base.log.b.c(e2, "Await for running lookup for %s failed", lVar);
                    int elapsedRealtime2 = (int) (((long) lVar.c) - (SystemClock.elapsedRealtime() - elapsedRealtime));
                    if (elapsedRealtime2 > 0) {
                        return b(new l.a(lVar).a(elapsedRealtime2).a());
                    }
                    return new LookupResult<>(IpSet.EMPTY, new StatisticsMerge(lVar.a));
                }
            } else {
                CountDownLatch countDownLatch3 = new CountDownLatch(1);
                a aVar = null;
                c cVar3 = new c();
                map.put(lVar, new b(countDownLatch3, cVar3));
                int i3 = lVar.c;
                LookupExtra lookupextra = lVar.d;
                String str4 = lVar.e;
                boolean z = lVar.g;
                j<LookupExtra> a2 = j.a(lVar);
                a aVar2 = z ? a.get("Local") : null;
                if ("Local".equals(str4)) {
                    aVar2 = a.get("Local");
                } else {
                    aVar = a.get(str4);
                }
                a2.a(com.tencent.msdk.dns.base.e.d.a());
                i a3 = c.a(a2.l());
                a2.a(a3);
                h hVar = d;
                IStatisticsMerge<LookupExtra> a4 = e.a(lookupextra.getClass(), lVar.a);
                a2.a(a4);
                b.c a5 = b.a();
                a2.a(a5);
                Set<f> synchronizedSet = Collections.synchronizedSet(com.tencent.msdk.dns.base.a.a.b());
                a2.a(synchronizedSet);
                ArrayList arrayList = new ArrayList();
                a2.a(arrayList);
                String str5 = "FINALLY statMerge: %s";
                if (aVar != null) {
                    cVar = a5;
                    try {
                        LookupResult<IStatisticsMerge> a6 = a(lVar);
                        i = i3;
                        if (((IStatisticsMerge) a6.stat).lookupSuccess()) {
                            cVar3.a = a6;
                            com.tencent.msdk.dns.base.log.b.b("DnsManager lookup getResultFromCache success", new Object[0]);
                            c(a2);
                            countDownLatch3.countDown();
                            map.remove(lVar);
                            a4.statContext(a2);
                            com.tencent.msdk.dns.base.log.b.b(str5, a4.toJsonResult());
                            d(a2);
                            synchronizedSet.clear();
                            Selector p2 = a2.p();
                            if (p2 != null) {
                                try {
                                    p2.close();
                                    com.tencent.msdk.dns.base.log.b.b("%s closed", p2);
                                } catch (IOException unused) {
                                }
                            }
                            return a6;
                        }
                        a(aVar, a2);
                        if (!a2.r() && aVar2 != null) {
                            a(aVar2, a2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = "%s closed";
                        countDownLatch = countDownLatch3;
                        str = str5;
                        c(a2);
                        countDownLatch.countDown();
                        b.remove(lVar);
                        a4.statContext(a2);
                        com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                        d(a2);
                        synchronizedSet.clear();
                        p = a2.p();
                        if (p != null) {
                        }
                        throw th;
                    }
                } else {
                    i = i3;
                    cVar = a5;
                    if (aVar2 != null) {
                        a(aVar2, a2);
                    }
                }
                int a7 = hVar.a();
                int elapsedRealtime3 = i - ((int) (SystemClock.elapsedRealtime() - elapsedRealtime));
                if (a7 > 0) {
                    elapsedRealtime3 /= a7 + 1;
                }
                CountDownLatch a8 = cVar.a();
                a2.a(a8);
                Selector p3 = a2.p();
                if (p3 == null) {
                    try {
                        com.tencent.msdk.dns.base.log.b.b("selector is null", new Object[0]);
                        int i4 = 0;
                        while (true) {
                            if (synchronizedSet.isEmpty()) {
                                str3 = str5;
                                break;
                            }
                            try {
                                str3 = str5;
                                if (SystemClock.elapsedRealtime() - elapsedRealtime < ((long) i)) {
                                    try {
                                        a8.await((long) elapsedRealtime3, TimeUnit.MILLISECONDS);
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        if (!synchronizedSet.isEmpty() && a(elapsedRealtime, i, a7, i4)) {
                                            i4++;
                                            hVar.b(a2.b(new l.a(lVar).a(i - ((int) (SystemClock.elapsedRealtime() - elapsedRealtime))).d(i4).a()));
                                        }
                                        str5 = str3;
                                        elapsedRealtime3 = elapsedRealtime3;
                                        i = i;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        countDownLatch = countDownLatch3;
                                        str2 = "%s closed";
                                        str = str3;
                                        c(a2);
                                        countDownLatch.countDown();
                                        b.remove(lVar);
                                        a4.statContext(a2);
                                        com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                                        d(a2);
                                        synchronizedSet.clear();
                                        p = a2.p();
                                        if (p != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                countDownLatch = countDownLatch3;
                                str = str5;
                                str2 = "%s closed";
                                c(a2);
                                countDownLatch.countDown();
                                b.remove(lVar);
                                a4.statContext(a2);
                                com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                                d(a2);
                                synchronizedSet.clear();
                                p = a2.p();
                                if (p != null) {
                                }
                                throw th;
                            }
                        }
                        try {
                            IpSet a9 = a3.a();
                            a4.statResult(a9);
                            LookupResult<IStatisticsMerge> lookupResult = new LookupResult<>(a9, a4);
                            cVar3.a = lookupResult;
                            c(a2);
                            countDownLatch3.countDown();
                            b.remove(lVar);
                            a4.statContext(a2);
                            com.tencent.msdk.dns.base.log.b.b(str3, a4.toJsonResult());
                            d(a2);
                            synchronizedSet.clear();
                            Selector p4 = a2.p();
                            if (p4 != null) {
                                try {
                                    p4.close();
                                    com.tencent.msdk.dns.base.log.b.b("%s closed", p4);
                                } catch (IOException unused3) {
                                }
                            }
                            return lookupResult;
                        } catch (Throwable th5) {
                            th = th5;
                            str = str3;
                            countDownLatch = countDownLatch3;
                            str2 = "%s closed";
                            c(a2);
                            countDownLatch.countDown();
                            b.remove(lVar);
                            a4.statContext(a2);
                            com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                            d(a2);
                            synchronizedSet.clear();
                            p = a2.p();
                            if (p != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str = str5;
                        countDownLatch = countDownLatch3;
                        str2 = "%s closed";
                        c(a2);
                        countDownLatch.countDown();
                        b.remove(lVar);
                        a4.statContext(a2);
                        com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                        d(a2);
                        synchronizedSet.clear();
                        p = a2.p();
                        if (p != null) {
                        }
                        throw th;
                    }
                } else {
                    int i5 = elapsedRealtime3;
                    str = str5;
                    String str6 = "%s closed";
                    int i6 = 0;
                    while (true) {
                        try {
                            if (arrayList.isEmpty()) {
                                countDownLatch = countDownLatch3;
                                cVar2 = cVar3;
                                break;
                            }
                            try {
                                countDownLatch = countDownLatch3;
                                cVar2 = cVar3;
                                if (SystemClock.elapsedRealtime() - elapsedRealtime >= ((long) i)) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10);
                                } catch (Exception unused4) {
                                }
                                try {
                                    com.tencent.msdk.dns.base.log.b.b("sessions is not empty, wait for sessions:%d, mills:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(i5));
                                    i2 = i5;
                                    countDownLatch2 = a8;
                                    try {
                                        p3.select((long) i2);
                                    } catch (Exception unused5) {
                                    }
                                } catch (Exception unused6) {
                                    i2 = i5;
                                    countDownLatch2 = a8;
                                }
                                b(a2);
                                if (!arrayList.isEmpty() && a(elapsedRealtime, i, a7, i6)) {
                                    com.tencent.msdk.dns.base.log.b.b("sessions is not empty, sessions:%d, enter retry", Integer.valueOf(arrayList.size()));
                                    i6++;
                                    hVar.a(a2.b(new l.a(lVar).d(i6).a()));
                                }
                                cVar3 = cVar2;
                                str6 = str6;
                                a8 = countDownLatch2;
                                i5 = i2;
                                countDownLatch3 = countDownLatch;
                            } catch (Throwable th7) {
                                th = th7;
                                str2 = str6;
                                c(a2);
                                countDownLatch.countDown();
                                b.remove(lVar);
                                a4.statContext(a2);
                                com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                                d(a2);
                                synchronizedSet.clear();
                                p = a2.p();
                                if (p != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            countDownLatch = countDownLatch3;
                            str2 = str6;
                            c(a2);
                            countDownLatch.countDown();
                            b.remove(lVar);
                            a4.statContext(a2);
                            com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                            d(a2);
                            synchronizedSet.clear();
                            p = a2.p();
                            if (p != null) {
                            }
                            throw th;
                        }
                    }
                    int elapsedRealtime4 = i - ((int) (SystemClock.elapsedRealtime() - elapsedRealtime));
                    try {
                        if (arrayList.size() > 0) {
                            com.tencent.msdk.dns.base.log.b.b("selector wait for last timeout if sessions is not empty, sessions:%d, mills:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(i5));
                        }
                        a8.await((long) elapsedRealtime4, TimeUnit.MILLISECONDS);
                    } catch (Exception unused7) {
                    }
                    IpSet a10 = a3.a();
                    a4.statResult(a10);
                    LookupResult<IStatisticsMerge> lookupResult2 = new LookupResult<>(a10, a4);
                    cVar2.a = lookupResult2;
                    c(a2);
                    countDownLatch.countDown();
                    b.remove(lVar);
                    a4.statContext(a2);
                    com.tencent.msdk.dns.base.log.b.b(str, a4.toJsonResult());
                    d(a2);
                    synchronizedSet.clear();
                    Selector p5 = a2.p();
                    if (p5 != null) {
                        try {
                            p5.close();
                            com.tencent.msdk.dns.base.log.b.b(str6, p5);
                        } catch (IOException unused8) {
                        }
                    }
                    return lookupResult2;
                }
            }
        } else {
            throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
        }
    }

    public static <LookupExtra extends f.a> LookupResult<IStatisticsMerge> c(l<LookupExtra> lVar) {
        LookupResult<IStatisticsMerge> b2 = b(lVar);
        com.tencent.msdk.dns.base.log.b.b("LookupResult %s", b2.ipSet);
        if (f != null) {
            f.a(lVar, b2);
        }
        return b2;
    }

    private static <LookupExtra extends f.a> void a(a aVar, j<LookupExtra> jVar) {
        int l = jVar.l();
        int g = jVar.g();
        boolean h = jVar.h();
        if (aVar.c != null || aVar.b != null) {
            if (!(aVar.c == null || (g & 2) == 0 || (!h && (l & 2) == 0))) {
                a(aVar.c, jVar);
            }
            if (aVar.b != null && (g & 1) != 0) {
                if (h || (l & 1) != 0) {
                    a(aVar.b, jVar);
                }
            }
        } else if (aVar.a == null) {
        } else {
            if (h || (l & 3) != 0) {
                a(aVar.a, jVar);
            }
        }
    }

    private static <LookupExtra extends f.a> void a(f<LookupExtra> fVar, j<LookupExtra> jVar) {
        f.b a2;
        com.tencent.msdk.dns.base.log.b.b("prepareTask:" + fVar, new Object[0]);
        jVar.q().add(fVar);
        if (jVar.f() || "Local".equals(fVar.a().a)) {
            k.a(fVar, jVar);
        } else if ((jVar.p() != null || a(jVar)) && (a2 = fVar.a(jVar)) != null) {
            k.a(a2, jVar);
        } else {
            k.a(fVar, jVar);
        }
    }

    private static boolean a(j jVar) {
        try {
            Selector open = Selector.open();
            jVar.a(open);
            com.tencent.msdk.dns.base.log.b.b("%s opened", open);
            return true;
        } catch (Exception e2) {
            com.tencent.msdk.dns.base.log.b.b(e2, "Open selector failed", new Object[0]);
            return false;
        }
    }

    private static <LookupExtra extends f.a> void b(j<LookupExtra> jVar) {
        Iterator<f.b> it2 = jVar.s().iterator();
        while (it2.hasNext()) {
            f.b next = it2.next();
            if (!next.g()) {
                f.b.a h = next.h();
                if (h.c()) {
                    com.tencent.msdk.dns.base.log.b.b("%s event readable", next.f().a());
                    String[] c2 = next.c();
                    if (next.i().lookupSuccess() || next.i().lookupFailed()) {
                        f f2 = next.f();
                        it2.remove();
                        jVar.q().remove(f2);
                        if (next.i().lookupSuccess()) {
                            jVar.m().a(f2, c2);
                            jVar.n().merge(f2, next.i());
                        }
                    }
                } else if (h.d()) {
                    com.tencent.msdk.dns.base.log.b.b("%s event writable", next.f().a());
                    next.b();
                } else {
                    if (h.a()) {
                        com.tencent.msdk.dns.base.log.b.b("%s event connectable", next.f().a());
                        next.a();
                    }
                    com.tencent.msdk.dns.base.log.b.b("%s event finishConnect:%b", next.f().a(), Boolean.valueOf(h.b()));
                }
                if (!h.e()) {
                    com.tencent.msdk.dns.base.log.b.b("%s event not available, maybe closed", next.f().a());
                    f f3 = next.f();
                    it2.remove();
                    jVar.q().remove(f3);
                }
            }
        }
    }

    private static boolean a(long j, int i, int i2, int i3) {
        return i3 < i2 && ((int) (SystemClock.elapsedRealtime() - j)) > (i * (i3 + 1)) / (i2 + 1);
    }

    private static <LookupExtra extends f.a> void c(j<LookupExtra> jVar) {
        for (f.b bVar : jVar.s()) {
            bVar.d();
            jVar.n().merge(bVar.f(), bVar.i());
        }
    }

    private static void d(j jVar) {
        Iterator<f.b> it2 = jVar.s().iterator();
        while (it2.hasNext()) {
            if (it2.next().g()) {
                it2.remove();
            }
        }
    }

    /* compiled from: DnsManager */
    private static class a {
        f a;
        f b;
        f c;

        private a() {
        }
    }

    /* compiled from: DnsManager */
    private static class c {
        LookupResult<IStatisticsMerge> a;

        private c() {
            this.a = null;
        }
    }

    /* compiled from: DnsManager */
    private static class b {
        final CountDownLatch a;
        final c b;

        public b(CountDownLatch countDownLatch, c cVar) {
            if (countDownLatch == null) {
                throw new IllegalArgumentException("lookupLatch".concat(" can not be null"));
            } else if (cVar != null) {
                this.a = countDownLatch;
                this.b = cVar;
            } else {
                throw new IllegalArgumentException("lookupResultHolder".concat(" can not be null"));
            }
        }
    }
}
