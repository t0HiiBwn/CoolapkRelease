package com.tencent.tpns.mqttchannel.core.common.c;

import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

/* compiled from: ProGuard */
public class a {
    public static void a(String str, String str2) {
        TBaseLogger.d("Mqtt-TPush - " + str, str2);
    }

    public static void b(String str, String str2) {
        TBaseLogger.i("Mqtt-TPush - " + str, str2);
    }

    public static void c(String str, String str2) {
        TBaseLogger.ii("Mqtt-TPush - " + str, str2);
    }

    public static void d(String str, String str2) {
        TBaseLogger.w("Mqtt-TPush - " + str, str2);
    }

    public static void e(String str, String str2) {
        TBaseLogger.e("Mqtt-TPush - " + str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        TBaseLogger.e("Mqtt-TPush - " + str, str2, th);
    }
}
