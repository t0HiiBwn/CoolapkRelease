package com.tencent.android.tpush.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.a;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.k;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: ProGuard */
public class XGVipPushService extends BaseMqttClientService {
    private static volatile String b = null;
    private static long c = 0;
    private static JSONArray d = null;
    private static long e = 270000;
    private static Service f;
    Runnable a = new Runnable() {
        /* class com.tencent.android.tpush.service.XGVipPushService.AnonymousClass2 */

        @Override // java.lang.Runnable
        public void run() {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.service.XGVipPushService.AnonymousClass2.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    TLogger.d("XGVipPushService", "--CheckMessage--interval time:" + XGVipPushService.e);
                    a.b(XGVipPushService.this);
                    if (MqttConfigImpl.getKeepAliveInterval(XGVipPushService.this.getApplicationContext()) >= 285) {
                        if (DeviceInfos.isScreenOn(XGVipPushService.this.getApplicationContext())) {
                            long unused = XGVipPushService.e = 120000;
                        } else {
                            long unused2 = XGVipPushService.e = 270000;
                        }
                        if (XGVipPushService.this.g != null && XGVipPushService.this.a != null) {
                            XGVipPushService.this.g.postDelayed(XGVipPushService.this.a, XGVipPushService.e);
                        }
                    }
                }
            });
        }
    };
    private Handler g;
    private boolean h = false;
    private com.tencent.android.tpush.service.channel.a i = new com.tencent.android.tpush.service.channel.a();
    private boolean j = false;

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onConnectComplete(boolean z) {
        TLogger.ii("XGVipPushService", "onConnectComplete isReconnect:" + z);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onConnectionLost() {
        TLogger.ii("XGVipPushService", "onConnectionLost");
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onHeartBeat() {
        TLogger.ii("XGVipPushService", "heartBeat");
        a.b(this);
        f.d(this);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onMessageArrived(String str, String str2) {
        TLogger.ii("XGVipPushService", "onMessageArrived: topic:" + str + ", message:" + str2);
        if (j.b(this, str)) {
            try {
                k kVar = new k();
                kVar.a(str2);
                com.tencent.android.tpush.service.b.a.a().a(kVar.b, kVar.a, this.i);
            } catch (JSONException e2) {
                TLogger.ee("XGVipPushService", "decode push msg fail", e2);
                ServiceStat.reportErrCode(this, -101, "onMessageArrived:" + str2, 0, "inner");
            }
        }
    }

    private void c() {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.service.XGVipPushService.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                Context applicationContext = XGVipPushService.this.getApplicationContext();
                boolean z = false;
                if (PushPreferences.getInt(applicationContext, "com.tencent.android.tpush.debug," + XGVipPushService.this.getApplicationContext().getPackageName(), 0) == 1) {
                    z = true;
                }
                XGPushConfig.enableDebug = true;
                TLogger.enableDebug(XGVipPushService.this.getApplicationContext(), z);
                Context applicationContext2 = XGVipPushService.this.getApplicationContext();
                TBaseLogger.setDebugLevel(PushPreferences.getInt(applicationContext2, "com.tencent.android.tpush.log_level," + XGVipPushService.this.getApplicationContext().getPackageName(), -1));
            }
        });
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public void onCreate() {
        super.onCreate();
        c = System.currentTimeMillis();
        f = this;
        Context applicationContext = getApplicationContext();
        b.b(applicationContext);
        ServiceStat.init(applicationContext);
        MqttChannel.getInstance(this).startConnect(null);
        a.a().b(applicationContext);
        c();
        TLogger.ii("XGVipPushService", "Service onCreate() : " + getPackageName());
        if (j.a(getApplicationContext()) > 0) {
            f.e(getApplicationContext());
        }
        d();
    }

    private void d() {
        TLogger.d("XGVipPushService", "action - initCheckMessageHandler, on 60s later");
        Handler handler = new Handler();
        this.g = handler;
        handler.postDelayed(this.a, 60000);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        TLogger.i("XGVipPushService", "Service onStart() : " + getPackageName());
        super.onStart(intent, i2);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public IBinder onBind(Intent intent) {
        TLogger.ii("XGVipPushService", "Service onBind()");
        if (!this.h) {
            a(intent, "onBind");
            this.h = true;
        }
        return super.onBind(intent);
    }

    public static Service a() {
        return f;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        TLogger.ii("XGVipPushService", "Service onStartCommand() : " + getPackageName());
        super.onStartCommand(intent, 1, i3);
        a(intent, "onStartCommand");
        return 1;
    }

    private synchronized void a(Intent intent, String str) {
        JSONArray jSONArray;
        TLogger.d("XGVipPushService", "initServiceHandler with method : " + str);
        try {
            if (j.a(getApplicationContext()) > 0) {
                TLogger.ee("XGVipPushService", "initGlobal error");
                f.e(getApplicationContext());
                return;
            }
            if (intent != null) {
                if (d == null) {
                    d = new JSONArray();
                }
                String action = intent.getAction();
                if (!j.b(action) && (jSONArray = d) != null && jSONArray.length() < 10) {
                    try {
                        action = action.replace("com.tencent.android.tpush.action", "");
                    } catch (Throwable th) {
                        TLogger.w("XGVipPushService", "unexpected for initServiceHandler:" + th.getMessage());
                    }
                    d.put(action);
                }
            }
            c();
            b.b().a(intent);
        } catch (Throwable th2) {
            TLogger.e("XGVipPushService", "initServiceHandler", th2);
        }
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public void onDestroy() {
        b.b().c();
        TLogger.flush();
        super.onDestroy();
    }
}
