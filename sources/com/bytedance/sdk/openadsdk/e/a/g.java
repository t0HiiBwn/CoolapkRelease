package com.bytedance.sdk.openadsdk.e.a;

import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.s;
import com.bytedance.sdk.openadsdk.e.a.u;
import com.bytedance.sdk.openadsdk.e.a.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* compiled from: CallHandler */
class g implements v.a {
    private final h a;
    private final t b;
    private final Map<String, b> c = new HashMap();
    private final Map<String, d.b> d = new HashMap();
    private final List<p> e = new ArrayList();
    private final Set<d> f = new HashSet();
    private final m g;
    private final boolean h;
    private final boolean i;
    private final a j;

    g(j jVar, a aVar, u uVar) {
        this.j = aVar;
        this.a = jVar.d;
        t tVar = new t(uVar, jVar.f1330l, jVar.m);
        this.b = tVar;
        tVar.a(this);
        tVar.a(jVar.p);
        this.g = jVar.i;
        this.h = jVar.h;
        this.i = jVar.o;
    }

    a a(p pVar, f fVar) throws Exception {
        b bVar = this.c.get(pVar.d);
        if (bVar != null) {
            try {
                w b2 = b(fVar.b, bVar);
                fVar.d = b2;
                if (b2 == null) {
                    m mVar = this.g;
                    if (mVar != null) {
                        mVar.a(fVar.b, pVar.d, 1);
                    }
                    i.a("Permission denied, call: " + pVar);
                    throw new r(-1);
                } else if (bVar instanceof e) {
                    i.a("Processing stateless call: " + pVar);
                    return a(pVar, (e) bVar, fVar);
                } else if (bVar instanceof c) {
                    i.a("Processing raw call: " + pVar);
                    return a(pVar, (c) bVar, b2);
                }
            } catch (u.a e2) {
                i.a("No remote permission config fetched, call pending: " + pVar, e2);
                this.e.add(pVar);
                return new a(false, x.a());
            }
        }
        d.b bVar2 = this.d.get(pVar.d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(pVar.d);
            w b3 = b(fVar.b, a2);
            fVar.d = b3;
            if (b3 != null) {
                i.a("Processing stateful call: " + pVar);
                return a(pVar, a2, fVar);
            }
            i.a("Permission denied, call: " + pVar);
            a2.d();
            throw new r(-1);
        }
        m mVar2 = this.g;
        if (mVar2 != null) {
            mVar2.a(fVar.b, pVar.d, 2);
        }
        i.b("Received call: " + pVar + ", but not registered.");
        return null;
    }

    void a(String str, e<?, ?> eVar) {
        eVar.a(str);
        this.c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    void a(String str, d.b bVar) {
        this.d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    private a a(p pVar, e eVar, f fVar) throws Exception {
        return new a(true, x.a(this.a.a((h) eVar.a(a(pVar.e, (b) eVar), fVar))));
    }

    private a a(final p pVar, final d dVar, f fVar) throws Exception {
        this.f.add(dVar);
        dVar.a(a(pVar.e, dVar), fVar, new d.a() {
            /* class com.bytedance.sdk.openadsdk.e.a.g.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.d.a
            public void a(Object obj) {
                if (g.this.j != null) {
                    g.this.j.b(x.a(g.this.a.a((h) obj)), pVar);
                    g.this.f.remove(dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.e.a.d.a
            public void a(Throwable th) {
                if (g.this.j != null) {
                    g.this.j.b(x.a(th), pVar);
                    g.this.f.remove(dVar);
                }
            }
        });
        return new a(false, x.a());
    }

    private a a(final p pVar, c cVar, w wVar) throws Exception {
        cVar.a(pVar, new s(pVar.d, wVar, new s.a() {
            /* class com.bytedance.sdk.openadsdk.e.a.g.AnonymousClass2 */
        }));
        return new a(false, x.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.a.a(str, a(bVar)[0]);
    }

    private w b(String str, b bVar) {
        if (this.i) {
            return w.PRIVATE;
        }
        return this.b.a(this.h, str, bVar);
    }

    private static Type[] a(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }

    /* compiled from: CallHandler */
    static final class a {
        boolean a;
        String b;

        private a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }
}
