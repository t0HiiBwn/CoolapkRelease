package com.kepler.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

public class x {
    private static String a = null;
    private static int b = -1;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;

    public String a(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.getConnectionInfo().getMacAddress();
        }
        String a2 = g.a().a(context, "kepler_mac");
        if (a2 != null) {
            try {
                if (!"".equals(a2)) {
                    return a2;
                }
            } catch (Error | Exception unused) {
                return a2;
            }
        }
        String a3 = a();
        try {
            g.a().a(context, "kepler_mac", a3);
            return a3;
        } catch (Error | Exception unused2) {
            return a3;
        }
    }

    public String b(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        String a2 = g.a().a(context, "kepler_imei");
        if (a2 != null) {
            try {
                if (!"".equals(a2)) {
                    str = a();
                    try {
                        g.a().a(context, "kepler_imei", str);
                        return str;
                    } catch (Error | Exception unused) {
                        return str;
                    }
                }
            } catch (Error | Exception unused2) {
                str = a2;
                return str;
            }
        }
        return a2;
    }

    private Signature[] l(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            return signatureArr;
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public String c(Context context) {
        String a2;
        try {
            String a3 = g.a().a(context, "md5sign");
            if (a3 != null && !"".equals(a3)) {
                return a3;
            }
            Signature[] l2 = l(context);
            if (!(l2 == null || (a2 = new ac().a(l2[0].toByteArray())) == null || "".equals(a2))) {
                g.a().a(context, "md5sign", a2);
                return a2;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    public String d(Context context) {
        String c2;
        try {
            String a2 = g.a().a(context, "shasign");
            if (a2 != null && !"".equals(a2)) {
                return a2;
            }
            Signature[] l2 = l(context);
            if (!(l2 == null || (c2 = new ac().c(l2[0].toByteArray())) == null || "".equals(c2))) {
                g.a().a(context, "shasign", c2);
                return c2;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    public static String a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(random.nextInt());
        }
        return stringBuffer.toString();
    }

    public static int e(Context context) {
        PackageInfo a2;
        if (context == null || (a2 = a(context, "com.jingdong.app.mall")) == null) {
            return 0;
        }
        return a2.versionCode;
    }

    private static void m(Context context) {
        String str;
        PackageInfo packageInfo;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null)) {
                    a = packageInfo.packageName;
                    b = packageInfo.versionCode;
                    c = packageInfo.versionName;
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    return;
                }
                if (applicationInfo.labelRes != 0) {
                    d = context.getResources().getString(applicationInfo.labelRes);
                    return;
                }
                if (applicationInfo.nonLocalizedLabel == null) {
                    str = null;
                } else {
                    str = applicationInfo.nonLocalizedLabel.toString();
                }
                d = str;
            } catch (Exception unused) {
            }
        }
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(a)) {
            m(context);
        }
        return a;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(c)) {
            m(context);
        }
        return c;
    }

    public static int h(Context context) {
        if (b == -1) {
            m(context);
        }
        return b;
    }

    public static PackageInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (x.class) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                    if (packageInfo != null) {
                        return packageInfo;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(e)) {
            if (Build.VERSION.RELEASE.length() <= 0) {
                return "";
            }
            e = Build.VERSION.RELEASE;
        }
        return e;
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(f)) {
            f = Build.BRAND;
        }
        return f;
    }

    public static String k(Context context) {
        if (TextUtils.isEmpty(g)) {
            g = Build.MODEL;
        }
        return g;
    }
}
