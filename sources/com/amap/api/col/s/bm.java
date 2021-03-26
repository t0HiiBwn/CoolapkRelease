package com.amap.api.col.s;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DeviceInfo */
public final class bm {
    private static String A = "";
    static String a = "";
    static String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static a g = null;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k = null;
    private static boolean l = false;
    private static volatile boolean m = false;
    private static String n = "";
    private static boolean o = false;
    private static String p = "";
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static boolean v = false;
    private static String w = "";
    private static long x;
    private static int y;
    private static String z;

    /* compiled from: DeviceInfo */
    public interface a {
        cy a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    public static String a() {
        return k;
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(e)) {
                return e;
            }
            a aVar = g;
            if (aVar == null) {
                return "";
            }
            return aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    public static a c() {
        return g;
    }

    public static String a(final Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (context == null) {
                return "";
            }
            String I = I(context);
            b = I;
            if (!TextUtils.isEmpty(I)) {
                return b;
            }
            if (g == null || m) {
                return "";
            }
            m = true;
            cg.c().submit(new Runnable() {
                /* class com.amap.api.col.s.bm.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Map<String, String> b = bm.g.b();
                        String a2 = bm.g.a(bm.h(context), "", "", bm.v(context));
                        if (!TextUtils.isEmpty(a2)) {
                            cs.a();
                            String a3 = bm.g.a(context, new String(cs.a(bm.g.a(a2.getBytes(), b))));
                            if (!TextUtils.isEmpty(a3)) {
                                bm.b = a3;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            return "";
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String v2 = v(context);
            if (v2 != null) {
                if (v2.length() >= 5) {
                    return v2.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return G(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int e(Context context) {
        try {
            return E(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private static String z(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (bs.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z2 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z2 = false;
                            } else if (eventType == 4) {
                                if (z2) {
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
                                    z2 = true;
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

    /* compiled from: DeviceInfo */
    static class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String unused = bm.n = obtain2.readString();
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: private */
    public static String A(Context context) {
        int i2 = 0;
        if (bs.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                Class<?> cls = Class.forName(bs.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
                Object invoke = cls.getMethod(bs.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
                if (invoke != null) {
                    String str = (String) invoke;
                    n = str;
                    return str;
                }
            } catch (Throwable unused) {
                o = true;
            }
        } else if (bs.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                Intent intent = new Intent();
                intent.setAction(bs.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(bs.c("UY29tLmh1YXdlaS5od2lk"));
                b bVar = new b();
                if (context.bindService(intent, bVar, 1)) {
                    while (i2 < 100 && TextUtils.isEmpty(n)) {
                        i2++;
                        Thread.sleep(15);
                    }
                    context.unbindService(bVar);
                }
                return n;
            } catch (Throwable th) {
                cd.a(th, "oa", "hw");
            }
        } else {
            "OPPO".equalsIgnoreCase(Build.MANUFACTURER);
            o = true;
        }
        return n;
    }

    public static String g(final Context context) {
        try {
            if (o) {
                return "";
            }
            if (!TextUtils.isEmpty(n)) {
                return n;
            }
            if (Looper.getMainLooper() != Looper.myLooper()) {
                return A(context);
            }
            cg.c().submit(new Runnable() {
                /* class com.amap.api.col.s.bm.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    bm.A(context);
                }
            });
            return n;
        } catch (Throwable unused) {
        }
    }

    public static String h(Context context) {
        try {
            String str = a;
            if (str != null && !"".equals(str)) {
                return a;
            }
            if (b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            String str2 = a;
            if (str2 != null && !"".equals(str2)) {
                return a;
            }
            try {
                a = z(context);
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
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) bs.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                q = Build.SERIAL;
            }
            String str = q;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), bs.c(new String(cc.a(13))));
            p = string;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return p;
        }
    }

    private static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
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
                if (b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                boolean z2 = true;
                                int i2 = 0;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z2) {
                                        z2 = false;
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
            String str = r;
            if (str != null && !"".equals(str)) {
                return r;
            }
            if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return r;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            r = wifiManager.getConnectionInfo().getMacAddress();
            if (bs.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(r) || bs.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(r)) {
                r = h();
            }
            return r;
        } catch (Throwable unused) {
        }
    }

    private static String h() {
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

    static String[] d() {
        return new String[]{"", ""};
    }

    static String n(Context context) {
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

    public static int o(Context context) {
        try {
            return G(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int p(Context context) {
        try {
            return E(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String q(Context context) {
        StringBuilder sb;
        try {
            String str = s;
            if (str != null && !"".equals(str)) {
                return s;
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
            s = sb.toString();
            return s;
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "";
            }
            if (!TextUtils.isEmpty(i)) {
                return i;
            }
            TelephonyManager H = H(context);
            if (h == -1) {
                Method a2 = bs.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                if (a2 != null) {
                    try {
                        h = ((Integer) a2.invoke(H, new Object[0])).intValue();
                    } catch (Throwable unused) {
                        h = 0;
                    }
                } else {
                    h = 0;
                }
            }
            Method a3 = bs.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (a3 == null) {
                h = 0;
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < h; i2++) {
                try {
                    sb.append((String) a3.invoke(H, Integer.valueOf(i2)));
                    sb.append(str);
                } catch (Throwable unused2) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                h = 0;
                return "";
            }
            String substring = sb2.substring(0, sb2.length() - 1);
            i = substring;
            return substring;
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static String s(Context context) {
        try {
            String t2 = t(context);
            try {
                if (TextUtils.isEmpty(t2)) {
                    t2 = a(context);
                }
                if (TextUtils.isEmpty(t2)) {
                    t2 = h(context);
                }
                if (TextUtils.isEmpty(t2)) {
                    t2 = g(context);
                }
                if (TextUtils.isEmpty(t2)) {
                    t2 = j(context);
                }
                return TextUtils.isEmpty(t2) ? B(context) : t2;
            } catch (Throwable unused) {
                return t2;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String B(Context context) {
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        try {
            String b2 = ci.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(b2)) {
                w = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor b3 = ci.b(context, "open_common");
                ci.a(b3, "a1", bs.b(w));
                ci.a(b3);
            } else {
                w = bs.c(b2);
            }
            return w;
        } catch (Throwable unused) {
            return w;
        }
    }

    public static String t(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            String str = t;
            if (str != null && !"".equals(str)) {
                return t;
            }
            if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return t;
            }
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            Method a2 = bs.a(H.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = bs.a(H.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                t = (String) a2.invoke(H, new Object[0]);
            }
            if (t == null) {
                t = "";
            }
            return t;
        } catch (Throwable unused) {
        }
    }

    public static String u(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String str = u;
            if (str != null && !"".equals(str)) {
                return u;
            }
            if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return u;
            }
            TelephonyManager H = H(context);
            if (H == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = bs.a(H.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    u = (String) a2.invoke(H, new Object[0]);
                }
                if (u == null) {
                    u = "";
                }
            }
            return u;
        } catch (Throwable unused) {
        }
    }

    public static String v(Context context) {
        try {
            return C(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long e() {
        long j2;
        long j3;
        long j4 = x;
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
            x = j3 + j2;
        } catch (Throwable unused) {
        }
        return x;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ IOException -> 0x0059 }] */
    public static int w(Context context) {
        int i2 = y;
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
                    y = i4;
                    return i4;
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                }
                int i4 = i3 / 1024;
                y = i4;
                return i4;
            }
        }
        int i4 = i3 / 1024;
        y = i4;
        return i4;
    }

    public static String f() {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        String property = System.getProperty("os.arch");
        z = property;
        return property;
    }

    static String x(Context context) {
        try {
            return D(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String C(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = A;
        if (str != null && !"".equals(str)) {
            return A;
        }
        if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return A;
        }
        TelephonyManager H = H(context);
        if (H == null) {
            return "";
        }
        Method a2 = bs.a(H.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            A = (String) a2.invoke(H, new Object[0]);
        }
        if (A == null) {
            A = "";
        }
        return A;
    }

    private static String D(Context context) {
        if (!b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager H = H(context);
        if (H == null) {
            return "";
        }
        String simOperatorName = H.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? H.getNetworkOperatorName() : simOperatorName;
    }

    private static int E(Context context) {
        ConnectivityManager F;
        NetworkInfo activeNetworkInfo;
        if (context == null || !b(context, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (F = F(context)) == null || (activeNetworkInfo = F.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager F(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int G(Context context) {
        TelephonyManager H;
        if (b(context, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (H = H(context)) != null) {
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

    private static String I(Context context) {
        if (!c) {
            return "";
        }
        String str = null;
        try {
            str = J(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = bs.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(bn.a(bs.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), bn.b(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static String J(Context context) {
        String str;
        try {
            str = K(context);
        } catch (Throwable unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(bs.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(bq.a(bs.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String K(Context context) {
        RandomAccessFile randomAccessFile;
        String[] split;
        String a2 = bq.a(bs.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String L = L(context);
        if (TextUtils.isEmpty(L)) {
            return "";
        }
        File file = new File(L + File.separator + bs.c("KYmFja3Vwcw"), bs.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(randomAccessFile);
                            return "";
                        }
                    }
                    String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                    if (TextUtils.isEmpty(str) || !str.contains(bs.c("SIw")) || (split = str.split(bs.c("SIw"))) == null || split.length != 2 || !TextUtils.equals(a2, split[0])) {
                        a(byteArrayOutputStream2);
                        a(randomAccessFile);
                    } else {
                        String str2 = split[1];
                        a(byteArrayOutputStream2);
                        a(randomAccessFile);
                        return str2;
                    }
                } catch (Throwable unused2) {
                    a(byteArrayOutputStream);
                    a(randomAccessFile);
                    return "";
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return "";
            }
        }
        return "";
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String L(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(bs.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(bs.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(bs.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String r(Context context) {
        ConnectivityManager F;
        NetworkInfo activeNetworkInfo;
        try {
            if (!b(context, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (F = F(context)) == null || (activeNetworkInfo = F.getActiveNetworkInfo()) == null) {
                return "";
            }
            return activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
