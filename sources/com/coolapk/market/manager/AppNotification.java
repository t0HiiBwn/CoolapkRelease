package com.coolapk.market.manager;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.util.RxUtils;
import com.google.gson.Gson;
import com.sina.weibo.sdk.utils.LogUtil;
import com.tencent.android.tpush.XGPushShowedResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u000278B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010&\u001a\u00020$J\u0006\u0010)\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u000200H\u0007J\u000e\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020\u001eH\u0016J\u0010\u00104\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/coolapk/market/manager/AppNotification;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "atMe", "", "atMeComment", "feedLike", "followMe", "isLogin", "", "()Z", "newNotificationFlag", "notification", "notificationHandler", "Lcom/coolapk/market/manager/CoolNotificationHandler;", "pm", "reply", "timeStamp", "", "addIntercept", "", "intercept", "Lcom/coolapk/market/manager/AppNotification$MessageIntercept;", "clearAllCount", "clearByPage", "page", "clearOnlineCountByType", "type", "", "getAllCount", "containMessage", "getCountByPage", "handleCloudInstallMessage", "message", "Lcom/coolapk/market/manager/PushMessage;", "handleDirectPushMessage", "pushMessage", "Lcom/tencent/android/tpush/XGPushShowedResult;", "handlePushMessage", "hasNewNotification", "interceptInLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "loadLastNotificationCountData", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "removeIntercept", "saveAndPostChangeEvent", "toString", "updateCount", "count", "Lcom/coolapk/market/model/NotifyCount;", "Companion", "MessageIntercept", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
public final class AppNotification {
    public static final String ACTION_LIVE_ADD_TO_BROADCAST = "liveAddToBroadcast";
    public static final String ACTION_LIVE_DELETE_ALL_MESSAGE_BY_UID = "liveDeleteAllMessageByUid";
    public static final String ACTION_LIVE_DELETE_MESSAGE = "liveDeleteMessage";
    public static final String ACTION_LIVE_DETAIL = "liveDetail";
    public static final String ACTION_LIVE_REMOVE_FROM_BROADCAST = "liveRemoveFromBroadcast";
    public static final String ACTION_NEW_LIVE_MESSAGE = "newLiveMessage";
    public static final String ACTION_TYPE_ALBUM_REPLY = "album_reply";
    public static final String ACTION_TYPE_ANSWER_INVITE = "answer_invite";
    public static final String ACTION_TYPE_ANSWER_REPLY = "answer_reply";
    public static final String ACTION_TYPE_APK_COMMENT_REPLY = "apk_comment_reply";
    public static final String ACTION_TYPE_ARTICLE_REPLY = "article_reply";
    public static final String ACTION_TYPE_AT_ME = "atme";
    public static final String ACTION_TYPE_AT_ME_COMMENT = "atcommentme";
    public static final String ACTION_TYPE_CLOUD_INSTALL = "cloudInstall";
    public static final String ACTION_TYPE_COMMENT_REPLY = "comment_reply";
    public static final String ACTION_TYPE_CONTACTS_FOLLOW = "contacts_follow";
    public static final String ACTION_TYPE_DISCOVERY_REPLY = "discovery_reply";
    public static final String ACTION_TYPE_DYH_INCLUDE = "dyh_include_feed";
    public static final String ACTION_TYPE_FEED_LIKE = "feedlike";
    public static final String ACTION_TYPE_FEED_REPLY = "feed_reply";
    public static final String ACTION_TYPE_FEED_REPLY_LIKE = "feedReplylike";
    public static final String ACTION_TYPE_GAME_COMMENT_REPLY = "game_comment_reply";
    public static final String ACTION_TYPE_GIFT = "gift";
    public static final String ACTION_TYPE_LIVE = "live";
    public static final String ACTION_TYPE_NOTIFY_XMS = "notify_xms";
    public static final String ACTION_TYPE_PICTURE_REPLY = "picture_reply";
    public static final String ACTION_TYPE_PRIVATE_MESSAGE = "message";
    public static final String ACTION_TYPE_QUESTION_FOLLOW = "question_follow";
    public static final String ACTION_TYPE_QUESTION_REPLY = "question_reply";
    public static final String ACTION_TYPE_RATING_REPLY = "rating_reply";
    public static final String ACTION_TYPE_TOPIC_REPLY = "topic_reply";
    public static final String ACTION_TYPE_URL_REPLY = "url_reply";
    public static final String ACTION_TYPE_VIDEO_REPLY = "video_reply";
    public static final String AT_ME_COMMENT_COUNT = "at_me_comment_count";
    public static final String AT_ME_COUNT = "at_me_count";
    public static final Companion Companion = new Companion(null);
    public static final String FEED_LIKE_COUNT = "feed_like_count";
    public static final String FOLLOW_ME_COUNT = "follow_me";
    public static final String MESSAGE_COUNT = "message_count";
    public static final String NEW_NOTIFICATION = "new_notification";
    public static final String NOTIFICATION_COUNT = "notification_count";
    public static final int NOTIFICATION_ID_BASE = 343;
    public static final String NOTIFICATION_TIME_STAMP = "notification_time_stamp";
    public static final int PAGE_AT_ME_FEED_COMMENT = 2;
    public static final int PAGE_AT_ME_NEW_FEED = 1;
    public static final int PAGE_FEED_LIKE = 5;
    public static final int PAGE_FOLLOW_ME = 6;
    public static final int PAGE_NOTIFICATION = 0;
    public static final int PAGE_PRIVATE_MESSAGE = 4;
    public static final int PAGE_REPLY = 3;
    public static final String REPLY_COUNT = "comment_count";
    private int atMe;
    private int atMeComment;
    private int feedLike;
    private int followMe;
    private boolean newNotificationFlag;
    private int notification;
    private final CoolNotificationHandler notificationHandler;
    private int pm;
    private int reply;
    private long timeStamp;

    public final void handleDirectPushMessage(XGPushShowedResult xGPushShowedResult) {
    }

    public AppNotification(Context context) {
        EventBus.getDefault().register(this);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Gson gson = instance.getGson();
        Intrinsics.checkNotNullExpressionValue(gson, "DataManager.getInstance().gson");
        this.notificationHandler = new CoolNotificationHandler(this, gson);
        loadLastNotificationCountData();
    }

    private final boolean isLogin() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        return loginSession.isLogin();
    }

    private final void loadLastNotificationCountData() {
        if (isLogin()) {
            this.notification = DataManager.getInstance().getPreferencesInt("notification_count", 0);
            this.atMe = DataManager.getInstance().getPreferencesInt("at_me_count", 0);
            this.atMeComment = DataManager.getInstance().getPreferencesInt("at_me_comment_count", 0);
            this.reply = DataManager.getInstance().getPreferencesInt("comment_count", 0);
            this.pm = DataManager.getInstance().getPreferencesInt("message_count", 0);
            this.feedLike = DataManager.getInstance().getPreferencesInt("feed_like_count", 0);
            this.followMe = DataManager.getInstance().getPreferencesInt("follow_me", 0);
            this.newNotificationFlag = DataManager.getInstance().getPreferencesBoolean("new_notification", false);
            this.timeStamp = DataManager.getInstance().getPreferencesLong("notification_time_stamp", 0);
        }
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (!loginSession.isLogin()) {
            clearAllCount();
        } else {
            ActionManager.checkNotificationCount();
        }
    }

    public final synchronized void clearByPage(int i) {
        this.newNotificationFlag = false;
        switch (i) {
            case 0:
                this.notification = 0;
                break;
            case 1:
                this.atMe = 0;
                break;
            case 2:
                this.atMeComment = 0;
                break;
            case 3:
                this.reply = 0;
                break;
            case 4:
                this.pm = 0;
                break;
            case 5:
                this.feedLike = 0;
                break;
            case 6:
                this.followMe = 0;
                break;
        }
        int[] iArr = {5, i + 343};
        for (int i2 = 0; i2 < 2; i2++) {
            NotificationManagerCompat.from(AppHolder.getApplication()).cancel(iArr[i2]);
        }
        saveAndPostChangeEvent();
    }

    public final void clearAllCount() {
        this.newNotificationFlag = false;
        this.followMe = 0;
        this.feedLike = 0;
        this.pm = 0;
        this.reply = 0;
        this.atMeComment = 0;
        this.atMe = 0;
        this.notification = 0;
        saveAndPostChangeEvent();
    }

    public final void clearOnlineCountByType(String str) {
        DataManager.getInstance().clearNotificationCount(str).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AppNotification$clearOnlineCountByType$1());
    }

    public final synchronized void updateCount(NotifyCount notifyCount) {
        if (notifyCount != null) {
            if (isLogin()) {
                if (notifyCount.getDateline() > this.timeStamp) {
                    this.timeStamp = notifyCount.getDateline();
                    boolean z = false;
                    this.newNotificationFlag = this.notification < notifyCount.getNotification() || this.atMe < notifyCount.getAtMe() || this.atMeComment < notifyCount.getAtCommentMe() || this.reply < notifyCount.getCommentMe() || this.pm < notifyCount.getMessage() || this.feedLike < notifyCount.getFeedLike() || this.followMe < notifyCount.getFollowMe() || this.newNotificationFlag;
                    if (!(this.notification == notifyCount.getNotification() && this.atMe == notifyCount.getAtMe() && this.atMeComment == notifyCount.getAtCommentMe() && this.reply == notifyCount.getCommentMe() && this.pm == notifyCount.getMessage() && this.feedLike == notifyCount.getFeedLike() && this.followMe == notifyCount.getFollowMe())) {
                        z = true;
                    }
                    if (z) {
                        this.notification = notifyCount.getNotification();
                        this.atMe = notifyCount.getAtMe();
                        this.atMeComment = notifyCount.getAtCommentMe();
                        this.reply = notifyCount.getCommentMe();
                        this.pm = notifyCount.getMessage();
                        this.feedLike = notifyCount.getFeedLike();
                        this.followMe = notifyCount.getFollowMe();
                        saveAndPostChangeEvent();
                    }
                }
            }
        }
    }

    private final void saveAndPostChangeEvent() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putInt("notification_count", this.notification).putInt("at_me_count", this.atMe).putInt("at_me_comment_count", this.atMeComment).putInt("comment_count", this.reply).putInt("message_count", this.pm).putInt("feed_like_count", this.feedLike).putInt("follow_me", this.followMe).putBoolean("new_notification", this.newNotificationFlag).putLong("notification_time_stamp", this.timeStamp).apply();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            EventBus.getDefault().post(this);
        } else {
            AppHolder.getMainThreadHandler().post(new AppNotification$saveAndPostChangeEvent$1(this));
        }
    }

    public final boolean hasNewNotification() {
        return isLogin() && this.newNotificationFlag && getAllCount(true) > 0;
    }

    public final synchronized int getCountByPage(int i) {
        if (!isLogin()) {
            return 0;
        }
        switch (i) {
            case 0:
                return this.notification;
            case 1:
                return this.atMe;
            case 2:
                return this.atMeComment;
            case 3:
                return this.reply;
            case 4:
                return this.pm;
            case 5:
                return this.feedLike;
            case 6:
                return this.followMe;
            default:
                return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r2 <= 0) goto L_0x003c;
     */
    public final synchronized int getAllCount(boolean z) {
        int i = 0;
        if (!isLogin()) {
            return 0;
        }
        int i2 = this.notification;
        int i3 = this.atMeComment + i2 + this.atMe + this.reply + this.feedLike;
        int i4 = this.followMe;
        if (i2 < i4) {
            i3 += i4;
        }
        if (z) {
            i3 += this.pm;
        }
        if (AppHolder.getAppSetting().getBooleanPref("notification_ignore_like_and_follow")) {
            int i5 = this.notification;
            int i6 = this.followMe;
            if (i5 < i6) {
                i3 -= i6;
            }
            i3 -= this.feedLike;
        }
        i = i3;
        return i;
    }

    public final void interceptInLifeCycle(LifecycleOwner lifecycleOwner, MessageIntercept messageIntercept) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(messageIntercept, "intercept");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycleOwner.lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.notificationHandler.addIntercept(messageIntercept);
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new AppNotification$interceptInLifeCycle$1(this, messageIntercept));
        }
    }

    public final void addIntercept(MessageIntercept messageIntercept) {
        Intrinsics.checkNotNullParameter(messageIntercept, "intercept");
        this.notificationHandler.addIntercept(messageIntercept);
    }

    public final void removeIntercept(MessageIntercept messageIntercept) {
        Intrinsics.checkNotNullParameter(messageIntercept, "intercept");
        this.notificationHandler.removeIntercept(messageIntercept);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r0.equals("discovery_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        if (r0.equals("question_follow") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        if (r0.equals("apk_comment_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r0.equals("picture_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r0.equals("video_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        if (r0.equals("answer_invite") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0091, code lost:
        if (r0.equals("article_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        if (r0.equals("feed_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        if (r0.equals("liveDetail") != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00af, code lost:
        if (r0.equals("liveRemoveFromBroadcast") != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b9, code lost:
        if (r0.equals("newLiveMessage") != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ed, code lost:
        if (r0.equals("atme") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f7, code lost:
        if (r0.equals("url_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        if (r0.equals("topic_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010b, code lost:
        if (r0.equals("feedlike") != false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0115, code lost:
        if (r0.equals("rating_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012c, code lost:
        if (r0.equals("album_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r0.equals("dyh_include_feed") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013f, code lost:
        if (r0.equals("liveAddToBroadcast") != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0141, code lost:
        r5.notificationHandler.handleLiveMessage2(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014e, code lost:
        if (r0.equals("atcommentme") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0157, code lost:
        if (r0.equals("answer_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0160, code lost:
        if (r0.equals("comment_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0169, code lost:
        if (r0.equals("notify_xms") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0172, code lost:
        if (r0.equals("contacts_follow") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017b, code lost:
        if (r0.equals("game_comment_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
        if (r0.equals("liveDeleteAllMessageByUid") != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0184, code lost:
        if (r0.equals("feedReplylike") != false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        if (isLogin() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018c, code lost:
        r5.notificationHandler.handleFeedLikeMessage(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0198, code lost:
        if (r0.equals("question_reply") != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019e, code lost:
        if (isLogin() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a0, code lost:
        r5.notificationHandler.handleNotificationMessage(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r0.equals("liveDeleteMessage") != false) goto L_0x0141;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b5  */
    public final void handlePushMessage(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        if (!TextUtils.isEmpty(pushMessage.getType())) {
            String type = pushMessage.getType();
            switch (type.hashCode()) {
                case -1877627567:
                    break;
                case -1713837693:
                    break;
                case -1257820291:
                    break;
                case -1177197283:
                    break;
                case -1164588504:
                    break;
                case -1107435254:
                    break;
                case -1068404951:
                    break;
                case -1026368156:
                    break;
                case -742476495:
                    break;
                case -680711903:
                    break;
                case -463919846:
                    break;
                case -450270810:
                    if (type.equals("cloudInstall")) {
                        handleCloudInstallMessage(pushMessage);
                        return;
                    }
                    if (!StringsKt.endsWith$default(pushMessage.getType(), "reply", false, 2, (Object) null) && isLogin()) {
                        this.notificationHandler.handleNotificationMessage(pushMessage);
                        return;
                    }
                    return;
                case -317604408:
                    break;
                case -191195595:
                    break;
                case -94346278:
                    break;
                case -12571622:
                    break;
                case 3004683:
                    break;
                case 3172656:
                    if (type.equals("gift")) {
                        if (isLogin()) {
                            this.notificationHandler.handleGiftMessage(pushMessage);
                            return;
                        }
                        return;
                    }
                    if (!StringsKt.endsWith$default(pushMessage.getType(), "reply", false, 2, (Object) null)) {
                        return;
                    }
                    return;
                case 3322092:
                    if (type.equals("live")) {
                        if (isLogin()) {
                            this.notificationHandler.handleLiveMessage(pushMessage);
                            return;
                        }
                        return;
                    }
                    if (!StringsKt.endsWith$default(pushMessage.getType(), "reply", false, 2, (Object) null)) {
                    }
                    break;
                case 270270395:
                    break;
                case 365614471:
                    break;
                case 427578461:
                    break;
                case 580594953:
                    break;
                case 660550241:
                    break;
                case 954925063:
                    if (type.equals("message")) {
                        if (isLogin()) {
                            this.notificationHandler.handlePrivateMessage(pushMessage);
                            return;
                        }
                        return;
                    }
                    if (!StringsKt.endsWith$default(pushMessage.getType(), "reply", false, 2, (Object) null)) {
                    }
                    break;
                case 990010026:
                    break;
                case 1384251942:
                    break;
                case 1406966889:
                    break;
                case 1580157991:
                    break;
                case 1588653610:
                    break;
                case 1877604251:
                    break;
                case 1886833232:
                    break;
                case 1949113916:
                    break;
                default:
                    if (!StringsKt.endsWith$default(pushMessage.getType(), "reply", false, 2, (Object) null)) {
                    }
                    break;
            }
        } else {
            LogUtil.w("AppNotification", "Message title is empty");
        }
    }

    private final void handleCloudInstallMessage(PushMessage pushMessage) {
        Observable.just(pushMessage).map(AppNotification$handleCloudInstallMessage$1.INSTANCE).observeOn(AndroidSchedulers.mainThread()).doOnNext(AppNotification$handleCloudInstallMessage$2.INSTANCE).observeOn(Schedulers.io()).flatMap(AppNotification$handleCloudInstallMessage$3.INSTANCE).observeOn(AndroidSchedulers.mainThread()).map(RxUtils.checkResult()).subscribe((Subscriber) new AppNotification$handleCloudInstallMessage$4());
    }

    public String toString() {
        return "AppNotification{atMe=" + this.atMe + ", atMeComment=" + this.atMeComment + ", feedLike=" + this.feedLike + ", mNewNotificationFlag=" + this.newNotificationFlag + ", notification=" + this.notification + ", pm=" + this.pm + ", reply=" + this.reply + '}';
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/manager/AppNotification$MessageIntercept;", "", "interceptNotification", "", "message", "Lcom/coolapk/market/manager/PushMessage;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNotification.kt */
    public interface MessageIntercept {
        public static final Companion Companion = Companion.$$INSTANCE;

        boolean interceptNotification(PushMessage pushMessage);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/manager/AppNotification$MessageIntercept$Companion;", "", "()V", "invoke", "Lcom/coolapk/market/manager/AppNotification$MessageIntercept;", "callback", "Lkotlin/Function1;", "Lcom/coolapk/market/manager/PushMessage;", "", "privateMessage", "Lcom/coolapk/market/model/Message;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: AppNotification.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final MessageIntercept invoke(Function1<? super PushMessage, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "callback");
                return new AppNotification$MessageIntercept$Companion$invoke$1(function1);
            }

            public final MessageIntercept privateMessage(Function1<? super Message, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "callback");
                return new AppNotification$MessageIntercept$Companion$privateMessage$1(function1);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020-XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/coolapk/market/manager/AppNotification$Companion;", "", "()V", "ACTION_LIVE_ADD_TO_BROADCAST", "", "ACTION_LIVE_DELETE_ALL_MESSAGE_BY_UID", "ACTION_LIVE_DELETE_MESSAGE", "ACTION_LIVE_DETAIL", "ACTION_LIVE_REMOVE_FROM_BROADCAST", "ACTION_NEW_LIVE_MESSAGE", "ACTION_TYPE_ALBUM_REPLY", "ACTION_TYPE_ANSWER_INVITE", "ACTION_TYPE_ANSWER_REPLY", "ACTION_TYPE_APK_COMMENT_REPLY", "ACTION_TYPE_ARTICLE_REPLY", "ACTION_TYPE_AT_ME", "ACTION_TYPE_AT_ME_COMMENT", "ACTION_TYPE_CLOUD_INSTALL", "ACTION_TYPE_COMMENT_REPLY", "ACTION_TYPE_CONTACTS_FOLLOW", "ACTION_TYPE_DISCOVERY_REPLY", "ACTION_TYPE_DYH_INCLUDE", "ACTION_TYPE_FEED_LIKE", "ACTION_TYPE_FEED_REPLY", "ACTION_TYPE_FEED_REPLY_LIKE", "ACTION_TYPE_GAME_COMMENT_REPLY", "ACTION_TYPE_GIFT", "ACTION_TYPE_LIVE", "ACTION_TYPE_NOTIFY_XMS", "ACTION_TYPE_PICTURE_REPLY", "ACTION_TYPE_PRIVATE_MESSAGE", "ACTION_TYPE_QUESTION_FOLLOW", "ACTION_TYPE_QUESTION_REPLY", "ACTION_TYPE_RATING_REPLY", "ACTION_TYPE_TOPIC_REPLY", "ACTION_TYPE_URL_REPLY", "ACTION_TYPE_VIDEO_REPLY", "AT_ME_COMMENT_COUNT", "AT_ME_COUNT", "FEED_LIKE_COUNT", "FOLLOW_ME_COUNT", "MESSAGE_COUNT", "NEW_NOTIFICATION", "NOTIFICATION_COUNT", "NOTIFICATION_ID_BASE", "", "NOTIFICATION_TIME_STAMP", "PAGE_AT_ME_FEED_COMMENT", "PAGE_AT_ME_NEW_FEED", "PAGE_FEED_LIKE", "PAGE_FOLLOW_ME", "PAGE_NOTIFICATION", "PAGE_PRIVATE_MESSAGE", "PAGE_REPLY", "REPLY_COUNT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNotification.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
