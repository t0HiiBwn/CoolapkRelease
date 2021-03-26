package com.coolapk.market.view.settings;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.service.autoinstall.AutoInstallServiceV10;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.SystemUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.widget.AppMainModelDialog;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

@Deprecated
public class AdvancedSettingsFragment extends BasePreferenceFragment {
    private static final int REQUEST_CODE = 233;

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148224;
    }

    public static AdvancedSettingsFragment newInstance() {
        Bundle bundle = new Bundle();
        AdvancedSettingsFragment advancedSettingsFragment = new AdvancedSettingsFragment();
        advancedSettingsFragment.setArguments(bundle);
        return advancedSettingsFragment;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        Preference findPreference;
        super.initPreferences(z);
        findPrefByKey("download_dir").setSummary(AppHolder.getAppSetting().getDownloadDir());
        if (Build.VERSION.SDK_INT <= 19 && (findPreference = findPreference("navigation_bar_color")) != null) {
            getPreferenceScreen().removePreference(findPreference);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        char c;
        String key = preference.getKey();
        key.hashCode();
        switch (key.hashCode()) {
            case -1757265931:
                if (key.equals("limited_background_enabled")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1270583121:
                if (key.equals("clear_all")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1258153200:
                if (key.equals("clear_cache")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -920069112:
                if (key.equals("reset_preferences")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -101299028:
                if (key.equals("global_auto_install_accessibility_service")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 92611469:
                if (key.equals("about")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1109391446:
                if (key.equals("download_dir")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1451753068:
                if (key.equals("check_log_and_test")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2041812939:
                if (key.equals("app_main_mode")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("limited_background_enabled");
                String packageName = getActivity().getPackageName();
                ComponentName componentName = new ComponentName(packageName, getActivity().getPackageName() + ".AdvancedSettingsActivity");
                if (booleanPref) {
                    getActivity().getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
                    getActivity().setResult(-1);
                } else {
                    getActivity().getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    getActivity().setResult(0);
                }
                return true;
            case 1:
                clearAll();
                return true;
            case 2:
                clearCache();
                return true;
            case 3:
                resetPreferences();
                return true;
            case 4:
                if (!SystemUtils.isAccessibilitySettingsOn(getActivity(), getActivity().getPackageName() + "/" + AutoInstallServiceV10.class.getName())) {
                    Toast.show(getActivity(), 2131886540);
                }
                return true;
            case 5:
                ActionManager.startAboutActivity(getActivity());
                return true;
            case 6:
                ActionManager.startFileViewActivity(this, 233);
                return true;
            case 7:
                ActionManager.startTestSettingsActivity(getActivity());
                return true;
            case '\b':
                AppMainModelDialog.newInstance().show(getChildFragmentManager(), (String) null);
                return true;
            default:
                return super.onPreferenceTreeClick(preference);
        }
    }

    private void resetPreferences() {
        Map<String, Boolean> defaultMap = AppSetting.getDefaultMap();
        PreferencesUtils.EditorHelper preferencesEditor = DataManager.getInstance().getPreferencesEditor();
        for (String str : defaultMap.keySet()) {
            preferencesEditor.putBoolean(str, defaultMap.get(str).booleanValue());
        }
        preferencesEditor.apply();
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        loginSession.reset();
        AppHolder.getAppSetting().setDownloadDir(AppHolder.getAppMetadata().getDefaultDownloadDir().getAbsolutePath());
        EventBus.getDefault().post(loginSession);
        Toast.show(getActivity(), 2131886462);
    }

    private static void clearCache() {
        Observable.create(new Observable.OnSubscribe<Void>() {
            /* class com.coolapk.market.view.settings.AdvancedSettingsFragment.AnonymousClass3 */

            public void call(Subscriber<? super Void> subscriber) {
                try {
                    AppHolder.getContextImageLoader().clearDiskCache(AppHolder.getApplication());
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        }).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.settings.AdvancedSettingsFragment.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                Toast.show(AppHolder.getApplication(), 2131886492);
            }
        }).subscribe((Subscriber) new EmptySubscriber<Void>() {
            /* class com.coolapk.market.view.settings.AdvancedSettingsFragment.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onCompleted() {
                super.onCompleted();
                Toast.show(AppHolder.getApplication(), 2131886491);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 233 && i2 == -1) {
            String stringExtra = intent.getStringExtra("directory");
            File file = new File(stringExtra);
            if (file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
                AppHolder.getAppSetting().setDownloadDir(stringExtra);
                findPrefByKey("download_dir").setSummary(stringExtra);
            }
        }
    }

    private void clearAll() {
        ActionManager.startApplicationDetailsActivity(getActivity(), getActivity().getPackageName());
    }
}
