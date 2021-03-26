package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.c;
import com.bytedance.sdk.openadsdk.preload.a.b.d;
import com.bytedance.sdk.openadsdk.preload.a.b.k;
import com.bytedance.sdk.openadsdk.preload.a.e;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class i implements w {
    private final c a;
    private final e b;
    private final d c;
    private final d d;
    private final com.bytedance.sdk.openadsdk.preload.a.b.b.b e = com.bytedance.sdk.openadsdk.preload.a.b.b.b.a();

    public i(c cVar, e eVar, d dVar, d dVar2) {
        this.a = cVar;
        this.b = eVar;
        this.c = dVar;
        this.d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.c);
    }

    static boolean a(Field field, boolean z, d dVar) {
        return !dVar.a(field.getType(), z) && !dVar.a(field, z);
    }

    private List<String> a(Field field) {
        com.bytedance.sdk.openadsdk.preload.a.a.c cVar = (com.bytedance.sdk.openadsdk.preload.a.a.c) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String str : b2) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (!Object.class.isAssignableFrom(a2)) {
            return null;
        }
        return new a(this.a.a(aVar), a(fVar, (com.bytedance.sdk.openadsdk.preload.a.c.a<?>) aVar, (Class<?>) a2));
    }

    private b a(final f fVar, final Field field, String str, final com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, boolean z2) {
        final boolean a2 = k.a(aVar.a());
        com.bytedance.sdk.openadsdk.preload.a.a.b bVar = (com.bytedance.sdk.openadsdk.preload.a.a.b) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.b.class);
        final v<?> a3 = bVar != null ? this.d.a(this.a, fVar, aVar, bVar) : null;
        final boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) aVar);
        }
        return new b(str, z, z2) {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.i.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                v vVar;
                Object obj2 = field.get(obj);
                if (z3) {
                    vVar = a3;
                } else {
                    vVar = new m(fVar, a3, aVar.b());
                }
                vVar.a(cVar, obj2);
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException {
                Object b2 = a3.b(aVar);
                if (b2 != null || !a2) {
                    field.set(obj, b2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            public boolean a(Object obj) throws IOException, IllegalAccessException {
                if (this.i && field.get(obj) != obj) {
                    return true;
                }
                return false;
            }
        };
    }

    private Map<String, b> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    this.e.a(field);
                    Type a4 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    b bVar = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = a5.get(i2);
                        boolean z2 = i2 != 0 ? false : a2;
                        bVar = bVar == null ? (b) linkedHashMap.put(str, a(fVar, field, str, com.bytedance.sdk.openadsdk.preload.a.c.a.a(a4), z2, a3)) : bVar;
                        i2++;
                        a2 = z2;
                        a5 = a5;
                        size = size;
                        field = field;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.h);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = com.bytedance.sdk.openadsdk.preload.a.c.a.a(com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    public static final class a<T> extends v<T> {
        private final com.bytedance.sdk.openadsdk.preload.a.b.i<T> a;
        private final Map<String, b> b;

        a(com.bytedance.sdk.openadsdk.preload.a.b.i<T> iVar, Map<String, b> map) {
            this.a = iVar;
            this.b = map;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.b.get(aVar.g());
                    if (bVar != null) {
                        if (bVar.j) {
                            bVar.a(aVar, a2);
                        }
                    }
                    aVar.n();
                }
                aVar.d();
                return a2;
            } catch (IllegalStateException e) {
                throw new t(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.h);
                        bVar.a(cVar, t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
