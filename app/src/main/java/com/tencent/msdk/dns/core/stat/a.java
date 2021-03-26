package com.tencent.msdk.dns.core.stat;

import android.content.Context;
import com.tencent.msdk.dns.core.IStatisticsMerge;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.rest.share.g;

/* compiled from: StatisticsMergeFactory */
public final class a implements IStatisticsMerge.a {
    @Override // com.tencent.msdk.dns.core.IStatisticsMerge.a
    public <LookupExtraImpl extends f.a> IStatisticsMerge<LookupExtraImpl> a(Class<LookupExtraImpl> cls, Context context) {
        if (cls == null) {
            throw new IllegalArgumentException("klass".concat(" can not be null"));
        } else if (context == null) {
            throw new IllegalArgumentException("context".concat(" can not be null"));
        } else if (g.class.equals(cls)) {
            return new StatisticsMerge(context);
        } else {
            return IStatisticsMerge.a.a.a(cls, context);
        }
    }
}
