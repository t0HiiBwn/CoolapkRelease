package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

class bg implements ServiceConnection {
    final /* synthetic */ be a;

    bg(be beVar) {
        this.a = beVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            be.a(this.a, new Messenger(iBinder));
            be.a(this.a, false);
            for (Message message : be.a(this.a)) {
                try {
                    be.a(this.a).send(message);
                } catch (RemoteException e) {
                    b.a(e);
                }
            }
            be.a(this.a).clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        be.a(this.a, (Messenger) null);
        be.a(this.a, false);
    }
}
