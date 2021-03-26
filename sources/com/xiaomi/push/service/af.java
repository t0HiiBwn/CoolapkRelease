package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.a.a.a.c;

class af implements ServiceConnection {
    final /* synthetic */ ad a;

    af(ad adVar) {
        this.a = adVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            ad.a(this.a, new Messenger(iBinder));
            ad.a(this.a, false);
            for (Message message : ad.a(this.a)) {
                try {
                    ad.b(this.a).send(message);
                } catch (RemoteException e) {
                    c.a(e);
                }
            }
            ad.a(this.a).clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ad.a(this.a, (Messenger) null);
        ad.a(this.a, false);
    }
}
