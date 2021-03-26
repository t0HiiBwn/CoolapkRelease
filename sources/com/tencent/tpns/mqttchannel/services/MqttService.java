package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.mqttchannel.core.b.b;
import com.tencent.tpns.mqttchannel.core.common.c.a;

/* compiled from: ProGuard */
public class MqttService extends Service {
    private b a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a.b("MqttService", "onBind: ");
        return this.a.a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            if (!XGApiConfig.isEnableService(this)) {
                a.b("MqttService", "MqttService onCreate  ");
                stopSelf();
                Process.killProcess(Process.myPid());
                return;
            }
        } catch (Throwable unused) {
            a.b("MqttService", "unexpected for MqttService");
        }
        boolean checkTpnsSecurityLibSo = Security.checkTpnsSecurityLibSo(this);
        a.b("MqttService", "MqttService onCreate load lib: " + checkTpnsSecurityLibSo);
        this.a = new b(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.b("MqttService", "onDestroy: ");
        super.onDestroy();
    }
}
