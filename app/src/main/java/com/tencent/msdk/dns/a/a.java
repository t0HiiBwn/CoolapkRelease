package com.tencent.msdk.dns.a;

import com.tencent.msdk.dns.core.rest.share.AbsRestDns;
import com.tencent.msdk.dns.core.stat.StatisticsMerge;

/* compiled from: BatchStatistics */
final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    /* renamed from: l  reason: collision with root package name */
    public final String f1448l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;

    private a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.f1448l = str12;
        this.m = str13;
        this.n = str14;
        this.o = str15;
        this.q = str16;
        this.p = str17;
        this.r = str18;
        this.s = str19;
        this.t = str20;
        this.u = str21;
    }

    /* renamed from: com.tencent.msdk.dns.a.a$a  reason: collision with other inner class name */
    /* compiled from: BatchStatistics */
    public static class C0128a {
        private final boolean a;
        private final StringBuilder b = new StringBuilder();
        private final StringBuilder c = new StringBuilder();
        private final StringBuilder d = new StringBuilder();
        private final StringBuilder e = new StringBuilder();
        private final StringBuilder f = new StringBuilder();
        private final StringBuilder g = new StringBuilder();
        private final StringBuilder h = new StringBuilder();
        private final StringBuilder i = new StringBuilder();
        private final StringBuilder j = new StringBuilder();
        private final StringBuilder k = new StringBuilder();

        /* renamed from: l  reason: collision with root package name */
        private final StringBuilder f1449l = new StringBuilder();
        private final StringBuilder m = new StringBuilder();
        private final StringBuilder n = new StringBuilder();
        private final StringBuilder o = new StringBuilder();
        private final StringBuilder p = new StringBuilder();
        private final StringBuilder q = new StringBuilder();
        private final StringBuilder r = new StringBuilder();
        private final StringBuilder s = new StringBuilder();
        private final StringBuilder t = new StringBuilder();
        private final StringBuilder u = new StringBuilder();
        private final StringBuilder v = new StringBuilder();

        public C0128a(boolean z) {
            this.a = z;
        }

        public C0128a a(StatisticsMerge statisticsMerge) {
            if (statisticsMerge != null) {
                StringBuilder sb = this.b;
                sb.append(statisticsMerge.netType);
                sb.append('_');
                StringBuilder sb2 = this.c;
                sb2.append(statisticsMerge.ssid);
                sb2.append('_');
                StringBuilder sb3 = this.d;
                sb3.append(statisticsMerge.hostname);
                sb3.append('_');
                StringBuilder sb4 = this.f;
                sb4.append(statisticsMerge.curNetStack);
                sb4.append('_');
                if (this.a) {
                    StringBuilder sb5 = this.e;
                    sb5.append(statisticsMerge.channel);
                    sb5.append('_');
                    AbsRestDns.Statistics statistics = AbsRestDns.Statistics.NOT_LOOKUP != statisticsMerge.restInetDnsStat ? statisticsMerge.restInetDnsStat : statisticsMerge.restInet6DnsStat;
                    StringBuilder sb6 = this.g;
                    sb6.append(statistics.netChangeLookup);
                    sb6.append('_');
                    StringBuilder sb7 = this.h;
                    sb7.append(statistics.startLookupTimeMills);
                    sb7.append('_');
                    StringBuilder sb8 = this.i;
                    sb8.append(statistics.errorCode);
                    sb8.append('_');
                    StringBuilder sb9 = this.j;
                    sb9.append(statistics.errorMsg);
                    sb9.append('_');
                    StringBuilder sb10 = this.k;
                    sb10.append(com.tencent.msdk.dns.base.e.a.a(statistics.ips, ","));
                    sb10.append('_');
                    StringBuilder sb11 = this.f1449l;
                    sb11.append(statistics.ttl);
                    sb11.append('_');
                    StringBuilder sb12 = this.m;
                    sb12.append(statistics.clientIp);
                    sb12.append('_');
                    StringBuilder sb13 = this.n;
                    sb13.append(statistics.costTimeMills);
                    sb13.append('_');
                    StringBuilder sb14 = this.o;
                    sb14.append(statistics.retryTimes);
                    sb14.append('_');
                } else {
                    StringBuilder sb15 = this.i;
                    sb15.append(statisticsMerge.restInetDnsStat.errorCode);
                    sb15.append('_');
                    StringBuilder sb16 = this.j;
                    sb16.append(statisticsMerge.restInetDnsStat.errorMsg);
                    sb16.append('_');
                    StringBuilder sb17 = this.k;
                    sb17.append(com.tencent.msdk.dns.base.e.a.a(statisticsMerge.restInetDnsStat.ips, ","));
                    sb17.append('_');
                    StringBuilder sb18 = this.f1449l;
                    sb18.append(statisticsMerge.restInetDnsStat.ttl);
                    sb18.append('_');
                    StringBuilder sb19 = this.m;
                    sb19.append(statisticsMerge.restInetDnsStat.clientIp);
                    sb19.append('_');
                    StringBuilder sb20 = this.n;
                    sb20.append(statisticsMerge.restInetDnsStat.costTimeMills);
                    sb20.append('_');
                    StringBuilder sb21 = this.o;
                    sb21.append(statisticsMerge.restInetDnsStat.retryTimes);
                    sb21.append('_');
                    StringBuilder sb22 = this.p;
                    sb22.append(statisticsMerge.restInet6DnsStat.errorCode);
                    sb22.append('_');
                    StringBuilder sb23 = this.q;
                    sb23.append(statisticsMerge.restInet6DnsStat.errorMsg);
                    sb23.append('_');
                    StringBuilder sb24 = this.r;
                    sb24.append(com.tencent.msdk.dns.base.e.a.a(statisticsMerge.restInet6DnsStat.ips, ","));
                    sb24.append('_');
                    StringBuilder sb25 = this.s;
                    sb25.append(statisticsMerge.restInet6DnsStat.ttl);
                    sb25.append('_');
                    StringBuilder sb26 = this.t;
                    sb26.append(statisticsMerge.restInet6DnsStat.clientIp);
                    sb26.append('_');
                    StringBuilder sb27 = this.u;
                    sb27.append(statisticsMerge.restInet6DnsStat.costTimeMills);
                    sb27.append('_');
                    StringBuilder sb28 = this.v;
                    sb28.append(statisticsMerge.restInet6DnsStat.retryTimes);
                    sb28.append('_');
                }
                return this;
            }
            throw new IllegalArgumentException("statMerge".concat(" can not be null"));
        }

        public a a() {
            if (this.b.length() != 0) {
                StringBuilder sb = this.b;
                sb.setLength(sb.length() - 1);
                StringBuilder sb2 = this.c;
                sb2.setLength(sb2.length() - 1);
                StringBuilder sb3 = this.d;
                sb3.setLength(sb3.length() - 1);
                StringBuilder sb4 = this.f;
                sb4.setLength(sb4.length() - 1);
                StringBuilder sb5 = this.i;
                sb5.setLength(sb5.length() - 1);
                StringBuilder sb6 = this.j;
                sb6.setLength(sb6.length() - 1);
                StringBuilder sb7 = this.k;
                sb7.setLength(sb7.length() - 1);
                StringBuilder sb8 = this.f1449l;
                sb8.setLength(sb8.length() - 1);
                StringBuilder sb9 = this.m;
                sb9.setLength(sb9.length() - 1);
                StringBuilder sb10 = this.n;
                sb10.setLength(sb10.length() - 1);
                StringBuilder sb11 = this.o;
                sb11.setLength(sb11.length() - 1);
                if (this.a) {
                    StringBuilder sb12 = this.e;
                    sb12.setLength(sb12.length() - 1);
                    StringBuilder sb13 = this.g;
                    sb13.setLength(sb13.length() - 1);
                    StringBuilder sb14 = this.h;
                    sb14.setLength(sb14.length() - 1);
                } else {
                    StringBuilder sb15 = this.p;
                    sb15.setLength(sb15.length() - 1);
                    StringBuilder sb16 = this.q;
                    sb16.setLength(sb16.length() - 1);
                    StringBuilder sb17 = this.r;
                    sb17.setLength(sb17.length() - 1);
                    StringBuilder sb18 = this.s;
                    sb18.setLength(sb18.length() - 1);
                    StringBuilder sb19 = this.t;
                    sb19.setLength(sb19.length() - 1);
                    StringBuilder sb20 = this.u;
                    sb20.setLength(sb20.length() - 1);
                    StringBuilder sb21 = this.v;
                    sb21.setLength(sb21.length() - 1);
                }
            }
            return new a(this.b.toString(), this.c.toString(), this.d.toString(), this.e.toString(), this.f.toString(), this.g.toString(), this.h.toString(), this.i.toString(), this.j.toString(), this.k.toString(), this.f1449l.toString(), this.m.toString(), this.n.toString(), this.o.toString(), this.p.toString(), this.q.toString(), this.r.toString(), this.s.toString(), this.t.toString(), this.u.toString(), this.v.toString());
        }
    }
}
