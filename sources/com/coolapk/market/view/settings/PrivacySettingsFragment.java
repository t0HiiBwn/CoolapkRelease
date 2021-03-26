package com.coolapk.market.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/settings/PrivacySettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "onDestroy", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "synchronizeSettings", "updateGoodsClipboardStatus", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PrivacySettingsFragment.kt */
public final class PrivacySettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148240;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/PrivacySettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/BetaSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PrivacySettingsFragment.kt */
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

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        updateGoodsClipboardStatus();
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null && str.hashCode() == 167226925 && str.equals("read_clipboard")) {
            updateGoodsClipboardStatus();
        }
        if (str == null) {
            str = "";
        }
        synchronizeSettings(str);
    }

    private final void updateGoodsClipboardStatus() {
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("read_clipboard");
        Preference findPreference = findPreference("share_goods_dialog");
        if (findPreference != null) {
            findPreference.setEnabled(booleanPref);
        }
    }

    private final void synchronizeSettings(String str) {
        switch (str.hashCode()) {
            case -1475562831:
                if (!str.equals("share_goods_dialog")) {
                    return;
                }
                break;
            case -1347074618:
                if (!str.equals("user_space_show_recent_like")) {
                    return;
                }
                break;
            case -901794566:
                if (!str.equals("record_hit_history")) {
                    return;
                }
                break;
            case 167226925:
                if (!str.equals("read_clipboard")) {
                    return;
                }
                break;
            case 1961557086:
                if (!str.equals("record_recent_history")) {
                    return;
                }
                break;
            default:
                return;
        }
        SettingSynchronized.INSTANCE.uploadSetting(str, 0);
    }
}
