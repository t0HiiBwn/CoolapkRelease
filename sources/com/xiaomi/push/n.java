package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.m;

class n extends Handler {
    final /* synthetic */ m a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(m mVar, Looper looper) {
        super(looper);
        this.a = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m.b bVar = (m.b) message.obj;
        if (message.what == 0) {
            bVar.a();
        } else if (message.what == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
