package com.xiaomi.mipush.sdk;

import android.content.Context;

final class x implements Runnable {
    final /* synthetic */ Context a;

    x(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.a);
    }
}
