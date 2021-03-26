package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: UMNetWorkSender */
class a implements UMImprintChangeCallback {
    private static HandlerThread a = null;
    private static Handler b = null;
    private static Handler c = null;
    private static final int d = 200;
    private static final int e = 273;
    private static final int f = 274;
    private static final int g = 512;
    private static final int h = 769;
    private static FileObserverC0147a i = null;
    private static ConnectivityManager j = null;
    private static NetworkInfo k = null;

    /* renamed from: l  reason: collision with root package name */
    private static IntentFilter f1482l = null;
    private static boolean m = false;
    private static ArrayList<UMSenderStateNotify> n = null;
    private static Object o = new Object();
    private static ReentrantLock p = new ReentrantLock();
    private static final String q = "report_policy";
    private static final String r = "report_interval";
    private static boolean s = false;
    private static final int t = 15;
    private static final int u = 3;
    private static final int v = 90;
    private static int w = 15;
    private static Object x = new Object();
    private static BroadcastReceiver y = new BroadcastReceiver() {
        /* class com.umeng.commonsdk.framework.a.AnonymousClass1 */

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int size;
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Context appContext = UMModuleRegister.getAppContext();
                try {
                    if (a.j != null) {
                        NetworkInfo unused = a.k = a.j.getActiveNetworkInfo();
                        if (a.k == null || !a.k.isAvailable()) {
                            ULog.i("--->>> network disconnected.");
                            boolean unused2 = a.m = false;
                            return;
                        }
                        ULog.i("--->>> network isAvailable, check if there are any files to send.");
                        boolean unused3 = a.m = true;
                        synchronized (a.o) {
                            if (a.n != null && (size = a.n.size()) > 0) {
                                for (int i = 0; i < size; i++) {
                                    ((UMSenderStateNotify) a.n.get(i)).onConnectionAvailable();
                                }
                            }
                        }
                        UMRTLog.e("MobclickRT", "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
                        a.d();
                        if (a.k.getType() == 1 && context != null) {
                            try {
                                if (!UMWorkDispatch.eventHasExist(32774)) {
                                    UMWorkDispatch.sendEvent(context, 32774, b.a(context).a(), null);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
    };

    public static void c() {
    }

    /* access modifiers changed from: private */
    public static void q() {
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (o) {
            try {
                if (n == null) {
                    n = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < n.size(); i2++) {
                        if (uMSenderStateNotify == n.get(i2)) {
                            UMRTLog.i("MobclickRT", "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    n.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (x) {
            z = s;
        }
        return z;
    }

    public static int b() {
        int i2;
        synchronized (x) {
            i2 = w;
        }
        return i2;
    }

    private void n() {
        synchronized (x) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), "report_policy", ""))) {
                UMRTLog.i("MobclickRT", "--->>> switch to report_policy 11");
                s = true;
                w = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), "report_interval", "15")).intValue();
                UMRTLog.i("MobclickRT", "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3) {
                    if (intValue <= 90) {
                        w = intValue * 1000;
                    }
                }
                w = 15;
            } else {
                s = false;
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (x) {
            if ("report_policy".equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i("MobclickRT", "--->>> switch to report_policy 11");
                    s = true;
                } else {
                    s = false;
                }
            }
            if ("report_interval".equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i("MobclickRT", "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3) {
                    if (intValue <= 90) {
                        w = intValue * 1000;
                        UMRTLog.i("MobclickRT", "--->>> really set report_interval value to: " + w);
                    }
                }
                w = 15000;
                UMRTLog.i("MobclickRT", "--->>> really set report_interval value to: " + w);
            }
        }
    }

    public a(Context context, Handler handler) {
        Context appContext = UMModuleRegister.getAppContext();
        j = (ConnectivityManager) appContext.getSystemService("connectivity");
        c = handler;
        try {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                a = handlerThread;
                handlerThread.start();
                if (i == null) {
                    FileObserverC0147a aVar = new FileObserverC0147a(UMFrUtils.getEnvelopeDirPath(context));
                    i = aVar;
                    aVar.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                if (DeviceConfig.checkPermission(appContext, "android.permission.ACCESS_NETWORK_STATE") && j != null && f1482l == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    f1482l = intentFilter;
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    BroadcastReceiver broadcastReceiver = y;
                    if (broadcastReceiver != null) {
                        appContext.registerReceiver(broadcastReceiver, f1482l);
                    }
                }
                n();
                if (b == null) {
                    b = new Handler(a.getLooper()) {
                        /* class com.umeng.commonsdk.framework.a.AnonymousClass2 */

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i = message.what;
                            if (i == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.p.tryLock(1, TimeUnit.SECONDS);
                                    try {
                                        a.r();
                                    } catch (Throwable unused) {
                                    }
                                    a.p.unlock();
                                } catch (Throwable unused2) {
                                }
                            } else if (i == 274) {
                                a.p();
                            } else if (i == 512) {
                                a.q();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback("report_policy", this);
                ImprintHandler.getImprintService(context).registImprintCallback("report_interval", this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static void o() {
        if (a != null) {
            a = null;
        }
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
    }

    /* access modifiers changed from: private */
    public static void p() {
        int size;
        synchronized (o) {
            ArrayList<UMSenderStateNotify> arrayList = n;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    n.get(i2).onSenderIdle();
                }
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (m && (handler = b) != null && !handler.hasMessages(i2)) {
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i2;
            b.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public static void c(int i2) {
        Handler handler;
        if (m && (handler = b) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i2;
            b.sendMessage(obtainMessage);
        }
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (m && (handler = b) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i2;
            UMRTLog.i("MobclickRT", "--->>> sendMsgDelayed: " + j2);
            b.sendMessageDelayed(obtainMessage, j2);
        }
    }

    public static void d() {
        if (p.tryLock()) {
            try {
                b(273);
            } finally {
                p.unlock();
            }
        }
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (m && (handler = b) != null) {
            handler.removeMessages(i2);
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i2;
            b.sendMessageDelayed(obtainMessage, (long) i3);
        }
    }

    public static void e() {
        a(274, 3000);
    }

    /* renamed from: com.umeng.commonsdk.framework.a$a  reason: collision with other inner class name */
    /* compiled from: UMNetWorkSender */
    static class FileObserverC0147a extends FileObserver {
        public FileObserverC0147a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) == 8) {
                ULog.d("--->>> envelope file created >>> " + str);
                UMRTLog.i("MobclickRT", "--->>> envelope file created >>> " + str);
                a.c(273);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void r() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (m) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i("MobclickRT", "--->>> send envelope file [ " + path + "].");
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(273);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }
}
