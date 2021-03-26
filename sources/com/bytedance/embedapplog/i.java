package com.bytedance.embedapplog;

import android.content.Context;

abstract class i {
    final Context a;
    private int b = 0;
    private boolean c;

    abstract boolean a();

    abstract long b();

    abstract long[] c();

    abstract boolean d();

    abstract String e();

    i(Context context) {
        this.a = context;
    }

    void f() {
        this.c = true;
    }

    boolean g() {
        return this.c;
    }

    final long h() {
        boolean z;
        long j;
        if (!(!a() || bl.a(this.a))) {
            return 60000;
        }
        long b2 = b();
        long currentTimeMillis = System.currentTimeMillis();
        if (b2 > 1000 + currentTimeMillis) {
            return b2 - currentTimeMillis;
        }
        try {
            z = d();
        } catch (Exception e) {
            bo.a(e);
            z = false;
        }
        if (z) {
            this.b = 0;
            j = b() - System.currentTimeMillis();
        } else {
            long[] c2 = c();
            int i = this.b;
            this.b = i + 1;
            j = c2[i % c2.length];
        }
        bo.d(e() + " worked:" + z + " " + j, null);
        return j;
    }
}
