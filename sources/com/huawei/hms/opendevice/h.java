package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: RemoteService */
public class h {
    private ServiceConnection a;
    private Messenger b = null;

    public boolean a(Context context, final Bundle bundle, Intent intent) {
        final Context applicationContext = context.getApplicationContext();
        this.a = new ServiceConnection() {
            /* class com.huawei.hms.opendevice.h.AnonymousClass1 */

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("RemoteService", "remote service onConnected");
                h.this.b = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                try {
                    h.this.b.send(obtain);
                } catch (RemoteException unused) {
                    HMSLog.i("RemoteService", "remote service message send failed");
                }
                HMSLog.i("RemoteService", "remote service unbindservice");
                applicationContext.unbindService(h.this.a);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("RemoteService", "remote service onDisconnected");
                h.this.b = null;
            }
        };
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.a, 1);
    }
}
