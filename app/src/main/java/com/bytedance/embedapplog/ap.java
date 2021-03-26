package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

public class ap {
    private static final String[] a = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] b = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, IAppParam iAppParam) {
        HashMap<String, String> hashMap;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap2 = new HashMap(a.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap2.put(b[i], optString);
            }
            i++;
        }
        if (iAppParam != null) {
            try {
                hashMap = iAppParam.getAppSSIDs(context);
            } catch (Exception e) {
                bo.a(e);
            }
        } else {
            hashMap = null;
        }
        if (bp.b(context) && hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        try {
            HashMap<String, String> extraParams = AppLog.getExtraParams() == null ? null : AppLog.getExtraParams().getExtraParams();
            if (extraParams != null) {
                hashMap2.putAll(extraParams);
            }
        } catch (Exception e2) {
            bo.a(e2);
        }
        if (AppLog.sCustomNetParams.size() > 0) {
            hashMap2.putAll(AppLog.sCustomNetParams);
        }
        if (z) {
            hashMap2.put("ssmix", "a");
        }
        String b2 = bl.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("ac", b2);
        }
        String str2 = (String) AppLog.getHeaderValue("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) AppLog.getHeaderValue("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap2.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap2.put("os_version", optString2);
        hashMap2.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap2.put("device_platform", "android");
        int intValue = ((Integer) AppLog.getHeaderValue("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap2.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) AppLog.getHeaderValue("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap2.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) AppLog.getHeaderValue("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap2.put("update_version_code", String.valueOf(intValue3));
        }
        String a2 = bw.a(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(a2)) {
            hashMap2.put("oaid", a2);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap2.put("cdid", optString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        char c = '?';
        if (str.indexOf(63) >= 0) {
            c = '&';
        }
        sb.append(c);
        return bp.a(sb.toString(), hashMap2, "UTF-8");
    }

    public static String[] a(Context context, JSONObject jSONObject) {
        String[] strArr = new String[ao.a().getSendHeadersUris().length];
        String str = AppLog.getEncryptAndCompress() ? "/service/2/app_log/?tt_data=a" : "/service/2/app_log/?";
        for (int i = 0; i < ao.a().getSendHeadersUris().length; i++) {
            strArr[i] = a(context, jSONObject, ao.a().getSendHeadersUris()[i] + str, true, AppLog.getIAppParam());
            strArr[i] = ao.a(strArr[i], ao.b);
        }
        return strArr;
    }
}
