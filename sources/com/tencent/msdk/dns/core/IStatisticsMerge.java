package com.tencent.msdk.dns.core;

import android.content.Context;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.f.a;

public interface IStatisticsMerge<LookupExtra extends f.a> extends f.c {

    public interface a {
        public static final a a = new a() {
            /* class com.tencent.msdk.dns.core.IStatisticsMerge.a.AnonymousClass1 */

            @Override // com.tencent.msdk.dns.core.IStatisticsMerge.a
            public <LookupExtra extends f.a> IStatisticsMerge<LookupExtra> a(Class<LookupExtra> cls, Context context) {
                return new IStatisticsMerge$IFactory$1$1(this);
            }
        };

        <LookupExtra extends f.a> IStatisticsMerge<LookupExtra> a(Class<LookupExtra> cls, Context context);
    }

    <Statistics extends f.c> void merge(f fVar, Statistics statistics);

    void statContext(j<LookupExtra> jVar);

    void statResult(IpSet ipSet);

    String toJsonResult();
}
