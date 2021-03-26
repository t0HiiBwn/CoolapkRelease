package com.loc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class ep {
    static WifiManager a = null;
    private static int b;
    private static String[] c;
    private static String[] d = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static String e = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static boolean f = false;

    public static double a(double d2) {
        return b(d2);
    }

    public static float a(float f2) {
        return (float) (((double) ((long) (((double) f2) * 100.0d))) / 100.0d);
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static float a(double[] dArr) {
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
            ej.a(th, "Utils", "getServ");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    public static String a(long j, String str) {
        SimpleDateFormat simpleDateFormat;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat2 = null;
        try {
            simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
            try {
                simpleDateFormat.applyPattern(str);
            } catch (Throwable th2) {
                th = th2;
                simpleDateFormat2 = simpleDateFormat;
            }
        } catch (Throwable th3) {
            th = th3;
            ej.a(th, "Utils", "formatUTC");
            simpleDateFormat = simpleDateFormat2;
            if (j <= 0) {
            }
            if (simpleDateFormat != null) {
            }
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        return simpleDateFormat != null ? "NULL" : simpleDateFormat.format(Long.valueOf(j));
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? c(context, "android.provider.Settings$System") : c(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (query != null && query.moveToFirst() && query.getInt(0) > 0) {
                        z = true;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return z;
                }
            } catch (Throwable unused) {
                if (0 == 0) {
                    return true;
                }
                cursor.close();
                return true;
            }
        }
        return false;
    }

    public static boolean a(Location location, int i) {
        Boolean bool = false;
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bool = (Boolean) em.a(location, "isFromMockProvider", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        if (bool.booleanValue()) {
            return true;
        }
        Bundle extras = location.getExtras();
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        return i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean a(ds dsVar) {
        if (dsVar != null && !"8".equals(dsVar.d()) && !"5".equals(dsVar.d()) && !"6".equals(dsVar.d())) {
            return b(dsVar);
        }
        return false;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> d2 = d(str);
            String[] split = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (d2.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            if (((double) (i2 * 2)) >= ((double) (d2.size() + i)) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return u.a(jSONObject, str);
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
        return u.b(bArr);
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
            ej.a(th, "Utils", "getMccMnc");
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
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static int b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & 255) << ((1 - i2) * 8);
        }
        return i;
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
        if (!TextUtils.isEmpty(ej.h)) {
            return ej.h;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(k.c(context), 64);
        } catch (Throwable th) {
            ej.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(ej.i)) {
                ej.i = null;
            }
        } catch (Throwable th2) {
            ej.a(th2, "Utils", "getAppName");
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
        String c2 = k.c(context);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!TextUtils.isEmpty(ej.i)) {
            sb.append(",");
            sb.append(ej.i);
        }
        String sb2 = sb.toString();
        ej.h = sb2;
        return sb2;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            try {
                i = telephonyManager.getNetworkType();
            } catch (Throwable unused) {
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
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
        return a(Integer.parseInt(str), (byte[]) null);
    }

    public static double c(double d2) {
        return ((double) ((long) (d2 * 100.0d))) / 100.0d;
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            return em.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static NetworkInfo c(Context context) {
        try {
            return n.r(context);
        } catch (Throwable th) {
            ej.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    private static boolean c(Context context, String str) throws Throwable {
        return ((Integer) em.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) em.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] c(String str) {
        return b(Integer.parseInt(str), (byte[]) null);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static ArrayList<String> d(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c2 = c(context);
            return c2 != null && c2.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    public static double e(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static String e() {
        try {
            return o.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean e(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.processName.equals(k.c(context))) {
                    if (next.importance != 100) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            ej.a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static float f(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static boolean f(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String str : d) {
                if (context.checkCallingOrSelfPermission(str) == 0) {
                }
            }
            return true;
        }
        Application application = (Application) context;
        for (String str2 : d) {
            try {
                i = em.b(application.getBaseContext(), "checkSelfPermission", str2);
            } catch (Throwable unused) {
                i = 0;
            }
            if (i == 0) {
            }
        }
        return true;
        return false;
    }

    public static int g(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static boolean g(Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        try {
            i = em.b(((Application) context).getBaseContext(), "checkSelfPermission", e);
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    public static int h(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static boolean h(Context context) {
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
            return "true".equals(String.valueOf(em.a(a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return z;
        }
    }

    public static byte i(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String i(Context context) {
        NetworkInfo c2 = c(context);
        if (c2 == null || !c2.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c2.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = c2.getSubtypeName();
        switch (c2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
                }
                break;
        }
        return "2G";
    }

    public static String j(Context context) {
        String m = n.m(context);
        String str = "00:00:00:00:00:00";
        if (TextUtils.isEmpty(m) || m.equals(str)) {
            m = context == null ? str : eo.a(context, "pref", "smac", str);
        }
        if (!TextUtils.isEmpty(m)) {
            str = m;
        }
        if (!f) {
            if (context != null && !TextUtils.isEmpty(str)) {
                SharedPreferences.Editor a2 = eo.a(context, "pref");
                eo.a(a2, "smac", str);
                eo.a(a2);
            }
            f = true;
        }
        return str;
    }

    public static boolean k(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean l(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }
}
