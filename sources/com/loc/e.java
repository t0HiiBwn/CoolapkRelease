package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ApsManager */
public final class e {
    static boolean g;
    private i A = null;
    private List<Messenger> B;
    private boolean C = true;
    private String D = "";
    private final int E = 5000;
    private String F = "jsonp1";
    String a = null;
    b b = null;
    AMapLocation c = null;
    a d = null;
    Context e = null;
    dn f = null;
    HashMap<Messenger, Long> h = new HashMap<>();
    en i = null;
    long j = 0;
    long k = 0;
    String l = null;
    AMapLocationClientOption m = null;
    AMapLocationClientOption n = new AMapLocationClientOption();
    ServerSocket o = null;
    boolean p = false;
    Socket q = null;
    boolean r = false;
    c s = null;
    private boolean t = false;
    private boolean u = false;
    private long v = 0;
    private long w = 0;
    private ds x = null;
    private long y = 0;
    private int z = 0;

    /* compiled from: ApsManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[Catch:{ all -> 0x0066 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0077 A[Catch:{ all -> 0x0173 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0165  */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            Bundle bundle;
            int i;
            Throwable th;
            boolean z;
            try {
                bundle = message.getData();
                try {
                    messenger = message.replyTo;
                    if (bundle != null) {
                        try {
                            if (!bundle.isEmpty()) {
                                String string = bundle.getString("c");
                                e eVar = e.this;
                                if (TextUtils.isEmpty(eVar.l)) {
                                    eVar.l = ej.b(eVar.e);
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    if (string.equals(eVar.l)) {
                                        z = true;
                                        if (!z) {
                                            if (message.what == 1) {
                                                en.a((String) null, 2102);
                                                ds a2 = e.a(10, "invalid handlder scode!!!#1002");
                                                dm dmVar = new dm();
                                                dmVar.f("#1002");
                                                dmVar.e("conitue");
                                                e.this.a(messenger, a2, a2.k(), dmVar);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ej.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                                i = message.what;
                                if (i != 0) {
                                }
                                super.handleMessage(message);
                            } catch (Throwable th3) {
                                ej.a(th3, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    messenger = null;
                    ej.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                    i = message.what;
                    if (i != 0) {
                    }
                    super.handleMessage(message);
                }
            } catch (Throwable th5) {
                th = th5;
                bundle = null;
                messenger = null;
                ej.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                i = message.what;
                if (i != 0) {
                }
                super.handleMessage(message);
            }
            i = message.what;
            if (i != 0) {
                e.this.a(bundle);
                e.a(e.this, messenger, bundle);
            } else if (i == 1) {
                e.this.a(bundle);
                e.b(e.this, messenger, bundle);
            } else if (i != 2) {
                if (i != 3) {
                    switch (i) {
                        case 9:
                            e.this.a(bundle);
                            e.a(e.this);
                            break;
                        case 10:
                            e.this.a(bundle);
                            e.this.a(messenger, bundle);
                            break;
                        case 11:
                            e.this.c();
                            break;
                        case 12:
                            e.a(e.this, messenger);
                            break;
                        case 13:
                            Messenger messenger2 = message.replyTo;
                            if (!(messenger2 == null || e.this.B == null || e.this.B.contains(messenger2))) {
                                e.this.B.add(messenger2);
                                if (e.this.B.size() == 1) {
                                    e.this.f();
                                    break;
                                }
                            }
                            break;
                        case 14:
                            Messenger messenger3 = message.replyTo;
                            if (!(messenger3 == null || e.this.B == null || !e.this.B.contains(messenger3))) {
                                e.this.B.remove(messenger3);
                            }
                            if (e.this.B != null && e.this.B.size() == 0) {
                                e.this.f.h();
                                break;
                            }
                    }
                } else if (bundle == null) {
                    return;
                } else {
                    if (!bundle.isEmpty()) {
                        e.this.a((Bundle) null);
                        e.this.b();
                    } else {
                        return;
                    }
                }
            } else if (bundle == null) {
                return;
            } else {
                if (!bundle.isEmpty()) {
                    e.this.a((Bundle) null);
                    e eVar2 = e.this;
                    try {
                        if (!eVar2.r) {
                            eVar2.s = new c();
                            eVar2.s.start();
                            eVar2.r = true;
                        }
                    } catch (Throwable th6) {
                        ej.a(th6, "ApsServiceCore", "startSocket");
                    }
                } else {
                    return;
                }
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: ApsManager */
    class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                e.this.A = new i(e.this.e);
            } catch (Throwable th) {
                ej.a(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            try {
                ei.b(e.this.e);
                ei.a(e.this.e);
            } catch (Throwable th2) {
                ej.a(th2, "APSManager$ActionThread", "init 3");
            }
            e.this.f = new dn();
            super.onLooperPrepared();
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                ej.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    /* compiled from: ApsManager */
    class c extends Thread {
        c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (!e.this.p) {
                    e.this.p = true;
                    e.this.o = new ServerSocket(43689);
                }
                while (e.this.p && e.this.o != null) {
                    e eVar = e.this;
                    eVar.q = eVar.o.accept();
                    e eVar2 = e.this;
                    e.a(eVar2, eVar2.q);
                }
            } catch (Throwable th) {
                ej.a(th, "ApsServiceCore", "run");
            }
            super.run();
        }
    }

    public e(Context context) {
        this.e = context;
    }

    /* access modifiers changed from: private */
    public static ds a(int i2, String str) {
        try {
            ds dsVar = new ds("");
            dsVar.setErrorCode(i2);
            dsVar.setLocationDetail(str);
            return dsVar;
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (!this.t) {
                ej.a(this.e);
                if (bundle != null) {
                    this.n = ej.a(bundle.getBundle("optBundle"));
                }
                this.f.a(this.e);
                this.f.a();
                a(this.n);
                this.f.b();
                this.t = true;
                this.C = true;
                this.D = "";
                List<Messenger> list = this.B;
                if (list != null && list.size() > 0) {
                    f();
                }
            }
        } catch (Throwable th) {
            this.C = false;
            this.D = th.getMessage();
            ej.a(th, "ApsServiceCore", "init");
        }
    }

    private static void a(Messenger messenger, int i2, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i2;
                messenger.send(obtain);
            } catch (Throwable th) {
                ej.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Messenger messenger, AMapLocation aMapLocation, String str, dm dmVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", dmVar);
        this.h.put(messenger, Long.valueOf(ep.b()));
        a(messenger, 1, bundle);
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            dn dnVar = this.f;
            if (dnVar != null) {
                dnVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (!(this.m == null || (aMapLocationClientOption.isOffset() == this.m.isOffset() && aMapLocationClientOption.isNeedAddress() == this.m.isNeedAddress() && aMapLocationClientOption.isLocationCacheEnable() == this.m.isLocationCacheEnable() && this.m.getGeoLanguage() == aMapLocationClientOption.getGeoLanguage()))) {
                    this.w = 0;
                    this.c = null;
                }
                this.m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "setExtra");
        }
    }

    static /* synthetic */ void a(e eVar) {
        try {
            ei.c(eVar.e);
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    static /* synthetic */ void a(e eVar, Messenger messenger) {
        eVar.h.remove(messenger);
    }

    static /* synthetic */ void a(e eVar, Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (!eVar.u) {
                        eVar.u = true;
                        try {
                            eVar.f.e();
                            if (ei.k()) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putBoolean("installMockApp", true);
                                a(messenger, 9, bundle2);
                            }
                        } catch (Throwable th) {
                            ej.a(th, "ApsServiceCore", "initAuth");
                        }
                    }
                }
            } catch (Throwable th2) {
                ej.a(th2, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    static /* synthetic */ void a(e eVar, Socket socket) {
        Throwable th;
        BufferedReader bufferedReader;
        if (socket != null) {
            try {
                int i2 = ej.g;
                String str = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    try {
                        eVar.a(bufferedReader);
                        String e2 = eVar.e();
                        ej.g = i2;
                        try {
                            eVar.b(e2);
                            try {
                                bufferedReader.close();
                                socket.close();
                                return;
                            } catch (Throwable th2) {
                                ej.a(th2, "apm", "inSocetLn part3");
                                return;
                            }
                        } catch (Throwable th3) {
                            ej.a(th3, "apm", "inSocetLn part3");
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            str = eVar.F + "&&" + eVar.F + "({'package':'" + eVar.a + "','error_code':1,'error':'params error'})";
                            ej.a(th, "apm", "inSocetLn");
                            ej.g = i2;
                            try {
                                eVar.b(str);
                                try {
                                    bufferedReader.close();
                                    socket.close();
                                    return;
                                } catch (Throwable th5) {
                                    ej.a(th5, "apm", "inSocetLn part3");
                                    return;
                                }
                            } catch (Throwable th6) {
                                ej.a(th6, "apm", "inSocetLn part3");
                                return;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    bufferedReader = null;
                    str = eVar.F + "&&" + eVar.F + "({'package':'" + eVar.a + "','error_code':1,'error':'params error'})";
                    ej.a(th, "apm", "inSocetLn");
                    ej.g = i2;
                    eVar.b(str);
                    bufferedReader.close();
                    socket.close();
                    return;
                }
            } catch (Throwable th9) {
                ej.a(th9, "apm", "inSocetLn part4");
                return;
            }
        } else {
            return;
        }
        ej.a(th, "apm", "inSocetLn part3");
        throw th;
        throw th;
    }

    private void a(BufferedReader bufferedReader) throws Exception {
        String[] split;
        String[] split2;
        String[] split3;
        String readLine = bufferedReader.readLine();
        int i2 = 30000;
        if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
            for (String str : split3) {
                String[] split4 = str.split("=");
                if (split4 != null && split4.length > 1) {
                    if ("to".equals(split4[0])) {
                        i2 = ep.g(split4[1]);
                    }
                    if ("callback".equals(split4[0])) {
                        this.F = split4[1];
                    }
                }
            }
        }
        ej.g = i2;
    }

    private AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption a2 = ej.a(bundle.getBundle("optBundle"));
        a(a2);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                n.a(string);
            }
        } catch (Throwable th) {
            ej.a(th, "APSManager", "parseBundle");
        }
        return a2;
    }

    static /* synthetic */ void b(e eVar, Messenger messenger, Bundle bundle) {
        String str;
        i iVar;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    dm dmVar = new dm();
                    dmVar.e("conitue");
                    AMapLocationClientOption b2 = eVar.b(bundle);
                    if (eVar.h.containsKey(messenger) && !b2.isOnceLocation()) {
                        if (ep.b() - eVar.h.get(messenger).longValue() < 800) {
                            return;
                        }
                    }
                    AMapLocation aMapLocation = null;
                    if (!eVar.C) {
                        eVar.x = a(9, "init error : " + eVar.D + "#0901");
                        dmVar.f("#0901");
                        ds dsVar = eVar.x;
                        eVar.a(messenger, dsVar, dsVar.k(), dmVar);
                        en.a((String) null, 2091);
                        return;
                    }
                    long b3 = ep.b();
                    if (!ep.a(eVar.x) || b3 - eVar.w >= 600) {
                        dmVar.c(ep.b());
                        try {
                            ds a2 = eVar.f.a(dmVar);
                            eVar.x = a2;
                            if (a2.getLocationType() != 6) {
                                eVar.x.getLocationType();
                            }
                            eVar.x = eVar.f.a(eVar.x);
                        } catch (Throwable th) {
                            en.a((String) null, 2081);
                            dmVar.f("#0801");
                            eVar.x = a(8, "loc error : " + th.getMessage() + "#0801");
                            ej.a(th, "ApsServiceCore", "run part2");
                        }
                        if (ep.a(eVar.x)) {
                            eVar.w = ep.b();
                        }
                        if (eVar.x == null) {
                            eVar.x = a(8, "loc is null#0801");
                            dmVar.f("#0801");
                        }
                        ds dsVar2 = eVar.x;
                        if (dsVar2 != null) {
                            String k2 = dsVar2.k();
                            aMapLocation = eVar.x.clone();
                            str = k2;
                        } else {
                            str = null;
                        }
                        try {
                            if (b2.isLocationCacheEnable() && (iVar = eVar.A) != null) {
                                aMapLocation = iVar.a(aMapLocation, str, b2.getLastLocationLifeCycle());
                            }
                        } catch (Throwable th2) {
                            ej.a(th2, "ApsServiceCore", "fixLastLocation");
                        }
                        eVar.a(messenger, aMapLocation, str, dmVar);
                        return;
                    }
                    ds dsVar3 = eVar.x;
                    eVar.a(messenger, dsVar3, dsVar3.k(), dmVar);
                }
            } catch (Throwable th3) {
                ej.a(th3, "ApsServiceCore", "doLocation");
            }
        }
    }

    private void b(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.q.getOutputStream(), true, "UTF-8");
        printStream.println("HTTP/1.0 200 OK");
        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    public static void d() {
        g = false;
    }

    private String e() {
        StringBuilder sb;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (ep.e(this.e)) {
            sb = new StringBuilder();
            sb.append(this.F);
            sb.append("&&");
            sb.append(this.F);
            sb.append("({'package':'");
            sb.append(this.a);
            str = "','error_code':36,'error':'app is background'})";
        } else {
            ds dsVar = this.x;
            if (dsVar == null || currentTimeMillis - dsVar.getTime() > 5000) {
                try {
                    this.x = this.f.a(new dm());
                } catch (Throwable th) {
                    ej.a(th, "ApsServiceCore", "getSocketLocResult");
                }
            }
            ds dsVar2 = this.x;
            if (dsVar2 == null) {
                sb = new StringBuilder();
                sb.append(this.F);
                sb.append("&&");
                sb.append(this.F);
                sb.append("({'package':'");
                sb.append(this.a);
                str = "','error_code':8,'error':'unknown error'})";
            } else if (dsVar2.getErrorCode() != 0) {
                sb = new StringBuilder();
                sb.append(this.F);
                sb.append("&&");
                sb.append(this.F);
                sb.append("({'package':'");
                sb.append(this.a);
                sb.append("','error_code':");
                sb.append(this.x.getErrorCode());
                sb.append(",'error':'");
                sb.append(this.x.getErrorInfo());
                str = "'})";
            } else {
                sb = new StringBuilder();
                sb.append(this.F);
                sb.append("&&");
                sb.append(this.F);
                sb.append("({'package':'");
                sb.append(this.a);
                sb.append("','error_code':0,'error':'','location':{'y':");
                sb.append(this.x.getLatitude());
                sb.append(",'precision':");
                sb.append(this.x.getAccuracy());
                sb.append(",'x':");
                sb.append(this.x.getLongitude());
                str = "},'version_code':'5.2.0','version':'5.2.0'})";
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            dn dnVar = this.f;
            if (dnVar != null && dnVar != null) {
                dnVar.a(this.d);
                this.f.g();
            }
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "startColl");
        }
    }

    public final void a() {
        try {
            this.i = new en();
            b bVar = new b("amapLocCoreThread");
            this.b = bVar;
            bVar.setPriority(5);
            this.b.start();
            this.d = new a(this.b.getLooper());
            this.B = new ArrayList();
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "onCreate");
        }
    }

    final void a(Messenger messenger, Bundle bundle) {
        float f2;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (ei.h()) {
                        double d2 = bundle.getDouble("lat");
                        double d3 = bundle.getDouble("lon");
                        b(bundle);
                        AMapLocation aMapLocation = this.c;
                        if (aMapLocation != null) {
                            f2 = ep.a(new double[]{d2, d3, aMapLocation.getLatitude(), this.c.getLongitude()});
                            if (f2 < ((float) (ei.i() * 3))) {
                                Bundle bundle2 = new Bundle();
                                bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                                bundle2.putInt("I_MAX_GEO_DIS", ei.i() * 3);
                                bundle2.putInt("I_MIN_GEO_DIS", ei.i());
                                bundle2.putParcelable("loc", this.c);
                                a(messenger, 6, bundle2);
                            }
                        } else {
                            f2 = -1.0f;
                        }
                        if (f2 == -1.0f || f2 > ((float) ei.i())) {
                            a(bundle);
                            this.c = this.f.a(d2, d3);
                        }
                    }
                }
            } catch (Throwable th) {
                ej.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final void b() {
        try {
            Socket socket = this.q;
            if (socket != null) {
                socket.close();
            }
        } catch (Throwable th) {
            ej.a(th, "ApsServiceCore", "doStopScocket 1");
        }
        try {
            ServerSocket serverSocket = this.o;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Throwable th2) {
            ej.a(th2, "ApsServiceCore", "doStopScocket 2");
        }
        try {
            c cVar = this.s;
            if (cVar != null) {
                cVar.interrupt();
            }
        } catch (Throwable unused) {
        }
        this.s = null;
        this.o = null;
        this.p = false;
        this.r = false;
    }

    public final void c() {
        b bVar;
        try {
            HashMap<Messenger, Long> hashMap = this.h;
            if (hashMap != null) {
                hashMap.clear();
                this.h = null;
            }
            try {
                List<Messenger> list = this.B;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                ej.a(th, "apm", "des1");
            }
            a aVar = this.d;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            if (this.b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        em.a(this.b, HandlerThread.class, "quitSafely", new Object[0]);
                    } catch (Throwable unused) {
                        bVar = this.b;
                    }
                } else {
                    bVar = this.b;
                    bVar.quit();
                }
            }
            this.b = null;
            this.d = null;
            i iVar = this.A;
            if (iVar != null) {
                iVar.c();
                this.A = null;
            }
            b();
            this.t = false;
            this.u = false;
            this.f.d();
            if (!(this.i == null || this.j == 0 || this.k == 0)) {
                long b2 = ep.b() - this.j;
                en.a(this.e, this.i.c(this.e), this.i.d(this.e), this.k, b2);
                this.i.e(this.e);
            }
            en.a(this.e);
            ab.b();
            if (g) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            ej.a(th2, "apm", "tdest");
        }
    }
}
