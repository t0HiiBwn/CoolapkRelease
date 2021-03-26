package com.coolapk.market.manager;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.local.LoginSession;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\rH\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/manager/AppPushManger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isRegistered", "", "()Z", "setRegistered", "(Z)V", "mCallInit", "mContext", "clearNotification", "", "notifyId", "", "initMiPush", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onSettingEvent", "event", "Lcom/coolapk/market/event/SettingEvent;", "registerPush", "registerUserAccount", "release", "subscribe", "topic", "", "unregisterPush", "unregisterUserAccount", "unsubscribe", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppPushManger.kt */
public final class AppPushManger {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = false;
    private volatile boolean isRegistered;
    private boolean mCallInit;
    private Context mContext;

    public AppPushManger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = CondomContextUtils.buildContext(context);
        initMiPush();
    }

    public final boolean isRegistered() {
        return this.isRegistered;
    }

    public final void setRegistered(boolean z) {
        this.isRegistered = z;
    }

    public final void initMiPush() {
        Observable.timer(150, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super Long>) new AppPushManger$initMiPush$1(this));
    }

    /* access modifiers changed from: private */
    public final void registerPush() {
        if (!this.mCallInit) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            MiPushClient.registerPush(context, "2882303761517155131", "5431715541131");
            this.mCallInit = true;
            if (AppHolder.getAppSetting().getBooleanPref("push_service_enabled")) {
                MiPushClient.enablePush(this.mContext);
            } else {
                MiPushClient.disablePush(this.mContext);
            }
        }
    }

    public final void clearNotification(int i) {
        MiPushClient.clearNotification(AppHolder.getApplication(), i);
    }

    public final void unregisterPush() {
        if (this.mCallInit) {
            MiPushClient.unregisterPush(this.mContext);
            this.mCallInit = false;
            this.isRegistered = false;
        }
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (this.mCallInit) {
            if (loginSession.isLogin()) {
                registerUserAccount();
            } else {
                unregisterUserAccount();
            }
        }
    }

    @Subscribe
    public final void onSettingEvent(SettingEvent settingEvent) {
        String str;
        Intrinsics.checkNotNullParameter(settingEvent, "event");
        if (!this.mCallInit || (str = settingEvent.key) == null || str.hashCode() != -1887959918 || !str.equals("push_service_enabled")) {
            return;
        }
        if (AppHolder.getAppSetting().getBooleanPref(settingEvent.key)) {
            MiPushClient.enablePush(this.mContext);
        } else {
            MiPushClient.disablePush(this.mContext);
        }
    }

    public final void registerUserAccount() {
        if (this.mCallInit && this.isRegistered) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                List<String> allUserAccount = MiPushClient.getAllUserAccount(context);
                if (allUserAccount.size() > 0) {
                    for (String str : allUserAccount) {
                        if (!Intrinsics.areEqual(str, loginSession.getUid())) {
                            MiPushClient.unsetUserAccount(this.mContext, str, null);
                        }
                    }
                }
                MiPushClient.setUserAccount(this.mContext, loginSession.getUid(), null);
            }
        }
    }

    public final void unregisterUserAccount() {
        if (this.mCallInit) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            List<String> allUserAccount = MiPushClient.getAllUserAccount(context);
            if (allUserAccount.size() > 0) {
                for (String str : allUserAccount) {
                    MiPushClient.unsetUserAccount(this.mContext, str, null);
                }
            }
        }
    }

    public final void release() {
        unregisterUserAccount();
        EventBus.getDefault().unregister(this);
        this.mContext = null;
    }

    public final void subscribe(String str) {
        Intrinsics.checkNotNullParameter(str, "topic");
        if (this.mCallInit) {
            MiPushClient.subscribe(this.mContext, str, null);
        }
    }

    public final void unsubscribe(String str) {
        Intrinsics.checkNotNullParameter(str, "topic");
        if (this.mCallInit) {
            MiPushClient.unsubscribe(this.mContext, str, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/manager/AppPushManger$Companion;", "", "()V", "DEBUG", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppPushManger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
