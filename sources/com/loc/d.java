package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AmapLocationManager */
public final class d {
    private static boolean D = true;
    private static boolean F;
    public static volatile boolean f;
    private Context A;
    private boolean B = false;
    private volatile boolean C = false;
    private boolean E = true;
    private h G = null;
    private ServiceConnection H = new ServiceConnection() {
        /* class com.loc.d.AnonymousClass1 */

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.i = new Messenger(iBinder);
                d.this.B = true;
                d.this.r = true;
            } catch (Throwable th) {
                ej.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.i = null;
            d.this.B = false;
        }
    };
    private volatile boolean I = false;
    AMapLocationClientOption a = new AMapLocationClientOption();
    public c b;
    g c = null;
    ArrayList<AMapLocationListener> d = new ArrayList<>();
    boolean e = false;
    public boolean g = true;
    i h;
    Messenger i = null;
    Messenger j = null;
    Intent k = null;

    /* renamed from: l  reason: collision with root package name */
    int f1360l = 0;
    b m = null;
    boolean n = false;
    AMapLocationClientOption.AMapLocationMode o = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object p = new Object();
    en q = null;
    boolean r = false;
    e s = null;
    String t = null;
    AMapLocationQualityReport u = null;
    boolean v = false;
    boolean w = false;
    a x = null;
    String y = null;
    boolean z = false;

    /* renamed from: com.loc.d$2  reason: invalid class name */
    /* compiled from: AmapLocationManager */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: AmapLocationManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Throwable th;
            String str = null;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    d.this.a(message.getData());
                } else if (i == 12) {
                    d.a(d.this, message);
                } else if (i == 1008) {
                    d.h(d.this);
                } else if (i == 1009) {
                    d.i(d.this);
                } else if (i != 1011) {
                    switch (i) {
                        case 1002:
                            d.a(d.this, (AMapLocationListener) message.obj);
                            return;
                        case 1003:
                            d.this.j();
                            d.this.a(13, (Bundle) null);
                            return;
                        case 1004:
                            try {
                                d.this.k();
                                d.this.a(14, (Bundle) null);
                                return;
                            } catch (Throwable th2) {
                                str = "handleMessage STOP_LOCATION";
                                th = th2;
                                break;
                            }
                        case 1005:
                            d.b(d.this, (AMapLocationListener) message.obj);
                            return;
                        default:
                            switch (i) {
                                case 1014:
                                    d.b(d.this, message);
                                    return;
                                case 1015:
                                    d.this.c.a(d.this.a);
                                    d.this.a(1025, (Object) null, 300000);
                                    return;
                                case 1016:
                                    if (d.this.c.b()) {
                                        d.this.a(1016, (Object) null, 1000);
                                        return;
                                    } else {
                                        d.e(d.this);
                                        return;
                                    }
                                case 1017:
                                    d.this.c.a();
                                    d.this.a(1025);
                                    return;
                                case 1018:
                                    d.this.a = (AMapLocationClientOption) message.obj;
                                    if (d.this.a != null) {
                                        d.g(d.this);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i) {
                                        case 1023:
                                            d.c(d.this, message);
                                            return;
                                        case 1024:
                                            d.d(d.this, message);
                                            return;
                                        case 1025:
                                            g gVar = d.this.c;
                                            boolean z = false;
                                            if (gVar.c != null) {
                                                if (!gVar.c.isOnceLocation()) {
                                                    if (ep.b() - gVar.d > 300000) {
                                                        z = true;
                                                    }
                                                }
                                            }
                                            if (z) {
                                                d.this.c.a();
                                                d.this.c.a(d.this.a);
                                            }
                                            d.this.a(1025, (Object) null, 300000);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
                    if (str == null) {
                        str = "handleMessage";
                    }
                    ej.a(th, "AMapLocationManage$MHandlerr", str);
                } else {
                    d.this.a(14, (Bundle) null);
                    d.this.h();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* compiled from: AmapLocationManager */
    static class b extends HandlerThread {
        d a = null;

        public b(String str, d dVar) {
            super(str);
            this.a = dVar;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.a.h.a();
                this.a.m();
                dw.j();
                d dVar = this.a;
                if (!(dVar == null || dVar.A == null)) {
                    ei.b(this.a.A);
                    ei.a(this.a.A);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AmapLocationManager */
    public class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str = null;
            try {
                super.handleMessage(message);
                if (!d.this.n) {
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            switch (i) {
                                case 5:
                                    Bundle data = message.getData();
                                    data.putBundle("optBundle", ej.a(d.this.a));
                                    d.this.a(10, data);
                                    return;
                                case 6:
                                    Bundle data2 = message.getData();
                                    if (d.this.c != null) {
                                        g gVar = d.this.c;
                                        if (data2 != null) {
                                            try {
                                                data2.setClassLoader(AMapLocation.class.getClassLoader());
                                                gVar.g = data2.getInt("I_MAX_GEO_DIS");
                                                gVar.h = data2.getInt("I_MIN_GEO_DIS");
                                                AMapLocation aMapLocation = (AMapLocation) data2.getParcelable("loc");
                                                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                                    synchronized (gVar.o) {
                                                        g.y = aMapLocation;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                ej.a(th, "GpsLocation", "setLastGeoLocation");
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                case 7:
                                    Bundle data3 = message.getData();
                                    d.this.E = data3.getBoolean("ngpsAble");
                                    return;
                                case 8:
                                    en.a((String) null, 2141);
                                    break;
                                case 9:
                                    boolean unused = d.F = message.getData().getBoolean("installMockApp");
                                    return;
                                case 10:
                                    d.a(d.this, (AMapLocation) message.obj);
                                    return;
                                default:
                                    return;
                            }
                        }
                        Message obtain = Message.obtain();
                        obtain.what = 12;
                        obtain.obj = message.obj;
                        d.this.x.sendMessage(obtain);
                        return;
                    }
                    Message obtainMessage = d.this.x.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    d.this.x.sendMessage(obtainMessage);
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    str = "handleMessage";
                }
                ej.a(th2, "AmapLocationManager$MainHandler", str);
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        c cVar;
        this.A = context;
        this.k = intent;
        if (looper == null) {
            try {
                cVar = Looper.myLooper() == null ? new c(this.A.getMainLooper()) : new c();
            } catch (Throwable th) {
                ej.a(th, "ALManager", "init 1");
            }
        } else {
            cVar = new c(looper);
        }
        this.b = cVar;
        try {
            this.h = new i(this.A);
        } catch (Throwable th2) {
            ej.a(th2, "ALManager", "init 5");
        }
        b bVar = new b("amapLocManagerThread", this);
        this.m = bVar;
        bVar.setPriority(5);
        this.m.start();
        this.x = a(this.m.getLooper());
        try {
            this.c = new g(this.A, this.b);
        } catch (Throwable th3) {
            ej.a(th3, "ALManager", "init 3");
        }
        if (this.q == null) {
            this.q = new en();
        }
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.p) {
            aVar = new a(looper);
            this.x = aVar;
        }
        return aVar;
    }

    private ds a(dn dnVar) {
        if (!this.a.isLocationCacheEnable()) {
            return null;
        }
        try {
            return dnVar.f();
        } catch (Throwable th) {
            ej.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        synchronized (this.p) {
            a aVar = this.x;
            if (aVar != null) {
                aVar.removeMessages(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z2 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z2) {
                    this.i = null;
                    this.B = false;
                }
                ej.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = ej.b(this.A);
        }
        bundle.putString("c", this.t);
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.setData(bundle);
        obtain.replyTo = this.j;
        Messenger messenger = this.i;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object obj, long j2) {
        synchronized (this.p) {
            if (this.x != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.x.sendMessageDelayed(obtain, j2);
            }
        }
    }

    private void a(Intent intent, boolean z2) {
        if (this.A != null) {
            if (Build.VERSION.SDK_INT >= 26 && z2) {
                if (!o()) {
                    Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                    return;
                }
                try {
                    this.A.getClass().getMethod("startForegroundService", Intent.class).invoke(this.A, intent);
                } catch (Throwable unused) {
                }
                this.z = true;
            }
            this.A.startService(intent);
            this.z = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    public void a(Bundle bundle) {
        dm dmVar;
        dm dmVar2;
        AMapLocation aMapLocation;
        dm dmVar3;
        Throwable th;
        AMapLocation aMapLocation2 = null;
        if (bundle != 0) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.y = bundle.getString("nb");
                dm dmVar4 = (dm) bundle.getParcelable("statics");
                dmVar2 = dmVar4;
                if (aMapLocation != null) {
                    dmVar2 = dmVar4;
                    if (aMapLocation.getErrorCode() == 0) {
                        g gVar = this.c;
                        dmVar2 = dmVar4;
                        if (gVar != null) {
                            gVar.w = 0;
                            dmVar2 = dmVar4;
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                g.y = aMapLocation;
                                dmVar2 = dmVar4;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dmVar3 = bundle;
                ej.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                dmVar = dmVar3;
                a(aMapLocation2, dmVar);
            }
        } else {
            dmVar2 = null;
            aMapLocation = null;
        }
        g gVar2 = this.c;
        if (gVar2 != null) {
            aMapLocation2 = gVar2.a(aMapLocation, this.y);
            dmVar = dmVar2;
        } else {
            aMapLocation2 = aMapLocation;
            dmVar = dmVar2;
        }
        a(aMapLocation2, dmVar);
    }

    private synchronized void a(AMapLocation aMapLocation, dm dmVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                ej.a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.u == null) {
            this.u = new AMapLocationQualityReport();
        }
        this.u.setLocationMode(this.a.getLocationMode());
        g gVar = this.c;
        if (gVar != null) {
            this.u.setGPSSatellites(gVar.d());
            this.u.setGpsStatus(this.c.c());
        }
        this.u.setWifiAble(ep.h(this.A));
        this.u.setNetworkType(ep.i(this.A));
        if (aMapLocation.getLocationType() == 1 || "gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            this.u.setNetUseTime(0);
        }
        if (dmVar != null) {
            this.u.setNetUseTime(dmVar.a());
        }
        this.u.setInstallHighDangerMockApp(F);
        aMapLocation.setLocationQualityReport(this.u);
        try {
            if (this.C) {
                String str = this.y;
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", aMapLocation);
                bundle.putString("lastLocNb", str);
                a(1014, bundle, 0);
                if (dmVar != null) {
                    dmVar.d(ep.b());
                }
                en.a(this.A, aMapLocation, dmVar);
                en.a(this.A, aMapLocation);
                AMapLocation clone = aMapLocation.clone();
                Message obtainMessage = this.b.obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.obj = clone;
                this.b.sendMessage(obtainMessage);
            }
        } catch (Throwable th2) {
            ej.a(th2, "ALManager", "handlerLocation part2");
        }
        if (!this.n) {
            if (this.a.isOnceLocation()) {
                k();
                a(14, (Bundle) null);
            }
        }
    }

    static /* synthetic */ void a(d dVar, Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (dVar.g && dVar.i != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", ej.a(dVar.a));
                dVar.a(0, bundle);
                if (dVar.C) {
                    dVar.a(13, (Bundle) null);
                }
                dVar.g = false;
            }
            dVar.a(aMapLocation, (dm) null);
            dVar.a(1025);
            dVar.a(1025, (Object) null, 300000);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    static /* synthetic */ void a(d dVar, AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    en.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !dVar.c.b()) {
                aMapLocation.setAltitude(ep.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(ep.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(ep.a(aMapLocation.getSpeed()));
                Iterator<AMapLocationListener> it2 = dVar.d.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    static /* synthetic */ void a(d dVar, AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (dVar.d == null) {
                dVar.d = new ArrayList<>();
            }
            if (!dVar.d.contains(aMapLocationListener)) {
                dVar.d.add(aMapLocationListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    private ds b(dn dnVar) {
        Throwable th;
        boolean z2;
        String str;
        ds dsVar;
        dm dmVar = new dm();
        ds dsVar2 = null;
        try {
            dmVar.c(ep.b());
            try {
                String apikey = AMapLocationClientOption.getAPIKEY();
                if (!TextUtils.isEmpty(apikey)) {
                    l.a(this.A, apikey);
                }
            } catch (Throwable th2) {
                ej.a(th2, "ALManager", "apsLocation setAuthKey");
            }
            try {
                String umidtoken = UmidtokenInfo.getUmidtoken();
                if (!TextUtils.isEmpty(umidtoken)) {
                    n.a(umidtoken);
                }
            } catch (Throwable th3) {
                ej.a(th3, "ALManager", "apsLocation setUmidToken");
            }
            try {
                dnVar.a(this.A);
                dnVar.a(this.a);
                dnVar.b(dmVar);
            } catch (Throwable th4) {
                ej.a(th4, "ALManager", "initApsBase");
            }
            boolean l2 = ei.l();
            ds a2 = a(dnVar);
            if (a2 == null) {
                try {
                    a2 = dnVar.a(!l2, dmVar);
                    if (a2 != null) {
                        try {
                            if (a2.getErrorCode() == 0) {
                                dnVar.b(a2);
                            }
                        } catch (Throwable th5) {
                            ej.a(th5, "ALManager", "apsLocation:doFirstAddCache");
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    dsVar2 = a2;
                    try {
                        ej.a(th, "ALManager", "apsLocation");
                        try {
                            dnVar.d();
                        } catch (Throwable unused) {
                        }
                        return dsVar2;
                    } catch (Throwable unused2) {
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (a2 != null) {
                str = a2.k();
                dsVar2 = a2.clone();
            } else {
                str = null;
            }
            try {
                dsVar = dsVar2;
                if (this.a.isLocationCacheEnable()) {
                    i iVar = this.h;
                    dsVar = dsVar2;
                    if (iVar != null) {
                        dsVar = iVar.a(dsVar2, str, this.a.getLastLocationLifeCycle());
                    }
                }
            } catch (Throwable th7) {
                ej.a(th7, "ALManager", "fixLastLocation");
                dsVar = dsVar2;
            }
            try {
                Bundle bundle = new Bundle();
                if (dsVar != null) {
                    bundle.putParcelable("loc", dsVar);
                    bundle.putString("nb", a2.k());
                    bundle.putParcelable("statics", dmVar);
                }
                a(bundle);
            } catch (Throwable th8) {
                ej.a(th8, "ALManager", "apsLocation:callback");
            }
            if (z2 && l2 && !f) {
                f = true;
                try {
                    dnVar.c();
                    dnVar.a(new AMapLocationClientOption().setNeedAddress(false));
                    dnVar.a(true, new dm());
                } catch (Throwable th9) {
                    ej.a(th9, "ALManager", "apsLocation:doFirstNetLocate 2");
                }
            }
            try {
                dnVar.d();
                return a2;
            } catch (Throwable unused3) {
                return a2;
            }
        } catch (Throwable th10) {
            th = th10;
            ej.a(th, "ALManager", "apsLocation");
            dnVar.d();
            return dsVar2;
        }
        throw th;
    }

    static /* synthetic */ void b(d dVar, Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            if (aMapLocation != null) {
                AMapLocation aMapLocation2 = null;
                try {
                    if (i.b == null) {
                        i iVar = dVar.h;
                        if (iVar != null) {
                            aMapLocation2 = iVar.b();
                        }
                    } else {
                        aMapLocation2 = i.b.a();
                    }
                    en.a(aMapLocation2, aMapLocation);
                } catch (Throwable unused) {
                }
            }
            if (dVar.h.a(aMapLocation, string)) {
                dVar.h.d();
            }
        } catch (Throwable th) {
            ej.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    static /* synthetic */ void b(d dVar, AMapLocationListener aMapLocationListener) {
        if (!dVar.d.isEmpty() && dVar.d.contains(aMapLocationListener)) {
            dVar.d.remove(aMapLocationListener);
        }
        if (dVar.d.isEmpty()) {
            dVar.k();
        }
    }

    static /* synthetic */ void c(d dVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i2 = data.getInt("i", 0);
                    Intent n2 = dVar.n();
                    n2.putExtra("i", i2);
                    n2.putExtra("h", (Notification) data.getParcelable("h"));
                    n2.putExtra("g", 1);
                    dVar.a(n2, true);
                }
            } catch (Throwable th) {
                ej.a(th, "ALManager", "doEnableBackgroundLocation");
            }
        }
    }

    static /* synthetic */ void d(d dVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z2 = data.getBoolean("j", true);
                    Intent n2 = dVar.n();
                    n2.putExtra("j", z2);
                    n2.putExtra("g", 2);
                    dVar.a(n2, false);
                }
            } catch (Throwable th) {
                ej.a(th, "ALManager", "doDisableBackgroundLocation");
            }
        }
    }

    static /* synthetic */ void e(d dVar) {
        try {
            if (D || (!dVar.r && !dVar.I)) {
                D = false;
                dVar.I = true;
                ds b2 = dVar.b(new dn());
                if (dVar.i()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (b2 != null && (b2.getLocationType() == 2 || b2.getLocationType() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", ej.a(dVar.a));
                    bundle.putString("isCacheLoc", str);
                    dVar.a(0, bundle);
                    if (dVar.C) {
                        dVar.a(13, (Bundle) null);
                    }
                }
            } else {
                try {
                    if (dVar.r && !dVar.B && !dVar.w) {
                        dVar.w = true;
                        dVar.m();
                    }
                } catch (Throwable th) {
                    dVar.w = true;
                    ej.a(th, "ALManager", "doLBSLocation reStartService");
                }
                if (dVar.i()) {
                    dVar.w = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", ej.a(dVar.a));
                    bundle2.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!dVar.c.b()) {
                        dVar.a(1, bundle2);
                    }
                }
            }
            try {
                if (!dVar.a.isOnceLocation()) {
                    dVar.l();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
    }

    static /* synthetic */ void g(d dVar) {
        int i2;
        Context context;
        en enVar;
        g gVar = dVar.c;
        AMapLocationClientOption aMapLocationClientOption = dVar.a;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        gVar.c = aMapLocationClientOption;
        if (!(gVar.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors || gVar.a == null)) {
            gVar.a.removeMessages(8);
        }
        if (gVar.r != gVar.c.getGeoLanguage()) {
            synchronized (gVar.o) {
                g.y = null;
            }
        }
        gVar.r = gVar.c.getGeoLanguage();
        if (dVar.C && !dVar.a.getLocationMode().equals(dVar.o)) {
            dVar.k();
            dVar.j();
        }
        dVar.o = dVar.a.getLocationMode();
        if (dVar.q != null) {
            if (dVar.a.isOnceLocation()) {
                enVar = dVar.q;
                context = dVar.A;
                i2 = 0;
            } else {
                enVar = dVar.q;
                context = dVar.A;
                i2 = 1;
            }
            enVar.a(context, i2);
            dVar.q.a(dVar.A, dVar.a);
        }
    }

    static /* synthetic */ void h(d dVar) {
        try {
            if (dVar.i != null) {
                dVar.f1360l = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", ej.a(dVar.a));
                dVar.a(2, bundle);
                return;
            }
            int i2 = dVar.f1360l + 1;
            dVar.f1360l = i2;
            if (i2 < 10) {
                dVar.a(1008, (Object) null, 50);
            }
        } catch (Throwable th) {
            ej.a(th, "ALManager", "startAssistantLocationImpl");
        }
    }

    static /* synthetic */ void i(d dVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", ej.a(dVar.a));
            dVar.a(3, bundle);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "stopAssistantLocationImpl");
        }
    }

    private boolean i() {
        boolean z2 = false;
        int i2 = 0;
        do {
            try {
                if (this.i != null) {
                    break;
                }
                Thread.sleep(100);
                i2++;
            } catch (Throwable th) {
                ej.a(th, "ALManager", "checkAPSManager");
            }
        } while (i2 < 50);
        if (this.i == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!ep.l(this.A.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.b.sendMessage(obtain);
        } else {
            z2 = true;
        }
        if (!z2) {
            en.a((String) null, !ep.l(this.A.getApplicationContext()) ? 2103 : 2101);
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public synchronized void j() {
        if (this.a == null) {
            this.a = new AMapLocationClientOption();
        }
        if (!this.C) {
            this.C = true;
            int i2 = AnonymousClass2.a[this.a.getLocationMode().ordinal()];
            long j2 = 0;
            if (i2 == 1) {
                a(1017, (Object) null, 0);
                a(1016, (Object) null, 0);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    a(1015, (Object) null, 0);
                    if (this.a.isGpsFirst() && this.a.isOnceLocation()) {
                        j2 = this.a.getGpsFirstTimeout();
                    }
                    a(1016, (Object) null, j2);
                }
            } else {
                a(1016);
                a(1015, (Object) null, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        try {
            a(1025);
            g gVar = this.c;
            if (gVar != null) {
                gVar.a();
            }
            a(1016);
            this.C = false;
            this.f1360l = 0;
        } catch (Throwable th) {
            ej.a(th, "ALManager", "stopLocation");
        }
    }

    private void l() {
        if (this.a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j2 = 1000;
            if (this.a.getInterval() >= 1000) {
                j2 = this.a.getInterval();
            }
            a(1016, (Object) null, j2);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        try {
            if (this.j == null) {
                this.j = new Messenger(this.b);
            }
            try {
                this.A.bindService(n(), this.H, 1);
            } catch (Throwable th) {
                ej.a(th, "ALManager", "startServiceImpl");
            }
        } catch (Throwable unused) {
        }
    }

    private Intent n() {
        String str;
        if (this.k == null) {
            this.k = new Intent(this.A, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : k.f(this.A);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.k.putExtra("a", str);
        this.k.putExtra("b", k.c(this.A));
        this.k.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.k;
    }

    private boolean o() {
        if (ep.k(this.A)) {
            int i2 = -1;
            try {
                i2 = em.b(((Application) this.A.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public final void a(int i2, Notification notification) {
        if (i2 != 0 && notification != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("i", i2);
                bundle.putParcelable("h", notification);
                a(1023, bundle, 0);
            } catch (Throwable th) {
                ej.a(th, "ALManager", "disableBackgroundLocation");
            }
        }
    }

    public final void a(WebView webView) {
        if (this.G == null) {
            this.G = new h(this.A, webView);
        }
        this.G.a();
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            a(1018, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void a(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "setLocationListener");
        }
    }

    public final void a(boolean z2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z2);
            a(1024, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean a() {
        return this.B;
    }

    public final void b() {
        try {
            a(1003, (Object) null, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "startLocation");
        }
    }

    public final void b(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void c() {
        try {
            a(1004, (Object) null, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "stopLocation");
        }
    }

    public final void d() {
        try {
            h hVar = this.G;
            if (hVar != null) {
                hVar.b();
                this.G = null;
            }
            a(1011, (Object) null, 0);
            this.n = true;
        } catch (Throwable th) {
            ej.a(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation e() {
        AMapLocation aMapLocation = null;
        try {
            i iVar = this.h;
            if (!(iVar == null || (aMapLocation = iVar.b()) == null)) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            ej.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void f() {
        try {
            a(1008, (Object) null, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "startAssistantLocation");
        }
    }

    public final void g() {
        try {
            h hVar = this.G;
            if (hVar != null) {
                hVar.b();
                this.G = null;
            }
            a(1009, (Object) null, 0);
        } catch (Throwable th) {
            ej.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    final void h() {
        a(12, (Bundle) null);
        this.g = true;
        this.B = false;
        this.r = false;
        k();
        en enVar = this.q;
        if (enVar != null) {
            enVar.b(this.A);
        }
        en.a(this.A);
        e eVar = this.s;
        if (eVar != null) {
            eVar.d.sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.H;
            if (serviceConnection != null) {
                this.A.unbindService(serviceConnection);
            }
        }
        try {
            if (this.z) {
                this.A.stopService(n());
            }
        } catch (Throwable unused) {
        }
        this.z = false;
        ArrayList<AMapLocationListener> arrayList = this.d;
        if (arrayList != null) {
            arrayList.clear();
            this.d = null;
        }
        this.H = null;
        synchronized (this.p) {
            a aVar = this.x;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.x = null;
        }
        if (this.m != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    em.a(this.m, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                }
            }
            this.m.quit();
        }
        this.m = null;
        c cVar = this.b;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        i iVar = this.h;
        if (iVar != null) {
            iVar.c();
            this.h = null;
        }
    }
}
