package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SelfShow */
public class m {
    public static void a(Context context, Intent intent) {
        if (context == null || intent == null) {
            HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
            return;
        }
        try {
            String action = intent.getAction();
            if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                if (byteArrayExtra.length != 0) {
                    if (byteArrayExtra2.length != 0) {
                        String stringExtra = intent.getStringExtra("selfshow_event_id");
                        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
                        HMSLog.i("PushSelfShowLog", "get notifyId:" + intExtra);
                        a(context, intent, byteArrayExtra, byteArrayExtra2, stringExtra, intExtra);
                        return;
                    }
                }
                HMSLog.i("PushSelfShowLog", "self show info or token is null.");
            }
        } catch (RuntimeException e) {
            HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
        } catch (Exception unused) {
            HMSLog.d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    private static void a(Context context, Intent intent, byte[] bArr, byte[] bArr2, String str, int i) {
        o oVar = new o(bArr, bArr2);
        if (!oVar.b()) {
            HMSLog.d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.i("PushSelfShowLog", " onReceive the msg id = " + oVar.a() + ",and cmd is" + oVar.j() + ",and the eventId is " + str);
        if (str == null) {
            a(context, intent, oVar);
        } else {
            a(context, intent, str, oVar, i);
        }
    }

    private static void a(Context context, Intent intent, o oVar) {
        HMSLog.i("PushSelfShowLog", "receive a selfshow message ,the type is" + oVar.j());
        if (n.a(oVar.j())) {
            long a = u.a(oVar.h());
            if (a == 0) {
                new t(context, oVar).start();
                return;
            }
            HMSLog.d("PushSelfShowLog", "waiting ……");
            intent.setPackage(context.getPackageName());
            u.a(context, intent, a);
        }
    }

    private static void a(Context context, Intent intent, String str, o oVar, int i) {
        HMSLog.d("PushSelfShowLog", "receive a selfshow userhandle message");
        if (!"-1".equals(str)) {
            u.b(context, intent);
        } else {
            u.a(context, i);
        }
        if ("1".equals(str)) {
            new n(context, oVar).a();
            k.a(context, "1", String.valueOf(i), oVar);
        } else if ("2".equals(str)) {
            k.a(context, "2", String.valueOf(i), oVar);
        } else {
            HMSLog.d("PushSelfShowLog", "other event");
        }
    }
}
