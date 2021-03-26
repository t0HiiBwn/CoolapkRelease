package com.xiaomi.push.service.receivers;

import android.content.Context;

class a implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f1037a;

    a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f1037a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1037a.a(this.a);
    }
}
