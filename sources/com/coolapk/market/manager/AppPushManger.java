package com.coolapk.market.manager;

import android.content.Context;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.util.RomUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\rH\u0002J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0006H\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/manager/AppPushManger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "isRegistered", "()Z", "lastPushId", "", "pushContext", "clearNotification", "", "notifyId", "", "fixMiPushCompat", "initPushConfig", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onSettingEvent", "event", "Lcom/coolapk/market/event/SettingEvent;", "registerPush", "registerUserAccount", "release", "subscribe", "topic", "unregisterPush", "unregisterUserAccount", "unsubscribe", "updatePushServiceStatus", "enable", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppPushManger.kt */
public final class AppPushManger {
    private boolean isRegistered;
    private String lastPushId;
    private Context pushContext;

    public AppPushManger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.pushContext = context;
        AppHolder.getMainThreadHandler().postDelayed(new Runnable(this) {
            /* class com.coolapk.market.manager.AppPushManger.AnonymousClass1 */
            final /* synthetic */ AppPushManger this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.initPushConfig();
                this.this$0.registerPush();
            }
        }, 500);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    public final boolean isRegistered() {
        return this.isRegistered;
    }

    /* access modifiers changed from: private */
    public final void initPushConfig() {
        boolean z = false;
        XGPushConfig.enableDebug(this.pushContext, false);
        boolean z2 = RomUtils.isEmui() || RomUtils.isMIUI();
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("tpns_keep_alive");
        Context context = this.pushContext;
        if (!z2 && booleanPref) {
            z = true;
        }
        XGPushConfig.enablePullUpOtherApp(context, z);
        XGPushConfig.setMiPushAppId(this.pushContext, "2882303761517155131");
        XGPushConfig.setMiPushAppKey(this.pushContext, "5431715541131");
        XGPushConfig.enableOtherPush(this.pushContext, true);
    }

    public final void registerPush() {
        if (!this.isRegistered) {
            XGPushManager.registerPush(this.pushContext, new AppPushManger$registerPush$1(this));
            updatePushServiceStatus(AppHolder.getAppSetting().getBooleanPref("push_service_enabled"));
        }
    }

    private final void updatePushServiceStatus(boolean z) {
        XGPushManager.enableService(this.pushContext, z);
    }

    public final void clearNotification(int i) {
        XGPushManager.cancelNotifaction(AppHolder.getApplication(), i);
    }

    public final void unregisterPush() {
        if (this.isRegistered) {
            XGPushManager.unregisterPush(this.pushContext, new AppPushManger$unregisterPush$1(this));
        }
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (this.isRegistered) {
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
        if (this.isRegistered && (str = settingEvent.key) != null && str.hashCode() == -1887959918 && str.equals("push_service_enabled")) {
            updatePushServiceStatus(AppHolder.getAppSetting().getBooleanPref(settingEvent.key));
        }
    }

    public final void registerUserAccount() {
        if (this.isRegistered) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            String str = this.lastPushId;
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (!Intrinsics.areEqual(str, loginSession.getPushId())) {
                if (loginSession.isLogin()) {
                    String pushId = loginSession.getPushId();
                    XGPushManager.clearAndAppendAccount(this.pushContext, pushId, new AppPushManger$registerUserAccount$1(this, pushId));
                }
                fixMiPushCompat();
            }
        }
    }

    private final void unregisterUserAccount() {
        String str;
        if (this.isRegistered && (str = this.lastPushId) != null) {
            XGPushManager.delAccount(this.pushContext, str);
            this.lastPushId = null;
        }
    }

    public final void release() {
        EventBus.getDefault().unregister(this);
    }

    public final void subscribe(String str) {
        Intrinsics.checkNotNullParameter(str, "topic");
        if (!this.isRegistered) {
        }
    }

    public final void unsubscribe(String str) {
        Intrinsics.checkNotNullParameter(str, "topic");
        if (!this.isRegistered) {
        }
    }

    private final void fixMiPushCompat() {
        try {
            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.pushContext);
            if (allUserAccount.size() > 0) {
                Intrinsics.checkNotNullExpressionValue(allUserAccount, "userAccounts");
                ArrayList<String> arrayList = new ArrayList();
                for (T t : allUserAccount) {
                    T t2 = t;
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    if (TextUtils.isDigitsOnly(t2)) {
                        arrayList.add(t);
                    }
                }
                for (String str : arrayList) {
                    MiPushClient.unsetUserAccount(this.pushContext, str, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
