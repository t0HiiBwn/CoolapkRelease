package com.coolapk.market;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.coolapk.market.event.CheckForUpgradeEvent;
import com.coolapk.market.event.LoadMobileAppEvent;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.imageloader.GlideFragmentImageLoader;
import com.coolapk.market.imageloader.GlideImageLoader;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActivityStackManager;
import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.AppPushManger;
import com.coolapk.market.manager.MainInitHelper;
import com.coolapk.market.manager.OaidManager;
import com.coolapk.market.manager.QuickReplyReceiver;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.SystemHookManager;
import com.coolapk.market.model.PackageServiceEvent;
import com.coolapk.market.receiver.ConnectivityReceiver;
import com.coolapk.market.receiver.InstallStatusReceiver;
import com.coolapk.market.receiver.NotificationActionReceiver;
import com.coolapk.market.receiver.PackageReceiverImpl;
import com.coolapk.market.receiver.ScreenStatusReceiver;
import com.coolapk.market.service.install.InstallQueue;
import com.coolapk.market.util.ActivityLifecycle;
import com.coolapk.market.util.DelayTask;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ThirdPartUtils;
import com.coolapk.market.util.ThirdStatUtil;
import com.coolapk.market.view.ad.tencent.GDTAdManagerHolder;
import com.coolapk.market.view.ad.toutiao.TTAdManagerHolder;
import com.coolapk.market.widget.CoolCodeHelper;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AppHolder {
    private ActivityLifecycle activityLifecycle;
    private SystemHookManager activityManagerHook;
    private ActivityStackManager activityStackManager;
    private Application appContext;
    private AppIMManager appIMManager;
    private AppMetadata appMetadata;
    private AppSetting appSetting;
    private AppTheme appTheme;
    private ConnectivityReceiver connectivityReceiver;
    private GlideContextImageLoader contextImageLoader;
    private DelayTask delayTask;
    private GlideFragmentImageLoader fragmentImageLoader;
    private Handler handler;
    private InstallQueue installQueue;
    private InstallStatusReceiver installStatusReceiver;
    private boolean isCheckForUpgrading;
    private HashMap<String, Boolean> isFirstByKey;
    private boolean isMobileAppLoading;
    private AppNotification mAppNotification;
    private AppPushManger mAppPushManger;
    private WeakReference<Activity> mCurrentActivity;
    private int mainActivityCount;
    private NotificationActionReceiver notificationActionReceiver;
    private PackageReceiverImpl packageReceiver;
    private QuickReplyReceiver quickReplyReceiver;
    private ScreenStatusReceiver screenStatusReceiver;
    private ThirdPartUtils thirdPartUtils;
    private ThirdStatUtil thirdStatUtil;
    private Map<String, WeakReference<Object>> weakValueMap;
    private IWXAPI wxApi;

    private AppHolder() {
        this.isFirstByKey = new HashMap<>();
    }

    public static AppHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static Application getApplication() {
        return getInstance().appContext;
    }

    public static ActivityLifecycle getActivityLifeCycle() {
        return getInstance().activityLifecycle;
    }

    public static ScreenStatusReceiver getScreenStatusReceiver() {
        return getInstance().screenStatusReceiver;
    }

    public static AppMetadata getAppMetadata() {
        return getInstance().appMetadata;
    }

    public static AppSetting getAppSetting() {
        return getInstance().appSetting;
    }

    public static AppTheme getAppTheme() {
        return getInstance().appTheme;
    }

    public static AppNotification getAppNotification() {
        return getInstance().mAppNotification;
    }

    public static AppPushManger getAppPushManager() {
        return getInstance().mAppPushManger;
    }

    public static AppIMManager getAppIMManager() {
        return getInstance().appIMManager;
    }

    public static ThirdPartUtils getThirdPartUtils() {
        return getInstance().thirdPartUtils;
    }

    public static ThirdStatUtil getThirdStatUtils() {
        return getInstance().thirdStatUtil;
    }

    public static Handler getMainThreadHandler() {
        return getInstance().handler;
    }

    public static InstallQueue getInstallQueue() {
        return getInstance().installQueue;
    }

    public static GlideContextImageLoader getContextImageLoader() {
        return getInstance().contextImageLoader;
    }

    public static GlideFragmentImageLoader getFragmentImageLoader() {
        return getInstance().fragmentImageLoader;
    }

    public static ActivityStackManager getActivityStackManager() {
        return getInstance().activityStackManager;
    }

    public static Activity getCurrentActivity() {
        return getActivityStackManager().getTopActivity();
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = new WeakReference<>(activity);
    }

    public static IWXAPI getWxApi() {
        if (getInstance().wxApi == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(getInstance().appContext, "wxb1753a8e51d9d32d", true);
            createWXAPI.registerApp("wxb1753a8e51d9d32d");
            getInstance().wxApi = createWXAPI;
        }
        return getInstance().wxApi;
    }

    public void init(Application application, AppMetadata appMetadata2) {
        LogUtils.i("Init AppHolder", new Object[0]);
        this.appContext = application;
        this.appMetadata = appMetadata2;
        this.appSetting = new AppSetting(this.appContext, appMetadata2);
        this.appTheme = new AppTheme();
        this.handler = new Handler(Looper.getMainLooper());
        this.activityLifecycle = new ActivityLifecycle();
        this.connectivityReceiver = new ConnectivityReceiver();
        this.notificationActionReceiver = new NotificationActionReceiver();
        this.quickReplyReceiver = new QuickReplyReceiver();
        this.packageReceiver = new PackageReceiverImpl();
        this.installStatusReceiver = new InstallStatusReceiver();
        this.screenStatusReceiver = new ScreenStatusReceiver();
        GlideImageLoader glideImageLoader = new GlideImageLoader();
        this.contextImageLoader = new GlideContextImageLoader(glideImageLoader);
        this.fragmentImageLoader = new GlideFragmentImageLoader(glideImageLoader);
        this.mAppNotification = new AppNotification(this.appContext);
        this.mAppPushManger = new AppPushManger(this.appContext);
        this.appIMManager = new AppIMManager(this.appContext);
        this.thirdPartUtils = new ThirdPartUtils(this.appContext, appMetadata2);
        this.thirdStatUtil = new ThirdStatUtil(this.appContext, appMetadata2);
        this.weakValueMap = new HashMap();
        this.activityManagerHook = new SystemHookManager(this.appContext);
        this.activityStackManager = new ActivityStackManager(this.appContext);
        this.delayTask = new DelayTask();
        this.installQueue = new InstallQueue();
        OaidManager.INSTANCE.init(this.appContext);
        GDTAdManagerHolder.INSTANCE.init(this.appContext);
        TTAdManagerHolder.INSTANCE.init(this.appContext);
        CoolCodeHelper.INSTANCE.init(this.appContext);
        MainInitHelper.updateMainInitInfo();
        LogUtils.i("Init AppHolder end", new Object[0]);
    }

    public boolean isCheckForUpgrading() {
        return this.isCheckForUpgrading;
    }

    public boolean isMobileAppLoading() {
        return this.isMobileAppLoading;
    }

    public void mount() {
        LogUtils.v("AppHolder mount", new Object[0]);
        this.activityLifecycle.register(this.appContext);
        this.quickReplyReceiver.register(this.appContext);
        this.connectivityReceiver.register(this.appContext);
        this.notificationActionReceiver.register(this.appContext);
        this.packageReceiver.register(this.appContext);
        this.installStatusReceiver.register(this.appContext);
        this.screenStatusReceiver.register(this.appContext);
        this.installQueue.onAttach();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void unmount() {
        LogUtils.v("AppHolder unmount", new Object[0]);
        EventBus.getDefault().unregister(this);
        this.activityLifecycle.unregister(this.appContext);
        this.connectivityReceiver.unregister(this.appContext);
        this.quickReplyReceiver.unregister(this.appContext);
        this.notificationActionReceiver.unregister(this.appContext);
        this.packageReceiver.unregister(this.appContext);
        this.installStatusReceiver.unregister(this.appContext);
        this.screenStatusReceiver.unregister(this.appContext);
        this.mAppPushManger.release();
        this.appSetting.releaseResource();
        this.delayTask.clear();
        this.installQueue.onDetach();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCheckForUpgradeEventChanged(CheckForUpgradeEvent checkForUpgradeEvent) {
        this.isCheckForUpgrading = checkForUpgradeEvent.isLoading;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadMobileAppEventChanged(LoadMobileAppEvent loadMobileAppEvent) {
        this.isMobileAppLoading = loadMobileAppEvent.isLoading;
    }

    public boolean isMainActivityExist() {
        return this.mainActivityCount > 0;
    }

    public void notifyMainActivityCountChange(boolean z) {
        if (z) {
            this.mainActivityCount++;
        } else {
            this.mainActivityCount--;
        }
    }

    public static void setWeakValue(String str, Object obj) {
        if (obj != null) {
            getInstance().weakValueMap.put(str, new WeakReference<>(obj));
        } else {
            getInstance().weakValueMap.remove(str);
        }
    }

    public void addInstallDelayTask(final String str) {
        if ("apk".equals(FileUtils.getFileExtension(str))) {
            LogUtils.v("加入备用安装通道: " + str, new Object[0]);
            this.delayTask.addTask(str, new Runnable() {
                /* class com.coolapk.market.AppHolder.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.w("PackageService可能无法启动，我们走备用安装通道: " + str, new Object[0]);
                    AppUtils.installApp(str);
                }
            }, 1200);
        }
    }

    public static <T> T getWeakValue(String str) {
        WeakReference<Object> weakReference = getInstance().weakValueMap.get(str);
        if (weakReference == null) {
            return null;
        }
        return (T) weakReference.get();
    }

    @Subscribe
    public void onLoginEvent(LoginSession loginSession) {
        if (loginSession.isLogin()) {
            this.thirdPartUtils.setUserId(loginSession.getUid());
        } else {
            this.thirdPartUtils.removeUserData(this.appContext);
            CookieManager instance = CookieManager.getInstance();
            instance.removeAllCookies(null);
            instance.flush();
        }
        MainInitHelper.updateMainInitInfo();
        StatisticHelper.getInstance().recordLoginStatusEvent(loginSession.isLogin());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPackageServiceEventChanged(PackageServiceEvent packageServiceEvent) {
        if (packageServiceEvent.getAction().equals("ACTION_INSTALL")) {
            LogUtils.v("PackageService已启动，正常安装，取消备用安装通道 " + packageServiceEvent.getKey(), new Object[0]);
            this.delayTask.removeTask(packageServiceEvent.getKey());
        }
    }

    public boolean isFirstAndSet(String str) {
        Boolean bool = this.isFirstByKey.get(str);
        if (bool == null) {
            bool = true;
        }
        if (bool.booleanValue()) {
            this.isFirstByKey.put(str, false);
        }
        return bool.booleanValue();
    }

    private static class SingletonHolder {
        private static final AppHolder INSTANCE = new AppHolder();

        private SingletonHolder() {
        }
    }
}
