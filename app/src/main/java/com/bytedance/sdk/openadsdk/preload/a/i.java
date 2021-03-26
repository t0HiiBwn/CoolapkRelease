package com.bytedance.sdk.openadsdk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class i extends l implements Iterable<l> {
    private final List<l> a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.a;
        }
        this.a.add(lVar);
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.a.iterator();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        if (this.a.size() == 1) {
            return this.a.get(0).a();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        if (this.a.size() == 1) {
            return this.a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        if (this.a.size() == 1) {
            return this.a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        if (this.a.size() == 1) {
            return this.a.get(0).e();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        if (this.a.size() == 1) {
            return this.a.get(0).f();
        }
        throw new IllegalStateException();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).a.equals(this.a));
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }
}
