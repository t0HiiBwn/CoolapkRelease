package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hg;

class y implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0156a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hg f180a;

    y(MiTinyDataClient.a.C0156a aVar, hg hgVar) {
        this.a = aVar;
        this.f180a = hgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f135a.add(this.f180a);
        MiTinyDataClient.a.C0156a.a(this.a);
    }
}
