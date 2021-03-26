package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tpns.mqttchannel.core.a.a;
import com.tencent.tpns.mqttchannel.core.common.b.b;

/* compiled from: ProGuard */
public abstract class BaseMqttClientService extends Service {
    private b.a a;

    public abstract void onConnectComplete(boolean z);

    public abstract void onConnectionLost();

    public abstract void onHeartBeat();

    public abstract void onMessageArrived(String str, String str2);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = new a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }
}
