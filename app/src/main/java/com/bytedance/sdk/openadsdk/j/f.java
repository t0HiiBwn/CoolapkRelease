package com.bytedance.sdk.openadsdk.j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: TTFutureTask */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {
    private int a;
    private int b;

    public f(Callable<V> callable, int i, int i2) {
        super(callable);
        this.a = i == -1 ? 5 : i;
        this.b = i2;
    }

    public f(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.a = i == -1 ? 5 : i;
        this.b = i2;
    }

    /* renamed from: a */
    public int compareTo(f fVar) {
        if (a() < fVar.a()) {
            return 1;
        }
        return a() > fVar.a() ? -1 : 0;
    }

    public int a() {
        return this.a;
    }
}
