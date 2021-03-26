package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

/* compiled from: ProGuard */
public class MqttConfig {
    public static long getAccessId(Context context) {
        return MqttConfigImpl.getAccessId(context);
    }

    public static void setAccessId(Context context, long j) {
        MqttConfigImpl.setAccessId(context, j);
    }

    public static String getAccessKey(Context context) {
        return MqttConfigImpl.getAccessKey(context);
    }

    public static void setAccessKey(Context context, String str) {
        MqttConfigImpl.setAccessKey(context, str);
    }

    public static void setServerAddr(Context context, String str) {
        MqttConfigImpl.setServerAddr(context, str);
    }

    public static void setKeepAliveInterval(Context context, int i) {
        MqttConfigImpl.setKeepAliveInterval(context, i);
    }

    public static int getKeepAliveInterval(Context context) {
        return MqttConfigImpl.getKeepAliveInterval(context);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        MqttConfigImpl.setForeignWeakAlarmMode(context, z);
    }
}
