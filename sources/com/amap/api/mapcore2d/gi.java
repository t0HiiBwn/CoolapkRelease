package com.amap.api.mapcore2d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

/* compiled from: MapNetLocation */
public final class gi {
    Context a = null;
    boolean b = false;
    String c = null;
    long d = 0;
    private go e = null;
    private gn f = null;
    private a g = null;
    private gq h = null;
    private ConnectivityManager i = null;
    private gs j = null;
    private StringBuilder k = new StringBuilder();
    private Inner_3dMap_locationOption l = null;
    private gg m = null;
    private final String n = "\"status\":\"0\"";
    private final String o = "</body></html>";

    /* compiled from: MapNetLocation */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(gi giVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (gi.this.e != null) {
                                gi.this.e.c();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && gi.this.e != null) {
                            gi.this.e.d();
                        }
                    }
                } catch (Throwable th) {
                    gu.a(th, "MapNetLocation", "onReceive");
                }
            }
        }
    }

    public gi(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            gy.b(applicationContext);
            a(this.a);
            this.l = new Inner_3dMap_locationOption();
            if (this.e == null) {
                go goVar = new go(this.a, (WifiManager) gy.a(this.a, "wifi"));
                this.e = goVar;
                goVar.a(this.b);
            }
            if (this.f == null) {
                this.f = new gn(this.a);
            }
            if (this.h == null) {
                this.h = gq.a(this.a);
            }
            if (this.i == null) {
                this.i = (ConnectivityManager) gy.a(this.a, "connectivity");
            }
            this.j = new gs();
            c();
        } catch (Throwable th) {
            gu.a(th, "MapNetLocation", "<init>");
        }
    }

    private static gg a(gg ggVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return gc.a().a(ggVar);
        }
        if (strArr[0].equals("shake")) {
            return gc.a().a(ggVar);
        }
        if (!strArr[0].equals("fusion")) {
            return ggVar;
        }
        gc.a();
        return gc.b(ggVar);
    }

    private void a(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(db.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.b = true;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(long j2) {
        if (gy.b() - j2 < 800) {
            long j3 = 0;
            if (gk.a(this.m)) {
                j3 = gy.a() - this.m.getTime();
            }
            if (j3 <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        try {
            if (this.g == null) {
                this.g = new a(this, (byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.a.registerReceiver(this.g, intentFilter);
            this.e.b(false);
            this.f.f();
        } catch (Throwable th) {
            gu.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private gg d() throws Exception {
        String str;
        String str2;
        StringBuilder sb;
        gg ggVar = new gg("");
        go goVar = this.e;
        if (goVar == null || !goVar.g()) {
            try {
                if (this.j == null) {
                    this.j = new gs();
                }
                this.j.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
                gj gjVar = new gj();
                byte[] bArr = null;
                try {
                    try {
                        ey a2 = this.h.a(this.h.a(this.a, this.j.a(), gu.a()));
                        if (a2 != null) {
                            bArr = a2.a;
                            str = a2.c;
                        } else {
                            str = "";
                        }
                        if (bArr == null || bArr.length == 0) {
                            ggVar.setErrorCode(4);
                            this.k.append("please check the network");
                            if (!TextUtils.isEmpty(str)) {
                                StringBuilder sb2 = this.k;
                                sb2.append(" #csid:" + str);
                            }
                            ggVar.setLocationDetail(this.k.toString());
                            return ggVar;
                        }
                        String str3 = new String(bArr, "UTF-8");
                        if (str3.contains("\"status\":\"0\"")) {
                            return gjVar.a(str3, this.a, a2);
                        }
                        if (str3.contains("</body></html>")) {
                            ggVar.setErrorCode(5);
                            go goVar2 = this.e;
                            if (goVar2 == null || !goVar2.a(this.i)) {
                                sb = this.k;
                                str2 = "request may be intercepted";
                            } else {
                                sb = this.k;
                                str2 = "make sure you are logged in to the network";
                            }
                            sb.append(str2);
                            if (!TextUtils.isEmpty(str)) {
                                StringBuilder sb3 = this.k;
                                sb3.append(" #csid:" + str);
                            }
                            ggVar.setLocationDetail(this.k.toString());
                            return ggVar;
                        }
                        byte[] a3 = gp.a(bArr);
                        if (a3 == null) {
                            ggVar.setErrorCode(5);
                            this.k.append("decrypt response data error");
                            if (!TextUtils.isEmpty(str)) {
                                StringBuilder sb4 = this.k;
                                sb4.append(" #csid:" + str);
                            }
                            ggVar.setLocationDetail(this.k.toString());
                            return ggVar;
                        }
                        gg a4 = gjVar.a(a3);
                        if (a4 == null) {
                            gg ggVar2 = new gg("");
                            ggVar2.setErrorCode(5);
                            this.k.append("location is null");
                            if (!TextUtils.isEmpty(str)) {
                                StringBuilder sb5 = this.k;
                                sb5.append(" #csid:" + str);
                            }
                            ggVar2.setLocationDetail(this.k.toString());
                            return ggVar2;
                        }
                        this.c = a4.a();
                        if (a4.getErrorCode() != 0) {
                            if (!TextUtils.isEmpty(str)) {
                                a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str);
                            }
                            return a4;
                        } else if (gk.a(a4)) {
                            a4.e();
                            if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                                if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || "14".equals(a4.d()) || "24".equals(a4.d()) || "-1".equals(a4.d())) {
                                    a4.setLocationType(5);
                                } else {
                                    a4.setLocationType(6);
                                }
                                this.k.append(a4.d());
                                if (!TextUtils.isEmpty(str)) {
                                    StringBuilder sb6 = this.k;
                                    sb6.append(" #csid:" + str);
                                }
                                a4.setLocationDetail(this.k.toString());
                            }
                            return a4;
                        } else {
                            String b2 = a4.b();
                            a4.setErrorCode(6);
                            StringBuilder sb7 = this.k;
                            StringBuilder sb8 = new StringBuilder("location faile retype:");
                            sb8.append(a4.d());
                            sb8.append(" rdesc:");
                            if (b2 == null) {
                                b2 = "null";
                            }
                            sb8.append(b2);
                            sb7.append(sb8.toString());
                            if (!TextUtils.isEmpty(str)) {
                                StringBuilder sb9 = this.k;
                                sb9.append(" #csid:" + str);
                            }
                            a4.setLocationDetail(this.k.toString());
                            return a4;
                        }
                    } catch (Throwable th) {
                        gu.a(th, "MapNetLocation", "getApsLoc req");
                        ggVar.setErrorCode(4);
                        this.k.append("please check the network");
                        ggVar.setLocationDetail(this.k.toString());
                        return ggVar;
                    }
                } catch (Throwable th2) {
                    gu.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                    ggVar.setErrorCode(3);
                    StringBuilder sb10 = this.k;
                    sb10.append("buildV4Dot2 error " + th2.getMessage());
                    ggVar.setLocationDetail(this.k.toString());
                    return ggVar;
                }
            } catch (Throwable th3) {
                gu.a(th3, "MapNetLocation", "getApsLoc");
                StringBuilder sb11 = this.k;
                sb11.append("get parames error:" + th3.getMessage());
                ggVar.setErrorCode(3);
                ggVar.setLocationDetail(this.k.toString());
                return ggVar;
            }
        } else {
            ggVar.setErrorCode(15);
            return ggVar;
        }
    }

    public final Inner_3dMap_location a() {
        if (this.k.length() > 0) {
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
        if (a(this.d) && gk.a(this.m)) {
            return this.m;
        }
        this.d = gy.b();
        if (this.a == null) {
            this.k.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f.f();
        } catch (Throwable th) {
            gu.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.e.b(true);
        } catch (Throwable th2) {
            gu.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            gg d2 = d();
            this.m = d2;
            this.m = a(d2, new String[0]);
        } catch (Throwable th3) {
            gu.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.m;
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.l = new Inner_3dMap_locationOption();
        }
        try {
            go goVar = this.e;
            this.l.isWifiActiveScan();
            goVar.c(this.l.isWifiScan());
        } catch (Throwable unused) {
        }
        try {
            this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
        } catch (Throwable unused2) {
        }
    }

    public final void b() {
        a aVar;
        this.b = false;
        this.c = null;
        try {
            Context context = this.a;
            if (!(context == null || (aVar = this.g) == null)) {
                context.unregisterReceiver(aVar);
            }
            gn gnVar = this.f;
            if (gnVar != null) {
                gnVar.g();
            }
            go goVar = this.e;
            if (goVar != null) {
                goVar.h();
            }
            this.g = null;
        } catch (Throwable unused) {
            this.g = null;
        }
    }
}
