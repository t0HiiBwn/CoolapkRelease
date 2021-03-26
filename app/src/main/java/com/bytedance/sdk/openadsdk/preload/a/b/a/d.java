package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.a.b;
import com.bytedance.sdk.openadsdk.preload.a.b.c;
import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.k;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class d implements w {
    private final c a;

    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(f fVar, a<T> aVar) {
        b bVar = (b) aVar.a().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (v<T>) a(this.a, fVar, aVar, bVar);
    }

    v<?> a(c cVar, f fVar, a<?> aVar, b bVar) {
        v<?> vVar;
        Object a2 = cVar.a(a.b(bVar.a())).a();
        if (a2 instanceof v) {
            vVar = (v) a2;
        } else if (a2 instanceof w) {
            vVar = ((w) a2).a(fVar, aVar);
        } else {
            boolean z = a2 instanceof s;
            if (z || (a2 instanceof k)) {
                k kVar = null;
                s sVar = z ? (s) a2 : null;
                if (a2 instanceof k) {
                    kVar = (k) a2;
                }
                vVar = new l<>(sVar, kVar, fVar, aVar, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (vVar == null || !bVar.b()) ? vVar : vVar.a();
    }
}
