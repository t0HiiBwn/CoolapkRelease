package com.tencent.android.tpush.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.g;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.MqttChannel;

/* compiled from: ProGuard */
public class b {
    private static Context a = null;
    private static String b = "";
    private static LocalServerSocket c;
    private static LocalServerSocket d;
    private static volatile boolean e;
    private static volatile boolean f;
    private static volatile boolean g;
    private static boolean h;
    private static ServiceConnection i;
    private Handler j;

    /* compiled from: ProGuard */
    public static class a {
        public static final b a = new b();
    }

    private b() {
        this.j = null;
        b = com.tencent.android.tpush.common.b.b(e());
    }

    public static boolean a() {
        return h;
    }

    public static b b() {
        return a.a;
    }

    public void a(Intent intent) {
        if (this.j == null) {
            k();
        }
        synchronized (this) {
            if (e) {
                if (intent != null) {
                    String action = intent.getAction();
                    TLogger.v("PushServiceManager", "Start Service with action " + action);
                    if (action != null) {
                        if ("com.tencent.android.xg.vip.action.keepalive".equals(action)) {
                            Message obtainMessage = this.j.obtainMessage(2);
                            long longExtra = intent.getLongExtra("delay_time", 0);
                            if (longExtra == 0) {
                                this.j.removeMessages(2);
                                this.j.sendMessageDelayed(obtainMessage, 100);
                            } else {
                                this.j.removeMessages(2);
                                this.j.sendMessageDelayed(obtainMessage, longExtra);
                            }
                        } else if ("com.tencent.android.xg.vip.action.stop_connect".equals(action)) {
                            Message obtainMessage2 = this.j.obtainMessage(3);
                            this.j.removeMessages(3);
                            this.j.sendMessageDelayed(obtainMessage2, 100);
                        }
                    }
                } else {
                    TLogger.v("PushServiceManager", "Start Service with null action  but intent is not null");
                    this.j.removeMessages(1);
                    this.j.sendMessageDelayed(this.j.obtainMessage(1), 100);
                }
                return;
            }
            TLogger.d("PushServiceManager", "send WHAT_SERVICE_START msg at 100ms later on serviceStartHandler");
            this.j.removeMessages(1);
            this.j.sendMessageDelayed(this.j.obtainMessage(1), 100);
        }
    }

    public static void a(Context context) {
        a(context, "com.tencent.android.xg.vip.action.keepalive", 0);
    }

    public static void a(Context context, long j2) {
        a(context, "com.tencent.android.xg.vip.action.keepalive", j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6 A[Catch:{ all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba A[Catch:{ all -> 0x00c1 }] */
    public static void a(Context context, String str, long j2) {
        Object th;
        Object th2;
        Intent intent;
        TLogger.d("PushServiceManager", "startService, action:" + str + ", delay:" + j2);
        if (PushPreferences.getBoolean(context, "start_service_by_user", false) || !com.tencent.android.tpush.common.b.g(context)) {
            Intent intent2 = null;
            if (context != null) {
                try {
                    Intent intent3 = new Intent();
                    try {
                        intent3.setClass(context, XGVipPushService.class);
                        intent3.setAction(str);
                        if (j2 != 0) {
                            intent3.putExtra("delay_time", j2);
                        }
                        if (j.a(context) <= 0) {
                            context.startService(intent3);
                            if (!h) {
                                AnonymousClass1 r7 = new ServiceConnection() {
                                    /* class com.tencent.android.tpush.service.b.AnonymousClass1 */

                                    @Override // android.content.ServiceConnection
                                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                        boolean unused = b.h = true;
                                        TLogger.d("PushServiceManager", "XGPushService onServiceConnected");
                                    }

                                    @Override // android.content.ServiceConnection
                                    public void onServiceDisconnected(ComponentName componentName) {
                                        boolean unused = b.h = false;
                                        TLogger.d("PushServiceManager", "XGPushService onServiceDisconnected");
                                    }
                                };
                                i = r7;
                                context.bindService(intent3, r7, 1);
                                TLogger.d("PushServiceManager", "bindService ret:" + h);
                                return;
                            }
                            return;
                        }
                        TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
                        context.stopService(intent3);
                    } catch (Throwable th3) {
                        th = th3;
                        intent2 = intent3;
                        TLogger.e("PushServiceManager", "startService failed, intent:" + intent2 + ", ex:" + th);
                        try {
                            intent = new Intent();
                            try {
                                intent.setClass(context, XGVipPushService.class);
                                if (j.a(context) > 0) {
                                    context.startService(intent);
                                    return;
                                }
                                TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
                                context.stopService(intent);
                            } catch (Throwable th4) {
                                th2 = th4;
                                intent2 = intent;
                                TLogger.e("PushServiceManager", "222 startService failed, intent:" + intent2 + ", ex:" + th2);
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            TLogger.e("PushServiceManager", "222 startService failed, intent:" + intent2 + ", ex:" + th2);
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    TLogger.e("PushServiceManager", "startService failed, intent:" + intent2 + ", ex:" + th);
                    intent = new Intent();
                    intent.setClass(context, XGVipPushService.class);
                    if (j.a(context) > 0) {
                    }
                }
            }
        } else {
            TLogger.ii("PushServiceManager", "startService abolish, XG_SERVICE_PULL_UP_OFF on manifest and never called by user");
        }
    }

    public void c() {
        try {
            TLogger.d("PushServiceManager", "@@ serviceExit()");
            j.a();
            Handler handler = this.j;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.j = null;
            }
            if (CommonWorkingThread.getInstance().getHandler() != null) {
                CommonWorkingThread.getInstance().getHandler().removeCallbacksAndMessages(null);
            }
            a.a().c(a);
            MqttChannel.getInstance(a).stopConnect(null);
            d();
            f.e(e());
        } catch (Throwable th) {
            TLogger.w("PushServiceManager", "unexpected for serviceExit:" + th.getMessage());
        }
    }

    public void d() {
        synchronized (this) {
            LocalServerSocket localServerSocket = c;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                    c = null;
                } catch (Throwable th) {
                    TLogger.e("PushServiceManager", ">> Destroy local socket exception", th);
                }
            }
            Boolean bool = false;
            e = bool.booleanValue();
        }
    }

    public static void b(Context context) {
        if (context != null) {
            a = context;
            b = context.getPackageName();
        }
    }

    public static Context e() {
        Context context = a;
        if (context != null) {
            return context;
        }
        return XGPushManager.getContext();
    }

    public static ServiceConnection f() {
        return i;
    }

    public static void g() {
        i = null;
    }

    public static String h() {
        return b;
    }

    private void k() {
        this.j = new Handler(Looper.getMainLooper()) {
            /* class com.tencent.android.tpush.service.b.AnonymousClass2 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    TLogger.d("PushServiceManager", "initHandler, cmd:" + message.what);
                    int i = message.what;
                    if (i == 1) {
                        TLogger.dd("PushServiceManager", "Service's running at " + b.a.getPackageName() + ",version : 1.2.3.1");
                        if (!g.a()) {
                            TLogger.e("PushServiceManager", "permission check failed, kill service!");
                            b.this.d();
                            f.e(b.e());
                        }
                        a.a().a(b.e());
                        MqttChannel.getInstance(b.a).startConnect(null);
                        com.tencent.android.tpush.a.a.a(b.e()).a();
                        if (!b.e) {
                            TLogger.d("PushServiceManager", "pull up xg services on 8s later");
                            CommonWorkingThread.getInstance().execute(new Runnable() {
                                /* class com.tencent.android.tpush.service.b.AnonymousClass2.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    TLogger.d("PushServiceManager", "8s time's over, now pull up xg services");
                                    f.d(b.e());
                                }
                            }, 8000);
                            boolean unused = b.e = true;
                        }
                    } else if (i == 2) {
                        MqttChannel.getInstance(b.a).startConnect(null);
                    } else if (i == 3) {
                        MqttChannel.getInstance(b.a).stopConnect(null);
                    } else if (i != 4) {
                        TLogger.e("PushServiceManager", "unknown handler msg = " + message.what);
                    }
                }
            }
        };
    }
}
