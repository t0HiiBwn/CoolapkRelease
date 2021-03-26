package com.amap.api.mapcore2d;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* compiled from: MapGpsLocation */
public final class ga {
    Context a;
    LocationManager b;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    Object g = null;
    boolean h = false;
    boolean i = false;
    LocationListener j = new LocationListener() {
        /* class com.amap.api.mapcore2d.ga.AnonymousClass1 */

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setProvider("gps");
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i);
                    inner_3dMap_location.setTime(gv.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                    ga.this.f = inner_3dMap_location;
                    ga.this.c = gy.b();
                    ga.this.d = true;
                } catch (Throwable th) {
                    gu.a(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equals(str)) {
                    ga.this.d = false;
                }
            } catch (Throwable th) {
                gu.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public ga(Context context) {
        if (context != null) {
            this.a = context;
            e();
            try {
                if (this.g == null && !this.i) {
                    this.g = this.h ? Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(Context.class).newInstance(context) : Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (context == null) {
                        this.i = true;
                    }
                }
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = (LocationManager) this.a.getSystemService("location");
            }
        }
    }

    private void e() {
        try {
            if (Class.forName("com.amap.api.maps.CoordinateConverter") != null) {
                this.h = true;
            }
        } catch (Throwable unused) {
        }
    }

    private void f() {
        try {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.a.getMainLooper();
            }
            try {
                this.b.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Throwable unused) {
            }
            this.b.requestLocationUpdates("gps", 800, 0.0f, this.j, myLooper);
        } catch (SecurityException unused2) {
        } catch (Throwable th) {
            gu.a(th, "MAPGPSLocation", "requestLocationUpdates");
        }
    }

    private void g() {
        this.d = false;
        this.c = 0;
        this.f = null;
    }

    public final void a() {
        if (!this.e) {
            f();
            this.e = true;
        }
    }

    public final void b() {
        LocationListener locationListener;
        this.e = false;
        g();
        LocationManager locationManager = this.b;
        if (locationManager != null && (locationListener = this.j) != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    public final boolean c() {
        if (!this.d) {
            return false;
        }
        if (gy.b() - this.c <= 10000) {
            return true;
        }
        this.f = null;
        return false;
    }

    public final Inner_3dMap_location d() {
        double[] a2;
        Object obj;
        Object obj2;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location clone = this.f.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (gu.a(clone.getLatitude(), clone.getLongitude())) {
                        Object[] objArr = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.h) {
                            obj2 = gw.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            obj = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(Double.TYPE, Double.TYPE).newInstance(Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude()));
                        } else {
                            obj2 = gw.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            obj = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(Double.TYPE, Double.TYPE).newInstance(Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude()));
                        }
                        gw.a(this.g, "coord", obj);
                        gw.a(this.g, "from", obj2);
                        Object a3 = gw.a(this.g, "convert", new Object[0]);
                        double doubleValue = ((Double) a3.getClass().getDeclaredField("latitude").get(a3)).doubleValue();
                        double doubleValue2 = ((Double) a3.getClass().getDeclaredField("longitude").get(a3)).doubleValue();
                        clone.setLatitude(doubleValue);
                        clone.setLongitude(doubleValue2);
                    }
                } else if (this.i && gu.a(clone.getLatitude(), clone.getLongitude()) && (a2 = fy.a(clone.getLongitude(), clone.getLatitude())) != null) {
                    clone.setLatitude(a2[1]);
                    clone.setLongitude(a2[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return clone;
    }
}
