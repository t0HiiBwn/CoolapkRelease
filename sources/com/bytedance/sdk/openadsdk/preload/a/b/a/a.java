package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter */
public final class a<E> extends v<Object> {
    public static final w a = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.a.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            Type b = aVar.b();
            if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
                return null;
            }
            Type g = b.g(b);
            return new a(fVar, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(g)), b.e(g));
        }
    };
    private final Class<E> b;
    private final v<E> c;

    public a(f fVar, v<E> vVar, Class<E> cls) {
        this.c = new m(fVar, vVar, cls);
        this.b = cls;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(cVar, Array.get(obj, i));
        }
        cVar.c();
    }
}
