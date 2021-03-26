package com.tencent.android.tpush.service.c;

import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class b {
    private static volatile boolean a = true;
    private static volatile boolean b = true;
    private long c;

    /* renamed from: com.tencent.android.tpush.service.c.b$b  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    private interface AbstractC0136b {
        void a();

        void a(int i, String str);
    }

    /* compiled from: ProGuard */
    public static class c {
        public static b a = new b();
    }

    static /* synthetic */ long a(b bVar) {
        long j = bVar.c;
        bVar.c = 1 + j;
        return j;
    }

    private b() {
        this.c = b();
    }

    private long b() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + ((long) (Process.myPid() % 1000))) * 1000;
    }

    public static b a() {
        return c.a;
    }

    public void a(final Context context, final d dVar, final a aVar) {
        a(context, new AbstractC0136b() {
            /* class com.tencent.android.tpush.service.c.b.AnonymousClass1 */

            @Override // com.tencent.android.tpush.service.c.b.AbstractC0136b
            public void a() {
                try {
                    MqttChannel.getInstance(context).sendRequest(dVar.a().getStr(), dVar.a(context), new a(context, aVar, dVar));
                } catch (Throwable th) {
                    TLogger.ee("XGMqttChannel", "sendMessage throwable: ", th);
                    ServiceStat.reportErrCode(context, -101, "sendMessage request error", 0, dVar.a().getStr());
                    aVar.b(-101, "sendMessage request error", dVar);
                }
            }

            @Override // com.tencent.android.tpush.service.c.b.AbstractC0136b
            public void a(int i, String str) {
                aVar.b(i, str, dVar);
                b.b(context, i, str, 0, dVar);
            }
        });
    }

    public void b(final Context context, final d dVar, final a aVar) {
        a(context, new AbstractC0136b() {
            /* class com.tencent.android.tpush.service.c.b.AnonymousClass2 */

            @Override // com.tencent.android.tpush.service.c.b.AbstractC0136b
            public void a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", b.a(b.this));
                    jSONObject.put("cmd", dVar.a().getStr());
                    jSONObject.put("params", dVar.a(context));
                    MqttChannel.getInstance(context).sendPublishData("_xg/device/statistics", jSONObject.toString(), new a(context, aVar, dVar));
                } catch (Throwable th) {
                    TLogger.ee("XGMqttChannel", "sendStatMsg throwable: ", th);
                    aVar.b(-101, "sendStatMsg request error", dVar);
                }
            }

            @Override // com.tencent.android.tpush.service.c.b.AbstractC0136b
            public void a(int i, String str) {
                aVar.b(i, str, dVar);
            }
        });
    }

    /* compiled from: ProGuard */
    static class a extends OnMqttCallback {
        private a a;
        private d b;
        private Context c;

        a(Context context, a aVar, d dVar) {
            this.c = context.getApplicationContext();
            this.a = aVar;
            this.b = dVar;
        }

        @Override // com.tencent.tpns.mqttchannel.core.a.b
        public void callback(int i, String str) {
            if (i >= 0) {
                this.a.a(i, str, this.b);
            } else {
                this.a.b(i, str, this.b);
            }
            b.b(this.c, i, str, this.requestId, this.b);
        }
    }

    private void a(final Context context, final AbstractC0136b bVar) {
        TLogger.d("XGMqttChannel", "doActionWhenConnected");
        if (!Util.isNullOrEmptyString(GuidInfoManager.getToken(context))) {
            bVar.a();
        } else {
            MqttChannel.getInstance(context).getConnectState(new OnMqttCallback() {
                /* class com.tencent.android.tpush.service.c.b.AnonymousClass3 */

                @Override // com.tencent.tpns.mqttchannel.core.a.b
                public void callback(int i, String str) {
                    if (i == 0 && (MqttConnectState.valueOf(str) == MqttConnectState.CONNECTED || MqttConnectState.valueOf(str) == MqttConnectState.SUBTOPICS)) {
                        bVar.a();
                    } else {
                        MqttChannel.getInstance(context).startConnect(new OnMqttCallback() {
                            /* class com.tencent.android.tpush.service.c.b.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.tpns.mqttchannel.core.a.b
                            public void callback(int i, String str) {
                                if (i == 0) {
                                    bVar.a();
                                    return;
                                }
                                AbstractC0136b bVar = bVar;
                                bVar.a(i, "mqtt connect error:" + str);
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, int i, String str, long j, d dVar) {
        if (i == 0) {
            a = true;
        } else if (i == -1103) {
            try {
                if (a) {
                    a = false;
                    ServiceStat.reportErrCode(context, i, str, j, dVar.a().getStr());
                }
            } catch (Throwable th) {
                TLogger.e("XGMqttChannel", "handleErrCodeReport error: " + th.getMessage());
            }
        } else {
            if (i != -3) {
                if (i != -4) {
                    if (i <= 1010000 || i >= 1011000) {
                        ServiceStat.reportErrCode(context, i, str, j, dVar.a().getStr());
                        return;
                    }
                    return;
                }
            }
            if (b) {
                b = false;
                ServiceStat.reportErrCode(context, i, str, j, dVar.a().getStr());
            }
        }
    }
}
