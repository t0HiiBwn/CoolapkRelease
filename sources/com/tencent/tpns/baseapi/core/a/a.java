package com.tencent.tpns.baseapi.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.NetworkUtil;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.StatHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a {
    private static boolean a;
    private static boolean b;
    private static String c;
    private static String d;
    private static long e;
    private static boolean f;
    private static long g;
    private static boolean h;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x02c8 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v26, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16, types: [int] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.String] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static GUIDInfo a(final Context context, int i) {
        String str;
        Throwable th;
        String str2;
        String str3;
        Context context2;
        GUIDInfo gUIDInfo = new GUIDInfo();
        if (context == null) {
            Logger.e("GuidInfoManagerImpl", "context null");
            gUIDInfo.errCode = -1;
            return gUIDInfo;
        } else if (GuidInfoManager.isServerDestroy(context)) {
            Logger.e("GuidInfoManagerImpl", "refreshConnectInfoSynchronized: Resources have been destroyed");
            gUIDInfo.errCode = 10030006;
            return gUIDInfo;
        } else {
            Logger.d("GuidInfoManagerImpl", "action - refreshConnectInfoSynchronized");
            if (!Util.checkAccessId(XGApiConfig.getAccessId(context)) || !Util.checkAccessKey(XGApiConfig.getAccessKey(context))) {
                gUIDInfo.errCode = -501;
                return gUIDInfo;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            Logger.i("GuidInfoManagerImpl", "RefreshTime: " + currentTimeMillis);
            JSONObject jSONObject = new JSONObject();
            long accessId = XGApiConfig.getAccessId(context);
            String accessKey = XGApiConfig.getAccessKey(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                jSONObject.put("accessId", accessId);
                jSONObject.put("accessKey", accessKey);
                jSONObject.put("deviceType", 0);
                jSONObject.put("sdkVersion", "1.2.3.1");
                jSONObject.put("seq", currentTimeMillis);
                jSONObject.put("cloudVersion", CloudManager.getInstance(context).getCloudVersion());
                b bVar = new b();
                bVar.a = Util.getCurAppVersion(context);
                bVar.b = Build.MODEL;
                bVar.d = "android";
                bVar.e = context.getPackageName();
                bVar.f = Build.VERSION.RELEASE;
                jSONObject.put("deviceInfo", bVar.a());
                Pair<String, String> s = s(context);
                String str4 = (String) s.first;
                String str5 = (String) s.second;
                if (str4 != null) {
                    jSONObject.put("token", str4);
                }
                if (!Util.isNullOrEmptyString(str5)) {
                    jSONObject.put("tokenList", new JSONArray(str5));
                } else {
                    jSONObject.put("tokenList", new JSONArray());
                }
                jSONObject.put("protocolVersion", 2);
                jSONObject.put("timestamp", currentTimeMillis2);
                TBaseLogger.ii("GuidInfoManagerImpl", "Send request to GuidServer with token: " + str4);
                TBaseLogger.i("GuidInfoManagerImpl", "Send request to GuidServer: " + jSONObject.toString());
                String d2 = com.tencent.tpns.baseapi.core.a.d(context);
                String a2 = com.tencent.tpns.baseapi.core.net.a.a(d2);
                String c2 = c(context, d2);
                Logger.i("GuidInfoManagerImpl", "Send to GuidServerIpAddr: " + c2);
                String a3 = com.tencent.tpns.baseapi.core.net.a.a(context).a(c2, a2, jSONObject.toString(), new HttpRequestCallback() {
                    /* class com.tencent.tpns.baseapi.core.a.a.AnonymousClass1 */

                    @Override // com.tencent.tpns.baseapi.core.net.HttpRequestCallback
                    public void onSuccess(String str) {
                    }

                    @Override // com.tencent.tpns.baseapi.core.net.HttpRequestCallback
                    public void onFailure(int i, String str) {
                        if (!a.a) {
                            CloudManager.getInstance(context).clearGuid();
                            if (!NetworkUtil.isNetworkConnected(context)) {
                                Logger.w("GuidInfoManagerImpl", "GUID HttpRequest Throw Error: network unavailable");
                            } else if (!a.b) {
                                StatHelper.reportErrCode(context, i, str, currentTimeMillis, "");
                                boolean unused = a.a = true;
                            } else if (i != -506) {
                                StatHelper.reportErrCode(context, i, str, currentTimeMillis, "");
                                boolean unused2 = a.a = true;
                            }
                        }
                    }
                });
                if (Util.isNullOrEmptyString(a3)) {
                    gUIDInfo.errCode = -502;
                    return gUIDInfo;
                }
                try {
                    String str6 = "cf5f04cd36" + accessId + accessKey;
                    TBaseLogger.ii("GuidInfoManagerImpl", "Get response from GuidServer: " + a3);
                    JSONObject jSONObject2 = new JSONObject(a3);
                    String optString = jSONObject2.optString("data", "");
                    if (!Util.isNullOrEmptyString(optString)) {
                        str2 = new String(RC4.decrypt(Base64.decode(optString, 0), str6.getBytes("UTF-8")), "UTF-8");
                        try {
                            TBaseLogger.d("GuidInfoManagerImpl", "decode response:" + str2);
                            a3 = str2;
                        } catch (Throwable th2) {
                            th = th2;
                            str = "GUID server service code ";
                            a3 = str2;
                            Logger.e("GuidInfoManagerImpl", str, th);
                            gUIDInfo.errCode = -503;
                            gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                            return gUIDInfo;
                        }
                    }
                    try {
                        gUIDInfo.result = a3;
                        JSONObject jSONObject3 = new JSONObject(a3);
                        ?? optInt = jSONObject2.optInt("retCode", -1);
                        String optString2 = jSONObject2.optString("msg", "");
                        if (optInt == -1) {
                            Logger.e("GuidInfoManagerImpl", "GUID server error code " + ((int) optInt) + " error msg " + optString2);
                            gUIDInfo.errCode = -502;
                            return gUIDInfo;
                        } else if (optInt == 0 || optInt == 10030007) {
                            try {
                                CloudManager.getInstance(context).parseCloudConfig(jSONObject3.optString("cloud", null), currentTimeMillis);
                                String optString3 = jSONObject2.optString("token", null);
                                String optString4 = jSONObject3.optString("mqttServer", null);
                                String optString5 = jSONObject3.optString("userName", null);
                                if (Util.isNullOrEmptyString(optString5)) {
                                    optString5 = jSONObject3.optString("mqttKey", null);
                                }
                                String optString6 = jSONObject3.optString("passWord", null);
                                if (Util.isNullOrEmptyString(optString6)) {
                                    optString6 = jSONObject3.optString("mqttSecret", null);
                                }
                                if (optString3 == null || optString4 == null || optString5 == null || optString6 == null) {
                                    Logger.e("GuidInfoManagerImpl", "GUID_INFO_INCOMPLETE, result: " + a3);
                                    gUIDInfo.errCode = -502;
                                    return gUIDInfo;
                                }
                                try {
                                    long optInt2 = (long) jSONObject3.optInt("guid", 0);
                                    long optLong = jSONObject3.optLong("expiredSeconds", 0);
                                    int optInt3 = jSONObject3.optInt("encrypt", 0);
                                    gUIDInfo.token = optString3;
                                    JSONArray optJSONArray = jSONObject3.optJSONArray("invalidTokenList");
                                    if (optJSONArray != null) {
                                        try {
                                            Logger.i("GuidInfoManagerImpl", "Get invalidTokenList: " + optJSONArray);
                                            str5 = a(optJSONArray, str5);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            a3 = a3;
                                        }
                                    }
                                    String b2 = b(optString3, str5);
                                    JSONArray optJSONArray2 = jSONObject3.optJSONArray("mqttPortList");
                                    if (optJSONArray2 != null) {
                                        gUIDInfo.mqttPortList = optJSONArray2.toString();
                                    }
                                    gUIDInfo.tokenList = b2;
                                    gUIDInfo.mqttServer = optString4;
                                    gUIDInfo.passWord = optString6;
                                    gUIDInfo.userName = optString5;
                                    gUIDInfo.refreshTime = currentTimeMillis;
                                    gUIDInfo.guid = optInt2;
                                    gUIDInfo.expiredSeconds = optLong;
                                    gUIDInfo.guidLastAccessid = accessId;
                                    gUIDInfo.encrypt = optInt3;
                                    if (optInt == 10030007) {
                                        gUIDInfo.refuseRate = jSONObject3.optInt("refuseRate", 0);
                                        long optLong2 = jSONObject3.optLong("penaltySeconds", 0);
                                        if (optLong2 == 0) {
                                            context2 = context;
                                            PushPreferences.putLong(context2, "XG_GUID_SERVER_PENALTY_TIME", 0);
                                        } else {
                                            context2 = context;
                                            TBaseLogger.ww("GuidInfoManagerImpl", "GUID excee receive penaltySeconds: " + optLong2);
                                            PushPreferences.putLong(context2, "XG_GUID_SERVER_PENALTY_TIME", System.currentTimeMillis() + (optLong2 * 1000));
                                        }
                                    } else {
                                        context2 = context;
                                        gUIDInfo.refuseRate = 0;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("GUID -> write token: ");
                                    optInt = a3;
                                    sb.append((String) optInt);
                                    Logger.d("GuidInfoManagerImpl", sb.toString());
                                    gUIDInfo.saveGuidToSha(context2);
                                    b(context2, optString3, b2);
                                    return gUIDInfo;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str3 = optInt;
                                    a3 = str3;
                                    str = "GUID server service code ";
                                    Logger.e("GuidInfoManagerImpl", str, th);
                                    gUIDInfo.errCode = -503;
                                    gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                                    return gUIDInfo;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = a3;
                                str = "GUID server service code ";
                                a3 = str2;
                                Logger.e("GuidInfoManagerImpl", str, th);
                                gUIDInfo.errCode = -503;
                                gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                                return gUIDInfo;
                            }
                        } else if (optInt == 10030006) {
                            try {
                                long optLong3 = jSONObject3.optLong("penaltySeconds", 0);
                                if (optLong3 == 0) {
                                    PushPreferences.putLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0);
                                } else {
                                    TBaseLogger.ww("GuidInfoManagerImpl", "GUID destroy receive penaltySeconds: " + optLong3);
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    Long.signum(optLong3);
                                    PushPreferences.putLong(context, "XG_GUID_SERVER_PENALTY_TIME", currentTimeMillis3 + (optLong3 * 1000));
                                }
                                TBaseLogger.ww("GuidInfoManagerImpl", "GUID -> Server has been destroy");
                                gUIDInfo.errCode = optInt;
                                return gUIDInfo;
                            } catch (Throwable th6) {
                                th = th6;
                                str = "GUID server service code ";
                                a3 = a3;
                                Logger.e("GuidInfoManagerImpl", str, th);
                                gUIDInfo.errCode = -503;
                                gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                                return gUIDInfo;
                            }
                        } else {
                            TBaseLogger.ee("GuidInfoManagerImpl", "GUID server service code " + ((int) optInt) + " error msg " + optString2);
                            gUIDInfo.errCode = optInt;
                            return gUIDInfo;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        str = "GUID server service code ";
                        Logger.e("GuidInfoManagerImpl", str, th);
                        gUIDInfo.errCode = -503;
                        gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                        return gUIDInfo;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str = "GUID server service code ";
                    Logger.e("GuidInfoManagerImpl", str, th);
                    gUIDInfo.errCode = -503;
                    gUIDInfo.result = a3 + "\n " + Util.getThrowableToString(th);
                    return gUIDInfo;
                }
            } catch (Throwable th9) {
                TBaseLogger.ee("GuidInfoManagerImpl", "Send request to GuidServer: ", th9);
                gUIDInfo.errCode = -101;
                return gUIDInfo;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ all -> 0x006d }, LOOP:0: B:8:0x001b->B:10:0x0021, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[Catch:{ all -> 0x006d }, LOOP:1: B:15:0x0037->B:17:0x003f, LOOP_END] */
    private static String b(String str, String str2) {
        JSONArray jSONArray;
        ArrayList arrayList;
        int i;
        if (str2 != null) {
            try {
                if (!str2.isEmpty()) {
                    jSONArray = new JSONArray(str2);
                    arrayList = new ArrayList();
                    for (i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    if (arrayList.contains(str)) {
                        arrayList.remove(str);
                    }
                    arrayList.add(0, str);
                    while (arrayList.size() > 10) {
                        arrayList.remove(arrayList.size() - 1);
                    }
                    JSONArray jSONArray2 = new JSONArray((Collection) arrayList);
                    Logger.i("GuidInfoManagerImpl", "Update tokenList: " + jSONArray2.toString());
                    return jSONArray2.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        jSONArray = new JSONArray();
        arrayList = new ArrayList();
        while (i < jSONArray.length()) {
        }
        if (arrayList.contains(str)) {
        }
        arrayList.add(0, str);
        while (arrayList.size() > 10) {
        }
        JSONArray jSONArray2 = new JSONArray((Collection) arrayList);
        Logger.i("GuidInfoManagerImpl", "Update tokenList: " + jSONArray2.toString());
        return jSONArray2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ all -> 0x005f }, LOOP:0: B:8:0x001b->B:10:0x0021, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[Catch:{ all -> 0x005f }, LOOP:1: B:11:0x002b->B:13:0x0031, LOOP_END] */
    private static String a(JSONArray jSONArray, String str) {
        JSONArray jSONArray2;
        int i;
        int i2;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    jSONArray2 = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList.add(jSONArray2.getString(i2));
                    }
                    for (i = 0; i < jSONArray.length(); i++) {
                        arrayList.remove(jSONArray.getString(i));
                    }
                    JSONArray jSONArray3 = new JSONArray((Collection) arrayList);
                    Logger.i("GuidInfoManagerImpl", "Update tokenList: " + jSONArray3.toString());
                    return jSONArray3.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        jSONArray2 = new JSONArray();
        ArrayList arrayList = new ArrayList();
        while (i2 < jSONArray2.length()) {
        }
        while (i < jSONArray.length()) {
        }
        JSONArray jSONArray3 = new JSONArray((Collection) arrayList);
        Logger.i("GuidInfoManagerImpl", "Update tokenList: " + jSONArray3.toString());
        return jSONArray3.toString();
    }

    private static Pair<String, String> s(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tpush.vip.service.shareprefs", 0);
        String string = sharedPreferences.getString(a("XG_GUID_TOKEN"), null);
        String string2 = sharedPreferences.getString(a("XG_GUID_TOKEN_LIST"), null);
        if (string == null) {
            string = a(context);
        }
        if (string2 == null) {
            string2 = b(context);
        }
        return new Pair<>(string, string2);
    }

    private static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tpush.vip.service.shareprefs", 0).edit();
        edit.putString(a("XG_GUID_TOKEN"), str);
        edit.putString(a("XG_GUID_TOKEN_LIST"), str2);
        edit.commit();
    }

    public static String a(Context context) {
        try {
            return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN", null);
        } catch (Throwable th) {
            Logger.e("GuidInfoManagerImpl", "getToken Throwable: ", th);
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN_LIST", null);
        } catch (Throwable th) {
            Logger.e("GuidInfoManagerImpl", "getGuid Throwable: ", th);
            return "";
        }
    }

    public static long c(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_GUID", 0);
    }

    public static String d(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER", null);
    }

    private static String c(Context context, String str) {
        int i;
        String str2 = "";
        Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | XGConfig guidServerHostAddr : " + str);
        if (context == null) {
            return str;
        }
        UnknownHostException th = null;
        try {
            InetAddress byName = InetAddress.getByName(new URL(str).getHost());
            String hostAddress = byName != null ? byName.getHostAddress() : str2;
            Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | update lastResolvedGuidServerIP , guidServerIPAddr : " + str2 + "; guidServerIp : " + hostAddress);
            if (!TextUtils.isEmpty(hostAddress)) {
                GuidInfoManager.setLastResolvedGuidServerIP(context, hostAddress);
            }
            str2 = a(str, hostAddress);
            i = 0;
        } catch (UnknownHostException e2) {
            th = e2;
            i = -506;
        } catch (Throwable th2) {
            th = th2;
            i = -505;
        }
        if (th != null) {
            str2 = d(context, str);
            TBaseLogger.ee("GuidInfoManagerImpl", "getGuidServerAddress | exception " + th.toString(), th);
            if (!b) {
                if (NetworkUtil.isNetworkConnected(context)) {
                    StatHelper.reportErrCode(context, i, "GUID DNS Throw Error: " + th.getMessage(), 0, "");
                    b = true;
                } else {
                    Logger.w("GuidInfoManagerImpl", "getGuidServerAddress Throw Error: network unavailable");
                }
            }
        }
        Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | result guidServerIPAddress : " + str2);
        return str2;
    }

    private static String d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String lastResolvedGuidServerIP = GuidInfoManager.getLastResolvedGuidServerIP(context);
        if (TextUtils.isEmpty(lastResolvedGuidServerIP)) {
            return str;
        }
        String a2 = a(str, lastResolvedGuidServerIP);
        Logger.d("GuidInfoManagerImpl", "replaceGuidHostWithLastResolvedIP | lastResolvedIp : " + lastResolvedGuidServerIP + "; guidServerAddr : " + str + "; ipAddr : " + a2);
        return a2;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = "";
        try {
            Matcher matcher = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+(:\\d*)?").matcher(str);
            if (matcher.find()) {
                str3 = matcher.group();
            }
            String replace = str.replace(str3, str2);
            Logger.d("GuidInfoManagerImpl", "replaceHostWithIp | host : " + str3 + "; ipAddr : " + replace);
            return replace;
        } catch (Throwable th) {
            TBaseLogger.ee("GuidInfoManagerImpl", "replaceHostWithIp exception ", th);
            return str;
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (a.class) {
            if (!Util.isNullOrEmptyString(str)) {
                Logger.i("GuidInfoManagerImpl", "setLastResolvedGuidServerIP | lastGuidServerIp : " + c + "; newGuidServerIp : " + str);
                if (!str.equalsIgnoreCase(c)) {
                    c = str;
                    PushPreferences.putString(context.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", str);
                }
            }
        }
    }

    public static synchronized String e(Context context) {
        String str;
        synchronized (a.class) {
            if (c == null) {
                c = PushPreferences.getString(context.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", "");
                Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp is null, get from Shar");
            }
            Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp : " + c);
            str = c;
        }
        return str;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            if (!Util.isNullOrEmptyString(str)) {
                Logger.i("GuidInfoManagerImpl", "Save mqttServerIP: " + str);
                if (!str.equals(d)) {
                    d = str;
                    PushPreferences.putString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", str);
                }
            }
        }
    }

    public static synchronized String f(Context context) {
        String str;
        synchronized (a.class) {
            if (d == null) {
                Logger.i("GuidInfoManagerImpl", "MqttServerAddr null, get from Shar");
                d = PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", "");
            }
            Logger.i("GuidInfoManagerImpl", "Get mqttServerIP: " + d);
            str = d;
        }
        return str;
    }

    public static String g(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_USERNAME", null);
    }

    public static String h(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_PASSWORD", null);
    }

    public static long i(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_EXPIRED_SECONDS", 43200);
    }

    public static long j(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_LAST_REFRESH_TIME", 0);
    }

    public static boolean k(Context context) {
        long j = j(context.getApplicationContext());
        if (!f) {
            f = true;
            if (XGApiConfig.getAccessId(context) != PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0)) {
                Logger.d("GuidInfoManagerImpl", "New AccessId need to refresh token");
                o(context);
                return true;
            }
        }
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        Logger.i("GuidInfoManagerImpl", "GuidInfo gapSeconds = " + currentTimeMillis + ", compare to " + i(context.getApplicationContext()));
        if (currentTimeMillis > i(context.getApplicationContext())) {
            return true;
        }
        return false;
    }

    public static long l(Context context) {
        if (g == 0) {
            Logger.i("GuidInfoManagerImpl", "MqttServerLastRefreshTime null, get from Shar");
            g = PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0);
        }
        Logger.i("GuidInfoManagerImpl", "Get mqttServerLastRefreshTime: " + g);
        return g;
    }

    public static void a(Context context, long j) {
        Logger.i("GuidInfoManagerImpl", "Last time: " + g + ", this time: " + j);
        if (g != j) {
            Logger.i("GuidInfoManagerImpl", "Save mqttServerLastRefreshTime: " + j);
            g = j;
            PushPreferences.putLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", j);
        }
    }

    public static boolean m(Context context) {
        Logger.d("GuidInfoManagerImpl", "Check MqttServer expired?");
        long currentTimeMillis = (System.currentTimeMillis() - l(context)) / 1000;
        Logger.i("GuidInfoManagerImpl", "MqttServerAddr gapSeconds = " + currentTimeMillis + ", 1800");
        return currentTimeMillis > 1800;
    }

    public static void n(Context context) {
        TBaseLogger.ii("GuidInfoManagerImpl", "Force expired guidInfo, let its refreshTime 0");
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
    }

    public static void a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        PushPreferences.putString(context, "XG_GUID_TOKEN", str2);
        PushPreferences.putString(context, "XG_GUID_MQTT_SERVER", str);
        PushPreferences.putString(context, "XG_GUID_MQTT_USERNAME", "c34c9f3c514aa3560c38f74407f1a5bb");
        PushPreferences.putString(context, "XG_GUID_MQTT_PASSWORD", "9d8afb2ae393e47e7f3bbd254ed8c72e");
        PushPreferences.putLong(context, "XG_GUID_EXPIRED_SECONDS", 172800);
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", currentTimeMillis);
    }

    public static void o(Context context) {
        b(context, "", "");
        PushPreferences.putString(context, "XG_GUID_TOKEN", "");
        PushPreferences.putString(context, "XG_GUID_TOKEN_LIST", null);
        PushPreferences.putString(context, "XG_GUID_MQTT_SERVER", "");
        PushPreferences.putString(context, "XG_GUID_MQTT_USERNAME", "");
        PushPreferences.putString(context, "XG_GUID_MQTT_PASSWORD", "");
        PushPreferences.putLong(context, "XG_GUID_EXPIRED_SECONDS", 172800);
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
        CloudManager.getInstance(context).reset();
    }

    private static boolean t(Context context) {
        long j = PushPreferences.getLong(context, "XG_GUID_LAST_APP_VERSION_CODE", 0);
        long curVersionCode = Util.getCurVersionCode(context);
        if (j == curVersionCode) {
            return false;
        }
        PushPreferences.putLong(context, "XG_GUID_LAST_APP_VERSION_CODE", curVersionCode);
        if (curVersionCode <= j) {
            return false;
        }
        Logger.i("GuidInfoManagerImpl", "App is Update");
        return true;
    }

    public static boolean p(Context context) {
        if (!h) {
            h = true;
            if (t(context)) {
                PushPreferences.putLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0);
                return false;
            }
        }
        if (PushPreferences.getLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0) > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static int q(Context context) {
        return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ABANDON_RATE", 0);
    }

    public static int r(Context context) {
        return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
    }

    private static String a(String str) {
        return Util.getKey(str);
    }
}
