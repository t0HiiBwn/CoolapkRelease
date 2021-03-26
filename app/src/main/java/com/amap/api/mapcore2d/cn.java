package com.amap.api.mapcore2d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

/* compiled from: AMapLocationClient */
public class cn {
    Context a;
    Inner_3dMap_locationManagerBase b = null;
    Object c = null;
    boolean d = false;
    gb e = null;
    da f = null;

    public cn(Context context) {
        try {
            this.f = gk.a();
        } catch (Throwable unused) {
        }
        this.e = new gb();
        a(context);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                try {
                    Class<?> cls = Class.forName("com.amap.api.location.AMapLocationClient");
                    ServiceInfo serviceInfo = null;
                    try {
                        serviceInfo = this.a.getPackageManager().getServiceInfo(new ComponentName(this.a, "com.amap.api.location.APSService"), 128);
                    } catch (Throwable unused) {
                    }
                    if (!(cls == null || serviceInfo == null)) {
                        this.d = true;
                    }
                } catch (Throwable unused2) {
                    this.d = false;
                }
                if (this.d) {
                    this.c = new AMapLocationClient(this.a);
                } else {
                    this.b = b(this.a);
                }
            } catch (Throwable th) {
                gu.a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private Inner_3dMap_locationManagerBase b(Context context) {
        Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase;
        try {
            inner_3dMap_locationManagerBase = (Inner_3dMap_locationManagerBase) ef.a(context, this.f, db.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), gd.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable unused) {
            inner_3dMap_locationManagerBase = new gd(context);
        }
        return inner_3dMap_locationManagerBase == null ? new gd(context) : inner_3dMap_locationManagerBase;
    }

    public void a() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            gu.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.d) {
                    this.e.a(this.c, inner_3dMap_locationListener);
                } else {
                    this.b.setLocationListener(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                gu.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption != null) {
            try {
                if (this.d) {
                    gb.a(this.c, inner_3dMap_locationOption);
                } else {
                    this.b.setLocationOption(inner_3dMap_locationOption);
                }
            } catch (Throwable th) {
                gu.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public void b() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            gu.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void c() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
            if (this.e != null) {
                this.e = null;
            }
        } catch (Throwable th) {
            gu.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
