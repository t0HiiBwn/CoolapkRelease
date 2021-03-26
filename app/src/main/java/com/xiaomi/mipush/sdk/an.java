package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

class an implements ServiceConnection {
    final /* synthetic */ ak a;

    an(ak akVar) {
        this.a = akVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            this.a.f150a = new Messenger(iBinder);
            this.a.c = false;
            for (Message message : ak.a(this.a)) {
                try {
                    ak.a(this.a).send(message);
                } catch (RemoteException e) {
                    b.a(e);
                }
            }
            ak.a(this.a).clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f150a = null;
        this.a.c = false;
    }
}
