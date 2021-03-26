package com.bytedance.sdk.openadsdk.preload.b.b;

import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventListenerWrapper */
public final class b extends a {
    private List<a> a;

    public b(a... aVarArr) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = copyOnWriteArrayList;
        if (aVarArr != null) {
            copyOnWriteArrayList.addAll(Arrays.asList(aVarArr));
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.a.add(aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.c(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.b(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.a(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.a(bVar, dVar, th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void f(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.f(bVar, dVar, th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.a) {
            if (aVar != null) {
                aVar.b(bVar, dVar, th);
            }
        }
    }
}
