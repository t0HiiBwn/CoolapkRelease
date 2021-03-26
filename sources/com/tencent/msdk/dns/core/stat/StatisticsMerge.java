package com.tencent.msdk.dns.core.stat;

import android.content.Context;
import com.tencent.msdk.dns.base.e.a;
import com.tencent.msdk.dns.base.e.e;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.IpSet;
import com.tencent.msdk.dns.core.c;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.local.LocalDns;
import com.tencent.msdk.dns.core.rest.share.AbsRestDns;
import com.tencent.msdk.dns.core.rest.share.g;
import org.json.JSONObject;

public final class StatisticsMerge implements IStatisticsMerge<g> {
    public String channel = "";
    public int curNetStack = -1;
    private boolean hasBeenMerge = false;
    public String hostname = "";
    public IpSet ipSet;
    public LocalDns.Statistics localDnsStat = LocalDns.Statistics.NOT_LOOKUP;
    public boolean lookupFailed = true;
    public boolean lookupSuccess = false;
    public final String netType;
    public AbsRestDns.Statistics restInet6DnsStat = AbsRestDns.Statistics.NOT_LOOKUP;
    public AbsRestDns.Statistics restInetDnsStat = AbsRestDns.Statistics.NOT_LOOKUP;
    public final String ssid;

    public StatisticsMerge(Context context) {
        if (context != null) {
            this.netType = e.a(context);
            this.ssid = e.c(context);
            return;
        }
        throw new IllegalArgumentException("context".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public <Statistics extends f.c> void merge(f fVar, Statistics statistics) {
        if (fVar == null) {
            throw new IllegalArgumentException("dns".concat(" can not be null"));
        } else if (statistics != null) {
            boolean z = false;
            b.a("%s.merge(%s, %s) called", super.toString(), fVar, statistics);
            if (!this.hasBeenMerge) {
                this.lookupSuccess = statistics.lookupSuccess();
                this.hasBeenMerge = true;
            } else {
                this.lookupSuccess = this.lookupSuccess && statistics.lookupSuccess();
            }
            if (this.lookupFailed && statistics.lookupFailed()) {
                z = true;
            }
            this.lookupFailed = z;
            c a = fVar.a();
            if ("Local".equals(a.a)) {
                this.localDnsStat = (LocalDns.Statistics) statistics;
            } else if (1 == a.b) {
                this.restInetDnsStat = (AbsRestDns.Statistics) statistics;
            } else if (2 == a.b) {
                this.restInet6DnsStat = (AbsRestDns.Statistics) statistics;
            }
        } else {
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public void statContext(j<g> jVar) {
        if (jVar != null) {
            this.hostname = jVar.b();
            this.channel = jVar.d();
            this.curNetStack = jVar.l();
            return;
        }
        throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public void statResult(IpSet ipSet2) {
        if (ipSet2 != null) {
            this.ipSet = ipSet2;
            return;
        }
        throw new IllegalArgumentException("ipSet".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupSuccess() {
        return this.lookupSuccess;
    }

    public boolean lookupNeedRetry() {
        return !lookupSuccess() && !lookupFailed();
    }

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupFailed() {
        return this.lookupFailed;
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public String toJsonResult() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v4_ips", a.a(this.restInetDnsStat.ips, ","));
            jSONObject.put("v4_ttl", String.valueOf(this.restInetDnsStat.ttl));
            jSONObject.put("v4_client_ip", String.valueOf(this.restInetDnsStat.clientIp));
            jSONObject.put("v6_ips", a.a(this.restInet6DnsStat.ips, ","));
            if (this.restInet6DnsStat.ttl == 0) {
                str = "";
            } else {
                str = String.valueOf(this.restInet6DnsStat.ttl);
            }
            jSONObject.put("v6_ttl", str);
            if ("0".equals(this.restInet6DnsStat.clientIp)) {
                str2 = "";
            } else {
                str2 = String.valueOf(this.restInet6DnsStat.clientIp);
            }
            jSONObject.put("v6_client_ip", str2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String toString() {
        return super.toString() + "{netType='" + this.netType + "', ssid='" + this.ssid + "', hostname='" + this.hostname + "', channel='" + this.channel + "', curNetStack=" + this.curNetStack + ", localDnsStat=" + this.localDnsStat + ", restInetDnsStat=" + this.restInetDnsStat + ", restInet6DnsStat=" + this.restInet6DnsStat + ", ipSet=" + this.ipSet + ", lookupSuccess=" + this.lookupSuccess + ", lookupGetEmptyResponse=" + this.lookupFailed + ", hasBeenMerge=" + this.hasBeenMerge + '}';
    }
}
