package com.coolapk.market.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/settings/FlowSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "listPreference", "Landroidx/preference/Preference;", "summary", "", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "onDestroy", "onPreferenceTreeClick", "preference", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "parserSummaryText", "value", "setPhotoViewOptions", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FlowSettingsFragment.kt */
public final class FlowSettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);
    private Preference listPreference;
    private String summary = "网络自适应";

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148231;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/FlowSettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/FlowSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FlowSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FlowSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            FlowSettingsFragment flowSettingsFragment = new FlowSettingsFragment();
            flowSettingsFragment.setArguments(bundle);
            return flowSettingsFragment;
        }
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        setPhotoViewOptions();
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        String key = preference != null ? preference.getKey() : null;
        if (key != null) {
            int hashCode = key.hashCode();
            if (hashCode != -388415503) {
                if (hashCode == 1477516177 && key.equals("auto_disable_image_load")) {
                    Preference findPreference = findPreference("always_load_app_icon");
                    boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("auto_disable_image_load");
                    if (findPreference != null) {
                        findPreference.setEnabled(booleanPref);
                    }
                }
            } else if (key.equals("photo_view_options")) {
                ImageModeDialog newInstance = ImageModeDialog.Companion.newInstance();
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    private final void setPhotoViewOptions() {
        String preferencesString = DataManager.getInstance().getPreferencesString("photo_view_options", "AUTO");
        this.listPreference = findPreference("photo_view_options");
        Intrinsics.checkNotNullExpressionValue(preferencesString, "loadSummary");
        parserSummaryText(preferencesString);
        Preference preference = this.listPreference;
        if (preference != null) {
            preference.setSummary(this.summary);
        }
    }

    private final void parserSummaryText(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1986416409) {
            if (hashCode != -1843176421) {
                if (hashCode == 2020783 && str.equals("AUTO")) {
                    this.summary = "网络自适应";
                }
            } else if (str.equals("SOURCE")) {
                this.summary = "默认原图";
            }
        } else if (str.equals("NORMAL")) {
            this.summary = "普清";
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -388415503) {
                if (hashCode != 1477516177) {
                    if (hashCode != 1557288160 || !str.equals("always_load_app_icon")) {
                        return;
                    }
                } else if (!str.equals("auto_disable_image_load")) {
                    return;
                }
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
            } else if (str.equals("photo_view_options")) {
                String preferencesString = DataManager.getInstance().getPreferencesString(str, "AUTO");
                Intrinsics.checkNotNullExpressionValue(preferencesString, "loadValue");
                parserSummaryText(preferencesString);
                Preference preference = this.listPreference;
                if (preference != null) {
                    preference.setSummary(this.summary);
                }
            }
        }
    }
}
