package com.bytedance.sdk.openadsdk.preload.geckox.e;

import com.bytedance.sdk.openadsdk.preload.b.b.a;
import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ListenerProvider */
public class b {
    private final Map<Class<? extends d<?, ?>>, com.bytedance.sdk.openadsdk.preload.b.b.b> a = new HashMap();

    public void a(Class<? extends d<?, ?>> cls, a aVar) {
        synchronized (this.a) {
            com.bytedance.sdk.openadsdk.preload.b.b.b bVar = this.a.get(cls);
            if (bVar == null) {
                bVar = new com.bytedance.sdk.openadsdk.preload.b.b.b(new a[0]);
                this.a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public a a(Class<? extends d<?, ?>> cls) {
        com.bytedance.sdk.openadsdk.preload.b.b.b bVar;
        synchronized (this.a) {
            bVar = this.a.get(cls);
        }
        return bVar;
    }
}
