package com.sina.deviceidjnisdk;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

public class DeviceInfo {
    public static String getDeviceId(Context context) {
        String str;
        String str2 = null;
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    str = telephonyManager.getDeviceId(0);
                } else {
                    str = telephonyManager.getDeviceId();
                }
                if (str != null) {
                    str2 = str;
                }
                str2 = "";
            } catch (Exception unused) {
            }
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static String getMacAddress(Context context) {
        WifiInfo connectionInfo;
        String str = null;
        if (isPermissionGranted(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return null;
                }
                str = connectionInfo.getMacAddress();
            } catch (Exception unused) {
                str = "";
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getImei(Context context) {
        return getDeviceId(context);
    }

    public static String getImsi(Context context) {
        String str;
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            str = telephonyManager.getSubscriberId();
        } else {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static boolean isPermissionGranted(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
