package com.coolapk.market.manager;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.Notification;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.message.ChattingActivity;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020%J\u0010\u0010,\u001a\u00020-2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\b\u00101\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u0010+\u001a\u00020%H\u0002J\u0018\u00105\u001a\u00020\u00102\u0006\u0010$\u001a\u0002062\u0006\u0010+\u001a\u00020%H\u0002J\u000e\u00107\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u00108\u001a\u00020-2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/coolapk/market/manager/CoolNotificationHandler;", "", "mAppNotification", "Lcom/coolapk/market/manager/AppNotification;", "mGson", "Lcom/google/gson/Gson;", "(Lcom/coolapk/market/manager/AppNotification;Lcom/google/gson/Gson;)V", "basePushMessageId", "", "lastPostNotificationTime", "", "mIntercepts", "", "Lcom/coolapk/market/manager/AppNotification$MessageIntercept;", "mLastHandleNotificationSecond", "addIntercept", "", "intercept", "buildAndPost", "notificationId", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "createBaseBuilder", "contentTitle", "", "contentText", "ticker", "contentIntent", "Landroid/app/PendingIntent;", "createQuickReplyAction", "Landroidx/core/app/NotificationCompat$Action;", "context", "Landroid/content/Context;", "intentAction", "targetId", "handleFeedLikeMessage", "message", "Lcom/coolapk/market/manager/PushMessage;", "handleGiftMessage", "handleLiveMessage", "handleLiveMessage2", "handleNotificationMessage", "handlePrivateMessage", "pushMessage", "interceptMessage", "", "loadIconObservable", "Lrx/Observable;", "Landroid/graphics/Bitmap;", "url", "notifyNotificationMessage", "card", "Lcom/coolapk/market/model/Notification;", "notifyPrivateMessage", "Lcom/coolapk/market/model/Message;", "removeIntercept", "shouldShowNotification", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolNotificationHandler.kt */
public final class CoolNotificationHandler {
    public static final Companion Companion = new Companion(null);
    private static final String LAST_HANDLE_TIME = "LAST_SHOW_NOTIFICATION_TIME";
    private int basePushMessageId = 132123;
    private long lastPostNotificationTime;
    private final AppNotification mAppNotification;
    private final Gson mGson;
    private List<AppNotification.MessageIntercept> mIntercepts;
    private long mLastHandleNotificationSecond = DataManager.getInstance().getPreferencesLong("LAST_SHOW_NOTIFICATION_TIME", 0);

    public final void handleGiftMessage(PushMessage pushMessage) {
    }

    public CoolNotificationHandler(AppNotification appNotification, Gson gson) {
        Intrinsics.checkNotNullParameter(appNotification, "mAppNotification");
        Intrinsics.checkNotNullParameter(gson, "mGson");
        this.mAppNotification = appNotification;
        this.mGson = gson;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/manager/CoolNotificationHandler$Companion;", "", "()V", "LAST_HANDLE_TIME", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolNotificationHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void handleLiveMessage(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        if (!interceptMessage(pushMessage)) {
            AppHolder.getAppPushManager().unsubscribe(pushMessage.getMessageTitle());
        }
    }

    public final void handleLiveMessage2(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        interceptMessage(pushMessage);
    }

    public final void handlePrivateMessage(PushMessage pushMessage) {
        Long l;
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        try {
            Message fromJson = Message.typeAdapter(this.mGson).fromJson(pushMessage.getContent());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Message.typeAdapter(mGso…Json(pushMessage.content)");
            Message message = fromJson;
            this.mAppNotification.updateCount(message.getNotifyCount());
            if (shouldShowNotification(pushMessage) && !message.isSentFromMe()) {
                boolean z = true;
                if (!TextUtils.isEmpty(message.getUid())) {
                    String uid = message.getUid();
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    if (!Intrinsics.areEqual(uid, loginSession.getUid())) {
                        return;
                    }
                }
                if (message.getDateline() == null) {
                    l = 0L;
                } else {
                    l = message.getDateline();
                    Intrinsics.checkNotNull(l);
                }
                Intrinsics.checkNotNullExpressionValue(l, "if (card.dateline == null) 0 else card.dateline!!");
                long longValue = l.longValue();
                if (longValue <= 0 || longValue > this.mLastHandleNotificationSecond) {
                    Long dateline = message.getDateline();
                    Intrinsics.checkNotNull(dateline);
                    this.mLastHandleNotificationSecond = dateline.longValue();
                    DataManager instance2 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                    instance2.getPreferencesEditor().putLong("LAST_SHOW_NOTIFICATION_TIME", this.mLastHandleNotificationSecond).apply();
                    LogUtils.d("show message %s", message.toString());
                } else {
                    LogUtils.d("ignore message  %s", message.toString());
                    z = false;
                }
                if (z) {
                    notifyPrivateMessage(message, pushMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void handleFeedLikeMessage(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        try {
            Notification fromJson = Notification.typeAdapter(this.mGson).fromJson(pushMessage.getContent());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Notification.typeAdapter…fromJson(message.content)");
            this.mAppNotification.updateCount(fromJson.getNotifyCount());
        } catch (IOException e) {
            Toast.show$default(AppHolder.getApplication(), e.getMessage(), 0, false, 12, null);
            e.printStackTrace();
        }
    }

    public final void handleNotificationMessage(PushMessage pushMessage) {
        Long l;
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        try {
            Notification fromJson = Notification.typeAdapter(this.mGson).fromJson(pushMessage.getContent());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Notification.typeAdapter…fromJson(message.content)");
            Notification notification = fromJson;
            this.mAppNotification.updateCount(notification.getNotifyCount());
            if (shouldShowNotification(pushMessage)) {
                if (notification.getDateline() == null) {
                    l = 0L;
                } else {
                    l = notification.getDateline();
                    Intrinsics.checkNotNull(l);
                }
                Intrinsics.checkNotNullExpressionValue(l, "if (card.dateline == null) 0 else card.dateline!!");
                long longValue = l.longValue();
                boolean z = true;
                if (longValue <= 0 || longValue > this.mLastHandleNotificationSecond) {
                    Long dateline = notification.getDateline();
                    Intrinsics.checkNotNull(dateline);
                    this.mLastHandleNotificationSecond = dateline.longValue();
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getPreferencesEditor().putLong("LAST_SHOW_NOTIFICATION_TIME", this.mLastHandleNotificationSecond).apply();
                    LogUtils.d("show message %s", notification.toString());
                } else {
                    LogUtils.d("ignore message  %s", notification.toString());
                    z = false;
                }
                if (z) {
                    notifyNotificationMessage(notification, pushMessage);
                }
            }
        } catch (IOException e) {
            Toast.show$default(AppHolder.getApplication(), e.getMessage(), 0, false, 12, null);
            e.printStackTrace();
        }
    }

    private final void notifyPrivateMessage(Message message, PushMessage pushMessage) {
        this.mAppNotification.getCountByPage(4);
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s: %s", Arrays.copyOf(new Object[]{message.getFromUserName(), message.getMessage()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        String messageTitle = pushMessage.getMessageTitle();
        String messageContnet = pushMessage.getMessageContnet();
        Intent buildUriIntent = pushMessage.buildUriIntent(application2);
        if (buildUriIntent == null) {
            buildUriIntent = new Intent(application2, ChattingActivity.class).putExtra("TITLE", message.getFromUserName()).putExtra("USER_ID", message.getFromUid());
            Intrinsics.checkNotNullExpressionValue(buildUriIntent, "Intent(context, Chatting…USER_ID, message.fromUid)");
        }
        PendingIntent activity = PendingIntent.getActivity(application2, 0, buildUriIntent, 134217728);
        Intrinsics.checkNotNullExpressionValue(activity, "contentIntent");
        NotificationCompat.Builder createBaseBuilder = createBaseBuilder(messageTitle, messageContnet, format, activity);
        if (Build.VERSION.SDK_INT >= 24) {
            String fromUid = message.getFromUid();
            Intrinsics.checkNotNullExpressionValue(fromUid, "message.fromUid");
            createBaseBuilder.addAction(createQuickReplyAction(application2, "com.coolapk.market.quick.reply.private_message", fromUid));
        }
        loadIconObservable(message.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new CoolNotificationHandler$notifyPrivateMessage$1(this, createBaseBuilder, 347));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        if (r1.equals("atcommentme") != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f6  */
    private final void notifyNotificationMessage(Notification notification, PushMessage pushMessage) {
        Intent buildUriIntent;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        String type = pushMessage.getType();
        this.mAppNotification.getAllCount(false);
        String messageTitle = pushMessage.getMessageTitle();
        String messageContnet = pushMessage.getMessageContnet();
        NotificationCompat.Action action = null;
        int hashCode = type.hashCode();
        int i = 2;
        if (hashCode != -1177197283) {
            if (hashCode != -1026368156) {
                if (hashCode == 3004683 && type.equals("atme")) {
                    i = 1;
                    buildUriIntent = pushMessage.buildUriIntent(application2);
                    if (buildUriIntent == null) {
                        Intent intent = new Intent(application2, NotificationActivity.class);
                        intent.setFlags(268435456);
                        buildUriIntent = intent.putExtra("tab", i);
                        Intrinsics.checkNotNullExpressionValue(buildUriIntent, "intent.putExtra(Notifica…Activity.EXTRA_TAB, page)");
                    }
                    PendingIntent activity = PendingIntent.getActivity(application2, 0, buildUriIntent, 134217728);
                    Intrinsics.checkNotNullExpressionValue(activity, "pendingIntent");
                    NotificationCompat.Builder createBaseBuilder = createBaseBuilder(messageTitle, messageContnet, messageTitle, activity);
                    if (action != null) {
                        createBaseBuilder.addAction(action);
                    }
                    loadIconObservable(notification.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new CoolNotificationHandler$notifyNotificationMessage$1(this, createBaseBuilder, i + 343));
                }
            }
        } else if (type.equals("contacts_follow")) {
            if (AppHolder.getAppSetting().getBooleanPref("notification_ignore_like_and_follow")) {
                return;
            }
            i = 0;
            buildUriIntent = pushMessage.buildUriIntent(application2);
            if (buildUriIntent == null) {
            }
            PendingIntent activity = PendingIntent.getActivity(application2, 0, buildUriIntent, 134217728);
            Intrinsics.checkNotNullExpressionValue(activity, "pendingIntent");
            NotificationCompat.Builder createBaseBuilder = createBaseBuilder(messageTitle, messageContnet, messageTitle, activity);
            if (action != null) {
            }
            loadIconObservable(notification.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new CoolNotificationHandler$notifyNotificationMessage$1(this, createBaseBuilder, i + 343));
        }
        if (StringsKt.endsWith$default(type, "_reply", false, 2, (Object) null) && notification.getNote() != null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isAdmin() && Build.VERSION.SDK_INT >= 24) {
                Pattern compile = Pattern.compile(".+rid=(\\d+).+");
                String note = notification.getNote();
                String str = "";
                if (note == null) {
                    note = str;
                }
                if (compile.matcher(note).find()) {
                    String note2 = notification.getNote();
                    if (note2 != null) {
                        str = note2;
                    }
                    String replaceAll = compile.matcher(str).replaceAll("$1");
                    Intrinsics.checkNotNullExpressionValue(replaceAll, "replyFeedId");
                    action = createQuickReplyAction(application2, "com.coolapk.market.quick.reply.feed_reply", replaceAll);
                }
            }
        }
        i = 0;
        buildUriIntent = pushMessage.buildUriIntent(application2);
        if (buildUriIntent == null) {
        }
        PendingIntent activity = PendingIntent.getActivity(application2, 0, buildUriIntent, 134217728);
        Intrinsics.checkNotNullExpressionValue(activity, "pendingIntent");
        NotificationCompat.Builder createBaseBuilder = createBaseBuilder(messageTitle, messageContnet, messageTitle, activity);
        if (action != null) {
        }
        loadIconObservable(notification.getFromUserAvatar()).subscribe((Subscriber<? super Bitmap>) new CoolNotificationHandler$notifyNotificationMessage$1(this, createBaseBuilder, i + 343));
    }

    private final NotificationCompat.Action createQuickReplyAction(Context context, String str, String str2) {
        String string = context.getString(2131886967);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…notification_quick_reply)");
        String str3 = string;
        RemoteInput build = new RemoteInput.Builder("remote_input_text").setLabel(str3).build();
        Intrinsics.checkNotNullExpressionValue(build, "RemoteInput.Builder(Quic…\n                .build()");
        NotificationCompat.Action build2 = new NotificationCompat.Action.Builder(2131231548, str3, PendingIntent.getBroadcast(context, 0, new Intent(str).putExtra("bundle_id", str2), 134217728)).addRemoteInput(build).setAllowGeneratedReplies(true).build();
        Intrinsics.checkNotNullExpressionValue(build2, "NotificationCompat.Actio…\n                .build()");
        return build2;
    }

    private final Observable<Bitmap> loadIconObservable(String str) {
        Observable<R> take = Observable.timer(500, TimeUnit.MILLISECONDS).map(CoolNotificationHandler$loadIconObservable$1.INSTANCE).observeOn(Schedulers.io()).mergeWith(Observable.create(new CoolNotificationHandler$loadIconObservable$2(str)).observeOn(AndroidSchedulers.mainThread())).take(1);
        Intrinsics.checkNotNullExpressionValue(take, "Observable.timer(500, Ti…\n                .take(1)");
        return take;
    }

    private final NotificationCompat.Builder createBaseBuilder(String str, String str2, String str3, PendingIntent pendingIntent) {
        int i = 5;
        String str4 = str2;
        NotificationCompat.Builder style = new NotificationCompat.Builder(AppHolder.getApplication(), String.valueOf(5)).setTicker(str3).setContentTitle(str).setContentText(str4).setPriority(AppHolder.getAppSetting().getBooleanPref("floating_notification") ? 1 : 0).setSmallIcon(2131231767).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099786)).setShowWhen(true).setAutoCancel(true).setChannelId(String.valueOf(5)).setContentIntent(pendingIntent).setStyle(new NotificationCompat.BigTextStyle().bigText(str4));
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
        Intrinsics.checkNotNullExpressionValue(style, "builder");
        return style;
    }

    /* access modifiers changed from: private */
    public final void buildAndPost(int i, NotificationCompat.Builder builder) {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        NotificationManagerCompat from = NotificationManagerCompat.from(application);
        int i2 = this.basePushMessageId + 1;
        this.basePushMessageId = i2;
        from.notify(i2, builder.build());
        this.lastPostNotificationTime = System.currentTimeMillis();
    }

    private final boolean shouldShowNotification(PushMessage pushMessage) {
        boolean z = !interceptMessage(pushMessage);
        if ((!z || AppHolder.getAppSetting().getBooleanPref("show_notice_notification_enabled")) && System.currentTimeMillis() - this.lastPostNotificationTime >= ((long) 1000)) {
            return z;
        }
        return false;
    }

    private final boolean interceptMessage(PushMessage pushMessage) {
        List<AppNotification.MessageIntercept> list = this.mIntercepts;
        boolean z = false;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            for (AppNotification.MessageIntercept messageIntercept : list) {
                if (messageIntercept.interceptNotification(pushMessage)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void addIntercept(AppNotification.MessageIntercept messageIntercept) {
        Intrinsics.checkNotNullParameter(messageIntercept, "intercept");
        if (this.mIntercepts == null) {
            this.mIntercepts = new CopyOnWriteArrayList();
        }
        List<AppNotification.MessageIntercept> list = this.mIntercepts;
        Intrinsics.checkNotNull(list);
        list.add(messageIntercept);
    }

    public final void removeIntercept(AppNotification.MessageIntercept messageIntercept) {
        Intrinsics.checkNotNullParameter(messageIntercept, "intercept");
        if (this.mIntercepts == null) {
            this.mIntercepts = new CopyOnWriteArrayList();
        }
        List<AppNotification.MessageIntercept> list = this.mIntercepts;
        Intrinsics.checkNotNull(list);
        list.remove(messageIntercept);
    }
}
