package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.List;

/* compiled from: IdUtils */
public class k {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static boolean k;

    private static Context k(Context context) {
        return context == null ? p.a() : context;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(a) && b.b()) {
                a = d.a(k(context)).b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static String b(Context context) {
        if (h == null && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return h;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(b) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return b;
    }

    public static String d(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUsePhoneState()) {
            return e2.getDevImei();
        }
        if (TextUtils.isEmpty(c) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return c;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(i) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return i;
    }

    public static String f(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f;
    }

    public static String g(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(d) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return d;
    }

    public static String h(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(e) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return e;
    }

    public static String i(Context context) {
        TTCustomController e2;
        if (Build.VERSION.SDK_INT >= 28 && (e2 = i.d().e()) != null && !e2.isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(j) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return j;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(a)) {
            d.a(context).a("did", str);
            a = str;
        }
        if (!TextUtils.isEmpty(a)) {
            s.b(a).a(a);
        }
    }

    private static void l(Context context) {
        Context k2;
        if (!k && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception unused) {
            }
            try {
                TTCustomController e2 = i.d().e();
                if (e2 != null && e2.isCanUseWifiState() && e2.isCanUseLocation()) {
                    try {
                        WifiManager wifiManager = (WifiManager) k2.getSystemService("wifi");
                        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                        if (connectionInfo != null) {
                            d = connectionInfo.getSSID();
                        }
                        e = a(wifiManager);
                    } catch (Throwable unused2) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    j = Build.getSerial();
                } else {
                    j = Build.SERIAL;
                }
            } catch (Exception unused3) {
            }
            b = a(k2, true);
            a = d.a(k2).b("did", (String) null);
            g = a();
            h = String.valueOf(Build.TIME);
            i = d.a(k2).b("uuid", (String) null);
            k = true;
        }
    }

    public static String a(WifiManager wifiManager) {
        String str = "02:00:00:00:00:00";
        if (wifiManager == null) {
            return str;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!(scanResults == null || connectionInfo == null || connectionInfo.getBSSID() == null)) {
                for (int i2 = 0; i2 < scanResults.size(); i2++) {
                    ScanResult scanResult = scanResults.get(i2);
                    if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static void j(Context context) {
        Context k2;
        if (TextUtils.isEmpty(c) && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception unused) {
            }
        }
    }

    private static void m(Context context) {
        TelephonyManager telephonyManager;
        TTCustomController e2 = i.d().e();
        if ((e2 == null || e2.isCanUsePhoneState()) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            c = telephonyManager.getDeviceId();
            f = telephonyManager.getSubscriberId();
        }
    }

    private static synchronized String a(Context context, boolean z) {
        synchronized (k.class) {
            Context k2 = k(context);
            String str = null;
            if (k2 == null) {
                return null;
            }
            try {
                str = Settings.Secure.getString(k2.getContentResolver(), "android_id");
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str) || str.length() < 13) {
                str = "";
            }
            return str;
        }
    }

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ad.e()) {
                sb.append("MIUI-");
            } else if (ad.b()) {
                sb.append("FLYME-");
            } else {
                String n = ad.n();
                if (ad.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
