package com.amap.api.mapcore2d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Hashtable;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class gy {
    static WifiManager a = null;
    private static int b;
    private static String[] c;
    private static Hashtable<String, Long> d = new Hashtable<>();
    private static SparseArray<String> e = null;
    private static String[] f = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static String g = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static boolean h = false;

    public static double a(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static float a(float f2) {
        return (float) (((double) ((long) (((double) f2) * 100.0d))) / 100.0d);
    }

    public static float a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i) {
        return (i * 2) - 113;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            gu.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? b(context, "android.provider.Settings$System") : b(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return db.a(jSONObject, str);
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & 65280) >> 8);
        return bArr;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        try {
            return db.b(bArr);
        } catch (Throwable th) {
            gu.a(th, "Utils", "gz");
            return null;
        }
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            gu.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return (!"0".equals(strArr2[0]) || !"0".equals(strArr2[1]) || (strArr = c) == null) ? strArr2 : strArr;
        }
        c = strArr2;
        return strArr2;
    }

    public static double b(double d2) {
        return ((double) ((long) (d2 * 100.0d))) / 100.0d;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
            case 16:
            case 17:
            default:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(gu.g)) {
            return gu.g;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(cq.c(context), 64);
        } catch (Throwable th) {
            gu.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(gu.h)) {
                gu.h = null;
            }
        } catch (Throwable th2) {
            gu.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c2 = cq.c(context);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!TextUtils.isEmpty(gu.h)) {
            sb.append(",");
            sb.append(gu.h);
        }
        String sb2 = sb.toString();
        gu.g = sb2;
        return sb2;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (e == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            e = sparseArray;
            sparseArray.append(0, "UNKWN");
            e.append(1, "GPRS");
            e.append(2, "EDGE");
            e.append(3, "UMTS");
            e.append(4, "CDMA");
            e.append(5, "EVDO_0");
            e.append(6, "EVDO_A");
            e.append(7, "1xRTT");
            e.append(8, "HSDPA");
            e.append(9, "HSUPA");
            e.append(10, "HSPA");
            e.append(11, "IDEN");
            e.append(12, "EVDO_B");
            e.append(13, "LTE");
            e.append(14, "EHRPD");
            e.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return e.get(i, "UNKWN");
    }

    private static boolean b(Context context, String str) throws Throwable {
        return ((Integer) gw.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) gw.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] b(String str) {
        return a(d(str), (byte[]) null);
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            return gw.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean c(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (a == null) {
            a = (WifiManager) a(context, "wifi");
        }
        try {
            z = a.isWifiEnabled();
        } catch (Throwable unused) {
            z = false;
        }
        if (z || c() <= 17) {
            return z;
        }
        try {
            return "true".equals(String.valueOf(gw.a(a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return z;
        }
    }

    public static byte[] c(String str) {
        return b(d(str), (byte[]) null);
    }

    public static int d(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String d(Context context) {
        String m = cu.m(context);
        String str = "00:00:00:00:00:00";
        if (TextUtils.isEmpty(m) || m.equals(str)) {
            m = gx.a(context);
        }
        if (!TextUtils.isEmpty(m)) {
            str = m;
        }
        if (!h) {
            gx.a(context, str);
            h = true;
        }
        return str;
    }

    public static byte e(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static int f() {
        return new Random().nextInt(65536) - 32768;
    }
}
