package com.coolapk.market.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.widget.AppMainModelDialog;
import java.text.DecimalFormat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/settings/UISettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "getPreferencesXmlRes", "", "initNightTimeSummary", "", "initPreferences", "init", "", "onDestroy", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setFollowSystemNightModeUI", "setLanguageInfo", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UISettingsFragment.kt */
public final class UISettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148248;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewExtents2Kt.tryListenWindowsInset(view, new UISettingsFragment$onViewCreated$1(this));
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        initNightTimeSummary();
        DataManager.getInstance().registerPreferenceChangeListener(this);
        setLanguageInfo();
        setFollowSystemNightModeUI();
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            Preference findPreference = findPreference("app_main_mode_group");
            if (findPreference != null) {
                getPreferenceScreen().removePreference(findPreference);
            }
            Preference findPreference2 = findPreference("upgrade_app_card_group");
            if (findPreference2 != null) {
                getPreferenceScreen().removePreference(findPreference2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -2120780302:
                    if (key.equals("auto_night_mode_time")) {
                        NightThemeDialog newInstance = NightThemeDialog.newInstance();
                        FragmentManager childFragmentManager = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        newInstance.show(childFragmentManager, (String) null);
                        return true;
                    }
                    break;
                case 266738532:
                    if (key.equals("set_night_mode_to_pure_black")) {
                        if (AppHolder.getAppTheme().isDarkTheme()) {
                            boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("set_night_mode_to_pure_black");
                            String currentThemeId = AppHolder.getAppTheme().getCurrentThemeId();
                            if (booleanPref && (!Intrinsics.areEqual(currentThemeId, "amoled"))) {
                                AppTheme appTheme = AppHolder.getAppTheme();
                                FragmentActivity activity = getActivity();
                                Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                                appTheme.setThemeId((AppCompatActivity) activity, "amoled", false);
                                ThemeUtils.startThemeChangeAlphaAnimation(getActivity());
                                StatisticHelper.Companion.getInstance().recordThemeEvent("amoled");
                                break;
                            }
                        } else {
                            return true;
                        }
                    }
                    break;
                case 493438611:
                    if (key.equals("app_post_button")) {
                        ActionManager.startPostButtonSettingActivity(getActivity());
                        return true;
                    }
                    break;
                case 1746004441:
                    if (key.equals("theme_settings")) {
                        ActionManager.startThemePickerActivity(getActivity());
                        return true;
                    }
                    break;
                case 2041812939:
                    if (key.equals("app_main_mode")) {
                        AppMainModelDialog newInstance2 = AppMainModelDialog.Companion.newInstance();
                        FragmentManager childFragmentManager2 = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                        newInstance2.show(childFragmentManager2, (String) null);
                        return true;
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(str, "key");
        switch (str.hashCode()) {
            case -2127252848:
                if (str.equals("disable_show_center_upgrade_app_card")) {
                    boolean z = sharedPreferences.getBoolean(str, false);
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getPreferencesEditor().putBoolean("disable_show_center_upgrade_app_card", z).apply();
                    EventBus.getDefault().post(new SettingEvent(str));
                    SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                    return;
                }
                return;
            case -1749622827:
                if (!str.equals("auto_night_mode_time_start")) {
                    return;
                }
                initNightTimeSummary();
                return;
            case -969993349:
                if (!str.equals("auto_hide_bottom_navigation")) {
                    return;
                }
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                return;
            case 755630931:
                if (!str.equals("transparent_status_bar")) {
                    return;
                }
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                return;
            case 830390255:
                if (str.equals("follow_system_day_night_mode")) {
                    setFollowSystemNightModeUI();
                    return;
                }
                return;
            case 1549001998:
                if (!str.equals("auto_night_mode_time_end")) {
                    return;
                }
                initNightTimeSummary();
                return;
            case 1819209676:
                if (!str.equals("navigation_bar_color")) {
                    return;
                }
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                return;
            default:
                return;
        }
    }

    private final void initNightTimeSummary() {
        NightModeHelper instance = NightModeHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "NightModeHelper.getInstance()");
        int endTime = instance.getEndTime();
        NightModeHelper instance2 = NightModeHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "NightModeHelper.getInstance()");
        int startTime = instance2.getStartTime();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String string = requireActivity().getString(2131886526, new Object[]{String.valueOf(startTime / 60), decimalFormat.format((long) (startTime % 60)), String.valueOf(endTime / 60), decimalFormat.format((long) (endTime % 60))});
        Intrinsics.checkNotNullExpressionValue(string, "requireActivity().getStr…(endTime % 60).toLong()))");
        Preference findPreference = findPreference("auto_night_mode_time");
        if (findPreference != null) {
            findPreference.setSummary(string);
        }
    }

    private final void setLanguageInfo() {
        ListPreference listPreference = (ListPreference) findPreference("language");
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener(new UISettingsFragment$setLanguageInfo$1(this));
        }
    }

    private final void setFollowSystemNightModeUI() {
        Preference findPreference = findPreference("follow_system_day_night_mode");
        if (findPreference != null) {
            Intrinsics.checkNotNullExpressionValue(findPreference, "findPreference<Preferenc…                ?: return");
            if (NightModeHelper.isThisRomSupportSystemTheme()) {
                boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("follow_system_day_night_mode");
                Preference findPreference2 = findPreference("auto_switch_night_mode");
                if (findPreference2 != null) {
                    Intrinsics.checkNotNullExpressionValue(findPreference2, "findPreference<Preferenc…                ?: return");
                    findPreference2.setEnabled(!booleanPref);
                    Preference findPreference3 = findPreference("auto_night_mode_time");
                    if (findPreference3 != null) {
                        Intrinsics.checkNotNullExpressionValue(findPreference3, "findPreference<Preferenc…                ?: return");
                        findPreference3.setEnabled(!booleanPref);
                        return;
                    }
                    return;
                }
                return;
            }
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.removePreference(findPreference);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/UISettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/UISettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UISettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UISettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            UISettingsFragment uISettingsFragment = new UISettingsFragment();
            uISettingsFragment.setArguments(bundle);
            return uISettingsFragment;
        }
    }
}
