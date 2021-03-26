package com.coolapk.market.view.main;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.LogUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.CoolMarketApplication;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.MainBinding;
import com.coolapk.market.event.AppCheckForUpgradeEvent;
import com.coolapk.market.event.ConfigJsonEvent;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.ClearCacheHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.MainInitHelper;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.service.AppService;
import com.coolapk.market.service.DownloadService;
import com.coolapk.market.service.PackageService;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShortcutsUtils;
import com.coolapk.market.util.SystemUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.main.MainActivity;
import com.coolapk.market.view.splash.FullScreenAdUtils;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.BottomBarIncluded;
import com.hjq.permissions.XXPermissions;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscriber;

public class MainActivity extends FakeStatusBarActivity implements BottomBarIncluded, TranslucentActivity {
    public static final String EXTRA_URL = "extra_url";
    public static final int REQUEST_CODE_PERMISSIONS = 2;
    public static final int REQUEST_CODE_SPLASH_AD = 1;
    private MainBinding binding;
    private boolean checkForUpgrade;
    private long lastBackPressedTime = 0;
    private int originalSystemUiVisibility = 0;
    private boolean shouldShowPrivacyDialog;

    static /* synthetic */ void lambda$checkBatteryOptimization$2(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$onCreate$0(DialogInterface dialogInterface, int i) {
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public boolean shouldReturnToMainActivity() {
        return false;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        Drawable drawable;
        LogUtils.file("ACTIVITY_LOG", "Main activity on create savedInstanceState: " + bundle);
        boolean z2 = false;
        try {
            ((CoolMarketApplication) getApplication()).checkAdOnForeground = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (FullScreenAdUtils.shouldShowAd(this)) {
            ActionManager.startSplashActivity(this, 1);
            drawable = ResourceUtils.getDrawable(this, 2131231719);
            z = true;
        } else {
            drawable = null;
            z = false;
        }
        if (PermissionsAgreeActivity.shouldShowByFirstInstall() && !this.shouldShowPrivacyDialog) {
            this.shouldShowPrivacyDialog = true;
            ActionManager.startPermissionsAgreeActivity(this, 2);
        }
        if (!PermissionsAgreeActivity.shouldShowByIntent()) {
            AppHolder.getThirdStatUtils().confirmInit();
        }
        setInitSlidrDisable();
        super.onCreate(bundle);
        getWindow().clearFlags(1024);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & -5);
        if (z) {
            this.originalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            setFullscreen();
        }
        getWindow().getDecorView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        ShortcutsUtils.init(this);
        AppHolder.getInstance().notifyMainActivityCountChange(true);
        Uri data = getIntent().getData();
        if (data != null && TextUtils.equals(data.getHost(), getPackageName())) {
            z2 = true;
        }
        if ((getIntent().getFlags() & 4194304) == 0 || z2) {
            handleIntent(getIntent());
            this.binding = (MainBinding) DataBindingUtil.setContentView(this, 2131559015);
            if (z && Build.VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setForeground(drawable);
            }
            if (((MainFragment) getSupportFragmentManager().findFragmentById(this.binding.contentView.getId())) == null) {
                getSupportFragmentManager().beginTransaction().replace(this.binding.contentView.getId(), MainFragment.newInstance()).commitAllowingStateLoss();
                getSupportFragmentManager().executePendingTransactions();
            }
            try {
                checkShortCut();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            checkForUpgrade();
            boolean isComponentEnabled = SystemUtils.isComponentEnabled(this, AppService.class);
            boolean isComponentEnabled2 = SystemUtils.isComponentEnabled(this, PackageService.class);
            boolean isComponentEnabled3 = SystemUtils.isComponentEnabled(this, DownloadService.class);
            if (!isComponentEnabled || !isComponentEnabled2 || !isComponentEnabled3) {
                String str = "检测到酷安的后台服务被禁止，酷安无法完成应用的下载安装，请检测您的手机管家类软件，给予酷安自启权限，开启以下服务";
                if (!isComponentEnabled) {
                    str = str + "\n" + AppService.class.getSimpleName();
                }
                if (!isComponentEnabled2) {
                    str = str + "\n" + PackageService.class.getSimpleName();
                }
                if (!isComponentEnabled3) {
                    str = str + "\n" + DownloadService.class.getSimpleName();
                }
                SimpleDialog newInstance = SimpleDialog.newInstance();
                newInstance.setMessage(str);
                newInstance.setPositiveButton("好的", $$Lambda$MainActivity$BN8Bnky0en3rObVlei2C1Am5OU.INSTANCE);
                newInstance.show(getSupportFragmentManager(), (String) null);
            }
            checkBatteryOptimization(this);
            return;
        }
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigJsonEventChanged(ConfigJsonEvent configJsonEvent) {
        if (!this.shouldShowPrivacyDialog && PrivacyAlertDialog.shouldShowByFirstInstall() && PrivacyAlertDialog.shouldShowByVersion()) {
            PrivacyAlertDialog.newInstance().show(getSupportFragmentManager(), (String) null);
        }
    }

    private void checkBatteryOptimization(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (AppHolder.getInstance().isFirstAndSet("CHECK_BATTERY_OPT") && DataManager.getInstance().getPreferencesBoolean("CHECK_BATTERY_OPTIMIZATION", true) && ((ActivityManager) getSystemService("activity")).isBackgroundRestricted()) {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setTitle("温馨提示");
                    newInstance.setMessage("检测到您使用的是9.0及以上系统，建议您在电池设置中解除酷安的后台限制，以防止出现通知不及时或者通知无法自动清除的问题。");
                    newInstance.setNeutralButton("不再提醒", $$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc.INSTANCE);
                    newInstance.setNegativeButton("以后再说", $$Lambda$MainActivity$LeYMM7MBmsiV6zJ1BhZ0dYZ4G8s.INSTANCE);
                    newInstance.setPositiveButton("前往设置", new DialogInterface.OnClickListener(context) {
                        /* class com.coolapk.market.view.main.$$Lambda$MainActivity$wzFDfBDM3K6rAZ7IMTVBQckWv_w */
                        public final /* synthetic */ Context f$0;

                        {
                            this.f$0 = r1;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.lambda$checkBatteryOptimization$3(this.f$0, dialogInterface, i);
                        }
                    });
                    newInstance.show(getSupportFragmentManager(), (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void lambda$checkBatteryOptimization$3(Context context, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    private void checkForUpgrade() {
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            new Handler().post(new Runnable() {
                /* class com.coolapk.market.view.main.MainActivity.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.checkForUpgrade = true;
                    ActionManager.startCheckMobileAppForUpgrade(MainActivity.this.getActivity(), MainActivity.this.getActivity().getPackageName());
                }
            });
        }
        MainInitHelper.loadMainInitInfo();
    }

    private void checkPermissions(List<String> list) {
        LibraryExtentsKt.asObservable(XXPermissions.with((FragmentActivity) getActivity()).permission(list)).subscribe((Subscriber<? super Boolean>) new EmptySubscriber());
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        super.onSetStatusBarDarkMode(i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppCheckForUpgradeEventChanged(AppCheckForUpgradeEvent appCheckForUpgradeEvent) {
        MobileApp mobileAppUpgradeFast;
        try {
            if (this.checkForUpgrade) {
                this.checkForUpgrade = false;
                if (TextUtils.equals(getActivity().getPackageName(), appCheckForUpgradeEvent.getPackageName()) && (mobileAppUpgradeFast = DataManager.getInstance().getMobileAppUpgradeFast(getPackageName(), false)) != null && mobileAppUpgradeFast.getUpgradeInfo() != null && AppHolder.getAppMetadata().getAppVersionCode() < mobileAppUpgradeFast.getUpgradeInfo().getVersionCode() && DataManager.getInstance().getPreferencesInt("SHOW_UPGRADE_DIALOG", 0) < mobileAppUpgradeFast.getUpgradeInfo().getVersionCode()) {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setTitle(mobileAppUpgradeFast.getAppName() + "-" + mobileAppUpgradeFast.getUpgradeInfo().getVersionName());
                    newInstance.setMessage(mobileAppUpgradeFast.getUpgradeInfo().getChangeLog());
                    newInstance.setPositiveButton(2131886157, new DialogInterface.OnClickListener(mobileAppUpgradeFast) {
                        /* class com.coolapk.market.view.main.$$Lambda$MainActivity$PTqq7N982Hv1nEMHiebKJ3ELzQ */
                        public final /* synthetic */ MobileApp f$1;

                        {
                            this.f$1 = r2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.lambda$onAppCheckForUpgradeEventChanged$4$MainActivity(this.f$1, dialogInterface, i);
                        }
                    });
                    newInstance.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.main.$$Lambda$MainActivity$956f4HnE9nYEM1ZLD3UESzuZJ4Y */

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            DataManager.getInstance().getPreferencesEditor().putInt("SHOW_UPGRADE_DIALOG", MobileApp.this.getUpgradeInfo().getVersionCode()).apply();
                        }
                    });
                    newInstance.show(getSupportFragmentManager(), (String) null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onAppCheckForUpgradeEventChanged$4$MainActivity(MobileApp mobileApp, DialogInterface dialogInterface, int i) {
        ActionManager.startDownload(getActivity(), mobileApp, mobileApp.getUpgradeInfo().getDownloadUrlTypeSmart());
    }

    private void checkShortCut() {
        Uri data = getIntent().getData();
        if (data != null && TextUtils.equals(data.getScheme(), "coolmarket") && TextUtils.equals(data.getHost(), getPackageName())) {
            String lastPathSegment = data.getLastPathSegment();
            lastPathSegment.hashCode();
            char c = 65535;
            switch (lastPathSegment.hashCode()) {
                case -906336856:
                    if (lastPathSegment.equals("search")) {
                        c = 0;
                        break;
                    }
                    break;
                case -418218097:
                    if (lastPathSegment.equals("app_manager")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3433103:
                    if (lastPathSegment.equals("page")) {
                        c = 2;
                        break;
                    }
                    break;
                case 113101341:
                    if (lastPathSegment.equals("which")) {
                        c = 3;
                        break;
                    }
                    break;
                case 563682779:
                    if (lastPathSegment.equals("qr_scan")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1376909533:
                    if (lastPathSegment.equals("new_feed")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ActionManager.startSearchActivity(getActivity());
                    return;
                case 1:
                    StatisticHelper.getInstance().recordViewClickEvent("桌面捷径 应用管理");
                    ActionManager.startAppManagerActivity(getActivity());
                    return;
                case 2:
                    String uri = data.toString();
                    ActionManagerCompat.startActivityByUrl(getActivity(), uri.substring(uri.lastIndexOf("/")), null, null);
                    return;
                case 3:
                    int intValue = Integer.valueOf(data.getQueryParameter("bottom_page")).intValue();
                    int intValue2 = Integer.valueOf(data.getQueryParameter("child_page")).intValue();
                    if (intValue >= 0 && intValue2 >= 0) {
                        this.binding.getRoot().post(new Runnable(intValue, intValue2) {
                            /* class com.coolapk.market.view.main.$$Lambda$MainActivity$O5NLaN2F9U23MreEZBaGvJKOkQ */
                            public final /* synthetic */ int f$1;
                            public final /* synthetic */ int f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                MainActivity.this.lambda$checkShortCut$6$MainActivity(this.f$1, this.f$2);
                            }
                        });
                        return;
                    }
                    return;
                case 4:
                    StatisticHelper.getInstance().recordViewClickEvent("桌面捷径 二维码");
                    ActionManager.startQrcodeActivity(this);
                    return;
                case 5:
                    StatisticHelper.getInstance().recordViewClickEvent("桌面捷径 新的动态");
                    ActionManager.startNewFeedV8Activity(getActivity());
                    return;
                default:
                    return;
            }
        }
    }

    public /* synthetic */ void lambda$checkShortCut$6$MainActivity(int i, int i2) {
        ((MainFragment) getSupportFragmentManager().findFragmentById(this.binding.contentView.getId())).setCurrentItem(i, i2);
    }

    private void handleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("extra_url");
        if (!TextUtils.isEmpty(stringExtra)) {
            ActionManager.startActivityByUrl(getActivity(), stringExtra);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ActionManager.requestCheckNotificationCount();
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        changeBaseTheme();
        int id = this.binding.contentView.getId();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MainFragment newInstance = MainFragment.newInstance();
        newInstance.setInitialSavedState(supportFragmentManager.saveFragmentInstanceState((MainFragment) supportFragmentManager.findFragmentById(id)));
        supportFragmentManager.beginTransaction().replace(id, newInstance).commitAllowingStateLoss();
        ShortcutsUtils.update(this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MarketFragmentV8 marketFragmentV8;
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(this.binding.contentView.getId());
        if (mainFragment != null && mainFragment.isVisible()) {
            PageName pageName = PageName.HOME;
            String preferencesString = DataManager.getInstance().getPreferencesString("APP_MAIN_MODE_KEY", "SOCIAL");
            preferencesString.hashCode();
            if (preferencesString.equals("MARKET")) {
                pageName = PageName.APP_AND_GAME;
            } else if (preferencesString.equals("SOCIAL")) {
                pageName = PageName.HOME;
            }
            int pageNameIndex = mainFragment.getPageNameIndex(pageName);
            if (mainFragment.getCurrentItem() != pageNameIndex) {
                mainFragment.setCurrentItem(pageNameIndex);
                return;
            } else if (!(AnonymousClass2.$SwitchMap$com$coolapk$market$view$main$PageName[pageName.ordinal()] != 2 || (marketFragmentV8 = (MarketFragmentV8) mainFragment.getLastFragment()) == null || marketFragmentV8.getCurrentItem() == 0)) {
                marketFragmentV8.setCurrentItem(0);
                return;
            }
        }
        if (DataManager.getInstance().getDownloadTaskCount() > 0) {
            AlertDownloadingDialog.newInstance().show(getSupportFragmentManager(), (String) null);
            return;
        }
        long timeInMillis = DateUtils.getTimeInMillis();
        if (timeInMillis - this.lastBackPressedTime > 3000) {
            this.lastBackPressedTime = timeInMillis;
            Toast.show(getActivity(), "再按一次返回键退出");
            return;
        }
        super.onBackPressed();
        if (isFinishing()) {
            ActionManager.closeDownloadService(this);
            ActionManager.closeAppService(this);
            NotificationManagerCompat.from(this).cancelAll();
            DataManager.getInstance().clearCompleteInstallState();
            ClearCacheHelper.clearCacheAndGC(AppHolder.getAppSetting().getBooleanPref("clear_cache_on_exit") ? "clear_all" : "clear_recent");
        }
    }

    /* renamed from: com.coolapk.market.view.main.MainActivity$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$coolapk$market$view$main$PageName;

        static {
            int[] iArr = new int[PageName.values().length];
            $SwitchMap$com$coolapk$market$view$main$PageName = iArr;
            try {
                iArr[PageName.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$main$PageName[PageName.APP_AND_GAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AppHolder.getInstance().notifyMainActivityCountChange(false);
    }

    public void setAppHeaderAlpha(float f) {
        if (getContentStatusView() != null) {
            getContentStatusView().setAlpha(f);
            MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(this.binding.contentView.getId());
            if (mainFragment != null) {
                mainFragment.setAppBarBgAlpha(f);
            }
        }
    }

    public static class AlertDownloadingDialog extends BaseDialogFragment {
        static /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        }

        public static AlertDownloadingDialog newInstance() {
            Bundle bundle = new Bundle();
            AlertDownloadingDialog alertDownloadingDialog = new AlertDownloadingDialog();
            alertDownloadingDialog.setArguments(bundle);
            return alertDownloadingDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886704).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.main.$$Lambda$MainActivity$AlertDownloadingDialog$Wxf6K89gYOQiTvSv1IEuE0xwlk */

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.AlertDownloadingDialog.this.lambda$onCreateDialog$0$MainActivity$AlertDownloadingDialog(dialogInterface, i);
                }
            }).setNegativeButton(2131886140, $$Lambda$MainActivity$AlertDownloadingDialog$H9slmMG9YnR0Mh54sU0HUZ28z9w.INSTANCE).create();
        }

        public /* synthetic */ void lambda$onCreateDialog$0$MainActivity$AlertDownloadingDialog(DialogInterface dialogInterface, int i) {
            getActivity().finish();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (Build.VERSION.SDK_INT >= 23 && getWindow().getDecorView().getForeground() != null) {
                getWindow().getDecorView().setForeground(null);
            }
            getWindow().getDecorView().setSystemUiVisibility(this.originalSystemUiVisibility);
            checkStatusBarDarkMode();
        } else if (i == 2) {
            if (i2 == -1) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("list");
                if (CollectionUtils.isNotEmpty(parcelableArrayListExtra)) {
                    checkPermissions(parcelableArrayListExtra);
                }
            }
            MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(this.binding.contentView.getId());
            if (mainFragment != null) {
                mainFragment.showTips();
            }
        }
    }

    private void setFullscreen() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
