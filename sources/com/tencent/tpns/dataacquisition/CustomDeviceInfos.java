package com.tencent.tpns.dataacquisition;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomDeviceInfos {
    private static final String DEVICEINFOS_REAL_CLASSNAME = "com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos";
    private static boolean isWarned;
    private static Boolean ismportImplClassFlag;

    public static String getAndroidId(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getAndroidId", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getFacilityIdentity(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getFacilityIdentity", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getFacilityMacAddr(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getFacilityMacAddr", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getImsi(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getImsi", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static List<PackageInfo> getInstalledPackages(Context context) {
        try {
            return (List) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getInstalledPackages", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new ArrayList();
        }
    }

    public static String getIp(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getIp", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static Map<String, Integer> getRecentTasks(Context context) {
        try {
            return (Map) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRecentTasks", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static JSONObject getReportLocationJson(Context context) {
        try {
            return (JSONObject) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getReportLocationJson", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static Map<String, ActivityManager.RunningAppProcessInfo> getRunningAppProces(Context context) {
        try {
            return (Map) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRunningAppProces", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static Map<String, Integer> getRunningProcess(Context context) {
        try {
            return (Map) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRunningProcess", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static String getSimOperator(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getSimOperator", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getWiFiBBSID(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWiFiBBSID", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getWiFiSSID(Context context) {
        try {
            return (String) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWiFiSSID", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            return (WifiInfo) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWifiInfo", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        try {
            return (JSONArray) Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWifiTopN", context, Integer.valueOf(i)).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static boolean isImportImplClass() {
        Boolean bool = ismportImplClassFlag;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos");
            ismportImplClassFlag = true;
        } catch (ReflectException unused) {
            Log.w("TPush-DataAcq", "isImportImplClass false");
            ismportImplClassFlag = false;
        }
        return ismportImplClassFlag.booleanValue();
    }

    private static void showWarnMessage(ReflectException reflectException) {
        if (!isWarned) {
            isWarned = true;
        }
    }
}
