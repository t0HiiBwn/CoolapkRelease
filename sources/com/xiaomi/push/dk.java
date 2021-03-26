package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;

class dk implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f317a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dj f318a;

    dk(dj djVar, Context context, Intent intent) {
        this.f318a = djVar;
        this.a = context;
        this.f317a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f318a.b(this.a, this.f317a);
    }
}
