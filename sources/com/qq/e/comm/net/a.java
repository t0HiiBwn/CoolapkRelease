package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002a: INVOKE  (r0v4 int) = 
      (wrap: android.telephony.TelephonyManager : 0x0023: CHECK_CAST (r0v3 android.telephony.TelephonyManager) = (android.telephony.TelephonyManager) (wrap: java.lang.Object : 0x001f: INVOKE  (r0v2 java.lang.Object) = (r0v1 android.content.Context), ("phone") type: VIRTUAL call: android.content.Context.getSystemService(java.lang.String):java.lang.Object))
     type: VIRTUAL call: android.telephony.TelephonyManager.getNetworkType():int)] */
    private static String a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(((TelephonyManager) appContext.getSystemService("phone")).getNetworkType());
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject a(PM pm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
        jSONObject.putOpt("sdk_st", 1);
        jSONObject.putOpt("sdk_cnl", 1);
        if (!TextUtils.isEmpty("")) {
            jSONObject.putOpt("sdk_ex1", "");
        }
        if (!TextUtils.isEmpty("")) {
            jSONObject.putOpt("sdk_ex2", "");
        }
        return jSONObject;
    }

    public static JSONObject a(SM sm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt("sid", sm.getSid());
        }
        return jSONObject;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt("an", aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
            jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
        }
        return jSONObject;
    }

    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            String a = a();
            if (!StringUtil.isEmpty(a)) {
                jSONObject.putOpt("cell_native", a);
            }
            jSONObject.putOpt("lat", deviceStatus.getLat());
            jSONObject.putOpt("lng", deviceStatus.getLng());
            for (Map.Entry<String, String> entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
