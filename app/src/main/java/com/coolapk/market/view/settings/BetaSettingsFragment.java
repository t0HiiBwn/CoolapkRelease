package com.coolapk.market.view.settings;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/settings/BetaSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "onDestroy", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onResume", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BetaSettingsFragment.kt */
public final class BetaSettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148226;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        long preferencesLong = DataManager.getInstance().getPreferencesLong("last_weekly_no_ad_splash_time", 0);
        if (preferencesLong < DateUtils.getWeekAgoTime() || preferencesLong >= System.currentTimeMillis()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("weekly_no_ad_splash", false).apply();
        }
        super.initPreferences(z);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean isAdmin = loginSession.isAdmin();
        Preference findPreference = findPreference("statistic_toast");
        if (findPreference != null && !isAdmin) {
            getPreferenceScreen().removePreference(findPreference);
        }
        Preference findPreference2 = findPreference("clear_headline_history");
        if (findPreference2 != null && !isAdmin) {
            getPreferenceScreen().removePreference(findPreference2);
        }
        Preference findPreference3 = findPreference("developer_api");
        if (findPreference3 != null) {
            getPreferenceScreen().removePreference(findPreference3);
        }
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            Preference findPreference4 = findPreference("show_hide_apps");
            if (findPreference4 != null) {
                getPreferenceScreen().removePreference(findPreference4);
            }
            Preference findPreference5 = findPreference("check_beta_version_enabled");
            if (findPreference5 != null) {
                getPreferenceScreen().removePreference(findPreference5);
            }
        }
        Intrinsics.areEqual(AppHolder.getAppMetadata().getAppModeFromMeta(), "community");
        Preference findPreference6 = findPreference("app_mode");
        if (findPreference6 != null) {
            getPreferenceScreen().removePreference(findPreference6);
        }
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        long preferencesLong = DataManager.getInstance().getPreferencesLong("last_weekly_no_ad_splash_time", 0);
        if (preferencesLong < DateUtils.getWeekAgoTime() || preferencesLong >= System.currentTimeMillis()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("weekly_no_ad_splash", false).apply();
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPrefByKey("weekly_no_ad_splash");
            Intrinsics.checkNotNullExpressionValue(checkBoxPreference, "checkBoxPreference");
            if (checkBoxPreference.isChecked()) {
                checkBoxPreference.setChecked(false);
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -2133887781:
                    if (key.equals("clear_headline_history")) {
                        DataManager instance = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                        LoginSession loginSession = instance.getLoginSession();
                        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                        if (loginSession.isAdmin()) {
                            ConfirmDialog newInstance = ConfirmDialog.newInstance("", "尊贵的管理员阁下，您确定要清除您的头条记录缓存吗？此操作会重置您的头条记录，会让你刷到之前看过的头条！", "确定", "取消");
                            newInstance.setOnOkRunnable(new BetaSettingsFragment$onPreferenceTreeClick$2(this));
                            FragmentActivity requireActivity = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                            newInstance.show(supportFragmentManager, (String) null);
                        }
                        return true;
                    }
                    break;
                case -1757265931:
                    if (key.equals("limited_background_enabled")) {
                        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("limited_background_enabled");
                        FragmentActivity requireActivity2 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                        String packageName = requireActivity2.getPackageName();
                        StringBuilder sb = new StringBuilder();
                        FragmentActivity requireActivity3 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
                        sb.append(requireActivity3.getPackageName());
                        sb.append(".AdvancedSettingsActivity");
                        ComponentName componentName = new ComponentName(packageName, sb.toString());
                        if (booleanPref) {
                            FragmentActivity requireActivity4 = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity()");
                            requireActivity4.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
                            requireActivity().setResult(-1);
                        } else {
                            FragmentActivity requireActivity5 = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity5, "requireActivity()");
                            requireActivity5.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                            requireActivity().setResult(0);
                        }
                        return true;
                    }
                    break;
                case 577752067:
                    if (key.equals("weekly_no_ad_splash")) {
                        DataManager instance2 = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                        LoginSession loginSession2 = instance2.getLoginSession();
                        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                        if (loginSession2.isLogin()) {
                            long currentTimeMillis = AppHolder.getAppSetting().getBooleanPref("weekly_no_ad_splash") ? System.currentTimeMillis() : 0;
                            DataManager instance3 = DataManager.getInstance();
                            Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                            instance3.getPreferencesEditor().putLong("last_weekly_no_ad_splash_time", currentTimeMillis).apply();
                        } else {
                            ActionManager.startLoginActivity(getActivity());
                        }
                        return true;
                    }
                    break;
                case 1167631617:
                    if (key.equals("app_mode")) {
                        String preferencesString = DataManager.getInstance().getPreferencesString("app_mode", null);
                        if (preferencesString != null) {
                            AppHolder.getAppMetadata().changeAppMode(preferencesString);
                        }
                        return true;
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/BetaSettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/BetaSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BetaSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BetaSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            BetaSettingsFragment betaSettingsFragment = new BetaSettingsFragment();
            betaSettingsFragment.setArguments(bundle);
            return betaSettingsFragment;
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2133887781:
                    if (!str.equals("clear_headline_history")) {
                        return;
                    }
                    break;
                case -1757265931:
                    if (!str.equals("limited_background_enabled")) {
                        return;
                    }
                    break;
                case -1515152347:
                    if (!str.equals("developer_api")) {
                        return;
                    }
                    break;
                case -1453740702:
                    if (!str.equals("check_beta_version_enabled")) {
                        return;
                    }
                    break;
                case -1442637777:
                    if (!str.equals("use_internal_webview")) {
                        return;
                    }
                    break;
                case -1288298131:
                    if (!str.equals("auto_load_video_when_wifi")) {
                        return;
                    }
                    break;
                case -1035166579:
                    if (!str.equals("show_hide_apps")) {
                        return;
                    }
                    break;
                case 1226389112:
                    if (!str.equals("statistic_toast")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            SettingSynchronized.INSTANCE.uploadSetting(str, 0);
        }
    }
}
