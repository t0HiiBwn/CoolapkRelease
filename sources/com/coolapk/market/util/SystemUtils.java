package com.coolapk.market.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SystemUtils {
    public static boolean shouldInit(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[SYNTHETIC, Splitter:B:18:0x0041] */
    private static String getProcessName(int i) {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            th.printStackTrace();
            return null;
        }
    }

    public static String getMyProcessName(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean isProcessRunning(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAccessibilitySettingsOn(Context context, String str) {
        String string;
        try {
            int i = Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled");
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
            if (i != 1 || (string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services")) == null) {
                return false;
            }
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isBelowKitkat() {
        return Build.VERSION.SDK_INT < 19;
    }

    public static boolean isKitkatOrUpper() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean isLollipopOrUpper() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isKitkat() {
        return Build.VERSION.SDK_INT == 19;
    }

    public static void setComponentEnabledSettingDisabled(Context context, Class<?> cls) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), 2, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isComponentEnabled(Context context, Class<?> cls) {
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls));
            return componentEnabledSetting == 0 || componentEnabledSetting == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setComponentEnabledSettingEnabled(Context context, Class<?> cls) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWifiAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting() || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getMacAddress(Context context) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String getDeviceId(Context context) {
        File file = new File(context.getFilesDir(), "INSTALLATION");
        try {
            if (!file.exists()) {
                String str = null;
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (string != null && !"9774d56d682e549c".equals(string)) {
                    str = UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)).toString();
                }
                if (str == null) {
                    str = UUID.randomUUID().toString();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bArr = new byte[((int) randomAccessFile.length())];
            randomAccessFile.readFully(bArr);
            randomAccessFile.close();
            return new String(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 8192).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 8192).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getUserAgent() {
        return getUserAgent(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r3.isEmpty() != false) goto L_0x000f;
     */
    public static String getUserAgent(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        str = System.getProperty("http.agent");
        sb.append(str);
        sb.append(" (#Build; ");
        sb.append(Build.BRAND);
        sb.append("; ");
        sb.append(Build.MODEL);
        sb.append("; ");
        sb.append(Build.DISPLAY);
        sb.append("; ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(")");
        return sb.toString();
    }

    public static File getDefaultCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    public static File getDefaultDownloadDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        return externalFilesDir == null ? new File(getDefaultCacheDir(context), Environment.DIRECTORY_DOWNLOADS) : externalFilesDir;
    }

    public static Bundle getMetaData(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045 A[SYNTHETIC, Splitter:B:17:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052 A[SYNTHETIC, Splitter:B:25:0x0052] */
    public static String getSystemProperty(String str) {
        Throwable th;
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isSmartisanPro() {
        return Build.BRAND.equals("SMARTISAN") && (Build.MODEL.equals("OD103") || Build.MODEL.equals("OD105"));
    }

    public static String getAuthority(Context context) {
        return context.getPackageName() + ".fileprovider";
    }
}
