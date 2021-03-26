package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class i extends t {
    private t a;

    public i(t tVar) {
        if (tVar != null) {
            this.a = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final t a() {
        return this.a;
    }

    public final i a(t tVar) {
        if (tVar != null) {
            this.a = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.a.a.t
    public t a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long b_() {
        return this.a.b_();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long c_() {
        return this.a.c_();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t a(long j) {
        return this.a.a(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t e() {
        return this.a.e();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t f() {
        return this.a.f();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.a.g();
    }
}
