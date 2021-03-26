package com.coolapk.market.manager;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.remote.TypeAdapterFactory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AppNotification {
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
    private Gson mGson;
    private CoolNotificationHandler mHandler = new CoolNotificationHandler(this, this.mGson);
    private boolean mNewNotificationFlag;
    private int notification;
    private int pm;
    private int reply;
    private long timeStamp;

    public interface MessageIntercept {
        boolean interceptNotification(PushMessage pushMessage);
    }

    public AppNotification(Context context) {
        EventBus.getDefault().register(this);
        ensureGson();
        if (isLogin()) {
            this.notification = DataManager.getInstance().getPreferencesInt("notification_count", 0);
            this.atMe = DataManager.getInstance().getPreferencesInt("at_me_count", 0);
            this.atMeComment = DataManager.getInstance().getPreferencesInt("at_me_comment_count", 0);
            this.reply = DataManager.getInstance().getPreferencesInt("comment_count", 0);
            this.pm = DataManager.getInstance().getPreferencesInt("message_count", 0);
            this.feedLike = DataManager.getInstance().getPreferencesInt("feed_like_count", 0);
            this.followMe = DataManager.getInstance().getPreferencesInt("follow_me", 0);
            this.mNewNotificationFlag = DataManager.getInstance().getPreferencesBoolean("new_notification", false);
            this.timeStamp = DataManager.getInstance().getPreferencesLong("notification_time_stamp", 0);
        }
    }

    @Subscribe
    public void onLoginEvent(LoginSession loginSession) {
        if (!loginSession.isLogin()) {
            clearAllCount();
        } else {
            ActionManager.checkNotificationCount();
        }
    }

    public synchronized void clearByPage(int i) {
        this.mNewNotificationFlag = false;
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
            int i3 = iArr[i2];
            NotificationManagerCompat.from(AppHolder.getApplication()).cancel(i3);
            AppHolder.getAppPushManager().clearNotification(i3);
        }
        saveAndPostChangeEvent();
    }

    public void clearAllCount() {
        this.mNewNotificationFlag = false;
        this.followMe = 0;
        this.feedLike = 0;
        this.pm = 0;
        this.reply = 0;
        this.atMeComment = 0;
        this.atMe = 0;
        this.notification = 0;
        saveAndPostChangeEvent();
    }

    public void clearOnlineCountByType(String str) {
        DataManager.getInstance().clearNotificationCount(str).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.manager.AppNotification.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(AppHolder.getApplication(), th);
            }
        });
    }

    public synchronized void updateCount(NotifyCount notifyCount) {
        if (notifyCount != null) {
            if (isLogin()) {
                if (notifyCount.getDateline() > this.timeStamp) {
                    this.timeStamp = notifyCount.getDateline();
                    boolean z = false;
                    this.mNewNotificationFlag = this.notification < notifyCount.getNotification() || this.atMe < notifyCount.getAtMe() || this.atMeComment < notifyCount.getAtCommentMe() || this.reply < notifyCount.getCommentMe() || this.pm < notifyCount.getMessage() || this.feedLike < notifyCount.getFeedLike() || this.followMe < notifyCount.getFollowMe() || this.mNewNotificationFlag;
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

    private void saveAndPostChangeEvent() {
        DataManager.getInstance().getPreferencesEditor().putInt("notification_count", this.notification).putInt("at_me_count", this.atMe).putInt("at_me_comment_count", this.atMeComment).putInt("comment_count", this.reply).putInt("message_count", this.pm).putInt("feed_like_count", this.feedLike).putInt("follow_me", this.followMe).putBoolean("new_notification", this.mNewNotificationFlag).putLong("notification_time_stamp", this.timeStamp).apply();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            EventBus.getDefault().post(this);
        } else {
            AppHolder.getMainThreadHandler().post(new Runnable() {
                /* class com.coolapk.market.manager.AppNotification.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    EventBus.getDefault().post(AppNotification.this);
                }
            });
        }
    }

    public boolean hasNewNotification() {
        if (isLogin() && this.mNewNotificationFlag && getAllCount(true) > 0) {
            return true;
        }
        return false;
    }

    public synchronized int getCountByPage(int i) {
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
    public synchronized int getAllCount(boolean z) {
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

    public void addIntercept(MessageIntercept messageIntercept) {
        this.mHandler.addIntercept(messageIntercept);
    }

    public void removeIntercept(MessageIntercept messageIntercept) {
        this.mHandler.removeIntercept(messageIntercept);
    }

    public void handlePushMessage(PushMessage pushMessage) {
        if (TextUtils.isEmpty(pushMessage.getType())) {
            Log.w("AppNotification", "Message title is empty");
            return;
        }
        String type = pushMessage.getType();
        type.hashCode();
        char c = 65535;
        switch (type.hashCode()) {
            case -1877627567:
                if (type.equals("question_reply")) {
                    c = 0;
                    break;
                }
                break;
            case -1713837693:
                if (type.equals("feedReplylike")) {
                    c = 1;
                    break;
                }
                break;
            case -1257820291:
                if (type.equals("game_comment_reply")) {
                    c = 2;
                    break;
                }
                break;
            case -1177197283:
                if (type.equals("contacts_follow")) {
                    c = 3;
                    break;
                }
                break;
            case -1164588504:
                if (type.equals("notify_xms")) {
                    c = 4;
                    break;
                }
                break;
            case -1107435254:
                if (type.equals("comment_reply")) {
                    c = 5;
                    break;
                }
                break;
            case -1068404951:
                if (type.equals("answer_reply")) {
                    c = 6;
                    break;
                }
                break;
            case -1026368156:
                if (type.equals("atcommentme")) {
                    c = 7;
                    break;
                }
                break;
            case -742476495:
                if (type.equals("liveAddToBroadcast")) {
                    c = '\b';
                    break;
                }
                break;
            case -680711903:
                if (type.equals("dyh_include_feed")) {
                    c = '\t';
                    break;
                }
                break;
            case -463919846:
                if (type.equals("album_reply")) {
                    c = '\n';
                    break;
                }
                break;
            case -450270810:
                if (type.equals("cloudInstall")) {
                    c = 11;
                    break;
                }
                break;
            case -317604408:
                if (type.equals("rating_reply")) {
                    c = '\f';
                    break;
                }
                break;
            case -191195595:
                if (type.equals("feedlike")) {
                    c = '\r';
                    break;
                }
                break;
            case -94346278:
                if (type.equals("topic_reply")) {
                    c = 14;
                    break;
                }
                break;
            case -12571622:
                if (type.equals("url_reply")) {
                    c = 15;
                    break;
                }
                break;
            case 3004683:
                if (type.equals("atme")) {
                    c = 16;
                    break;
                }
                break;
            case 3172656:
                if (type.equals("gift")) {
                    c = 17;
                    break;
                }
                break;
            case 3322092:
                if (type.equals("live")) {
                    c = 18;
                    break;
                }
                break;
            case 270270395:
                if (type.equals("newLiveMessage")) {
                    c = 19;
                    break;
                }
                break;
            case 365614471:
                if (type.equals("liveRemoveFromBroadcast")) {
                    c = 20;
                    break;
                }
                break;
            case 427578461:
                if (type.equals("liveDetail")) {
                    c = 21;
                    break;
                }
                break;
            case 580594953:
                if (type.equals("feed_reply")) {
                    c = 22;
                    break;
                }
                break;
            case 660550241:
                if (type.equals("article_reply")) {
                    c = 23;
                    break;
                }
                break;
            case 954925063:
                if (type.equals("message")) {
                    c = 24;
                    break;
                }
                break;
            case 990010026:
                if (type.equals("answer_invite")) {
                    c = 25;
                    break;
                }
                break;
            case 1384251942:
                if (type.equals("video_reply")) {
                    c = 26;
                    break;
                }
                break;
            case 1406966889:
                if (type.equals("picture_reply")) {
                    c = 27;
                    break;
                }
                break;
            case 1580157991:
                if (type.equals("apk_comment_reply")) {
                    c = 28;
                    break;
                }
                break;
            case 1588653610:
                if (type.equals("question_follow")) {
                    c = 29;
                    break;
                }
                break;
            case 1877604251:
                if (type.equals("discovery_reply")) {
                    c = 30;
                    break;
                }
                break;
            case 1886833232:
                if (type.equals("liveDeleteMessage")) {
                    c = 31;
                    break;
                }
                break;
            case 1949113916:
                if (type.equals("liveDeleteAllMessageByUid")) {
                    c = ' ';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\t':
            case '\n':
            case '\f':
            case 14:
            case 15:
            case 16:
            case 22:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                if (isLogin()) {
                    this.mHandler.handleNotificationMessage(pushMessage);
                    return;
                }
                return;
            case 1:
            case '\r':
                if (isLogin()) {
                    this.mHandler.handleFeedLikeMessage(pushMessage);
                    return;
                }
                return;
            case '\b':
            case 19:
            case 20:
            case 21:
            case 31:
            case ' ':
                this.mHandler.handleLiveMessage2(pushMessage);
                return;
            case 11:
                handleCloudInstallMessage(pushMessage);
                return;
            case 17:
                if (isLogin()) {
                    this.mHandler.handleGiftMessage(pushMessage);
                    return;
                }
                return;
            case 18:
                if (isLogin()) {
                    this.mHandler.handleLiveMessage(pushMessage);
                    return;
                }
                return;
            case 24:
                if (isLogin()) {
                    this.mHandler.handlePrivateMessage(pushMessage);
                    return;
                }
                return;
            default:
                if (pushMessage.getType().endsWith("reply") && isLogin()) {
                    this.mHandler.handleNotificationMessage(pushMessage);
                    return;
                }
                return;
        }
    }

    private void ensureGson() {
        if (this.mGson == null) {
            this.mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapterFactory(TypeAdapterFactory.create()).create();
        }
    }

    private void handleCloudInstallMessage(PushMessage pushMessage) {
        Observable.just(pushMessage).map(new Func1<PushMessage, JSONObject>() {
            /* class com.coolapk.market.manager.AppNotification.AnonymousClass6 */

            public JSONObject call(PushMessage pushMessage) {
                try {
                    return new JSONObject(pushMessage.getContent());
                } catch (JSONException e) {
                    throw Exceptions.propagate(e);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1<JSONObject>() {
            /* class com.coolapk.market.manager.AppNotification.AnonymousClass5 */

            public void call(JSONObject jSONObject) {
                Application application = AppHolder.getApplication();
                Toast.show(application, application.getString(2131886995, jSONObject.optString("title")));
            }
        }).observeOn(Schedulers.io()).flatMap(new Func1<JSONObject, Observable<Result<ServiceApp>>>() {
            /* class com.coolapk.market.manager.AppNotification.AnonymousClass4 */

            public Observable<Result<ServiceApp>> call(JSONObject jSONObject) {
                return DataManager.getInstance().getCloudInstall(jSONObject.optString("id"));
            }
        }).observeOn(AndroidSchedulers.mainThread()).map(RxUtils.checkResult()).subscribe((Subscriber) new EmptySubscriber<Result<ServiceApp>>() {
            /* class com.coolapk.market.manager.AppNotification.AnonymousClass3 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(AppHolder.getApplication(), th);
            }

            public void onNext(Result<ServiceApp> result) {
                if (result.getData() != null) {
                    ActionManager.startDownload(AppHolder.getApplication(), result.getData(), 0);
                }
            }
        });
    }

    public String toString() {
        return "AppNotification{atMe=" + this.atMe + ", atMeComment=" + this.atMeComment + ", feedLike=" + this.feedLike + ", mNewNotificationFlag=" + this.mNewNotificationFlag + ", notification=" + this.notification + ", pm=" + this.pm + ", reply=" + this.reply + '}';
    }

    private boolean isLogin() {
        return DataManager.getInstance().getLoginSession().isLogin();
    }

    public class PMIntercept implements MessageIntercept {
        private Func1<Message, Boolean> handler;

        public PMIntercept(Func1<Message, Boolean> func1) {
            this.handler = func1;
        }

        @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
        public boolean interceptNotification(PushMessage pushMessage) {
            if (!pushMessage.getType().equals("message")) {
                return false;
            }
            try {
                Message fromJson = Message.typeAdapter(AppHolder.getAppNotification().mGson).fromJson(pushMessage.getContent());
                Func1<Message, Boolean> func1 = this.handler;
                if (func1 == null || !func1.call(fromJson).booleanValue()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
