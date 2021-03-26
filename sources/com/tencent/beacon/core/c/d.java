package com.tencent.beacon.core.c;

import com.tencent.beacon.core.d.b;

/* compiled from: RequestCounter */
public final class d implements e {
    private long a = 0;
    private long b = 0;
    private int c = 0;
    private long d = 0;
    private String e = "";

    @Override // com.tencent.beacon.core.c.e
    public final synchronized void a(String str, long j, String str2, int i) {
        b.h("[net] send: %s sz: %d apn: %s", str, Long.valueOf(j), str2);
        this.e = str2;
        this.c++;
        this.a += j;
        a(i);
    }

    @Override // com.tencent.beacon.core.c.e
    public final synchronized void a(long j, long j2) {
        b.h("[net] received: %d", Long.valueOf(j));
        this.b += j;
        this.d = j2;
    }

    @Override // com.tencent.beacon.core.c.e
    public final void a() {
        b.h("[net] request time out!!!", new Object[0]);
    }

    public final synchronized long b() {
        return this.a;
    }

    public final synchronized long c() {
        return this.b;
    }

    public final synchronized int d() {
        return this.c;
    }

    private synchronized void a(int i) {
        this.c = i;
    }

    public final synchronized long e() {
        return this.d;
    }

    public final synchronized String f() {
        return this.e;
    }
}
