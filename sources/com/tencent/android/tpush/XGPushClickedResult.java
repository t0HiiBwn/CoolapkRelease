package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public class XGPushClickedResult implements XGIResult, Serializable {
    public static final int NOTIFACTION_CLICKED_TYPE = NotificationAction.clicked.getType();
    public static final int NOTIFACTION_DELETED_TYPE = NotificationAction.delete.getType();
    public static final int NOTIFACTION_DOWNLOAD_CANCEL_TYPE = NotificationAction.download_cancel.getType();
    public static final int NOTIFACTION_DOWNLOAD_TYPE = NotificationAction.download.getType();
    public static final int NOTIFACTION_OPEN_CANCEL_TYPE = NotificationAction.open_cancel.getType();
    public static final int NOTIFACTION_OPEN_TYPE = NotificationAction.open.getType();
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    private static final String TAG = "XGPushClickedResult";
    private static final long serialVersionUID = 5485267763104201539L;
    int actionType = NotificationAction.clicked.getType();
    String activityName = "";
    String content = "";
    String customContent = "";
    long msgId = 0;
    int notificationActionType = NotificationAction.activity.getType();
    int pushChannel = 100;
    String templateId = "";
    String title = "";
    String traceId = "";

    public int getPushChannel() {
        return this.pushChannel;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public long getActionType() {
        return (long) this.actionType;
    }

    public int getNotificationActionType() {
        return this.notificationActionType;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // java.lang.Object
    public String toString() {
        return "XGPushClickedResult [msgId = " + this.msgId + ", title = " + this.title + ", content = " + this.content + ", customContent = " + this.customContent + ", activityName = " + this.activityName + ", actionType = " + this.actionType + ", pushChannel = " + this.pushChannel + ", notificationActionType = " + this.notificationActionType + ", templateId = " + this.templateId + ", traceId = " + this.traceId + "]";
    }

    @Override // com.tencent.android.tpush.XGIResult
    public void parseIntent(Intent intent) {
        this.msgId = intent.getLongExtra("msgId", -1);
        this.activityName = intent.getStringExtra("activity");
        this.title = Rijndael.decrypt(intent.getStringExtra("title"));
        this.content = Rijndael.decrypt(intent.getStringExtra("content"));
        this.customContent = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.actionType = intent.getIntExtra("action", NotificationAction.clicked.getType());
        this.notificationActionType = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
        this.pushChannel = intent.getIntExtra("PUSH.CHANNEL", 100);
        this.templateId = intent.getStringExtra("templateId");
        this.traceId = intent.getStringExtra("traceId");
        int i = this.pushChannel;
        if (i == 101 || i == 99) {
            try {
                this.activityName = URLDecoder.decode(this.activityName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                TLogger.d("XGPushClickedResult", "parseIntent activityName :" + e.toString());
            }
        }
    }
}
