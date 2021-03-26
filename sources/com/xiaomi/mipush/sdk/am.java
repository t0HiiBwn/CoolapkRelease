package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

final class am implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f122a;

    am(Context context, Intent intent) {
        this.a = context;
        this.f122a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.a, this.f122a);
    }
}
