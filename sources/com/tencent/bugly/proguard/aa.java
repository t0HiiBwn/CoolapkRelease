package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: BUGLY */
public final class aa implements Runnable {
    private final Handler a;
    private final String b;
    private long c;
    private final long d;
    private boolean e = true;
    private long f;

    aa(Handler handler, String str, long j) {
        this.a = handler;
        this.b = str;
        this.c = j;
        this.d = j;
    }

    public final void a() {
        if (this.e) {
            this.e = false;
            this.f = SystemClock.uptimeMillis();
            this.a.post(this);
        }
    }

    public final boolean b() {
        return !this.e && SystemClock.uptimeMillis() > this.f + this.c;
    }

    public final int c() {
        if (this.e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f < this.c ? 1 : 3;
    }

    public final String d() {
        return this.b;
    }

    public final Looper e() {
        return this.a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e = true;
        this.c = this.d;
    }

    public final void a(long j) {
        this.c = Long.MAX_VALUE;
    }
}
