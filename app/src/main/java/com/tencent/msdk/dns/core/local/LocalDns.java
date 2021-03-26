package com.tencent.msdk.dns.core.local;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.a;
import com.tencent.msdk.dns.core.c;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.stat.AbsStatistics;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public final class LocalDns implements f<f.a> {
    private final c a = new c("Local", 3);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.msdk.dns.core.j] */
    @Override // com.tencent.msdk.dns.core.f
    public f.b a(j<f.a> jVar) {
        return null;
    }

    @Override // com.tencent.msdk.dns.core.f
    public c a() {
        return this.a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.msdk.dns.core.l] */
    @Override // com.tencent.msdk.dns.core.f
    public LookupResult a(l<f.a> lVar) {
        if (lVar != null) {
            Statistics statistics = new Statistics();
            statistics.startLookup();
            String[] a2 = a(lVar.b);
            statistics.endLookup();
            statistics.ips = a2;
            return new LookupResult(a2, statistics);
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.msdk.dns.core.l] */
    @Override // com.tencent.msdk.dns.core.f
    public LookupResult b(l<f.a> lVar) {
        Statistics statistics = new Statistics();
        statistics.startLookup();
        statistics.endLookup();
        return new LookupResult(statistics.ips, statistics);
    }

    private String[] a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = a.a;
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                if (b.b(3)) {
                    b.b("LocalDns lookup for %s result: %s", str, Arrays.toString(strArr));
                }
            } catch (UnknownHostException e) {
                b.b(e, "LocalDns lookup %s failed", str);
            }
            return strArr;
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    public static class Statistics extends AbsStatistics {
        public static final Statistics NOT_LOOKUP = new Statistics();

        public String toString() {
            return "Statistics{ips=" + Arrays.toString(this.ips) + ", costTimeMills=" + this.costTimeMills + '}';
        }
    }
}
