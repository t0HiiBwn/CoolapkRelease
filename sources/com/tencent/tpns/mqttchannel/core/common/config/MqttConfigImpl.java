package com.tencent.tpns.mqttchannel.core.common.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.mqttchannel.core.common.c.a;

/* compiled from: ProGuard */
public class MqttConfigImpl {
    public static final int DEFAULT_KEEP_ALIVE_INTERVAL = 285;
    private static Integer a;

    public static long getAccessId(Context context) {
        return XGApiConfig.getAccessId(context);
    }

    public static void setAccessId(Context context, long j) {
        XGApiConfig.setAccessId(context, j);
    }

    public static String getAccessKey(Context context) {
        return XGApiConfig.getAccessKey(context);
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static String getServerAddr(Context context) {
        String string = PushPreferences.getString(context, "MQTT_HOST", null);
        return TextUtils.isEmpty(string) ? "tcp://127.0.0.1:1883" : string;
    }

    public static void setServerAddr(Context context, String str) {
        PushPreferences.putString(context, "MQTT_HOST", str);
    }

    public static boolean setKeepAliveInterval(Context context, int i) {
        if (i < 10 || i > 36000) {
            return false;
        }
        PushPreferences.putInt(context, "MQTT_KEEPALIVE_INTERVAL", i);
        return true;
    }

    public static int getKeepAliveInterval(Context context) {
        try {
            int interval = CloudManager.getInstance(context).getInterval() / 1000;
            if (interval >= 60) {
                a = Integer.valueOf(interval);
            }
            if (a == null) {
                if (a(context)) {
                    a.b("MqttConfigImpl", "isForeignWeakAlarmMode KeepAlive set to : 3600");
                    return 3600;
                }
                Integer valueOf = Integer.valueOf(PushPreferences.getInt(context, "MQTT_KEEPALIVE_INTERVAL", 0));
                a = valueOf;
                if (valueOf.intValue() == 0) {
                    a = 285;
                }
            }
            return a.intValue();
        } catch (Throwable unused) {
            return 285;
        }
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        PushPreferences.putInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), z ? 1 : 0);
    }

    private static boolean a(Context context) {
        Object metaData;
        int i = PushPreferences.getInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), -1);
        if (i == -1 && (metaData = CommonHelper.getMetaData(context, "XG_WEAK_ALARM", null)) != null) {
            if (metaData.toString().equals("true")) {
                i = 1;
            }
            a.e("MqttConfigImpl", "getMetaData key:" + i);
        }
        if (i == 1) {
            return true;
        }
        return false;
    }
}
