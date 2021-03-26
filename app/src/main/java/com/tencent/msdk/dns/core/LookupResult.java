package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.f.c;

public final class LookupResult<Statistics extends f.c> {
    public final IpSet ipSet;
    public final Statistics stat;

    public LookupResult(String[] strArr, Statistics statistics) {
        if (strArr == null) {
            throw new IllegalArgumentException("ips".concat(" can not be null"));
        } else if (statistics != null) {
            this.ipSet = new IpSet(strArr);
            this.stat = statistics;
        } else {
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }

    public LookupResult(IpSet ipSet2, Statistics statistics) {
        if (ipSet2 == null) {
            throw new IllegalArgumentException("ipSet".concat(" can not be null"));
        } else if (statistics != null) {
            this.ipSet = ipSet2;
            this.stat = statistics;
        } else {
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }

    public String toString() {
        return "LookupResult{ipSet=" + this.ipSet + ", stat=" + this.stat + '}';
    }
}
