package com.amap.api.mapcore2d;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DeviceInfo */
public class cu {
    static String a = "";
    static String b = "";
    public static boolean c = false;
    static String d = "";
    static boolean e = false;
    static int f = -1;
    static String g = "";
    static String h = "";
    private static String i = null;
    private static boolean j = false;
    private static String k = "";
    private static String l = "";
    private static String m = "";
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static long r = 0;
    private static int s = 0;
    private static String t = null;
    private static String u = "";

    public static String a() {
        return i;
    }

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            da a2 = dj.a();
            if (!ef.a(context, a2)) {
                return "";
            }
            Class a3 = ef.a(context, a2, db.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a3 != null) {
                d = (String) a3.getMethod("getAdiuExtras", new Class[0]).invoke(a3, new Object[0]);
            }
            return d;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(final Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            da a2 = dj.a();
            if (a2 == null) {
                return null;
            }
            if (!ef.a(context, a2)) {
                return "";
            }
            final Class a3 = ef.a(context, a2, db.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a3 == null) {
                return b;
            }
            String str = (String) a3.getMethod("getADIU", Context.class).invoke(a3, context);
            if (!TextUtils.isEmpty(str)) {
                b = str;
                return str;
            } else if (j) {
                return "";
            } else {
                j = true;
                Cdo.d().submit(new Runnable() {
                    /* class com.amap.api.mapcore2d.cu.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Map map = (Map) a3.getMethod("getGetParams", new Class[0]).invoke(a3, new Object[0]);
                            if (map != null) {
                                String str = (String) a3.getMethod("getPostParam", String.class, String.class, String.class, String.class).invoke(a3, cu.h(context), cu.v(context), cu.m(context), cu.x(context));
                                if (!TextUtils.isEmpty(str)) {
                                    a3.getMethod("parseResult", Context.class, String.class).invoke(a3, context, new String(er.a().a(new eq(str.getBytes(), map))));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return G(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        try {
            return B(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void b() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private static String A(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (db.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z = false;
                            } else if (eventType == 4) {
                                if (z) {
                                    String text = newPullParser.getText();
                                    try {
                                        fileInputStream2.close();
                                    } catch (Throwable unused) {
                                    }
                                    return text;
                                }
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeValue = newPullParser.getAttributeValue(i2);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                    }
                    fileInputStream.close();
                    return "";
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.close();
            return "";
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String h(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String str = a;
            if (str != null && !"".equals(str)) {
                return a;
            }
            if (a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            String str2 = a;
            if (str2 != null && !"".equals(str2)) {
                return a;
            }
            try {
                a = A(context);
            } catch (Throwable unused) {
            }
            String str3 = a;
            if (str3 == null) {
                return "";
            }
            return str3;
        } catch (Throwable unused2) {
        }
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) db.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                l = Build.SERIAL;
            }
            String str = l;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), db.c(new String(dj.a(13))));
            k = string;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return k;
        }
    }

    private static boolean a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                return wifiManager.getConnectionInfo().getBSSID();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                boolean z = true;
                                int i2 = 0;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(";");
                                    }
                                    sb.append(scanResult.BSSID);
                                    i2++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    public static String m(Context context) {
        try {
            String str = m;
            if (str != null && !"".equals(str)) {
                return m;
            }
            if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return m;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            m = wifiManager.getConnectionInfo().getMacAddress();
            if (db.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(m) || db.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(m)) {
                m = e();
            }
            return m;
        } catch (Throwable unused) {
        }
    }

    private static String e() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = networkInterface.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    static String[] n(Context context) {
        try {
            if (a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (a(context, db.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        int cid = gsmCellLocation.getCid();
                        int lac = gsmCellLocation.getLac();
                        return new String[]{lac + "||" + cid, "gsm"};
                    }
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int systemId = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
                    }
                    return new String[]{"", ""};
                }
            }
            return new String[]{"", ""};
        } catch (Throwable unused) {
        }
    }

    static String o(Context context) {
        try {
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            String networkOperator = H.getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                return "";
            }
            if (networkOperator.length() < 3) {
                return "";
            }
            return networkOperator.substring(0, 3);
        } catch (Throwable unused) {
            return "";
        }
    }

    static String p(Context context) {
        try {
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            String networkOperator = H.getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                return "";
            }
            if (networkOperator.length() < 3) {
                return "";
            }
            return networkOperator.substring(3);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int q(Context context) {
        try {
            return G(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int r(Context context) {
        try {
            return D(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo s(Context context) {
        ConnectivityManager E;
        if (a(context, db.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E = E(context)) != null) {
            return E.getActiveNetworkInfo();
        }
        return null;
    }

    static String t(Context context) {
        try {
            NetworkInfo s2 = s(context);
            if (s2 == null) {
                return null;
            }
            return s2.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    static String u(Context context) {
        StringBuilder sb;
        try {
            String str = n;
            if (str != null && !"".equals(str)) {
                return n;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            n = sb.toString();
            return n;
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str, boolean z) {
        int i2;
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "";
            }
            if (!TextUtils.isEmpty(g)) {
                return g;
            }
            if (!z && (i2 = f) >= 0 && i2 < 2) {
                return "";
            }
            TelephonyManager H = H(context);
            if (f == -1) {
                Method a2 = db.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                if (a2 != null) {
                    try {
                        f = ((Integer) a2.invoke(H, new Object[0])).intValue();
                    } catch (Throwable unused) {
                        f = 0;
                    }
                } else {
                    f = 0;
                }
            }
            if (!z && f <= 1) {
                return "";
            }
            Method a3 = db.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (a3 == null) {
                f = 0;
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < f; i3++) {
                try {
                    sb.append((String) a3.invoke(H, Integer.valueOf(i3)));
                    sb.append(str);
                } catch (Throwable unused2) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                f = 0;
                return "";
            }
            String substring = sb2.substring(0, sb2.length() - 1);
            g = substring;
            return substring;
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static String v(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            String str = o;
            if (str != null && !"".equals(str)) {
                return o;
            }
            if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return o;
            }
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            Method a2 = db.a(H.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = db.a(H.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                o = (String) a2.invoke(H, new Object[0]);
            }
            if (o == null) {
                o = "";
            }
            return o;
        } catch (Throwable unused) {
        }
    }

    public static String w(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String str = p;
            if (str != null && !"".equals(str)) {
                return p;
            }
            if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return p;
            }
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = db.a(H.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    p = (String) a2.invoke(H, new Object[0]);
                }
                if (p == null) {
                    p = "";
                }
            }
            return p;
        } catch (Throwable unused) {
        }
    }

    public static String x(Context context) {
        try {
            return B(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long c() {
        long j2;
        long j3;
        long j4 = r;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j3 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j3 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            r = j3 + j2;
        } catch (Throwable unused) {
        }
        return r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ IOException -> 0x0057 }] */
    public static int y(Context context) {
        int i2 = s;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                try {
                    i3 = Integer.valueOf(bufferedReader2.readLine().split("\\s+")[1]).intValue();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    int i4 = i3 / 1024;
                    s = i4;
                    return i4;
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                }
                int i4 = i3 / 1024;
                s = i4;
                return i4;
            }
        }
        int i4 = i3 / 1024;
        s = i4;
        return i4;
    }

    public static String d() {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        String property = System.getProperty("os.arch");
        t = property;
        return property;
    }

    static String z(Context context) {
        try {
            return C(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String B(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = u;
        if (str != null && !"".equals(str)) {
            return u;
        }
        if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return u;
        }
        TelephonyManager H = H(context);
        if (H == null) {
            return "";
        }
        Method a2 = db.a(H.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            u = (String) a2.invoke(H, new Object[0]);
        }
        if (u == null) {
            u = "";
        }
        return u;
    }

    private static String C(Context context) {
        if (!a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager H = H(context);
        if (H == null) {
            return "";
        }
        String simOperatorName = H.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? H.getNetworkOperatorName() : simOperatorName;
    }

    private static int D(Context context) {
        ConnectivityManager E;
        NetworkInfo activeNetworkInfo;
        if (context == null || !a(context, db.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (E = E(context)) == null || (activeNetworkInfo = E.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager E(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String F(Context context) {
        String x = x(context);
        return (x == null || x.length() < 5) ? "" : x.substring(3, 5);
    }

    private static int G(Context context) {
        TelephonyManager H;
        if (a(context, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (H = H(context)) != null) {
            return H.getNetworkType();
        }
        return -1;
    }

    private static TelephonyManager H(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }
}
