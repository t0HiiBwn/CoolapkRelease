package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.a.a.a.c;

class at implements ServiceConnection {
    final /* synthetic */ aq a;

    at(aq aqVar) {
        this.a = aqVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            this.a.f132a = new Messenger(iBinder);
            this.a.c = false;
            for (Message message : aq.a(this.a)) {
                try {
                    aq.a(this.a).send(message);
                } catch (RemoteException e) {
                    c.a(e);
                }
            }
            aq.a(this.a).clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f132a = null;
        this.a.c = false;
    }
}
