package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.j;
import com.bytedance.sdk.openadsdk.preload.a.k;
import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;

/* compiled from: TreeTypeAdapter */
public final class l<T> extends v<T> {
    final f a;
    private final s<T> b;
    private final k<T> c;
    private final com.bytedance.sdk.openadsdk.preload.a.c.a<T> d;
    private final w e;
    private final l<T>.a f = new a();
    private v<T> g;

    public l(s<T> sVar, k<T> kVar, f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.b = sVar;
        this.c = kVar;
        this.a = fVar;
        this.d = aVar;
        this.e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.c.a(a2, this.d.b(), this.f);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, T t) throws IOException {
        s<T> sVar = this.b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.d.b(), this.f), cVar);
        }
    }

    private v<T> b() {
        v<T> vVar = this.g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.a.a(this.e, this.d);
        this.g = a2;
        return a2;
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    /* compiled from: TreeTypeAdapter */
    private static final class b implements w {
        private final com.bytedance.sdk.openadsdk.preload.a.c.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final s<?> d;
        private final k<?> e;

        b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            k<?> kVar = null;
            s<?> sVar = obj instanceof s ? (s) obj : null;
            this.d = sVar;
            kVar = obj instanceof k ? (k) obj : kVar;
            this.e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((sVar == null && kVar == null) ? false : true);
            this.a = aVar;
            this.b = z;
            this.c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean z;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.a;
            if (aVar2 != null) {
                z = aVar2.equals(aVar) || (this.b && this.a.b() == aVar.a());
            } else {
                z = this.c.isAssignableFrom(aVar.a());
            }
            if (z) {
                return new l(this.d, this.e, fVar, aVar, this);
            }
            return null;
        }
    }

    /* compiled from: TreeTypeAdapter */
    private final class a implements j, r {
        private a() {
        }
    }
}
