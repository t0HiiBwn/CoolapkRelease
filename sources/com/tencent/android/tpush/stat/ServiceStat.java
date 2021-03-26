package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.PushStatClientReport;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.event.e;
import com.tencent.android.tpush.stat.event.f;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class ServiceStat {
    public static final String ACCOUNT_EVENT_ID = "SdkAccount";
    public static final String ACK_EVENT_ID = "Ack";
    public static final String APP_LIST_EVENT_ID = "app_list";
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_APP_RECEIVED = 8;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_CLEAN_UP = 64;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_REVOKE_MESSAGE_SERVICE_RECEIVED = 2048;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SERVICE_RECEIVED = 4;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SHOW = 128;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_USER_CLICK = 16;
    public static final int EnumPushChannel = 0;
    public static final int EnumPushChannel_CHANNEL_FCM = 101;
    public static final int EnumPushChannel_CHANNEL_HUAWEI = 102;
    public static final int EnumPushChannel_CHANNEL_LOCAL = 99;
    public static final int EnumPushChannel_CHANNEL_MEIZU = 106;
    public static final int EnumPushChannel_CHANNEL_OPPO = 105;
    public static final int EnumPushChannel_CHANNEL_VIVO = 104;
    public static final int EnumPushChannel_CHANNEL_XG = 100;
    public static final int EnumPushChannel_CHANNEL_XIAOMI = 103;
    public static final String FAILED_CNT = "failed_cnt";
    public static final String HEARTBEAT_EVENT_ID = "SdkHeartbeat";
    public static final String IS_CUSTOMDATA_VERSION_EVENT_ID = "IsCustomDataVersion";
    public static final String LAST_REPORT_APPLIST = "last_reportAppList_time";
    public static final String LAST_REPORT_NOTIFICATION = "last_reportNotification_time";
    public static final String NETWORKTYOE = "np";
    public static final String NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID = "Action";
    public static final String NOTIFICATION_STATUS_EVENT_ID = "notification_st";
    public static final String REGISTER_EVENT_ID = "SdkRegister";
    public static final String SDK_ACK_EVENT_ID = "SdkAck";
    public static final String SDK_OTHER_PULLUP_ID = "OtherPull";
    public static final String SERVICE_EVENT_ID = "SdkService";
    public static final String SHOW_EVENT_ID = "SHOW";
    public static final String SRV_ACK_EVENT_ID = "SrvAck";
    public static final String STRATTIME = "failed_cnt";
    public static final String SUCC_CNT = "suc_cnt";
    public static final String UNREGISTER_EVENT_ID = "SdkUnRegister";
    public static final String VERIFY_EVENT_ID = "Verify";
    public static AtomicBoolean _isInited = new AtomicBoolean(false);
    private static Context a;
    private static boolean b;
    private static volatile a c;

    public static void appReportPullupAck(Context context, Intent intent) {
    }

    public static void reportAck(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportIsCustomDataAcquisitionVersion(Context context) {
    }

    public static void reportNotifactionClickedOrClear(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportPullYYB() {
    }

    public static void reportSrvAck(ArrayList<j> arrayList) {
    }

    public static void reportXGLBS(Context context, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat(Context context, long j, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat2(Context context, String str, JSONObject jSONObject) {
    }

    public static void debug(boolean z) {
        b.a(z);
    }

    /* compiled from: ProGuard */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            NetworkInfo networkInfo;
            if (intent != null && context != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null) {
                TLogger.v("ServiceStat", "NetworkReceiver - Connection state changed to - " + networkInfo.toString());
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    TLogger.v("ServiceStat", "stat network is disConnected");
                } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    TLogger.v("ServiceStat", "stat network connected and sendLocalMsg on 5s later");
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.stat.ServiceStat.a.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ServiceStat.sendLocalMsg(context);
                        }
                    }, 5000);
                } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                    TLogger.v("ServiceStat", "Network is disconnected.");
                } else {
                    TLogger.v("ServiceStat", "other network state - " + networkInfo.getState() + ". Do nothing.");
                }
            }
        }
    }

    public static synchronized void init(Context context) {
        synchronized (ServiceStat.class) {
            if (!_isInited.get()) {
                b.c(true);
                b.a(StatReportStrategy.INSTANT);
                e.b(context);
                e.e(context);
                a = context.getApplicationContext();
                try {
                    if (c == null) {
                        TLogger.d("ServiceStat", "register network receiver on ServiceStat.init");
                        c = new a();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        a.getApplicationContext().registerReceiver(c, intentFilter);
                    }
                } catch (Throwable th) {
                    TLogger.e("ServiceStat", "init", th);
                }
                _isInited.set(true);
            }
        }
    }

    public static void commit() {
        e.b(a, -1);
    }

    public static void sendLocalMsg(Context context) {
        if (context != null) {
            init(context);
            if (e.b) {
                e.b = !e.c(context, -1);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db A[Catch:{ all -> 0x0101 }] */
    private static void a(Context context, Intent intent, int i) {
        long j;
        String stringExtra;
        if (intent == null || i < 0) {
            TLogger.e("ServiceStat", "intent = null or evendId < 0 ");
            return;
        }
        init(context);
        try {
            long longExtra = intent.getLongExtra("msgId", 0);
            long longExtra2 = intent.getLongExtra("type", 1);
            long longExtra3 = intent.getLongExtra("busiMsgId", 0);
            long longExtra4 = intent.getLongExtra("accId", 0);
            String stringExtra2 = intent.getStringExtra("groupId");
            if (com.tencent.android.tpush.common.j.b(stringExtra2)) {
                stringExtra2 = intent.getStringExtra("group_id");
            }
            if (longExtra4 == 0) {
                longExtra4 = XGApiConfig.getAccessId(a);
            }
            e eVar = new e(context.getApplicationContext(), longExtra4);
            eVar.t = longExtra;
            eVar.u = longExtra2;
            eVar.n = System.currentTimeMillis() / 1000;
            if (!com.tencent.android.tpush.common.j.b(stringExtra2)) {
                eVar.w = stringExtra2;
            }
            eVar.p = intent.getIntExtra("pushChannel", -1);
            if (eVar.p != 100) {
                if (!com.tencent.android.tpush.f.a.a(context) || eVar.p != com.tencent.android.tpush.f.a.a()) {
                    j = intent.getLongExtra("pushTime", 0);
                    eVar.v = i;
                    eVar.m = longExtra3;
                    eVar.o = j / 1000;
                    eVar.s = GuidInfoManager.getToken(context.getApplicationContext());
                    eVar.r = "1.2.3.1";
                    eVar.q = com.tencent.android.tpush.stat.a.a.c(context);
                    eVar.x = intent.getLongExtra("targetType", 0);
                    eVar.y = intent.getLongExtra("source", 0);
                    eVar.B = intent.getStringExtra("templateId");
                    eVar.C = intent.getStringExtra("traceId");
                    stringExtra = intent.getStringExtra("inapp_custom_event_id");
                    if (!com.tencent.android.tpush.common.j.b(stringExtra)) {
                        eVar.z = stringExtra;
                        int intExtra = intent.getIntExtra("inapp_button_event_id", 0);
                        Properties properties = new Properties();
                        properties.put("BUTTON_ID", String.valueOf(intExtra));
                        eVar.A = new JSONObject(properties);
                    }
                    e.a(context.getApplicationContext(), eVar);
                }
            }
            j = intent.getLongExtra("timestamps", 0);
            eVar.v = i;
            eVar.m = longExtra3;
            eVar.o = j / 1000;
            eVar.s = GuidInfoManager.getToken(context.getApplicationContext());
            eVar.r = "1.2.3.1";
            eVar.q = com.tencent.android.tpush.stat.a.a.c(context);
            eVar.x = intent.getLongExtra("targetType", 0);
            eVar.y = intent.getLongExtra("source", 0);
            eVar.B = intent.getStringExtra("templateId");
            eVar.C = intent.getStringExtra("traceId");
            stringExtra = intent.getStringExtra("inapp_custom_event_id");
            if (!com.tencent.android.tpush.common.j.b(stringExtra)) {
            }
            e.a(context.getApplicationContext(), eVar);
        } catch (Throwable th) {
            TLogger.e("ServiceStat", "reportSDKAck", th);
        }
    }

    public static void appReportServiceReceived(Context context, Intent intent) {
        a(context, intent, 4);
    }

    public static void appReportRevokeMessageServiceReceived(Context context, Intent intent) {
        a(context, intent, 2048);
    }

    public static void appReportSDKReceived(Context context, Intent intent) {
        a(context, intent, 8);
    }

    public static void appReportNotificationShowed(Context context, Intent intent) {
        a(context, intent, 128);
    }

    public static void appReportNotificationCleared(Context context, Intent intent) {
        a(context, intent, 64);
    }

    public static void appReportNotificationClicked(Context context, Intent intent) {
        a(context, intent, 16);
    }

    public static void reportLaunchEvent(Context context, int i) {
        e.a(context, i);
    }

    public static void reportCustomData(Context context, String str, Properties properties) {
        e.a(context, str, properties);
    }

    public static void reportCustomData4FirstLaunch(Context context) {
        e.a(context, "FIRST_OPEN", null);
    }

    public static void reportCloudControl(Context context, long j, int i, String str, long j2) {
        try {
            com.tencent.android.tpush.stat.event.a aVar = new com.tencent.android.tpush.stat.event.a(context, j, i);
            if (j2 != 0) {
                aVar.b = j2;
            }
            if (!TextUtils.isEmpty(str)) {
                aVar.a = str;
            }
            e.a(context.getApplicationContext(), aVar);
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportCloudControl", th);
        }
    }

    public static void reportErrCode(Context context, int i, String str, long j, String str2) {
        try {
            if (CloudManager.getInstance(context).disableReptErrCode()) {
                TLogger.d("ServiceStat", "disable reportErrCode");
                return;
            }
            init(context);
            f fVar = new f(context, i, str2);
            if (!TextUtils.isEmpty(str)) {
                fVar.n = str;
            }
            if (j != 0) {
                fVar.o = j;
            }
            e.a(context.getApplicationContext(), fVar);
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportErrCode", th);
        }
    }

    public static void reportTokenFailed(Context context) {
        int i;
        try {
            if (!b) {
                String g = d.g();
                String h = d.h();
                if (i.a(context).c() && XGPushConfig.isNotTryFcm(context)) {
                    i = -1057;
                } else if (d.a(context).j()) {
                    if (com.tencent.android.tpush.f.a.b(context)) {
                        i = -1051;
                    } else {
                        if (!ChannelUtils.isBrandXiaoMi()) {
                            if (!"blackshark".equals(g) || com.tencent.android.tpush.common.j.b(d.a)) {
                                if ((ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) && !com.tencent.android.tpush.common.j.b(com.tencent.android.tpush.common.j.l(context))) {
                                    i = -1055;
                                } else if (!ChannelUtils.isBrandMeiZu() || com.tencent.android.tpush.common.j.b(d.c)) {
                                    i = (("oppo".equals(g) || "oneplus".equals(g) || "realme".equals(g)) && !com.tencent.android.tpush.common.j.b(d.e)) ? -1053 : (!"vivo".equals(g) || com.tencent.android.tpush.common.j.b(com.tencent.android.tpush.common.j.m(context))) ? 0 : -1052;
                                } else {
                                    i = -1054;
                                }
                            }
                        }
                        i = -1056;
                    }
                } else {
                    return;
                }
                if (i != 0) {
                    b = true;
                    reportErrCode(context, i, g + ":" + h + ":" + XGPushConfig.getOtherPushErrCode(context), 0, "inner");
                }
            }
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportTokenFailed", th);
        }
    }
}
