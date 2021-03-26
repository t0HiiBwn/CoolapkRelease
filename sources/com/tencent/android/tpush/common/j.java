package com.tencent.android.tpush.common;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.XGPushReceiver;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.security.a;
import com.tencent.android.tpush.service.d;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.android.tpush.stat.e;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttTools;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.x500.X500Principal;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class j {
    public static String a = null;
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static boolean c = false;
    private static final X500Principal d = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static String e = "";
    private static String f = "";

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 32;
    }

    public static int a(Context context) {
        if (b.get()) {
            return 0;
        }
        try {
            TBaseLogger.init(context);
            if (XGPushManager.getContext() == null) {
                XGPushManager.setContext(context);
            }
            if (b.e() == null) {
                b.b(context);
            }
            XGPushProvider.fetchProviderAuthorities(context);
            if (!h(context)) {
                TLogger.ee("Util", "XG is disable");
                return ReturnCode.CODE_SERVICE_DISABLED.getType();
            } else if (!Security.checkTpnsSecurityLibSo(context)) {
                TLogger.ee("Util", "can not load library from so file");
                ServiceStat.reportErrCode(context, ReturnCode.CODE_SO_ERROR.getType(), "can not load library from so file", 0, "inner");
                return ReturnCode.CODE_SO_ERROR.getType();
            } else {
                b.f(context);
                e.d(context);
                g(context);
                q(context);
                b.set(true);
                return 0;
            }
        } catch (Throwable th) {
            TLogger.e("Util", "Util -> initGlobal", th);
            return -1;
        }
    }

    private static void q(final Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.common.j.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:43:0x021e A[SYNTHETIC, Splitter:B:43:0x021e] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x0229  */
                /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                public void run() {
                    HttpURLConnection httpURLConnection;
                    DataOutputStream dataOutputStream;
                    Throwable th;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sdkStatus", 1);
                        jSONObject.put("sdkType", "android");
                        jSONObject.put("sdkVersion", "1.2.3.1");
                        URL url = new URL("https://log.tpns.tencent.com/device/sdk/list");
                        if (url.getProtocol().toLowerCase().equals("https")) {
                            httpURLConnection = (HttpsURLConnection) url.openConnection();
                            try {
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream = null;
                            }
                        } else {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                        }
                        httpURLConnection.setReadTimeout(15000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Content-Type", "json");
                        httpURLConnection.setConnectTimeout(15000);
                        long accessId = XGApiConfig.getAccessId(context);
                        String accessKey = XGApiConfig.getAccessKey(context);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Basic ");
                        sb.append(Base64.encodeToString((accessId + ":" + accessKey).getBytes("UTF-8"), 0));
                        httpURLConnection.addRequestProperty("Authorization", sb.toString());
                        byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                        DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream2.write(bytes);
                            dataOutputStream2.flush();
                            int responseCode = httpURLConnection.getResponseCode();
                            String responseMessage = httpURLConnection.getResponseMessage();
                            Logger.d("Util", "http recv response status code:" + responseCode + ", responseMsg:" + responseMessage + ",contentLength:" + httpURLConnection.getContentLength());
                            if (responseCode == 200) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                                String str = "";
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    str = str + readLine;
                                }
                                Logger.d("Util", "http get response data:" + str);
                                bufferedReader.close();
                                JSONObject jSONObject2 = new JSONObject(str);
                                if (jSONObject2.optInt("retCode", -1) != 0) {
                                    Logger.e("Util", "checkVersionUpdate" + jSONObject2.getString("errMsg"));
                                } else {
                                    JSONArray jSONArray = jSONObject2.getJSONArray("sdkInfos");
                                    if (jSONArray != null) {
                                        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                                        String optString = jSONObject3.optString("version", "");
                                        String optString2 = jSONObject3.optString("date", "");
                                        String optString3 = jSONObject3.optString("enDesc", "");
                                        String optString4 = jSONObject3.optString("domainUrl", "");
                                        Logger.d("Util", "the current server TPNS sdk version is " + optString);
                                        if (j.b("1.2.3.1", optString)) {
                                            TLogger.ee("Util", "The latest release of TPNS SDK is now available, you can download it or update by Gradle. The details are as follows:\r\nnewSdkVersion = " + optString + "\r\ncurrentSDKVersion = 1.2.3.1\r\nreleaseDate = " + optString2 + "\r\nreleaseNote = " + optString3 + "\r\nreleaseSDKUrl = " + optString4 + "\r\n");
                                        }
                                    }
                                }
                            } else {
                                Logger.e("Util", "Server response error code:" + responseCode + ", error:" + responseMessage);
                            }
                            try {
                                dataOutputStream2.close();
                            } catch (Throwable th3) {
                                Logger.e("Util", "outStream.close()", th3);
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (Throwable th4) {
                                    Logger.e("Util", "conn.disconnect()", th4);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            dataOutputStream = dataOutputStream2;
                            try {
                                Logger.e("Util", "checkVersionUpdate", th);
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Throwable th6) {
                                        Logger.e("Util", "outStream.close()", th6);
                                    }
                                }
                                if (httpURLConnection == null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            } catch (Throwable th7) {
                                Logger.e("Util", "conn.disconnect()", th7);
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        dataOutputStream = null;
                        httpURLConnection = null;
                        Logger.e("Util", "checkVersionUpdate", th);
                        if (dataOutputStream != null) {
                        }
                        if (httpURLConnection == null) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                    throw th;
                }
            });
        } else {
            Logger.d("Util", "It is release");
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        try {
            return Float.valueOf(str2.replace(".", "")).floatValue() > Float.valueOf(str.replace(".", "")).floatValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            List<ResolveInfo> c2 = f.c(context, context.getPackageName() + ".XGVIP_PUSH_ACTION");
            if (c2 == null || c2.size() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            TLogger.e("Util", "Util -> isAIDLConfiged", th);
            return false;
        }
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int c(Context context) {
        TLogger.d("Util", "action getServiceStatus");
        if (context == null) {
            return 0;
        }
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null || runningServices.size() <= 0) {
                return 0;
            }
            String name = XGVipPushService.class.getName();
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                String className = runningServiceInfo.service.getClassName();
                String packageName = runningServiceInfo.service.getPackageName();
                if (name.equals(className) && packageName.equals(context.getPackageName())) {
                    return runningServiceInfo.pid != 0 ? 1 : 2;
                }
            }
            return 0;
        } catch (Throwable th) {
            TLogger.e("Util", "getServiceStatus", th);
            return 0;
        }
    }

    public static void d(Context context) {
        TLogger.d("Util", "startCurrentAppService " + context.getPackageName());
        context.startService(new Intent(context, XGVipPushService.class));
    }

    public static void e(final Context context) {
        if (context != null) {
            try {
                if (f.a(context.getPackageName())) {
                    d(context);
                    return;
                }
                b.b(context.getApplicationContext());
                b.a(context);
                TLogger.v("Util", "Action -> start Local Service()");
                CommonWorkingThread.getInstance().execute(new Runnable() {
                    /* class com.tencent.android.tpush.common.j.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.c(context) != 1) {
                            try {
                                TLogger.v("Util", "Action2 -> start Local Service()");
                                b.a(context);
                            } catch (Throwable th) {
                                TLogger.e("Util", "CommonWorkingThread StartService", th);
                            }
                        }
                    }
                }, 1500);
            } catch (Throwable th) {
                TLogger.e("Util", "StartService", th);
            }
        }
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            d.a(context, broadcastReceiver);
            return true;
        } catch (Throwable th) {
            TLogger.e("Util", "safeUnregisterReceiver error", th);
            return false;
        }
    }

    private static void d(Context context, String str) {
        if (context != null && str != null) {
            try {
                if (str.trim().length() != 0) {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        ComponentName componentName = new ComponentName(context.getPackageName(), str);
                        if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                            packageManager.setComponentEnabledSetting(componentName, 1, 1);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(Context context) {
        if (context != null && !c) {
            try {
                d(context, XGVipPushService.class.getName());
                d(context, TpnsActivity.class.getName());
                d(context, XGPushProvider.class.getName());
                d(context, SettingsContentProvider.class.getName());
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers) {
                    String str = activityInfo.name;
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass(str);
                        if (XGPushBaseReceiver.class.isAssignableFrom(loadClass) || loadClass.getName().equals(XGPushReceiver.class.getName())) {
                            d(context, str);
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
            } catch (Throwable th) {
                TLogger.e("Util", "enableComponents", th);
            }
            c = true;
        }
    }

    public static void g(final Context context) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.common.j.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        String b = j.b();
                        TLogger.i("filter components", "deviceType: " + b);
                        if (!ChannelUtils.isBrandXiaoMi() && !"blackshark".equals(b) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-xiaomi", true)).booleanValue()) {
                            j.b(packageManager, context, "com.xiaomi.push.service.XMPushService");
                            j.b(packageManager, context, "com.xiaomi.push.service.XMJobService");
                            j.b(packageManager, context, "com.xiaomi.mipush.sdk.PushMessageHandler");
                            j.b(packageManager, context, "com.xiaomi.mipush.sdk.MessageHandleService");
                            j.b(packageManager, context, "com.xiaomi.push.service.receivers.NetworkStatusReceiver");
                            j.b(packageManager, context, "com.xiaomi.push.service.receivers.PingReceiver");
                            j.b(packageManager, context, "com.tencent.android.mipush.XMPushMessageReceiver");
                        }
                        if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor()) {
                            TLogger.i("filter components", "desiable device huawei");
                            if (((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-huawei-v4", true)).booleanValue()) {
                                j.b(packageManager, context, "com.huawei.agconnect.core.provider.AGConnectInitializeProvider");
                                j.b(packageManager, context, "com.huawei.agconnect.core.ServiceDiscovery");
                                j.b(packageManager, context, "com.tencent.android.hwpushv3.HWHmsMessageService");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushMsgReceiver");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushReceiver");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushProvider");
                            }
                        }
                        if (!ChannelUtils.isBrandMeiZu() && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-meizu", true)).booleanValue()) {
                            j.b(packageManager, context, "com.tencent.android.mzpush.MZPushMessageReceiver");
                            j.b(packageManager, context, "com.meizu.cloud.pushsdk.SystemReceiver");
                            j.b(packageManager, context, "com.meizu.cloud.pushsdk.NotificationService");
                        }
                        if (!"oppo".equals(b) && !"oneplus".equals(b) && !"realme".equals(b) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-oppo", true)).booleanValue()) {
                            j.b(packageManager, context, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService");
                            j.b(packageManager, context, "com.heytap.msp.push.service.DataMessageCallbackService");
                        }
                        if (!"vivo".equals(b) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-vivo", true)).booleanValue()) {
                            j.b(packageManager, context, "com.vivo.push.sdk.service.CommandClientService");
                            j.b(packageManager, context, "com.vivo.push.sdk.LinkProxyClientActivity");
                            j.b(packageManager, context, "com.tencent.android.vivopush.VivoPushMessageReceiver");
                        }
                    }
                } catch (Throwable th) {
                    TLogger.w("Util", "unexpected for disableComponents", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(PackageManager packageManager, Context context, String str) {
        if (context != null && str != null) {
            try {
                if (str.trim().length() != 0) {
                    if (packageManager != null) {
                        ComponentName componentName = new ComponentName(context.getPackageName(), str);
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(j));
        } catch (Throwable th) {
            TLogger.e("Util", "getDateString", th);
            return "20141111";
        }
    }

    public static boolean h(Context context) {
        return XGApiConfig.isEnableService(context);
    }

    public static void a() {
        try {
            PowerManager.WakeLock b2 = d.a().b();
            if (b2 != null) {
                if (b2.isHeld()) {
                    try {
                        b2.release();
                    } catch (Throwable th) {
                        TLogger.e("Util", "Wakelock exception", th);
                    }
                }
                TLogger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th2) {
            TLogger.e("Util", "stopWakeLock", th2);
        }
    }

    public static void i(Context context) {
        try {
            if ("oppo".equals(b())) {
                Intent intent = new Intent("oppo.safecenter.intent.action.CHANGE_NOTIFICATION_STATE");
                intent.putExtra("package_name", context.getPackageName());
                intent.putExtra("allow_notify", true);
                d.a(context, intent);
            }
        } catch (Throwable th) {
            TLogger.d("openNotification", "openNotification", th);
        }
    }

    public static void j(Context context) {
        String b2 = b();
        if (!"meizu".equals(b2) && "oppo".equals(b2)) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity");
                intent.setAction("com.coloros.notificationmanager.app.detail");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                intent.putExtra("pkg_name", context.getPackageName());
                intent.putExtra("app_name", b.c(context));
                intent.putExtra("class_name", context.getPackageName());
                context.startActivity(intent);
            } catch (Throwable th) {
                TLogger.d("Util", "openNotificationSettings", th);
            }
        }
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public static void k(Context context) {
        String a2 = a(context, "otherpush_config.json");
        if (!b(a2)) {
            try {
                JSONObject jSONObject = new JSONObject(a2);
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("xiaomi");
                    if (optJSONObject != null) {
                        com.tencent.android.tpush.d.d.a = optJSONObject.optString("appid", null);
                        com.tencent.android.tpush.d.d.b = optJSONObject.optString("appkey", null);
                    }
                } catch (Throwable unused) {
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("meizu");
                    if (optJSONObject2 != null) {
                        com.tencent.android.tpush.d.d.c = optJSONObject2.optString("appid", null);
                        com.tencent.android.tpush.d.d.d = optJSONObject2.optString("appkey", null);
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                TLogger.e("Util", "", th);
            }
        }
    }

    public static void a(Context context, int i) {
        if (2 == i) {
            try {
                com.tencent.android.tpush.d.d.c = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_id", "")).substring(4);
                com.tencent.android.tpush.d.d.d = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_key", "")).substring(4);
                TLogger.d("Util", "mz:" + com.tencent.android.tpush.d.d.c + ", " + com.tencent.android.tpush.d.d.d);
            } catch (Throwable unused) {
                TLogger.w("Util", "unexpected for init mz");
            }
        } else if (1 == i) {
            try {
                com.tencent.android.tpush.d.d.a = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_id", "")).substring(4);
                com.tencent.android.tpush.d.d.b = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_key", "")).substring(4);
                TLogger.d("Util", "mi:" + com.tencent.android.tpush.d.d.a + ", " + com.tencent.android.tpush.d.d.b);
            } catch (Throwable unused2) {
                TLogger.w("Util", "unexpected for init xm");
            }
        } else if (6 == i) {
            try {
                com.tencent.android.tpush.d.d.e = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_id", "")).substring(4);
                com.tencent.android.tpush.d.d.f = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_key", "")).substring(4);
                TLogger.d("Util", "oppo:" + com.tencent.android.tpush.d.d.e + ", " + com.tencent.android.tpush.d.d.f);
            } catch (Throwable unused3) {
                TLogger.w("Util", "unexpected for init oppo");
            }
        }
    }

    public static String l(Context context) {
        try {
            if (b(e)) {
                e = String.valueOf(CommonHelper.getMetaData(context, "com.huawei.hms.client.appid", ""));
            }
            if (TextUtils.isEmpty(e)) {
                e = com.tencent.android.tpush.d.d.h;
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getHwConfig");
        }
        return e;
    }

    public static String m(Context context) {
        try {
            if (b(f)) {
                f = String.valueOf(CommonHelper.getMetaData(context, "com.vivo.push.app_id", ""));
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getVivoConfig");
        }
        return f;
    }

    public static boolean n(Context context) {
        try {
            return ((Boolean) CommonHelper.getMetaData(context, "ENABLE_OTHER_PUSH", false)).booleanValue();
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for init isUsedOtherPush4Plugin");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0050 A[SYNTHETIC, Splitter:B:34:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0057 A[SYNTHETIC, Splitter:B:38:0x0057] */
    public static String a(Context context, String str) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        if (!b(a)) {
            return a;
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (open == null) {
                return null;
            }
            inputStreamReader = new InputStreamReader(open, "UTF-8");
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    a = stringBuffer2;
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused2) {
                    }
                    return stringBuffer2;
                } catch (Throwable unused3) {
                    try {
                        TLogger.d("Util", "assets is null");
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        return null;
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
                TLogger.d("Util", "assets is null");
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused7) {
                    }
                }
                return null;
            }
        } catch (Throwable unused8) {
            bufferedReader = null;
            inputStreamReader = null;
            TLogger.d("Util", "assets is null");
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            return null;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        throw th;
        throw th;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static long d(String str) {
        if (str == null || str.equals("0") || str.equals("")) {
            return 0;
        }
        String trim = str.trim();
        long[] jArr = new long[4];
        int indexOf = trim.indexOf(".");
        int i = indexOf + 1;
        int indexOf2 = trim.indexOf(".", i);
        int i2 = indexOf2 + 1;
        int indexOf3 = trim.indexOf(".", i2);
        try {
            jArr[3] = Long.parseLong(trim.substring(0, indexOf));
            jArr[2] = Long.parseLong(trim.substring(i, indexOf2));
            jArr[1] = Long.parseLong(trim.substring(i2, indexOf3));
            jArr[0] = Long.parseLong(trim.substring(indexOf3 + 1));
        } catch (Throwable th) {
            for (int i3 = 0; i3 < 4; i3++) {
                jArr[i3] = 0;
            }
            TLogger.e("Util", "service Util@@parseIpAddress(" + trim + ")", th);
        }
        return (jArr[0] << 24) + (jArr[1] << 16) + (jArr[2] << 8) + jArr[3];
    }

    public static byte o(Context context) {
        byte type = MobileType.UNKNOWN.getType();
        if (context == null) {
            return type;
        }
        try {
            String simOperator = CustomDeviceInfos.getSimOperator(context);
            if (simOperator == null) {
                return type;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (!simOperator.equals("46020")) {
                    if (!simOperator.equals("46001")) {
                        if (!simOperator.equals("46006")) {
                            if (simOperator.equals("46003") || simOperator.equals("46005")) {
                                return MobileType.TELCOM.getType();
                            }
                            return type;
                        }
                    }
                    return MobileType.UNICOM.getType();
                }
            }
            return MobileType.CHINAMOBILE.getType();
        } catch (Throwable th) {
            TLogger.e("Util", "getIsp", th);
            return type;
        }
    }

    public static boolean b(Context context, String str) {
        return MqttTools.isPushMsgTopic(context, str) || MqttTools.isAesPushMsgTopic(context, str) || MqttTools.isGZipPushMsgTopic(context, str) || MqttTools.isGZipAesPushMsgTopic(context, str);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(RC4.decrypt(a.a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            TLogger.e("Util", "decode error", th);
            return str;
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(a.b(RC4.encrypt(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            TLogger.e("Util", "encode error", th);
            return str;
        }
    }

    public static String p(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    return resolveInfo.activityInfo.name;
                }
            }
            return "";
        } catch (Throwable th) {
            TLogger.e("Util", "get launcher class name error: " + th.toString());
            return "";
        }
    }

    public static boolean c(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            TLogger.e("Util", "unexpected for isFirstInstall: " + th.getMessage());
            return false;
        }
    }
}
