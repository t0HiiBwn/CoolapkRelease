package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.pro.br;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EnvelopeManager */
public class b {
    public static String a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static boolean k;
    private int j = 0;

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i("EnvelopeManager", "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty("debug.umeng.umTaskId", "");
        h = UMUtils.getSystemProperty("debug.umeng.umCaseId", "");
        return (!TextUtils.isEmpty(g) && !"empty".equals(g)) && (!TextUtils.isEmpty(h) && !"empty".equals(h));
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        String str4;
        Exception e2;
        String str5;
        Envelope envelope;
        String str6;
        if (!(!ULog.DEBUG || jSONObject == null || jSONObject2 == null)) {
            Log.i("EnvelopeManager", "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i("EnvelopeManager", "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        JSONObject jSONObject3 = null;
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            JSONObject b2 = b(context);
            if (!(b2 == null || jSONObject == null)) {
                b2 = a(b2, jSONObject);
            }
            if (!(b2 == null || jSONObject2 == null)) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!(next == null || !(next instanceof String) || (str6 = next) == null || jSONObject2.opt(str6) == null)) {
                        try {
                            b2.put(str6, jSONObject2.opt(str6));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            String str7 = "u";
            String str8 = "1.0.0";
            if (!TextUtils.isEmpty(str2)) {
                str7 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str8 = str3;
            }
            if (b2 != null) {
                String str9 = str7 + "==" + str8 + "&=";
                if (TextUtils.isEmpty(str9)) {
                    return a(101, b2);
                }
                if (str9.endsWith("&=")) {
                    str9 = str9.substring(0, str9.length() - 2);
                }
                str5 = str9;
            } else {
                str5 = null;
            }
            if (b2 != null) {
                try {
                    e a2 = e.a(context);
                    if (a2 != null) {
                        a2.b();
                        String encodeToString = Base64.encodeToString(new br().a(a2.c()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject4 = b2.getJSONObject("header");
                            jSONObject4.put("id_tracking", encodeToString);
                            b2.put("header", jSONObject4);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (b2 == null || !DataHelper.largeThanMaxSize((long) b2.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                if (b2 != null) {
                    Envelope a3 = a(context, b2.toString().getBytes());
                    if (a3 == null) {
                        return a(111, b2);
                    }
                    envelope = a3;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize((long) envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, b2);
                }
                int a4 = a(context, envelope, str5, b2 != null ? b2.optJSONObject("header").optString("app_version") : null, str);
                if (a4 != 0) {
                    return a(a4, b2);
                }
                if (ULog.DEBUG) {
                    Log.i("EnvelopeManager", "constructHeader size is " + b2.toString().getBytes().length);
                }
                if (!str5.startsWith("z") && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return b2;
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
            }
            return a(113, b2);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e3) {
                        e2 = e3;
                        jSONObject3 = jSONObject5;
                        UMCrashManager.reportCrash(context, e2);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject5;
                } catch (Exception e4) {
                    e2 = e4;
                    UMCrashManager.reportCrash(context, e2);
                    return a(110, jSONObject3);
                }
            }
            if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                if (jSONObject2 != null) {
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        if (!(next2 == null || !(next2 instanceof String) || (str4 = next2) == null || jSONObject2.opt(str4) == null)) {
                            try {
                                jSONObject3.put(str4, jSONObject2.opt(str4));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
            }
            return a(110, jSONObject3);
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("header", new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (!(jSONObject3 == null || jSONObject2 == null)) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!(next == null || !(next instanceof String) || (str2 = next) == null || jSONObject2.opt(str2) == null)) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 == null || !DataHelper.largeThanMaxSize((long) jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                String str3 = null;
                if (jSONObject3 != null) {
                    Envelope a2 = a(context, jSONObject3.toString().getBytes());
                    if (a2 == null) {
                        return a(111, jSONObject3);
                    }
                    envelope = a2;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize((long) envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject3);
                }
                if (jSONObject3 != null) {
                    str3 = jSONObject3.optJSONObject("header").optString("app_version");
                }
                int a3 = a(context, envelope, "z==1.2.0", str3, str);
                if (a3 != 0) {
                    return a(a3, jSONObject3);
                }
                if (ULog.DEBUG) {
                    Log.i("EnvelopeManager", "constructHeader size is " + jSONObject3.toString().getBytes().length);
                }
                return jSONObject3;
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
            }
            return a(113, jSONObject3);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static JSONObject b(Context context) {
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_signature", DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put("app_sig_sha1", DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put("app_sig_sha", DeviceConfig.getAppHashKey(context));
                jSONObject2.put("app_version", DeviceConfig.getAppVersionName(context));
                jSONObject2.put("version_code", Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put("idmd5", DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put("cpu", DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put("mccmnc", mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject2.put("mccmnc", "");
                }
                String subOSName = DeviceConfig.getSubOSName(context);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject2.put("sub_os_name", subOSName);
                }
                String subOSVersion = DeviceConfig.getSubOSVersion(context);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject2.put("sub_os_version", subOSVersion);
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put("device_type", deviceType);
                }
                jSONObject2.put("package_name", DeviceConfig.getPackageName(context));
                jSONObject2.put("sdk_type", "Android");
                jSONObject2.put("device_id", DeviceConfig.getDeviceId(context));
                jSONObject2.put("device_model", Build.MODEL);
                jSONObject2.put("device_board", Build.BOARD);
                jSONObject2.put("device_brand", Build.BRAND);
                jSONObject2.put("device_manutime", Build.TIME);
                jSONObject2.put("device_manufacturer", Build.MANUFACTURER);
                jSONObject2.put("device_manuid", Build.ID);
                jSONObject2.put("device_name", Build.DEVICE);
                jSONObject2.put("os_version", Build.VERSION.RELEASE);
                jSONObject2.put("os", "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put("resolution", resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put("mc", DeviceConfig.getMac(context));
                jSONObject2.put("timezone", DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put("country", localeInfo[0]);
                jSONObject2.put("language", localeInfo[1]);
                jSONObject2.put("carrier", DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put("display_name", DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put("access", "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put("access", "2G/3G");
                } else {
                    jSONObject2.put("access", "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put("access_subtype", networkAccessMode[1]);
                }
                if (FieldManager.allow("header_local_ip")) {
                    jSONObject2.put("local_ip", DeviceConfig.getIPAddress(context));
                }
                jSONObject2.put("network_type", DeviceConfig.getNetworkType(context));
                jSONObject2.put("com_ver", "9.3.3");
                jSONObject2.put("com_type", SdkVersion.SDK_TYPE);
                jSONObject2.put("mini_ver", "1");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject2.put("module", a);
                }
                jSONObject2.put("api_level", Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put("urec_ver", UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put("session_id", uUIDForZid);
                } catch (Throwable unused2) {
                }
                i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put("oaid_required_time", UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("successful_requests", sharedPreferences.getInt("successful_request", 0));
                jSONObject.put("failed_requests", sharedPreferences.getInt("failed_requests", 0));
                jSONObject.put("req_time", sharedPreferences.getInt("last_request_spent_ms", 0));
                if (UMConfigure.shouldCollectZData()) {
                    String zData = UMUtils.getZData(context);
                    if (!TextUtils.isEmpty(zData)) {
                        jSONObject.put("zdata", zData);
                        jSONObject.put("zdata_req_ts", UMUtils.getZDataRequestTime(context));
                        jSONObject.put("zdata_ver", UMUtils.VALUE_ASMS_VERSION);
                    }
                }
            } catch (Exception unused4) {
            }
            jSONObject.put("channel", UMUtils.getChannel(context));
            jSONObject.put("appkey", UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put("devicetoken", deviceToken);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put("umid", imprintProperty);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put("wrapper_type", a.a);
                jSONObject.put("wrapper_version", a.b);
            } catch (Exception unused5) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                boolean checkPermission2 = UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                boolean checkPermission3 = UMUtils.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION");
                jSONObject.put("targetSdkVer", targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put("rps_pr", "yes");
                } else {
                    jSONObject.put("rps_pr", "no");
                }
                if (checkPermission2) {
                    jSONObject.put("acl_pr", "yes");
                } else {
                    jSONObject.put("acl_pr", "no");
                }
                if (checkPermission3) {
                    jSONObject.put("afl_pr", "yes");
                } else {
                    jSONObject.put("afl_pr", "no");
                }
            } catch (Throwable unused6) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused7) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i_ver", "1.2.0");
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                    jSONObject3.put("a_ver", UMUtils.VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                    jSONObject3.put("g_ver", UMUtils.VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                    jSONObject3.put("p_ver", UMUtils.VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                    jSONObject3.put("s_ver", UMUtils.VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                    jSONObject3.put("c_ver", UMUtils.VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                    jSONObject3.put("n_ver", UMUtils.VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                    jSONObject3.put("m_ver", UMUtils.VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject3.put("u_ver", UMUtils.VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                    jSONObject3.put("v_ver", UMUtils.VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject3.put("z_ver", UMUtils.VALUE_ASMS_VERSION);
                }
                jSONObject.put("module_ver", jSONObject3);
            } catch (Throwable unused8) {
            }
            byte[] a2 = ImprintHandler.getImprintService(context).a();
            if (a2 != null && a2.length > 0) {
                try {
                    jSONObject.put("imprint", Base64.encodeToString(a2, 0));
                } catch (JSONException e4) {
                    UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                return new JSONObject().put("header", jSONObject);
            }
            return null;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (!(jSONObject == null || jSONObject2 == null || jSONObject.opt("header") == null || !(jSONObject.opt("header") instanceof JSONObject))) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!(next == null || !(next instanceof String) || (str = next) == null || jSONObject2.opt(str) == null)) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals("vertical_type") && (jSONObject2.opt(str) instanceof Integer)) {
                            this.j = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (k) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b2 = d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (str.startsWith("z") || str.startsWith("i") || str.startsWith("a") || str.startsWith("t")) {
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
        return d.a(context, ".emitter", sb.toString(), binary);
    }

    public static void a(boolean z) {
        k = z;
    }
}
