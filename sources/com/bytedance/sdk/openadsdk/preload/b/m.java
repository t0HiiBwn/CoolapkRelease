package com.bytedance.sdk.openadsdk.preload.b;

/* compiled from: UnProceedChain */
final class m<IN> implements b<IN> {
    private b<IN> a;

    public m(b<IN> bVar) {
        this.a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.a.a((Class<? extends d<Object, ?>>) cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.a.b(cls);
    }
}
