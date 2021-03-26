package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

class bu extends Handler {
    final /* synthetic */ XMPushService a;

    bu(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            try {
                int i = message.what;
                if (i != 17) {
                    if (i == 18) {
                        Message obtain = Message.obtain((Handler) null, 0);
                        obtain.what = 18;
                        Bundle bundle = new Bundle();
                        bundle.putString("xmsf_region", XMPushService.a(this.a));
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    }
                } else if (message.obj != null) {
                    this.a.onStart((Intent) message.obj, 1);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
