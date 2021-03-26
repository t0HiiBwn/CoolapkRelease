package com.tencent.tpns.baseapi.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.b.a;

/* compiled from: ProGuard */
public class a {
    private static volatile long a = -1;
    private static volatile String b = "";
    private static volatile long c = -1;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static int j = -1;

    public static synchronized long a(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                return a;
            }
            if (a != -1) {
                return a;
            }
            a = PushPreferences.getLong(context, "XG_V2_ACCESS_ID", -1);
            if (a == -1 && (metaData = CommonHelper.getMetaData(context, "XG_V2_ACCESS_ID", null)) != null) {
                try {
                    a = Long.valueOf(metaData.toString()).longValue();
                } catch (Throwable th) {
                    Logger.w("XGApiConfigImpl", "get accessId from getMetaData failed: ", th);
                    a = -1;
                }
            }
            if (a == -1) {
                Logger.e("XGApiConfigImpl", "accessId没有初始化");
            }
            return a;
        }
    }

    public static synchronized void a(final Context context, final long j2) {
        synchronized (a.class) {
            if (context == null) {
                Logger.e("XGApiConfigImpl", "null  context");
                return;
            }
            a = j2;
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.tpns.baseapi.core.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    PushPreferences.putLong(context, "XG_V2_ACCESS_ID", j2);
                }
            });
        }
    }

    public static synchronized String b(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (!Util.isNullOrEmptyString(b)) {
                return b;
            }
            b = PushPreferences.getString(context, "XG_V2_ACCESS_KEY", null);
            if (Util.isNullOrEmptyString(b) && (metaData = CommonHelper.getMetaData(context, "XG_V2_ACCESS_KEY", null)) != null) {
                b = metaData.toString();
            }
            if (Util.isNullOrEmptyString(b)) {
                Logger.e("XGApiConfigImpl", "accessKey is null");
            }
            return b;
        }
    }

    public static synchronized void a(final Context context, final String str) {
        synchronized (a.class) {
            if (context == null || str == null) {
                Logger.e("XGApiConfigImpl", "null context or null accessKey");
                return;
            }
            b = str;
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.tpns.baseapi.core.a.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    PushPreferences.putString(context, "XG_V2_ACCESS_KEY", str);
                }
            });
        }
    }

    public static String c(Context context) {
        Object metaData;
        Object metaData2;
        if (TextUtils.isEmpty(d)) {
            d = PushPreferences.getString(context, "XG_SERVER_SUFFIX", null);
        }
        if (TextUtils.isEmpty(d) && (metaData2 = CommonHelper.getMetaData(context, "XG_SERVER_SUFFIX", null)) != null) {
            d = metaData2.toString();
        }
        if (TextUtils.isEmpty(d)) {
            try {
                String string = PushPreferences.getString(context, "XG_GUID_SERVER", null);
                if (TextUtils.isEmpty(string) && (metaData = CommonHelper.getMetaData(context, "XG_GUID_SERVER", null)) != null) {
                    string = metaData.toString();
                }
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains(a.EnumC0157a.CLUSTER_SGP.a())) {
                        d = a.EnumC0157a.CLUSTER_SGP.b();
                    } else if (string.contains(a.EnumC0157a.CLUSTER_HK.a())) {
                        d = a.EnumC0157a.CLUSTER_HK.b();
                    } else {
                        Logger.w("XGApiConfigImpl", "unexpected serverSuffix from old version config: " + string);
                    }
                }
            } catch (Throwable th) {
                Logger.w("XGApiConfigImpl", "getServerSuffix from old version config error: " + th.toString());
            }
        }
        if (TextUtils.isEmpty(d)) {
            d = "tpns.tencent.com";
        }
        return d;
    }

    public static void b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(c(context))) {
            PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
            Logger.w("XGApiConfigImpl", "refresh Token");
            d = str;
            e = null;
            f = null;
            h = null;
            i = null;
            PushPreferences.putString(context, "XG_SERVER_SUFFIX", str);
        }
    }

    public static String d(Context context) {
        String str;
        String guid = CloudManager.getInstance(context).getGuid();
        if (!TextUtils.isEmpty(guid)) {
            str = "https://guid." + guid + "/guid/v3/guid_and_mqtt_info";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = PushPreferences.getString(context, "XG_GUID_SERVER", null);
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://guid." + c(context) + "/guid/v3/guid_and_mqtt_info";
        }
        return TextUtils.isEmpty(str) ? "https://api.tpns.tencent.com/guid/api/GetGuidAndMqttServer" : str;
    }

    public static void c(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String d2 = d(context);
            if (d2 != null && !d2.equals(str)) {
                PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
                Logger.w("XGApiConfigImpl", "refresh Token");
            }
            PushPreferences.putString(context, "XG_GUID_SERVER", str);
        }
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(e)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                e = "https://stat." + stat + "/log/statistics/push";
            }
        }
        if (TextUtils.isEmpty(e)) {
            e = PushPreferences.getString(context, "XG_STAT_SERVER", null);
        }
        if (TextUtils.isEmpty(e)) {
            String c2 = c(context);
            e = "https://stat." + c2 + "/log/statistics/push";
        }
        if (TextUtils.isEmpty(e)) {
            e = "https://stat.api.tpns.tencent.com/log/statistics/push";
        }
        return e;
    }

    public static void d(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(e(context))) {
            e = str;
            PushPreferences.putString(context, "XG_STAT_SERVER", str);
        }
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                f = "https://log." + stat + "/log/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f)) {
            f = PushPreferences.getString(context, "XG_ERRCODE_SERVER", null);
        }
        if (TextUtils.isEmpty(f)) {
            String c2 = c(context);
            f = "https://log." + c2 + "/log/statistics/push";
        }
        if (TextUtils.isEmpty(f)) {
            f = "https://log.tpns.tencent.com/log/statistics/push";
        }
        return f;
    }

    public static void e(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f(context))) {
            f = str;
            PushPreferences.putString(context, "XG_ERRCODE_SERVER", str);
        }
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(g)) {
            String custom = CloudManager.getInstance(context).getCustom();
            if (!TextUtils.isEmpty(custom)) {
                g = "https://log." + custom + "/log/statistics/push";
            }
        }
        if (TextUtils.isEmpty(g)) {
            g = PushPreferences.getString(context, "XG_CUSTOMEVEN_SERVER", null);
        }
        if (TextUtils.isEmpty(g)) {
            String c2 = c(context);
            g = "https://log." + c2 + "/log/statistics/push";
        }
        if (TextUtils.isEmpty(g)) {
            g = "https://stat.api.tpns.tencent.com/log/statistics/push";
        }
        return g;
    }

    public static void f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(g(context))) {
            g = str;
            PushPreferences.putString(context, "XG_CUSTOMEVEN_SERVER", str);
        }
    }

    public static void g(Context context, String str) {
        PushPreferences.putString(context, "XG_GUID_SERVER", str);
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(h)) {
            String log = CloudManager.getInstance(context).getLog();
            if (!TextUtils.isEmpty(log)) {
                h = "https://stat." + log + "/v3/mobile/log/upload";
            }
        }
        if (TextUtils.isEmpty(h)) {
            String c2 = c(context);
            h = "https://stat." + c2 + "/v3/mobile/log/upload";
        }
        if (TextUtils.isEmpty(h)) {
            h = "https://stat.api.tpns.tencent.com/v3/mobile/log/upload";
        }
        return h;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(i)) {
            String c2 = c(context);
            i = "https://log." + c2 + "/device/api/GetOfflineMsg";
        }
        return i;
    }

    public static void a(Context context, boolean z) {
        try {
            PushPreferences.putBoolean(context, "IS_POWER_SAVE_MODE", z);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "setPowerSaveMode Throwable: " + th);
        }
    }

    public static boolean j(Context context) {
        try {
            return PushPreferences.getBoolean(context, "IS_POWER_SAVE_MODE", false);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "isPowerSaveMode Throwable: " + th);
            return false;
        }
    }

    public static synchronized long k(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                return c;
            }
            if (c != -1) {
                return c;
            }
            if (c == -1 && (metaData = CommonHelper.getMetaData(context, "XG_OLD_ACCESS_ID", null)) != null) {
                try {
                    c = Long.valueOf(metaData.toString().replace("L", "")).longValue();
                } catch (Throwable th) {
                    Logger.w("XGApiConfigImpl", "get freeVersionAccessId from getMetaData failed: ", th);
                    c = -1;
                }
            }
            if (c == -1) {
                Logger.d("XGApiConfigImpl", "Not set freeVersionAccessId");
            }
            return c;
        }
    }

    public static boolean l(Context context) {
        if (context == null) {
            return true;
        }
        try {
            int i2 = PushMd5Pref.getInt(context, context.getPackageName() + ".enableService", j);
            j = i2;
            return i2 != 0;
        } catch (Throwable unused) {
            Logger.w("XGApiConfigImpl", "unexpected for isEnableService");
            return true;
        }
    }

    public static void m(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", true);
            PushPreferences.putLong(context, "REGISTERED_TIME", currentTimeMillis);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for setRegisterSuccess: " + th.getMessage());
        }
    }

    public static void n(Context context) {
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", false);
            PushPreferences.putLong(context, "REGISTERED_TIME", 0);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for clearRegistered: " + th.getMessage());
        }
    }

    public static boolean o(Context context) {
        if (p(context)) {
            return false;
        }
        try {
            return PushPreferences.getBoolean(context, "IS_REGISTERED", false);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegistered: " + th.getMessage());
            return false;
        }
    }

    private static boolean p(Context context) {
        try {
            if (System.currentTimeMillis() - PushPreferences.getLong(context, "REGISTERED_TIME", 0) > 3600000) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegisterExpire: " + th.getMessage());
            return true;
        }
    }
}
