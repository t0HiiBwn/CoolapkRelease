package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.gv;
import com.xiaomi.push.hm;
import java.util.List;

public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(hm hmVar, gv gvVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(hmVar.c());
        if (!TextUtils.isEmpty(hmVar.j())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(hmVar.j());
        } else if (!TextUtils.isEmpty(hmVar.h())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(hmVar.h());
        } else if (!TextUtils.isEmpty(hmVar.r())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(hmVar.r());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(hmVar.p());
        if (hmVar.l() != null) {
            miPushMessage.setContent(hmVar.l().f());
        }
        if (gvVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(gvVar.b());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(gvVar.f());
            }
            miPushMessage.setDescription(gvVar.j());
            miPushMessage.setTitle(gvVar.h());
            miPushMessage.setNotifyType(gvVar.l());
            miPushMessage.setNotifyId(gvVar.q());
            miPushMessage.setPassThrough(gvVar.o());
            miPushMessage.setExtra(gvVar.s());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static gv generateMessage(MiPushMessage miPushMessage) {
        gv gvVar = new gv();
        gvVar.a(miPushMessage.getMessageId());
        gvVar.b(miPushMessage.getTopic());
        gvVar.d(miPushMessage.getDescription());
        gvVar.c(miPushMessage.getTitle());
        gvVar.c(miPushMessage.getNotifyId());
        gvVar.a(miPushMessage.getNotifyType());
        gvVar.b(miPushMessage.getPassThrough());
        gvVar.a(miPushMessage.getExtra());
        return gvVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
