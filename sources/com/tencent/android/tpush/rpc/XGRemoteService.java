package com.tencent.android.tpush.rpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.service.b;

/* compiled from: ProGuard */
public class XGRemoteService extends Service {
    private a.AbstractBinderC0132a a = new d();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b.b(getApplicationContext());
        return this.a;
    }
}
