package com.coolapk.market.manager;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.WifiEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/manager/LoginCheckManager;", "", "()V", "hasCheckValidate", "", "isChecking", "checkLoginInfo", "", "isCoolBoot", "checkLoginInfoInit", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onLoginInfoLoaded", "info", "Lcom/coolapk/market/model/LoginInfo;", "onSessionCheckError", "message", "", "onWifiEvent", "event", "Lcom/coolapk/market/event/WifiEvent;", "startForwardUrl", "unregisterNetworkListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginCheckManager.kt */
public final class LoginCheckManager {
    public static final LoginCheckManager INSTANCE = new LoginCheckManager();
    private static boolean hasCheckValidate;
    private static boolean isChecking;

    private LoginCheckManager() {
    }

    @JvmStatic
    public static final void checkLoginInfoInit() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin()) {
            LoginCheckManager loginCheckManager = INSTANCE;
            loginCheckManager.checkLoginInfo(true);
            EventBus eventBus = EventBus.getDefault();
            Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
            EventBusExtendsKt.safeRegister(eventBus, loginCheckManager);
        }
    }

    @Subscribe
    public final void onWifiEvent(WifiEvent wifiEvent) {
        Intrinsics.checkNotNullParameter(wifiEvent, "event");
        if (hasCheckValidate) {
            unregisterNetworkListener();
            return;
        }
        try {
            Object systemService = AppHolder.getApplication().getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    checkLoginInfo(false);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception unused) {
        }
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (!loginSession.isLogin()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().remove("login_forward_url").apply();
        }
    }

    private final void unregisterNetworkListener() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    private final void checkLoginInfo(boolean z) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin() && !hasCheckValidate && !isChecking) {
            isChecking = true;
            DataManager.getInstance().checkLoginInfo().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new LoginCheckManager$checkLoginInfo$1(z));
        }
    }

    /* access modifiers changed from: private */
    public final void onLoginInfoLoaded(LoginInfo loginInfo, boolean z) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (!Intrinsics.areEqual(loginSession.getUid(), loginInfo.getUid()) || !Intrinsics.areEqual(loginSession.getUserName(), loginInfo.getUserName()) || loginSession.getAdminType() != loginInfo.getAdminType()) {
            onSessionCheckError("信息错误，请重新登录");
            return;
        }
        loginSession.update(loginInfo);
        hasCheckValidate = true;
        unregisterNetworkListener();
        AppHolder.getAppPushManager().registerUserAccount();
        if (z) {
            startForwardUrl();
        }
    }

    /* access modifiers changed from: private */
    public final void onSessionCheckError(String str) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        loginSession.reset();
        EventBus.getDefault().post(loginSession);
        Toast.show$default(AppHolder.getApplication(), str, 0, false, 12, null);
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            ActionManager.startLoginActivity(currentActivity);
        }
        unregisterNetworkListener();
    }

    private final void startForwardUrl() {
        Activity currentActivity;
        String preferencesString = DataManager.getInstance().getPreferencesString("login_forward_url", "");
        String str = preferencesString;
        if (!(str == null || str.length() == 0) && AppHolder.getActivityLifeCycle().isAppForeground() && (currentActivity = AppHolder.getCurrentActivity()) != null) {
            ActionManagerCompat.startActivityByUrl$default(currentActivity, preferencesString, null, null, 12, null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().remove("login_forward_url").apply();
        }
    }
}
