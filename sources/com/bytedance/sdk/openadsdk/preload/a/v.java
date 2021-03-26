package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.f;
import com.bytedance.sdk.openadsdk.preload.a.d.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class v<T> {
    public abstract void a(c cVar, T t) throws IOException;

    public abstract T b(a aVar) throws IOException;

    public final v<T> a() {
        return new v<T>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.v.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    v.this.a(cVar, t);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public T b(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return (T) v.this.b(aVar);
                }
                aVar.j();
                return null;
            }
        };
    }

    public final l a(T t) {
        try {
            f fVar = new f();
            a(fVar, t);
            return fVar.a();
        } catch (IOException e) {
            throw new m(e);
        }
    }
}
