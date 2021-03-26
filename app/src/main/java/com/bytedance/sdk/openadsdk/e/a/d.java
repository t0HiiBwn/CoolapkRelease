package com.bytedance.sdk.openadsdk.e.a;

/* compiled from: BaseStatefulMethod */
public abstract class d<P, R> extends b<P, R> {
    private boolean a = true;
    private a b;
    private f c;

    /* compiled from: BaseStatefulMethod */
    interface a {
        void a(Object obj);

        void a(Throwable th);
    }

    /* compiled from: BaseStatefulMethod */
    public interface b {
        d a();
    }

    protected abstract void a(P p, f fVar) throws Exception;

    @Override // com.bytedance.sdk.openadsdk.e.a.b
    public /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public final void a(R r) {
        if (e()) {
            this.b.a((Object) r);
            d();
        }
    }

    protected final void a(Throwable th) {
        if (e()) {
            this.b.a(th);
            d();
        }
    }

    protected final void c() {
        a((Throwable) null);
    }

    protected void d() {
        this.a = false;
        this.c = null;
    }

    void a(P p, f fVar, a aVar) throws Exception {
        this.c = fVar;
        this.b = aVar;
        a(p, fVar);
    }

    private boolean e() {
        if (this.a) {
            return true;
        }
        i.a(new IllegalStateException("Jsb async call already finished: " + a() + ", hashcode: " + hashCode()));
        return false;
    }
}
