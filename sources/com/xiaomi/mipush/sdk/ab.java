package com.xiaomi.mipush.sdk;

import android.content.Context;

final class ab implements Runnable {
    final /* synthetic */ Context a;

    ab(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.a(this.a);
    }
}
