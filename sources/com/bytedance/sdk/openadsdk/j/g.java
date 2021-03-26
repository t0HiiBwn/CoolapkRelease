package com.bytedance.sdk.openadsdk.j;

import java.util.UUID;

/* compiled from: TTRunnable */
public abstract class g implements Comparable<g>, Runnable {
    private int a;
    private String b;

    public g(int i) {
        this.a = 0;
        this.a = i == 0 ? 5 : i;
        this.b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    public g() {
        this.a = 0;
        this.a = 5;
        this.b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    public int c() {
        return this.a;
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        if (c() < gVar.c()) {
            return 1;
        }
        return c() > gVar.c() ? -1 : 0;
    }
}
