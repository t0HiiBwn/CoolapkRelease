package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.a.a;
import com.xiaomi.b.b.b;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.ah;
import com.xiaomi.push.ci;
import com.xiaomi.push.cj;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.du;
import com.xiaomi.push.ea;
import com.xiaomi.push.eu;
import com.xiaomi.push.gi;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hd;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hr;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iv;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.o;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.v;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static boolean isCrashHandlerSuggested;
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        protected String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private long resultCode = -1;
        private String token = null;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }

        protected void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            iz.a(edit);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        iz.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        iz.a(edit);
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        j.a(context).a(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String[] strArr = strArr;
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
                            if (packageInfo != null) {
                                MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                            }
                        }
                    }
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (com.xiaomi.push.v.a(r5).a() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    private static boolean checkPermission(Context context) {
        boolean z = true;
        if (context != null) {
            if (!it.a() && !"com.xiaomi.xmsf".equals(context.getPackageName()) && TextUtils.isEmpty(gw.b(context))) {
                if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
                    String f = gw.f(context);
                    String a = gw.a();
                    if (TextUtils.isEmpty(f)) {
                    }
                } else if (!iu.a(context, "android.permission.READ_PHONE_STATE")) {
                    if (!iu.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    }
                }
            }
            if (!z) {
                c.d("Because of lack of necessary information, mi push can't be initialized");
                ArrayList arrayList = new ArrayList();
                if (!iu.a(context, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (!iu.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (!arrayList.isEmpty()) {
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    Intent intent = new Intent();
                    intent.setAction("com.xiaomi.mipush.ERROR");
                    intent.setPackage(context.getPackageName());
                    intent.putExtra("message_type", 5);
                    intent.putExtra("error_type", "error_lack_of_permission");
                    intent.putExtra("error_message", strArr);
                    context.sendBroadcast(intent);
                }
            }
            return z;
        }
        z = false;
        if (!z) {
        }
        return z;
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        aq.a(context).m53e();
    }

    public static void clearNotification(Context context) {
        aq.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        aq.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        aq.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        aq.a(context).a(true);
    }

    public static void enablePush(Context context) {
        aq.a(context).a(false);
    }

    private static void forceHandleCrash() {
        boolean a = l.a(sContext).a(gn.ForceHandleCrashSwitch.a(), false);
        if (!isCrashHandlerSuggested && a) {
            Thread.setDefaultUncaughtExceptionHandler(new v(sContext));
        }
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m54a(context).m63c()) {
            return b.m54a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return it.b();
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m54a(context).m63c()) {
            return b.m54a(context).m62c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        du.a(new du.a() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass5 */

            @Override // com.xiaomi.push.du.a
            public void uploader(Context context, gm gmVar) {
                MiTinyDataClient.upload(context, gmVar);
            }
        });
        a c = du.c(context);
        b.a(context).a("3_7_5");
        com.xiaomi.b.b.a.a(context, c, new dr(context), new ds(context));
        a.a(context);
        r.a(context, c);
        l.a(context).a(new l.a(100, "perf event job update") {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass6 */

            @Override // com.xiaomi.push.service.l.a
            protected void onCallback() {
                du.b(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            c.a("sdk_version = 3_7_5");
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (jb.b(sContext)) {
                x.a(sContext);
            }
            if (b.m54a(sContext).a(str, str2) || checkPermission(sContext)) {
                boolean z = b.m54a(sContext).a() != Constants.a();
                if (z || shouldSendRegRequest(sContext)) {
                    if (z || !b.m54a(sContext).a(str, str2) || b.m54a(sContext).m65e()) {
                        String a = ah.a(6);
                        b.m54a(sContext).m56a();
                        b.m54a(sContext).a(Constants.a());
                        b.m54a(sContext).a(str, str2, a);
                        MiTinyDataClient.a.a().b("com.xiaomi.xmpushsdk.tinydataPending.appId");
                        clearExtras(sContext);
                        hj hjVar = new hj();
                        hjVar.a(o.a());
                        hjVar.b(str);
                        hjVar.e(str2);
                        hjVar.d(sContext.getPackageName());
                        hjVar.f(a);
                        Context context2 = sContext;
                        hjVar.c(eu.a(context2, context2.getPackageName()));
                        Context context3 = sContext;
                        hjVar.b(eu.b(context3, context3.getPackageName()));
                        hjVar.h("3_7_5");
                        hjVar.a(30705);
                        hjVar.i(gw.e(sContext));
                        hjVar.a(gx.Init);
                        if (!TextUtils.isEmpty(str3)) {
                            hjVar.g(str3);
                        }
                        if (!it.g()) {
                            String g = gw.g(sContext);
                            if (!TextUtils.isEmpty(g)) {
                                hjVar.k(ah.a(g) + "," + gw.j(sContext));
                            }
                        }
                        hjVar.j(gw.a());
                        int b = gw.b();
                        if (b >= 0) {
                            hjVar.c(b);
                        }
                        aq.a(sContext).a(hjVar, z);
                        sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                    } else {
                        if (1 == PushMessageHelper.getPushMode(sContext)) {
                            checkNotNull(miPushClientCallback, "callback");
                            miPushClientCallback.onInitializeResult(0, null, b.m54a(sContext).m62c());
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(b.m54a(sContext).m62c());
                            PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ea.COMMAND_REGISTER.k, arrayList, 0, null, null));
                        }
                        aq.a(sContext).m45a();
                        if (b.m54a(sContext).m58a()) {
                            hi hiVar = new hi();
                            hiVar.b(b.m54a(sContext).m55a());
                            hiVar.c("client_info_update");
                            hiVar.a(o.a());
                            hiVar.h = new HashMap();
                            Map<String, String> map = hiVar.h;
                            Context context4 = sContext;
                            map.put("app_version", eu.a(context4, context4.getPackageName()));
                            Map<String, String> map2 = hiVar.h;
                            Context context5 = sContext;
                            map2.put("app_version_code", Integer.toString(eu.b(context5, context5.getPackageName())));
                            hiVar.h.put("push_sdk_vn", "3_7_5");
                            hiVar.h.put("push_sdk_vc", Integer.toString(30705));
                            String e = b.m54a(sContext).e();
                            if (!TextUtils.isEmpty(e)) {
                                hiVar.h.put("deviceid", e);
                            }
                            aq.a(sContext).a((aq) hiVar, gi.Notification, false, (gv) null);
                        }
                        if (!iv.a(sContext, "update_devId", false)) {
                            updateImeiOrOaid();
                            iv.b(sContext, "update_devId", true);
                        }
                        String d = gw.d(sContext);
                        if (!TextUtils.isEmpty(d)) {
                            hd hdVar = new hd();
                            hdVar.a(o.a());
                            hdVar.b(str);
                            hdVar.c(ea.COMMAND_CHK_VDEVID.k);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(gw.c(sContext));
                            arrayList2.add(d);
                            String str4 = "";
                            arrayList2.add(Build.MODEL != null ? Build.MODEL : str4);
                            if (Build.BOARD != null) {
                                str4 = Build.BOARD;
                            }
                            arrayList2.add(str4);
                            hdVar.a(arrayList2);
                            aq.a(sContext).a((aq) hdVar, gi.Command, false, (gv) null);
                        }
                        if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                            hi hiVar2 = new hi();
                            hiVar2.b(b.m54a(sContext).m55a());
                            hiVar2.c(gs.PullOfflineMessage.S);
                            hiVar2.a(o.a());
                            hiVar2.a(false);
                            aq.a(sContext).a((aq) hiVar2, gi.Notification, false, (gv) null, false);
                            addPullNotificationTime(sContext);
                        }
                    }
                    addRegRequestTime(sContext);
                    scheduleOcVersionCheckJob();
                    scheduleDataCollectionJobs(sContext);
                    initEventPerfLogic(sContext);
                    aw.a(sContext);
                    forceHandleCrash();
                    if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                        if (Logger.getUserLogger() != null) {
                            Logger.setLogger(sContext, Logger.getUserLogger());
                        }
                        c.a(2);
                    }
                    operateSyncAction(context);
                    return;
                }
                aq.a(sContext).m45a();
                c.a("Could not send  register message within 5s repeatly .");
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(ag.a(sContext).a(av.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, gx gxVar) {
        if (b.m54a(context).m63c()) {
            String a = ah.a(6);
            String a2 = b.m54a(context).m55a();
            String b = b.m54a(context).b();
            b.m54a(context).m56a();
            b.m54a(context).a(Constants.a());
            b.m54a(context).a(a2, b, a);
            hj hjVar = new hj();
            hjVar.a(o.a());
            hjVar.b(a2);
            hjVar.e(b);
            hjVar.f(a);
            hjVar.d(context.getPackageName());
            hjVar.c(eu.a(context, context.getPackageName()));
            hjVar.a(gxVar);
            aq.a(context).a(hjVar, false);
        }
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(new v(sContext, uncaughtExceptionHandler));
        isCrashHandlerSuggested = true;
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        jb.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        j.a(context2).a(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            iz.a(edit);
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m54a(context).m61b()) {
            gs gsVar = z ? gs.APP_SLEEP : gs.APP_WAKEUP;
            hi hiVar = new hi();
            hiVar.b(b.m54a(context).m55a());
            hiVar.c(gsVar.S);
            hiVar.d(context.getPackageName());
            hiVar.a(o.a());
            hiVar.a(false);
            aq.a(context).a((aq) hiVar, gi.Notification, false, (gv) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, gv gvVar, String str2, String str3) {
        hi hiVar = new hi();
        if (TextUtils.isEmpty(str3)) {
            c.d("do not report clicked message");
            return;
        }
        hiVar.b(str3);
        hiVar.c("bar:click");
        hiVar.a(str);
        hiVar.a(false);
        aq.a(context).a(hiVar, gi.Notification, false, true, gvVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gv gvVar = new gv();
        gvVar.a(miPushMessage.getMessageId());
        gvVar.b(miPushMessage.getTopic());
        gvVar.d(miPushMessage.getDescription());
        gvVar.c(miPushMessage.getTitle());
        gvVar.c(miPushMessage.getNotifyId());
        gvVar.a(miPushMessage.getNotifyType());
        gvVar.b(miPushMessage.getPassThrough());
        gvVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), gvVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, gv gvVar, String str2) {
        hi hiVar = new hi();
        if (TextUtils.isEmpty(str2)) {
            if (b.m54a(context).m61b()) {
                str2 = b.m54a(context).m55a();
            } else {
                c.d("do not report clicked message");
                return;
            }
        }
        hiVar.b(str2);
        hiVar.c("bar:click");
        hiVar.a(str);
        hiVar.a(false);
        aq.a(context).a((aq) hiVar, gi.Notification, false, gvVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (l.a(sContext).a(gn.DataCollectionSwitch.a(), getDefaultSwitch())) {
            ci.a().a(new q(context));
            j.a(sContext).a(new Runnable() {
                /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    cj.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        j.a(sContext).a(new af(sContext), l.a(sContext).a(gn.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        long j2 = ((((long) ((i3 * 60) + i4)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ea.COMMAND_SET_ACCEPT_TIME.k, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ea.COMMAND_SET_ACCEPT_TIME.k, 0, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ea.COMMAND_SET_ACCEPT_TIME.k, arrayList2, 0, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ea.COMMAND_SET_ALIAS.k, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ea eaVar;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!ea.COMMAND_SET_ALIAS.k.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= 86400000) {
            if (ea.COMMAND_UNSET_ALIAS.k.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (!ea.COMMAND_SET_ACCOUNT.k.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= 3600000) {
                if (!ea.COMMAND_UNSET_ACCOUNT.k.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, arrayList, str3);
                    return;
                } else {
                    sb = new StringBuilder();
                    str4 = "Don't cancel account for ";
                }
            } else if (1 != PushMessageHelper.getPushMode(context)) {
                eaVar = ea.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eaVar.k, arrayList, 0, null, str3));
                return;
            }
            sb.append(str4);
            sb.append(ah.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            c.a(sb.toString());
            return;
        } else if (1 != PushMessageHelper.getPushMode(context)) {
            eaVar = ea.COMMAND_SET_ALIAS;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eaVar.k, arrayList, 0, null, str3));
            return;
        }
        PushMessageHandler.a(context, str3, str, 0, null, arrayList);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(b.m54a(context).m55a())) {
            hd hdVar = new hd();
            hdVar.a(o.a());
            hdVar.b(b.m54a(context).m55a());
            hdVar.c(str);
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                hdVar.d(it2.next());
            }
            hdVar.f(str2);
            hdVar.e(context.getPackageName());
            aq.a(context).a((aq) hdVar, gi.Command, (gv) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        aq.a(context).b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ea.COMMAND_SET_ACCOUNT.k, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return aq.a(context).m47a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(b.m54a(context).m55a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                hn hnVar = new hn();
                hnVar.a(o.a());
                hnVar.b(b.m54a(context).m55a());
                hnVar.c(str);
                hnVar.d(context.getPackageName());
                hnVar.e(str2);
                aq.a(context).a((aq) hnVar, gi.Subscription, (gv) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ea.COMMAND_SUBSCRIBE_TOPIC.k, arrayList, 0, null, null));
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        h.c(context);
        l.a(context).a();
        if (b.m54a(context).m61b()) {
            hp hpVar = new hp();
            hpVar.a(o.a());
            hpVar.b(b.m54a(context).m55a());
            hpVar.c(b.m54a(context).m62c());
            hpVar.e(b.m54a(context).b());
            hpVar.d(context.getPackageName());
            aq.a(context).a(hpVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m54a(context).m60b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ea.COMMAND_UNSET_ALIAS.k, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ea.COMMAND_UNSET_ACCOUNT.k, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m54a(context).m61b()) {
            if (topicSubscribedTime(context, str) < 0) {
                c.a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            hr hrVar = new hr();
            hrVar.a(o.a());
            hrVar.b(b.m54a(context).m55a());
            hrVar.c(str);
            hrVar.d(context.getPackageName());
            hrVar.e(str2);
            aq.a(context).a((aq) hrVar, gi.UnSubscription, (gv) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (it.g()) {
                    return;
                }
                if (gw.f(MiPushClient.sContext) != null || v.a(MiPushClient.sContext).a()) {
                    hi hiVar = new hi();
                    hiVar.b(b.m54a(MiPushClient.sContext).m55a());
                    hiVar.c("client_info_update");
                    hiVar.a(o.a());
                    hiVar.a(new HashMap());
                    String str = "";
                    String f = gw.f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(f)) {
                        str = str + ah.a(f);
                    }
                    String h = gw.h(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h)) {
                        str = str + "," + h;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hiVar.j().put("imei_md5", str);
                    }
                    v.a(MiPushClient.sContext).a(hiVar.j());
                    int b = gw.b();
                    if (b >= 0) {
                        hiVar.j().put("space_id", Integer.toString(b));
                    }
                    aq.a(MiPushClient.sContext).a((aq) hiVar, gi.Notification, false, (gv) null);
                }
            }
        }).start();
    }
}
