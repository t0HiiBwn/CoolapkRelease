package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class dx {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static HashMap<String, Long> s = new HashMap<>(36);
    public static long t = 0;
    static int u = 0;
    public static long w = 0;
    private Cdo A;
    WifiManager a;
    ArrayList<ScanResult> b = new ArrayList<>();
    ArrayList<dd> c = new ArrayList<>();
    Context i;
    boolean j = false;
    StringBuilder k = null;

    /* renamed from: l  reason: collision with root package name */
    boolean f1369l = true;
    boolean m = true;
    boolean n = true;
    String o = null;
    TreeMap<Integer, ScanResult> p = null;
    public boolean q = true;
    public boolean r = false;
    ConnectivityManager v = null;
    volatile boolean x = false;
    private volatile WifiInfo y = null;
    private long z = 30000;

    public dx(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            ej.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && ep.a(wifiInfo.getBSSID());
    }

    public static long b() {
        return ((ep.b() - t) / 1000) + 1;
    }

    private void c(boolean z2) {
        String str;
        ArrayList<ScanResult> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (ep.b() - g > 3600000) {
                g();
            }
            if (this.p == null) {
                this.p = new TreeMap<>(Collections.reverseOrder());
            }
            this.p.clear();
            if (this.r && z2) {
                try {
                    this.c.clear();
                } catch (Throwable unused) {
                }
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.b.get(i2);
                if (ep.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (this.r && z2) {
                        try {
                            dd ddVar = new dd(false);
                            ddVar.b = scanResult.SSID;
                            ddVar.d = scanResult.frequency;
                            ddVar.e = scanResult.timestamp;
                            ddVar.a = dd.a(scanResult.BSSID);
                            ddVar.c = (short) scanResult.level;
                            if (Build.VERSION.SDK_INT >= 17) {
                                ddVar.g = (short) ((int) ((SystemClock.elapsedRealtime() - (scanResult.timestamp / 1000)) / 1000));
                                if (ddVar.g < 0) {
                                    ddVar.g = 0;
                                }
                            }
                            ddVar.f = System.currentTimeMillis();
                            this.c.add(ddVar);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.b.clear();
            for (ScanResult scanResult2 : this.p.values()) {
                this.b.add(scanResult2);
            }
            this.p.clear();
        }
    }

    public static String o() {
        return String.valueOf(ep.b() - g);
    }

    private List<ScanResult> p() {
        long b2;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                        }
                    }
                    if (s.isEmpty() || !s.equals(hashMap)) {
                        s = hashMap;
                        b2 = ep.b();
                    }
                    this.o = null;
                    return scanResults;
                }
                b2 = ep.b();
                t = b2;
                this.o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                ej.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r0 < r4) goto L_0x0072;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    private void q() {
        boolean z2;
        if (r()) {
            try {
                long b2 = ep.b() - d;
                if (b2 >= 4900) {
                    if (this.v == null) {
                        this.v = (ConnectivityManager) ep.a(this.i, "connectivity");
                    }
                    if (!a(this.v) || b2 >= 9900) {
                        if (u > 1) {
                            long j2 = this.z;
                            if (j2 == 30000) {
                                j2 = ei.n() != -1 ? ei.n() : 30000;
                            }
                            if (Build.VERSION.SDK_INT >= 28) {
                            }
                        }
                        if (this.a != null) {
                            d = ep.b();
                            int i2 = u;
                            if (i2 < 2) {
                                u = i2 + 1;
                            }
                            z2 = this.a.startScan();
                            if (!z2) {
                                f = ep.b();
                                return;
                            }
                            return;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                }
            } catch (Throwable th) {
                ej.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private boolean r() {
        boolean h2 = this.a == null ? false : ep.h(this.i);
        this.q = h2;
        if (!h2 || !this.f1369l) {
            return false;
        }
        if (f != 0) {
            if (ep.b() - f < 4900 || ep.b() - g < 1500) {
                return false;
            }
            int i2 = ((ep.b() - g) > 4900 ? 1 : ((ep.b() - g) == 4900 ? 0 : -1));
        }
        return true;
    }

    public final ArrayList<dd> a() {
        if (!this.r) {
            return this.c;
        }
        b(true);
        return this.c;
    }

    public final void a(Cdo doVar) {
        this.A = doVar;
    }

    public final void a(boolean z2) {
        Context context = this.i;
        if (ei.m() && this.n && this.a != null && context != null && z2 && ep.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) em.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    em.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                ej.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final void a(boolean z2, boolean z3, boolean z4, long j2) {
        this.f1369l = z2;
        this.m = z3;
        this.n = z4;
        if (j2 < 10000) {
            this.z = 10000;
        } else {
            this.z = j2;
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return ep.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            ej.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    public final void b(boolean z2) {
        int i2;
        if (!z2) {
            q();
        } else if (r()) {
            long b2 = ep.b();
            if (b2 - e >= 10000) {
                this.b.clear();
                h = g;
            }
            q();
            if (b2 - e >= 10000) {
                for (int i3 = 20; i3 > 0 && g == h; i3--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        boolean z3 = true;
        if (this.x) {
            this.x = false;
            try {
                WifiManager wifiManager = this.a;
                if (wifiManager != null) {
                    if (wifiManager != null) {
                        try {
                            i2 = wifiManager.getWifiState();
                        } catch (Throwable th) {
                            ej.a(th, "WifiManager", "onReceive part");
                        }
                        if (this.b == null) {
                            this.b = new ArrayList<>();
                        }
                        if (i2 == 0 || i2 == 1 || i2 == 4) {
                            g();
                        }
                    }
                    i2 = 4;
                    if (this.b == null) {
                    }
                    g();
                }
            } catch (Throwable unused2) {
            }
        }
        if (h != g) {
            List<ScanResult> list = null;
            try {
                list = p();
            } catch (Throwable th2) {
                ej.a(th2, "WifiManager", "updateScanResult");
            }
            h = g;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
            } else {
                this.b.clear();
            }
        }
        if (ep.b() - g > 20000) {
            this.b.clear();
        }
        e = ep.b();
        if (this.b.isEmpty()) {
            g = ep.b();
            List<ScanResult> p2 = p();
            if (p2 != null) {
                this.b.addAll(p2);
                c(z3);
            }
        }
        z3 = false;
        c(z3);
    }

    public final WifiInfo c() {
        try {
            WifiManager wifiManager = this.a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            ej.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.o;
    }

    public final ArrayList<ScanResult> e() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.r = true;
            List<ScanResult> p2 = p();
            if (p2 != null) {
                this.b.clear();
                this.b.addAll(p2);
            }
            c(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.y = null;
        this.b.clear();
    }

    public final void h() {
        w = System.currentTimeMillis();
        Cdo doVar = this.A;
        if (doVar != null) {
            doVar.b();
        }
    }

    public final void i() {
        if (this.a != null && ep.b() - g > 4900) {
            g = ep.b();
        }
    }

    public final void j() {
        if (this.a != null) {
            this.x = true;
        }
    }

    public final WifiInfo k() {
        this.y = c();
        return this.y;
    }

    public final boolean l() {
        return this.j;
    }

    public final String m() {
        boolean z2;
        String str;
        StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.j = false;
        this.y = k();
        String bssid = a(this.y) ? this.y.getBSSID() : "";
        int size = this.b.size();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < size) {
            String str2 = this.b.get(i2).BSSID;
            if (!this.m && !"<unknown ssid>".equals(this.b.get(i2).SSID)) {
                z3 = true;
            }
            if (bssid.equals(str2)) {
                str = "access";
                z2 = true;
            } else {
                z2 = z4;
                str = "nb";
            }
            this.k.append(String.format(Locale.US, "#%s,%s", str2, str));
            i2++;
            z4 = z2;
        }
        if (this.b.size() == 0) {
            z3 = true;
        }
        if (!this.m && !z3) {
            this.j = true;
        }
        if (!z4 && !TextUtils.isEmpty(bssid)) {
            StringBuilder sb2 = this.k;
            sb2.append("#");
            sb2.append(bssid);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final void n() {
        g();
        this.b.clear();
    }
}
