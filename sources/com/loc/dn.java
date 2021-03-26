package com.loc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: Aps */
public final class dn {
    static int D = -1;
    private static boolean K;
    private static volatile boolean P;
    int A = 12;
    dt B = null;
    boolean C = false;
    dr E = null;
    String F = null;
    IntentFilter G = null;
    LocationManager H = null;
    private int I = 0;
    private String J = null;
    private String L = null;
    private boolean M = true;
    private Handler N;
    private String O;
    private Cdo Q;
    Context a = null;
    ConnectivityManager b = null;
    dx c = null;
    dw d = null;
    dz e = null;
    dp f = null;
    eg g = null;
    ArrayList<ScanResult> h = new ArrayList<>();
    a i = null;
    AMapLocationClientOption j = new AMapLocationClientOption();
    ds k = null;

    /* renamed from: l  reason: collision with root package name */
    long f1364l = 0;
    eh m = null;
    boolean n = false;
    ee o = null;
    StringBuilder p = new StringBuilder();
    boolean q = true;
    boolean r = true;
    AMapLocationClientOption.GeoLanguage s = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean t = true;
    boolean u = false;
    WifiInfo v = null;
    boolean w = true;
    StringBuilder x = null;
    boolean y = false;
    public boolean z = false;

    /* renamed from: com.loc.dn$1  reason: invalid class name */
    /* compiled from: Aps */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Aps */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (dn.this.c != null) {
                                dn.this.c.i();
                            }
                            try {
                                if (intent.getExtras() != null && intent.getExtras().getBoolean("resultsUpdated", true) && dn.this.c != null) {
                                    dn.this.c.h();
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && dn.this.c != null) {
                            dn.this.c.j();
                        }
                    }
                } catch (Throwable th) {
                    ej.a(th, "Aps", "onReceive");
                }
            }
        }
    }

    private static ds a(int i2, String str) {
        ds dsVar = new ds("");
        dsVar.setErrorCode(i2);
        dsVar.setLocationDetail(str);
        if (i2 == 15) {
            en.a((String) null, 2151);
        }
        return dsVar;
    }

    private ds a(ds dsVar, aw awVar, dm dmVar) {
        if (awVar != null) {
            try {
                if (awVar.a != null) {
                    if (awVar.a.length != 0) {
                        eg egVar = new eg();
                        String str = new String(awVar.a, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            ds a2 = egVar.a(str, this.a, awVar, dmVar);
                            a2.h(this.x.toString());
                            return a2;
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            dsVar.setErrorCode(5);
                            dx dxVar = this.c;
                            if (dxVar == null || !dxVar.a(this.b)) {
                                dmVar.f("#0502");
                                this.p.append("请求可能被劫持了#0502");
                                en.a((String) null, 2052);
                            } else {
                                dmVar.f("#0501");
                                this.p.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                en.a((String) null, 2051);
                            }
                            dsVar.setLocationDetail(this.p.toString());
                            return dsVar;
                        }
                    }
                }
            } catch (Throwable th) {
                dsVar.setErrorCode(4);
                ej.a(th, "Aps", "checkResponseEntity");
                dmVar.f("#0403");
                StringBuilder sb = this.p;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                dsVar.setLocationDetail(this.p.toString());
                return dsVar;
            }
        }
        dsVar.setErrorCode(4);
        this.p.append("网络异常,请求异常#0403");
        dmVar.f("#0403");
        dsVar.h(this.x.toString());
        dsVar.setLocationDetail(this.p.toString());
        if (awVar != null) {
            en.a(awVar.d, 2041);
        }
        return dsVar;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.m());
        sb.append(this.c.m());
        return sb;
    }

    private void a(dm dmVar, ef efVar, String str, String str2, String str3, int i2) {
        dmVar.b(str3);
        dmVar.c("FAIL");
        ec.a(this.a).a(false, i2);
        efVar.a(str);
        efVar.b(str2);
        if (this.o.a() > ei.q()) {
            efVar.a(ei.q() * 1000);
            efVar.b(ei.q() * 1000);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x034a  */
    private ds b(boolean z2, dm dmVar) {
        int i2;
        j th;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        long j2;
        aw awVar;
        ec a2;
        int i3;
        String str2;
        try {
            if (TextUtils.isEmpty(this.O)) {
                this.O = u.b(n.a(this.a) + "," + n.h(this.a));
            }
            StringBuilder sb3 = this.p;
            sb3.append("#id:");
            sb3.append(this.O);
        } catch (Throwable unused) {
        }
        String str3 = "";
        ds dsVar = new ds(str3);
        String str4 = null;
        try {
            if (this.m == null) {
                this.m = new eh();
            }
            if (this.j == null) {
                this.j = new AMapLocationClientOption();
            }
            this.m.a(this.a, this.j.isNeedAddress(), this.j.isOffset(), this.d, this.c, this.b, this.F);
            byte[] a3 = this.m.a();
            long b2 = ep.b();
            this.f1364l = b2;
            dmVar.a(b2);
            try {
                ej.c(this.a);
                ef a4 = this.o.a(this.a, a3, ej.a(), ej.b(), z2);
                String c2 = a4.c();
                String d2 = a4.d();
                l.a(this.a);
                boolean z3 = !TextUtils.isEmpty(d2) && d2.contains("dualstack");
                if (!l.a() || !l.c() || !z3) {
                    dmVar.a("v4");
                    String a5 = ec.a(this.a).a(a4, ec.a);
                    if (!TextUtils.isEmpty(a5)) {
                        try {
                            awVar = this.o.a(a4, 1);
                            j2 = ep.b();
                            dmVar.b(a5);
                            dmVar.c("SUCCESS");
                            ec.a(this.a).a(true, ec.a);
                        } catch (Throwable unused2) {
                            a(dmVar, a4, c2, d2, a5, ec.a);
                            awVar = this.o.a(a4, 1);
                            j2 = ep.b();
                            dmVar.d("SUCCESS");
                            ec.a(this.a).a(ec.a);
                        }
                    } else {
                        awVar = this.o.a(a4, 1);
                        j2 = ep.b();
                        dmVar.d("SUCCESS");
                    }
                    a2 = ec.a(this.a);
                    i3 = ec.a;
                } else {
                    dmVar.a("v6");
                    if (!l.b()) {
                        str4 = ec.a(this.a).a(a4, ec.b);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            awVar = this.o.a(a4, 2);
                            j2 = ep.b();
                            dmVar.b(str4);
                            dmVar.c("SUCCESS");
                        } catch (Throwable th2) {
                            th = th2;
                            ep.b();
                            dmVar.d("FAIL");
                            ec.a(this.a).a(false, ec.a);
                            ej.a(th, "Aps", "getApsLoc req");
                            en.a("/mobile/binary", th);
                            if (ep.d(this.a)) {
                            }
                            sb2.append(str);
                            ds a6 = a(i2, this.p.toString());
                            a6.h(this.x.toString());
                            return a6;
                        }
                    } else {
                        awVar = this.o.a(a4);
                        j2 = ep.b();
                        dmVar.d("SUCCESS");
                    }
                    a2 = ec.a(this.a);
                    i3 = ec.b;
                }
                a2.a(true, i3);
                Cdo doVar = this.Q;
                if (doVar != null) {
                    doVar.d();
                }
                dmVar.b(j2);
                if (awVar != null) {
                    if (!TextUtils.isEmpty(awVar.c)) {
                        StringBuilder sb4 = this.p;
                        sb4.append("#csid:" + awVar.c);
                    }
                    str2 = awVar.d;
                    dsVar.h(this.x.toString());
                } else {
                    str2 = str3;
                }
                ds a7 = a(dsVar, awVar, dmVar);
                if (a7 != null) {
                    return a7;
                }
                byte[] b3 = dy.b(awVar.a);
                if (b3 == null) {
                    dsVar.setErrorCode(5);
                    dmVar.f("#0503");
                    this.p.append("解密数据失败#0503");
                    dsVar.setLocationDetail(this.p.toString());
                    en.a(str2, 2053);
                    return dsVar;
                }
                ds a8 = this.g.a(dsVar, b3, dmVar);
                if (!ep.a(a8)) {
                    String b4 = a8.b();
                    this.J = b4;
                    en.a(str2, !TextUtils.isEmpty(b4) ? 2062 : 2061);
                    a8.setErrorCode(6);
                    dmVar.f("#0601");
                    StringBuilder sb5 = this.p;
                    StringBuilder sb6 = new StringBuilder("location faile retype:");
                    sb6.append(a8.d());
                    sb6.append(" rdesc:");
                    if (!TextUtils.isEmpty(this.J)) {
                        str3 = this.J;
                    }
                    sb6.append(str3);
                    sb6.append("#0601");
                    sb5.append(sb6.toString());
                    a8.h(this.x.toString());
                    a8.setLocationDetail(this.p.toString());
                    return a8;
                }
                if (a8.getErrorCode() == 0 && a8.getLocationType() == 0) {
                    if ("-5".equals(a8.d()) || "1".equals(a8.d()) || "2".equals(a8.d()) || "14".equals(a8.d()) || "24".equals(a8.d()) || "-1".equals(a8.d())) {
                        a8.setLocationType(5);
                    } else {
                        a8.setLocationType(6);
                    }
                }
                a8.setOffset(this.r);
                a8.a(this.q);
                a8.f(String.valueOf(this.s));
                a8.e("new");
                a8.setLocationDetail(this.p.toString());
                this.F = a8.a();
                return a8;
            } catch (Throwable th3) {
                th = th3;
                i2 = 4;
                ep.b();
                dmVar.d("FAIL");
                ec.a(this.a).a(false, ec.a);
                ej.a(th, "Aps", "getApsLoc req");
                en.a("/mobile/binary", th);
                if (ep.d(this.a)) {
                    dmVar.f("#0401");
                    sb2 = this.p;
                    str = "网络异常，未连接到网络，请连接网络#0401";
                } else {
                    if (th instanceof j) {
                        j jVar = th;
                        if (jVar.a().contains("网络异常状态码")) {
                            dmVar.f("#0404");
                            StringBuilder sb7 = this.p;
                            sb7.append("网络异常，状态码错误#0404");
                            sb7.append(jVar.f());
                            ds a6 = a(i2, this.p.toString());
                            a6.h(this.x.toString());
                            return a6;
                        } else if (jVar.f() == 23 || Math.abs((ep.b() - this.f1364l) - this.j.getHttpTimeOut()) < 500) {
                            dmVar.f("#0402");
                            sb2 = this.p;
                            str = "网络异常，连接超时#0402";
                        } else {
                            sb = new StringBuilder("#0403,");
                        }
                    } else {
                        sb = new StringBuilder("#0403,");
                    }
                    sb.append(th.getMessage());
                    dmVar.f(sb.toString());
                    this.p.append("网络异常,请求异常#0403");
                    ds a6 = a(i2, this.p.toString());
                    a6.h(this.x.toString());
                    return a6;
                }
                sb2.append(str);
                ds a6 = a(i2, this.p.toString());
                a6.h(this.x.toString());
                return a6;
            }
        } catch (Throwable th4) {
            dmVar.f("#0301");
            StringBuilder sb8 = this.p;
            sb8.append("get parames error:" + th4.getMessage() + "#0301");
            en.a((String) null, 2031);
            ds a9 = a(3, this.p.toString());
            a9.h(this.x.toString());
            return a9;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0204, code lost:
        if (r14.w == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x023e, code lost:
        if (r14.w == false) goto L_0x0241;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    private String c(dm dmVar) {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2;
        StringBuilder sb4;
        String str3;
        int f2 = this.d.f();
        dv d2 = this.d.d();
        ArrayList<ScanResult> arrayList = this.h;
        boolean z2 = arrayList == null || arrayList.isEmpty();
        String str4 = "";
        if (d2 != null || !z2) {
            WifiInfo k2 = this.c.k();
            this.v = k2;
            this.w = dx.a(k2);
            if (f2 != 0) {
                String str5 = "cgi";
                if (f2 != 1) {
                    if (f2 != 2) {
                        this.A = 11;
                        en.a((String) null, 2111);
                        dmVar.f("#1101");
                        this.p.append("get cgi failure#1101");
                    } else if (d2 != null) {
                        sb2 = new StringBuilder();
                        sb2.append(d2.a);
                        sb2.append("#");
                        sb2.append(d2.b);
                        sb2.append("#");
                        sb2.append(d2.g);
                        sb2.append("#");
                        sb2.append(d2.h);
                        sb2.append("#");
                        sb2.append(d2.i);
                        sb2.append("#");
                        sb2.append("network");
                        sb2.append("#");
                        if (this.h.isEmpty()) {
                        }
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                    if (!str4.startsWith("#")) {
                        str4 = "#" + str4;
                    }
                    return ep.e() + str4;
                }
                if (d2 != null) {
                    sb2 = new StringBuilder();
                    sb2.append(d2.a);
                    sb2.append("#");
                    sb2.append(d2.b);
                    sb2.append("#");
                    sb2.append(d2.c);
                    sb2.append("#");
                    sb2.append(d2.d);
                    sb2.append("#");
                    sb2.append("network");
                    sb2.append("#");
                    if (this.h.isEmpty()) {
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                str5 = "cgiwifi";
                sb2.append(str5);
            } else {
                boolean z3 = !this.h.isEmpty() || this.w;
                if (!this.w || !this.h.isEmpty()) {
                    if (this.h.size() == 1) {
                        this.A = 2;
                        if (!this.w) {
                            dmVar.f("#0202");
                            this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            en.a((String) null, 2022);
                            return str4;
                        } else if (this.c.k().getBSSID().equals(this.h.get(0).BSSID)) {
                            dmVar.f("#0202");
                            this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            en.a((String) null, 2021);
                            return str4;
                        }
                    }
                    String format = String.format(Locale.US, "#%s#", "network");
                    if (z3) {
                        sb2 = new StringBuilder();
                        sb2.append(format);
                        sb2.append("wifi");
                    } else {
                        this.A = 2;
                        if (!this.c.q) {
                            dmVar.f("#0203");
                            sb = this.p;
                            str = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
                        } else {
                            dmVar.f("#0204");
                            sb = this.p;
                            str = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
                        }
                        sb.append(str);
                        en.a((String) null, 2022);
                        if (!TextUtils.isEmpty(str4)) {
                        }
                    }
                } else {
                    this.A = 2;
                    dmVar.f("#0201");
                    this.p.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    en.a((String) null, 2021);
                    return str4;
                }
            }
            str4 = sb2.toString();
            if (!TextUtils.isEmpty(str4)) {
            }
        } else {
            if (this.b == null) {
                this.b = (ConnectivityManager) ep.a(this.a, "connectivity");
            }
            if (!ep.a(this.a) || this.c.q) {
                if (ep.c() >= 28) {
                    if (this.H == null) {
                        this.H = (LocationManager) this.a.getApplicationContext().getSystemService("location");
                    }
                    if (!((Boolean) em.a(this.H, "isLocationEnabled", new Object[0])).booleanValue()) {
                        this.A = 12;
                        this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                        dmVar.f("#1206");
                        en.a((String) null, 2121);
                        return str4;
                    }
                }
                if (!ep.f(this.a)) {
                    this.A = 12;
                    this.p.append("定位权限被禁用,请授予应用定位权限#1201");
                    dmVar.f("#1201");
                    en.a((String) null, 2121);
                    return str4;
                } else if (ep.c() < 24 || ep.c() >= 28 || Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) != 0) {
                    String k3 = this.d.k();
                    String d3 = this.c.d();
                    if (this.c.a(this.b) && d3 != null) {
                        this.A = 12;
                        dmVar.f("#1202");
                        this.p.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                        en.a((String) null, 2121);
                        return str4;
                    } else if (k3 != null) {
                        this.A = 12;
                        if (!this.c.q) {
                            dmVar.f("#1204");
                            sb4 = this.p;
                            str3 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
                        } else {
                            dmVar.f("#1205");
                            sb4 = this.p;
                            str3 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
                        }
                        sb4.append(str3);
                        en.a((String) null, 2121);
                        return str4;
                    } else if (!this.c.q && !this.d.n()) {
                        this.A = 19;
                        dmVar.f("#1901");
                        this.p.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                        en.a((String) null, 2133);
                        return str4;
                    } else if (!ep.g(this.a)) {
                        this.A = 12;
                        dmVar.f("#1207");
                        this.p.append("后台定位服务没有开启，请在设置中打开后台定位服务开关#1207");
                        en.a((String) null, 2121);
                        return str4;
                    } else {
                        if (!this.c.q) {
                            dmVar.f("#1301");
                            sb3 = this.p;
                            str2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
                        } else {
                            dmVar.f("#1302");
                            sb3 = this.p;
                            str2 = "获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302";
                        }
                        sb3.append(str2);
                        this.A = 13;
                        en.a((String) null, 2131);
                        return str4;
                    }
                } else {
                    this.A = 12;
                    dmVar.f("#1206");
                    this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    en.a((String) null, 2121);
                    return str4;
                }
            } else {
                this.A = 18;
                this.p.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                en.a((String) null, 2132);
                dmVar.f("#1801");
                return str4;
            }
        }
    }

    private void c(ds dsVar) {
        if (dsVar != null) {
            this.k = dsVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a A[Catch:{ all -> 0x004e }] */
    private void i() {
        int i2;
        if (this.o != null) {
            try {
                if (this.j == null) {
                    this.j = new AMapLocationClientOption();
                }
                int i3 = 2;
                boolean z2 = true;
                if (!(this.j.getGeoLanguage() == null || (i2 = AnonymousClass1.a[this.j.getGeoLanguage().ordinal()]) == 1)) {
                    if (i2 == 2) {
                        i3 = 1;
                    } else if (i2 != 3) {
                    }
                    ee eeVar = this.o;
                    long httpTimeOut = this.j.getHttpTimeOut();
                    if (this.j.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS)) {
                        z2 = false;
                    }
                    eeVar.a(httpTimeOut, z2, i3);
                }
                i3 = 0;
                ee eeVar = this.o;
                long httpTimeOut = this.j.getHttpTimeOut();
                if (this.j.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS)) {
                }
                eeVar.a(httpTimeOut, z2, i3);
            } catch (Throwable unused) {
            }
        }
    }

    private void j() {
        try {
            if (this.i == null) {
                this.i = new a();
            }
            if (this.G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.a.registerReceiver(this.i, this.G);
        } catch (Throwable th) {
            ej.a(th, "Aps", "initBroadcastListener");
        }
    }

    private boolean k() {
        ArrayList<ScanResult> e2 = this.c.e();
        this.h = e2;
        return e2 == null || e2.size() <= 0;
    }

    public final ds a(double d2, double d3) {
        try {
            String a2 = this.o.a(this.a, d2, d3);
            if (!a2.contains("\"status\":\"1\"")) {
                return null;
            }
            ds a3 = this.g.a(a2);
            a3.setLatitude(d2);
            a3.setLongitude(d3);
            return a3;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b3 A[Catch:{ all -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b7 A[Catch:{ all -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ec  */
    public final ds a(dm dmVar) throws Throwable {
        boolean z2;
        dt dtVar;
        String c2;
        float f2;
        dt dtVar2;
        long b2;
        boolean z3;
        dx dxVar;
        c();
        dmVar.e("conitue");
        if (this.a == null) {
            dmVar.f("#0101");
            this.p.append("context is null#0101");
            return a(1, this.p.toString());
        }
        int i2 = this.I + 1;
        this.I = i2;
        if (i2 == 1 && (dxVar = this.c) != null) {
            dxVar.a(this.n);
        }
        long j2 = this.f1364l;
        if (!this.M) {
            this.M = true;
        } else if (ep.b() - j2 < 800) {
            if ((ep.a(this.k) ? ep.a() - this.k.getTime() : 0) <= 10000) {
                z2 = true;
                if (z2 || !ep.a(this.k)) {
                    dtVar = this.B;
                    if (dtVar != null) {
                        if (this.C) {
                            dtVar.a();
                        } else {
                            dtVar.b();
                        }
                    }
                    if (!this.j.isOnceLocationLatest()) {
                        if (this.j.isOnceLocation()) {
                            z3 = false;
                            this.c.b(z3);
                            this.h = this.c.e();
                            this.d.a(false, k());
                            c2 = c(dmVar);
                            this.L = c2;
                            if (TextUtils.isEmpty(c2)) {
                                return a(this.A, this.p.toString());
                            }
                            this.x = a(this.x);
                            if (this.c.l()) {
                                ds a2 = a(15, "networkLocation has been mocked!#1502");
                                dmVar.f("#1502");
                                a2.setMock(true);
                                a2.setTrustedLevel(4);
                                return a2;
                            }
                            ds a3 = this.e.a(this.d, this.f1364l == 0 || ep.b() - this.f1364l > 20000, this.k, this.c, this.x, this.L, this.a, false);
                            if (ep.a(a3)) {
                                a3.setTrustedLevel(2);
                            } else {
                                a3 = b(true, dmVar);
                                if (ep.a(a3)) {
                                    a3.e("new");
                                    this.e.a(this.x.toString());
                                    this.e.a(this.d.d());
                                } else {
                                    ds a4 = this.e.a(this.d, false, this.k, this.c, this.x, this.L, this.a, true);
                                    if (ep.a(a4)) {
                                        dmVar.f("#0001");
                                        a4.setTrustedLevel(2);
                                        c(a4);
                                        a3 = a4;
                                    }
                                    if (!(this.c == null || a3 == null)) {
                                        b2 = dx.b();
                                        if (b2 > 15) {
                                            a3.setTrustedLevel(1);
                                        } else if (b2 <= 120) {
                                            a3.setTrustedLevel(2);
                                        } else if (b2 <= 600) {
                                            a3.setTrustedLevel(3);
                                        } else {
                                            a3.setTrustedLevel(4);
                                        }
                                    }
                                    this.e.a(this.L, this.x, a3, this.a, true);
                                    ep.a(a3);
                                    StringBuilder sb = this.x;
                                    sb.delete(0, sb.length());
                                    if (a3 != null) {
                                        if (!this.C || (dtVar2 = this.B) == null) {
                                            a3.setAltitude(0.0d);
                                            f2 = 0.0f;
                                            a3.setBearing(0.0f);
                                        } else {
                                            a3.setAltitude(dtVar2.f);
                                            a3.setBearing(this.B.c());
                                            f2 = (float) this.B.d();
                                        }
                                        a3.setSpeed(f2);
                                    }
                                    c(a3);
                                    return this.k;
                                }
                            }
                            c(a3);
                            try {
                                b2 = dx.b();
                                if (b2 > 15) {
                                }
                            } catch (Throwable unused) {
                            }
                            this.e.a(this.L, this.x, a3, this.a, true);
                            ep.a(a3);
                            StringBuilder sb = this.x;
                            sb.delete(0, sb.length());
                            if (a3 != null) {
                            }
                            c(a3);
                            return this.k;
                        }
                    }
                    z3 = true;
                    this.c.b(z3);
                    this.h = this.c.e();
                    this.d.a(false, k());
                    c2 = c(dmVar);
                    this.L = c2;
                    if (TextUtils.isEmpty(c2)) {
                    }
                } else {
                    if (this.t && ei.a(this.k.getTime())) {
                        this.k.setLocationType(2);
                    }
                    return this.k;
                }
            }
        }
        z2 = false;
        if (z2) {
        }
        dtVar = this.B;
        if (dtVar != null) {
        }
        try {
            if (!this.j.isOnceLocationLatest()) {
            }
            z3 = true;
            this.c.b(z3);
            this.h = this.c.e();
        } catch (Throwable th) {
            ej.a(th, "Aps", "getLocation getScanResultsParam");
        }
        try {
            this.d.a(false, k());
        } catch (Throwable th2) {
            ej.a(th2, "Aps", "getLocation getCgiListParam");
        }
        c2 = c(dmVar);
        this.L = c2;
        if (TextUtils.isEmpty(c2)) {
        }
    }

    public final ds a(ds dsVar) {
        this.E.a(this.t);
        return this.E.a(dsVar);
    }

    public final ds a(boolean z2, dm dmVar) {
        dmVar.e(z2 ? "statics" : "first");
        if (this.a == null) {
            dmVar.f("#0101");
            this.p.append("context is null#0101");
            en.a((String) null, 2011);
            return a(1, this.p.toString());
        } else if (this.c.l()) {
            dmVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        } else {
            a();
            if (TextUtils.isEmpty(this.L)) {
                return a(this.A, this.p.toString());
            }
            ds b2 = b(z2, dmVar);
            if (ep.a(b2) && !P) {
                this.e.a(this.x.toString());
                this.e.a(this.d.d());
                c(b2);
            }
            P = true;
            return b2;
        }
    }

    public final void a() {
        this.o = ee.a(this.a);
        i();
        if (this.b == null) {
            this.b = (ConnectivityManager) ep.a(this.a, "connectivity");
        }
        if (this.m == null) {
            this.m = new eh();
        }
    }

    public final void a(Context context) {
        try {
            if (this.a == null) {
                this.E = new dr();
                Context applicationContext = context.getApplicationContext();
                this.a = applicationContext;
                ep.b(applicationContext);
                if (this.c == null) {
                    this.c = new dx(this.a, (WifiManager) ep.a(this.a, "wifi"));
                }
                if (this.d == null) {
                    this.d = new dw(this.a);
                }
                if (this.e == null) {
                    this.e = new dz();
                }
                if (this.g == null) {
                    this.g = new eg();
                }
            }
        } catch (Throwable th) {
            ej.a(th, "Aps", "initBase");
        }
    }

    public final void a(Handler handler) {
        this.N = handler;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        this.j = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.j = new AMapLocationClientOption();
        }
        dx dxVar = this.c;
        if (dxVar != null) {
            this.j.isWifiActiveScan();
            dxVar.a(this.j.isWifiScan(), this.j.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        dz dzVar = this.e;
        if (dzVar != null) {
            dzVar.a(this.j);
        }
        eg egVar = this.g;
        if (egVar != null) {
            egVar.a(this.j);
        }
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z6 = true;
        try {
            geoLanguage = this.j.getGeoLanguage();
            z3 = this.j.isNeedAddress();
            try {
                z2 = this.j.isOffset();
            } catch (Throwable unused) {
                z5 = true;
                z2 = z6;
                z4 = z5;
                this.r = z2;
                this.q = z3;
                this.t = z4;
                this.s = geoLanguage;
            }
            try {
                z4 = this.j.isLocationCacheEnable();
            } catch (Throwable unused2) {
                z6 = z2;
                z5 = true;
                z2 = z6;
                z4 = z5;
                this.r = z2;
                this.q = z3;
                this.t = z4;
                this.s = geoLanguage;
            }
            try {
                this.u = this.j.isOnceLocationLatest();
                this.C = this.j.isSensorEnable();
                if (!(z2 == this.r && z3 == this.q && z4 == this.t && geoLanguage == this.s)) {
                    try {
                        dz dzVar2 = this.e;
                        if (dzVar2 != null) {
                            dzVar2.a();
                        }
                        c((ds) null);
                        this.M = false;
                        dr drVar = this.E;
                        if (drVar != null) {
                            drVar.a();
                        }
                    } catch (Throwable th) {
                        ej.a(th, "Aps", "cleanCache");
                    }
                }
            } catch (Throwable unused3) {
                z5 = z4;
                z6 = z2;
                z2 = z6;
                z4 = z5;
                this.r = z2;
                this.q = z3;
                this.t = z4;
                this.s = geoLanguage;
            }
        } catch (Throwable unused4) {
            z3 = true;
            z5 = true;
            z2 = z6;
            z4 = z5;
            this.r = z2;
            this.q = z3;
            this.t = z4;
            this.s = geoLanguage;
        }
        this.r = z2;
        this.q = z3;
        this.t = z4;
        this.s = geoLanguage;
    }

    public final void b() {
        if (this.B == null) {
            this.B = new dt(this.a);
        }
        j();
        this.c.b(false);
        this.h = this.c.e();
        this.d.a(false, k());
        this.e.a(this.a);
        try {
            if (this.a.checkCallingOrSelfPermission(u.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.n = true;
            }
        } catch (Throwable unused) {
        }
        this.z = true;
    }

    public final void b(dm dmVar) {
        try {
            if (!this.y) {
                if (this.L != null) {
                    this.L = null;
                }
                StringBuilder sb = this.x;
                if (sb != null) {
                    sb.delete(0, sb.length());
                }
                if (this.u) {
                    j();
                }
                this.c.b(this.u);
                this.h = this.c.e();
                this.d.a(true, k());
                String c2 = c(dmVar);
                this.L = c2;
                if (!TextUtils.isEmpty(c2)) {
                    this.x = a(this.x);
                }
                this.y = true;
            }
        } catch (Throwable th) {
            ej.a(th, "Aps", "initFirstLocateParam");
        }
    }

    public final void b(ds dsVar) {
        if (ep.a(dsVar)) {
            this.e.a(this.L, this.x, dsVar, this.a, true);
        }
    }

    public final void c() {
        if (this.p.length() > 0) {
            StringBuilder sb = this.p;
            sb.delete(0, sb.length());
        }
    }

    public final void d() {
        a aVar;
        this.F = null;
        this.y = false;
        this.z = false;
        dz dzVar = this.e;
        if (dzVar != null) {
            dzVar.b(this.a);
        }
        dr drVar = this.E;
        if (drVar != null) {
            drVar.a();
        }
        if (this.g != null) {
            this.g = null;
        }
        try {
            Context context = this.a;
            if (!(context == null || (aVar = this.i) == null)) {
                context.unregisterReceiver(aVar);
            }
        } catch (Throwable th) {
            this.i = null;
            throw th;
        }
        this.i = null;
        dw dwVar = this.d;
        if (dwVar != null) {
            dwVar.h();
        }
        dx dxVar = this.c;
        if (dxVar != null) {
            dxVar.n();
        }
        ArrayList<ScanResult> arrayList = this.h;
        if (arrayList != null) {
            arrayList.clear();
        }
        dt dtVar = this.B;
        if (dtVar != null) {
            dtVar.e();
        }
        this.k = null;
        this.a = null;
        this.x = null;
        this.H = null;
    }

    public final void e() {
        Cdo doVar = this.Q;
        if (doVar != null) {
            doVar.d();
        }
    }

    public final ds f() {
        int i2;
        String sb;
        if (this.c.l()) {
            i2 = 15;
            sb = "networkLocation has been mocked!#1502";
        } else if (TextUtils.isEmpty(this.L)) {
            i2 = this.A;
            sb = this.p.toString();
        } else {
            ds a2 = this.e.a(this.a, this.L, this.x, true);
            if (ep.a(a2)) {
                c(a2);
            }
            return a2;
        }
        return a(i2, sb);
    }

    public final void g() {
        try {
            if (ei.d && this.a != null) {
                if (this.Q == null) {
                    this.Q = new Cdo(this.a);
                }
                this.Q.a(this.d, this.c, this.N);
            }
        } catch (Throwable th) {
            ab.b(th, "as", "stc");
        }
    }

    public final void h() {
        Cdo doVar = this.Q;
        if (doVar != null) {
            doVar.a();
        }
    }
}
