package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.f;
import com.bytedance.sdk.openadsdk.j.g;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: AdLocationUtils */
public class d {
    private static long a = 1800000;
    private static Handler b = new Handler(Looper.getMainLooper());

    public static c a(Context context) {
        if (!i.d().e().isCanUseLocation() && i.d().e().getTTLocation() == null) {
            return null;
        }
        Context a2 = context == null ? p.a() : context.getApplicationContext();
        a = (long) (p.h().l() * 60 * 1000);
        c c = c(a2);
        if (!b(a2)) {
            return c;
        }
        return d(a2);
    }

    private static boolean b(Context context) {
        long longValue = com.bytedance.sdk.openadsdk.core.d.a(context).b("lbstime", -1L).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > a;
    }

    private static c c(Context context) {
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
        float b2 = a2.b("latitude", -1.0f);
        float b3 = a2.b("longitude", -1.0f);
        if (b2 == -1.0f || b3 == -1.0f) {
            return null;
        }
        return new c(b2, b3);
    }

    private static c d(final Context context) {
        c cVar = null;
        if (!i.d().e().isCanUseLocation()) {
            try {
                TTLocation a2 = a();
                if (a2 != null) {
                    a(context, a2);
                    return new c(Double.valueOf(a2.getLatitude()).floatValue(), Double.valueOf(a2.getLongitude()).floatValue());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                Location a3 = a(locationManager);
                if (a3 != null && b(a3)) {
                    b(context, a3);
                    cVar = new c((float) a3.getLatitude(), (float) a3.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.utils.d.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            d.b(context, locationManager);
                        }
                    });
                } else {
                    b(context, locationManager);
                }
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
            }
        }
        return cVar;
    }

    private static Location a(LocationManager locationManager) {
        Location a2 = a(locationManager, "gps");
        if (a2 == null) {
            a2 = a(locationManager, "network");
        }
        return a2 == null ? a(locationManager, "passive") : a2;
    }

    private static Location a(LocationManager locationManager, String str) {
        try {
            final f fVar = new f(new b(locationManager, str), 1, 2);
            e.a().execute(new g() {
                /* class com.bytedance.sdk.openadsdk.utils.d.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            return (Location) fVar.get(1, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static TTLocation a() {
        try {
            final f fVar = new f(new a(), 1, 2);
            e.a().execute(new g() {
                /* class com.bytedance.sdk.openadsdk.utils.d.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            TTLocation tTLocation = (TTLocation) fVar.get(1, TimeUnit.SECONDS);
            u.b("AdLocationUtils", "location dev:" + tTLocation);
            return tTLocation;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: AdLocationUtils */
    private static class b implements Callable<Location> {
        private LocationManager a;
        private String b;

        public b(LocationManager locationManager, String str) {
            this.a = locationManager;
            this.b = str;
        }

        /* renamed from: a */
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.a.getLastKnownLocation(this.b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            u.b("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    /* compiled from: AdLocationUtils */
    private static class a implements Callable<TTLocation> {
        private a() {
        }

        /* renamed from: a */
        public TTLocation call() throws Exception {
            return i.d().e().getTTLocation();
        }
    }

    private static String b(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void b(final Context context, final LocationManager locationManager) {
        if (context != null && locationManager != null) {
            final AnonymousClass4 r0 = new LocationListener() {
                /* class com.bytedance.sdk.openadsdk.utils.d.AnonymousClass4 */

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    if (location != null && d.b(location)) {
                        d.b(context, location);
                    }
                    d.b(locationManager, this);
                }
            };
            try {
                String b2 = b(locationManager);
                if (!TextUtils.isEmpty(b2)) {
                    locationManager.requestSingleUpdate(b2, r0, Looper.getMainLooper());
                    b.postDelayed(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.utils.d.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            d.b(locationManager, r0);
                        }
                    }, 30000);
                }
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
                b(locationManager, r0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager != null && locationListener != null) {
            try {
                locationManager.removeUpdates(locationListener);
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, Location location) {
        if (b(location)) {
            com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
            a2.a("latitude", (float) location.getLatitude());
            a2.a("longitude", (float) location.getLongitude());
            a2.a("lbstime", System.currentTimeMillis());
        }
    }

    private static void a(Context context, TTLocation tTLocation) {
        if (tTLocation != null && tTLocation.getLatitude() != 0.0d && tTLocation.getLongitude() != 0.0d) {
            com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
            a2.a("latitude", (float) tTLocation.getLatitude());
            a2.a("longitude", (float) tTLocation.getLongitude());
            a2.a("lbstime", System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
