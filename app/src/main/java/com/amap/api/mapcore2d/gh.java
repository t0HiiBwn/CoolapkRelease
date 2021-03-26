package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MapLocationService */
public final class gh {
    private static int m = 200;
    private static boolean n = true;
    Context a = null;
    ga b = null;
    gi c = null;
    b d = null;
    Handler e = null;
    Handler f = null;
    boolean g = false;
    boolean h = false;
    Inner_3dMap_locationOption i = null;
    final int j = 500;
    final int k = 30;

    /* renamed from: l  reason: collision with root package name */
    Object f1233l = new Object();
    private JSONArray o = null;

    /* compiled from: MapLocationService */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 1) {
                gh.this.b();
            }
        }
    }

    /* compiled from: MapLocationService */
    static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public gh(Context context, Handler handler) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.f = handler;
                this.i = new Inner_3dMap_locationOption();
                f();
                e();
            } catch (Throwable th) {
                gu.a(th, "LocationService", "<init>");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private void a(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (!n || inner_3dMap_location == null || inner_3dMap_location.getErrorCode() != 0) {
                return;
            }
            if (inner_3dMap_location.getLocationType() == 1) {
                if (this.o == null) {
                    this.o = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lon", inner_3dMap_location.getLongitude());
                jSONObject.put("lat", inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", gy.a());
                JSONArray put = this.o.put(jSONObject);
                this.o = put;
                if (put.length() >= m) {
                    h();
                }
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "recordOfflineLocLog");
        }
    }

    private void e() {
        b bVar = new b("locServiceAction");
        this.d = bVar;
        bVar.setPriority(5);
        this.d.start();
        this.e = new a(this.d.getLooper());
    }

    private void f() {
        try {
            if (this.i == null) {
                this.i = new Inner_3dMap_locationOption();
            }
            if (!this.h) {
                this.b = new ga(this.a);
                gi giVar = new gi(this.a);
                this.c = giVar;
                giVar.a(this.i);
                g();
                this.h = true;
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "init");
        }
    }

    private void g() {
        try {
            n = gx.b(this.a, "maploc", "ue");
            int a2 = gx.a(this.a, "maploc", "opn");
            m = a2;
            if (a2 > 500) {
                m = 500;
            }
            if (m < 30) {
                m = 30;
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void h() {
        try {
            JSONArray jSONArray = this.o;
            if (jSONArray != null && jSONArray.length() > 0) {
                fe.a(new fd(this.a, gu.b(), this.o.toString()), this.a);
                this.o = null;
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "writeOfflineLog");
        }
    }

    private void i() {
        synchronized (this.f1233l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.e = null;
        }
    }

    private void j() {
        synchronized (this.f1233l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public final void a() {
        try {
            f();
            if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && !this.g) {
                this.g = true;
                this.b.a();
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "getLocation");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.i = new Inner_3dMap_locationOption();
        }
        gi giVar = this.c;
        if (giVar != null) {
            giVar.a(inner_3dMap_locationOption);
        }
    }

    final void b() {
        Inner_3dMap_location inner_3dMap_location = null;
        try {
            if (this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.g) {
                this.b.b();
                this.g = false;
            }
            if (this.b.c()) {
                inner_3dMap_location = this.b.d();
            } else if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
                inner_3dMap_location = this.c.a();
            }
            if (!(this.f == null || inner_3dMap_location == null)) {
                Message obtain = Message.obtain();
                obtain.obj = inner_3dMap_location;
                obtain.what = 1;
                this.f.sendMessage(obtain);
            }
            a(inner_3dMap_location);
        } catch (Throwable th) {
            gu.a(th, "LocationService", "doGetLocation");
        }
    }

    public final void c() {
        this.g = false;
        try {
            j();
            ga gaVar = this.b;
            if (gaVar != null) {
                gaVar.b();
            }
        } catch (Throwable th) {
            gu.a(th, "LocationService", "stopLocation");
        }
    }

    public final void d() {
        b bVar;
        try {
            c();
            i();
            if (this.d != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        gw.a(this.d, HandlerThread.class, "quitSafely", new Object[0]);
                    } catch (Throwable unused) {
                        bVar = this.d;
                    }
                } else {
                    bVar = this.d;
                    bVar.quit();
                }
            }
            this.d = null;
            this.c.b();
            this.g = false;
            this.h = false;
            h();
        } catch (Throwable th) {
            gu.a(th, "LocationService", "destroy");
        }
    }
}
