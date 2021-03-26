package com.xiaomi.push;

import android.content.Context;

final class dg implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;

    dg(Context context, String str, int i, String str2) {
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        df.b(this.a, this.b, this.c, this.d);
    }
}
