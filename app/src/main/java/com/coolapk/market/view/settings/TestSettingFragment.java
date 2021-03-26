package com.coolapk.market.view.settings;

import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.base.BasePreferenceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/settings/TestSettingFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "()V", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TestSettingFragment.kt */
public final class TestSettingFragment extends BasePreferenceFragment {
    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148247;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            Preference findPreference = findPreference("view_download_log");
            if (findPreference != null) {
                getPreferenceScreen().removePreference(findPreference);
            }
            Preference findPreference2 = findPreference("view_install_log");
            if (findPreference2 != null) {
                getPreferenceScreen().removePreference(findPreference2);
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1840225538:
                    if (key.equals("debug_test")) {
                        ActionManager.startDebugTestSettingsActivity(getActivity());
                        return true;
                    }
                    break;
                case -1223459157:
                    if (key.equals("view_network_state_log")) {
                        ActionManager.startNetworkStateLogActivity(getActivity());
                        return true;
                    }
                    break;
                case -1204878224:
                    if (key.equals("local_log")) {
                        ActionManager.startLogFileActivity(getActivity());
                        return true;
                    }
                    break;
                case -376866201:
                    if (key.equals("view_download_log")) {
                        ActionManager.startDownloadLogActivity(getActivity());
                        return true;
                    }
                    break;
                case 179513861:
                    if (key.equals("http_info")) {
                        ActionManager.startHttpInfoActivity(getActivity());
                        return true;
                    }
                    break;
                case 630178130:
                    if (key.equals("cdn_diagnosis_2")) {
                        ActionManager.startWebViewActivity(getActivity(), "http://pubstatic.upyun.com/cdn-stream-test.html");
                        return true;
                    }
                    break;
                case 653168991:
                    if (key.equals("cdn_diagnosis")) {
                        ActionManager.startWebViewActivity(getActivity(), "http://pubstatic.b0.upaiyun.com/cdn-health.html");
                        return true;
                    }
                    break;
                case 710441990:
                    if (key.equals("view_install_log")) {
                        ActionManager.startInstallLogActivity(getActivity());
                        return true;
                    }
                    break;
                case 1196956677:
                    if (key.equals("view_api_log")) {
                        ActionManager.startApiLogActivity(getActivity());
                        return true;
                    }
                    break;
                case 1596628512:
                    if (key.equals("network_diagnosis")) {
                        ActionManager.startNetworkDiagnosisActivity(getActivity());
                        return true;
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }
}
