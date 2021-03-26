package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMInternalUtils */
public class j {
    private static final String a = "um_pri";
    private static final String b = "um_common_strength";
    private static final String c = "um_common_battery";

    public static JSONObject a(Context context) {
        TelephonyManager telephonyManager;
        JSONObject jSONObject;
        if (context == null) {
            return null;
        }
        if ((!UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") && !UMUtils.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        try {
            CellLocation cellLocation = telephonyManager.getCellLocation();
            int phoneType = telephonyManager.getPhoneType();
            if (phoneType == 1 && (cellLocation instanceof GsmCellLocation)) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                int cid = gsmCellLocation.getCid();
                if (cid <= 0 || cid == 65535) {
                    return null;
                }
                int lac = gsmCellLocation.getLac();
                jSONObject = new JSONObject();
                jSONObject.put("cid", cid);
                jSONObject.put("lacid", lac);
                jSONObject.put("ts", System.currentTimeMillis());
            } else if (phoneType != 2 || !(cellLocation instanceof CdmaCellLocation)) {
                return null;
            } else {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int baseStationId = cdmaCellLocation.getBaseStationId();
                int networkId = cdmaCellLocation.getNetworkId();
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", baseStationId);
                    jSONObject.put("lacid", networkId);
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences("um_pri", 0)) != null) {
            sharedPreferences.edit().putString("um_common_strength", str).commit();
        }
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("um_pri", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("um_common_strength", null);
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("um_pri", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("um_common_battery", null);
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences("um_pri", 0)) != null) {
            sharedPreferences.edit().putString("um_common_battery", str).commit();
        }
    }

    public static JSONArray d(Context context) {
        SensorManager sensorManager;
        JSONArray jSONArray = new JSONArray();
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return jSONArray;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            if (sensor != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a_type", sensor.getType());
                    jSONObject.put("a_ven", sensor.getVendor());
                    if (Build.VERSION.SDK_INT >= 24) {
                        jSONObject.put("a_id", sensor.getId());
                    }
                    jSONObject.put("a_na", sensor.getName());
                    jSONObject.put("a_ver", sensor.getVersion());
                    jSONObject.put("a_mar", (double) sensor.getMaximumRange());
                    jSONObject.put("a_ver", sensor.getVersion());
                    jSONObject.put("a_res", (double) sensor.getResolution());
                    jSONObject.put("a_po", (double) sensor.getPower());
                    if (Build.VERSION.SDK_INT >= 9) {
                        jSONObject.put("a_mid", sensor.getMinDelay());
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        jSONObject.put("a_mad", sensor.getMaxDelay());
                    }
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
