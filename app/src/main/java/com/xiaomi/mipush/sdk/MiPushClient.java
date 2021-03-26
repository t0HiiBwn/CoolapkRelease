package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.ai;
import com.xiaomi.push.ax;
import com.xiaomi.push.bi;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.ew;
import com.xiaomi.push.g;
import com.xiaomi.push.hc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hw;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.l;
import com.xiaomi.push.n;
import com.xiaomi.push.r;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.t;
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
            r.a(edit);
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
        r.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        r.a(edit);
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
        ai.a(context).a(new Runnable() {
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
                    b.a(th);
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

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ak.a(context).m74e();
    }

    public static void clearNotification(Context context) {
        ak.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ak.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ak.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ak.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ak.a(context).a(false);
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
        if (b.m75a(context).m84c()) {
            return b.m75a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return l.m571b();
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
        if (b.m75a(context).m84c()) {
            return b.m75a(context).m83c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        em.a(new em.a() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass5 */

            @Override // com.xiaomi.push.em.a
            public void uploader(Context context, hg hgVar) {
                MiTinyDataClient.upload(context, hgVar);
            }
        });
        Config a = em.a(context);
        a.a(context).a("3_7_9");
        ClientReportClient.init(context, a, new ek(context), new el(context));
        a.a(context);
        r.a(context, a);
        an.a(context).a(new an.a(100, "perf event job update") {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass6 */

            @Override // com.xiaomi.push.service.an.a
            protected void onCallback() {
                em.m293a(context);
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
            b.a(context.getApplicationContext());
            b.e("sdk_version = 3_7_9");
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (t.m678a(sContext)) {
                t.a(sContext);
            }
            boolean z = b.m75a(sContext).a() != Constants.a();
            if (z || shouldSendRegRequest(sContext)) {
                if (z || !b.m75a(sContext).a(str, str2) || b.m75a(sContext).m86e()) {
                    String a = bi.a(6);
                    b.m75a(sContext).m77a();
                    b.m75a(sContext).a(Constants.a());
                    b.m75a(sContext).a(str, str2, a);
                    MiTinyDataClient.a.a().b("com.xiaomi.xmpushsdk.tinydataPending.appId");
                    clearExtras(sContext);
                    clearNotification(context);
                    ic icVar = new ic();
                    icVar.a(aq.a());
                    icVar.b(str);
                    icVar.e(str2);
                    icVar.d(sContext.getPackageName());
                    icVar.f(a);
                    Context context2 = sContext;
                    icVar.c(g.m356a(context2, context2.getPackageName()));
                    Context context3 = sContext;
                    icVar.b(g.a(context3, context3.getPackageName()));
                    icVar.h("3_7_9");
                    icVar.a(30709);
                    icVar.a(hq.Init);
                    if (!TextUtils.isEmpty(str3)) {
                        icVar.g(str3);
                    }
                    if (!l.d()) {
                        String g = i.g(sContext);
                        if (!TextUtils.isEmpty(g)) {
                            icVar.i(bi.a(g) + "," + i.j(sContext));
                        }
                    }
                    int a2 = i.a();
                    if (a2 >= 0) {
                        icVar.c(a2);
                    }
                    ak.a(sContext).a(icVar, z);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, "callback");
                        miPushClientCallback.onInitializeResult(0, null, b.m75a(sContext).m83c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.m75a(sContext).m83c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f419a, arrayList, 0, null, null));
                    }
                    ak.a(sContext).m66a();
                    if (b.m75a(sContext).m79a()) {
                        ib ibVar = new ib();
                        ibVar.b(b.m75a(sContext).m76a());
                        ibVar.c(hm.ClientInfoUpdate.f576a);
                        ibVar.a(aq.a());
                        ibVar.f717a = new HashMap();
                        Map<String, String> map = ibVar.f717a;
                        Context context4 = sContext;
                        map.put("app_version", g.m356a(context4, context4.getPackageName()));
                        Map<String, String> map2 = ibVar.f717a;
                        Context context5 = sContext;
                        map2.put("app_version_code", Integer.toString(g.a(context5, context5.getPackageName())));
                        ibVar.f717a.put("push_sdk_vn", "3_7_9");
                        ibVar.f717a.put("push_sdk_vc", Integer.toString(30709));
                        i.a(sContext, ibVar.f717a);
                        String e = b.m75a(sContext).e();
                        if (!TextUtils.isEmpty(e)) {
                            ibVar.f717a.put("deviceid", e);
                        }
                        ak.a(sContext).a((ak) ibVar, hc.Notification, false, (hp) null);
                    }
                    if (!n.m572a(sContext, "update_devId", false)) {
                        updateImeiOrOaid();
                        n.a(sContext, "update_devId", true);
                    }
                    String c = i.c(sContext);
                    if (!TextUtils.isEmpty(c)) {
                        hw hwVar = new hw();
                        hwVar.a(aq.a());
                        hwVar.b(str);
                        hwVar.c(ew.COMMAND_CHK_VDEVID.f419a);
                        ArrayList arrayList2 = new ArrayList();
                        String b = i.b(sContext);
                        if (!TextUtils.isEmpty(b)) {
                            arrayList2.add(b);
                        }
                        String str4 = "";
                        if (c == null) {
                            c = str4;
                        }
                        arrayList2.add(c);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : str4);
                        if (Build.BOARD != null) {
                            str4 = Build.BOARD;
                        }
                        arrayList2.add(str4);
                        hwVar.a(arrayList2);
                        ak.a(sContext).a((ak) hwVar, hc.Command, false, (hp) null);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        ib ibVar2 = new ib();
                        ibVar2.b(b.m75a(sContext).m76a());
                        ibVar2.c(hm.PullOfflineMessage.f576a);
                        ibVar2.a(aq.a());
                        ibVar2.a(false);
                        ak.a(sContext).a((ak) ibVar2, hc.Notification, false, (hp) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                aq.a(sContext);
                if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (Logger.getUserLogger() != null) {
                        Logger.setLogger(sContext, Logger.getUserLogger());
                    }
                    b.a(2);
                }
                operateSyncAction(context);
                return;
            }
            ak.a(sContext).m66a();
            b.m41a("Could not send  register message within 5s repeatly .");
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(ab.a(sContext).a(ap.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(ab.a(sContext).a(ap.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(ab.a(sContext).a(ap.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(ab.a(sContext).a(ap.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(ab.a(sContext).a(ap.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(ab.a(sContext).a(ap.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, hq hqVar) {
        if (b.m75a(context).m84c()) {
            String a = bi.a(6);
            String a2 = b.m75a(context).m76a();
            String b = b.m75a(context).b();
            b.m75a(context).m77a();
            clearNotification(context);
            b.m75a(context).a(Constants.a());
            b.m75a(context).a(a2, b, a);
            ic icVar = new ic();
            icVar.a(aq.a());
            icVar.b(a2);
            icVar.e(b);
            icVar.f(a);
            icVar.d(context.getPackageName());
            icVar.c(g.m356a(context, context.getPackageName()));
            icVar.a(hqVar);
            ak.a(context).a(icVar, false);
        }
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            b.a(th);
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
        t.m676a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        ai.a(context2).a(new Runnable() {
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
            r.a(edit);
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
        if (b.m75a(context).m82b()) {
            hm hmVar = z ? hm.APP_SLEEP : hm.APP_WAKEUP;
            ib ibVar = new ib();
            ibVar.b(b.m75a(context).m76a());
            ibVar.c(hmVar.f576a);
            ibVar.d(context.getPackageName());
            ibVar.a(aq.a());
            ibVar.a(false);
            ak.a(context).a((ak) ibVar, hc.Notification, false, (hp) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, hp hpVar, String str2, String str3) {
        ib ibVar = new ib();
        if (TextUtils.isEmpty(str3)) {
            b.d("do not report clicked message");
            return;
        }
        ibVar.b(str3);
        ibVar.c("bar:click");
        ibVar.a(str);
        ibVar.a(false);
        ak.a(context).a(ibVar, hc.Notification, false, true, hpVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hp hpVar = new hp();
        hpVar.a(miPushMessage.getMessageId());
        hpVar.b(miPushMessage.getTopic());
        hpVar.d(miPushMessage.getDescription());
        hpVar.c(miPushMessage.getTitle());
        hpVar.c(miPushMessage.getNotifyId());
        hpVar.a(miPushMessage.getNotifyType());
        hpVar.b(miPushMessage.getPassThrough());
        hpVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hpVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, hp hpVar, String str2) {
        ib ibVar = new ib();
        if (TextUtils.isEmpty(str2)) {
            if (b.m75a(context).m82b()) {
                str2 = b.m75a(context).m76a();
            } else {
                b.d("do not report clicked message");
                return;
            }
        }
        ibVar.b(str2);
        ibVar.c("bar:click");
        ibVar.a(str);
        ibVar.a(false);
        ak.a(context).a((ak) ibVar, hc.Notification, false, hpVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (an.a(sContext).a(hh.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dh.a().a(new q(context));
            ai.a(sContext).a(new Runnable() {
                /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    di.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        ai.a(sContext).a(new aa(sContext), an.a(sContext).a(hh.OcVersionCheckFrequency.a(), 86400), 5);
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
            setCommand(context, ew.COMMAND_SET_ACCEPT_TIME.f419a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ew.COMMAND_SET_ACCEPT_TIME.f419a, 0, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SET_ACCEPT_TIME.f419a, arrayList2, 0, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ew.COMMAND_SET_ALIAS.f419a, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ew ewVar;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!ew.COMMAND_SET_ALIAS.f419a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= 86400000) {
            if (ew.COMMAND_UNSET_ALIAS.f419a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (!ew.COMMAND_SET_ACCOUNT.f419a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= 3600000) {
                if (!ew.COMMAND_UNSET_ACCOUNT.f419a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, arrayList, str3);
                    return;
                } else {
                    sb = new StringBuilder();
                    str4 = "Don't cancel account for ";
                }
            } else if (1 != PushMessageHelper.getPushMode(context)) {
                ewVar = ew.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ewVar.f419a, arrayList, 0, null, str3));
                return;
            }
            sb.append(str4);
            sb.append(bi.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            b.m41a(sb.toString());
            return;
        } else if (1 != PushMessageHelper.getPushMode(context)) {
            ewVar = ew.COMMAND_SET_ALIAS;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ewVar.f419a, arrayList, 0, null, str3));
            return;
        }
        PushMessageHandler.a(context, str3, str, 0, null, arrayList);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(b.m75a(context).m76a())) {
            hw hwVar = new hw();
            String a = aq.a();
            hwVar.a(a);
            hwVar.b(b.m75a(context).m76a());
            hwVar.c(str);
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                hwVar.m447a(it2.next());
            }
            hwVar.e(str2);
            hwVar.d(context.getPackageName());
            b.e("cmd:" + str + ", " + a);
            ak.a(context).a((ak) hwVar, hc.Command, (hp) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        ak.a(context).b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ew.COMMAND_SET_ACCOUNT.f419a, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ak.a(context).m68a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(b.m75a(context).m76a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                ig igVar = new ig();
                String a = aq.a();
                igVar.a(a);
                igVar.b(b.m75a(context).m76a());
                igVar.c(str);
                igVar.d(context.getPackageName());
                igVar.e(str2);
                b.e("cmd:" + ew.COMMAND_SUBSCRIBE_TOPIC + ", " + a);
                ak.a(context).a((ak) igVar, hc.Subscription, (hp) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SUBSCRIBE_TOPIC.f419a, arrayList, 0, null, null));
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context context) {
        ak.a(context).a((String) null, ap.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ak.a(context).a((String) null, ap.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        ak.a(context).a((String) null, ap.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        ak.a(context).a((String) null, ap.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI);
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
        an.a(context).a();
        if (b.m75a(context).m82b()) {
            ii iiVar = new ii();
            iiVar.a(aq.a());
            iiVar.b(b.m75a(context).m76a());
            iiVar.c(b.m75a(context).m83c());
            iiVar.e(b.m75a(context).b());
            iiVar.d(context.getPackageName());
            ak.a(context).a(iiVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m75a(context).m81b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ew.COMMAND_UNSET_ALIAS.f419a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ew.COMMAND_UNSET_ACCOUNT.f419a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m75a(context).m82b()) {
            if (topicSubscribedTime(context, str) < 0) {
                b.m41a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ik ikVar = new ik();
            String a = aq.a();
            ikVar.a(a);
            ikVar.b(b.m75a(context).m76a());
            ikVar.c(str);
            ikVar.d(context.getPackageName());
            ikVar.e(str2);
            b.e("cmd:" + ew.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a);
            ak.a(context).a((ak) ikVar, hc.UnSubscription, (hp) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (l.d()) {
                    return;
                }
                if (i.f(MiPushClient.sContext) != null || ax.a(MiPushClient.sContext).mo112a()) {
                    ib ibVar = new ib();
                    ibVar.b(b.m75a(MiPushClient.sContext).m76a());
                    ibVar.c(hm.ClientInfoUpdate.f576a);
                    ibVar.a(aq.a());
                    ibVar.a(new HashMap());
                    String str = "";
                    String f = i.f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(f)) {
                        str = str + bi.a(f);
                    }
                    String h = i.h(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h)) {
                        str = str + "," + h;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ibVar.m481a().put("imei_md5", str);
                    }
                    ax.a(MiPushClient.sContext).a(ibVar.m481a());
                    i.a(MiPushClient.sContext, ibVar.f717a);
                    int a = i.a();
                    if (a >= 0) {
                        ibVar.m481a().put("space_id", Integer.toString(a));
                    }
                    ak.a(MiPushClient.sContext).a((ak) ibVar, hc.Notification, false, (hp) null);
                }
            }
        }).start();
    }
}
