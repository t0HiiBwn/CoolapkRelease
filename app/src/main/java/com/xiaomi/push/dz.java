package com.xiaomi.push;

import android.content.Context;

final class dz implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f388a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f389a;
    final /* synthetic */ String b;

    dz(Context context, String str, int i, String str2) {
        this.f388a = context;
        this.f389a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dy.b(this.f388a, this.f389a, this.a, this.b);
    }
}
