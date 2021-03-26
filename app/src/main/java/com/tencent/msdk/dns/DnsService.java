package com.tencent.msdk.dns;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.msdk.dns.DnsConfig;
import com.tencent.msdk.dns.base.c.d;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.base.log.ILogNode;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.base.report.IReporter;
import com.tencent.msdk.dns.base.report.c;
import com.tencent.msdk.dns.base.report.e;
import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.IpSet;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.a;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.g;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.stat.StatisticsMerge;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public final class DnsService {
    private static final String BUILT_IN_APP_ID = "0000066HQK3XVNGP";
    private static Context sAppContext;
    private static DnsConfig sConfig;
    private static volatile boolean sInited;

    public static void init(Context context, DnsConfig dnsConfig) {
        if (context != null) {
            if (dnsConfig == null) {
                dnsConfig = new DnsConfig.Builder().build();
            }
            b.a(dnsConfig.logLevel);
            addLogNodes(dnsConfig.logNodes);
            b.a("DnsService.init(%s, %s) called, ver:%s", context, dnsConfig, "3.3.0a");
            Context applicationContext = context.getApplicationContext();
            sAppContext = applicationContext;
            sConfig = dnsConfig;
            d.a(applicationContext);
            com.tencent.msdk.dns.base.b.b.a(applicationContext);
            e.a(1);
            if (dnsConfig.initBuiltInReporters) {
                e.a(1, new c(applicationContext, "0000066HQK3XVNGP"));
            }
            com.tencent.msdk.dns.a.b.a(dnsConfig);
            DnsExecutors.c = sConfig.executorSupplier;
            setLookedUpListener(dnsConfig.lookedUpListener);
            addReporters(dnsConfig.reporters);
            sInited = true;
            preLookupAndStartAsyncLookup();
            return;
        }
        throw new IllegalArgumentException("context".concat(" can not be null"));
    }

    public static synchronized void setUserId(String str) {
        synchronized (DnsService.class) {
            if (!sInited) {
                throw new IllegalStateException("DnsService".concat(" is not initialized yet"));
            } else if (!TextUtils.isEmpty(str)) {
                sConfig.userId = str;
            } else {
                throw new IllegalArgumentException("userId".concat(" can not be empty"));
            }
        }
    }

    public static String getDnsDetail(String str) {
        return ((StatisticsMerge) com.tencent.msdk.dns.core.d.a(new l.a().a(sAppContext).a(str).a(sConfig.timeoutMills).a((l.a) sConfig.lookupExtra).b(sConfig.channel).b(sConfig.token).a(true).b(sConfig.blockFirst).d(false).a()).stat).toJsonResult();
    }

    public static IpSet getAddrsByName(String str) {
        return getAddrsByName(str, sConfig.channel, sConfig.token, true, false);
    }

    public static IpSet getAddrsByName(String str, String str2) {
        return getAddrsByName(str, str2, sConfig.token, true, false);
    }

    public static IpSet getAddrsByName(String str, String str2, int i) {
        return getAddrsByName(str, sConfig.channel, i, true, false);
    }

    private static IpSet getAddrsByName(String str, String str2, int i, boolean z, boolean z2) {
        if (sInited) {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim)) {
                    if (com.tencent.msdk.dns.base.e.c.a(trim)) {
                        b.b("Hostname %s is an v4 ip, just return it", trim);
                        return new IpSet(new String[]{trim}, a.a);
                    } else if (com.tencent.msdk.dns.base.e.c.b(trim)) {
                        b.b("Hostname %s is an v6 ip, just return it", trim);
                        return new IpSet(a.a, new String[]{trim});
                    } else {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = sConfig.channel;
                        }
                        b.a("DnsService.getAddrsByName(%s, %s, %b, %b) called", trim, str2, Boolean.valueOf(z), Boolean.valueOf(z2));
                        if (sConfig.needProtect(trim)) {
                            LookupResult<IStatisticsMerge> c = com.tencent.msdk.dns.core.d.c(new l.a().a(sAppContext).a(trim).a(sConfig.timeoutMills).a((l.a) sConfig.lookupExtra).b(str2).b(i).a(z).b(sConfig.blockFirst).d(z2).a());
                            com.tencent.msdk.dns.a.b.a(c);
                            return c.ipSet;
                        } else if (!z) {
                            return IpSet.EMPTY;
                        } else {
                            b.b("Hostname %s is not in protected domain list, just lookup by LocalDns", trim);
                            return com.tencent.msdk.dns.core.d.c(new l.a().a(sAppContext).a(trim).a(sConfig.timeoutMills).a((l.a) f.a.a).b("Local").b(sConfig.token).a(false).b(sConfig.blockFirst).a()).ipSet;
                        }
                    }
                }
            }
            b.b("Hostname is empty", new Object[0]);
            return IpSet.EMPTY;
        }
        throw new IllegalStateException("DnsService".concat(" is not initialized yet"));
    }

    private static void setLookedUpListener(final ILookedUpListener iLookedUpListener) {
        b.a("DnsService.setLookedUpListener(%s) called", iLookedUpListener);
        if (iLookedUpListener != null) {
            com.tencent.msdk.dns.core.d.a(new g() {
                /* class com.tencent.msdk.dns.DnsService.AnonymousClass1 */

                @Override // com.tencent.msdk.dns.core.g
                public void a(l lVar, LookupResult<IStatisticsMerge> lookupResult) {
                    String str = lVar.b;
                    if (!(lookupResult.stat instanceof StatisticsMerge)) {
                        b.b("Looked up for %s may be by LocalDns", str);
                        return;
                    }
                    LookupResult<StatisticsMerge> lookupResult2 = new LookupResult<>(lookupResult.ipSet, (StatisticsMerge) lookupResult.stat);
                    if (!lVar.j) {
                        iLookedUpListener.onLookedUp(str, lookupResult2);
                    } else if (3 == lVar.i) {
                        iLookedUpListener.onPreLookedUp(str, lookupResult2);
                    } else {
                        iLookedUpListener.onAsyncLookedUp(str, lookupResult2);
                    }
                }
            });
        }
    }

    private static void addLogNodes(List<ILogNode> list) {
        b.a("DnsService.addLogNodes(%s) called", com.tencent.msdk.dns.base.e.a.b(list));
        if (list != null) {
            for (ILogNode iLogNode : list) {
                b.a(iLogNode);
            }
        }
    }

    private static void addReporters(List<IReporter> list) {
        b.a("DnsService.addReporters(%s) called", com.tencent.msdk.dns.base.e.a.b(list));
        if (list != null) {
            for (IReporter iReporter : list) {
                e.a(iReporter);
            }
        }
    }

    private static void preLookupAndStartAsyncLookup() {
        if (!com.tencent.msdk.dns.base.e.a.a((Collection<?>) sConfig.preLookupDomains)) {
            int size = sConfig.preLookupDomains.size();
            String[] strArr = (String[]) sConfig.preLookupDomains.toArray(new String[size]);
            if (sConfig.asyncLookupDomains != null) {
                Set<String> set = sConfig.asyncLookupDomains;
            } else {
                Collections.emptySet();
            }
            final LookupResult[] lookupResultArr = new LookupResult[size];
            final CountDownLatch countDownLatch = new CountDownLatch(size);
            for (final int i = 0; i < size; i++) {
                final String str = strArr[i];
                DnsExecutors.b.execute(new Runnable() {
                    /* class com.tencent.msdk.dns.DnsService.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        lookupResultArr[i] = com.tencent.msdk.dns.core.d.c(new l.a().a(DnsService.sAppContext).a(str).a(DnsService.sConfig.timeoutMills).a((l.a) DnsService.sConfig.lookupExtra).b(DnsService.sConfig.channel).b(DnsService.sConfig.token).a(false).b(DnsService.sConfig.blockFirst).c(true).d(DnsService.sConfig.asyncLookupDomains.contains(str)).a());
                        countDownLatch.countDown();
                    }
                });
            }
            DnsExecutors.b.execute(new Runnable() {
                /* class com.tencent.msdk.dns.DnsService.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        countDownLatch.await();
                        b.b("Await for pre lookup count down success", new Object[0]);
                    } catch (Exception e) {
                        b.c(e, "Await for pre lookup count down failed", new Object[0]);
                    }
                    com.tencent.msdk.dns.a.b.a(lookupResultArr);
                }
            });
        }
    }
}
