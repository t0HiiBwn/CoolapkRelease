package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;

class ae implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0184a a;

    ae(MiTinyDataClient.a.C0184a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.f113a.size() != 0) {
            this.a.b();
        } else if (MiTinyDataClient.a.C0184a.a(this.a) != null) {
            MiTinyDataClient.a.C0184a.a(this.a).cancel(false);
            this.a.f114a = null;
        }
    }
}
