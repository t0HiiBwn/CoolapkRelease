package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MapLocationManager */
public class gd implements Inner_3dMap_locationManagerBase {
    Context a = null;
    ArrayList<Inner_3dMap_locationListener> b = new ArrayList<>();
    Object c = new Object();
    Handler d = null;
    a e = null;
    Handler f = null;
    Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
    gh h = null;
    Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    boolean j = false;

    /* compiled from: MapLocationManager */
    static class a extends HandlerThread {
        gd a;

        public a(String str, gd gdVar) {
            super(str);
            this.a = gdVar;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.a.h = new gh(this.a.a, this.a.d);
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

    public gd(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
            e();
            return;
        }
        throw new IllegalArgumentException("Context参数不能为null");
    }

    private Handler a(Looper looper) {
        ge geVar;
        synchronized (this.c) {
            geVar = new ge(looper, this);
            this.f = geVar;
        }
        return geVar;
    }

    private void a(int i2) {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(i2);
            }
        }
    }

    private void a(int i2, Object obj, long j2) {
        synchronized (this.c) {
            if (this.f != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = obj;
                this.f.sendMessageDelayed(obtain, j2);
            }
        }
    }

    private void e() {
        try {
            this.d = Looper.myLooper() == null ? new gf(this.a.getMainLooper(), this) : new gf(this);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "initResultHandler");
        }
        try {
            a aVar = new a("locaitonClientActionThread", this);
            this.e = aVar;
            aVar.setPriority(5);
            this.e.start();
            this.f = a(this.e.getLooper());
        } catch (Throwable th2) {
            gu.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void f() {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }
    }

    final void a() {
        try {
            if (!this.j) {
                this.j = true;
                a(1005, null, 0);
            }
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    final void a(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (gk.a(inner_3dMap_location)) {
                    gb.a = inner_3dMap_location;
                }
            } catch (Throwable th) {
                gu.a(th, "MapLocationManager", "callBackLocation");
                return;
            }
        }
        if (this.j) {
            if (!"gps".equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                inner_3dMap_location.setProvider("lbs");
            }
            inner_3dMap_location.setAltitude(gy.b(inner_3dMap_location.getAltitude()));
            inner_3dMap_location.setBearing(gy.a(inner_3dMap_location.getBearing()));
            inner_3dMap_location.setSpeed(gy.a(inner_3dMap_location.getSpeed()));
            Iterator<Inner_3dMap_locationListener> it2 = this.b.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().onLocationChanged(inner_3dMap_location);
                } catch (Throwable unused) {
                }
            }
        }
        if (this.g.isOnceLocation()) {
            c();
        }
    }

    final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                if (!this.b.contains(inner_3dMap_locationListener)) {
                    this.b.add(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                gu.a(th, "MapLocationManager", "doSetLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.g = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.g = new Inner_3dMap_locationOption();
        }
        gh ghVar = this.h;
        if (ghVar != null) {
            ghVar.a(this.g);
        }
        if (this.j && !this.i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.i = this.g.getLocationMode();
    }

    final void b() {
        long j2 = 1000;
        try {
            gh ghVar = this.h;
            if (ghVar != null) {
                ghVar.a();
            }
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(1005, null, j2);
            }
        } catch (Throwable th) {
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(1005, null, j2);
            }
            throw th;
        }
    }

    final void b(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.b.isEmpty() && this.b.contains(inner_3dMap_locationListener)) {
                    this.b.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                gu.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.b.isEmpty()) {
            c();
        }
    }

    final void c() {
        try {
            this.j = false;
            a(1004);
            a(1005);
            gh ghVar = this.h;
            if (ghVar != null) {
                ghVar.c();
            }
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    final void d() {
        c();
        gh ghVar = this.h;
        if (ghVar != null) {
            ghVar.d();
        }
        ArrayList<Inner_3dMap_locationListener> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
        f();
        if (this.e != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    gw.a(this.e, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                }
            }
            this.e.quit();
        }
        this.e = null;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void destroy() {
        try {
            a(1007, null, 0);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public Inner_3dMap_location getLastKnownLocation() {
        return gb.a;
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0);
        } catch (Throwable th) {
            gu.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void startLocation() {
        try {
            a(1004, null, 0);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "startLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void stopLocation() {
        try {
            a(1006, null, 0);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            gu.a(th, "MapLocationManager", "stopLocation");
        }
    }
}
