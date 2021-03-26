package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.aa;
import com.xiaomi.push.service.x;

class as extends ContentObserver {
    final /* synthetic */ aq a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    as(aq aqVar, Handler handler) {
        super(handler);
        this.a = aqVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        aq aqVar = this.a;
        aqVar.f133a = Integer.valueOf(x.a(aq.a(aqVar)).b());
        if (aq.a(this.a).intValue() != 0) {
            aq.a(this.a).getContentResolver().unregisterContentObserver(this);
            if (aa.c(aq.a(this.a))) {
                this.a.m51c();
            }
        }
    }
}
