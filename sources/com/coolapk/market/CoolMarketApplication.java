package com.coolapk.market;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.event.LoadMobileAppEvent;
import com.coolapk.market.event.UninstallEvent;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ClearCacheHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.LoginCheckManager;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.service.autoinstall.AutoInstallSetting;
import com.coolapk.market.service.oss.OSSClientWrapImpl;
import com.coolapk.market.service.work.DeleteApkWorker;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.OnAppStatusChangedListener;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.SystemUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriActionUtils;
import com.coolapk.market.util.XposedUtils;
import com.coolapk.market.view.app.InstallErrorAlertDialog;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.block.BlockContentManager;
import com.coolapk.market.view.main.MainActivity;
import com.coolapk.market.view.main.PermissionsAgreeActivity;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.view.splash.FullScreenAdActivity;
import com.coolapk.market.view.splash.FullScreenAdUtils;
import com.coolapk.market.view.splash.SplashActivity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.IjkPlayer;
import com.kk.taurus.playerbase.config.PlayerConfig;
import com.kk.taurus.playerbase.config.PlayerLibrary;
import com.kk.taurus.playerbase.entity.DecoderPlan;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class CoolMarketApplication extends Application implements LogUtils.OnLogListener, OnAppStatusChangedListener {
    private static final long DEFAULT_INTERVAL_CHECK_FOR_UPGRADE = 360000;
    public boolean checkAdOnForeground = true;
    private Subscription checkCountSub;
    private Subscription checkForNetworkStateSub;
    private Subscription checkForUpgradeSub;
    private Subscription clearMemoryStateSub;
    public boolean isFirstVisible = true;
    private boolean isShowPermissionCheckDialog = true;

    @Override // com.coolapk.market.util.LogUtils.OnLogListener
    public boolean onLog(int i, String str, String str2, Throwable th) {
        return true;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        LogUtils.v("Create application start", new Object[0]);
        if (SystemUtils.shouldInit(this)) {
            init();
            if (!AppHolder.getAppMetadata().isCommunityMode()) {
                this.checkForUpgradeSub = Observable.interval(360000, TimeUnit.MILLISECONDS).subscribe((Subscriber<? super Long>) new EmptySubscriber<Long>() {
                    /* class com.coolapk.market.CoolMarketApplication.AnonymousClass1 */

                    public void onNext(Long l) {
                        if (AppHolder.getActivityLifeCycle().isAppForeground()) {
                            LogUtils.v("Check for upgrade by auto interval", new Object[0]);
                            ActionManager.startCheckMobileAppForUpgrade(CoolMarketApplication.this.getApplicationContext(), false);
                        }
                    }
                });
            }
            this.checkCountSub = Observable.interval(60000, TimeUnit.MILLISECONDS).subscribe((Subscriber<? super Long>) new EmptySubscriber<Long>() {
                /* class com.coolapk.market.CoolMarketApplication.AnonymousClass2 */

                public void onNext(Long l) {
                    if (AppHolder.getActivityLifeCycle().isAppForeground()) {
                        long lastCheckCountTime = AppHolder.getAppSetting().getLastCheckCountTime();
                        long j = 300000;
                        if (!AppHolder.getAppPushManager().isRegistered() && (AppHolder.getCurrentActivity() instanceof MainActivity)) {
                            j = 60000;
                        }
                        if (System.currentTimeMillis() - lastCheckCountTime >= j) {
                            ActionManager.checkNotificationCount();
                        }
                    }
                }
            });
            Observable.timer(1, TimeUnit.SECONDS).subscribe($$Lambda$CoolMarketApplication$tTdr0ksY3NXwd06bpDqHUbLuffM.INSTANCE);
            if (DataManager.getInstance().getLoginSession().isLogin()) {
                BlockContentManager.INSTANCE.reloadBlockData();
                SettingSynchronized.INSTANCE.reloadSettingConfig();
            }
            DeleteApkWorker.start(this);
            EventBus.getDefault().register(this);
            LogUtils.v("Create application end", new Object[0]);
        }
    }

    static /* synthetic */ void lambda$onCreate$0(Long l) {
        LoginCheckManager.checkLoginInfoInit();
        ClearCacheHelper.newClearCacheTask("clear_recent").subscribe((Subscriber<? super Object>) new EmptySubscriber());
        if (AppHolder.getAppSetting().shouldDisableXposed()) {
            XposedUtils.disableXposed();
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    private void init() {
        LogUtils.v("Application init", new Object[0]);
        Utils.init(this);
        initLog();
        AppMetadata appMetadata = new AppMetadata(this);
        DataManager.getInstance().init(this, new AppConfig(this, appMetadata), OSSClientWrapImpl.INSTANCE);
        AppHolder.getInstance().init(this, appMetadata);
        AppHolder.getInstance().mount();
        LogUtils.setOnLogListener(this);
        UriActionUtils.INSTANCE.init();
        PlayerConfig.addDecoderPlan(new DecoderPlan(1, IjkPlayer.class.getName(), "IjkPlayer"));
        PlayerConfig.setDefaultPlanId(1);
        PlayerConfig.setUseDefaultNetworkEventProducer(true);
        PlayerLibrary.init(this);
        UiUtils.changeLanguage(this, DataManager.getInstance().getPreferencesString("language", "system"));
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        createLowNotifyChannel(notificationManager, 1, "应用下载");
        createLowNotifyChannel(notificationManager, 2, "应用安装");
        createLowNotifyChannel(notificationManager, 3, "应用更新");
        createHighNotifyChannel(notificationManager, 5, "消息通知");
        createMinNotifyChannel(notificationManager, 6, "酷安后台服务");
        AppHolder.getActivityLifeCycle().addOnAppStatusChangedListener(this);
        LogUtils.v("Application init end", new Object[0]);
    }

    private void createMinNotifyChannel(NotificationManager notificationManager, int i, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(String.valueOf(i), str, 0);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createLowNotifyChannel(NotificationManager notificationManager, int i, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(String.valueOf(i), str, 2);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createHighNotifyChannel(NotificationManager notificationManager, int i, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(String.valueOf(i), str, 5);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(AppHolder.getAppTheme().getColorPrimary());
            notificationChannel.setShowBadge(true);
            try {
                notificationManager.createNotificationChannel(notificationChannel);
            } catch (Exception e) {
                e.printStackTrace();
                notificationChannel.setImportance(4);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        if (SystemUtils.shouldInit(this)) {
            EventBus.getDefault().unregister(this);
            RxUtils.unsubscribe(this.checkCountSub);
            RxUtils.unsubscribe(this.checkForUpgradeSub);
            AppHolder.getActivityLifeCycle().removeOnAppStatusChangedListener(this);
            AppHolder.getInstance().unmount();
            DataManager.getInstance().closeDatabase();
            AutoInstallSetting.clearPackageList();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (SystemUtils.shouldInit(this)) {
            LogUtils.d("OnTrimMemory level: %d", Integer.valueOf(i));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onInstallEventChanged(InstallEvent installEvent) {
        Extra extra;
        try {
            InstallState installState = installEvent.installState;
            if (installState.getState() == 7) {
                try {
                    Extra extra2 = installEvent.installState.getExtra();
                    String string = extra2 != null ? extra2.getString("TITLE") : null;
                    String apkFilePath = installEvent.installState.getApkFilePath();
                    Objects.requireNonNull(apkFilePath);
                    AutoInstallSetting.addToInstallPackageList(apkFilePath, string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (installState.hasError()) {
                try {
                    if (installState.getErrorCode() == -6) {
                        Extra extra3 = installState.getExtra();
                        if (extra3 != null) {
                            String string2 = extra3.getString("PACKAGE_NAME");
                            String from = installState.getFrom();
                            String string3 = extra3.getString("REDIRECT_URL");
                            String[] split = installState.getErrorMessage().split(",");
                            ActionManager.reportHijack(this, string2, from, string3, split[1].split(":")[1].trim(), split[2].split(":")[1].trim(), split[3].split(":")[1].trim(), Integer.parseInt(split[4].split(":")[1].trim()));
                        }
                    } else if (installState.getErrorCode() == -7 && (extra = installState.getExtra()) != null) {
                        ActionManager.reportUnknown(this, extra.getString("PACKAGE_NAME"), installState.getFrom(), extra.getString("REDIRECT_URL"));
                    }
                } catch (Exception e2) {
                    Toast.error(this, e2);
                }
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null && !currentActivity.isFinishing() && (currentActivity instanceof AppCompatActivity)) {
                    InstallErrorAlertDialog.newInstance(installState).show(((AppCompatActivity) currentActivity).getSupportFragmentManager(), (String) null);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUninstallEventChanged(UninstallEvent uninstallEvent) {
        try {
            if (uninstallEvent.uninstallState.getState() == 2) {
                AutoInstallSetting.addToUninstallPackageList(uninstallEvent.uninstallState.getPackageName(), uninstallEvent.uninstallState.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UninstallState uninstallState = DataManager.getInstance().getUninstallState(uninstallEvent.key);
        if (uninstallState != null && uninstallState.hasError()) {
            Toast.errorUninstall(this, uninstallState);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadMobileAppEventChanged(LoadMobileAppEvent loadMobileAppEvent) {
        try {
            if (AppHolder.getCurrentActivity() != null && !loadMobileAppEvent.isLoading && DataManager.getInstance().getMobileAppExistListFast().size() < 5 && DataManager.getInstance().getPreferencesBoolean("PREF_SHOW_PERMISSION_CHECK_DIALOG", true) && this.isShowPermissionCheckDialog) {
                this.isShowPermissionCheckDialog = false;
                SimpleDialog newInstance = SimpleDialog.newInstance();
                newInstance.setMessage(getString(2131887048));
                newInstance.setPositiveButton(2131886135, new DialogInterface.OnClickListener() {
                    /* class com.coolapk.market.CoolMarketApplication.AnonymousClass3 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActionManager.openApplicationInfo(AppHolder.getCurrentActivity(), CoolMarketApplication.this.getPackageName());
                    }
                });
                newInstance.setNegativeButton(2131886115);
                newInstance.setNeutralButton(2131886126, new DialogInterface.OnClickListener() {
                    /* class com.coolapk.market.CoolMarketApplication.AnonymousClass4 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataManager.getInstance().getPreferencesEditor().putBoolean("PREF_SHOW_PERMISSION_CHECK_DIALOG", false).apply();
                    }
                });
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity instanceof AppCompatActivity) {
                    newInstance.show(((AppCompatActivity) currentActivity).getSupportFragmentManager(), (String) null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initLog() {
        com.blankj.utilcode.util.LogUtils.getConfig().setLogSwitch(true).setConsoleSwitch(true).setGlobalTag(null).setLogHeadSwitch(true).setFilePrefix("coolapk").setSaveDays(2).setSingleTagSwitch(true);
    }

    @Override // com.coolapk.market.util.OnAppStatusChangedListener
    public void onForeground(Activity activity) {
        boolean z = false;
        if (this.isFirstVisible) {
            this.isFirstVisible = false;
            if (!AppHolder.getAppMetadata().isCommunityMode()) {
                ActionManager.startLoadMobileApp(this);
                ActionManager.startCheckMobileAppForUpgrade((Context) this, true);
            }
        } else {
            try {
                if (this.checkAdOnForeground && activity != null && !(activity instanceof SplashActivity) && !(activity instanceof FullScreenAdActivity) && !(activity instanceof PermissionsAgreeActivity) && (activity instanceof MainActivity)) {
                    if (AppHolder.getAppSetting().getConfigJson().optInt("SplashAd.onResume", 0) == 1) {
                        z = true;
                    }
                    if (z && !AppHolder.getScreenStatusReceiver().getScreenOnWithoutAd() && FullScreenAdUtils.shouldShowAd(this)) {
                        ActionManager.startFullScreenAdActivity(activity);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (AppHolder.getAppSetting().getBooleanPref("limited_background_enabled")) {
                AppHolder.getAppPushManager().registerPush();
            }
        }
        this.checkAdOnForeground = true;
        RxUtils.unsubscribe(this.checkForNetworkStateSub);
        this.checkForNetworkStateSub = Observable.timer(3, TimeUnit.SECONDS).subscribe(new Action1() {
            /* class com.coolapk.market.$$Lambda$CoolMarketApplication$qGQzWPXYFld6lSzssrld4NNoELU */

            @Override // rx.functions.Action1
            public final void call(Object obj) {
                CoolMarketApplication.this.lambda$onForeground$1$CoolMarketApplication((Long) obj);
            }
        });
        AppHolder.getAppIMManager().resume();
        ActionManager.checkNotificationCount();
    }

    public /* synthetic */ void lambda$onForeground$1$CoolMarketApplication(Long l) {
        LogUtils.v("Send broadcast check for network state", new Object[0]);
        ActionManager.sendCheckForNetworkStateBroadcast(getApplicationContext());
    }

    @Override // com.coolapk.market.util.OnAppStatusChangedListener
    public void onBackground(Activity activity) {
        RxUtils.unsubscribe(this.clearMemoryStateSub);
        this.clearMemoryStateSub = Observable.timer(3, TimeUnit.MINUTES).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.coolapk.market.$$Lambda$CoolMarketApplication$ViXks7q4R2ItN4mlTQU6H0g5QBs */

            @Override // rx.functions.Action1
            public final void call(Object obj) {
                CoolMarketApplication.this.lambda$onBackground$2$CoolMarketApplication((Long) obj);
            }
        });
        if (AppHolder.getAppSetting().getBooleanPref("limited_background_enabled")) {
            if (SystemUtils.isProcessRunning(this, getPackageName() + ":xg_vip_service")) {
                AppHolder.getAppPushManager().unregisterPush();
                try {
                    ActionManager.closePushService(getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        File externalFilesDir = getExternalFilesDir("event");
        if (externalFilesDir != null && externalFilesDir.exists()) {
            FileUtils.deleteAllInDir(externalFilesDir);
        }
        File externalFilesDir2 = getExternalFilesDir("eventUploading");
        if (externalFilesDir2 != null && externalFilesDir2.exists()) {
            FileUtils.deleteAllInDir(externalFilesDir2);
        }
        AppHolder.getAppIMManager().lazyRelease();
    }

    public /* synthetic */ void lambda$onBackground$2$CoolMarketApplication(Long l) {
        GlideApp.get(this).clearMemory();
    }
}
