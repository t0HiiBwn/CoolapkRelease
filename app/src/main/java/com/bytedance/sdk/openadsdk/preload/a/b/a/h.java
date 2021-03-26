package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ObjectTypeAdapter */
public final class h extends v<Object> {
    public static final w a = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.h.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };
    private final f b;

    h(f fVar) {
        this.b = fVar;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.h$2  reason: invalid class name */
    /* compiled from: ObjectTypeAdapter */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        switch (AnonymousClass2.a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.bytedance.sdk.openadsdk.preload.a.b.h hVar = new com.bytedance.sdk.openadsdk.preload.a.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return hVar;
            case 3:
                return aVar.h();
            case 4:
                return Double.valueOf(aVar.k());
            case 5:
                return Boolean.valueOf(aVar.i());
            case 6:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        v a2 = this.b.a((Class) obj.getClass());
        if (a2 instanceof h) {
            cVar.d();
            cVar.e();
            return;
        }
        a2.a(cVar, obj);
    }
}
