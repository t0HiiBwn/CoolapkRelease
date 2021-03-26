package com.amap.api.mapcore2d;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class go {
    static long c;
    static long d;
    static long e;
    static long f;
    static long g;
    public static HashMap<String, Long> q = new HashMap<>(36);
    public static long r = 0;
    static int s = 0;
    WifiManager a;
    ArrayList<ScanResult> b = new ArrayList<>();
    Context h;
    boolean i = false;
    StringBuilder j = null;
    boolean k = true;

    /* renamed from: l  reason: collision with root package name */
    boolean f1237l = true;
    boolean m = true;
    String n = null;
    TreeMap<Integer, ScanResult> o = null;
    public boolean p = true;
    ConnectivityManager t = null;
    volatile boolean u = false;
    private volatile WifiInfo v = null;
    private long w = 30000;

    public go(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.h = context;
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            gu.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && gy.a(wifiInfo.getBSSID());
    }

    private void d(boolean z) {
        this.k = z;
        this.f1237l = true;
        this.m = true;
        this.w = 30000;
    }

    public static String i() {
        return String.valueOf(gy.b() - f);
    }

    private List<ScanResult> j() {
        long b2;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (q.isEmpty() || !q.equals(hashMap)) {
                        q = hashMap;
                        b2 = gy.b();
                    }
                    this.n = null;
                    return scanResults;
                }
                b2 = gy.b();
                r = b2;
                this.n = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.n = e2.getMessage();
            } catch (Throwable th) {
                this.n = null;
                gu.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            WifiManager wifiManager = this.a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            gu.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long b2 = gy.b() - c;
        if (b2 < 4900) {
            return false;
        }
        if (n() && b2 < 9900) {
            return false;
        }
        if (s > 1) {
            long j2 = this.w;
            if (j2 == 30000) {
                j2 = gt.b() != -1 ? gt.b() : 30000;
            }
            if (Build.VERSION.SDK_INT >= 28 && b2 < j2) {
                return false;
            }
        }
        if (this.a == null) {
            return false;
        }
        c = gy.b();
        int i2 = s;
        if (i2 < 2) {
            s = i2 + 1;
        }
        return this.a.startScan();
    }

    private boolean n() {
        if (this.t == null) {
            this.t = (ConnectivityManager) gy.a(this.h, "connectivity");
        }
        return a(this.t);
    }

    private boolean o() {
        if (this.a == null) {
            return false;
        }
        return gy.c(this.h);
    }

    private void p() {
        String str;
        ArrayList<ScanResult> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (gy.b() - f > 3600000) {
                b();
            }
            if (this.o == null) {
                this.o = new TreeMap<>(Collections.reverseOrder());
            }
            this.o.clear();
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.b.get(i2);
                if (gy.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.o.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.o.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.b.clear();
            for (ScanResult scanResult2 : this.o.values()) {
                this.b.add(scanResult2);
            }
            this.o.clear();
        }
    }

    private void q() {
        if (t()) {
            long b2 = gy.b();
            if (b2 - d >= 10000) {
                this.b.clear();
                g = f;
            }
            r();
            if (b2 - d >= 10000) {
                for (int i2 = 20; i2 > 0 && f == g; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void r() {
        if (t()) {
            try {
                if (m()) {
                    e = gy.b();
                }
            } catch (Throwable th) {
                gu.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void s() {
        if (g != f) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th) {
                gu.a(th, "WifiManager", "updateScanResult");
            }
            g = f;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
                return;
            }
            this.b.clear();
        }
    }

    private boolean t() {
        boolean o2 = o();
        this.p = o2;
        if (o2 && this.k) {
            if (e == 0) {
                return true;
            }
            if (gy.b() - e >= 4900 && gy.b() - f >= 1500) {
                int i2 = ((gy.b() - f) > 4900 ? 1 : ((gy.b() - f) == 4900 ? 0 : -1));
                return true;
            }
        }
        return false;
    }

    public final ArrayList<ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void a(boolean z) {
        Context context = this.h;
        if (gt.a() && this.m && this.a != null && context != null && z && gy.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) gw.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    gw.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                gu.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return gy.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            gu.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.v = null;
        this.b.clear();
    }

    public final void b(boolean z) {
        if (z) {
            q();
        } else {
            r();
        }
        if (this.u) {
            this.u = false;
            b();
        }
        s();
        if (gy.b() - f > 20000) {
            this.b.clear();
        }
        d = gy.b();
        if (this.b.isEmpty()) {
            f = gy.b();
            List<ScanResult> j2 = j();
            if (j2 != null) {
                this.b.addAll(j2);
            }
        }
        p();
    }

    public final void c() {
        if (this.a != null && gy.b() - f > 4900) {
            f = gy.b();
        }
    }

    public final void c(boolean z) {
        d(z);
    }

    public final void d() {
        int i2;
        if (this.a != null) {
            try {
                i2 = l();
            } catch (Throwable th) {
                gu.a(th, "Aps", "onReceive part");
                i2 = 4;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (i2 == 0 || i2 == 1 || i2 == 4) {
                this.u = true;
            }
        }
    }

    public final boolean e() {
        return this.p;
    }

    public final WifiInfo f() {
        this.v = k();
        return this.v;
    }

    public final boolean g() {
        return this.i;
    }

    public final void h() {
        b();
        this.b.clear();
    }
}
