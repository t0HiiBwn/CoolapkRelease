package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class t {
    public static final t c = new t() {
        /* class com.bytedance.sdk.a.a.t.AnonymousClass1 */

        @Override // com.bytedance.sdk.a.a.t
        public t a(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public t a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public void g() throws IOException {
        }
    };
    private boolean a;
    private long b;
    private long d;

    public t a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit != null) {
            this.d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long b_() {
        return this.d;
    }

    public boolean c() {
        return this.a;
    }

    public long c_() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t a(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public t e() {
        this.d = 0;
        return this;
    }

    public t f() {
        this.a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
