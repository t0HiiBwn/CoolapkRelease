package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GpsLocation */
public final class g {
    static AMapLocation j;
    static long k;

    /* renamed from: l  reason: collision with root package name */
    static Object f1378l = new Object();
    static long q;
    static boolean t;
    static boolean u;
    public static volatile AMapLocation y;
    private long A = 0;
    private int B = 0;
    private int C = 0;
    private GpsStatus D = null;
    private GpsStatus.Listener E = new GpsStatus.Listener() {
        /* class com.loc.g.AnonymousClass1 */

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            Iterable<GpsSatellite> satellites;
            try {
                if (g.this.b != null) {
                    g gVar = g.this;
                    gVar.D = gVar.b.getGpsStatus(g.this.D);
                    int i2 = 0;
                    if (i == 2) {
                        g.this.C = 0;
                    } else if (i == 4) {
                        try {
                            if (!(g.this.D == null || (satellites = g.this.D.getSatellites()) == null)) {
                                Iterator<GpsSatellite> it2 = satellites.iterator();
                                int maxSatellites = g.this.D.getMaxSatellites();
                                while (it2.hasNext() && i2 < maxSatellites) {
                                    if (it2.next().usedInFix()) {
                                        i2++;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ej.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
                        }
                        g.this.C = i2;
                    }
                }
            } catch (Throwable th2) {
                ej.a(th2, "GpsLocation", "onGpsStatusChanged");
            }
        }
    };
    private String F = null;
    private boolean G = false;
    private int H = 0;
    private boolean I = false;
    Handler a;
    LocationManager b;
    AMapLocationClientOption c;
    long d = 0;
    boolean e = false;
    dr f = null;
    int g = 240;
    int h = 80;
    AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    long v = 0;
    int w = 0;
    LocationListener x = null;
    private Context z;

    /* compiled from: GpsLocation */
    static class a implements LocationListener {
        private g a;

        a(g gVar) {
            this.a = gVar;
        }

        final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                g gVar = this.a;
                if (gVar != null) {
                    g.a(gVar, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                g gVar = this.a;
                if (gVar != null) {
                    g.a(gVar, str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                g gVar = this.a;
                if (gVar != null) {
                    g.a(gVar, i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public g(Context context, Handler handler) {
        this.z = context;
        this.a = handler;
        try {
            this.b = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            ej.a(th, "GpsLocation", "<init>");
        }
        this.f = new dr();
    }

    private void a(int i2, int i3, String str, long j2) {
        try {
            if (this.a != null && this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.setErrorCode(i3);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(1);
                obtain.obj = aMapLocation;
                obtain.what = i2;
                this.a.sendMessageDelayed(obtain, j2);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode())) {
            return;
        }
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
            b(aMapLocation);
        } else if (ep.b() - this.v >= this.c.getInterval() - 200) {
            this.v = ep.b();
            b(aMapLocation);
        }
    }

    static /* synthetic */ void a(g gVar, int i2) {
        if (i2 == 0) {
            try {
                gVar.d = 0;
                gVar.C = 0;
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void a(g gVar, Location location) {
        Handler handler;
        String str;
        Handler handler2 = gVar.a;
        if (handler2 != null) {
            handler2.removeMessages(8);
        }
        if (location != null) {
            try {
                AMapLocation aMapLocation = new AMapLocation(location);
                if (ep.a(aMapLocation)) {
                    aMapLocation.setProvider("gps");
                    aMapLocation.setLocationType(1);
                    if (!gVar.e && ep.a(aMapLocation)) {
                        en.a(gVar.z, ep.b() - gVar.A, ej.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                        gVar.e = true;
                    }
                    if (ep.a(location, gVar.C)) {
                        aMapLocation.setMock(true);
                        aMapLocation.setTrustedLevel(4);
                        if (!gVar.c.isMockEnable()) {
                            int i2 = gVar.w;
                            if (i2 > 3) {
                                en.a((String) null, 2152);
                                aMapLocation.setErrorCode(15);
                                aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                                aMapLocation.setLatitude(0.0d);
                                aMapLocation.setLongitude(0.0d);
                                aMapLocation.setAltitude(0.0d);
                                aMapLocation.setSpeed(0.0f);
                                aMapLocation.setAccuracy(0.0f);
                                aMapLocation.setBearing(0.0f);
                                aMapLocation.setExtras(null);
                                gVar.a(aMapLocation);
                                return;
                            }
                            gVar.w = i2 + 1;
                            return;
                        }
                    } else {
                        gVar.w = 0;
                    }
                    aMapLocation.setSatellites(gVar.C);
                    try {
                        if (!ej.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !gVar.c.isOffset()) {
                            aMapLocation.setOffset(false);
                            str = "WGS84";
                        } else {
                            DPoint a2 = el.a(gVar.z, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                            aMapLocation.setLatitude(a2.getLatitude());
                            aMapLocation.setLongitude(a2.getLongitude());
                            aMapLocation.setOffset(gVar.c.isOffset());
                            str = "GCJ02";
                        }
                        aMapLocation.setCoordType(str);
                    } catch (Throwable unused) {
                        aMapLocation.setOffset(false);
                        aMapLocation.setCoordType("WGS84");
                    }
                    try {
                        int i3 = gVar.C;
                        if (i3 >= 4) {
                            aMapLocation.setGpsAccuracyStatus(1);
                        } else if (i3 == 0) {
                            aMapLocation.setGpsAccuracyStatus(-1);
                        } else {
                            aMapLocation.setGpsAccuracyStatus(0);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (ep.a(aMapLocation) && ei.s()) {
                        long time = aMapLocation.getTime();
                        long currentTimeMillis = System.currentTimeMillis();
                        long a3 = ek.a(time, currentTimeMillis, ei.t());
                        if (a3 != time) {
                            aMapLocation.setTime(a3);
                            en.a(time, currentTimeMillis);
                        }
                    }
                    if (ep.a(aMapLocation) && gVar.B >= 3) {
                        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                            aMapLocation.setAccuracy(0.0f);
                        }
                        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                            aMapLocation.setSpeed(0.0f);
                        }
                        aMapLocation = gVar.f.a(aMapLocation);
                    }
                    if (ep.a(aMapLocation)) {
                        gVar.d = ep.b();
                        synchronized (f1378l) {
                            k = ep.b();
                            j = aMapLocation.clone();
                        }
                        gVar.B++;
                    }
                    if (ep.a(aMapLocation) && gVar.a != null && gVar.c.isNeedAddress()) {
                        long b2 = ep.b();
                        if (gVar.c.getInterval() <= 8000 || b2 - gVar.v > gVar.c.getInterval() - 8000) {
                            Bundle bundle = new Bundle();
                            bundle.putDouble("lat", aMapLocation.getLatitude());
                            bundle.putDouble("lon", aMapLocation.getLongitude());
                            Message obtain = Message.obtain();
                            obtain.setData(bundle);
                            obtain.what = 5;
                            synchronized (gVar.o) {
                                if (y == null) {
                                    handler = gVar.a;
                                } else if (ep.a(aMapLocation, y) > ((float) gVar.h)) {
                                    handler = gVar.a;
                                }
                                handler.sendMessage(obtain);
                            }
                        }
                    }
                    synchronized (gVar.o) {
                        AMapLocation aMapLocation2 = y;
                        if (aMapLocation2 != null && gVar.c.isNeedAddress() && ep.a(aMapLocation, aMapLocation2) < ((float) gVar.g)) {
                            ej.a(aMapLocation, aMapLocation2);
                        }
                    }
                    try {
                        if (ep.a(aMapLocation)) {
                            if (gVar.i != null) {
                                gVar.m = location.getTime() - gVar.i.getTime();
                                gVar.n = ep.a(gVar.i, aMapLocation);
                            }
                            synchronized (gVar.p) {
                                gVar.i = aMapLocation.clone();
                            }
                            gVar.F = null;
                            gVar.G = false;
                            gVar.H = 0;
                        }
                    } catch (Throwable th) {
                        ej.a(th, "GpsLocation", "onLocationChangedLast");
                    }
                    gVar.a(aMapLocation);
                }
            } catch (Throwable th2) {
                ej.a(th2, "GpsLocation", "onLocationChanged");
            }
        }
    }

    static /* synthetic */ void a(g gVar, String str) {
        try {
            if ("gps".equalsIgnoreCase(str)) {
                gVar.d = 0;
                gVar.C = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                u = false;
            } else {
                u = allProviders.contains("gps");
            }
            t = true;
            return u;
        } catch (Throwable unused) {
            return u;
        }
    }

    private boolean a(String str) {
        try {
            ArrayList<String> d2 = ep.d(str);
            ArrayList<String> d3 = ep.d(this.F);
            if (d2.size() < 8 || d3.size() < 8) {
                return false;
            }
            return ep.a(this.F, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(AMapLocation aMapLocation) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    private static boolean e() {
        try {
            return ((Boolean) em.a(u.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), u.c("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private AMapLocation f() {
        float f2;
        float f3;
        try {
            if (ep.a(this.i) && ei.j() && e()) {
                JSONObject jSONObject = new JSONObject((String) em.a(u.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), u.c("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.I) {
                    this.I = true;
                    en.a("useNaviLoc", "use NaviLoc");
                }
                if (ep.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f4 = 0.0f;
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f2 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f3 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f3 = 0.0f;
                    }
                    try {
                        f4 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f3);
                    aMapLocation.setSpeed(f4);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType("GCJ02");
                    if (ep.a(aMapLocation, this.i) <= 300.0f) {
                        synchronized (this.p) {
                            this.i.setLongitude(optDouble2);
                            this.i.setLatitude(optDouble);
                            this.i.setAccuracy(f2);
                            this.i.setBearing(f3);
                            this.i.setSpeed(f4);
                            this.i.setTime(optLong);
                            this.i.setCoordType("GCJ02");
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    public final AMapLocation a(AMapLocation aMapLocation, String str) {
        long j2;
        long b2;
        if (this.i == null) {
            return aMapLocation;
        }
        if ((!this.c.isMockEnable() && this.i.isMock()) || !ep.a(this.i)) {
            return aMapLocation;
        }
        AMapLocation f2 = f();
        if (f2 == null || !ep.a(f2)) {
            float speed = this.i.getSpeed();
            if (speed == 0.0f) {
                long j3 = this.m;
                if (j3 > 0 && j3 < 8) {
                    float f3 = this.n;
                    if (f3 > 0.0f) {
                        speed = f3 / ((float) j3);
                    }
                }
            }
            if (aMapLocation != null && ep.a(aMapLocation)) {
                if (aMapLocation.getAccuracy() < 200.0f) {
                    int i2 = this.H + 1;
                    this.H = i2;
                    if (this.F == null && i2 >= 2) {
                        this.G = true;
                    }
                    j2 = speed > 5.0f ? 10000 : 15000;
                } else {
                    if (!TextUtils.isEmpty(this.F)) {
                        this.G = false;
                        this.H = 0;
                    }
                    if (speed > 5.0f) {
                        j2 = 20000;
                    }
                }
                b2 = ep.b() - this.d;
                if (b2 <= 30000) {
                    return aMapLocation;
                }
                if (b2 < j2) {
                    if (this.F == null && this.H >= 2) {
                        this.F = str;
                    }
                    AMapLocation clone = this.i.clone();
                    clone.setTrustedLevel(2);
                    return clone;
                } else if (!this.G || !a(str)) {
                    this.F = null;
                    this.H = 0;
                    synchronized (this.p) {
                        this.i = null;
                    }
                    this.m = 0;
                    this.n = 0.0f;
                    return aMapLocation;
                } else {
                    AMapLocation clone2 = this.i.clone();
                    clone2.setTrustedLevel(3);
                    return clone2;
                }
            }
            j2 = 30000;
            b2 = ep.b() - this.d;
            if (b2 <= 30000) {
            }
        } else {
            f2.setTrustedLevel(2);
            return f2;
        }
    }

    public final void a() {
        LocationManager locationManager = this.b;
        if (locationManager != null) {
            try {
                LocationListener locationListener = this.x;
                if (locationListener != null) {
                    locationManager.removeUpdates(locationListener);
                    ((a) this.x).a();
                    this.x = null;
                }
            } catch (Throwable unused) {
            }
            try {
                GpsStatus.Listener listener = this.E;
                if (listener != null) {
                    this.b.removeGpsStatusListener(listener);
                }
            } catch (Throwable unused2) {
            }
            try {
                Handler handler = this.a;
                if (handler != null) {
                    handler.removeMessages(8);
                }
            } catch (Throwable unused3) {
            }
            this.C = 0;
            this.A = 0;
            this.v = 0;
            this.d = 0;
            this.B = 0;
            this.w = 0;
            this.f.a();
            this.i = null;
            this.m = 0;
            this.n = 0.0f;
            this.F = null;
            this.I = false;
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        LocationManager locationManager;
        String str;
        long j2;
        float f2;
        LocationListener locationListener;
        this.c = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.c = new AMapLocationClientOption();
        }
        try {
            q = eo.a(this.z, "pref", "lagt", q);
        } catch (Throwable unused) {
        }
        if (this.b != null) {
            try {
                if (ep.b() - k <= 5000 && ep.a(j) && (this.c.isMockEnable() || !j.isMock())) {
                    this.d = ep.b();
                    a(j);
                }
                this.s = true;
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    myLooper = this.z.getMainLooper();
                }
                this.A = ep.b();
                if (a(this.b)) {
                    try {
                        if (ep.a() - q >= 259200000) {
                            this.b.sendExtraCommand("gps", "force_xtra_injection", null);
                            q = ep.a();
                            SharedPreferences.Editor a2 = eo.a(this.z, "pref");
                            eo.a(a2, "lagt", q);
                            eo.a(a2);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (this.x == null) {
                        this.x = new a(this);
                    }
                    if (!this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) || this.c.getDeviceModeDistanceFilter() <= 0.0f) {
                        locationManager = this.b;
                        str = "gps";
                        j2 = 900;
                        f2 = 0.0f;
                        locationListener = this.x;
                    } else {
                        locationManager = this.b;
                        str = "gps";
                        j2 = this.c.getInterval();
                        f2 = this.c.getDeviceModeDistanceFilter();
                        locationListener = this.x;
                    }
                    locationManager.requestLocationUpdates(str, j2, f2, locationListener, myLooper);
                    this.b.addGpsStatusListener(this.E);
                    a(8, 14, "no enough satellites#1401", this.c.getHttpTimeOut());
                    return;
                }
                a(8, 14, "no gps provider#1402", 0);
            } catch (SecurityException e2) {
                this.s = false;
                en.a((String) null, 2121);
                a(2, 12, e2.getMessage() + "#1201", 0);
            } catch (Throwable th) {
                ej.a(th, "GpsLocation", "requestLocationUpdates part2");
            }
        }
    }

    public final boolean b() {
        return ep.b() - this.d <= 2800;
    }

    public final int c() {
        LocationManager locationManager = this.b;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int i2 = Settings.Secure.getInt(this.z.getContentResolver(), "location_mode", 0);
            if (i2 == 0) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
        } else if (!this.b.isProviderEnabled("gps")) {
            return 2;
        }
        return !this.s ? 4 : 0;
    }

    public final int d() {
        return this.C;
    }
}
