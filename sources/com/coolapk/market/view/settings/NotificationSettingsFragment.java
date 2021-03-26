package com.coolapk.market.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RomUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.widget.preference.CheckBoxPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/settings/NotificationSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "onDestroy", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NotificationSettingsFragment.kt */
public final class NotificationSettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148237;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        CheckBoxPreference checkBoxPreference;
        super.initPreferences(z);
        DataManager.getInstance().registerPreferenceChangeListener(this);
        if ((RomUtils.isEmui() || RomUtils.isMIUI()) && (checkBoxPreference = (CheckBoxPreference) findPreference("tpns_keep_alive")) != null) {
            Intrinsics.checkNotNullExpressionValue(checkBoxPreference, "it");
            checkBoxPreference.setVisible(false);
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
        return super.onPreferenceTreeClick(preference);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(str, "key");
        switch (str.hashCode()) {
            case -1887959918:
                if (!str.equals("push_service_enabled")) {
                    return;
                }
                break;
            case -1714838396:
                if (!str.equals("floating_notification")) {
                    return;
                }
                break;
            case -1485694789:
                if (!str.equals("notification_sound")) {
                    return;
                }
                break;
            case -901830380:
                if (!str.equals("show_installed_notification_enabled")) {
                    return;
                }
                break;
            case 475362641:
                if (!str.equals("tpns_keep_alive")) {
                    return;
                }
                break;
            case 649759259:
                if (!str.equals("notification_vibrate")) {
                    return;
                }
                break;
            case 867080242:
                if (!str.equals("show_upgrade_notification_enabled")) {
                    return;
                }
                break;
            case 1442825394:
                if (!str.equals("show_notice_notification_enabled")) {
                    return;
                }
                break;
            default:
                return;
        }
        SettingSynchronized.INSTANCE.uploadSetting(str, 0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/NotificationSettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/NotificationSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NotificationSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            NotificationSettingsFragment notificationSettingsFragment = new NotificationSettingsFragment();
            notificationSettingsFragment.setArguments(bundle);
            return notificationSettingsFragment;
        }
    }
}
