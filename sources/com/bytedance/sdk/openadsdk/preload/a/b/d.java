package com.bytedance.sdk.openadsdk.preload.a.b;

import com.bytedance.sdk.openadsdk.preload.a.a.e;
import com.bytedance.sdk.openadsdk.preload.a.b;
import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class d implements w, Cloneable {
    public static final d a = new d();
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<b> f = Collections.emptyList();
    private List<b> g = Collections.emptyList();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(final f fVar, final a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        boolean a3 = a(a2);
        final boolean z = a3 || b(a2, true);
        final boolean z2 = a3 || b(a2, false);
        if (z || z2) {
            return new v<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.d.AnonymousClass1 */
                private v<T> f;

                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                    if (!z2) {
                        return (T) b().b(aVar);
                    }
                    aVar.n();
                    return null;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public void a(c cVar, T t) throws IOException {
                    if (z) {
                        cVar.f();
                    } else {
                        b().a(cVar, t);
                    }
                }

                private v<T> b() {
                    v<T> vVar = this.f;
                    if (vVar != null) {
                        return vVar;
                    }
                    v<T> a2 = fVar.a(d.this, aVar);
                    this.f = a2;
                    return a2;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.bytedance.sdk.openadsdk.preload.a.a.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (!(this.b == -1.0d || a((com.bytedance.sdk.openadsdk.preload.a.a.d) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.e && ((aVar = (com.bytedance.sdk.openadsdk.preload.a.a.a) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.a.class)) == null || (!z ? !aVar.b() : !aVar.a()))) {
            return true;
        }
        if ((!this.d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<b> list = z ? this.f : this.g;
        if (list.isEmpty()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.preload.a.c cVar = new com.bytedance.sdk.openadsdk.preload.a.c(field);
        for (b bVar : list) {
            if (bVar.a(cVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.b != -1.0d && !a((com.bytedance.sdk.openadsdk.preload.a.a.d) cls.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((this.d || !c(cls)) && !b(cls)) {
            return false;
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean b(Class<?> cls, boolean z) {
        for (b bVar : z ? this.f : this.g) {
            if (bVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.a() > this.b;
    }
}
