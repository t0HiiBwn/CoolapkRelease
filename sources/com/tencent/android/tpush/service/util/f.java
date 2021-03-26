package com.tencent.android.tpush.service.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.android.tpush.TypeStr;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.a.a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class f {
    static List<String> a = new ArrayList();
    private static long b = 0;
    private static long c = 0;
    private static int d = -1;

    public static List<ResolveInfo> a(Context context) {
        TLogger.d("ServiceUtil", "action - getLocalPushAppsInfo");
        if (context == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action"), 32);
            queryIntentActivities.addAll(packageManager.queryIntentActivities(new Intent(""), 32));
            queryIntentActivities.addAll(packageManager.queryBroadcastReceivers(new Intent("com.tencent.android.xg.vip.action.SDK"), 512));
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                hashMap.put(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo);
            }
            return new ArrayList(hashMap.values());
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "getLocalPushAppsInfo", th);
            return null;
        }
    }

    public static List<String> a() {
        if (a.isEmpty()) {
            a.add("com.jingdong.app.mall");
            a.add("com.ifeng.news2");
        }
        return a;
    }

    public static boolean a(String str) {
        return a().contains(str);
    }

    public static void b(Context context) {
        TLogger.d("ServiceUtil", "action - pullUpServerConfigPkgs");
        try {
            Map<String, String> map = a.a(context).K;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        if (!h(context, entry.getKey())) {
                            String str = "am startservice -n " + entry.getKey() + "/" + entry.getValue();
                            Process exec = Runtime.getRuntime().exec(str);
                            int waitFor = exec.waitFor();
                            if (waitFor != 0) {
                                str = "am startservice --user 0 -n " + entry.getKey() + "/" + entry.getValue();
                                TLogger.d("ServiceUtil", "start service:" + str);
                                exec = Runtime.getRuntime().exec(str);
                                waitFor = exec.waitFor();
                            }
                            if (waitFor != 0) {
                                TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + str + ",exitValud:" + exec.exitValue());
                            }
                        }
                    } catch (Throwable th) {
                        TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + th);
                    }
                }
                return;
            }
            TLogger.d("ServiceUtil", "pullUpServerConfigPkgs no pull up packages map");
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "", th2);
        }
    }

    /* access modifiers changed from: private */
    public static boolean g(Context context, String str) {
        if (str == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (!(runningAppProcessInfo == null || runningAppProcessInfo.processName == null || !runningAppProcessInfo.processName.startsWith(str))) {
                return true;
            }
        }
        return false;
    }

    public static void c(Context context) {
        try {
            if (CloudManager.getInstance(context).getAppClsAlive() == 1) {
                TLogger.d("ServiceUtil", "disable pull up group");
                return;
            }
            JSONArray pullupArrProviderAndActivity = CloudManager.getInstance(context).getPullupArrProviderAndActivity();
            if (pullupArrProviderAndActivity != null) {
                if (pullupArrProviderAndActivity.length() != 0) {
                    for (int i = 0; i < pullupArrProviderAndActivity.length(); i++) {
                        a(context, pullupArrProviderAndActivity.optJSONObject(i));
                    }
                    return;
                }
            }
            TLogger.i("ServiceUtil", "pullupOtherServiceByProviderAndActivity no running");
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "pullupOtherServiceByProviderAndActivity" + th);
        }
    }

    public static void a(final Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("name", "");
            if (!j.b(optString) && !h(context, optString) && !g(context, optString)) {
                TLogger.d("ServiceUtil", "action - pullUpOtherServiceByProviderAndActivityJSONOject, proName:" + optString);
                String optString2 = jSONObject.optString("intent", "");
                if (!j.b(optString2)) {
                    try {
                        Intent intent = new Intent(optString2);
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                    } catch (Throwable unused) {
                        TLogger.d("ServiceUtil", "unexpected for start activity for action:" + optString2);
                    }
                } else {
                    String optString3 = jSONObject.optString("schema", "");
                    if (!j.b(optString3)) {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(optString3));
                            intent2.setFlags(268435456);
                            context.startActivity(intent2);
                        } catch (Throwable unused2) {
                            TLogger.d("ServiceUtil", "unexpected for start activity for schema:" + optString3);
                        }
                    }
                }
                final String optString4 = jSONObject.optString("url", "");
                if (!j.b(optString4)) {
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.service.util.f.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!f.g(context, optString)) {
                                    ProviderMessage.getType(context, Uri.parse("content://" + optString4));
                                }
                            } catch (Throwable unused) {
                                TLogger.d("ServiceUtil", "unexpected for start provider for providerUrl:" + optString4);
                            }
                        }
                    }, 2000);
                }
            }
        }
    }

    public static void d(Context context) {
        if (com.tencent.android.tpush.f.a.a(context)) {
            TLogger.dd("ServiceUtil", "Run As SysPush, Not pullup other XGService");
        } else if (ChannelUtils.isMiuiV12()) {
            TLogger.dd("ServiceUtil", "Run As MIUI 12, Not pullup other XGService");
        } else if (CloudManager.getInstance(context).disablePullUp()) {
            TLogger.dd("ServiceUtil", " Not pullup other XGService with cloud");
        } else if (a(context.getPackageName())) {
            TLogger.dd("ServiceUtil", context.getPackageName() + " ingore pull up");
        } else {
            TLogger.d("ServiceUtil", "not in ignore app list");
            if (PushPreferences.getBoolean(context, "pull.up.other.app", true)) {
                TLogger.i("ServiceUtil", "default pull up other app");
                try {
                    f(context);
                } catch (Throwable th) {
                    TLogger.e("ServiceUtil", "pullUpXGServiceByProvider" + th);
                }
                c(context);
                b(context);
                return;
            }
            TLogger.ii("ServiceUtil", "disable pull up other app");
        }
    }

    /* access modifiers changed from: private */
    public static boolean h(Context context, String str) {
        if (j.b(str)) {
            return false;
        }
        String pullupBlackList = CloudManager.getInstance(context).getPullupBlackList();
        if (j.b(pullupBlackList)) {
            return false;
        }
        return pullupBlackList.contains(str);
    }

    private static void f(final Context context) {
        TLogger.d("ServiceUtil", "action - pullUpXGServiceByProvider on 2s later");
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.service.util.f.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                List<ResolveInfo> a2 = f.a(context);
                if (a2 != null) {
                    int i = 0;
                    for (ResolveInfo resolveInfo : a2) {
                        i++;
                        if ("oppo".equals(j.b())) {
                            if (i > 2) {
                                return;
                            }
                        } else if (i > 4) {
                            return;
                        }
                        String str = resolveInfo.activityInfo.applicationInfo.packageName;
                        if (!f.h(context, str) && !j.b(str) && !context.getPackageName().equals(str) && !f.b(context, str) && f.a(context, str)) {
                            try {
                                String str2 = "content://" + str + ".XGVIP_PUSH_AUTH/" + TypeStr.pullupxg.getStr();
                                Uri parse = Uri.parse(str2);
                                TLogger.d("ServiceUtil", "pull up by provider, pkgName: " + str + ", uri:" + str2);
                                ProviderMessage.getType(context, parse);
                                Thread.sleep(200);
                            } catch (Throwable th) {
                                TLogger.e("ServiceUtil", "pull up by provider error" + th);
                            }
                        }
                    }
                    return;
                }
                TLogger.ii("ServiceUtil", "pullupXGServices  with null content");
            }
        }, 2000);
    }

    public static boolean a(Context context, String str) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context.createPackageContext(str, 0), XGVipPushService.class), 0);
            if (queryIntentServices != null) {
                if (!queryIntentServices.isEmpty()) {
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (resolveInfo.serviceInfo.processName.contains("xg_vip_service")) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            TLogger.w("ServiceUtil", "unexpected for isXGServiceV4ProcssNameConfigByName:" + th.getMessage());
        }
    }

    public static boolean b(Context context, String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null || runningServices.size() <= 0) {
                return false;
            }
            String name = XGVipPushService.class.getName();
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.pid != 0 && name.equals(runningServiceInfo.service.getClassName())) {
                    String packageName = runningServiceInfo.service.getPackageName();
                    if (j.c(packageName) && packageName.equals(str)) {
                        TLogger.d("ServiceUtil", "isSurvive srvPkg :" + packageName);
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "checkXGServiceV3IsRunningByPkgName", th);
            return false;
        }
    }

    public static List<ResolveInfo> c(Context context, String str) {
        if (context != null) {
            try {
                return context.getPackageManager().queryIntentServices(new Intent(str), 512);
            } catch (Throwable th) {
                TLogger.e("ServiceUtil", "getLocalPushServicesInfo", th);
                return null;
            }
        } else {
            TLogger.e("ServiceUtil", "getLocalPushServicesInfo the context == null");
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        List<String> registerInfos;
        if (context == null || (registerInfos = CacheManager.getRegisterInfos(context)) == null) {
            return false;
        }
        for (String str2 : registerInfos) {
            if (str2.equals(str) && !context.getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Intent a(int i, String str, int i2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
        if (!(str == null || str.length() == 0)) {
            intent.setPackage(str);
        }
        intent.putExtra("TPUSH.FEEDBACK", i2);
        intent.putExtra("TPUSH.ERRORCODE", i);
        return intent;
    }

    public static boolean a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return true;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return true;
            }
            Calendar instance = Calendar.getInstance();
            int i = (instance.get(11) * 60) + instance.get(12);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("start"));
                int intValue = (Integer.valueOf(jSONObject3.getString("hour")).intValue() * 60) + Integer.valueOf(jSONObject3.getString("min")).intValue();
                JSONObject jSONObject4 = new JSONObject(jSONObject2.getString("end"));
                int intValue2 = (Integer.valueOf(jSONObject4.getString("hour")).intValue() * 60) + Integer.valueOf(jSONObject4.getString("min")).intValue();
                TLogger.i("ServiceUtil", ">> check accept time, current:" + i + ", startTime:" + intValue + ", endTime:" + intValue2);
                if (intValue <= i && i <= intValue2) {
                    return true;
                }
            }
            TLogger.w("Utils", " discurd the msg due to time not accepted! acceptTime = " + string + " , curTime= " + i);
            return false;
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "checkAcceptTime", th);
            return true;
        }
    }

    public static long b(Intent intent) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String stringExtra = intent.getStringExtra("date");
            if (j.b(stringExtra)) {
                stringExtra = simpleDateFormat.format(new Date());
            }
            long time = simpleDateFormat.parse(stringExtra).getTime();
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return time;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return time;
            }
            int i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONArray.getString(i2)).getString("start"));
                int intValue = (Integer.valueOf(jSONObject2.getString("hour")).intValue() * 60) + Integer.valueOf(jSONObject2.getString("min")).intValue();
                if (intValue < i || i == 0) {
                    i = intValue;
                }
            }
            long j = time + (((long) (i * 60)) * 1000);
            TLogger.i("Utils", "get acceptTime = " + string + " , acceptBeginTime= " + j);
            return j;
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "getAcceptBeginTime", th);
            return 0;
        }
    }

    public static void e(Context context) {
        try {
            String d2 = com.tencent.android.tpush.stat.a.a.d(context);
            TLogger.d("ServiceUtil", "serviceSafeExit @ " + d2);
            if (d2 != null && d2.contains(":xg_vip_service")) {
                XGVipPushService.a().stopSelf();
            }
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "unexpected for serviceSafeExit", th);
        }
    }
}
