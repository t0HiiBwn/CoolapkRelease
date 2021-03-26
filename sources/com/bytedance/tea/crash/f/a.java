package com.bytedance.tea.crash.f;

import android.os.Handler;

/* compiled from: BaseTask */
public abstract class a implements Runnable {
    private Handler a;
    private final long b;
    private final long c;

    a(Handler handler, long j, long j2) {
        this.a = handler;
        this.b = j;
        this.c = j2;
    }

    void a() {
        if (b() > 0) {
            this.a.postDelayed(this, b());
        } else {
            this.a.post(this);
        }
    }

    void a(long j) {
        if (j > 0) {
            this.a.postDelayed(this, j);
        } else {
            this.a.post(this);
        }
    }

    long b() {
        return this.b;
    }

    long c() {
        return this.c;
    }
}
