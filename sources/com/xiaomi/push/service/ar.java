package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.a.a.a.c;

class ar implements ServiceConnection {
    final /* synthetic */ XMPushService a;

    ar(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c.b("onServiceConnected " + iBinder);
        Service a2 = XMJobService.a();
        if (a2 != null) {
            this.a.startForeground(XMPushService.l, XMPushService.a((Context) this.a));
            a2.startForeground(XMPushService.l, XMPushService.a((Context) this.a));
            a2.stopForeground(true);
            this.a.unbindService(this);
            return;
        }
        c.a("XMService connected but innerService is null " + iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
