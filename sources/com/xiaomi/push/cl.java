package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;

class cl implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;
    final /* synthetic */ ck c;

    cl(ck ckVar, Context context, Intent intent) {
        this.c = ckVar;
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.b(this.a, this.b);
    }
}
