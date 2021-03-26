package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static String sImei = "";
    private static String sImsi = "";
    private static String sMeid = "";
    private static String sWifiMac = "";

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (FieldManager.allow("header_device_id_imei") && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w("No IMEI.", e);
            }
        }
        sImei = str;
        return str;
    }

    public static String getImeiNew(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (FieldManager.allow("header_device_id_imei") && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Exception unused) {
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = telephonyManager.getDeviceId();
                    }
                } else {
                    str = telephonyManager.getDeviceId();
                }
            }
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w("No IMEI.", e);
            }
        }
        sImei = str;
        return str;
    }

    public static String getAndroidId(Context context) {
        if (FieldManager.allow("header_device_id_android_id") && context != null) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception unused) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("can't read android id");
                }
            }
        }
        return null;
    }

    public static String getSerial() {
        if (!FieldManager.allow("header_device_id_serialNo") || Build.VERSION.SDK_INT < 9) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        try {
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[Catch:{ all -> 0x0076 }] */
    private static String getMacByJavaAPI() {
        try {
            if (!FieldManager.allow("header_device_id_mac")) {
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                    byte[] hardwareAddress = nextElement.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    if (hardwareAddress.length == 0) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString().toLowerCase(Locale.getDefault());
                }
                while (networkInterfaces.hasMoreElements()) {
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getMacShell() {
        try {
            if (!FieldManager.allow("header_device_id_mac")) {
                return null;
            }
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            for (int i = 0; i < 3; i++) {
                try {
                    String reaMac = reaMac(strArr[i]);
                    if (reaMac != null) {
                        return reaMac;
                    }
                } catch (Throwable th) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.e(LOG_TAG, "open file  Failed", th);
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0023 A[SYNTHETIC, Splitter:B:18:0x0023] */
    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            FileReader fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
                try {
                    str2 = bufferedReader.readLine();
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileReader.close();
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Throwable unused4) {
        }
        return str2;
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (FileNotFoundException e) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (getImsi(context) == null) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            int i2 = context.getResources().getConfiguration().mnc;
            if (i != 0) {
                String valueOf = String.valueOf(i2);
                if (i2 < 10) {
                    valueOf = String.format("%02d", Integer.valueOf(i2));
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(String.valueOf(i));
                stringBuffer.append(valueOf);
                return stringBuffer.toString();
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static String getImsi(Context context) {
        if (!TextUtils.isEmpty(sImsi)) {
            return sImsi;
        }
        String str = null;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (FieldManager.allow("internal_imsi")) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Throwable unused) {
            }
        }
        sImsi = str;
        return str;
    }

    public static String getMeid(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !FieldManager.allow("internal_meid")) {
            return null;
        }
        try {
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 26) {
                return getIMEI(context);
            }
            String meid = meid(context);
            return TextUtils.isEmpty(meid) ? getIMEI(context) : meid;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String meid(Context context) {
        if (TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } catch (Throwable th) {
            ULog.e("meid:" + th.getMessage());
        }
        sMeid = str;
        return str;
    }

    public static String getSimICCID(Context context) {
        TelephonyManager telephonyManager;
        if (!FieldManager.allow("inner_iccid") || context == null) {
            return null;
        }
        try {
            if (!UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return null;
            }
            return telephonyManager.getSimSerialNumber();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSecondSimIMEi(Context context) {
        if (context == null || !FieldManager.allow("inner_imei2") || Build.VERSION.SDK_INT < 23 || !UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            Class<?> cls = telephonyManager.getClass();
            if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() == 2) {
                return (String) cls.getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, 2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                return String.valueOf(i2) + "*" + String.valueOf(i);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[Catch:{ SocketException -> 0x0069 }] */
    public static String getIPAddress(Context context) {
        String str;
        String str2 = null;
        try {
            Iterator it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            str = null;
            while (!it2.hasNext()) {
                try {
                    NetworkInterface networkInterface = (NetworkInterface) it2.next();
                    Iterator it3 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            InetAddress inetAddress = (InetAddress) it3.next();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && !networkInterface.getDisplayName().contains("dummy") && str2 == null) {
                                str2 = inetAddress.getHostAddress();
                            }
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address) && !networkInterface.getDisplayName().contains("dummy") && str == null) {
                                str = inetAddress.getHostAddress();
                            }
                        }
                    }
                    if (!it2.hasNext()) {
                    }
                    break;
                } catch (SocketException unused) {
                    str2 = str;
                    str = str2;
                    str2 = "SocketException";
                    if (str2 != null) {
                    }
                }
            }
        } catch (SocketException unused2) {
            str = str2;
            str2 = "SocketException";
            if (str2 != null) {
            }
        }
        if (str2 != null) {
            return str2;
        }
        return str == null ? "null" : str;
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (!(!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar instance = Calendar.getInstance(getLocale(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    public static boolean isChineseAera(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "country", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                if (getImsi(context) == null) {
                    String str = getLocaleInfo(context)[0];
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                        return true;
                    }
                } else {
                    int i = context.getResources().getConfiguration().mcc;
                    if (!(i == 460 || i == 461)) {
                        if (i == 0) {
                            String str2 = getLocaleInfo(context)[0];
                            if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("cn")) {
                            }
                        }
                    }
                    return true;
                }
                return false;
            } else if (imprintProperty.equals("cn")) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable unused) {
        }
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String getMac(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        String str = "";
        if (FieldManager.allow("header_device_id_mac")) {
            if (context == null) {
                return str;
            }
            if (Build.VERSION.SDK_INT < 23) {
                str = getMacBySystemInterface(context);
            } else if (Build.VERSION.SDK_INT == 23) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        str = getMacShell();
                    } else {
                        str = getMacBySystemInterface(context);
                    }
                }
            } else {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    str = getMacBySystemInterface(context);
                }
            }
        }
        sWifiMac = str;
        return str;
    }

    private static String getMacBySystemInterface(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (FieldManager.allow("header_device_id_mac")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    if (wifiManager != null) {
                        return wifiManager.getConnectionInfo().getMacAddress();
                    }
                    return "";
                } else if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = LOG_TAG;
                MLog.w(str, "Could not get mac address." + th.toString());
            }
            return "";
        }
    }

    public static int[] getResolutionArray(Context context) {
        int i;
        int i2;
        if (context == null) {
            return null;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                i = reflectMetrics(displayMetrics, "noncompatWidthPixels");
                i2 = reflectMetrics(displayMetrics, "noncompatHeightPixels");
            } else {
                i = -1;
                i2 = -1;
            }
            if (i == -1 || i2 == -1) {
                i = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            int[] iArr = new int[2];
            if (i > i2) {
                iArr[0] = i2;
                iArr[1] = i;
            } else {
                iArr[0] = i;
                iArr[1] = i2;
            }
            return iArr;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "read resolution fail", th);
            }
            return null;
        }
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            Signature signature = signatureArr[0];
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(signature.toByteArray());
            return Base64.encodeToString(instance.digest(), 0).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(LOG_TAG, th);
            return null;
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei)) {
                    return imei;
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "No IMEI.");
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                if (FieldManager.allow("header_device_id_android_id")) {
                    macBySystemInterface = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str = LOG_TAG;
                        MLog.i(str, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                    }
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo;
            } else if (Build.VERSION.SDK_INT == 23) {
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei2)) {
                    return imei2;
                }
                String macByJavaAPI = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                    }
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    String str2 = LOG_TAG;
                    MLog.i(str2, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                if (FieldManager.allow("header_device_id_android_id")) {
                    macByJavaAPI = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str3 = LOG_TAG;
                        MLog.i(str3, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                    }
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo2;
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                return macBySystemInterface2;
            } else {
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei3)) {
                    return imei3;
                }
                String serialNo4 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                if (FieldManager.allow("header_device_id_android_id")) {
                    serialNo4 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str4 = LOG_TAG;
                        MLog.i(str4, "getDeviceId, ANDROID_ID: " + serialNo4);
                    }
                }
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                String macByJavaAPI3 = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macByJavaAPI3)) {
                    return macByJavaAPI3;
                }
                String macBySystemInterface3 = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!AnalyticsConstants.UM_DEBUG) {
                    return macBySystemInterface3;
                }
                String str5 = LOG_TAG;
                MLog.i(str5, "getDeviceId, MAC: " + macBySystemInterface3);
                return macBySystemInterface3;
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdForBox(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                if (FieldManager.allow("header_device_id_android_id")) {
                    str = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = LOG_TAG;
                        MLog.i(str2, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str3 = LOG_TAG;
                    MLog.i(str3, "getDeviceId, MAC: " + macBySystemInterface);
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo)) {
                    return serialNo;
                }
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei;
            } else if (Build.VERSION.SDK_INT == 23) {
                if (FieldManager.allow("header_device_id_android_id")) {
                    str = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str4 = LOG_TAG;
                        MLog.i(str4, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macByJavaAPI = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                    }
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    String str5 = LOG_TAG;
                    MLog.i(str5, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo2)) {
                    return serialNo2;
                }
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei2;
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                return macBySystemInterface2;
            } else {
                if (FieldManager.allow("header_device_id_android_id")) {
                    str = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str6 = LOG_TAG;
                        MLog.i(str6, "getDeviceId: ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String serialNo4 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei3)) {
                    return imei3;
                }
                String macByJavaAPI3 = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macByJavaAPI3)) {
                    return macByJavaAPI3;
                }
                String macBySystemInterface3 = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!AnalyticsConstants.UM_DEBUG) {
                    return macBySystemInterface3;
                }
                String str7 = LOG_TAG;
                MLog.i(str7, "getDeviceId, MAC: " + macBySystemInterface3);
                return macBySystemInterface3;
            }
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String getOaid(Context context) {
        if (!FieldManager.allow("header_device_oaid")) {
            return "";
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_oaid", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("key_umeng_sp_oaid", "");
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getIdfa(Context context) {
        try {
            if (FieldManager.allow("header_tracking_idfa")) {
                return a.a(context);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    private static String getIMEI(Context context) {
        String str;
        Throwable th;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str2 = "";
        if (FieldManager.allow("header_device_id_imei")) {
            if (context == null) {
                return str2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        str = telephonyManager.getDeviceId();
                        try {
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str3 = LOG_TAG;
                                MLog.i(str3, "getDeviceId, IMEI: " + str);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (AnalyticsConstants.UM_DEBUG) {
                            }
                            str2 = str;
                            sImei = str2;
                            return str2;
                        }
                        str2 = str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = str2;
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w(LOG_TAG, "No IMEI.", th);
                    }
                    str2 = str;
                    sImei = str2;
                    return str2;
                }
            }
        }
        sImei = str2;
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    private static String getSerialNo() {
        String str;
        if (FieldManager.allow("header_device_id_serialNo") && Build.VERSION.SDK_INT >= 9) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Class<?> cls = Class.forName("android.os.Build");
                    str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable unused) {
                }
            } else {
                str = Build.SERIAL;
            }
            if (AnalyticsConstants.UM_DEBUG) {
                String str2 = LOG_TAG;
                MLog.i(str2, "getDeviceId, serial no: " + str);
            }
            return str;
        }
        str = "";
        if (AnalyticsConstants.UM_DEBUG) {
        }
        return str;
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return "MIUI";
            }
            if (isFlyMe()) {
                return "Flyme";
            }
            if (isEmui(buildProp)) {
                return "Emui";
            }
            return !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            if (isFlyMe()) {
                try {
                    return getFlymeVersion(buildProp);
                } catch (Throwable unused) {
                    return property;
                }
            } else if (isEmui(buildProp)) {
                return getEmuiVersion(buildProp);
            } else {
                return getYunOSVersion(buildProp);
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty("ro.build.hw_emui_api_level", null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[Catch:{ all -> 0x001d, all -> 0x0025 }] */
    private static Properties getBuildProp() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream2);
                fileInputStream2.close();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            if (fileInputStream != null) {
            }
            return properties;
        }
        return properties;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isEmui(Properties properties) {
        try {
            return properties.getProperty("ro.build.hw_emui_api_level", null) != null;
        } catch (Exception unused) {
        }
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }
}
