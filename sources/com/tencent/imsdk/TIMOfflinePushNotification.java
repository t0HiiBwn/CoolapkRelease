package com.tencent.imsdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imsdk.log.QLog;

@Deprecated
public class TIMOfflinePushNotification {
    public static Uri globleC2CRemindSound;
    public static Uri globleGroupRemindSound;
    private final String TAG;
    private String content;
    private String conversationId;
    private TIMConversationType conversationType;
    private byte[] ext;
    private String groupName;
    private boolean isValid;
    private long opt;
    private String senderIdentifier;
    private String senderNickName;
    private Uri sound;
    private String tag;
    private String title;

    public TIMOfflinePushNotification() {
        this.TAG = TIMOfflinePushNotification.class.getSimpleName();
        this.opt = 0;
        this.isValid = false;
    }

    public TIMOfflinePushNotification(Context context, TIMMessage tIMMessage) {
        String str;
        String str2;
        Uri uri;
        Uri uri2;
        String str3;
        this.TAG = TIMOfflinePushNotification.class.getSimpleName();
        this.opt = 0;
        this.isValid = false;
        TIMConversationType type = tIMMessage.getConversation().getType();
        if (type != TIMConversationType.C2C && type != TIMConversationType.Group) {
            this.isValid = false;
        } else if (tIMMessage.getMsg().lifetime() == 0) {
            this.isValid = false;
        } else {
            TIMMessageOfflinePushSettings offlinePushSettings = tIMMessage.getOfflinePushSettings();
            String str4 = "";
            if (offlinePushSettings == null) {
                str = str4;
            } else if (!offlinePushSettings.isEnabled()) {
                this.isValid = false;
                return;
            } else {
                setSound(offlinePushSettings.getAndroidSettings().getSound());
                setExt(offlinePushSettings.getExt());
                str = offlinePushSettings.getDescr();
                this.title = offlinePushSettings.getAndroidSettings().getTitle();
            }
            this.opt = tIMMessage.getRecvFlag().getValue();
            setTag(tIMMessage.getConversation().getPeer());
            setConversationType(tIMMessage.getConversation().getType());
            setConversationId(tIMMessage.getConversation().getPeer());
            String sender = tIMMessage.getSender();
            if (!TextUtils.isEmpty(sender)) {
                setSenderIdentifier(sender);
            }
            if (tIMMessage.getSenderGroupMemberProfile() != null) {
                String nameCard = tIMMessage.getSenderGroupMemberProfile().getNameCard();
                if (!TextUtils.isEmpty(nameCard)) {
                    setSenderNickName(nameCard);
                }
            }
            if (this.conversationType != TIMConversationType.C2C) {
                setGroupName(tIMMessage.getConversation().getPeer());
                if (TextUtils.isEmpty(this.title)) {
                    setTitle(this.groupName);
                }
                String str5 = this.senderNickName;
                str4 = str4 + (TextUtils.isEmpty(str5) ? this.senderIdentifier : str5) + ": ";
            } else if (TextUtils.isEmpty(this.title)) {
                setTitle(this.senderNickName);
            }
            if (TextUtils.isEmpty(this.title)) {
                setTitle(this.conversationId);
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str4 + str;
            } else {
                for (int i = 0; i < tIMMessage.getElementCount(); i++) {
                    TIMElem element = tIMMessage.getElement(i);
                    if (element.getType() == TIMElemType.Sound) {
                        str3 = str4 + "[语音]";
                    } else if (element.getType() == TIMElemType.File) {
                        str3 = str4 + "[文件]";
                    } else if (element.getType() == TIMElemType.Text) {
                        str3 = str4 + ((TIMTextElem) element).getText();
                    } else if (element.getType() == TIMElemType.Image) {
                        str3 = str4 + "[图片]";
                    } else if (element.getType() == TIMElemType.Face) {
                        str3 = str4 + "[表情]";
                    } else {
                        if (element.getType() == TIMElemType.Custom) {
                            TIMCustomElem tIMCustomElem = (TIMCustomElem) element;
                            str4 = !TextUtils.isEmpty(tIMCustomElem.getDesc()) ? str4 + "[" + tIMCustomElem.getDesc() + "]" : str4;
                            if (this.ext == null) {
                                setExt(tIMCustomElem.getExt());
                            }
                        } else if (element.getType() == TIMElemType.Location) {
                            str3 = str4 + "[位置信息]" + ((TIMLocationElem) element).getDesc();
                        } else if (element.getType() == TIMElemType.Video) {
                            str3 = str4 + "[视频]";
                        }
                    }
                    str4 = str3;
                }
                str2 = str4;
            }
            setContent(str2);
            if (getSound() == null) {
                if (this.conversationType == TIMConversationType.C2C && (uri2 = globleC2CRemindSound) != null) {
                    setSound(uri2);
                } else if (this.conversationType == TIMConversationType.Group && (uri = globleGroupRemindSound) != null) {
                    setSound(uri);
                }
            }
            setIsValid(true);
        }
    }

    public Uri getSound() {
        return this.sound;
    }

    public void setSound(Uri uri) {
        if (uri != null) {
            this.sound = uri;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    void setIsValid(boolean z) {
        this.isValid = z;
    }

    void setTag(String str) {
        this.tag = str;
    }

    public String getTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public byte[] getExt() {
        byte[] bArr = this.ext;
        return bArr == null ? "".getBytes() : bArr;
    }

    public void setExt(byte[] bArr) {
        if (bArr != null) {
            this.ext = bArr;
        }
    }

    public TIMConversationType getConversationType() {
        return this.conversationType;
    }

    void setConversationType(TIMConversationType tIMConversationType) {
        this.conversationType = tIMConversationType;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    void setConversationId(String str) {
        this.conversationId = str;
    }

    public String getSenderIdentifier() {
        return this.senderIdentifier;
    }

    void setSenderIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.senderIdentifier = str;
        }
    }

    public String getSenderNickName() {
        return this.senderNickName;
    }

    void setSenderNickName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.senderNickName = str;
        }
    }

    public TIMGroupReceiveMessageOpt getGroupReceiveMsgOpt() {
        TIMGroupReceiveMessageOpt[] values = TIMGroupReceiveMessageOpt.values();
        for (TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt : values) {
            if (tIMGroupReceiveMessageOpt.getValue() == this.opt) {
                return tIMGroupReceiveMessageOpt;
            }
        }
        return TIMGroupReceiveMessageOpt.ReceiveAndNotify;
    }

    void setGroupReceiveMsgOpt(long j) {
        this.opt = j;
    }

    public String getGroupName() {
        return this.groupName;
    }

    void setGroupName(String str) {
        this.groupName = str;
    }

    @Deprecated
    public void doNotify(Context context, int i) {
        Notification.Builder builder;
        String str = this.TAG;
        QLog.i(str, "notification: " + toString());
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        if (notificationManager == null) {
            QLog.e(this.TAG, "get NotificationManager failed");
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, "FakeNotification");
            notificationManager.createNotificationChannel(new NotificationChannel("FakeNotification", "FakeNotificationName", 4));
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setTicker("收到一条新消息");
        builder.setContentTitle(getTitle());
        builder.setContentText(getContent());
        builder.setSmallIcon(i);
        builder.setAutoCancel(true);
        builder.setDefaults(-1);
        if (this.sound != null) {
            builder.setDefaults(6);
            builder.setSound(this.sound);
        }
        builder.setContentIntent(PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 134217728));
        notificationManager.notify(this.tag, 520, builder.build());
    }

    public String toString() {
        return "title: " + this.title + "|content: " + this.content + "|sid: " + this.conversationId + "|sender: " + this.senderIdentifier + "|senderNick: " + this.senderNickName + "|tag: " + this.tag + "|isValid: " + this.isValid;
    }
}
