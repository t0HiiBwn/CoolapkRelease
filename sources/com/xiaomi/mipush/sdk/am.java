package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bc;
import com.xiaomi.push.service.az;

class am extends ContentObserver {
    final /* synthetic */ ak a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    am(ak akVar, Handler handler) {
        super(handler);
        this.a = akVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ak akVar = this.a;
        akVar.f151a = Integer.valueOf(az.a(ak.a(akVar)).a());
        if (ak.a(this.a).intValue() != 0) {
            ak.a(this.a).getContentResolver().unregisterContentObserver(this);
            if (bc.b(ak.a(this.a))) {
                this.a.m72c();
            }
        }
    }
}
