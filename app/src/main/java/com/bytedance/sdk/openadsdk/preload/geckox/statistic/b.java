package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StatisticDataManager */
class b {
    private static final Map<Long, b> a = new HashMap();
    private final Map<String, a> b = new HashMap();

    b() {
    }

    static b a(long j) {
        b bVar;
        Map<Long, b> map = a;
        synchronized (map) {
            bVar = map.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                map.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    a a(String str) {
        a aVar;
        synchronized (this.b) {
            aVar = this.b.get(str);
            if (aVar == null) {
                aVar = new a();
                this.b.put(str, aVar);
            }
        }
        return aVar;
    }

    List<a> a() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b.values());
        }
        return arrayList;
    }
}
