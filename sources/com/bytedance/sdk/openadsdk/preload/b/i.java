package com.bytedance.sdk.openadsdk.preload.b;

import java.util.List;

/* compiled from: RealInterceptorChain */
final class i implements b {
    protected e a;
    private int b;
    private List<h> c;
    private d d;

    i(List<h> list, int i, e eVar, d dVar) {
        this.c = list;
        this.b = i;
        this.a = eVar;
        this.d = dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c = obj;
            this.d.f();
        }
        if (this.b >= this.c.size()) {
            return obj;
        }
        h hVar = this.c.get(this.b);
        Class<? extends d> a2 = hVar.a();
        d dVar2 = (d) this.a.a(a2);
        if (dVar2 != null) {
            com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
            i iVar = new i(this.c, this.b + 1, this.a, dVar2);
            dVar2.a(iVar, this.d, obj, b2, hVar.c());
            dVar2.d();
            try {
                Object a_ = dVar2.a_(iVar, obj);
                dVar2.e();
                return a_;
            } catch (a e) {
                dVar2.c(e.getCause());
                throw e;
            } catch (Throwable th) {
                dVar2.b(th);
                throw new a(th);
            }
        } else {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object b(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }

    private d c(Class cls) {
        d dVar = this.d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.a;
        }
        return dVar;
    }

    /* compiled from: RealInterceptorChain */
    static final class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
