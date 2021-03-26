package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.i;
import com.bytedance.sdk.openadsdk.preload.a.d.a;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class m<T> extends v<T> {
    private final f a;
    private final v<T> b;
    private final Type c;

    m(f fVar, v<T> vVar, Type type) {
        this.a = fVar;
        this.b = vVar;
        this.c = type;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(a aVar) throws IOException {
        return this.b.b(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, T t) throws IOException {
        v<T> vVar = this.b;
        Type a2 = a(this.c, t);
        if (a2 != this.c) {
            vVar = this.a.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a2));
            if (vVar instanceof i.a) {
                v<T> vVar2 = this.b;
                if (!(vVar2 instanceof i.a)) {
                    vVar = vVar2;
                }
            }
        }
        vVar.a(cVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }
}
