package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public class XGPushShowedResult implements XGIResult {
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    public static final int NOTIFICATION_ACTION_INTENT = NotificationAction.intent.getType();
    public static final int NOTIFICATION_ACTION_INTENT_WIHT_ACTION = NotificationAction.intent_with_action.getType();
    public static final int NOTIFICATION_ACTION_PACKAGE = NotificationAction.action_package.getType();
    public static final int NOTIFICATION_ACTION_URL = NotificationAction.url.getType();
    long a = 0;
    String b = "";
    String c = "";
    String d = "";
    String e = "";
    int f = 0;
    int g = NotificationAction.activity.getType();
    int h = 100;
    public String templateId = "";
    public String traceId = "";

    public int getPushChannel() {
        return this.h;
    }

    public int getNotifactionId() {
        return this.f;
    }

    public long getMsgId() {
        return this.a;
    }

    public String getTitle() {
        return this.b;
    }

    public String getContent() {
        return this.c;
    }

    public String getCustomContent() {
        return this.d;
    }

    public String getActivity() {
        return this.e;
    }

    public int getNotificationActionType() {
        return this.g;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "XGPushShowedResult [msgId = " + this.a + ", title = " + this.b + ", content = " + this.c + ", customContent=" + this.d + ", activity = " + this.e + ", notificationActionType = " + this.g + ", pushChannel = " + this.h + ", templateId = " + this.templateId + ", traceId = " + this.traceId + "]";
    }

    @Override // com.tencent.android.tpush.XGIResult
    public void parseIntent(Intent intent) {
        this.a = intent.getLongExtra("msgId", -1);
        this.e = intent.getStringExtra("activity");
        this.b = Rijndael.decrypt(intent.getStringExtra("title"));
        this.c = Rijndael.decrypt(intent.getStringExtra("content"));
        this.g = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
        this.d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.f = intent.getIntExtra("notifaction_id", 0);
        this.h = intent.getIntExtra("PUSH.CHANNEL", 100);
        this.templateId = intent.getStringExtra("templateId");
        this.traceId = intent.getStringExtra("traceId");
        int i = this.h;
        if (i == 101 || i == 99) {
            try {
                this.e = URLDecoder.decode(this.e, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                TLogger.d("XGPushShowedResult", "parseIntent activityName :" + e2.toString());
            }
        }
    }
}
