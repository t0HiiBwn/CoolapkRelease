package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.f;

class IStatisticsMerge$IFactory$1$1 implements IStatisticsMerge<LookupExtra> {
    final /* synthetic */ IStatisticsMerge.a.AnonymousClass1 this$0;

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupFailed() {
        return false;
    }

    public boolean lookupNeedRetry() {
        return false;
    }

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupSuccess() {
        return false;
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public void merge(f fVar, f.c cVar) {
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public void statContext(j jVar) {
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public void statResult(IpSet ipSet) {
    }

    @Override // com.tencent.msdk.dns.core.IStatisticsMerge
    public String toJsonResult() {
        return "{\"v4_ips\":\"\",\"v4_ttl\":\"\",\"v4_client_ip\":\"\",\"v6_ips\":\"\",\"v6_ttl\":\"\",\"v6_client_ip\":\"\"}";
    }

    IStatisticsMerge$IFactory$1$1(IStatisticsMerge.a.AnonymousClass1 r1) {
        this.this$0 = r1;
    }
}
