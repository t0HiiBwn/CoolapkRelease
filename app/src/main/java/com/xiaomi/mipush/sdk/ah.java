package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

final class ah implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f142a;

    ah(Context context, Intent intent) {
        this.a = context;
        this.f142a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.a, this.f142a);
    }
}
