package com.tencent.tpns.mqttchannel.core.b;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttDeliveryToken;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.persist.MemoryPersistence;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.DNSResolver;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.b.b;
import com.tencent.tpns.mqttchannel.core.common.b.c;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends c.a implements MqttCallbackExtended {
    private static long b = System.currentTimeMillis();
    private static boolean c = true;
    private static ExecutorService d = Executors.newSingleThreadExecutor();
    private static ConcurrentHashMap<Long, com.tencent.tpns.mqttchannel.core.common.b.a> u = new ConcurrentHashMap<>();
    private ReentrantLock A = new ReentrantLock();
    ReentrantLock a = new ReentrantLock();
    private volatile MqttAsyncClient e = null;
    private volatile MqttConnectState f = MqttConnectState.DISCONNECTED;
    private volatile int g = 0;
    private volatile int h = 0;
    private volatile int i = 0;
    private Context j;
    private Map<Long, Pair<com.tencent.tpns.mqttchannel.core.common.b.a, Runnable>> k = new ConcurrentHashMap();
    private boolean l;
    private Class m = null;
    private Handler n = null;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private volatile int r;
    private volatile int s;
    private List<com.tencent.tpns.mqttchannel.core.common.b.a> t = new CopyOnWriteArrayList();
    private Queue<com.tencent.tpns.mqttchannel.core.common.a.a> v = new ConcurrentLinkedQueue();
    private long w = 0;
    private c x = null;
    private ReentrantLock y = new ReentrantLock();
    private volatile boolean z = false;

    /* renamed from: com.tencent.tpns.mqttchannel.core.b.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    private interface AbstractC0161a {
        void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar);
    }

    /* compiled from: ProGuard */
    public enum b {
        CONNECTED,
        CONNECTING,
        IDLE,
        STOPED,
        UNKNOWN
    }

    static /* synthetic */ int q(a aVar) {
        int i2 = aVar.h;
        aVar.h = i2 + 1;
        return i2;
    }

    a(Context context) {
        this.j = context;
        this.l = a(context);
        this.o = GuidInfoManager.isServerDestroy(context);
        d();
        this.q = CloudManager.getInstance(context).isCloudRefuse();
        this.r = GuidInfoManager.getEncryptLevel(context);
        com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.r + ", compressLevel: " + this.s);
        if (this.n == null) {
            m();
        }
        f();
    }

    private synchronized void e(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        if (this.t.size() > 100) {
            this.t.remove(0);
        }
        this.t.add(aVar);
    }

    private synchronized void b() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - callAllConnectBackSuccess");
        if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(GuidInfoManager.getToken(this.j))) {
            for (com.tencent.tpns.mqttchannel.core.common.b.a aVar : this.t) {
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "callAllBackSucess");
                a(aVar, 0, "success");
            }
        } else {
            c();
        }
        this.t.clear();
    }

    private synchronized void c() {
        for (com.tencent.tpns.mqttchannel.core.common.b.a aVar : this.t) {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "callAllConnectBackFailed");
            a(aVar, -102, "connect failed beacuse token is null");
        }
    }

    private static void a(Long l2, com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        try {
            if (u.size() > 2000) {
                ArrayList arrayList = new ArrayList(u.keySet());
                Collections.sort(arrayList);
                u.remove(arrayList.get(0));
            }
            u.put(l2, aVar);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "putTagAliasCallback", th);
        }
    }

    private static com.tencent.tpns.mqttchannel.core.common.b.a a(Long l2) {
        try {
            return u.remove(l2);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "getTagAliasCallback", th);
            return null;
        }
    }

    private com.tencent.tpns.mqttchannel.core.common.b.a b(Long l2) {
        boolean z2 = false;
        try {
            Iterator<com.tencent.tpns.mqttchannel.core.common.a.a> it2 = this.v.iterator();
            while (it2.hasNext()) {
                if (l2.longValue() == it2.next().a()) {
                    it2.remove();
                    z2 = true;
                }
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "removeCacheMessages", th);
        }
        if (!z2) {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "removeCacheMessages error id " + l2);
        }
        return a(l2);
    }

    private void e(com.tencent.tpns.mqttchannel.core.common.a.a aVar, com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "addCacheMessage " + aVar);
        try {
            this.v.offer(aVar);
            if (this.v.size() > 100) {
                this.v.poll();
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "addCacheMessage", th);
        }
        if (aVar.a() > 0 && aVar2 != null) {
            a(Long.valueOf(aVar.a()), aVar2);
        }
    }

    private com.tencent.tpns.mqttchannel.core.common.a.a c(Long l2) {
        for (com.tencent.tpns.mqttchannel.core.common.a.a aVar : this.v) {
            if (l2.longValue() == aVar.a()) {
                return aVar;
            }
        }
        return null;
    }

    private void d() {
        int refuseRate = GuidInfoManager.getRefuseRate(this.j);
        if (refuseRate <= 0 || new Random().nextInt(100) >= refuseRate) {
            this.p = false;
            return;
        }
        this.p = true;
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Resources exceeded Limit, refuse this connect!");
    }

    private boolean a(Context context) {
        try {
            this.m = Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            Intent intent = new Intent(context, this.m);
            intent.setPackage(context.getPackageName());
            try {
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 512);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, querey intent info is null or empty");
                    return false;
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Has Xgpush!!!");
                return true;
            } catch (Throwable unused) {
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, querey intent fail");
                return false;
            }
        } catch (Throwable unused2) {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, Not found xgpush class");
            return false;
        }
    }

    private b e() {
        if (this.e == null) {
            return b.IDLE;
        }
        if (this.e.isConnected() && (this.f == MqttConnectState.CONNECTED || this.f == MqttConnectState.SUBTOPICS)) {
            return b.CONNECTED;
        }
        if (this.e.isConnecting()) {
            return b.CONNECTING;
        }
        return b.STOPED;
    }

    private void f() {
        try {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "ping starRtc at " + MqttConfigImpl.getKeepAliveInterval(this.j));
            Intent intent = new Intent("com.tencent.android.xg.vip.action.ACTION_SDK_KEEPALIVE");
            intent.setPackage(this.j.getPackageName());
            TPushAlarmManager.getAlarmManager(this.j).set(0, System.currentTimeMillis() + ((long) (MqttConfigImpl.getKeepAliveInterval(this.j) * 1000)), PendingIntent.getBroadcast(this.j, 0, intent, 134217728), XGApiConfig.isPowerSaveMode(this.j));
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Alarm started with interval: " + MqttConfigImpl.getKeepAliveInterval(this.j));
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Alarm started failed ", th);
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void d(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        g();
    }

    private void g() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - ping");
        try {
            int i2 = AnonymousClass11.a[e().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                    Util.stopWakeCpu();
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "The client is connecting");
                Util.stopWakeCpu();
            } else if (Math.abs(System.currentTimeMillis() - this.w) >= 15000) {
                h();
                a();
                this.e.ping(new IMqttActionListener() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass1 */

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        a.this.i();
                        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Ping succeed");
                        a.this.w = System.currentTimeMillis();
                        Util.stopWakeCpu();
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Ping onFailure", th);
                        a.this.i();
                        a.this.p();
                    }
                });
            }
        } catch (Throwable th) {
            i();
            Util.stopWakeCpu();
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "ping", th);
        }
    }

    /* renamed from: com.tencent.tpns.mqttchannel.core.b.a$11  reason: invalid class name */
    /* compiled from: ProGuard */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void h() {
        this.n.removeMessages(1006);
        this.n.sendEmptyMessageDelayed(1006, 10000);
    }

    /* access modifiers changed from: private */
    public void i() {
        this.n.removeMessages(1006);
    }

    /* access modifiers changed from: private */
    public void f(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        g(aVar);
    }

    private void g(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        String str = "restartLock unlock Exception";
        String str2 = "IMqttServiceImpl";
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action:restartConnectThread");
        this.y.lock();
        try {
            if (e() == b.CONNECTED) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action:restartConnectThread - CONNECTED");
                if (aVar != null) {
                    a(aVar, 0, "success");
                }
            } else {
                c cVar = this.x;
                if (cVar == null) {
                    try {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action:restartConnectThread in null thread");
                        c cVar2 = new c(aVar);
                        this.x = cVar2;
                        cVar2.start();
                        if (aVar != null) {
                            e(aVar);
                        }
                    } catch (Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "null mThread", th);
                    }
                } else if (cVar.isAlive() || o()) {
                    c cVar3 = this.x;
                    if (cVar3 != null && cVar3.isAlive()) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "The Thread is  isAlive and isRuning " + o() + " mqtt status " + e() + " just waiting for connecting");
                        try {
                            Thread.sleep(500);
                        } catch (Throwable th2) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Thread sleep error", th2);
                        }
                        if (!o()) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "The Thread is  isAlive and isRuning " + o() + " mThread.isAlive() " + this.x.isAlive() + " getMQTTStatus() " + e());
                            try {
                                this.x.interrupt();
                            } catch (Throwable th3) {
                                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "!mThread.iinterrupt", th3);
                            }
                            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "The Thread interrupt");
                            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "The new MQTTThread running");
                            c cVar4 = new c(aVar);
                            this.x = cVar4;
                            cVar4.start();
                        }
                        if (aVar != null) {
                            e(aVar);
                        }
                    } else if (o()) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "The Thread is still waiting for connecting call back " + o() + " mThread.isAlive() " + this.x.isAlive() + " getMQTTStatus() " + e());
                        if (aVar != null) {
                            e(aVar);
                        }
                    } else {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "restartConnectThread - unknown status isRunningFlag " + o() + " mThread.isAlive() " + this.x.isAlive() + " getMQTTStatus() " + e());
                    }
                } else {
                    try {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action:restartConnectThread is not isAlive");
                        this.x.join();
                        c cVar5 = new c(aVar);
                        this.x = cVar5;
                        cVar5.start();
                        if (aVar != null) {
                            e(aVar);
                        }
                    } catch (Throwable th4) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "!mThread.isAlive()", th4);
                    }
                }
            }
        } finally {
            try {
                this.y.unlock();
            } catch (Exception unused) {
                com.tencent.tpns.mqttchannel.core.common.c.a.d(str2, str);
            }
        }
    }

    /* compiled from: ProGuard */
    private class c extends Thread {
        com.tencent.tpns.mqttchannel.core.common.b.a a;

        c(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "doMqttConnect -> try connect, state: " + a.this.f);
            if (a.this.f == MqttConnectState.CONNECTED || a.this.f == MqttConnectState.SUBTOPICS) {
                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt already connected, give up");
                com.tencent.tpns.mqttchannel.core.common.b.a aVar = this.a;
                if (aVar != null) {
                    a.this.a(aVar, 0, "success");
                }
            } else if (a.this.o()) {
                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt is connecting, give up");
            } else {
                a.this.a.lock();
                a.this.a(true);
                if (a.this.o || a.this.p || a.this.q) {
                    a.this.i(this.a);
                    a.this.f = MqttConnectState.CONNECTFAIL;
                    a.this.a(false);
                    a.this.a.unlock();
                    return;
                }
                a.this.f = MqttConnectState.CONNECTING;
                GUIDInfo a2 = a();
                if (a2 == null || a2.isError()) {
                    if (a2 == null) {
                        a.this.a(this.a, -5, "getFinalMqttServerAddrAndGuidInfo GUID is null");
                    } else {
                        a.this.a(this.a, a2.errCode, a2.result);
                    }
                    a.this.f = MqttConnectState.CONNECTFAIL;
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "doMqttConnect -> connecting falied with null guid  ");
                    a.this.a(false);
                    a.this.a.unlock();
                    return;
                }
                a.this.r = a2.encrypt;
                a aVar2 = a.this;
                aVar2.s = CloudManager.getInstance(aVar2.j).getCompressLevel();
                com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "update encryptLevel: " + a.this.r + ", compressLevel: " + a.this.s);
                String str = a2.mqttServerIP;
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Finally get finalMqttServerAddr = " + str + "");
                if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(XGApiConfig.getDebugMQTTServer(a.this.j))) {
                    str = XGApiConfig.getDebugMQTTServer(a.this.j);
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "doMqttConnect -> connecting host: " + str + ", state: " + a.this.f);
                try {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Mqtt clientId: " + a2.token);
                    if (a.this.e != null) {
                        try {
                            a.this.b((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                        } catch (Throwable th) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "unexpected for release mqttAsyncClient" + th.getMessage());
                        }
                    }
                    a.this.e = new MqttAsyncClient(str, a2.token, new MemoryPersistence(), null);
                    MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
                    mqttConnectOptions.setAutomaticReconnect(false);
                    mqttConnectOptions.setCleanSession(true);
                    mqttConnectOptions.setUserName(a2.userName);
                    if (a2.passWord != null) {
                        mqttConnectOptions.setPassword(a2.passWord.toCharArray());
                    }
                    mqttConnectOptions.setKeepAliveInterval(MqttConfigImpl.getKeepAliveInterval(a.this.j));
                    try {
                        a.this.e.setCallback(a.this);
                        a.this.e.connect(mqttConnectOptions, null, new IMqttActionListener() {
                            /* class com.tencent.tpns.mqttchannel.core.b.a.c.AnonymousClass1 */

                            @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                            public void onSuccess(IMqttToken iMqttToken) {
                                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "doMqttConnect -> callback onSuccess");
                                a.this.f = MqttConnectState.CONNECTED;
                                a.this.a(false);
                                a.this.l();
                                a.this.g = 0;
                                a.this.a(c.this.a, 0, "success");
                                a.this.h(c.this.a);
                            }

                            @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                            public void onFailure(IMqttToken iMqttToken, Throwable th) {
                                a.this.a(false);
                                a.this.b((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                                a.this.f = MqttConnectState.CONNECTFAIL;
                                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "doMqttConnect -> callback onFailure:", th);
                                GuidInfoManager.forceExpired(a.this.j);
                                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "Set guid to expired");
                                a aVar = a.this;
                                com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = c.this.a;
                                aVar.a(aVar2, -11, "connect onFailure: " + th.toString());
                                a.this.k();
                                a.this.h(c.this.a);
                            }
                        });
                    } catch (Throwable th2) {
                        a.this.a.unlock();
                        throw th2;
                    }
                    a.this.a.unlock();
                } catch (Throwable th3) {
                    a.this.a(false);
                    a.this.a.unlock();
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "create mqtt client error, e:" + th3.toString(), th3);
                    a.this.f = MqttConnectState.CONNECTFAIL;
                    a aVar3 = a.this;
                    com.tencent.tpns.mqttchannel.core.common.b.a aVar4 = this.a;
                    aVar3.a(aVar4, -1102, "create mqtt client error " + th3);
                }
            }
        }

        private GUIDInfo a() {
            GUIDInfo gUIDInfo;
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "getFinalMqttServerAddrAndGuidInfo");
            GUIDInfo gUIDInfo2 = new GUIDInfo();
            if (GuidInfoManager.isServerDestroy(a.this.j)) {
                com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "getFinalMqttServerAddrAndGuidInfo: Resources have been destroyed");
                gUIDInfo2.errCode = 10030006;
                return gUIDInfo2;
            } else if (GuidInfoManager.isExpired(a.this.j)) {
                com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "Guid expired, request for new one.");
                GUIDInfo refreshConnectInfoSynchronized = GuidInfoManager.refreshConnectInfoSynchronized(a.this.j, 0, null);
                if (refreshConnectInfoSynchronized.isError()) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get guidServer error, guid == null;");
                    GUIDInfo guidInfoFromShar = GUIDInfo.getGuidInfoFromShar(a.this.j);
                    if (!guidInfoFromShar.isError()) {
                        refreshConnectInfoSynchronized = guidInfoFromShar;
                    }
                    refreshConnectInfoSynchronized.mqttServerIP = GuidInfoManager.getMqttServerIP(a.this.j);
                    return refreshConnectInfoSynchronized;
                }
                String hostToIp = DNSResolver.hostToIp(refreshConnectInfoSynchronized.mqttServer, refreshConnectInfoSynchronized.mqttPortList);
                if (com.tencent.tpns.mqttchannel.core.common.c.b.a(hostToIp)) {
                    hostToIp = GuidInfoManager.getMqttServerIP(a.this.j);
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MqttServer domain resolver failed, get from shar: " + hostToIp);
                } else {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get MqttServer: " + refreshConnectInfoSynchronized.mqttServer + ", save address: " + hostToIp);
                    GuidInfoManager.setMqttServerIP(a.this.j, hostToIp);
                    GuidInfoManager.setMqttServerRefreshTime(a.this.j, System.currentTimeMillis());
                }
                refreshConnectInfoSynchronized.mqttServerIP = hostToIp;
                return refreshConnectInfoSynchronized;
            } else {
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "GuidInfo not expired. Check mqttServer");
                String mqttServerIP = GuidInfoManager.getMqttServerIP(a.this.j);
                if (GuidInfoManager.isMqttServerExpired(a.this.j)) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Mqtt expired. Last MqttServer address: " + mqttServerIP);
                    gUIDInfo = GUIDInfo.getGuidInfoFromShar(a.this.j);
                    if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(gUIDInfo.mqttServer)) {
                        String hostToIp2 = DNSResolver.hostToIp(gUIDInfo.mqttServer, gUIDInfo.mqttPortList);
                        if (com.tencent.tpns.mqttchannel.core.common.c.b.a(hostToIp2)) {
                            gUIDInfo.mqttServerIP = mqttServerIP;
                            return gUIDInfo;
                        }
                        if (mqttServerIP != null) {
                            int lastIndexOf = mqttServerIP.lastIndexOf(":");
                            int lastIndexOf2 = hostToIp2.lastIndexOf(":");
                            if (!(lastIndexOf > 0 ? mqttServerIP.substring(0, lastIndexOf) : mqttServerIP).equals(lastIndexOf2 > 0 ? hostToIp2.substring(0, lastIndexOf2) : hostToIp2)) {
                                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "MqttServerAddr changed, request guidServer for new one.");
                                GUIDInfo refreshConnectInfoSynchronized2 = GuidInfoManager.refreshConnectInfoSynchronized(a.this.j, 1, null);
                                if (GuidInfoManager.isServerDestroy(a.this.j)) {
                                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Resources have been destroyed");
                                    gUIDInfo.errCode = 10030006;
                                    return gUIDInfo;
                                } else if (refreshConnectInfoSynchronized2 == null || refreshConnectInfoSynchronized2.isError()) {
                                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get new server guid error, get guid and finalMqttServerAddr from Shar");
                                    gUIDInfo.mqttServerIP = mqttServerIP;
                                    return gUIDInfo;
                                } else {
                                    if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(refreshConnectInfoSynchronized2.mqttServer)) {
                                        String hostToIp3 = DNSResolver.hostToIp(refreshConnectInfoSynchronized2.mqttServer, refreshConnectInfoSynchronized2.mqttPortList);
                                        if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(hostToIp3)) {
                                            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get MqttServer: " + refreshConnectInfoSynchronized2.mqttServer + ", save address: " + hostToIp3);
                                            GuidInfoManager.setMqttServerIP(a.this.j, hostToIp3);
                                            GuidInfoManager.setMqttServerRefreshTime(a.this.j, System.currentTimeMillis());
                                            mqttServerIP = hostToIp3;
                                        }
                                        gUIDInfo = refreshConnectInfoSynchronized2;
                                    } else {
                                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "get new server guid error");
                                    }
                                    hostToIp2 = mqttServerIP;
                                }
                            }
                        }
                        mqttServerIP = hostToIp2;
                    } else {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "get local GUIDInfo guid error");
                    }
                } else {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MqttServer not expired.");
                    gUIDInfo = GUIDInfo.getGuidInfoFromShar(a.this.j);
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Guid status: " + gUIDInfo);
                if (gUIDInfo != null && !gUIDInfo.isError()) {
                    gUIDInfo.mqttServerIP = mqttServerIP;
                }
                return gUIDInfo;
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        if (aVar != null && this.t.remove(aVar)) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "remove old callback success");
        }
        b();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void a(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - startConnect");
        f(aVar);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void b(final com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        synchronized (this) {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "stopConnect");
            if (this.f != MqttConnectState.CONNECTED && this.f != MqttConnectState.CONNECTING && this.f != MqttConnectState.SUBTOPICS) {
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Mqtt is not conneted");
                a(aVar, 0, "Mqtt is not conneted");
            } else if (this.e == null) {
                com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "stopConnect error: mqttAsyncClient is null");
                a(aVar, -602, "stopConnect error: mqttAsyncClient is null");
            } else {
                this.f = MqttConnectState.DISCONNECTING;
                try {
                    this.e.disconnect(10000, null, new IMqttActionListener() {
                        /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass12 */

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onSuccess(IMqttToken iMqttToken) {
                            a.this.f = MqttConnectState.DISCONNECTED;
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "disconnect success");
                            a.this.j();
                            a.this.a(aVar, 0, "success");
                        }

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onFailure(IMqttToken iMqttToken, Throwable th) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "stopConnect -> callback onFailure:", th);
                            a.this.f = MqttConnectState.DISCONNECTED;
                            a.this.j();
                            a aVar = a.this;
                            com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = aVar;
                            aVar.a(aVar2, -6, "stopConnect onFailure: " + th.toString());
                        }
                    });
                } catch (Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "stopConnect error MqttException " + th.getMessage());
                    this.f = MqttConnectState.DISCONNECTED;
                    j();
                    a(aVar, -601, "stopConnect error MqttException: " + th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "destroyMqttClient");
            this.e.destroy();
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "stopConnect close error:", th);
        }
        this.f = MqttConnectState.DISCONNECTED;
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass13 */

            @Override // java.lang.Runnable
            public void run() {
                if (!XGApiConfig.isEnableService(a.this.j)) {
                    Process.killProcess(Process.myPid());
                }
            }
        });
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void c(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        a(aVar, 0, this.f.toString());
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar, com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRequest");
        if (this.o || this.p || this.q) {
            i(aVar2);
            return;
        }
        if (aVar.a() > 0) {
            a(1010, aVar);
        }
        if (this.r == 1) {
            if (this.s == 1) {
                a(aVar, aVar2, "_xg/rpc/send/gzip_aes");
            } else {
                a(aVar, aVar2, "_xg/rpc/send/aes");
            }
        } else if (this.s == 1) {
            a(aVar, aVar2, "_xg/rpc/send/gzip");
        } else {
            a(aVar, aVar2, "_xg/rpc/send");
        }
    }

    /* access modifiers changed from: private */
    public void i(com.tencent.tpns.mqttchannel.core.common.b.a aVar) {
        if (this.o) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed");
            a(aVar, -3, "connect onFailure: Resources have been destroyed");
        } else if (this.p) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources exceeded limit");
            a(aVar, -4, "connect onFailure: Resources exceeded limit");
        } else if (this.q) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed by cloud");
            a(aVar, -4, "connect onFailure: Resources have been destroyed by cloud");
        }
    }

    /* access modifiers changed from: private */
    public void a(final com.tencent.tpns.mqttchannel.core.common.a.a aVar, final com.tencent.tpns.mqttchannel.core.common.b.a aVar2, final String str) {
        byte[] bArr;
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRealRequest");
        int i2 = AnonymousClass11.a[e().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                e(aVar, aVar2);
                a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                return;
            }
            e(aVar, aVar2);
        } else if (this.f != MqttConnectState.SUBTOPICS) {
            com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "sub topic not finish!");
            e(aVar, aVar2);
        } else if (this.e.getClientId() == null) {
            a(aVar2, -102, "sendRealRequest token is null");
        } else {
            aVar.a(this.e.getClientId());
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "sendRequest " + aVar);
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a());
                jSONObject.put("cmd", aVar.b());
                jSONObject.put("paramsMd5", aVar.f());
                jSONObject.put("params", new JSONObject(aVar.c()));
                AnonymousClass14 r1 = new Runnable() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass14 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.k.remove(Long.valueOf(aVar.a()));
                        aVar.d();
                        if (aVar.e() <= 1) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "sendRealRequest timeout and retry, request:" + aVar);
                            a.this.a(aVar, aVar2, str);
                        } else if (aVar.b) {
                            a.this.a(aVar2, -2, "Waiting for server response timeout!");
                        } else {
                            a.this.a(aVar2, -702, "sendRequest timeout!");
                        }
                    }
                };
                this.k.put(Long.valueOf(aVar.a()), new Pair<>(aVar2, r1));
                CommonWorkingThread.getInstance().execute(r1, 10000);
                try {
                    if (str.equals("_xg/rpc/send/gzip_aes")) {
                        String jSONObject2 = jSONObject.toString();
                        byte[] encodeGZipContent = CommonHelper.encodeGZipContent(jSONObject2.getBytes());
                        if (encodeGZipContent == null) {
                            a(aVar2, -706, "sendRequest " + aVar.b() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject2.length() + ", after: " + encodeGZipContent.length);
                        bArr = Security.encryptSrvData(encodeGZipContent);
                        if (bArr == null) {
                            a(aVar2, -704, "sendRequest " + aVar.b() + " encrypt failed");
                            return;
                        }
                    } else if (str.equals("_xg/rpc/send/gzip")) {
                        String jSONObject3 = jSONObject.toString();
                        byte[] encodeGZipContent2 = CommonHelper.encodeGZipContent(jSONObject3.getBytes());
                        if (encodeGZipContent2 == null) {
                            a(aVar2, -706, "sendRequest " + aVar.b() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject3.length() + ", after: " + encodeGZipContent2.length);
                        bArr = encodeGZipContent2;
                    } else if (str.equals("_xg/rpc/send/aes")) {
                        bArr = Security.encryptSrvData(jSONObject.toString().getBytes());
                        if (bArr == null) {
                            a(aVar2, -704, "sendRequest " + aVar.b() + " encrypt failed");
                            return;
                        }
                    } else {
                        bArr = jSONObject.toString().getBytes();
                    }
                    MqttMessage mqttMessage = new MqttMessage(bArr);
                    mqttMessage.setQos(1);
                    this.e.publish(str, mqttMessage, (Object) null, new IMqttActionListener() {
                        /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass15 */

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onSuccess(IMqttToken iMqttToken) {
                            aVar.b = true;
                            a.this.i = 0;
                            a.this.b(1010, aVar);
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest onSuccess topic:" + str + " body: " + jSONObject.toString());
                        }

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onFailure(IMqttToken iMqttToken, Throwable th) {
                            a.this.b(1010, aVar);
                            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest -> callback onFailure:", th);
                            Pair pair = (Pair) a.this.k.remove(Long.valueOf(aVar.a()));
                            if (pair != null) {
                                CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) pair.second);
                                a aVar = a.this;
                                com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = aVar2;
                                aVar.a(aVar2, -7, "sendRequest onFailure: " + th.toString());
                                return;
                            }
                            com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "onFailure but Not found the rpc Request id");
                        }
                    });
                } catch (Throwable th) {
                    b(1010, aVar);
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest error MqttException ", th);
                    Pair<com.tencent.tpns.mqttchannel.core.common.b.a, Runnable> remove = this.k.remove(Long.valueOf(aVar.a()));
                    if (remove != null) {
                        CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                        if (this.i >= 1) {
                            a(aVar2, -701, "sendRequest error: " + th.toString());
                            return;
                        }
                        this.i++;
                        com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "stop connect and retry sendRequest");
                        b(new OnMqttCallback() {
                            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass16 */

                            @Override // com.tencent.tpns.mqttchannel.core.a.b
                            public void callback(int i, String str) {
                                a.this.a(aVar, aVar2);
                            }
                        });
                    }
                }
            } catch (JSONException e2) {
                b(1010, aVar);
                a(aVar2, -101, "sendRealRequest JSONException: " + e2);
                e2.printStackTrace();
            }
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void b(com.tencent.tpns.mqttchannel.core.common.a.a aVar, com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        if (aVar.a() > 0) {
            a(1001, aVar);
        }
        f(aVar, aVar2);
    }

    private void f(final com.tencent.tpns.mqttchannel.core.common.a.a aVar, final com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRealPublishData");
        int i2 = AnonymousClass11.a[e().ordinal()];
        if (i2 == 1) {
            try {
                if (this.e.getClientId() == null) {
                    a(aVar2, -102, "sendPublishData token is null");
                    return;
                }
                aVar.a(this.e.getClientId());
                MqttMessage mqttMessage = new MqttMessage(aVar.c().getBytes());
                mqttMessage.setQos(1);
                this.e.publish(aVar.b(), mqttMessage, (Object) null, new IMqttActionListener() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass17 */

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        a.this.b(1001, aVar);
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData success, body: " + aVar.c());
                        a.this.a(aVar2, 0, "success");
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        a.this.b(1001, aVar);
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData -> callback onFailure:", th);
                        a aVar = a.this;
                        com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = aVar2;
                        aVar.a(aVar2, -8, "sendPublishData onFailure: " + th.toString());
                    }
                });
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData error MqttException ", th);
                a(aVar2, -801, "sendPublishData error: " + th);
            }
        } else if (i2 != 2) {
            e(aVar, aVar2);
            a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
        } else {
            e(aVar, aVar2);
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void c(com.tencent.tpns.mqttchannel.core.common.a.a aVar, com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        if (aVar.a() > 0) {
            a(1002, aVar);
        }
        g(aVar, aVar2);
    }

    private void g(final com.tencent.tpns.mqttchannel.core.common.a.a aVar, final com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - subscrbieReal");
        int i2 = AnonymousClass11.a[e().ordinal()];
        if (i2 == 1) {
            try {
                this.e.subscribe(aVar.b(), 1, (Object) null, new IMqttActionListener() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass18 */

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        a.this.a(aVar2, 0, "success");
                        a.this.b(1002, aVar);
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie -> callback onFailure:", th);
                        a aVar = a.this;
                        com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = aVar2;
                        aVar.a(aVar2, -9, "subscribe onFailure: " + th.toString());
                        a.this.b(1002, aVar);
                    }
                });
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th);
                a(aVar2, -901, "subscrbie error " + th);
            }
        } else if (i2 != 2) {
            e(aVar, aVar2);
            a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
        } else {
            e(aVar, aVar2);
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.c
    public void d(com.tencent.tpns.mqttchannel.core.common.a.a aVar, com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        if (aVar.a() > 0) {
            a(1003, aVar);
        }
        h(aVar, aVar2);
    }

    private void h(final com.tencent.tpns.mqttchannel.core.common.a.a aVar, final com.tencent.tpns.mqttchannel.core.common.b.a aVar2) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - unSubscrbieReal");
        int i2 = AnonymousClass11.a[e().ordinal()];
        if (i2 == 1) {
            try {
                this.e.unsubscribe(aVar.b(), (Object) null, new IMqttActionListener() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass19 */

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        a.this.b(1003, aVar);
                        a.this.a(aVar2, 0, "success");
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "unSubscrbie -> callback onFailure:", th);
                        a.this.b(1003, aVar);
                        a aVar = a.this;
                        com.tencent.tpns.mqttchannel.core.common.b.a aVar2 = aVar2;
                        aVar.a(aVar2, -10, "unSubscrbie onFailure: " + th.toString());
                    }
                });
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th);
                a(aVar2, -1001, "unSubscrbie error " + th);
            }
        } else if (i2 != 2) {
            e(aVar, aVar2);
            a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
        } else {
            e(aVar, aVar2);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallbackExtended
    public void connectComplete(final boolean z2, String str) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "connectComplete: " + str + ", reconnect:" + z2);
        a(new AbstractC0161a() {
            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass2 */

            @Override // com.tencent.tpns.mqttchannel.core.b.a.AbstractC0161a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar) {
                bVar.a(z2);
            }
        }, "doConnectComplete");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void connectionLost(Throwable th) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "connectionLost, cause:" + th + " retryCount:" + this.g);
        th.printStackTrace();
        this.f = MqttConnectState.DISCONNECTED;
        a(new AbstractC0161a() {
            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass3 */

            @Override // com.tencent.tpns.mqttchannel.core.b.a.AbstractC0161a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar) {
                bVar.a();
            }
        }, "doConnectionLost");
        k();
    }

    /* access modifiers changed from: private */
    public synchronized void k() {
        int recons = CloudManager.getInstance(this.j).getRecons();
        if (recons <= 0) {
            recons = 3;
            if (DeviceInfos.isScreenOn(this.j) || DeviceInfos.getChangedStatus(this.j) > 0) {
                recons = 5;
            }
        }
        this.g++;
        if (this.g >= recons || this.h > 5) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "tryReConnect too times, give up connect retryCount: " + this.g + ", sub retryCount: " + this.h);
            try {
                if (!c) {
                    if (System.currentTimeMillis() - b <= 1800000) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "get offline msg by HTTP time not reached");
                    }
                }
                ArrayList<String> b2 = b(this.j);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        c = false;
                        b = System.currentTimeMillis();
                        Iterator<String> it2 = b2.iterator();
                        while (it2.hasNext()) {
                            final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(0, "/_xg/push/" + XGApiConfig.getAccessId(this.j) + "/" + GuidInfoManager.getToken(this.j), it2.next());
                            a(new AbstractC0161a() {
                                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass4 */

                                @Override // com.tencent.tpns.mqttchannel.core.b.a.AbstractC0161a
                                public void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar) {
                                    bVar.a(aVar);
                                }
                            }, "doOfflineMsgByHttpArrived");
                        }
                    }
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "can't get any offline msg");
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "request for offline msg by http error", th);
            }
        } else {
            Message obtainMessage = this.n.obtainMessage(1);
            this.n.removeMessages(1);
            long max = (long) (Math.max(this.g, this.h) * 2000);
            if ((DeviceInfos.isScreenOn(this.j) || DeviceInfos.getChangedStatus(this.j) > 0) && max > 5000) {
                max = 5000;
            }
            this.n.sendMessageDelayed(obtainMessage, max);
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "tryReConnect -> retryCount:" + this.g + ", subRetryCount:" + this.h + ", delay:" + max);
        }
    }

    public void a() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "onHeartBeat ");
        if (this.e != null && !this.e.isConnected()) {
            com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "onHeartBeat: mqttAsyncClient not connect!");
            this.f = MqttConnectState.DISCONNECTED;
            f((com.tencent.tpns.mqttchannel.core.common.b.a) null);
        }
        a(new AbstractC0161a() {
            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass5 */

            @Override // com.tencent.tpns.mqttchannel.core.b.a.AbstractC0161a
            public void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "onHeartBeat doConnect action");
                bVar.b();
            }
        }, "onHeartBeat");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void messageArrived(String str, MqttMessage mqttMessage) {
        byte[] bArr;
        byte[] bArr2;
        if (mqttMessage == null) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived mqttMessage null");
        } else if (com.tencent.tpns.mqttchannel.core.common.c.b.i(this.j, str) || com.tencent.tpns.mqttchannel.core.common.c.b.k(this.j, str) || com.tencent.tpns.mqttchannel.core.common.c.b.m(this.j, str) || com.tencent.tpns.mqttchannel.core.common.c.b.o(this.j, str)) {
            try {
                if (com.tencent.tpns.mqttchannel.core.common.c.b.o(this.j, str)) {
                    byte[] decryptSrvData = Security.decryptSrvData(mqttMessage.getPayload());
                    if (decryptSrvData == null) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                    bArr = CommonHelper.decodeGZipContent(decryptSrvData);
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response unzip after decrypt failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.c.b.m(this.j, str)) {
                    bArr = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response unzip failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.c.b.k(this.j, str)) {
                    bArr = Security.decryptSrvData(mqttMessage.getPayload());
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                } else {
                    bArr = mqttMessage.getPayload();
                }
                String str2 = new String(bArr);
                com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MessageArrived, rpc topic :" + str + ", payload:" + str2);
                JSONObject jSONObject = new JSONObject(str2);
                long j2 = jSONObject.getLong("id");
                int optInt = jSONObject.optInt("ret", 0);
                String optString = jSONObject.optString("result", "");
                Pair<com.tencent.tpns.mqttchannel.core.common.b.a, Runnable> remove = this.k.remove(Long.valueOf(j2));
                if (remove != null) {
                    CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                    a((com.tencent.tpns.mqttchannel.core.common.b.a) remove.first, optInt, optString);
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "Not found the rpc Request id");
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived handle RpcReceiveTopic throw JSONException " + th.toString() + ", payload: " + new String(mqttMessage.getPayload()));
            }
        } else {
            if (com.tencent.tpns.mqttchannel.core.common.c.b.p(this.j, str)) {
                byte[] decryptSrvData2 = Security.decryptSrvData(mqttMessage.getPayload());
                if (decryptSrvData2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
                bArr2 = CommonHelper.decodeGZipContent(decryptSrvData2);
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message unzip after decrypt failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.c.b.n(this.j, str)) {
                bArr2 = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message unzip failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.c.b.l(this.j, str)) {
                bArr2 = Security.decryptSrvData(mqttMessage.getPayload());
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
            } else {
                bArr2 = mqttMessage.getPayload();
            }
            String str3 = new String(bArr2);
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MessageArrived, topic :" + str + ", payload:" + str3);
            final com.tencent.tpns.mqttchannel.core.common.a.a aVar = new com.tencent.tpns.mqttchannel.core.common.a.a(0, str, str3);
            a(new AbstractC0161a() {
                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass6 */

                @Override // com.tencent.tpns.mqttchannel.core.b.a.AbstractC0161a
                public void a(com.tencent.tpns.mqttchannel.core.common.b.b bVar) {
                    bVar.a(aVar);
                }
            }, "doMessageArrived");
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - deliveryComplete");
    }

    /* access modifiers changed from: private */
    public synchronized void l() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - initAfterConnected, encryptLevel:" + this.r);
        if (!(this.e == null || this.e.getClientId() == null)) {
            try {
                this.e.subscribe(this.r == 1 ? this.s == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.c.b.g(this.j, this.e.getClientId()), com.tencent.tpns.mqttchannel.core.common.c.b.h(this.j, this.e.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.c.b.c(this.j, this.e.getClientId()), com.tencent.tpns.mqttchannel.core.common.c.b.d(this.j, this.e.getClientId())} : this.s == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.c.b.e(this.j, this.e.getClientId()), com.tencent.tpns.mqttchannel.core.common.c.b.f(this.j, this.e.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.c.b.a(this.j, this.e.getClientId()), com.tencent.tpns.mqttchannel.core.common.c.b.b(this.j, this.e.getClientId())}, new int[]{1, 1}, (Object) null, new IMqttActionListener() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass7 */

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "subscribe INIT TOPIC success");
                        a.this.h = 0;
                        a.this.f = MqttConnectState.SUBTOPICS;
                        a.this.r();
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        a.q(a.this);
                        a.this.b((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                        a.this.k();
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error: ", th);
                    }
                });
            } catch (Throwable th) {
                this.h++;
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error MqttException ", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.tencent.tpns.mqttchannel.core.common.b.a aVar, int i2, String str) {
        if (aVar != null) {
            try {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - doCallback, code:" + i2 + ", message:" + str);
                aVar.handleCallback(i2, str);
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Callback code:" + i2 + ", message:" + str + " RemoteException:", th);
            }
        }
    }

    private void a(final AbstractC0161a aVar, final String str) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass8 */
            com.tencent.tpns.mqttchannel.core.common.b.b a = null;
            com.tencent.tpns.mqttchannel.core.common.b.b b = null;
            private ServiceConnection f = new ServiceConnection() {
                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass8.AnonymousClass1 */

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        AnonymousClass8.this.a = b.a.a(iBinder);
                        if (AnonymousClass8.this.a != null) {
                            aVar.a(AnonymousClass8.this.a);
                        }
                    } catch (Throwable th) {
                        a.this.j.unbindService(this);
                        throw th;
                    }
                    a.this.j.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass8.this.f = null;
                    AnonymousClass8.this.a = null;
                }
            };
            private ServiceConnection g = new ServiceConnection() {
                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass8.AnonymousClass2 */

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        AnonymousClass8.this.b = b.a.a(iBinder);
                        if (AnonymousClass8.this.b != null) {
                            CommonWorkingThread.getInstance().execute(new Runnable() {
                                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass8.AnonymousClass2.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        aVar.a(AnonymousClass8.this.b);
                                    } catch (Throwable th) {
                                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", str + " [xg] connectService connectAction.action() error: ", th);
                                    }
                                }
                            });
                        } else {
                            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "xgmqttAsyncClientService null");
                        }
                    } catch (Throwable th) {
                        a.this.j.unbindService(this);
                        throw th;
                    }
                    a.this.j.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass8.this.g = null;
                    AnonymousClass8.this.b = null;
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(a.this.j.getPackageName());
                    intent.setAction("com.tencent.tpns.mqttchannel.FEEDBACK");
                    if (!a.this.j.bindService(intent, this.f, 1)) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", str + " bind mqttAsyncClientService not success");
                    }
                    if (a.this.l) {
                        Intent intent2 = new Intent(a.this.j, a.this.m);
                        intent2.setPackage(a.this.j.getPackageName());
                        if (!a.this.j.bindService(intent2, this.g, 1)) {
                            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", str + " [xg] bind XgmqttAsyncClientService not success");
                        }
                    }
                } catch (Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", str + " bind mqttAsyncClientService throwable: " + th);
                }
            }
        });
    }

    private void m() {
        if (this.n == null) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "initHandler");
            this.n = new Handler() {
                /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass9 */

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message != null) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handler cmd: " + message.what);
                        int i = message.what;
                        if (i != 1) {
                            if (i == 2) {
                                a.this.a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                            } else if (i == 1006) {
                                a.this.n();
                            } else if (i != 1010) {
                                switch (i) {
                                    case 1001:
                                        a.this.a(1001, message);
                                        return;
                                    case 1002:
                                        a.this.a(1002, message);
                                        return;
                                    case 1003:
                                        a.this.a(1003, message);
                                        return;
                                    default:
                                        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "unknown handler msg = " + message.what);
                                        return;
                                }
                            } else {
                                a.this.a(1010, message);
                            }
                        } else if (com.tencent.tpns.mqttchannel.core.common.c.b.a(a.this.j)) {
                            a.this.f((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                        } else {
                            com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "net Work is not alive, stop connect");
                        }
                    }
                }
            };
        }
    }

    private void a(int i2, com.tencent.tpns.mqttchannel.core.common.a.a aVar) {
        Message message = new Message();
        message.obj = aVar;
        message.what = i2;
        if (!this.n.hasMessages(i2, Long.valueOf(aVar.a()))) {
            this.n.sendMessageDelayed(message, 30000);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, com.tencent.tpns.mqttchannel.core.common.a.a aVar) {
        this.n.removeMessages(i2, aVar);
        b(Long.valueOf(aVar.a()));
    }

    /* access modifiers changed from: private */
    public void a(int i2, Message message) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handleTimeOut " + i2 + " obj : " + message.obj);
        try {
            long a2 = ((com.tencent.tpns.mqttchannel.core.common.a.a) message.obj).a();
            com.tencent.tpns.mqttchannel.core.common.a.a c2 = c(Long.valueOf(a2));
            if (c2 != null && c2.a == 6) {
                this.k.remove(Long.valueOf(c2.a()));
            }
            final com.tencent.tpns.mqttchannel.core.common.b.a b2 = b(Long.valueOf(a2));
            if (b2 != null) {
                d.execute(new Runnable() {
                    /* class com.tencent.tpns.mqttchannel.core.b.a.AnonymousClass10 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(b2, -1103, "Mqtt is not connected, timeout");
                    }
                });
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Unknown msg " + i2, th);
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handlePingTimeOut");
        p();
    }

    /* access modifiers changed from: private */
    public boolean o() {
        return this.z;
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z2) {
        this.z = z2;
    }

    /* access modifiers changed from: private */
    public void p() {
        String str = "pingLock Exception";
        String str2 = "IMqttServiceImpl";
        if (!o()) {
            try {
                if (this.A.isLocked()) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Handling ping failed, return this time");
                } else {
                    this.A.lock();
                    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handlePingFailed");
                    b((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                    if (q()) {
                        a((com.tencent.tpns.mqttchannel.core.common.b.a) null);
                    }
                    try {
                        this.A.unlock();
                        Util.stopWakeCpu();
                    } catch (Exception unused) {
                        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "pingLock Exception");
                    }
                }
            } finally {
                try {
                    this.A.unlock();
                    Util.stopWakeCpu();
                } catch (Exception unused2) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.d(str2, str);
                }
            }
        }
    }

    private boolean q() {
        NetworkInfo activeNetworkInfo;
        if (Util.checkPermission(this.j, "android.permission.INTERNET") && Util.checkPermission(this.j, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.j.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public synchronized void r() {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action : sendCachedMessage");
        try {
            com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Cache message length: " + this.v.size());
            while (true) {
                com.tencent.tpns.mqttchannel.core.common.a.a poll = this.v.poll();
                if (poll == null) {
                    break;
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Action : sendCachedMessage " + poll);
                a(poll);
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendCachedMessage", th);
        }
    }

    private void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar) {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - handMQTTMsg");
        switch (aVar.a) {
            case 1:
                g(aVar, a(Long.valueOf(aVar.a())));
                return;
            case 2:
                f(aVar, a(Long.valueOf(aVar.a())));
                return;
            case 3:
                h(aVar, a(Long.valueOf(aVar.a())));
                return;
            case 4:
                return;
            case 5:
                f(aVar, a(Long.valueOf(aVar.a())));
                return;
            case 6:
                com.tencent.tpns.mqttchannel.core.common.b.a a2 = a(Long.valueOf(aVar.a()));
                if (this.r == 1) {
                    if (this.s == 1) {
                        a(aVar, a2, "_xg/rpc/send/gzip_aes");
                        return;
                    } else {
                        a(aVar, a2, "_xg/rpc/send/aes");
                        return;
                    }
                } else if (this.s == 1) {
                    a(aVar, a2, "_xg/rpc/send/gzip");
                    return;
                } else {
                    a(aVar, a2, "_xg/rpc/send");
                    return;
                }
            default:
                com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Error type of MQTTMessage");
                return;
        }
    }

    private ArrayList<String> b(Context context) {
        if (!Util.checkAccessId(XGApiConfig.getAccessId(context)) || !Util.checkAccessKey(XGApiConfig.getAccessKey(context)) || com.tencent.tpns.mqttchannel.core.common.c.b.a(GuidInfoManager.getToken(context)) || CloudManager.getInstance(context).disablePullMsg()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long accessId = XGApiConfig.getAccessId(context);
        String accessKey = XGApiConfig.getAccessKey(context);
        try {
            jSONObject.put("accessId", accessId);
            jSONObject.put("accessKey", accessKey);
            jSONObject.put("deviceType", 0);
            jSONObject.put("sdkVersion", "1.2.3.1");
            jSONObject.put("seq", currentTimeMillis);
            String token = GuidInfoManager.getToken(context);
            if (token != null) {
                jSONObject.put("token", token);
            }
            JSONArray jSONArray = new JSONArray();
            String notifiedMsgIds = Util.getNotifiedMsgIds(context, accessId);
            if (notifiedMsgIds != null && notifiedMsgIds.length() > 0) {
                for (String str : notifiedMsgIds.split(context.getPackageName() + "@")) {
                    jSONArray.put(Long.parseLong(str.substring(1)));
                }
            }
            jSONObject.put("recMsgIdList", jSONArray);
            jSONObject.put("protocolVersion", 1);
            String offlineMsg = CommonHelper.getOfflineMsg(context, XGApiConfig.getOfflineMsgServerAddr(context), jSONObject.toString(), null);
            if (offlineMsg == null || offlineMsg.length() <= 0) {
                com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "get offline msg http request error");
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(offlineMsg);
                int optInt = jSONObject2.optInt("retCode");
                if (optInt != 0) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "get offline msg error with retCode: " + optInt + ", msg: " + jSONObject2.optString("msg"));
                    return null;
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("msgList");
                ArrayList<String> arrayList = new ArrayList<>();
                if (optJSONArray == null) {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "no offline msg send to this package");
                } else {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "get offline msg number: " + optJSONArray.length());
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(optJSONArray.optJSONObject(i2).toString());
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "parse offline msg response error: ", th);
                return null;
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "generate offline msg request error: ", th2);
            return null;
        }
    }
}
