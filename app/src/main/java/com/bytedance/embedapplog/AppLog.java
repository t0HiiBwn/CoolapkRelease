package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class AppLog {
    public static final String UMENG_CATEGORY = "umeng";
    private static volatile z a = null;
    private static boolean b = true;
    private static boolean c;
    private static bi d = new bi();
    private static volatile IExtraParams e;
    public static ConcurrentHashMap<String, String> sCustomNetParams = new ConcurrentHashMap<>(4);
    public static aa sDevice;
    public static IAppParam sIAppParam;

    private static <T> T a(Object obj, T t) {
        if (obj == null) {
            obj = (T) null;
        }
        return obj == null ? t : (T) obj;
    }

    public static boolean getEncryptAndCompress() {
        return true;
    }

    public static void setEncryptAndCompress(boolean z) {
    }

    private AppLog() {
        bo.a(null);
    }

    public static void init(Context context, InitConfig initConfig) {
        if (!bo.b && Looper.myLooper() != Looper.getMainLooper()) {
            bo.a(new RuntimeException("Wrong thread!"));
        } else if (a != null) {
            bo.a(new RuntimeException("Init Twice!"));
            return;
        } else if (initConfig.getSensitiveInfoProvider() == null) {
            bo.a(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        k b2 = k.b();
        z zVar = new z(application, initConfig);
        aa aaVar = new aa(application, zVar);
        b2.a(application, zVar, aaVar, new f(initConfig.getPicker()));
        a = zVar;
        sDevice = aaVar;
        bo.d("Inited", null);
    }

    public static void flush() {
        k.a();
    }

    public static void setUserUniqueID(String str) {
        aa aaVar = sDevice;
        if (aaVar != null) {
            aaVar.c(str);
        }
    }

    public static ConcurrentHashMap<String, String> getCustomNetParams() {
        return sCustomNetParams;
    }

    public static void setCustomNetParams(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            sCustomNetParams.remove(str);
        } else {
            sCustomNetParams.put(str, str2);
        }
    }

    public static IExtraParams getExtraParams() {
        return e;
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        if (e == null && iExtraParams != null) {
            e = iExtraParams;
        }
    }

    public static IAppParam getIAppParam() {
        return sIAppParam;
    }

    public static void setIAppParam(IAppParam iAppParam) {
        sIAppParam = iAppParam;
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        aa aaVar = sDevice;
        if (aaVar != null) {
            aaVar.a(hashMap);
        }
    }

    public static void setAbSDKVersion(String str) {
        aa aaVar = sDevice;
        if (aaVar != null) {
            aaVar.a(str);
        }
    }

    public static String getAbSDKVersion() {
        aa aaVar = sDevice;
        if (aaVar != null) {
            return aaVar.q();
        }
        return null;
    }

    public static <T> T getAbConfig(String str, T t) {
        if (a == null) {
            return null;
        }
        JSONObject c2 = a.c(str);
        if (c2 == null) {
            return t;
        }
        String optString = c2.optString("vid");
        Object opt = c2.opt("val");
        sDevice.f(optString);
        return (T) a(opt, t);
    }

    public static JSONObject getAbConfig() {
        if (a != null) {
            return a.u();
        }
        return null;
    }

    public static String getAbConfigVersion() {
        if (a != null) {
            return a.t();
        }
        return null;
    }

    public static String getAid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.h() : "";
    }

    public static <T> T getHeaderValue(String str, T t) {
        aa aaVar = sDevice;
        if (aaVar != null) {
            return (T) aaVar.a(str, t);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public static byte[] toEncryptByte(String str) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            if (getEncryptAndCompress()) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes("UTF-8"));
                    gZIPOutputStream = gZIPOutputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        bo.a(th);
                        if (gZIPOutputStream != null) {
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (getEncryptAndCompress()) {
                        }
                    } catch (Throwable th3) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                bo.a(e2);
                            }
                        }
                        throw th3;
                    }
                }
            } else {
                byteArrayOutputStream.write(str.getBytes("UTF-8"));
            }
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException e3) {
                    bo.a(e3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bo.a(th);
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (getEncryptAndCompress()) {
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return getEncryptAndCompress() ? TTEncryptUtils.a(byteArray, byteArray.length) : byteArray;
    }

    public void setUserAgent(String str) {
        aa aaVar = sDevice;
        if (aaVar != null) {
            aaVar.b(str);
        }
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        String str4 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (bo.b) {
                bo.a("category or label is empty", null);
            }
            k.a(new az("" + str2 + str3, "2", 1));
            return;
        }
        if (jSONObject != null) {
            str4 = jSONObject.toString();
        }
        k.a(new at(str, str2, str3, j, j2, str4));
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        onEvent(str, str2, str3, j, j2, null);
    }

    public static void onEvent(String str, String str2) {
        onEvent("umeng", str, str2, 0, 0, null);
    }

    public static void onEvent(String str) {
        onEvent("umeng", str, null, 0, 0, null);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            bo.a("eventName is empty", null);
            k.a(new az("", "2", 1));
        }
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        }
        k.a(new av(str, false, str2));
    }

    public static void onEventV3(String str, Bundle bundle) {
        Throwable th;
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th2) {
                        th = th2;
                        jSONObject = jSONObject2;
                        bo.a(th);
                        onEventV3(str, jSONObject);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bo.a(th);
                onEventV3(str, jSONObject);
            }
        }
        onEventV3(str, jSONObject);
    }

    public static void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            String str5 = "second_app_" + str;
            try {
                jSONObject.put("params_for_special", "second_app");
                jSONObject.put("second_appid", str2);
                jSONObject.put("second_appname", str3);
                jSONObject.put("product_type", str4);
            } catch (Throwable th) {
                bo.a(th);
            }
            k.a(new av(str5, false, jSONObject.toString()));
            return;
        }
        bo.b("both second appid and second app name is empty, return", null);
    }

    public static void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        Throwable th;
        JSONObject jSONObject = null;
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            String str5 = "second_app_" + str;
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            for (String str6 : bundle.keySet()) {
                                jSONObject2.put(str6, bundle.get(str6));
                            }
                            jSONObject2.put("params_for_special", "second_app");
                            jSONObject2.put("second_appid", str2);
                            jSONObject2.put("second_appname", str3);
                            jSONObject2.put("product_type", str4);
                            jSONObject = jSONObject2;
                        } catch (Throwable th2) {
                            th = th2;
                            jSONObject = jSONObject2;
                            bo.a(th);
                            onEventV3(str5, jSONObject);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bo.a(th);
                    onEventV3(str5, jSONObject);
                    return;
                }
            }
            onEventV3(str5, jSONObject);
            return;
        }
        bo.b("both second appid and second app name is empty, return", null);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            bo.b("call onEventData with invalid params, return", null);
            return;
        }
        try {
            k.a(new au(str, jSONObject));
        } catch (Exception e2) {
            bo.c("call onEventData get exception: ", e2);
        }
    }

    public static void setEnableLog(boolean z) {
        bo.b = z;
    }

    public static void setAutoActiveState(boolean z) {
        b = z;
    }

    public static boolean getAutoActiveState() {
        return b;
    }

    public static boolean manualActivate() {
        if (sDevice != null) {
            return k.b().e();
        }
        return false;
    }

    public static String getDid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.g() : "";
    }

    public static String getUdid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.i() : "";
    }

    public static String getIid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.j() : "";
    }

    public static String getSsid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.k() : "";
    }

    public static String getUserUniqueID() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.l() : "";
    }

    public static String getClientUdid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.m() : "";
    }

    public static String getOpenUdid() {
        aa aaVar = sDevice;
        return aaVar != null ? aaVar.n() : "";
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        d.a(iDataObserver);
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        d.b(iDataObserver);
    }

    public static IDataObserver getDataObserver() {
        return d;
    }

    public static int getSuccRate() {
        if (a != null) {
            return a.i();
        }
        return 0;
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        bw.a(iOaidObserver);
    }

    public static InitConfig getInitConfig() {
        if (a != null) {
            return a.P();
        }
        return null;
    }
}
