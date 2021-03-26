package com.tencent.android.tpush;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.android.tpush.common.c;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.a.a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.LoggerInterface;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class XGPushConfig {
    public static final String TPUSH_ACCESS_CHANNAL = "XG_V4_CHANNEL_ID";
    public static final String TPUSH_ACCESS_ID = "XG_V2_ACCESS_ID";
    public static final String TPUSH_ACCESS_KEY = "XG_V2_ACCESS_KEY";
    public static final String TPUSH_IS_FOREIGINPUSH = "TPUSH_IS_FOREIGINPUSH";
    public static boolean _isHuaweiDebug = false;
    private static String a = "";
    private static String b = "";
    private static boolean c = true;
    private static String d = "";
    private static long e = -1;
    public static Boolean enableApplist;
    public static boolean enableDebug;
    public static Boolean enableLocation;
    public static Boolean enableNotification;
    private static Boolean f;
    public static Boolean fcmIsSuccess;
    private static Boolean g;
    private static SharedPreferences h;
    public static Boolean isUsedFcmPush;
    public static Boolean isUsedOtherPush;
    public static String notificationChannelID;
    public static String notificationChannelName;

    public static void setForeiginPushEnable(Context context, boolean z) {
    }

    public static synchronized long getChannelId(Context context) {
        Object metaData;
        synchronized (XGPushConfig.class) {
            if (context == null) {
                return e;
            }
            long j = e;
            if (j != -1) {
                return j;
            }
            if (!Security.checkTpnsSecurityLibSo(context)) {
                return e;
            }
            if (e == -1 && (metaData = CommonHelper.getMetaData(context, "XG_V4_CHANNEL_ID", null)) != null) {
                try {
                    e = Long.valueOf(metaData.toString()).longValue();
                } catch (Throwable th) {
                    TLogger.w("XGPushConfig", "get channelId from getMetaData failed: ", th);
                    e = -1;
                }
            }
            if (e == -1) {
                TLogger.d("XGPushConfig", "channelId is not empty");
            }
            return e;
        }
    }

    public static synchronized long getAccessId(Context context) {
        long accessId;
        synchronized (XGPushConfig.class) {
            accessId = XGApiConfig.getAccessId(context);
        }
        return accessId;
    }

    public static void setAccessId(Context context, long j) {
        XGApiConfig.setAccessId(context, j);
    }

    public static synchronized String getAccessKey(Context context) {
        String accessKey;
        synchronized (XGPushConfig.class) {
            accessKey = XGApiConfig.getAccessKey(context);
        }
        return accessKey;
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static String getToken(Context context) {
        if (context != null) {
            return CacheManager.getToken(context);
        }
        TLogger.e("XGPushConfig", "null context");
        return null;
    }

    public static void enableDebug(final Context context, final boolean z) {
        if (context != null) {
            enableDebug = z;
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.XGPushConfig.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TLogger.enableDebug(context, z);
                        Context context = context;
                        PushPreferences.putInt(context, "com.tencent.android.tpush.debug," + context.getPackageName(), z ? 1 : 0);
                        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                        intent.putExtra("debugMode", z);
                        d.a(context, intent);
                    } catch (Throwable th) {
                        TLogger.e("XGPushConfig", "enableDebug ", th);
                    }
                }
            });
        }
    }

    public static boolean isEnableDebug(Context context) {
        if (PushPreferences.getInt(context, "com.tencent.android.tpush.debug," + context.getPackageName(), 0) != 0) {
            return true;
        }
        return false;
    }

    public static void setTPushLogger(LoggerInterface loggerInterface) {
        TBaseLogger.setLogger(loggerInterface);
    }

    public static void setLocationEnable(Context context, boolean z) {
        Boolean bool = enableLocation;
        if (bool == null || bool.booleanValue() != z) {
            enableLocation = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_location," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static boolean isLocationEnable(Context context) {
        if (enableLocation == null) {
            boolean z = true;
            if (PushPreferences.getInt(context, "com.tencent.android.tpush.enable_location," + context.getPackageName(), 1) == 0) {
                z = false;
            }
            enableLocation = Boolean.valueOf(z);
        }
        return enableLocation.booleanValue();
    }

    public static void setReportApplistEnable(Context context, boolean z) {
        Boolean bool = enableApplist;
        if (bool == null || bool.booleanValue() != z) {
            enableApplist = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_applist," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static boolean isReportApplistEnable(Context context) {
        if (enableApplist == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_applist,");
            sb.append(context.getPackageName());
            enableApplist = Boolean.valueOf(PushPreferences.getInt(context, sb.toString(), 1) != 0);
        }
        if (a.a(context).F == -1) {
            return enableApplist.booleanValue();
        }
        return a.a(context).F == 1;
    }

    public static void setReportNotificationStatusEnable(Context context, boolean z) {
        Boolean bool = enableNotification;
        if (bool == null || bool.booleanValue() != z) {
            enableNotification = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_NOTIICATION," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static void enablePullUpOtherApp(Context context, boolean z) {
        if (context == null) {
            TLogger.ww("XGPushConfig", "context is null");
            return;
        }
        Boolean bool = f;
        if (bool == null || z != bool.booleanValue()) {
            f = Boolean.valueOf(z);
            TLogger.d("XGPushConfig", "action - enablePullUpOtherApp:" + z);
            PushPreferences.putBoolean(context, "pull.up.other.app", z);
        }
    }

    public static boolean isReportNotificationStatusEnable(Context context) {
        if (enableNotification == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_NOTIICATION,");
            sb.append(context.getPackageName());
            enableNotification = Boolean.valueOf(PushPreferences.getInt(context, sb.toString(), 1) != 0);
        }
        if (a.a(context).G == -1) {
            return enableNotification.booleanValue();
        }
        return a.a(context).G == 1;
    }

    public static List<Long> getAccessidList(Context context) {
        ArrayList arrayList = new ArrayList(2);
        if (context == null) {
            return arrayList;
        }
        long accessId = getAccessId(context);
        if (accessId > 0) {
            arrayList.add(Long.valueOf(accessId));
        }
        long qQAccessId = XGPush4Msdk.getQQAccessId(context);
        if (qQAccessId > 0) {
            arrayList.add(Long.valueOf(qQAccessId));
        }
        Object metaData = CommonHelper.getMetaData(context, "XG_V2_ACCESS_ID", null);
        if (metaData != null) {
            try {
                long longValue = Long.valueOf(metaData.toString()).longValue();
                if (!arrayList.contains(Long.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                }
            } catch (Throwable th) {
                TLogger.w("XGPushConfig", "get accessId from getMetaData failed: ", th);
            }
        }
        return arrayList;
    }

    public static void setInstallChannel(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            a = str;
        }
    }

    public static String getInstallChannel(Context context) {
        return a;
    }

    public static void setGameServer(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            b = str;
        }
    }

    public static String getGameServer(Context context) {
        return b;
    }

    public static void setImei(Context context, String str) {
        d = str;
    }

    public static void setStatAutoPage(Context context, boolean z) {
        c = z;
    }

    public static boolean getStatAutoPage(Context context) {
        return c;
    }

    public static String getFacilityImei(Context context) {
        return d;
    }

    public static void setHeartbeatIntervalMs(Context context, int i) {
        if (context != null && i >= 5000 && i < 1800000) {
            try {
                SharePrefsUtil.setInt(context, "com.tencent.android.xg.wx.HeartbeatIntervalMs", i);
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "setHeartbeatIntervalMs", th);
            }
        }
    }

    public static boolean isUsedOtherPush(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (isUsedOtherPush == null) {
            if (PushPreferences.getInt(context, "com.tencent.android.tpush.other.push," + context.getPackageName(), 0) != 0) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            isUsedOtherPush = valueOf;
            if (!valueOf.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(com.tencent.android.tpush.d.d.a(context).b());
            }
            if (!isUsedOtherPush.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(j.n(context));
            }
        }
        TLogger.v("XGPushConfig", "isUsedOtherPush:" + isUsedOtherPush);
        return isUsedOtherPush.booleanValue();
    }

    public static void enableOtherPush(Context context, boolean z) {
        if (context != null) {
            Boolean bool = isUsedOtherPush;
            if (bool == null || bool.booleanValue() != z) {
                isUsedOtherPush = Boolean.valueOf(z);
                PushPreferences.putInt(context, "com.tencent.android.tpush.other.push," + context.getPackageName(), z ? 1 : 0);
                setNotTryFcm(context, z);
            }
        }
    }

    public static boolean isUsedFcmPush(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (isUsedFcmPush == null) {
            if (PushPreferences.getInt(context, "com.tencent.android.tpush.fcm," + context.getPackageName(), 0) != 0) {
                z = true;
            }
            isUsedFcmPush = Boolean.valueOf(z);
        }
        return isUsedFcmPush.booleanValue();
    }

    public static void enableFcmPush(Context context, boolean z) {
        if (context != null) {
            Boolean bool = isUsedFcmPush;
            if (bool == null || bool.booleanValue() != z) {
                isUsedFcmPush = Boolean.valueOf(z);
                PushPreferences.putInt(context, "com.tencent.android.tpush.fcm," + context.getPackageName(), z ? 1 : 0);
                setNotTryFcm(context, z);
            }
        }
    }

    public static void setNotTryFcm(Context context, boolean z) {
        if (context != null) {
            Boolean bool = fcmIsSuccess;
            if (bool == null || bool.booleanValue() != z) {
                fcmIsSuccess = Boolean.valueOf(z);
                PushPreferences.putInt(context, "com.tencent.android.tpush.fcm.success," + context.getPackageName(), z ? 1 : 0);
            }
        }
    }

    public static boolean isNotTryFcm(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (fcmIsSuccess == null) {
            if (PushPreferences.getInt(context, "com.tencent.android.tpush.fcm.success," + context.getPackageName(), 0) != 0) {
                z = true;
            }
            fcmIsSuccess = Boolean.valueOf(z);
        }
        return fcmIsSuccess.booleanValue();
    }

    public static void setNotificationChannelID(Context context, String str) {
        if (context != null) {
            notificationChannelID = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelID", str);
        }
    }

    public static String getNotificationChannelID(Context context) {
        if (context == null) {
            return null;
        }
        String str = notificationChannelID;
        if (str != null && !TextUtils.isEmpty(str)) {
            return notificationChannelID;
        }
        String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelID", "");
        notificationChannelID = string;
        return string;
    }

    public static void setNotificationChannelName(Context context, String str) {
        if (context != null) {
            notificationChannelName = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelName", str);
        }
    }

    public static String getNotificationChannelName(Context context) {
        if (context == null) {
            return null;
        }
        String str = notificationChannelName;
        if (str != null && !TextUtils.isEmpty(str)) {
            return notificationChannelName;
        }
        String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelName", "");
        notificationChannelName = string;
        return string;
    }

    public static void setReportDebugMode(Context context, boolean z) {
        if (context != null) {
            PushPreferences.putInt(context, context.getPackageName() + ".report.mode", z ? 1 : 0);
        }
    }

    public static boolean getReportDebugMode(Context context) {
        if (PushPreferences.getInt(context, context.getPackageName() + ".report.mode", 0) != 0) {
            return true;
        }
        return false;
    }

    public static void setMiPushAppId(Context context, String str) {
        com.tencent.android.tpush.d.d.a(context, str);
    }

    public static void setMiPushAppKey(Context context, String str) {
        com.tencent.android.tpush.d.d.b(context, str);
    }

    public static void setMzPushAppId(Context context, String str) {
        com.tencent.android.tpush.d.d.c(context, str);
    }

    public static void setMzPushAppKey(Context context, String str) {
        com.tencent.android.tpush.d.d.d(context, str);
    }

    public static void setOppoPushAppId(Context context, String str) {
        com.tencent.android.tpush.d.d.e(context, str);
    }

    public static void setOppoPushAppKey(Context context, String str) {
        com.tencent.android.tpush.d.d.f(context, str);
    }

    public static void enableOppoNotification(Context context, boolean z) {
        com.tencent.android.tpush.d.d.a(context, z);
    }

    public static void setfcmSenderId(Context context, String str) {
        com.tencent.android.tpush.d.a.b(context, str);
    }

    public static boolean isForeiginPush(Context context) {
        if (g == null) {
            try {
                Object metaData = CommonHelper.getMetaData(context, "TPUSH_IS_FOREIGINPUSH", null);
                if (metaData == null) {
                    Boolean bool = false;
                    g = bool;
                    return bool.booleanValue();
                } else if ("true".equals(metaData.toString())) {
                    g = true;
                } else {
                    g = false;
                }
            } catch (Throwable unused) {
                g = false;
            }
        }
        return g.booleanValue();
    }

    public static void setHuaweiDebug(boolean z) {
        _isHuaweiDebug = z;
    }

    public static boolean isHuaweiDebug() {
        return _isHuaweiDebug;
    }

    public static void enableHuaweiV3Update(Context context, boolean z) {
        if (!z || context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            TLogger.i("XGPushConfig", "enableHuaweiV3Update context not instanceof Activity, would not update");
        } else if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            try {
                Class<?> cls = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
                cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, context);
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "enableHuaweiV3Update error, not find Hms V3 Sdk", th);
            }
        } else {
            TLogger.i("XGPushConfig", "enableHuaweiV3Update not Huawei device");
        }
    }

    public static void resetHuaweiBadgeNum(Context context) {
        c.a(context);
    }

    public static void changeHuaweiBadgeNum(Context context, int i) {
        c.a(context, i);
    }

    public static void setBadgeNum(Context context, int i) {
        c.c(context, i);
    }

    public static void resetBadgeNum(Context context) {
        c.b(context);
    }

    public static void setOPPOBadgeNum(Context context, int i) {
        c.d(context, i);
    }

    public static void setVivoBadgeNum(Context context, int i) {
        c.e(context, i);
    }

    public static void setHuaweiBadgeNum(Context context, int i) {
        c.b(context, i);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        MqttConfig.setForeignWeakAlarmMode(context, z);
    }

    public static void setPowerSaveMode(Context context, boolean z) {
        XGApiConfig.setPowerSaveMode(context, z);
    }

    public static void setNotificationShowEnable(Context context, boolean z) {
        if (context != null) {
            try {
                if (h == null) {
                    h = context.getSharedPreferences("xg.vip.app.shareprefs", 0);
                }
                SharedPreferences.Editor edit = h.edit();
                edit.putBoolean(Util.getKey("com.tencent.android.tpush.enable_SHOW_NOTIFICATION"), z);
                edit.commit();
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "setNotificationShowEnable", th);
            }
        }
    }

    public static boolean isNotificationShowEnable(Context context) {
        if (context != null) {
            try {
                if (h == null) {
                    h = context.getSharedPreferences("xg.vip.app.shareprefs", 0);
                }
                return h.getBoolean(Util.getKey("com.tencent.android.tpush.enable_SHOW_NOTIFICATION"), true);
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "isNotificationShowEnable", th);
            }
        }
        return true;
    }

    public static String getOtherPushToken(Context context) {
        try {
            return com.tencent.android.tpush.d.d.a(context).f();
        } catch (Throwable th) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th);
            return null;
        }
    }

    public static String getOtherPushType(Context context) {
        try {
            return com.tencent.android.tpush.d.d.a(context).i();
        } catch (Throwable th) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th);
            return null;
        }
    }

    public static String getOtherPushErrCode(Context context) {
        if (context == null) {
            return "errCode : -102 , errMsg : context == null";
        }
        try {
            Boolean valueOf = Boolean.valueOf(isUsedOtherPush(context));
            isUsedOtherPush = valueOf;
            if (!valueOf.booleanValue()) {
                return "errCode : -101 , errMsg : Manufacturer channel is not opened";
            }
            return SharePrefsUtil.getString(context, "other_push_error_code", "errCode : -100 , errMsg : unknown");
        } catch (Throwable th) {
            TLogger.dd("XGPushConfig", "getOtherPushErrCode error: " + th.getMessage());
            return "";
        }
    }

    public static void setServerIpList(Context context, XGServerInfo xGServerInfo) {
        if (context != null && xGServerInfo != null) {
            PushPreferences.putString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", xGServerInfo.getIpArray().toString());
        }
    }

    public static XGServerInfo getServerIpList(Context context) {
        if (context != null) {
            return new XGServerInfo(PushPreferences.getString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", null));
        }
        return null;
    }

    public static Build init(Context context) {
        if (context != null) {
            return new Build(context);
        }
        TLogger.ee("XGPushConfig", "context is null");
        return null;
    }

    /* compiled from: ProGuard */
    public static class Build {
        private Context context;

        public Build(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Build enableDebug(boolean z) {
            XGPushConfig.enableDebug(this.context, z);
            return this;
        }

        public Build setLogLevel(final int i) {
            TBaseLogger.setDebugLevel(i);
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.XGPushConfig.Build.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = Build.this.context;
                        PushPreferences.putInt(context, "com.tencent.android.tpush.log_level," + Build.this.context.getPackageName(), i);
                    } catch (Throwable th) {
                        TLogger.w("XGPushConfig", "XGPushConfig.Build.setLogLevel sharedPf put error " + th.toString());
                    }
                }
            });
            return this;
        }

        public Build enableOtherPush(boolean z) {
            XGPushConfig.enableOtherPush(this.context, z);
            return this;
        }

        public Build enableFcmPush(boolean z) {
            XGPushConfig.enableOtherPush(this.context, z);
            return this;
        }

        public Build setMiPushAppId(String str) {
            XGPushConfig.setMiPushAppId(this.context, str);
            return this;
        }

        public Build setMiPushAppKey(String str) {
            XGPushConfig.setMiPushAppKey(this.context, str);
            return this;
        }

        public Build setMzPushAppId(String str) {
            XGPushConfig.setMzPushAppId(this.context, str);
            return this;
        }

        public Build setMzPushAppKey(String str) {
            XGPushConfig.setMzPushAppKey(this.context, str);
            return this;
        }

        public Build setOppoPushAppId(String str) {
            XGPushConfig.setOppoPushAppId(this.context, str);
            return this;
        }

        public Build setOppoPushAppKey(String str) {
            XGPushConfig.setOppoPushAppKey(this.context, str);
            return this;
        }

        public Build setHuaweiDebug(boolean z) {
            XGPushConfig.setHuaweiDebug(z);
            return this;
        }
    }
}
