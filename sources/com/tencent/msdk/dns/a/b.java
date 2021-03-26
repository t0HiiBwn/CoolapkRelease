package com.tencent.msdk.dns.a;

import android.app.Activity;
import com.tencent.msdk.dns.DnsConfig;
import com.tencent.msdk.dns.a.a;
import com.tencent.msdk.dns.base.a.a;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.base.report.e;
import com.tencent.msdk.dns.core.IpSet;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.rest.share.c;
import com.tencent.msdk.dns.core.stat.StatisticsMerge;
import java.util.Collection;
import java.util.Map;

/* compiled from: ReportHelper */
public final class b {
    private static DnsConfig a;
    private static Runnable b = new Runnable() {
        /* class com.tencent.msdk.dns.a.b.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            b.b(c.a());
            DnsExecutors.a.a(b.b);
            DnsExecutors.a.a(b.b, 300000);
        }
    };

    public static void a(DnsConfig dnsConfig) {
        if (dnsConfig != null) {
            a = dnsConfig;
            b();
            return;
        }
        throw new IllegalArgumentException("dnsConfig".concat(" can not be null"));
    }

    public static void a(LookupResult[] lookupResultArr) {
        if (lookupResultArr == null) {
            throw new IllegalArgumentException("lookupResults".concat(" can not be null"));
        } else if (e.a()) {
            Map a2 = a.a(24);
            a2.put("channel", a.channel);
            a2.put("lookup_count", String.valueOf(lookupResultArr.length));
            a.C0146a aVar = new a.C0146a(false);
            for (LookupResult lookupResult : lookupResultArr) {
                aVar.a((StatisticsMerge) lookupResult.stat);
            }
            a a3 = aVar.a();
            a2.put("net_types", a3.a);
            a2.put("ssids", a3.b);
            a2.put("domains", a3.c);
            a2.put("net_stacks", a3.e);
            a2.put("hdns_a_err_codes", a3.h);
            a2.put("hdns_a_err_msgs", a3.i);
            a2.put("hdns_a_ipses", a3.j);
            a2.put("hdns_a_ttls", a3.k);
            a2.put("hdns_a_client_ips", a3.l);
            a2.put("hdns_a_time_mses", a3.m);
            a2.put("hdns_a_retrys", a3.n);
            a2.put("hdns_4a_err_codes", a3.o);
            a2.put("hdns_4a_err_msgs", a3.q);
            a2.put("hdns_4a_ipses", a3.p);
            a2.put("hdns_4a_ttls", a3.r);
            a2.put("hdns_4a_client_ips", a3.s);
            a2.put("hdns_4a_time_mses", a3.t);
            a2.put("hdns_4a_retrys", a3.u);
            a(a2);
            a("HDNSPreLookup", a2);
        }
    }

    public static void a(LookupResult lookupResult) {
        if (lookupResult == null) {
            throw new IllegalArgumentException("lookupResult".concat(" can not be null"));
        } else if (e.a()) {
            if (!(lookupResult.stat instanceof StatisticsMerge)) {
                com.tencent.msdk.dns.base.log.b.c("lookupResult.stat is not instanceof StatisticsMerge", new Object[0]);
                return;
            }
            Map a2 = com.tencent.msdk.dns.base.a.a.a(29);
            IpSet ipSet = lookupResult.ipSet;
            a2.put("dns_ips", com.tencent.msdk.dns.base.e.a.a(ipSet.v4Ips, ","));
            a2.put("dns_4a_ips", com.tencent.msdk.dns.base.e.a.a(ipSet.v6Ips, ","));
            StatisticsMerge statisticsMerge = (StatisticsMerge) lookupResult.stat;
            a2.put("channel", statisticsMerge.channel);
            a2.put("netType", statisticsMerge.netType);
            a2.put("ssid", statisticsMerge.ssid);
            a2.put("domain", statisticsMerge.hostname);
            a2.put("net_stack", String.valueOf(statisticsMerge.curNetStack));
            a2.put("ldns_ip", com.tencent.msdk.dns.base.e.a.a(statisticsMerge.localDnsStat.ips, ","));
            a2.put("ldns_time", String.valueOf(statisticsMerge.localDnsStat.costTimeMills));
            a2.put("isCache", String.valueOf(statisticsMerge.restInetDnsStat.cached));
            a2.put("hdns_a_err_code", String.valueOf(statisticsMerge.restInetDnsStat.errorCode));
            a2.put("hdns_a_err_msg", statisticsMerge.restInetDnsStat.errorMsg);
            a2.put("hdns_ip", com.tencent.msdk.dns.base.e.a.a(statisticsMerge.restInetDnsStat.ips, ","));
            a2.put("ttl", String.valueOf(statisticsMerge.restInetDnsStat.ttl));
            a2.put("clientIP", statisticsMerge.restInetDnsStat.clientIp);
            a2.put("hdns_time", String.valueOf(statisticsMerge.restInetDnsStat.costTimeMills));
            a2.put("hdns_a_retry", String.valueOf(statisticsMerge.restInetDnsStat.retryTimes));
            a2.put("hdns_4a_cache_hit", String.valueOf(statisticsMerge.restInet6DnsStat.cached));
            a2.put("hdns_4a_err_code", String.valueOf(statisticsMerge.restInet6DnsStat.errorCode));
            a2.put("hdns_4a_err_msg", statisticsMerge.restInet6DnsStat.errorMsg);
            a2.put("hdns_4a_ips", com.tencent.msdk.dns.base.e.a.a(statisticsMerge.restInet6DnsStat.ips, ","));
            a2.put("hdns_4a_ttl", String.valueOf(statisticsMerge.restInet6DnsStat.ttl));
            a2.put("hdns_4a_client_ip", statisticsMerge.restInet6DnsStat.clientIp);
            a2.put("hdns_4a_time_ms", String.valueOf(statisticsMerge.restInet6DnsStat.costTimeMills));
            a2.put("hdns_4a_retry", String.valueOf(statisticsMerge.restInet6DnsStat.retryTimes));
            a(a2);
            a("HDNSGetHostByName", a2);
        }
    }

    private static void b() {
        DnsExecutors.a.a(b, 300000);
        com.tencent.msdk.dns.base.b.b.a(new com.tencent.msdk.dns.base.b.a() {
            /* class com.tencent.msdk.dns.a.b.AnonymousClass2 */

            @Override // com.tencent.msdk.dns.base.b.a
            public void d(Activity activity) {
                DnsExecutors.a.execute(b.b);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(Collection<LookupResult> collection) {
        if (!com.tencent.msdk.dns.base.e.a.a((Collection<?>) collection) && e.a()) {
            Map a2 = com.tencent.msdk.dns.base.a.a.a(19);
            a2.put("channel", a.channel);
            a2.put("lookup_count", String.valueOf(collection.size()));
            a.C0146a aVar = new a.C0146a(true);
            for (LookupResult lookupResult : collection) {
                aVar.a((StatisticsMerge) lookupResult.stat);
            }
            a a3 = aVar.a();
            a2.put("net_types", a3.a);
            a2.put("ssids", a3.b);
            a2.put("net_changes", a3.f);
            a2.put("domains", a3.c);
            a2.put("lookup_time_mses", a3.g);
            a2.put("net_stacks", a3.e);
            a2.put("hdns_err_codes", a3.h);
            a2.put("hdns_err_msgs", a3.i);
            a2.put("hdns_ipses", a3.j);
            a2.put("hdns_ttls", a3.k);
            a2.put("hdns_client_ips", a3.l);
            a2.put("hdns_time_mses", a3.m);
            a2.put("hdns_retrys", a3.n);
            a(a2);
            a("HDNSLookupAsync", a2);
        }
    }

    private static void a(Map<String, String> map) {
        map.put("sdk_Version", "3.3.0a");
        map.put("appID", a.appId);
        map.put("id", a.lookupExtra.b);
        map.put("userID", a.userId);
    }

    private static void a(String str, Map<String, String> map) {
        e.a(3, str, map);
    }
}
