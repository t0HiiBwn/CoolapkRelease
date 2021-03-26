package com.huawei.android.hms.tpns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import java.io.Serializable;
import java.security.MessageDigest;

public class HWHmsMessageService extends HmsMessageService {
    private static String token;

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        String str2;
        super.onNewToken(str);
        Log.i("TPush", "[XG_HWPUSH_V3] otherpush huawei register onNewToken: " + str);
        int i = 0;
        if (!(str == null || str.length() == 0)) {
            try {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("tpush.vip.shareprefs", 0);
                String str3 = token;
                if (str3 == null || str3.length() <= 0) {
                    token = sharedPreferences.getString(md5("huawei_token"), "");
                }
                if (!str.equals(token)) {
                    token = str;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(md5("huawei_token"), str);
                    edit.commit();
                }
            } catch (Throwable th) {
                Log.e("TPush", "[XG_HWPUSH_V3] otherpush huawei save newToken error: " + th.getMessage());
            }
        }
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str2 = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException e) {
            Log.w("TPush", "[XG_HWPUSH_V3] onNewToken:" + e.getMessage());
            str2 = "com.tencent.android.tpush.action.FEEDBACK";
        }
        try {
            Intent intent = new Intent(str2);
            if (str == null) {
                i = -1;
            }
            intent.putExtra("TPUSH.ERRORCODE", i);
            intent.putExtra("other_push_token", str);
            intent.putExtra("TPUSH.FEEDBACK", 1);
            intent.putExtra("PUSH.CHANNEL", 102);
            intent.setPackage(getApplicationContext().getPackageName());
            getApplicationContext().sendBroadcast(intent);
        } catch (Throwable th2) {
            Log.w("TPush", "[XG_HWPUSH_V3] onNewToken:" + th2.getMessage());
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        super.onMessageReceived(remoteMessage);
        Log.w("TPush", "[XG_HWPUSH_V3] On messageReceived: " + remoteMessage.getMessageId() + ", " + remoteMessage.getMessageType());
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
        } catch (ClassNotFoundException e) {
            Log.w("TPush", "[XG_HWPUSH_V3] onMessageReceived:" + e.getMessage());
            str = "com.tencent.android.tpush.action.PUSH_MESSAGE";
        }
        try {
            if (remoteMessage.getData().length() > 0) {
                String data = remoteMessage.getData();
                Log.i("TPush", "[XG_HWPUSH_V3] Message data payload: " + data);
                Intent intent = new Intent(str);
                intent.putExtra("PUSH.CHANNEL", 102);
                intent.putExtra("content", data);
                intent.putExtra("custom_content", "");
                intent.putExtra("type", (Serializable) 2L);
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
            }
            if (remoteMessage.getNotification() != null) {
                Log.d("TPush", "[XG_HWPUSH_V3] Message Notification Body: " + remoteMessage.getNotification().getBody());
            }
        } catch (Throwable th) {
            Log.e("TPush", "[XG_HWPUSH_V3] onMessageReceived:" + th.getMessage());
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
