package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;

/* compiled from: Ping */
final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;
    private long c = -1;

    l() {
    }

    void a() {
        if (this.b == -1) {
            this.b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    void b() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.a.countDown();
    }

    void c() {
        if (this.c == -1) {
            long j = this.b;
            if (j != -1) {
                this.c = j - 1;
                this.a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
