package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.b.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Interceptor */
public abstract class d<IN, OUT> {
    private static AtomicLong d = new AtomicLong();
    d a;
    IN b;
    OUT c;
    private a e;
    private b f;
    private long g;

    protected void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    final void a(b bVar, d dVar, IN in, a aVar, Object[] objArr) {
        this.f = new m(bVar);
        this.a = dVar;
        this.b = in;
        this.e = aVar;
        a();
        a(objArr);
    }

    private void a() {
        d dVar = this.a;
        if (dVar != null) {
            this.g = dVar.g;
            return;
        }
        long andIncrement = d.getAndIncrement();
        this.g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }

    public long c() {
        return this.g;
    }

    final void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.d(this.f, this);
        }
    }

    final void e() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.f(this.f, this);
        }
    }

    final void f() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.e(this.f, this);
        }
    }

    final void b(Throwable th) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.c(this.f, this, th);
        }
    }

    final void c(Throwable th) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.e(this.f, this, th);
        }
    }

    protected final void d(Throwable th) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.d(this.f, this, th);
        }
    }
}
