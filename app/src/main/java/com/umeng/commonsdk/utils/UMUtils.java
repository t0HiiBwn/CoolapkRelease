package com.umeng.commonsdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String KEY_SHARED_PREFERENCES_NAME = "umeng_common_config";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String SP_FILE_NAME = "um_session_id";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static final String WIFI = "Wi-Fi";
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static Object spLock = new Object();

    public static String genId() {
        return "1234567890";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    public static void setMultiProcessSP(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        synchronized (spLock) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (str2 != null) {
                        if (isMainProgress(context)) {
                            sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
                        } else {
                            String subProcessName = UMFrUtils.getSubProcessName(context);
                            Context applicationContext = context.getApplicationContext();
                            sharedPreferences = applicationContext.getSharedPreferences(subProcessName + "_umeng_common_config", 0);
                        }
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putString(str, str2).commit();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        return null;
     */
    public static String getMultiProcessSP(Context context, String str) {
        SharedPreferences sharedPreferences;
        synchronized (spLock) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (isMainProgress(context)) {
                        sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
                    } else {
                        String subProcessName = UMFrUtils.getSubProcessName(context);
                        Context applicationContext = context.getApplicationContext();
                        sharedPreferences = applicationContext.getSharedPreferences(subProcessName + "_umeng_common_config", 0);
                    }
                    if (sharedPreferences == null) {
                        return null;
                    }
                    return sharedPreferences.getString(str, null);
                }
            }
            return null;
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "last_appkey", str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set last app key e is " + e);
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set last app key e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, "last_appkey");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get last app key e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get last app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static void setAppkey(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "appkey", str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set app key e is " + e);
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set app key e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sAppkey)) {
                return UMConfigure.sAppkey;
            }
            return getMultiProcessSP(context, "appkey");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app key e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static void setChannel(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "channel", str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set channel e is " + e);
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "set channel e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sChannel)) {
                return UMConfigure.sChannel;
            }
            return getMultiProcessSP(context, "channel");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get channel e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get channel e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static File getFile(Context context) {
        if (context != null && checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not read gpu infor, e is " + e);
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not read gpu infor, e is " + th);
            }
            return new String[0];
        }
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
            } catch (IOException e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "Could not read from file /proc/cpuinfo, e is " + e);
                }
            }
        } catch (FileNotFoundException e2) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "Could not read from file /proc/cpuinfo, e is " + e2);
                }
            } catch (Exception e3) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get cpu e is " + e3);
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get cpu e is " + th);
                }
                return "";
            }
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkOperator();
            }
            return null;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get registered operator e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get registered operator e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return "";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network operator e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network operator e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            return String.valueOf(i2) + "*" + String.valueOf(i);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get display resolution e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get display resolution e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
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
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network access mode e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network access mode e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        android.util.Log.e("UMUtils", "fail to read user config locale, e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        android.util.Log.e("UMUtils", "get locale e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0021;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a A[ExcHandler: all (r3v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    public static Locale getLocale(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                return Locale.getDefault();
            }
            return locale;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get locale e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
        }
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            Log.e("UMUtils", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get mac e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get mac e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getOperator(Context context) {
        if (context == null) {
            return "Unknown";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "Unknown";
            }
            return telephonyManager.getNetworkOperator();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get get operator e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return "Unknown";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get get operator e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return "Unknown";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        android.util.Log.e("UMUtils", "get sub os name e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        android.util.Log.e("UMUtils", "get sub os name e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[ExcHandler: all (r3v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    public static String getSubOSName(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            Properties buildProp = getBuildProp();
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                str = "MIUI";
            } else if (isFlyMe()) {
                str = "Flyme";
            } else if (TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                return property;
            } else {
                str = "YunOS";
            }
            return str;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        android.util.Log.e("UMUtils", "get sub os version e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        android.util.Log.e("UMUtils", "get sub os version e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[ExcHandler: all (r3v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    public static String getSubOSVersion(Context context) {
        String property;
        String str;
        if (context == null) {
            return null;
        }
        try {
            Properties buildProp = getBuildProp();
            property = buildProp.getProperty("ro.miui.ui.version.name");
            if (TextUtils.isEmpty(property)) {
                if (isFlyMe()) {
                    str = getFlymeVersion(buildProp);
                } else {
                    str = getYunOSVersion(buildProp);
                }
                return str;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
        }
        return property;
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
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[SYNTHETIC, Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c  */
    public static Properties getBuildProp() {
        Throwable th;
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return properties;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return properties;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return properties;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                return "Tablet";
            }
            return "Phone";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get device type e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get device type e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app version code e is " + e);
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app version code e is " + th);
            }
            return "";
        }
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (!(context == null || str == null)) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + e);
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + th);
                }
                return "";
            }
        }
        return "";
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app version name e is " + e);
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app version name e is " + th);
            }
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (!(context == null || str == null)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version name e is " + e);
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version name e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
                return "";
            }
        }
        return "";
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
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
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
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app name e is " + e);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app name e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        return r10.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        android.util.Log.e("UMUtils", "MD5 e is " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0042 A[ExcHandler: all (r10v4 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "MD5 e is " + e);
            }
            return null;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        android.util.Log.e("UMUtils", "get file MD5 e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        android.util.Log.e("UMUtils", "get file MD5 e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[ExcHandler: all (r9v3 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    public static String getFileMD5(File file) {
        try {
            byte[] bArr = new byte[1024];
            if (!file.isFile()) {
                return "";
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return String.format("%1$032x", new BigInteger(1, instance.digest()));
                }
            }
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        android.util.Log.e("UMUtils", "encrypt by SHA1 e is " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        android.util.Log.e("UMUtils", "encrypt by SHA1 e is " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[ExcHandler: all (r4v3 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    public static String encryptBySHA1(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(bytes);
            return bytes2Hex(instance.digest());
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
        }
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String getUMId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "umid", null);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static String getUmengToken(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "ztoken", null);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            Class<?> cls = Class.forName("com.umeng.message.MessageSharedPrefs");
            if (cls == null || (method = cls.getMethod("getInstance", Context.class)) == null || (invoke = method.invoke(cls, applicationContext)) == null || (method2 = cls.getMethod("getDeviceToken", new Class[0])) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null || !(invoke2 instanceof String)) {
                return null;
            }
            return (String) invoke2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i("MobclickAgent", "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean checkPath(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getApplicationContext().getPackageManager().getActivityInfo(new ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("tencent" + str + ":"));
            List<ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            return context.getApplicationContext().getResources().getIdentifier(str, str2, context.getApplicationContext().getPackageName()) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData.get(str) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static String getAppMD5Signature(Context context) {
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                return !TextUtils.isEmpty(appMD5Signature) ? appMD5Signature.replace(":", "").toLowerCase() : appMD5Signature;
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getApplicationContext().getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isApplication(Context context) {
        try {
            String name = context.getApplicationContext().getClass().getSuperclass().getName();
            if (TextUtils.isEmpty(name) || !name.equals("android.app.Application")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getOaidRequiredTime(Context context) {
        if (!FieldManager.allow("header_device_oaid") || Build.VERSION.SDK_INT <= 28) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_oaid", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("key_umeng_sp_oaid_required_time", "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getZData(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_zdata", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("umeng_zdata", "");
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long getZDataRequestTime(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_zdata", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("umeng_zdata_req_ts", 0);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("um_session_id", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("session_id", "");
        }
        return "";
    }

    public static void setUUIDForZid(Context context) {
        String str;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("um_session_id", 0);
        try {
            str = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.3.3");
        }
        VALUE_ANALYTICS_VERSION = "9.3.3";
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                String str2 = (String) cls2.getDeclaredField("VERSION").get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append("p");
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        if (getClass("com.umeng.socialize.UMShareAPI") != null) {
            stringBuffer.append("s");
            Class<?> cls4 = getClass("com.umeng.a");
            if (cls4 != null) {
                try {
                    String str4 = (String) cls4.getDeclaredField("g").get(cls4);
                    if (!TextUtils.isEmpty(str4) && UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.Spy") != null) {
            stringBuffer.append("z");
        }
        stringBuffer.append("i");
        if (!(SdkVersion.SDK_TYPE == 1 || getClass("com.umeng.commonsdk.internal.UMOplus") == null)) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append("u");
            Class<?> cls5 = getClass("com.umeng.airec.BuildConfig");
            if (cls5 != null) {
                try {
                    String str5 = (String) cls5.getDeclaredField("VERSION_NAME").get(cls5);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.umverify.UMVerifyHelper") != null) {
            stringBuffer.append("n");
        }
        Class<?> cls6 = getClass("com.umeng.sms.UMSMS");
        if (cls6 != null) {
            stringBuffer.append("m");
            try {
                Method declaredMethod = cls6.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod != null) {
                    String str6 = (String) declaredMethod.invoke(cls6, new Object[0]);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_SMS_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str6);
                        }
                    }
                }
            } catch (Throwable unused6) {
            }
        }
        try {
            Class<?> cls7 = getClass("com.umeng.umcrash.UMCrash");
            if (cls7 != null) {
                stringBuffer.append("c");
                Field declaredField = cls7.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str7 = (String) declaredField.get(cls7);
                if (!TextUtils.isEmpty(str7)) {
                    VALUE_APM_VERSION = str7;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK版本号: " + str7);
                    }
                }
            }
        } catch (Throwable unused7) {
        }
        if (!TextUtils.isEmpty(stringBuffer)) {
            b.a = stringBuffer.toString();
            Log.i("MobclickAgent", "module init:" + b.a);
        }
    }
}
