package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.gm;

class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0184a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ gm f118a;

    ad(MiTinyDataClient.a.C0184a aVar, gm gmVar) {
        this.a = aVar;
        this.f118a = gmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f113a.add(this.f118a);
        MiTinyDataClient.a.C0184a.a(this.a);
    }
}
