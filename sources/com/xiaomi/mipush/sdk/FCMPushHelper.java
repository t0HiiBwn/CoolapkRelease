package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;

public class FCMPushHelper {
    public static void clearToken(Context context) {
        h.m93a(context, d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return h.m95a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = h.a(context)) != null) {
            a.onNotificationMessageArrived(context, h.a(str));
        }
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = h.a(context)) != null) {
            a.onReceivePassThroughMessage(context, h.a(str));
        }
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(h.b(d.ASSEMBLE_PUSH_FCM), "fcm", 1, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        h.a(context, d.ASSEMBLE_PUSH_FCM, str);
    }
}
