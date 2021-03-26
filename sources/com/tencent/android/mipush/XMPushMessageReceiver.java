package com.tencent.android.mipush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XMPushMessageReceiver extends PushMessageReceiver {
    private static String errMsg;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
        } catch (ClassNotFoundException unused) {
            Log.w("TPush", "[OtherPush_XG_MI] find XGVipPushService error");
            str = "com.tencent.android.tpush.action.PUSH_MESSAGE";
        }
        try {
            Log.i("TPush", "[OtherPush_XG_MI] onReceivePassThroughMessage->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra("PUSH.CHANNEL", 103);
            intent.putExtra("pushChannel", 103);
            intent.putExtra("content", miPushMessage.getContent());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", (Serializable) 2L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str3 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey("busiMsgId") && (str2 = miPushMessage.getExtra().get("busiMsgId")) != null) {
                    intent.putExtra("busiMsgId", Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e("TPush", "[OtherPush_XG_MI] onReceivePassThroughMessage ", th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException unused) {
            Log.w("TPush", "[OtherPush_XG_MI] find XGVipPushService error");
            str = "com.tencent.android.tpush.action.FEEDBACK";
        }
        try {
            Log.i("TPush", "[OtherPush_XG_MI] onNotificationMessageArrived->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + " Extra = " + miPushMessage.getExtra().toString() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra("TPUSH.FEEDBACK", 5);
            intent.putExtra("pushChannel", 103);
            intent.putExtra("PUSH.CHANNEL", 103);
            intent.putExtra("content", miPushMessage.getDescription());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", (Serializable) 1L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str5 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str5));
                }
                if (miPushMessage.getExtra().containsKey("busiMsgId") && (str4 = miPushMessage.getExtra().get("busiMsgId")) != null) {
                    intent.putExtra("busiMsgId", Long.valueOf(str4));
                }
                if (miPushMessage.getExtra().containsKey("ts")) {
                    String str6 = miPushMessage.getExtra().get("ts");
                    if (str6 != null) {
                        intent.putExtra("pushTime", Long.valueOf(str6));
                    } else {
                        intent.putExtra("pushTime", System.currentTimeMillis());
                    }
                } else {
                    intent.putExtra("pushTime", System.currentTimeMillis());
                }
                if (miPushMessage.getExtra().containsKey("groupId")) {
                    intent.putExtra("groupId", miPushMessage.getExtra().get("groupId"));
                }
                if (miPushMessage.getExtra().containsKey("targetType") && (str3 = miPushMessage.getExtra().get("targetType")) != null) {
                    intent.putExtra("targetType", Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey("source") && (str2 = miPushMessage.getExtra().get("source")) != null) {
                    intent.putExtra("source", Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e("TPush", "[OtherPush_XG_MI] onNotificationMessageArrived ", th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String str;
        long resultCode;
        String str2;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException unused) {
            Log.w("TPush", "[OtherPush_XG_MI] find XGVipPushService error");
            str = "com.tencent.android.tpush.action.FEEDBACK";
        }
        try {
            Intent intent = new Intent(str);
            String command = miPushCommandMessage.getCommand();
            Log.i("TPush", "[OtherPush_XG_MI] onCommandResult - command: " + command + ", result code: " + miPushCommandMessage.getResultCode());
            List<String> commandArguments = miPushCommandMessage.getCommandArguments();
            String str3 = null;
            String str4 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
            if (commandArguments != null && commandArguments.size() > 1) {
                str3 = commandArguments.get(1);
            }
            String str5 = "";
            if ("register".equals(command)) {
                String str6 = "errCode : " + miPushCommandMessage.getResultCode() + ", errMsg : unknown";
                if (miPushCommandMessage.getResultCode() == 0) {
                    intent.putExtra("TPUSH.ERRORCODE", 0);
                    Log.i("TPush", "[OtherPush_XG_MI] register success， regid is ：" + str4);
                    str2 = "errCode : 0, errMsg : success";
                } else {
                    if (miPushCommandMessage.getResultCode() == 70000002) {
                        intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                        Log.i("TPush", "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                    } else if (miPushCommandMessage.getResultCode() == 70000004) {
                        intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                        Log.i("TPush", "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                    } else if (miPushCommandMessage.getResultCode() == 70000003) {
                        intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                        Log.i("TPush", "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                    } else if (miPushCommandMessage.getResultCode() == 70000001) {
                        intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                        Log.i("TPush", "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                    } else {
                        intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                        Log.w("TPush", "[OtherPush_XG_MI] register failed, errorCode: " + miPushCommandMessage.getResultCode() + ", reason: " + miPushCommandMessage.getReason());
                    }
                    str2 = str6;
                    str4 = str5;
                }
                try {
                    SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tpush.vip.shareprefs", 0);
                    String str7 = errMsg;
                    if (str7 == null || str7.length() <= 0) {
                        try {
                            errMsg = sharedPreferences.getString(md5("other_push_error_code"), str5);
                        } catch (Throwable th) {
                            Log.d("TPush", "[OtherPush_XG_MI] onCommandResult read returnMsg from sp error: " + th.getMessage());
                        }
                    }
                    if (str2 != null && !str2.equals(errMsg)) {
                        errMsg = str2;
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(md5("other_push_error_code"), str2);
                        edit.commit();
                    }
                } catch (Throwable th2) {
                    Log.w("TPush", "[OtherPush_XG_MI] onCommandResult save result errMsg error: " + th2.getMessage());
                }
                str5 = str4;
            } else {
                if ("set-alias".equals(command)) {
                    resultCode = miPushCommandMessage.getResultCode();
                } else if ("unset-alias".equals(command)) {
                    resultCode = miPushCommandMessage.getResultCode();
                } else if ("subscribe-topic".equals(command)) {
                    resultCode = miPushCommandMessage.getResultCode();
                } else if ("unsubscibe-topic".equals(command)) {
                    resultCode = miPushCommandMessage.getResultCode();
                } else if ("accept-time".equals(command)) {
                    miPushCommandMessage.getResultCode();
                }
                int i = (resultCode > 0 ? 1 : (resultCode == 0 ? 0 : -1));
            }
            intent.putExtra("other_push_token", str5);
            intent.putExtra("TPUSH.FEEDBACK", 1);
            intent.putExtra("PUSH.CHANNEL", 103);
            intent.putExtra("pushChannel", 103);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th3) {
            Log.w("TPush", "[OtherPush_XG_MI] onCommandResult ", th3);
        }
    }

    private static String md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
