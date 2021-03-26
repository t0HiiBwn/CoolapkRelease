package com.coolapk.market.manager;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.Notification;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.message.ChattingActivity;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CoolNotificationHandler {
    private static final String LAST_HANDLE_TIME = "LAST_SHOW_NOTIFICATION_TIME";
    private long lastPostNotificationTime;
    private AppNotification mAppNotification;
    private Gson mGson;
    private List<AppNotification.MessageIntercept> mIntercepts;
    private long mLastHandleNotificationSecond = DataManager.getInstance().getPreferencesLong("LAST_SHOW_NOTIFICATION_TIME", 0);

    void handleGiftMessage(PushMessage pushMessage) {
    }

    CoolNotificationHandler(AppNotification appNotification, Gson gson) {
        this.mAppNotification = appNotification;
        this.mGson = gson;
    }

    void handleLiveMessage(PushMessage pushMessage) {
        if (!interceptMessage(pushMessage)) {
            AppHolder.getAppPushManager().unsubscribe(pushMessage.getTopic());
        }
    }

    void handleLiveMessage2(PushMessage pushMessage) {
        interceptMessage(pushMessage);
    }

    void handlePrivateMessage(PushMessage pushMessage) {
        try {
            Message fromJson = Message.typeAdapter(this.mGson).fromJson(pushMessage.getContent());
            this.mAppNotification.updateCount(fromJson.getNotifyCount());
            if (!shouldShowNotification(pushMessage) || fromJson.isSentFromMe()) {
                return;
            }
            if (TextUtils.isEmpty(fromJson.getUid()) || fromJson.getUid().equals(DataManager.getInstance().getLoginSession().getUid())) {
                long longValue = fromJson.getDateline() == null ? 0 : fromJson.getDateline().longValue();
                boolean z = true;
                boolean z2 = false;
                if (longValue <= 0 || longValue > this.mLastHandleNotificationSecond) {
                    this.mLastHandleNotificationSecond = fromJson.getDateline().longValue();
                    DataManager.getInstance().getPreferencesEditor().putLong("LAST_SHOW_NOTIFICATION_TIME", this.mLastHandleNotificationSecond).apply();
                    LogUtils.d("show message %s", fromJson.toString());
                } else {
                    LogUtils.d("ignore message  %s", fromJson.toString());
                    z = false;
                }
                if (pushMessage.getShouldShowNotification()) {
                    z2 = z;
                }
                if (z2) {
                    notifyPrivateMessage(fromJson);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void handleFeedLikeMessage(PushMessage pushMessage) {
        try {
            this.mAppNotification.updateCount(Notification.typeAdapter(this.mGson).fromJson(pushMessage.getContent()).getNotifyCount());
        } catch (IOException e) {
            Toast.show(AppHolder.getApplication(), e.getMessage());
            e.printStackTrace();
        }
    }

    void handleNotificationMessage(PushMessage pushMessage) {
        try {
            Notification fromJson = Notification.typeAdapter(this.mGson).fromJson(pushMessage.getContent());
            this.mAppNotification.updateCount(fromJson.getNotifyCount());
            if (shouldShowNotification(pushMessage)) {
                long longValue = fromJson.getDateline() == null ? 0 : fromJson.getDateline().longValue();
                boolean z = true;
                boolean z2 = false;
                if (longValue <= 0 || longValue > this.mLastHandleNotificationSecond) {
                    this.mLastHandleNotificationSecond = fromJson.getDateline().longValue();
                    DataManager.getInstance().getPreferencesEditor().putLong("LAST_SHOW_NOTIFICATION_TIME", this.mLastHandleNotificationSecond).apply();
                    LogUtils.d("show message %s", fromJson.toString());
                } else {
                    LogUtils.d("ignore message  %s", fromJson.toString());
                    z = false;
                }
                if (pushMessage.getShouldShowNotification()) {
                    z2 = z;
                }
                if (z2) {
                    notifyNotificationMessage(pushMessage.getType(), fromJson);
                }
            }
        } catch (IOException e) {
            Toast.show(AppHolder.getApplication(), e.getMessage());
            e.printStackTrace();
        }
    }

    private void notifyPrivateMessage(Message message) {
        String str;
        String str2;
        int countByPage = this.mAppNotification.getCountByPage(4);
        Application application = AppHolder.getApplication();
        String format = String.format("%s: %s", message.getFromUserName(), message.getMessage());
        if (countByPage > 1) {
            str = application.getString(2131886913, String.valueOf(countByPage));
        } else {
            str = application.getString(2131886914, message.getFromUserName());
        }
        if (countByPage > 1) {
            str2 = format;
        } else {
            str2 = message.getMessage();
        }
        final NotificationCompat.Builder createBaseBuilder = createBaseBuilder(str, str2, format, PendingIntent.getActivity(application, 0, new Intent(application, ChattingActivity.class).putExtra("TITLE", message.getFromUserName()).putExtra("USER_ID", message.getFromUid()), 134217728));
        if (Build.VERSION.SDK_INT >= 24) {
            createBaseBuilder.addAction(createQuickReplyAction(application, "com.coolapk.market.quick.reply.private_message", message.getFromUid()));
        }
        loadIconObservable(message.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new EmptySubscriber<Bitmap>() {
            /* class com.coolapk.market.manager.CoolNotificationHandler.AnonymousClass1 */

            public void onNext(Bitmap bitmap) {
                createBaseBuilder.setLargeIcon(bitmap);
                CoolNotificationHandler.this.buildAndPost(347, createBaseBuilder);
            }
        });
    }

    private void notifyNotificationMessage(String str, Notification notification) {
        String str2;
        String str3;
        Application application = AppHolder.getApplication();
        int allCount = this.mAppNotification.getAllCount(false);
        str.hashCode();
        int i = 2;
        char c = 65535;
        switch (str.hashCode()) {
            case -1177197283:
                if (str.equals("contacts_follow")) {
                    c = 0;
                    break;
                }
                break;
            case -1026368156:
                if (str.equals("atcommentme")) {
                    c = 1;
                    break;
                }
                break;
            case 3004683:
                if (str.equals("atme")) {
                    c = 2;
                    break;
                }
                break;
        }
        NotificationCompat.Action action = null;
        switch (c) {
            case 0:
                if (!AppHolder.getAppSetting().getBooleanPref("notification_ignore_like_and_follow")) {
                    if (allCount > 1) {
                        str3 = application.getString(2131886902, Integer.valueOf(allCount));
                        str2 = application.getString(2131886909, notification.getFromUserName());
                    } else {
                        String string = application.getString(2131886909, notification.getFromUserName());
                        str2 = application.getString(2131886896);
                        str3 = string;
                    }
                    i = 0;
                    break;
                } else {
                    return;
                }
            case 1:
                if (allCount <= 1) {
                    String string2 = application.getString(2131886912, notification.getFromUserName());
                    str2 = application.getString(2131886896);
                    str3 = string2;
                    break;
                } else {
                    str3 = application.getString(2131886902, Integer.valueOf(allCount));
                    str2 = application.getString(2131886912, notification.getFromUserName());
                    break;
                }
            case 2:
                if (allCount > 1) {
                    str3 = application.getString(2131886902, Integer.valueOf(allCount));
                    str2 = application.getString(2131886911, notification.getFromUserName());
                } else {
                    String string3 = application.getString(2131886911, notification.getFromUserName());
                    str2 = application.getString(2131886896);
                    str3 = string3;
                }
                i = 1;
                break;
            default:
                if (allCount > 1) {
                    str3 = application.getString(2131886902, Integer.valueOf(allCount));
                    str2 = notification.getFromUserName() + "：" + LinkTextUtils.reconvert(notification.getNote());
                } else {
                    String reconvert = LinkTextUtils.reconvert(notification.getNote());
                    int indexOf = reconvert.indexOf(65306);
                    if (indexOf > 0) {
                        String str4 = notification.getFromUserName() + "：" + reconvert.substring(0, indexOf);
                        str2 = reconvert.substring(indexOf + 1);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = application.getString(2131886896);
                        }
                        str3 = str4;
                    } else {
                        str3 = notification.getFromUserName() + "：" + LinkTextUtils.reconvert(notification.getNote());
                        str2 = application.getString(2131886896);
                    }
                }
                if (str.endsWith("_reply") && notification.getNote() != null && DataManager.getInstance().getLoginSession().isAdmin() && Build.VERSION.SDK_INT >= 24) {
                    Pattern compile = Pattern.compile(".+rid=(\\d+).+");
                    if (compile.matcher(notification.getNote()).find()) {
                        action = createQuickReplyAction(application, "com.coolapk.market.quick.reply.feed_reply", compile.matcher(notification.getNote()).replaceAll("$1"));
                    }
                }
                i = 0;
                break;
        }
        Intent intent = new Intent(application, NotificationActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("tab", i);
        final NotificationCompat.Builder createBaseBuilder = createBaseBuilder(str3, str2, str3, PendingIntent.getActivity(application, 0, intent, 134217728));
        if (action != null) {
            createBaseBuilder.addAction(action);
        }
        final int i2 = i + 343;
        loadIconObservable(notification.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new EmptySubscriber<Bitmap>() {
            /* class com.coolapk.market.manager.CoolNotificationHandler.AnonymousClass2 */

            public void onNext(Bitmap bitmap) {
                createBaseBuilder.setLargeIcon(bitmap);
                CoolNotificationHandler.this.buildAndPost(i2, createBaseBuilder);
            }
        });
    }

    private NotificationCompat.Action createQuickReplyAction(Context context, String str, String str2) {
        String string = context.getString(2131886905);
        return new NotificationCompat.Action.Builder(2131231537, string, PendingIntent.getBroadcast(context, 0, new Intent(str).putExtra("bundle_id", str2), 134217728)).addRemoteInput(new RemoteInput.Builder("remote_input_text").setLabel(string).build()).setAllowGeneratedReplies(true).build();
    }

    private Observable<Bitmap> loadIconObservable(final String str) {
        return Observable.timer(500, TimeUnit.MILLISECONDS).map(new Func1<Long, Bitmap>() {
            /* class com.coolapk.market.manager.CoolNotificationHandler.AnonymousClass3 */

            public Bitmap call(Long l2) {
                return null;
            }
        }).observeOn(Schedulers.io()).mergeWith(Observable.create(new Observable.OnSubscribe<Bitmap>() {
            /* class com.coolapk.market.manager.CoolNotificationHandler.AnonymousClass4 */

            public void call(Subscriber<? super Bitmap> subscriber) {
                Bitmap bitmap;
                try {
                    bitmap = (Bitmap) GlideApp.with(AppHolder.getApplication()).asBitmap().load(Uri.parse(str)).diskCacheStrategy(DiskCacheStrategy.DATA).transform((Transformation<Bitmap>) new CircleTransform()).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                } catch (Throwable unused) {
                    bitmap = null;
                }
                subscriber.onNext(bitmap);
            }
        }).observeOn(AndroidSchedulers.mainThread())).take(1);
    }

    private NotificationCompat.Builder createBaseBuilder(String str, String str2, String str3, PendingIntent pendingIntent) {
        int i = 5;
        NotificationCompat.Builder style = new NotificationCompat.Builder(AppHolder.getApplication(), String.valueOf(5)).setTicker(str3).setContentTitle(str).setContentText(str2).setPriority(AppHolder.getAppSetting().getBooleanPref("floating_notification") ? 1 : 0).setSmallIcon(2131231756).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099784)).setShowWhen(true).setAutoCancel(true).setContentIntent(pendingIntent).setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("notification_sound");
        boolean booleanPref2 = AppHolder.getAppSetting().getBooleanPref("notification_vibrate");
        if (booleanPref || booleanPref2) {
            if (!booleanPref) {
                i = 4;
            }
            if (booleanPref2) {
                i |= 2;
            }
            style.setDefaults(i);
        } else {
            style.setVibrate(new long[]{0, 0, 0, 0});
        }
        return style;
    }

    /* access modifiers changed from: private */
    public void buildAndPost(int i, NotificationCompat.Builder builder) {
        Application application = AppHolder.getApplication();
        NotificationManagerCompat.from(application).cancel(5);
        NotificationManagerCompat.from(application).notify(5, builder.build());
        this.lastPostNotificationTime = System.currentTimeMillis();
    }

    private boolean shouldShowNotification(PushMessage pushMessage) {
        boolean z = !interceptMessage(pushMessage);
        if ((!z || AppHolder.getAppSetting().getBooleanPref("show_notice_notification_enabled")) && System.currentTimeMillis() - this.lastPostNotificationTime >= 1000) {
            return z;
        }
        return false;
    }

    private boolean interceptMessage(PushMessage pushMessage) {
        List<AppNotification.MessageIntercept> list = this.mIntercepts;
        boolean z = false;
        if (list != null) {
            for (AppNotification.MessageIntercept messageIntercept : list) {
                if (messageIntercept.interceptNotification(pushMessage)) {
                    z = true;
                }
            }
        }
        return z;
    }

    void addIntercept(AppNotification.MessageIntercept messageIntercept) {
        if (this.mIntercepts == null) {
            this.mIntercepts = new CopyOnWriteArrayList();
        }
        this.mIntercepts.add(messageIntercept);
    }

    void removeIntercept(AppNotification.MessageIntercept messageIntercept) {
        if (this.mIntercepts == null) {
            this.mIntercepts = new CopyOnWriteArrayList();
        }
        this.mIntercepts.remove(messageIntercept);
    }
}
