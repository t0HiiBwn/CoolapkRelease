package com.tencent.msdk.dns.core.stat;

import com.tencent.msdk.dns.core.a;
import com.tencent.msdk.dns.core.f;

public abstract class AbsStatistics implements f.c {
    public int costTimeMills = 0;
    public String[] ips = a.a;
    public boolean isGetEmptyResponse = false;
    public long startLookupTimeMills = 0;

    public void startLookup() {
        this.startLookupTimeMills = System.currentTimeMillis();
    }

    public void endLookup() {
        this.costTimeMills = (int) (System.currentTimeMillis() - this.startLookupTimeMills);
    }

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupSuccess() {
        return a.a != this.ips;
    }

    @Override // com.tencent.msdk.dns.core.f.c
    public boolean lookupFailed() {
        return this.isGetEmptyResponse;
    }

    public boolean lookupNeedRetry() {
        return !lookupSuccess() && !lookupFailed();
    }
}
