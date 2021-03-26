package com.tencent.tpns.mqttchannel.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.IMqttChannel;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.b.c;
import com.tencent.tpns.mqttchannel.services.MqttService;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c implements IMqttChannel {
    private Context a;
    private Intent b = null;
    private Boolean c = false;
    private volatile long d = a();
    private ServiceConnection e = null;

    /* compiled from: ProGuard */
    private interface a {
        void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void bindAccount(String str, OnMqttCallback onMqttCallback) {
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unBindAccount(OnMqttCallback onMqttCallback) {
    }

    public c(Context context) {
        this.a = context.getApplicationContext();
        this.b = new Intent(this.a, MqttService.class);
    }

    private long a() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + ((long) (Process.myPid() % 1000))) * 1000;
    }

    private void a(final a aVar, final String str, final OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - doConnect, actionName:" + str);
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1 */
            com.tencent.tpns.mqttchannel.core.common.b.c a = null;
            private ServiceConnection f = new ServiceConnection() {
                /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.AnonymousClass1 */

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "doConnect - onServiceConnected");
                    AnonymousClass1.this.a = c.a.a(iBinder);
                    try {
                        if (AnonymousClass1.this.a != null) {
                            CommonWorkingThread.getInstance().execute(new Runnable() {
                                /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        aVar.a(AnonymousClass1.this.a);
                                    } catch (Throwable th) {
                                        com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", str + "connectAction.action error:", th);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        c.this.a.unbindService(this);
                        throw th;
                    }
                    c.this.a.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass1.this.a = null;
                    AnonymousClass1.this.f = null;
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean bindService = c.this.a.bindService(c.this.b, this.f, 1);
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "actionName:" + str + " bind MqttService:" + bindService);
                } catch (Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", str + " -> bindService", th);
                    OnMqttCallback onMqttCallback = onMqttCallback;
                    if (onMqttCallback != null) {
                        onMqttCallback.handleCallback(-1, str + " error: bindService Error: " + th);
                    }
                }
            }
        });
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void startConnect(final OnMqttCallback onMqttCallback) {
        try {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - startConnect, start MqttService");
            this.a.startService(this.b);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th);
        }
        if (!this.c.booleanValue()) {
            try {
                AnonymousClass4 r1 = new ServiceConnection() {
                    /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass4 */

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.e = r1;
                this.c = Boolean.valueOf(this.a.bindService(this.b, r1, 1));
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th2);
            }
        }
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass5 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                if (cVar != null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "doConnect action on startConnect");
                    cVar.a(onMqttCallback);
                }
            }
        }, "startConnect", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void ping(final OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - ping");
        try {
            this.a.startService(this.b);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th);
            Util.stopWakeCpu();
        }
        if (!this.c.booleanValue()) {
            try {
                AnonymousClass6 r1 = new ServiceConnection() {
                    /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass6 */

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.e = r1;
                this.c = Boolean.valueOf(this.a.bindService(this.b, r1, 1));
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th2);
                Util.stopWakeCpu();
            }
        }
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass7 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "ping doConnect action");
                if (cVar != null) {
                    cVar.d(onMqttCallback);
                } else {
                    Util.stopWakeCpu();
                }
            }
        }, "ping", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void stopConnect(final OnMqttCallback onMqttCallback) {
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass8 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                if (cVar != null) {
                    cVar.b(onMqttCallback);
                }
            }
        }, "stopConnect", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void getConnectState(final OnMqttCallback onMqttCallback) {
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass9 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                if (cVar != null) {
                    cVar.c(onMqttCallback);
                }
            }
        }, "getConnectState", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendRequest(String str, JSONObject jSONObject, final OnMqttCallback onMqttCallback) {
        if (jSONObject != null) {
            long j = this.d + 1;
            this.d = j;
            onMqttCallback.requestId = j;
            final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(j, str, jSONObject.toString());
            aVar.a = 6;
            a(new a() {
                /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass10 */

                @Override // com.tencent.tpns.mqttchannel.core.a.c.a
                public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                    if (cVar != null) {
                        cVar.a(aVar, onMqttCallback);
                    }
                }
            }, "sendRequest", onMqttCallback);
        } else if (onMqttCallback != null) {
            onMqttCallback.handleCallback(-101, "sendRequest jsonParm not alow to null");
        }
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendPublishData(String str, String str2, final OnMqttCallback onMqttCallback) {
        if (str2 != null) {
            long j = this.d + 1;
            this.d = j;
            final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(j, str, str2);
            aVar.a = 5;
            a(new a() {
                /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass11 */

                @Override // com.tencent.tpns.mqttchannel.core.a.c.a
                public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                    if (cVar != null) {
                        cVar.b(aVar, onMqttCallback);
                    }
                }
            }, "sendPublishData", onMqttCallback);
        } else if (onMqttCallback != null) {
            onMqttCallback.handleCallback(-101, "sendPublishData content not alow to null");
        }
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void subscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j = this.d + 1;
        this.d = j;
        final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(j, str, null);
        aVar.a = 1;
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass2 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                if (cVar != null) {
                    cVar.c(aVar, onMqttCallback);
                }
            }
        }, "subscrbie", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unSubscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j = this.d + 1;
        this.d = j;
        final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(j, str, null);
        aVar.a = 3;
        a(new a() {
            /* class com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass3 */

            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.c cVar) {
                if (cVar != null) {
                    cVar.d(aVar, onMqttCallback);
                }
            }
        }, "unSubscrbie", onMqttCallback);
    }
}
