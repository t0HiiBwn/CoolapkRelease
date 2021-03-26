package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.c;
import com.bytedance.sdk.openadsdk.preload.a.b.i;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class b implements w {
    private final c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(b, (Class<?>) a2);
        return new a(fVar, a3, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a3)), this.a.a(aVar));
    }

    /* compiled from: CollectionTypeAdapterFactory */
    private static final class a<E> extends v<Collection<E>> {
        private final v<E> a;
        private final i<? extends Collection<E>> b;

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Collection) ((Collection) obj));
        }

        public a(f fVar, Type type, v<E> vVar, i<? extends Collection<E>> iVar) {
            this.a = new m(fVar, vVar, type);
            this.b = iVar;
        }

        /* renamed from: a */
        public Collection<E> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> collection = (Collection) this.b.a();
            aVar.a();
            while (aVar.e()) {
                collection.add(this.a.b(aVar));
            }
            aVar.b();
            return collection;
        }

        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (E e : collection) {
                this.a.a(cVar, e);
            }
            cVar.c();
        }
    }
}
