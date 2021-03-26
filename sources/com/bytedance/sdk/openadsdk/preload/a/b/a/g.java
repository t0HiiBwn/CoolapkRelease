package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.b;
import com.bytedance.sdk.openadsdk.preload.a.b.c;
import com.bytedance.sdk.openadsdk.preload.a.b.i;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.l;
import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory */
public final class g implements w {
    final boolean a;
    private final c b;

    public g(c cVar, boolean z) {
        this.b = cVar;
        this.a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b2 = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b3 = b.b(b2, b.e(b2));
        return new a(fVar, b3[0], a(fVar, b3[0]), b3[1], fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(b3[1])), this.b.a(aVar));
    }

    private v<?> a(f fVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return n.f;
        }
        return fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
    }

    /* compiled from: MapTypeAdapterFactory */
    private final class a<K, V> extends v<Map<K, V>> {
        private final v<K> b;
        private final v<V> c;
        private final i<? extends Map<K, V>> d;

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Map) ((Map) obj));
        }

        public a(f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, i<? extends Map<K, V>> iVar) {
            this.b = new m(fVar, vVar, type);
            this.c = new m(fVar, vVar2, type2);
            this.d = iVar;
        }

        /* renamed from: a */
        public Map<K, V> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.preload.a.d.b f = aVar.f();
            if (f == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> map = (Map) this.d.a();
            if (f == com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K b2 = this.b.b(aVar);
                    if (map.put(b2, this.c.b(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new t("duplicate key: " + ((Object) b2));
                    }
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.bytedance.sdk.openadsdk.preload.a.b.f.a.a(aVar);
                    K b3 = this.b.b(aVar);
                    if (map.put(b3, this.c.b(aVar)) != null) {
                        throw new t("duplicate key: " + ((Object) b3));
                    }
                }
                aVar.d();
            }
            return map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.f();
            } else if (!g.this.a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.c.a(cVar, entry.getValue());
                }
                cVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    l a2 = this.b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= a2.g() || a2.h();
                }
                if (z) {
                    cVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.b();
                        com.bytedance.sdk.openadsdk.preload.a.b.l.a((l) arrayList.get(i), cVar);
                        this.c.a(cVar, arrayList2.get(i));
                        cVar.c();
                        i++;
                    }
                    cVar.c();
                    return;
                }
                cVar.d();
                int size2 = arrayList.size();
                while (i < size2) {
                    cVar.a(a((l) arrayList.get(i)));
                    this.c.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.e();
            }
        }

        private String a(l lVar) {
            if (lVar.i()) {
                q m = lVar.m();
                if (m.o()) {
                    return String.valueOf(m.a());
                }
                if (m.n()) {
                    return Boolean.toString(m.f());
                }
                if (m.p()) {
                    return m.b();
                }
                throw new AssertionError();
            } else if (lVar.j()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
