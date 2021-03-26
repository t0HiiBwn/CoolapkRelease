package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.i;

/* compiled from: RetryInterceptor */
public abstract class k<IN, OUT> extends d<IN, OUT> {
    private IN d;

    protected abstract boolean a(Throwable th);

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        this.d = in;
        try {
            return bVar.a((b<OUT>) b());
        } catch (i.a e) {
            return a(bVar, in, e.getCause());
        } catch (Throwable th) {
            return a(bVar, in, th);
        }
    }

    protected final IN g() {
        return this.d;
    }

    private Object a(b<OUT> bVar, IN in, Throwable th) throws Throwable {
        while (a(th)) {
            try {
                return bVar.a((b<OUT>) b());
            } catch (i.a e) {
                th = e.getCause();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [IN, OUT] */
    protected OUT b() {
        return this.d;
    }
}
