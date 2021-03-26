package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;

class z implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0156a a;

    z(MiTinyDataClient.a.C0156a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.f135a.size() != 0) {
            this.a.b();
        } else if (MiTinyDataClient.a.C0156a.a(this.a) != null) {
            MiTinyDataClient.a.C0156a.a(this.a).cancel(false);
            this.a.f136a = null;
        }
    }
}
